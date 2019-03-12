package wnderful.yummy.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wnderful.yummy.dao.module.RestaurantState;

public interface RestaurantStateRepository extends JpaRepository<RestaurantState,String> {
    RestaurantState findByName(String name);
}
