package wnderful.yummy.entity.entityInModule;

public class OrderTime {
    private int year;
    private int mouth;
    private int day;
    private int hour;
    private int minute;

    public OrderTime(int year, int mouth, int day, int hour, int minute) {
        this.year = year;
        this.mouth = mouth;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    }

    public int getYear() {
        return year;
    }

    public int getMouth() {
        return mouth;
    }

    public int getDay() {
        return day;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMouth(int mouth) {
        this.mouth = mouth;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }
}
