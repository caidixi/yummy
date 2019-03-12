package wnderful.yummy.entity.voEntity;

import com.alibaba.fastjson.JSON;
import wnderful.yummy.entity.entityInModule.OrderTime;

public class MemberStatisticByOrder {
    private String rid;
    private String oid;
    private String time;
    private double price;

    public MemberStatisticByOrder() {
    }

    public MemberStatisticByOrder(String rid, String oid, String time, double price) {
        this.rid = rid;
        this.oid = oid;
        this.price = price;
        OrderTime orderTime = JSON.parseObject(time,OrderTime.class);
        this.time = orderTime.getYear()+"年"+orderTime.getMouth()+"月"+orderTime.getDay()+"日"+orderTime.getHour()+"时"+orderTime.getMinute()+"分";
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
}
