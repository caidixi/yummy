package wnderful.yummy.response.MemberResponse;

import wnderful.yummy.response.CommonResponse;
import wnderful.yummy.responseCode.memberResponseCode.VerifyPasswordCode;
import wnderful.yummy.vo.memberVo.VerifyPasswordVo;

public class VerifyPasswordRes extends CommonResponse {

    public VerifyPasswordRes(VerifyPasswordCode code) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
    }

    public VerifyPasswordRes(VerifyPasswordCode code, VerifyPasswordVo vo) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
        this.setBody(vo);
    }
}
