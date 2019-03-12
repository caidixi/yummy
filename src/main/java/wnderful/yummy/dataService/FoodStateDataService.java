package wnderful.yummy.dataService;

import wnderful.yummy.dao.module.FoodState;

public interface FoodStateDataService {
    FoodState getNormalFoodState();
    FoodState getEmptyFoodState();
    FoodState getCancelFoodState();
}
