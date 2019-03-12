package wnderful.yummy.dao.module;

import com.alibaba.fastjson.JSON;
import wnderful.yummy.entity.entityInModule.OrderTime;
import wnderful.yummy.util.LocationHelper;
import wnderful.yummy.util.PriceHelper;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "foodOrder")
@Entity
public class Order {
    @Id
    @GeneratedValue()
    private Long oid;

    @Column(nullable = false)
    private String time;

    @Column(nullable = false)
    private int year;

    @Column(nullable = false)
    private int month;

    @Column(nullable = false,columnDefinition = "varchar(255) character set utf8")
    private String address;

    @Column(nullable = false,columnDefinition = "varchar(255) character set utf8")
    private String remark;

    @Column(nullable = false)
    private int numberOfDinner;

    @Column(nullable = false)
    private double totalPrice;

    @Column(nullable = false)
    private double packagePrice;

    @Column(nullable = false)
    private double deliveryPrice;

    @Column(nullable = false)
    private double restaurantDiscount;

    @Column(nullable = false)
    private double memberDiscount;

    @Column(nullable = false)
    private String payAccount;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name = "member_uid")
    private Member member;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name = "restaurant_rid")
    private Restaurant restaurant;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name = "orderState_name")
    private OrderState orderState;

    @OneToMany(mappedBy  = "order",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<OrderItem> orderItemList;

    public Order(String time,String address,String remark, int numberOfDinner,  Member member, Restaurant restaurant, OrderState orderState) {
        this.payAccount = "";
        this.time = time;
        this.address = address;
        this.remark = remark;
        this.numberOfDinner = numberOfDinner;
        this.member = member;
        this.restaurant = restaurant;
        this.orderState = orderState;
        orderItemList = new ArrayList<>();

        OrderTime orderTime = JSON.parseObject(time,OrderTime.class);
        this.year = orderTime.getYear();
        this.month = orderTime.getMouth();
        memberDiscount= PriceHelper.getMemberDiscount(member.getLevel());
        restaurantDiscount = restaurant.getTotalDiscount();
        int distance = LocationHelper.getDistance(address,restaurant.getAddress());
        deliveryPrice = PriceHelper.getDeliveryPrice(distance);
        totalPrice += deliveryPrice;
    }

    public Order() {
    }

    public String getTime() {
        return time;
    }

    public String  getOid() {
        if(oid!=null){
            return Long.toString(oid);
        }else {
            return "";
        }
    }

    public String getAddress() {
        return address;
    }

    public String getRemark() {
        return remark;
    }

    public String getFirstFoodName() {
        if(orderItemList.size()>0){
            return orderItemList.get(0).getFoodName();
        }else {
            return "";
        }
    }

    public int getNumberOfDinner() {
        return numberOfDinner;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getPackagePrice() {
        return packagePrice;
    }

    public double getDeliveryPrice() {
        return deliveryPrice;
    }

    public double getRestaurantDiscount() {
        return restaurantDiscount;
    }

    public double getMemberDiscount() {
        return memberDiscount;
    }

    public Member getMember() {
        return member;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public String getRestaurantRid(){
        return restaurant.getRid();
    }

    public String getRestaurantName(){
        return restaurant.getName();
    }

    public String getOrderStateName(){
        return orderState.getName();
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public String getOrderUid(){
        return member.getUid();
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }

    public void addOrderItem(OrderItem orderItem){
        orderItemList.add(orderItem);
        packagePrice += orderItem.getPackagePrice();
        totalPrice += orderItem.getPackagePrice();
        if(orderItem.getNumber()>orderItem.getDiscountLimit()){
            totalPrice += (orderItem.getDiscount()*orderItem.getDiscountLimit()+orderItem.getNumber()-orderItem.getDiscountLimit())*orderItem.getPrice()*memberDiscount*restaurantDiscount;
        }else {
            totalPrice += orderItem.getPrice()*orderItem.getDiscount()*orderItem.getNumber()*memberDiscount*restaurantDiscount;
        }
    }

    public String getPayAccount() {
        return payAccount;
    }

    public void setPayAccount(String payAccount) {
        this.payAccount = payAccount;
    }

    public void setTime(String time) {
        this.time = time;
        OrderTime orderTime = JSON.parseObject(time,OrderTime.class);
        this.year = orderTime.getYear();
        this.month = orderTime.getMouth();
    }
}
