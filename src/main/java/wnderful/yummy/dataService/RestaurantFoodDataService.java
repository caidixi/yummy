package wnderful.yummy.dataService;

import wnderful.yummy.vo.memberVo.GetRestDetailVo;
import wnderful.yummy.vo.memberVo.SearchFoodVo;
import wnderful.yummy.vo.restaurantVo.RestDetailVo;

public interface RestaurantFoodDataService {

    void newFood(String rid,String foodName, String announcement, double price, double packagePrice, int number, String picture, String type);

    GetRestDetailVo getRestaurantDetailFromMember(String rid);

    RestDetailVo getRestaurantDetailFromRest(String rid);

    SearchFoodVo searchFoodByName(String name,String city,double lng,double lat);
}
