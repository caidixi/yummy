package wnderful.yummy.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wnderful.yummy.dao.module.Member;
import wnderful.yummy.dao.module.Order;
import wnderful.yummy.dao.module.OrderState;
import wnderful.yummy.dao.module.Restaurant;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {

    Order findByOidAndOrderState(Long oid, OrderState orderState);

    Order findByOid(Long oid);

    List<Order> findByOrderState(OrderState orderState);

    List<Order> findByMemberOrderByOrderTimeDesc(Member member);

    List<Order> findByOrderStateAndMember(OrderState orderState, Member member);

    List<Order> findByOrderStateAndMemberAndRestaurant(OrderState orderState, Member member,Restaurant restaurant);

    List<Order> findByOrderStateAndYearAndMonthAndMember(OrderState orderState, int year, int mouth, Member member);

    List<Order> findByOrderStateAndYearAndMonthAndRestaurant(OrderState orderState, int year, int mouth, Restaurant restaurant);
}
