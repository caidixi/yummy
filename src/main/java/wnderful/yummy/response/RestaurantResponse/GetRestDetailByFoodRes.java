package wnderful.yummy.response.RestaurantResponse;

import wnderful.yummy.response.CommonResponse;
import wnderful.yummy.responseCode.restaurantResponseCode.GetDetailByFoodCode;
import wnderful.yummy.vo.restaurantVo.RestDetailByFoodVo;

public class GetRestDetailByFoodRes extends CommonResponse {

    public GetRestDetailByFoodRes(GetDetailByFoodCode code) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
    }

    public GetRestDetailByFoodRes(GetDetailByFoodCode code, RestDetailByFoodVo vo) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
        this.setBody(vo);
    }
}
