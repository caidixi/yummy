package wnderful.yummy.response.ManagerAddressResponse;

import wnderful.yummy.response.CommonResponse;
import wnderful.yummy.response.Response;
import wnderful.yummy.responseCode.memberAddressResponseCode.AddAddressResCode;
import wnderful.yummy.vo.memberVo.AddressIdVo;

public class AddAddressRes extends CommonResponse {

    public AddAddressRes(AddAddressResCode code) {
        setResult(code.getCode());
        setOpinion(code.getMessage());
    }

    public AddAddressRes(AddAddressResCode code, AddressIdVo vo) {
        setResult(code.getCode());
        setOpinion(code.getMessage());
        setBody(vo);
    }
}
