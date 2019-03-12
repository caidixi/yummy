package wnderful.yummy.response.MemberResponse;

import wnderful.yummy.response.Response;
import wnderful.yummy.responseCode.memberResponseCode.ModMemberInfoCode;

public class ModMemInfoRes extends Response {

    public ModMemInfoRes(ModMemberInfoCode code) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
    }
}
