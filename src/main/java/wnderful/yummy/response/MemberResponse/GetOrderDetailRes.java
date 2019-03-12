package wnderful.yummy.response.MemberResponse;

import wnderful.yummy.response.CommonResponse;
import wnderful.yummy.responseCode.memberResponseCode.GetOrderDetailCode;
import wnderful.yummy.responseCode.memberResponseCode.GetOrderListCode;
import wnderful.yummy.responseCode.memberResponseCode.GetRestDetailCode;
import wnderful.yummy.vo.memberVo.GetOrderDetailVo;
import wnderful.yummy.vo.memberVo.GetRestDetailVo;

public class GetOrderDetailRes extends CommonResponse {

    public GetOrderDetailRes(GetOrderDetailCode code) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
    }

    public GetOrderDetailRes(GetOrderDetailCode code, GetOrderDetailVo vo) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
        this.setBody(vo);
    }
}
