package wnderful.yummy.response.ManagerResponse;

import wnderful.yummy.response.CommonResponse;
import wnderful.yummy.responseCode.managerResponseCode.GetModifyListCode;
import wnderful.yummy.vo.managerVo.GetModifyListVo;

public class GetModifyListRes extends CommonResponse {

    public GetModifyListRes(GetModifyListCode code) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
    }

    public GetModifyListRes(GetModifyListCode code, GetModifyListVo vo) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
        this.setBody(vo);
    }
}
