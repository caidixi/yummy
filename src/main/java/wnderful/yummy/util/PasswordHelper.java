package wnderful.yummy.util;

public class PasswordHelper {
    public static String getRandomPassword(){
        return (int)(Math.random()*100000000)+"";
    }
}
