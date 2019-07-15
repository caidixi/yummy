package wnderful.yummy.response.MemberResponse;

import wnderful.yummy.response.Response;
import wnderful.yummy.responseCode.memberResponseCode.ModifyAvatarCode;

public class ModifyAvatarRes extends Response {

    public ModifyAvatarRes(ModifyAvatarCode code) {
        setResult(code.getCode());
        setOpinion(code.getMessage());
    }
}
