package wnderful.yummy.entity.voEntity;

public class FoodInfo {
    private String name;
    private double price;
    private int number;


    public FoodInfo() {
    }

    public FoodInfo(String name, double price , int number) {
        this.name = name;
        this.price = price;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getNumber() {
        return number;
    }

}
