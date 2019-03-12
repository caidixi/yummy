package wnderful.yummy.response.RestaurantResponse;

import wnderful.yummy.response.Response;
import wnderful.yummy.responseCode.restaurantResponseCode.DeleteFoodCode;

public class DeleteFoodRes extends Response {

    public DeleteFoodRes(DeleteFoodCode code) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
    }
}
