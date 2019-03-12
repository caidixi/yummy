package wnderful.yummy.request.memberRequest;

import wnderful.yummy.entity.FoodOrder;

public class MakeOrderReq {
    private String uid;
    private String rid;
    private String address;
    private int numOfDinner;
    private String remark;
    private FoodOrder[] foods;

    public MakeOrderReq() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public FoodOrder[] getFoods() {
        return foods;
    }

    public void setFoods(FoodOrder[] foods) {
        this.foods = foods;
    }
}
