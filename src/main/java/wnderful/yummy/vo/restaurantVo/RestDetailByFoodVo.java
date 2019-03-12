package wnderful.yummy.vo.restaurantVo;

import wnderful.yummy.entity.voEntity.RestStatisticByFood;

public class RestDetailByFoodVo {
    private String rid;
    private String name;
    private RestStatisticByFood[] foods;

    public RestDetailByFoodVo(String rid, String name, RestStatisticByFood[] foods) {
        this.rid = rid;
        this.name = name;
        this.foods = foods;
    }

    public RestDetailByFoodVo() {
        foods = new RestStatisticByFood[1];
        foods[0] = new RestStatisticByFood();
    }
    public String getRid() {
        return rid;
    }

    public String getName() {
        return name;
    }

    public RestStatisticByFood[] getFoods() {
        return foods;
    }
}
