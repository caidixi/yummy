package wnderful.yummy.blservice;


import wnderful.yummy.response.Response;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;


public interface NewBaseService {
     Response getVerificationCode(String phoneNumber);

     Response memberSignUp(String phoneNumber,String password,String name);

     Response resetPassword(String phone,String verificationCode,String newPassword);

     Response memberLogInWithCode(String phoneNumber, String verificationCode, HttpServletResponse httpServletResponse)throws UnsupportedEncodingException;

     Response memberLogInWithPassword(String phoneNumber, String password, HttpServletResponse httpServletResponse)throws UnsupportedEncodingException;
}
