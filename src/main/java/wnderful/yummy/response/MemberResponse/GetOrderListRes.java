package wnderful.yummy.response.MemberResponse;

import wnderful.yummy.response.CommonResponse;
import wnderful.yummy.responseCode.memberResponseCode.GetMemberInfoCode;
import wnderful.yummy.responseCode.memberResponseCode.GetOrderListCode;
import wnderful.yummy.vo.memberVo.GetMemInfoVo;
import wnderful.yummy.vo.memberVo.MemGetOrderListVo;

public class GetOrderListRes extends CommonResponse {

    public GetOrderListRes(GetOrderListCode code) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
    }

    public GetOrderListRes(GetOrderListCode code, MemGetOrderListVo vo) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
        this.setBody(vo);
    }
}
