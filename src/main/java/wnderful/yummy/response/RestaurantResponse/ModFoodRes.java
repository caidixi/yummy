package wnderful.yummy.response.RestaurantResponse;

import wnderful.yummy.response.Response;
import wnderful.yummy.responseCode.restaurantResponseCode.ModFoodCode;

public class ModFoodRes extends Response {

    public ModFoodRes(ModFoodCode code) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
    }
}
