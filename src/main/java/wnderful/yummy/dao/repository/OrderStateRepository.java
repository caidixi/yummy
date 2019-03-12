package wnderful.yummy.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wnderful.yummy.dao.module.OrderState;

public interface OrderStateRepository extends JpaRepository<OrderState,String> {
    OrderState findByName(String name);
}
