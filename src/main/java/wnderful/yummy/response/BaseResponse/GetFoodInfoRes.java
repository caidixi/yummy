package wnderful.yummy.response.BaseResponse;

import wnderful.yummy.entity.voEntity.FoodDetail;
import wnderful.yummy.response.CommonResponse;
import wnderful.yummy.response.Response;
import wnderful.yummy.responseCode.baseResponseCode.GetFoodInfoCode;
import wnderful.yummy.responseCode.baseResponseCode.RestaurantSignUpCode;

public class GetFoodInfoRes extends CommonResponse {

    public GetFoodInfoRes(GetFoodInfoCode code) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
    }

    public GetFoodInfoRes(GetFoodInfoCode code, FoodDetail vo) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
        this.setBody(vo);
    }
}
