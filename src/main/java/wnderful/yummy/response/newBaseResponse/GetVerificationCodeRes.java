package wnderful.yummy.response.newBaseResponse;

import wnderful.yummy.response.CommonResponse;
import wnderful.yummy.responseCode.newBaseResponseCode.baseResponseCode.VerificationResponseCode;
import wnderful.yummy.vo.newCommonVo.GetVerificationCodeVo;

public class GetVerificationCodeRes extends CommonResponse {

    public GetVerificationCodeRes(VerificationResponseCode code) {
        super(code.getCode(), code.getMessage());
    }

    public GetVerificationCodeRes(VerificationResponseCode code, GetVerificationCodeVo vo) {
        super(code.getCode(), code.getMessage(), vo);
    }
}
