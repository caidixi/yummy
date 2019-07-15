package wnderful.yummy.dataService;

import wnderful.yummy.dao.module.RestaurantState;

public interface RestaurantStateDataService {
    void initialize();

    RestaurantState getNormalRestState();

    RestaurantState getExamineRestState();

    RestaurantState getFailRestState();
}
