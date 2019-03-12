package wnderful.yummy.response.MemberResponse;

import wnderful.yummy.response.CommonResponse;
import wnderful.yummy.responseCode.memberResponseCode.LogOffCode;
import wnderful.yummy.responseCode.memberResponseCode.VerifyPasswordCode;
import wnderful.yummy.vo.memberVo.VerifyPasswordVo;

public class LogOffRes extends CommonResponse {

    public LogOffRes(LogOffCode code) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
    }
}
