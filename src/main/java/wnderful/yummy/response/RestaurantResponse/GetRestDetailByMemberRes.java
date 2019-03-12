package wnderful.yummy.response.RestaurantResponse;

import wnderful.yummy.response.CommonResponse;
import wnderful.yummy.responseCode.restaurantResponseCode.GetDetailByMemberCode;
import wnderful.yummy.vo.restaurantVo.RestDetailByMemberVo;

public class GetRestDetailByMemberRes extends CommonResponse {

    public GetRestDetailByMemberRes(GetDetailByMemberCode code) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
    }

    public GetRestDetailByMemberRes(GetDetailByMemberCode code, RestDetailByMemberVo vo) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
        this.setBody(vo);
    }
}
