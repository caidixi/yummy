package wnderful.yummy.dataService;

import wnderful.yummy.vo.memberVo.GetRestDetailVo;
import wnderful.yummy.vo.restaurantVo.RestDetailByFoodVo;
import wnderful.yummy.vo.restaurantVo.RestDetailVo;

public interface RestaurantFoodDataService {

    void newFood(String rid,String foodName, String announcement, double price, double packagePrice, int number, String picture, double discount, int discountLimit);

    GetRestDetailVo getRestaurantDetailFromMember(String rid);

    RestDetailVo getRestaurantDetailFromRest(String rid);
}
