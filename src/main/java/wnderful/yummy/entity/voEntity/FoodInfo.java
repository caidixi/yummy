package wnderful.yummy.entity.voEntity;

public class FoodInfo {
    private String name;
    private double price;
    private double discount;
    private int number;
    private int discountLimit;


    public FoodInfo() {
    }

    public FoodInfo(String name, double price, double discount, int number, int discountLimit) {
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.number = number;
        this.discountLimit = discountLimit;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    public int getNumber() {
        return number;
    }

    public int getDiscountLimit() {
        return discountLimit;
    }
}
