package wnderful.yummy.dataService;

import wnderful.yummy.dao.module.RestaurantState;

public interface RestaurantStateDataService {
    RestaurantState getNormalRestState();

    RestaurantState getExamineRestState();

    RestaurantState getFailRestState();
}
