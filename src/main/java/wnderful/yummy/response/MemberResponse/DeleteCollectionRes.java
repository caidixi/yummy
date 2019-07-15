package wnderful.yummy.response.MemberResponse;

import wnderful.yummy.response.Response;
import wnderful.yummy.responseCode.memberResponseCode.DeleteCollectionResCode;

public class DeleteCollectionRes extends Response {

    public DeleteCollectionRes(DeleteCollectionResCode code) {
        setResult(code.getCode());
        setOpinion(code.getMessage());
    }
}
