package wnderful.yummy.entity.voEntity;

public class FoodDetail {
    private String name;
    private String fid;
    private String type;
    private String announcement;
    private String picture;
    private double price;
    private double packagePrice;
    private int quantity;

    public FoodDetail(String name, String fid, String type, String announcement, String picture, double price, double packagePrice, int quantity) {
        this.name = name;
        this.fid = fid;
        this.type = type;
        this.announcement = announcement;
        this.picture = picture;
        this.price = price;
        this.packagePrice = packagePrice;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getFid() {
        return fid;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public String getPicture() {
        return picture;
    }

    public double getPrice() {
        return price;
    }

    public double getPackagePrice() {
        return packagePrice;
    }

    public String getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }
}
