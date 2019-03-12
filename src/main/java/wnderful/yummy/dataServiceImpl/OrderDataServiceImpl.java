package wnderful.yummy.dataServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wnderful.yummy.dao.module.*;
import wnderful.yummy.dao.repository.*;
import wnderful.yummy.dataService.OrderDataService;
import wnderful.yummy.entity.FoodOrder;
import wnderful.yummy.entity.entityInModule.OrderStateName;
import wnderful.yummy.entity.voEntity.*;
import wnderful.yummy.util.PriceHelper;
import wnderful.yummy.util.TimeHelper;
import wnderful.yummy.vo.memberVo.*;
import wnderful.yummy.vo.restaurantVo.RestDetailByFoodVo;
import wnderful.yummy.vo.restaurantVo.RestDetailByMemberVo;
import wnderful.yummy.vo.restaurantVo.RestDetailByTimeVo;
import wnderful.yummy.vo.restaurantVo.RestGetOrderListVo;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDataServiceImpl implements OrderDataService {
    private MemberStateDataServiceImpl memberStateDataService;
    private OrderStateDataServiceImpl orderStateDataService;
    private FoodStateDataServiceImpl foodStateDataService;
    private AccountDataServiceImpl accountDataService;
    private RestaurantStateDataServiceImpl restaurantStateDataService;
    private OrderRepository orderRepository;
    private MemberRepository memberRepository;
    private RestaurantRepository restaurantRepository;
    private FoodRepository foodRepository;

    @Autowired
    public OrderDataServiceImpl(OrderRepository orderRepository, OrderStateDataServiceImpl orderStateDataService,
                                FoodStateDataServiceImpl foodStateDataService,AccountDataServiceImpl accountDataService, MemberRepository memberRepository,
                                RestaurantRepository restaurantRepository, FoodRepository foodRepository,
                                RestaurantStateDataServiceImpl restaurantStateDataService,MemberStateDataServiceImpl memberStateDataService) {
        this.orderRepository = orderRepository;
        this.orderStateDataService = orderStateDataService;
        this.foodStateDataService = foodStateDataService;
        this.accountDataService = accountDataService;
        this.restaurantStateDataService = restaurantStateDataService;
        this.memberRepository = memberRepository;
        this.restaurantRepository = restaurantRepository;
        this.foodRepository = foodRepository;
        this.memberStateDataService = memberStateDataService;
    }

    @Override
    public void cancelOrder(String oid) {
        Order order = orderRepository.findByOid(Long.parseLong(oid));
        assert order!=null;
        OrderState orderState = order.getOrderState();
        if(orderState.equals(orderStateDataService.getPaidOrderState())){
            String time= order.getTime();
            if(!TimeHelper.isOvertime(time)){
                String payAccount = order.getPayAccount();
                String restaurantAccount = order.getRestaurant().getAccountId();
                double returnMoney = PriceHelper.getReturnPrice(order.getTotalPrice());
                accountDataService.consume(payAccount,restaurantAccount,-returnMoney);
            }
        }
        List<OrderItem> orderItems = order.getOrderItemList();
        for(OrderItem orderItem:orderItems){
            Food food = orderItem.getFood();
            food.setNumber(food.getNumber()+orderItem.getNumber());
            foodRepository.save(food);
        }
        order.setOrderState(orderStateDataService.getCancelOrderState());
        orderRepository.save(order);
    }

    @Override
    public void confirmOrder(String uid,String oid) {
        Order order = orderRepository.findByOidAndOrderState(Long.parseLong(oid),orderStateDataService.getPaidOrderState());
        Member member = memberRepository.findMemberByUid(Long.parseLong(uid));
        assert order!=null&&member!=null;
        order.setOrderState(orderStateDataService.getDoneOrderState());
        member.addXp((int)order.getTotalPrice());
        orderRepository.save(order);
        memberRepository.save(member);
    }

    @Override
    public boolean orderIsOvertime(String oid) {
        Order order = orderRepository.findByOidAndOrderState(Long.parseLong(oid),orderStateDataService.getUnpaidOrderState());
        assert order!=null;
        String time = order.getTime();
        return TimeHelper.isOvertime(time);
    }

    @Override
    public boolean orderIsUnpaid(String oid) {
        return orderRepository.findByOidAndOrderState(Long.parseLong(oid),orderStateDataService.getUnpaidOrderState())!=null;
    }


    @Override
    public boolean orderIsPaid(String oid) {
        return orderRepository.findByOidAndOrderState(Long.parseLong(oid),orderStateDataService.getPaidOrderState())!=null;
    }

    @Override
    public boolean orderExist(String oid) {
        return orderRepository.findByOid(Long.parseLong(oid))!=null;
    }


    @Override
    public MakeOrderVo makeOrder(String uid, String rid, String address, int numberOfDinner, String remark, FoodOrder[] foodOrders) {
        Restaurant restaurant = restaurantRepository.findRestaurantByRid(rid);
        Member member = memberRepository.findMemberByUid(Long.parseLong(uid));
        assert restaurant!=null&&member!=null;
        Order order = new Order(TimeHelper.getInstanceTime(),address,remark,numberOfDinner,member,restaurant,orderStateDataService.getUnpaidOrderState());
        for(FoodOrder foodOrder:foodOrders){
            Food food = foodRepository.findByFidAndFoodState(Long.parseLong(foodOrder.getFid()),foodStateDataService.getNormalFoodState());
            assert food!=null;
            OrderItem orderItem = new OrderItem(food.getName(),foodOrder.getNumber(),food.getPrice(),food.getPackagePrice(),food.getDiscount(),food.getDiscountLimit(),food,order);
            order.addOrderItem(orderItem);
            food.setNumber(food.getNumber()-orderItem.getNumber());
            foodRepository.save(food);
        }
        orderRepository.save(order);
        Order newOrder = orderRepository.findOidByTime(order.getTime());
        return new MakeOrderVo(newOrder.getOid(),order.getTotalPrice(),order.getPackagePrice(),order.getDeliveryPrice());
    }

    @Override
    public GetOrderDetailVo getOrderDetail(String oid) {
        Order order = orderRepository.findByOid(Long.parseLong(oid));
        List<OrderItem> orderItems = order.getOrderItemList();
        FoodInfo[] FoodInfoList = new FoodInfo[orderItems.size()];
        for(int i = 0;i<orderItems.size();i++){
            OrderItem orderItem = orderItems.get(i);
            FoodInfoList[i] = new FoodInfo(orderItem.getFoodName(),orderItem.getPrice(),orderItem.getDiscount(),orderItem.getNumber(),orderItem.getDiscountLimit());
        }
        return new GetOrderDetailVo(oid,order.getOrderStateName(),order.getTime(),order.getRestaurantRid(),
                order.getTotalPrice(),order.getPackagePrice(),order.getDeliveryPrice(),FoodInfoList);
    }

    @Override
    public MemGetOrderListVo getMemOrderList(String uid) {
        Member member = memberRepository.findMemberByUid(Long.parseLong(uid));
        List<Order> orders = member.getOrderList();
        MemberOrderInfo[] memberOrderInfoList = new MemberOrderInfo[orders.size()];
        for(int i = 0;i < orders.size();i++){
            Order order = orders.get(i);
            if(order.getOrderStateName().equals(OrderStateName.UNPAID.getStateName())&&orderIsOvertime(order.getOid())){
                order.setOrderState(orderStateDataService.getCancelOrderState());
                orderRepository.save(order);
            }
            memberOrderInfoList[i] = new MemberOrderInfo(order.getRestaurantRid(),order.getRestaurantName(),order.getOid(),order.getTime(),order.getTotalPrice(),order.getFirstFoodName(),order.getOrderStateName());
        }
        return new MemGetOrderListVo(memberOrderInfoList);
    }

    @Override
    public RestGetOrderListVo getRestaurantOrderList(String rid) {
        List<Order> orderList = orderRepository.findByOrderState(orderStateDataService.getPaidOrderState());
        RestOrderInfo[] restOrderInfos = new RestOrderInfo[orderList.size()];
        for(int i = 0;i < orderList.size();i++){
            Order order = orderList.get(i);
            List<OrderItem> orderItems = order.getOrderItemList();
            RestFoodOrder[] restFoodOrders = new RestFoodOrder[orderItems.size()];
            for(int j =0;j<orderItems.size();j++){
                OrderItem orderItem = orderItems.get(j);
                restFoodOrders[j] = new RestFoodOrder(orderItem.getFoodFid(),orderItem.getFoodName(),orderItem.getNumber());
            }
            restOrderInfos[i] = new RestOrderInfo(order.getOrderUid(),order.getOid(),order.getTime(),order.getTotalPrice(),order.getOrderStateName(),restFoodOrders);
        }
        return new RestGetOrderListVo(restOrderInfos);
    }

    @Override
    public MemDetailByTimeVo getMemDetailByTime(String uid) {
        Member member = memberRepository.findMemberByUid(Long.parseLong(uid));
        assert member!=null;
        int year = TimeHelper.getYear();
        int mouth = TimeHelper.getMouth();
        MemberStatisticByTime[] memberStatisticByTimes = new MemberStatisticByTime[12];
        for(int i = 0;i < 12;i++){
            if(mouth<=i){
                year = year-1;
                mouth = mouth+12-i;
            }else {
                mouth = mouth-i;
            }
            List<Order> orderList = orderRepository.findByOrderStateAndYearAndMonthAndMember(orderStateDataService.getDoneOrderState(),year,mouth,member);
            memberStatisticByTimes[i] = new MemberStatisticByTime(year,mouth,orderList.size(),getOrdersTotalPrice(orderList),getOrdersAveragePrice(orderList));
        }
        return new MemDetailByTimeVo(uid,member.getName(),memberStatisticByTimes);
    }

    @Override
    public MemDetailByMoneyVo getMemDetailByMoney(String uid) {
        Member member = memberRepository.findMemberByUid(Long.parseLong(uid));
        assert member!=null;
        List<Order> orderList = orderRepository.findByOrderStateAndMember(orderStateDataService.getDoneOrderState(),member);
        MemberStatisticByOrder[] memberStatisticByOrders = new MemberStatisticByOrder[orderList.size()];
        for(int i = 0 ;i < orderList.size();i++){
            Order order = orderList.get(i);
            memberStatisticByOrders[i] = new MemberStatisticByOrder(order.getRestaurantRid(),order.getOid(),order.getTime(),order.getTotalPrice());
        }
        return new MemDetailByMoneyVo(uid,member.getName(),getOrdersTotalPrice(orderList),getOrdersAveragePrice(orderList),memberStatisticByOrders);
    }

    @Override
    public MemDetailByRestaurantVo getMemDetailByRestaurant(String uid) {
        Member member = memberRepository.findMemberByUid(Long.parseLong(uid));
        assert member!=null;
        List<Restaurant> restaurants = restaurantRepository.findByRestaurantState(restaurantStateDataService.getNormalRestState());
        ArrayList<MemberStatisticByRestaurant> memberStatisticByRestaurants = new ArrayList<>();
        for(Restaurant restaurant:restaurants){
            List<Order> orderList = orderRepository.findByOrderStateAndMemberAndRestaurant(orderStateDataService.getDoneOrderState(),member,restaurant);
            if(orderList.size()>0){
                memberStatisticByRestaurants.add(new MemberStatisticByRestaurant(restaurant.getRid(),restaurant.getName(),orderList.size(),getOrdersAveragePrice(orderList)));
            }
        }
        return new MemDetailByRestaurantVo(uid,member.getName(),memberStatisticByRestaurants);
    }

    @Override
    public RestDetailByTimeVo getRestaurantDetailByTime(String rid) {
        Restaurant restaurant = restaurantRepository.findRestaurantByRid(rid);
        assert restaurant!=null;
        int year = TimeHelper.getYear();
        int mouth = TimeHelper.getMouth();
        RestStatisticByTime[] restStatisticByTimes = new RestStatisticByTime[12];
        double totalIncome = 0;
        for(int i = 0;i < 12;i++){
            List<Order> orderList = orderRepository.findByOrderStateAndYearAndMonthAndRestaurant(orderStateDataService.getDoneOrderState(),year,mouth,restaurant);
            restStatisticByTimes[i] = new RestStatisticByTime(year,mouth,orderList.size(),getOrdersTotalPrice(orderList),getOrdersAveragePrice(orderList));
            totalIncome = totalIncome + getOrdersTotalPrice(orderList);
            mouth = mouth-1;
            if(mouth==0){
                year = year-1;
                mouth = mouth+12;
            }
        }
        return new RestDetailByTimeVo(rid,totalIncome,restStatisticByTimes);
    }

    @Override
    public RestDetailByFoodVo getRestaurantDetailByFood(String rid) {
        Restaurant restaurant = restaurantRepository.findRestaurantByRid(rid);
        assert restaurant!=null;
        List<Food> foods = restaurant.getFoodList();
        RestStatisticByFood[] restStatisticByFoods = new RestStatisticByFood[foods.size()];
        for(int i = 0; i < foods.size();i++){
            Food food = foods.get(i);
            List<OrderItem> orderItems =food.getOrderItemList();
            restStatisticByFoods[i] = new RestStatisticByFood(food.getFid(),food.getName(),food.getPrice(),food.getNumber(),getFoodSales(orderItems));
        }
        return new RestDetailByFoodVo(rid,restaurant.getName(),restStatisticByFoods);
    }

    @Override
    public RestDetailByMemberVo getRestaurantDetailByMember(String rid) {
        Restaurant restaurant = restaurantRepository.findRestaurantByRid(rid);
        assert restaurant!=null;
        List<Member> members = memberRepository.findByMemberState(memberStateDataService.getNormalState());
        ArrayList<RestStatisticByMember> restStatisticByMembers = new ArrayList<>();
        for(Member member:members){
            List<Order> orderList = orderRepository.findByOrderStateAndMemberAndRestaurant(orderStateDataService.getDoneOrderState(),member,restaurant);
            if(orderList.size()>0){
                restStatisticByMembers.add(new RestStatisticByMember(member.getUid(),member.getName(),orderList.size(),getOrdersTotalPrice(orderList)));
            }
        }
        return new RestDetailByMemberVo(rid,restaurant.getName(),restStatisticByMembers);
    }

    private double getOrdersTotalPrice(List<Order> orders){
        double totalPrices = 0;
        for(Order order:orders){
            totalPrices = totalPrices + order.getTotalPrice();
        }
        return totalPrices;
    }

    private double getOrdersAveragePrice(List<Order> orders){
        double totalPrices = 0;
        if(orders.size()!=0){
            for(Order order:orders){
                totalPrices = totalPrices + order.getTotalPrice();
            }
            return totalPrices/orders.size();
        }else {
            return totalPrices;
        }
    }

    private int getFoodSales(List<OrderItem> orderItems){
        int result = 0;
        for(OrderItem orderItem:orderItems){
            Order order = orderItem.getOrder();
            assert order!=null;
            if(order.getOrderStateName().equals("done")){
                result +=orderItem.getNumber();
            }
        }
        return result;
    }
}
