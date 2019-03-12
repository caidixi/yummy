package wnderful.yummy.response.MemberResponse;

import wnderful.yummy.response.CommonResponse;
import wnderful.yummy.responseCode.baseResponseCode.LogInCode;
import wnderful.yummy.responseCode.memberResponseCode.GetMemberInfoCode;
import wnderful.yummy.vo.commonVo.LogInVo;
import wnderful.yummy.vo.memberVo.GetMemInfoVo;

public class GetMemInfoRes extends CommonResponse {

    public GetMemInfoRes(GetMemberInfoCode code) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
    }

    public GetMemInfoRes(GetMemberInfoCode code, GetMemInfoVo vo) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
        this.setBody(vo);
    }
}
