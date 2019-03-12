package wnderful.yummy.response.ManagerResponse;

import wnderful.yummy.response.CommonResponse;
import wnderful.yummy.responseCode.ManagerResponseCode.GetStatisticsCode;
import wnderful.yummy.vo.managerVo.RestStatisticsVo;

public class GetRestaurantStatisticsRes extends CommonResponse {

    public GetRestaurantStatisticsRes(GetStatisticsCode code) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
    }

    public GetRestaurantStatisticsRes(GetStatisticsCode code, RestStatisticsVo vo) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
        this.setBody(vo);
    }
}
