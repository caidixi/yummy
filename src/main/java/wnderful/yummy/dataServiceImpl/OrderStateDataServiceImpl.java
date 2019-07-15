package wnderful.yummy.dataServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wnderful.yummy.dao.module.OrderState;
import wnderful.yummy.dao.repository.OrderStateRepository;
import wnderful.yummy.dataService.OrderStateDataService;
import wnderful.yummy.entity.entityInModule.OrderStateName;

@Service
public class OrderStateDataServiceImpl implements OrderStateDataService {
    private OrderStateRepository repository;

    @Autowired
    public OrderStateDataServiceImpl(OrderStateRepository repository) {
        this.repository = repository;
    }

    @Override
    public OrderState getUnpaidOrderState() {
        return repository.findByName(OrderStateName.UNPAID.getStateName());
    }

    @Override
    public OrderState getCancelOrderState() {
        return repository.findByName(OrderStateName.CANCEL.getStateName());
    }

    @Override
    public OrderState getPaidOrderState() {
        return repository.findByName(OrderStateName.PAID.getStateName());
    }

    @Override
    public OrderState getDoneOrderState() {
        return repository.findByName(OrderStateName.DONE.getStateName());
    }

    @Override
    public OrderState getAssessedOrderState() {
        return repository.findByName(OrderStateName.ASSESSED.getStateName());
    }
}
