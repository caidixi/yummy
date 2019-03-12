package wnderful.yummy.response.MemberResponse;

import wnderful.yummy.response.Response;
import wnderful.yummy.responseCode.memberResponseCode.CancelOrderCode;
import wnderful.yummy.responseCode.memberResponseCode.PayOrderCode;

public class CancelOrderRes extends Response {

    public CancelOrderRes(CancelOrderCode code) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
    }
}
