package wnderful.yummy.vo.memberVo;

import wnderful.yummy.entity.voEntity.MemberStatisticByOrder;

public class MemDetailByMoneyVo {
    private String uid;
    private String name;
    private double totalPrice;
    private double averagePrice;
    private MemberStatisticByOrder[] orders;

    public MemDetailByMoneyVo() {
        this.orders = new MemberStatisticByOrder[1];
        orders[0] = new MemberStatisticByOrder();
    }

    public MemDetailByMoneyVo(String uid, String name, double totalPrice, double averagePrice, MemberStatisticByOrder[] orders) {
        this.uid = uid;
        this.name = name;
        this.totalPrice = totalPrice;
        this.averagePrice = averagePrice;
        this.orders = orders;
    }

    public String getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getAveragePrice() {
        return averagePrice;
    }

    public MemberStatisticByOrder[] getOrders() {
        return orders;
    }
}
