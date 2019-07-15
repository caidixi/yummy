package wnderful.yummy.dataService;

import wnderful.yummy.dao.module.RestaurantType;

import java.util.List;

public interface RestaurantTypeDataService {
    RestaurantType getFastFoodType();

    RestaurantType getSnackType();

    RestaurantType getMainType();

    RestaurantType getSuperMarketType();

    RestaurantType getFruitType();

    RestaurantType getTeaType();

    RestaurantType getByName(String name);

    List<RestaurantType> getAllType();
}
