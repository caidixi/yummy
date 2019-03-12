package wnderful.yummy.entity.voEntity;

public class RestStatisticByTime {
    private String year;
    private String mouth;
    private int times;
    private double totalIncome;
    private double averageIncome;


    public RestStatisticByTime() {
    }

    public RestStatisticByTime(int year, int mouth, int times, double totalIncome, double averageIncome) {
        this.year = year+"";
        this.mouth = mouth+"";
        this.times = times;
        this.totalIncome = totalIncome;
        this.averageIncome = averageIncome;
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

    public double getTotalIncome() {
        return totalIncome;
    }

    public double getAverageIncome() {
        return averageIncome;
    }
}
