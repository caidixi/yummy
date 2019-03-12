package wnderful.yummy.vo.memberVo;

import wnderful.yummy.entity.FullReduction;
import wnderful.yummy.entity.voEntity.FoodDetail;

public class GetRestDetailVo {
    private String name;
    private String picture;
    private String rid;
    private String address;
    private String announcement;
    private double totalDiscount;
    private FullReduction[] fullReductions;
    private FoodDetail[] foods;

    public GetRestDetailVo(String name, String picture, String rid, String address, String announcement, double totalDiscount, FullReduction[] fullReductions, FoodDetail[] foods) {
        this.name = name;
        this.picture = picture;
        this.rid = rid;
        this.address = address;
        this.announcement = announcement;
        this.totalDiscount = totalDiscount;
        this.fullReductions = fullReductions;
        this.foods = foods;
    }

    public GetRestDetailVo(String name, String picture, String rid, String address, String announcement, double totalDiscount, FoodDetail[] foods) {
        this.name = name;
        this.picture = picture;
        this.rid = rid;
        this.address = address;
        this.announcement = announcement;
        this.totalDiscount = totalDiscount;
        this.foods = foods;
    }

    public String getName() {
        return name;
    }

    public String getPicture() {
        return picture;
    }

    public String getRid() {
        return rid;
    }

    public String getAddress() {
        return address;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public FoodDetail[] getFoods() {
        return foods;
    }

    public double getTotalDiscount() {
        return totalDiscount;
    }

    public FullReduction[] getFullReductions() {
        return fullReductions;
    }
}
