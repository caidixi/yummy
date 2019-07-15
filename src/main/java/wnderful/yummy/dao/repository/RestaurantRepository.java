package wnderful.yummy.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wnderful.yummy.dao.module.Restaurant;
import wnderful.yummy.dao.module.RestaurantState;
import wnderful.yummy.dao.module.RestaurantType;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant,String> {
    Restaurant findRestaurantByRid(String rid);

    Restaurant findRestaurantByEmail(String email);

    Restaurant findRestaurantByName(String name);

    List<Restaurant> findByRestaurantState(RestaurantState restaurantState);

    List<Restaurant> findByRestaurantStateAndCityContainingAndRestaurantType(RestaurantState restaurantState, String city, RestaurantType restaurantType);

    List<Restaurant> findByRestaurantStateAndCityContainingAndNameContaining(RestaurantState restaurantState, String city,String name);
}
