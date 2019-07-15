package wnderful.yummy.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wnderful.yummy.dao.module.Food;
import wnderful.yummy.dao.module.FoodState;
import wnderful.yummy.dao.module.Restaurant;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food,String> {
    Food findByFid(String fid);

    Food findByFidAndFoodStateNot(String fid,FoodState foodState);

    Food findByFidAndFoodState(String fid,FoodState foodState);

    List<Food> findByRestaurantAndFoodStateNot(Restaurant restaurant,FoodState foodState);

    List<Food> findByRestaurantCityAndNameContaining(String city,String name);
}