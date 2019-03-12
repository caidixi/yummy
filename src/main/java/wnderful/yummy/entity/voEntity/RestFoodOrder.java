package wnderful.yummy.entity.voEntity;

public class RestFoodOrder {
    private String fid;
    private String name;
    private int number;

    public RestFoodOrder(String fid, String name, int number) {
        this.fid = fid;
        this.name = name;
        this.number = number;
    }

    public RestFoodOrder() {
    }

    public String getFid() {
        return fid;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }
}
