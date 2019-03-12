package wnderful.yummy.response.RestaurantResponse;

import wnderful.yummy.response.CommonResponse;
import wnderful.yummy.responseCode.restaurantResponseCode.GetOrderListCode;
import wnderful.yummy.vo.restaurantVo.RestGetOrderListVo;

public class GetOrderListRes extends CommonResponse {

    public GetOrderListRes(GetOrderListCode code) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
    }

    public GetOrderListRes(GetOrderListCode code, RestGetOrderListVo vo) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
        this.setBody(vo);
    }
}
