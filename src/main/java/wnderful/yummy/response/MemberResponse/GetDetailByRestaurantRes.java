package wnderful.yummy.response.MemberResponse;

import wnderful.yummy.response.CommonResponse;
import wnderful.yummy.responseCode.memberResponseCode.GetDetailByRestaurantCode;
import wnderful.yummy.vo.memberVo.MemDetailByRestaurantVo;

public class GetDetailByRestaurantRes extends CommonResponse {

    public GetDetailByRestaurantRes(GetDetailByRestaurantCode code) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
    }

    public GetDetailByRestaurantRes(GetDetailByRestaurantCode code, MemDetailByRestaurantVo vo) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
        this.setBody(vo);
    }
}
