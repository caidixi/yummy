package wnderful.yummy.entity;

public class FoodOrder {
    private String fid;
    private int number;

    public FoodOrder() {
    }

    public FoodOrder(String fid, int number) {
        this.fid = fid;
        this.number = number;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
