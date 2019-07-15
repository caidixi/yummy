package wnderful.yummy.response.ManagerAddressResponse;

import wnderful.yummy.response.Response;
import wnderful.yummy.responseCode.memberAddressResponseCode.ModifyAddressResCode;

public class ModifyAddressRes extends Response {

    public ModifyAddressRes(ModifyAddressResCode code) {
        setResult(code.getCode());
        setOpinion(code.getMessage());
    }
}
