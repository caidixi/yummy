package wnderful.yummy.response.BaseResponse;

import wnderful.yummy.response.Response;
import wnderful.yummy.responseCode.baseResponseCode.MemberSignUpCode;

public class MemberSignUpRes extends Response {

    public MemberSignUpRes(MemberSignUpCode memberSignUpCode) {
        this.setResult(memberSignUpCode.getCode());
        this.setOpinion(memberSignUpCode.getMessage());
    }
}
