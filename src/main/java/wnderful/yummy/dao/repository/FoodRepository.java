package wnderful.yummy.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wnderful.yummy.dao.module.Food;
import wnderful.yummy.dao.module.FoodState;
import wnderful.yummy.dao.module.Restaurant;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food,Long> {
    Food findByFidAndFoodStateNot(Long fid,FoodState foodState);

    Food findByFidAndFoodState(Long fid,FoodState foodState);

    List<Food> findByRestaurantAndFoodStateNot(Restaurant restaurant,FoodState foodState);
}
