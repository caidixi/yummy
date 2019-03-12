package wnderful.yummy.dataService;

import wnderful.yummy.dao.module.OrderState;

public interface OrderStateDataService {
    OrderState getUnpaidOrderState();
    OrderState getCancelOrderState();
    OrderState getPaidOrderState();
    OrderState getDoneOrderState();
}
