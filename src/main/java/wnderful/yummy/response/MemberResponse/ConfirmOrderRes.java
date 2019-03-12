package wnderful.yummy.response.MemberResponse;

import wnderful.yummy.response.Response;
import wnderful.yummy.responseCode.memberResponseCode.ConfirmOrderCode;

public class ConfirmOrderRes extends Response {

    public ConfirmOrderRes(ConfirmOrderCode code) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
    }
}
