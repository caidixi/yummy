package wnderful.yummy.response.MemberResponse;

import wnderful.yummy.response.Response;
import wnderful.yummy.responseCode.memberResponseCode.ModPasswordCode;

public class ModPasswordRes extends Response {

    public ModPasswordRes(ModPasswordCode code) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
    }
}
