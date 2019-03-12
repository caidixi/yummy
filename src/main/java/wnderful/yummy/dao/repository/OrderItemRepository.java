package wnderful.yummy.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wnderful.yummy.dao.module.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
}
