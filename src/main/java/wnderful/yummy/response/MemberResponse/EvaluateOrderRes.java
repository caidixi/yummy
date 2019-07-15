package wnderful.yummy.response.MemberResponse;

import wnderful.yummy.response.Response;
import wnderful.yummy.responseCode.memberResponseCode.EvaluateOrderCode;

public class EvaluateOrderRes extends Response {

    public EvaluateOrderRes(EvaluateOrderCode code) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
    }
}
