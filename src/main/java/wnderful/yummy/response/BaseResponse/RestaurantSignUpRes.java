package wnderful.yummy.response.BaseResponse;

import wnderful.yummy.response.Response;
import wnderful.yummy.responseCode.baseResponseCode.MemberSignUpCode;
import wnderful.yummy.responseCode.baseResponseCode.RestaurantSignUpCode;

public class RestaurantSignUpRes extends Response {

    public RestaurantSignUpRes(RestaurantSignUpCode restaurantSignUpCode) {
        this.setResult(restaurantSignUpCode.getCode());
        this.setOpinion(restaurantSignUpCode.getMessage());
    }
}
