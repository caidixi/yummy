package wnderful.yummy.blservice;

import wnderful.yummy.response.Response;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public interface BaseService {

    Response restaurantSignUp(String name,String email,String phone,String address,double lng,double lat,String city,String accountId,String type,String announcement,String picture);

    Response Login(String username, String password, HttpServletResponse response) throws UnsupportedEncodingException;

    Response getRestaurantTypeList();

    Response getFoodInfo(String fid);
}
