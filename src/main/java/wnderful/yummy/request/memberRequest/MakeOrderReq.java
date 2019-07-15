package wnderful.yummy.request.memberRequest;

import wnderful.yummy.entity.FoodOrder;

public class MakeOrderReq {
    private String uid;
    private String rid;
    private String addressId;
    private int numOfDinner;
    private String remark;
    private double totalPrice;
    private FoodOrder[] foods;

    public MakeOrderReq() {
    }

    public MakeOrderReq(String uid, String rid, String addressId, int numOfDinner, String remark, double totalPrice, FoodOrder[] foods) {
        this.uid = uid;
        this.rid = rid;
        this.addressId = addressId;
        this.numOfDinner = numOfDinner;
        this.remark = remark;
        this.totalPrice = totalPrice;
        this.foods = foods;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public int getNumOfDinner() {
        return numOfDinner;
    }

    public void setNumOfDinner(int numOfDinner) {
        this.numOfDinner = numOfDinner;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public FoodOrder[] getFoods() {
        return foods;
    }

    public void setFoods(FoodOrder[] foods) {
        this.foods = foods;
    }
}
