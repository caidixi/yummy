package wnderful.yummy.response.MemberResponse;

import wnderful.yummy.response.Response;
import wnderful.yummy.responseCode.memberResponseCode.AddCollectionResCode;

public class AddCollectionRes extends Response {

    public AddCollectionRes(AddCollectionResCode code) {
        setResult(code.getCode());
        setOpinion(code.getMessage());
    }
}
