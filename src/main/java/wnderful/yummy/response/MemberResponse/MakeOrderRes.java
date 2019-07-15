package wnderful.yummy.response.MemberResponse;

import wnderful.yummy.response.CommonResponse;
import wnderful.yummy.responseCode.memberResponseCode.MakeOrderCode;
import wnderful.yummy.vo.memberVo.MakeOrderVo;

public class MakeOrderRes extends CommonResponse {

    public MakeOrderRes(MakeOrderCode code) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
    }

    public MakeOrderRes(MakeOrderCode code,MakeOrderVo vo) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
        this.setBody(vo);
    }
}
