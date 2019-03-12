package wnderful.yummy.response.RestaurantResponse;

import wnderful.yummy.response.CommonResponse;
import wnderful.yummy.responseCode.restaurantResponseCode.GetRestaurantTypeListCode;
import wnderful.yummy.vo.restaurantVo.RestTypeListVo;

public class GetRestaurantTypeListRes extends CommonResponse {

    public GetRestaurantTypeListRes(GetRestaurantTypeListCode code) {
        this.setResult(code.getCode());
        this.setOpinion(code.getMessage());
    }

    public GetRestaurantTypeListRes(GetRestaurantTypeListCode getMemberInfoCode, RestTypeListVo vo) {
        this.setResult(getMemberInfoCode.getCode());
        this.setOpinion(getMemberInfoCode.getMessage());
        this.setBody(vo);
    }
}
