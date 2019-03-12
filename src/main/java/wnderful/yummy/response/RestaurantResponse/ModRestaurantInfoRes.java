package wnderful.yummy.response.RestaurantResponse;

import wnderful.yummy.response.Response;
import wnderful.yummy.responseCode.restaurantResponseCode.ModRestaurantInfoCode;

public class ModRestaurantInfoRes extends Response {

    public ModRestaurantInfoRes(ModRestaurantInfoCode code) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
    }
}
