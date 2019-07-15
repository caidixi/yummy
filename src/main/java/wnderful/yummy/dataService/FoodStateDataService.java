package wnderful.yummy.dataService;

import wnderful.yummy.dao.module.FoodState;

public interface FoodStateDataService {

    void initialize();
    FoodState getNormalFoodState();
    FoodState getEmptyFoodState();
    FoodState getCancelFoodState();
}
