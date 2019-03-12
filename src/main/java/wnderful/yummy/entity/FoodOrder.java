package wnderful.yummy.entity;

public class FoodOrder {
    private String fid;
    private String name;
    private int number;

    public FoodOrder(String fid, String name, int number) {
        this.fid = fid;
        this.name = name;
        this.number = number;
    }

    public FoodOrder() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
