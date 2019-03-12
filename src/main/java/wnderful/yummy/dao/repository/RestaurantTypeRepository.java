package wnderful.yummy.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wnderful.yummy.dao.module.RestaurantType;

public interface RestaurantTypeRepository extends JpaRepository<RestaurantType,Long> {
    RestaurantType findByName(String name);
}
