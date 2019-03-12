package wnderful.yummy.response.RestaurantResponse;

import wnderful.yummy.response.Response;
import wnderful.yummy.responseCode.restaurantResponseCode.NewFoodCode;

public class NewFoodRes extends Response {

    public NewFoodRes(NewFoodCode code) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
    }
}
