package wnderful.yummy.vo.memberVo;

import wnderful.yummy.entity.voEntity.RestDetail;

public class GetRestListVo {
    private RestDetail[] restaurants;

    public GetRestListVo(RestDetail[] restaurants) {
        this.restaurants = restaurants;
    }

    public GetRestListVo() {
        this.restaurants = new RestDetail[1];
        restaurants[0] = new RestDetail();
    }

    public RestDetail[] getRestaurants() {
        return restaurants;
    }
}
