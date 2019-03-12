package wnderful.yummy.response.MemberResponse;

import wnderful.yummy.response.Response;
import wnderful.yummy.responseCode.memberResponseCode.PayOrderCode;

public class PayOrderRes extends Response {

    public PayOrderRes(PayOrderCode code) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
    }
}
