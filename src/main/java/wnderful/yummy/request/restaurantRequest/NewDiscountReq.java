package wnderful.yummy.request.restaurantRequest;

import wnderful.yummy.entity.FullReduction;

public class NewDiscountReq {
    private String rid;
    private double totalDiscount;
    private FullReduction[] fullReductions;

    public NewDiscountReq() {
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public double getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public FullReduction[] getFullReductions() {
        return fullReductions;
    }

    public void setFullReductions(FullReduction[] fullReductions) {
        this.fullReductions = fullReductions;
    }
}
