package wnderful.yummy.dao.module;

import com.alibaba.fastjson.JSON;
import wnderful.yummy.entity.entityInModule.OrderTime;
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
    private String orderTime;

    @Column(nullable = false)
    private int year;

    @Column(nullable = false)
    private int month;

    @Column(nullable = false,columnDefinition = "varchar(255) character set utf8mb4")
    private String remark;

    @Column(nullable = false)
    private int numberOfDinner;

    @Column(nullable = false)
    private int deliveryTime;

    @Column(nullable = false)
    private double totalPrice;

    @Column(nullable = false)
    private double packagePrice;

    @Column(nullable = false)
    private double deliveryPrice;

    @Column(nullable = false)
    private String payAccount;

    @Column(nullable = false)
    private int evaluatePoint;

    @Column(nullable = false,columnDefinition = "varchar(255) character set utf8mb4")
    private String name;

    @Column(nullable = false,columnDefinition = "varchar(255) character set utf8mb4")
    private String phone;

    @Column(nullable = false,columnDefinition = "varchar(255) character set utf8mb4")
    private String location;

    @Column(nullable = false,columnDefinition = "varchar(255) character set utf8mb4")
    private String detailAddress;

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

    public Order() {
    }

    public Order(OrderTime time, Address  address, String remark, int numberOfDinner, Member member, Restaurant restaurant, int deliveryTime,
                 OrderState orderState) {
        this.payAccount = "";
        this.time = JSON.toJSONString(time);
        this.orderTime = time.getTime();
        this.name = address.getName();
        this.phone = address.getPhone();
        this.location = address.getLocation();
        this.detailAddress = address.getDetailAddress();
        this.remark = remark;
        this.numberOfDinner = numberOfDinner;
        this.deliveryTime = deliveryTime;
        this.member = member;
        this.restaurant = restaurant;
        this.orderState = orderState;
        orderItemList = new ArrayList<>();

        this.year = time.getYear();
        this.month = time.getMouth();
        deliveryPrice = restaurant.getDeliverPrice();
        evaluatePoint = 3;
        totalPrice += deliveryPrice;
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

    public String getRemark() {
        return remark;
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

    public Member getMember() {
        return member;
    }

    public int getEvaluatePoint() {
        return evaluatePoint;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public String getRestaurantRid(){
        return restaurant.getRid();
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

    public String getOrderTime() {
        return orderTime;
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

    public int getDeliveryTime() {
        return deliveryTime;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getLocation() {
        return location;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }

    public void addOrderItem(OrderItem orderItem){
        orderItemList.add(orderItem);
        packagePrice += orderItem.getPackagePrice();
        totalPrice += orderItem.getPackagePrice();
        totalPrice += orderItem.getPrice()*orderItem.getNumber();
    }

    public String getPayAccount() {
        return payAccount;
    }

    public void setPayAccount(String payAccount) {
        this.payAccount = payAccount;
    }

    public void setTime(OrderTime time) {
        this.time = JSON.toJSONString(time);
        this.orderTime = time.getTime();
        this.year = time.getYear();
        this.month = time.getMouth();
    }

    public void setEvaluatePoint(int evaluatePoint) {
        this.evaluatePoint = evaluatePoint;
    }
}
