package wnderful.yummy.util;

public class PriceHelper {
    public static double getReturnPrice(double totalPrice){
        return totalPrice/2;
    }

    public static double getMemberDiscount(int memberLevel){
        return 1 - memberLevel*0.02;
    }

    public static double getDeliveryPrice(int distance){
        return 1+ (distance/500)*0.5;
    }

    public static int getMemberLevel(int xp){
        if(xp>=10){
            if(xp>=50){
                if(xp>=200){
                    if(xp>=500){
                        if(xp>=1000){
                            return 5;
                        }else {
                            return 4;
                        }
                    }else {
                        return 3;
                    }
                }else {
                    return 2;
                }
            }else {
                return 1;
            }
        }else {
            return 0;
        }
    }
}
