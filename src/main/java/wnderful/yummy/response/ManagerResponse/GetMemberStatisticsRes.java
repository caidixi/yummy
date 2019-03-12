package wnderful.yummy.response.ManagerResponse;

import wnderful.yummy.response.CommonResponse;
import wnderful.yummy.responseCode.ManagerResponseCode.GetStatisticsCode;
import wnderful.yummy.vo.managerVo.MemberStatisticsVo;

public class GetMemberStatisticsRes extends CommonResponse {

    public GetMemberStatisticsRes(GetStatisticsCode code) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
    }

    public GetMemberStatisticsRes(GetStatisticsCode code, MemberStatisticsVo vo) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
        this.setBody(vo);
    }
}
