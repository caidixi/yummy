package wnderful.yummy.response.ManagerResponse;

import wnderful.yummy.response.CommonResponse;
import wnderful.yummy.responseCode.ManagerResponseCode.GetApplyListCode;
import wnderful.yummy.vo.managerVo.GetApplyListVo;

public class GetApplyListRes extends CommonResponse {

    public GetApplyListRes(GetApplyListCode code) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
    }

    public GetApplyListRes(GetApplyListCode code, GetApplyListVo vo) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
        this.setBody(vo);
    }
}
