package wnderful.yummy.blservice;

import wnderful.yummy.response.Response;

import java.io.UnsupportedEncodingException;

public interface BaseService {
    Response memberSignUp(String name,String email,String phone,String address);

    Response restaurantSignUp(String name,String email,String phone,String address,String accountId,String type,String announcement);

    Response Login(String username,String password) throws UnsupportedEncodingException;

    Response getRestaurantTypeList();

    Response getFoodInfo(String fid);
}
