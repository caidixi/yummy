package wnderful.yummy.response.ManagerResponse;

import wnderful.yummy.response.Response;
import wnderful.yummy.responseCode.ManagerResponseCode.ApproveModificationCode;

public class ApproveModificationRes extends Response {

    public ApproveModificationRes(ApproveModificationCode code) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
    }
}
