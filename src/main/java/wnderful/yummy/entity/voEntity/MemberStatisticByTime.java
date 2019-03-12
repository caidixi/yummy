package wnderful.yummy.entity.voEntity;

public class MemberStatisticByTime {
    private String year;
    private String mouth;
    private int times;
    private double totalMoney;
    private double averageMoney;


    public MemberStatisticByTime() {
    }

    public MemberStatisticByTime(int year, int mouth, int times, double totalMoney, double averageMoney) {
        this.year = year+"";
        this.mouth = mouth+"";
        this.times = times;
        this.totalMoney = totalMoney;
        this.averageMoney = averageMoney;
    }

    public String getYear() {
        return year;
    }

    public String getMouth() {
        return mouth;
    }

    public int getTimes() {
        return times;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public double getAverageMoney() {
        return averageMoney;
    }
}
