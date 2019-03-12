package wnderful.yummy.response.MemberResponse;

import wnderful.yummy.response.CommonResponse;
import wnderful.yummy.responseCode.memberResponseCode.GetDetailByMoneyCode;
import wnderful.yummy.vo.memberVo.MemDetailByMoneyVo;

public class GetDetailByMoneyRes extends CommonResponse {

    public GetDetailByMoneyRes(GetDetailByMoneyCode code) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
    }

    public GetDetailByMoneyRes(GetDetailByMoneyCode code, MemDetailByMoneyVo vo) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
        this.setBody(vo);
    }
}
