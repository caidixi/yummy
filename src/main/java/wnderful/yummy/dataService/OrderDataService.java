package wnderful.yummy.dataService;

import org.springframework.transaction.annotation.Transactional;
import wnderful.yummy.entity.FoodOrder;
import wnderful.yummy.vo.memberVo.*;
import wnderful.yummy.vo.restaurantVo.RestDetailByFoodVo;
import wnderful.yummy.vo.restaurantVo.RestDetailByMemberVo;
import wnderful.yummy.vo.restaurantVo.RestDetailByTimeVo;
import wnderful.yummy.vo.restaurantVo.RestGetOrderListVo;

public interface OrderDataService {
    void cancelOrder(String oid);

    void confirmOrder(String uid,String oid);

    void evaluateOrder(String oid,int point);

    boolean orderExist(String oid);

    boolean orderIsUnpaid(String oid);

    boolean orderIsOvertime(String oid);

    boolean orderIsPaid(String oid);

    boolean orderIsDone(String oid);

    boolean orderIsFromMember(String oid,String uid);

    @Transactional
    String makeOrder(String uid, String rid, String addressId, int numberOfDinner, String remark,double totalPrice, FoodOrder[] foodOrders);


    MemGetOrderListVo getMemOrderList(String uid);

    GetOrderDetailVo getOrderDetail(String oid);

    MemDetailByTimeVo getMemDetailByTime(String uid);

    MemDetailByMoneyVo getMemDetailByMoney(String uid);

    MemDetailByRestaurantVo getMemDetailByRestaurant(String uid);

    RestGetOrderListVo getRestaurantOrderList(String rid);

    RestDetailByTimeVo getRestaurantDetailByTime(String rid);

    RestDetailByFoodVo getRestaurantDetailByFood(String rid);

    RestDetailByMemberVo getRestaurantDetailByMember(String rid);
}
