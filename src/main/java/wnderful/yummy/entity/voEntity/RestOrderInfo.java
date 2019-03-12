package wnderful.yummy.entity.voEntity;

import com.alibaba.fastjson.JSON;
import wnderful.yummy.entity.entityInModule.OrderTime;

public class RestOrderInfo {
    private String uid;
    private String oid;
    private String time;
    private double price;
    private String state;
    private RestFoodOrder[] foods;

    public RestOrderInfo() {
        foods = new RestFoodOrder[1];
        foods[0] = new RestFoodOrder();
    }

    public RestOrderInfo(String uid, String oid, String time, double price, String state, RestFoodOrder[] foods) {
        this.uid = uid;
        this.oid = oid;
        this.price = price;
        this.state = state;
        this.foods = foods;
        OrderTime orderTime = JSON.parseObject(time,OrderTime.class);
        this.time = orderTime.getYear()+"年"+orderTime.getMouth()+"月"+orderTime.getDay()+"日"+orderTime.getHour()+"时"+orderTime.getMinute()+"分";
    }

    public String getUid() {
        return uid;
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

    public String getState() {
        return state;
    }

    public RestFoodOrder[] getFoods() {
        return foods;
    }
}
