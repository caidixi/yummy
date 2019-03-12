package wnderful.yummy.entity.voEntity;

public class MemberStatisticByRestaurant {
    private String rid;
    private String name;
    private int totalTimes;
    private double averagePrice;

    public MemberStatisticByRestaurant() {
    }

    public MemberStatisticByRestaurant(String rid, String name, int totalTimes, double averagePrice) {
        this.rid = rid;
        this.name = name;
        this.totalTimes = totalTimes;
        this.averagePrice = averagePrice;
    }

    public String getRid() {
        return rid;
    }

    public String getName() {
        return name;
    }

    public int getTotalTimes() {
        return totalTimes;
    }

    public double getAveragePrice() {
        return averagePrice;
    }
}
