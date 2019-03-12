package wnderful.yummy.response.BaseResponse;

import wnderful.yummy.response.CommonResponse;
import wnderful.yummy.responseCode.baseResponseCode.LogInCode;
import wnderful.yummy.vo.commonVo.LogInVo;

public class LogInRes extends CommonResponse {

    public LogInRes(LogInCode logInCode) {
        this.setResult(logInCode.getCode());
        this.setOpinion(logInCode.getMessage());
    }

    public LogInRes(LogInCode logInCode, LogInVo logInVo) {
        this.setResult(logInCode.getCode());
        this.setOpinion(logInCode.getMessage());
        this.setBody(logInVo);
    }
}
