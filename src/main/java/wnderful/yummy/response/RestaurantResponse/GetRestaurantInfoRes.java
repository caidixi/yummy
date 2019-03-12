package wnderful.yummy.response.RestaurantResponse;

import wnderful.yummy.response.CommonResponse;
import wnderful.yummy.responseCode.restaurantResponseCode.GetRestaurantInfoCode;
import wnderful.yummy.vo.restaurantVo.RestGetInfoVo;

public class GetRestaurantInfoRes extends CommonResponse {

    public GetRestaurantInfoRes(GetRestaurantInfoCode code) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
    }

    public GetRestaurantInfoRes(GetRestaurantInfoCode code, RestGetInfoVo vo) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
        this.setBody(vo);
    }
}
