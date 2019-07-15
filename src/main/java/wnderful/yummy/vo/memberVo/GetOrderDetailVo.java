package wnderful.yummy.vo.memberVo;

import wnderful.yummy.entity.voEntity.FoodInfo;

public class GetOrderDetailVo {
    private String rid;
    private String restaurantName;
    private String restaurantPicture;
    private String restaurantPhone;

    private String oid;
    private String time;
    private double price;
    private double packagePrice;
    private double deliveryPrice;

    private String state;
    private String remark;
    private int numberOfDinner;
    private String probablyArriveTime;

    private String name;
    private String phone;
    private String location;
    private String detailAddress;
    private FoodInfo[] foods;

    public GetOrderDetailVo(String rid, String restaurantName, String restaurantPicture, String restaurantPhone, String oid,
                            String time, double price, double packagePrice, double deliveryPrice, String state, String remark,int numberOfDinner,
                            String probablyArriveTime, String name, String phone, String location, String detailAddress, FoodInfo[] foods) {
        this.rid = rid;
        this.restaurantName = restaurantName;
        this.restaurantPicture = restaurantPicture;
        this.restaurantPhone = restaurantPhone;
        this.oid = oid;
        this.time = time;
        this.price = price;
        this.packagePrice = packagePrice;
        this.deliveryPrice = deliveryPrice;
        this.state = state;
        this.remark = remark;
        this.numberOfDinner = numberOfDinner;
        this.probablyArriveTime = probablyArriveTime;
        this.name = name;
        this.phone = phone;
        this.location = location;
        this.detailAddress = detailAddress;
        this.foods = foods;
    }

    public String getOid() {
        return oid;
    }

    public String getState() {
        return state;
    }

    public String getTime() {
        return time;
    }

    public String getRid() {
        return rid;
    }

    public double getPackagePrice() {
        return packagePrice;
    }

    public double getDeliveryPrice() {
        return deliveryPrice;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public String getRestaurantPicture() {
        return restaurantPicture;
    }

    public String getRestaurantPhone() {
        return restaurantPhone;
    }

    public double getPrice() {
        return price;
    }

    public String getRemark() {
        return remark;
    }

    public String getProbablyArriveTime() {
        return probablyArriveTime;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getLocation() {
        return location;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public int getNumberOfDinner() {
        return numberOfDinner;
    }

    public FoodInfo[] getFoods() {
        return foods;
    }
}
