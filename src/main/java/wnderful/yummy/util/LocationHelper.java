package wnderful.yummy.util;

import wnderful.yummy.dao.module.Address;
import wnderful.yummy.dao.module.Restaurant;

public class LocationHelper {

    private static double rad(double d){
        return d * Math.PI / 180.0;
    }

    public static double getDistance(double lng1,double lat1,double lng2,double lat2){
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 *Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2)+Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));
        s = s * 6371004;
        return s;
    }

    public static int getArriveTime(double distance){
        return 20+(int)(distance/1000*8);
    }

    public static int getArriveTime(Address address, Restaurant restaurant){
        double distance = getDistance(address.getLng(),address.getLat(),restaurant.getLng(),restaurant.getLat());
        return 20+(int)(distance/1000*8);
    }
}
