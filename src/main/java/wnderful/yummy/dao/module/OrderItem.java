package wnderful.yummy.dao.module;

import javax.persistence.*;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue
    private Long itemId;

    @Column(nullable = false,columnDefinition = "varchar(255) character set utf8")
    private String foodName;

    @Column(nullable = false)
    private int number;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private double packagePrice;

    @Column(nullable = false)
    private double discount;

    @Column(nullable = false)
    private int discountLimit;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name = "food_fid")
    private Food food;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name = "order_oid")
    private Order order;

    public OrderItem(String foodName, int number, double price, double packagePrice, double discount, int discountLimit, Food food, Order order) {
        this.foodName = foodName;
        this.number = number;
        this.price = price;
        this.packagePrice = packagePrice;
        this.discount = discount;
        this.discountLimit = discountLimit;
        this.food = food;
        this.order = order;
    }

    public OrderItem() {
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

    public double getDiscount() {
        return discount;
    }

    public int getDiscountLimit() {
        return discountLimit;
    }

    public Food getFood() {
        return food;
    }

    public Order getOrder() {
        return order;
    }
}
