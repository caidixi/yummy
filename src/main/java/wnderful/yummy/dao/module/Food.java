package wnderful.yummy.dao.module;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Food {
    @Id
    @GeneratedValue
    private Long fid;

    @Column(nullable = false,columnDefinition = "varchar(255) character set utf8")
    private String name;

    @Column(nullable = false)
    private int number;

    @Column(nullable = false,columnDefinition = "varchar(255) character set utf8")
    private String announcement;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private double packagePrice;

    @Column(nullable = false,columnDefinition = "varchar(255) character set utf8")
    private String picture;

    @Column(nullable = false)
    private double discount;

    @Column(nullable = false)
    private int discountLimit;

    @OneToMany(mappedBy  = "food",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<OrderItem> orderItemList;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name = "foodState_name")
    private FoodState foodState;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name = "restaurant_rid")
    private Restaurant restaurant;

    public Food() {
    }

    public Food(String name, int number, String announcement, double price, double packagePrice, String picture,
                double discount, int discountLimit, FoodState foodState, Restaurant restaurant) {
        this.name = name;
        this.number = number;
        this.announcement = announcement;
        this.price = price;
        this.packagePrice = packagePrice;
        this.discount = discount;
        this.discountLimit = discountLimit;
        this.foodState = foodState;
        this.restaurant = restaurant;
        if(picture!=null){
            this.picture = picture;
        }else {
            this.picture = "";
        }
        orderItemList = new ArrayList<>();
    }

    public String getFid() {
        if(fid!=null){
            return Long.toString(fid);
    }else {
            return "";
        }
    }

    public String getName() {
        return name;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public double getPrice() {
        return price;
    }

    public double getPackagePrice() {
        return packagePrice;
    }

    public String getPicture() {
        return picture;
    }

    public double getDiscount() {
        return discount;
    }

    public int getDiscountLimit() {
        return discountLimit;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public FoodState getFoodState() {
        return foodState;
    }

    public int getNumber() {
        return number;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPackagePrice(double packagePrice) {
        this.packagePrice = packagePrice;
    }

    public void setPicture(String picture) {
        if(picture!=null){
            this.picture = picture;
        }else {
            this.picture = "";
        }
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setDiscountLimit(int discountLimit) {
        this.discountLimit = discountLimit;
    }

    public void setFoodState(FoodState foodState) {
        this.foodState = foodState;
    }

    public void setName(String name) {
        this.name = name;
    }
}
