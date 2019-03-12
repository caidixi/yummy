package wnderful.yummy.util;

public class LocationHelper {
    public static int getDistance(String addressInfo1,String addressInfo2){
        return (int)(Math.random()*5000);
    }

    public static int getArriveTime(int distance){
        return 20+(int)(distance/100/(1+Math.random()));
    }
}
