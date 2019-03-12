package wnderful.yummy.dataServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wnderful.yummy.dao.module.Order;
import wnderful.yummy.dao.module.Restaurant;
import wnderful.yummy.dao.repository.OrderRepository;
import wnderful.yummy.dataService.MemberOrderDataService;
import wnderful.yummy.util.TimeHelper;


@Service
public class MemberOrderDataServiceImpl implements MemberOrderDataService {
    private AccountDataServiceImpl accountDataService;
    private OrderRepository orderRepository;
    private OrderStateDataServiceImpl orderStateDataService;

    @Autowired
    public MemberOrderDataServiceImpl(AccountDataServiceImpl accountDataService, OrderRepository orderRepository, OrderStateDataServiceImpl orderStateDataService) {
        this.accountDataService = accountDataService;
        this.orderRepository = orderRepository;
        this.orderStateDataService = orderStateDataService;
    }

    @Override
    public void payOrder(String accountId,  String oid) {
        Order order = orderRepository.findByOidAndOrderState(Long.parseLong(oid),orderStateDataService.getUnpaidOrderState());
        assert order!=null;
        Restaurant restaurant = order.getRestaurant();
        assert  restaurant!=null;
        Double price = order.getTotalPrice();
        accountDataService.consume(accountId,restaurant.getAccountId(),price);
        order.setOrderState(orderStateDataService.getPaidOrderState());
        order.setPayAccount(accountId);
        order.setTime(TimeHelper.getInstanceTime());
        orderRepository.save(order);
    }

    @Override
    public boolean orderCanPay( String oid, String accountId) {
        Order order = orderRepository.findByOidAndOrderState(Long.parseLong(oid),orderStateDataService.getUnpaidOrderState());
        assert order!=null;
        Double price = order.getTotalPrice();
        return accountDataService.checkBalance(accountId,price);
    }
}
