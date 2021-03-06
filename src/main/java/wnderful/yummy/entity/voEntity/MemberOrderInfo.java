package wnderful.yummy.entity.voEntity;

import com.alibaba.fastjson.JSON;
import wnderful.yummy.entity.entityInModule.OrderTime;

public class MemberOrderInfo {
    private String rid;
    private String restaurantName;
    private String restaurantPicture;
    private String restaurantPhone;
    private String oid;
    private String time;
    private double price;
    private String state;

    public MemberOrderInfo(String rid, String restaurantName,String restaurantPicture,String restaurantPhone, String oid, String time, double price,String state) {
        this.rid = rid;
        this.restaurantName = restaurantName;
        this.restaurantPicture = restaurantPicture;
        this.restaurantPhone = restaurantPhone;
        this.oid = oid;
        this.price = price;
        this.state = state;
        OrderTime orderTime = JSON.parseObject(time,OrderTime.class);
        this.time = orderTime.getYear()+"年"+orderTime.getMouth()+"月"+orderTime.getDay()+"日"+orderTime.getHour()+"时"+orderTime.getMinute()+"分";
    }

    public MemberOrderInfo() {
    }

    public String getRid() {
        return rid;
    }

    public String getOid() {
        return oid;
    }

    public String getTime() {
        return time;
    }

    public double getPrice() {
        return price;
    }

    public String getRestaurantPicture() {
        return restaurantPicture;
    }

    public String getRestaurantPhone() {
        return restaurantPhone;
    }

    public String getState() {
        return state;
    }

    public String getRestaurantName() {
        return restaurantName;
    }
}
