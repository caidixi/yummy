package wnderful.yummy.dataService;

import wnderful.yummy.dao.module.RestaurantType;

import java.util.List;

public interface RestaurantTypeDataService {
    RestaurantType getFastFoodType();

    RestaurantType getSnackType();

    RestaurantType getWesternType();

    RestaurantType getRegionalType();

    RestaurantType getNoodleType();

    RestaurantType getByName(String name);

    List<RestaurantType> getAllType();
}
