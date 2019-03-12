package wnderful.yummy.vo.restaurantVo;

import wnderful.yummy.entity.FullReduction;
import wnderful.yummy.entity.voEntity.FoodDetail;

public class RestDetailVo {
    private String name;
    private String rid;
    private double totalDiscount;
    private FullReduction[] fullReductions;
    private FoodDetail[] foods;

    public RestDetailVo(String name, String rid, double totalDiscount, FullReduction[] fullReductions, FoodDetail[] foods) {
        this.name = name;
        this.rid = rid;
        this.totalDiscount = totalDiscount;
        this.fullReductions = fullReductions;
        this.foods = foods;
    }

    public RestDetailVo(String name, String rid, double totalDiscount, FoodDetail[] foods) {
        this.name = name;
        this.rid = rid;
        this.totalDiscount = totalDiscount;
        this.foods = foods;
    }

    public String getName() {
        return name;
    }

    public String getRid() {
        return rid;
    }

    public double getTotalDiscount() {
        return totalDiscount;
    }

    public FullReduction[] getFullReductions() {
        return fullReductions;
    }

    public FoodDetail[] getFoods() {
        return foods;
    }
}
