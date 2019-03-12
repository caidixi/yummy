package wnderful.yummy.vo.managerVo;

public class RestStatisticsVo {
    private int restaurantNumber;
    private int applicationNumber;

    public RestStatisticsVo(int restaurantNumber, int applicationNumber) {
        this.restaurantNumber = restaurantNumber;
        this.applicationNumber = applicationNumber;
    }

    public int getRestaurantNumber() {
        return restaurantNumber;
    }



    public int getApplicationNumber() {
        return applicationNumber;
    }
}
