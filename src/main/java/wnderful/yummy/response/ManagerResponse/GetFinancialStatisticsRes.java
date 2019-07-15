package wnderful.yummy.response.ManagerResponse;

import wnderful.yummy.response.CommonResponse;
import wnderful.yummy.responseCode.managerResponseCode.GetStatisticsCode;
import wnderful.yummy.vo.managerVo.FinancialStatisticsVo;

public class GetFinancialStatisticsRes extends CommonResponse {

    public GetFinancialStatisticsRes(GetStatisticsCode code) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
    }

    public GetFinancialStatisticsRes(GetStatisticsCode code, FinancialStatisticsVo vo) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
        this.setBody(vo);
    }
}
