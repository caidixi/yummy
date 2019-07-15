package wnderful.yummy.entity.voEntity;

public class RestDetail {
    private String name;
    private String rid;
    private double point;
    private String picture;
    private double startingPrice;
    private double deliveryPrice;
    private int probablyTime;

    public RestDetail(String name, String rid, double point, String picture, double startingPrice, double deliveryPrice, int probablyTime) {
        this.name = name;
        this.rid = rid;
        this.point = point;
        this.picture = picture;
        this.startingPrice = startingPrice;
        this.deliveryPrice = deliveryPrice;
        this.probablyTime = probablyTime;
    }

    public RestDetail() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public double getStartingPrice() {
        return startingPrice;
    }

    public void setStartingPrice(double startingPrice) {
        this.startingPrice = startingPrice;
    }

    public double getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(double deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public int getProbablyTime() {
        return probablyTime;
    }

    public void setProbablyTime(int probablyTime) {
        this.probablyTime = probablyTime;
    }
}
