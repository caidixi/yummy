package wnderful.yummy.entity.voEntity;

public class FoodDetail {
    private String name;
    private String fid;
    private String announcement;
    private String picture;
    private double price;
    private double packagePrice;
    private double discount;
    private int discountLimit;
    private int quality;

    public FoodDetail() {
    }

    public FoodDetail(String name, String fid, String announcement, String picture, double price, double packagePrice, double discount, int discountLimit, int quality) {
        this.name = name;
        this.fid = fid;
        this.announcement = announcement;
        this.picture = picture;
        this.price = price;
        this.packagePrice = packagePrice;
        this.discount = discount;
        this.discountLimit = discountLimit;
        this.quality = quality;
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

    public double getDiscount() {
        return discount;
    }

    public int getDiscountLimit() {
        return discountLimit;
    }

    public int getQuality() {
        return quality;
    }
}
