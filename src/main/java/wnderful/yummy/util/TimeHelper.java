package wnderful.yummy.util;

import com.alibaba.fastjson.JSON;
import wnderful.yummy.entity.entityInModule.OrderTime;

import java.util.Calendar;

public class TimeHelper {
    public static String getInstanceTime() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int mouth = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        OrderTime orderTime = new OrderTime(year,mouth,day,hour,minute);
        return JSON.toJSONString(orderTime);
    }

    public static int getYear(){
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR);
    }

    public static int getMouth(){
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MONTH)+1;
    }

    public static boolean isOvertime(String time) {
        OrderTime orderTime = JSON.parseObject(time, OrderTime.class);
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int mouth = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        if (year == orderTime.getYear()) {
            if (mouth == orderTime.getMouth()) {
                if (day == orderTime.getDay()) {
                    return (60*hour+minute)-(orderTime.getHour()*60+orderTime.getMinute())>1;
                } else {
                    return true;
                }
            } else {
                return true;
            }
        } else {
            return true;
        }
    }
}
