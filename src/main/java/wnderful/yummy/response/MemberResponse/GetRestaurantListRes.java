package wnderful.yummy.response.MemberResponse;

import wnderful.yummy.response.CommonResponse;
import wnderful.yummy.responseCode.memberResponseCode.GetMemberInfoCode;
import wnderful.yummy.responseCode.memberResponseCode.GetRestaurantListCode;
import wnderful.yummy.vo.memberVo.GetMemInfoVo;
import wnderful.yummy.vo.memberVo.GetRestListVo;

public class GetRestaurantListRes extends CommonResponse {

    public GetRestaurantListRes(GetRestaurantListCode code) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
    }

    public GetRestaurantListRes(GetRestaurantListCode getMemberInfoCode, GetRestListVo vo) {
        this.setResult(getMemberInfoCode.getCode());
        this.setOpinion(getMemberInfoCode.getMessage());
        this.setBody(vo);
    }
}
