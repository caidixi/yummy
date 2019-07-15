package wnderful.yummy.dao.module;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Food {
    @Id
    private String fid;

    @Column(nullable = false,columnDefinition = "varchar(255) character set utf8mb4")
    private String name;

    @Column(nullable = false)
    private int number;

    @Column(nullable = false,columnDefinition = "varchar(255) character set utf8mb4")
    private String announcement;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private double packagePrice;

    @Column(nullable = false,columnDefinition = "varchar(255) character set utf8mb4")
    private String picture;

    @Column(nullable = false,columnDefinition = "varchar(255) character set utf8mb4")
    private String type;


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

    public Food(String fid,String name, int number, String announcement, double price, double packagePrice, String picture, String type,
                FoodState foodState, Restaurant restaurant) {
        this.fid = fid;
        this.name = name;
        this.number = number;
        this.announcement = announcement;
        this.price = price;
        this.packagePrice = packagePrice;
        this.foodState = foodState;
        this.restaurant = restaurant;
        this.type = type;
        if(picture!=null){
            this.picture = picture;
        }else {
            this.picture = "";
        }
        orderItemList = new ArrayList<>();
    }

    public String getFid() {
       return fid;
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


    public String getType() {
        return type;
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


    public void setFoodState(FoodState foodState) {
        this.foodState = foodState;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }
}
