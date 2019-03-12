package wnderful.yummy.response.RestaurantResponse;

import wnderful.yummy.response.Response;
import wnderful.yummy.responseCode.restaurantResponseCode.NewDiscountCode;

public class NewDiscountRes extends Response {

    public NewDiscountRes(NewDiscountCode code) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
    }
}
