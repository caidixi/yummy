package wnderful.yummy.response.ManagerResponse;

import wnderful.yummy.response.Response;
import wnderful.yummy.responseCode.ManagerResponseCode.ApproveApplicationCode;

public class ApproveApplicationRes extends Response {

    public ApproveApplicationRes(ApproveApplicationCode code) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
    }
}
