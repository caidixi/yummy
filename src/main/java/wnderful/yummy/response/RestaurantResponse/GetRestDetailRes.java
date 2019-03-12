package wnderful.yummy.response.RestaurantResponse;

import wnderful.yummy.response.CommonResponse;
import wnderful.yummy.responseCode.restaurantResponseCode.GetRestDetailCode;
import wnderful.yummy.vo.restaurantVo.RestDetailVo;

public class GetRestDetailRes extends CommonResponse {

    public GetRestDetailRes(GetRestDetailCode code) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
    }

    public GetRestDetailRes(GetRestDetailCode code, RestDetailVo vo) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
        this.setBody(vo);
    }
}
