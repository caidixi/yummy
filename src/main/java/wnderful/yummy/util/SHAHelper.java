package wnderful.yummy.util;

import java.math.BigInteger;
import java.security.MessageDigest;

public class SHAHelper {
    private static final String KEY_SHA = "SHA";


    public static  String  getResult(String inputStr)
    {
        BigInteger sha =new BigInteger("0");
        //System.out.println("=======加密前的数据:"+inputStr);
        byte[] inputData = inputStr.getBytes();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KEY_SHA);
            messageDigest.update(inputData);
            sha = new BigInteger(messageDigest.digest());
            //System.out.println("SHA加密后:" + sha.toString(32));
        } catch (Exception e) {e.printStackTrace();}
        return sha.toString(32);
    }
}
