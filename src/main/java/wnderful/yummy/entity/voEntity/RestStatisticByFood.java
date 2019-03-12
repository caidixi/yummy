package wnderful.yummy.entity.voEntity;

public class RestStatisticByFood {
    private String fid;
    private String name;
    private double price;
    private int quantity;
    private int totalSales;

    public RestStatisticByFood() {
    }

    public RestStatisticByFood(String fid, String name, double price, int quantity, int totalSales) {
        this.fid = fid;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.totalSales = totalSales;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getFid() {
        return fid;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getTotalSales() {
        return totalSales;
    }

}
