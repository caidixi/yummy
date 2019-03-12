package wnderful.yummy.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wnderful.yummy.dao.module.FoodState;

public interface FoodStateRepository extends JpaRepository<FoodState,String> {
    FoodState findByName(String name);
}
