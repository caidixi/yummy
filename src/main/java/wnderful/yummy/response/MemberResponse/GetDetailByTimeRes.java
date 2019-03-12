package wnderful.yummy.response.MemberResponse;

import wnderful.yummy.response.CommonResponse;
import wnderful.yummy.responseCode.memberResponseCode.GetDetailByTimeCode;
import wnderful.yummy.vo.memberVo.MemDetailByTimeVo;

public class GetDetailByTimeRes extends CommonResponse {

    public GetDetailByTimeRes(GetDetailByTimeCode code) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
    }

    public GetDetailByTimeRes(GetDetailByTimeCode code, MemDetailByTimeVo vo) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
        this.setBody(vo);
    }
}
