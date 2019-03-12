package wnderful.yummy.vo.restaurantVo;

import wnderful.yummy.entity.voEntity.RestOrderInfo;

public class RestGetOrderListVo {
    private RestOrderInfo[] orders;

    public RestGetOrderListVo(RestOrderInfo[] orders) {
        this.orders = orders;
    }

    public RestGetOrderListVo() {
        orders = new RestOrderInfo[1];
        orders[0] = new RestOrderInfo();
    }

    public RestOrderInfo[] getOrders() {
        return orders;
    }
}
