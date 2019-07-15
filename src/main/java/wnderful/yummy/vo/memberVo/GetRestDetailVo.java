package wnderful.yummy.vo.memberVo;

import wnderful.yummy.entity.voEntity.FoodDetail;

public class GetRestDetailVo {
    private String name;
    private double point;
    private String picture;
    private double startingPrice;
    private double deliveryPrice;
    private String phone;
    private String address;
    private String announcement;
    private double lng;
    private double lat;
    private FoodDetail[] foods;

    public GetRestDetailVo(String name, double point, String picture, double startingPrice, double deliveryPrice, String phone,
                           String address, String announcement, double lng, double lat, FoodDetail[] foods) {
        this.name = name;
        this.point = point;
        this.picture = picture;
        this.startingPrice = startingPrice;
        this.deliveryPrice = deliveryPrice;
        this.phone = phone;
        this.address = address;
        this.announcement = announcement;
        this.lng = lng;
        this.lat = lat;
        this.foods = foods;
    }

    public String getName() {
        return name;
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

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public double getLng() {
        return lng;
    }

    public double getLat() {
        return lat;
    }

    public FoodDetail[] getFoods() {
        return foods;
    }
}
