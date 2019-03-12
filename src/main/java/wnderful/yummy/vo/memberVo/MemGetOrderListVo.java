package wnderful.yummy.vo.memberVo;

import wnderful.yummy.entity.voEntity.MemberOrderInfo;

public class MemGetOrderListVo {
    private MemberOrderInfo[] orders;

    public MemGetOrderListVo(MemberOrderInfo[] orders) {
        this.orders = orders;
    }

    public MemGetOrderListVo() {
        this.orders = new MemberOrderInfo[1];
        orders[0] = new MemberOrderInfo();
    }

    public MemberOrderInfo[] getOrders() {
        return orders;
    }
}
