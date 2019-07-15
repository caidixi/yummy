package wnderful.yummy.response.ManagerAddressResponse;

import wnderful.yummy.response.CommonResponse;
import wnderful.yummy.responseCode.memberAddressResponseCode.GetAddressListResCode;
import wnderful.yummy.vo.memberVo.GetAddressListVo;

public class GetAddressListRes extends CommonResponse {
    public GetAddressListRes(GetAddressListResCode code) {
        setResult(code.getCode());
        setOpinion(code.getMessage());
    }

    public GetAddressListRes(GetAddressListResCode code, GetAddressListVo vo) {
        setResult(code.getCode());
        setOpinion(code.getMessage());
        setBody(vo);
    }
}
