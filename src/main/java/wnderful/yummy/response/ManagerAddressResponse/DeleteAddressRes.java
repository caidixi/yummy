package wnderful.yummy.response.ManagerAddressResponse;

import wnderful.yummy.response.Response;
import wnderful.yummy.responseCode.memberAddressResponseCode.DeleteAddressResCode;

public class DeleteAddressRes extends Response {

    public DeleteAddressRes(DeleteAddressResCode code) {
        setResult(code.getCode());
        setOpinion(code.getMessage());
    }
}
