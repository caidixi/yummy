package wnderful.yummy.vo.memberVo;

import com.alibaba.fastjson.JSON;
import wnderful.yummy.entity.entityInModule.OrderTime;
import wnderful.yummy.entity.voEntity.FoodInfo;

public class GetOrderDetailVo {
    private String oid;
    private String state;
    private String time;
    private String rid;
    private double totalPrice;
    private double packagePrice;
    private double deliveryPrice;
    private FoodInfo[] foods;

    public GetOrderDetailVo(String oid, String state,  String time, String rid, double totalPrice,
                            double packagePrice, double deliveryPrice, FoodInfo[] foods) {
        this.oid = oid;
        this.state = state;
        this.rid = rid;
        this.totalPrice = totalPrice;
        this.packagePrice = packagePrice;
        this.deliveryPrice = deliveryPrice;
        this.foods = foods;
        OrderTime orderTime = JSON.parseObject(time,OrderTime.class);
        this.time = orderTime.getYear()+"年"+orderTime.getMouth()+"月"+orderTime.getDay()+"日"+orderTime.getHour()+"时"+orderTime.getMinute()+"分";
    }

    public GetOrderDetailVo() {
        this.foods = new FoodInfo[1];
        foods[0] = new FoodInfo();
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

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getPackagePrice() {
        return packagePrice;
    }

    public double getDeliveryPrice() {
        return deliveryPrice;
    }

    public FoodInfo[] getFoods() {
        return foods;
    }
}
