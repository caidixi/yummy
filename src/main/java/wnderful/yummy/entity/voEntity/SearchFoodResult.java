package wnderful.yummy.entity.voEntity;

public class SearchFoodResult {
    private String name;
    private String rid;
    private double point;
    private String picture;
    private double startingPrice;
    private double deliveryPrice;
    private int probablyTime;

    private String fid;
    private String type;
    private double packagePrice;
    private String foodName;
    private String foodPicture;
    private double price;
    private String announcement;
    private int quantity;

    public SearchFoodResult(String name, String rid, double point, String picture, double startingPrice, double deliveryPrice, int probablyTime, String fid, String type, double packagePrice, String foodName, String foodPicture, double price, String announcement, int quantity) {
        this.name = name;
        this.rid = rid;
        this.point = point;
        this.picture = picture;
        this.startingPrice = startingPrice;
        this.deliveryPrice = deliveryPrice;
        this.probablyTime = probablyTime;
        this.fid = fid;
        this.type = type;
        this.packagePrice = packagePrice;
        this.foodName = foodName;
        this.foodPicture = foodPicture;
        this.price = price;
        this.announcement = announcement;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getRid() {
        return rid;
    }

    public double getPoint() {
        return point;
    }

    public String getPicture() {
        return picture;
    }

    public double getStartingPrice() {
        return startingPrice;
    }

    public double getDeliveryPrice() {
        return deliveryPrice;
    }

    public int getProbablyTime() {
        return probablyTime;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getFoodPicture() {
        return foodPicture;
    }

    public double getPrice() {
        return price;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getFid() {
        return fid;
    }

    public String getType() {
        return type;
    }

    public double getPackagePrice() {
        return packagePrice;
    }
}
