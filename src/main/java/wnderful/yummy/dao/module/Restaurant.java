package wnderful.yummy.dao.module;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Restaurant {
    @Id
    private String rid;

    @Column(nullable = false,columnDefinition = "varchar(255) character set utf8")
    private String name;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false,columnDefinition = "varchar(255) character set utf8")
    private String address;

    @Column(nullable = false,columnDefinition = "varchar(255) character set utf8")
    private String announcement;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String accountId;

    @Column(nullable = false)
    private double totalDiscount;

    @Column(nullable = false)
    private String fullReduction;

    @Column(nullable = false)
    private String picture;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name = "restaurantType_typeId")
    private RestaurantType restaurantType;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name = "restaurantState_name")
    private RestaurantState restaurantState;

    @OneToMany(mappedBy  = "restaurant",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Order> orderList;

    @OneToMany(mappedBy  = "restaurant",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Food> foodList;

    public Restaurant() {
    }

    public Restaurant(String rid, String name, String email, String phone, String address, String announcement, String password, String accountId, RestaurantType restaurantType, RestaurantState restaurantState) {
        this.rid = rid;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.announcement = announcement;
        this.password = password;
        this.accountId = accountId;
        this.restaurantType = restaurantType;
        this.restaurantState = restaurantState;
        totalDiscount = 1;
        fullReduction = "";
        picture = "";
        orderList = new ArrayList<>();
        foodList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getRid() {
        return rid;
    }

    public RestaurantState getRestaurantState() {
        return restaurantState;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public String getPicture() {
        return picture;
    }

    public String getAddress() {
        return address;
    }

    public RestaurantType getRestaurantType() {
        return restaurantType;
    }

    public double getTotalDiscount() {
        return totalDiscount;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getFullReduction() {
        return fullReduction;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setRestaurantState(RestaurantState restaurantState) {
        this.restaurantState = restaurantState;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }

    public void setRestaurantType(RestaurantType restaurantType) {
        this.restaurantType = restaurantType;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTotalDiscount(double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public void setFullReduction(String fullReduction) {
        this.fullReduction = fullReduction;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
