package wnderful.yummy.entity.voEntity;

public class RestDetail {
    private String name;
    private String rid;
    private String picture;
    private String type;
    private int distance;
    private int probablyTime;

    public RestDetail(String name, String rid, String picture, String type, int distance, int probablyTime) {
        this.name = name;
        this.rid = rid;
        this.picture = picture;
        this.type = type;
        this.distance = distance;
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getProbablyTime() {
        return probablyTime;
    }

    public void setProbablyTime(int probablyTime) {
        this.probablyTime = probablyTime;
    }
}
