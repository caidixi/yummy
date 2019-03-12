package wnderful.yummy.response.MemberResponse;

import wnderful.yummy.response.CommonResponse;
import wnderful.yummy.responseCode.memberResponseCode.GetRestDetailCode;
import wnderful.yummy.vo.memberVo.GetRestDetailVo;

public class GetRestDetailRes extends CommonResponse {

    public GetRestDetailRes(GetRestDetailCode code) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
    }

    public GetRestDetailRes(GetRestDetailCode code, GetRestDetailVo vo) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
        this.setBody(vo);
    }
}
