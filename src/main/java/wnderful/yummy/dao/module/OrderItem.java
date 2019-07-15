package wnderful.yummy.dao.module;

import javax.persistence.*;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue
    private Long itemId;

    @Column(nullable = false,columnDefinition = "varchar(255) character set utf8mb4")
    private String foodName;

    @Column(nullable = false)
    private int number;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private double packagePrice;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name = "food_fid")
    private Food food;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name = "order_oid")
    private Order order;

    public OrderItem() {
    }

    public OrderItem(String foodName, int number, double price, double packagePrice, Food food, Order order) {
        this.foodName = foodName;
        this.number = number;
        this.price = price;
        this.packagePrice = packagePrice;
        this.food = food;
        this.order = order;
    }

    public Long getItemId() {
        return itemId;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getFoodFid(){
        return food.getFid();
    }

    public int getNumber() {
        return number;
    }

    public double getPrice() {
        return price;
    }

    public double getPackagePrice() {
        return packagePrice;
    }

    public Food getFood() {
        return food;
    }

    public Order getOrder() {
        return order;
    }
}
