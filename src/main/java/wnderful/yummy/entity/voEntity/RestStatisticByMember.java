package wnderful.yummy.entity.voEntity;

public class RestStatisticByMember {
    private String uid;
    private String name;
    private int totalTimes;
    private double totalMoney;

    public RestStatisticByMember() {
    }

    public RestStatisticByMember(String uid, String name, int totalTimes, double totalMoney) {
        this.uid = uid;
        this.name = name;
        this.totalTimes = totalTimes;
        this.totalMoney = totalMoney;
    }

    public String getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public int getTotalTimes() {
        return totalTimes;
    }

    public double getTotalMoney() {
        return totalMoney;
    }
}
