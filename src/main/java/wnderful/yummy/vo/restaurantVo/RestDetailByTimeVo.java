package wnderful.yummy.vo.restaurantVo;

import wnderful.yummy.entity.voEntity.RestStatisticByTime;

public class RestDetailByTimeVo {
    private String rid;
    private double totalIncome;
    private RestStatisticByTime[] mouths;

    public RestDetailByTimeVo(String rid, double totalIncome, RestStatisticByTime[] mouths) {
        this.rid = rid;
        this.totalIncome = totalIncome;
        this.mouths = mouths;
    }

    public RestDetailByTimeVo() {
        mouths = new RestStatisticByTime[1];
        mouths[0] = new RestStatisticByTime();
    }

    public String getRid() {
        return rid;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public RestStatisticByTime[] getMouths() {
        return mouths;
    }
}
