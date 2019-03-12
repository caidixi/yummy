package wnderful.yummy.response.RestaurantResponse;

import wnderful.yummy.response.CommonResponse;
import wnderful.yummy.responseCode.restaurantResponseCode.GetDetailByTimeCode;
import wnderful.yummy.vo.restaurantVo.RestDetailByTimeVo;

public class GetRestDetailByTimeRes extends CommonResponse {

    public GetRestDetailByTimeRes(GetDetailByTimeCode code) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
    }

    public GetRestDetailByTimeRes(GetDetailByTimeCode code, RestDetailByTimeVo vo) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
        this.setBody(vo);
    }
}
