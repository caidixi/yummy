package wnderful.yummy.blserviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wnderful.yummy.blservice.BaseService;
import wnderful.yummy.dataServiceImpl.*;
import wnderful.yummy.entity.voEntity.FoodDetail;
import wnderful.yummy.response.BaseResponse.GetFoodInfoRes;
import wnderful.yummy.response.BaseResponse.LogInRes;
import wnderful.yummy.response.BaseResponse.RestaurantSignUpRes;
import wnderful.yummy.response.Response;
import wnderful.yummy.response.RestaurantResponse.GetRestaurantTypeListRes;
import wnderful.yummy.responseCode.baseResponseCode.GetFoodInfoCode;
import wnderful.yummy.responseCode.baseResponseCode.LogInCode;
import wnderful.yummy.responseCode.baseResponseCode.RestaurantSignUpCode;
import wnderful.yummy.responseCode.restaurantResponseCode.GetRestaurantTypeListCode;
import wnderful.yummy.util.JWTHelper;
import wnderful.yummy.vo.commonVo.LogInVo;
import wnderful.yummy.vo.restaurantVo.RestTypeListVo;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

@Service
public class BaseServiceImpl implements BaseService {
    private RestaurantDataServiceImpl restaurantDataService;
    private ManagerDataServiceImpl managerDataService;
    private AccountDataServiceImpl accountDataService;
    private FoodDataServiceImpl foodDataService;

    @Autowired
    public BaseServiceImpl(RestaurantDataServiceImpl restaurantDataService,
                           ManagerDataServiceImpl managerDataService, AccountDataServiceImpl accountDataService, FoodDataServiceImpl foodDataService) {
        this.restaurantDataService = restaurantDataService;
        this.managerDataService = managerDataService;
        this.accountDataService = accountDataService;
        this.foodDataService = foodDataService;
    }

    @Override
    public Response restaurantSignUp(String name, String email, String phone, String address,double lng,double lat,String city, String accountId, String type, String announcement,String picture) {
        if (!(name.equals("") || email.equals("") || phone.equals("") || address.equals("") || announcement.equals(""))) {
            if (!restaurantDataService.restaurantEmailExist(email)) {
                if (!restaurantDataService.restaurantApplicationExist(email)) {
                    if (!restaurantDataService.restaurantNameExist(name)) {
                        if (accountDataService.accountExist(accountId)) {
                            restaurantDataService.newSignUpApplication(name, email, phone, address,lng,lat,city,accountId, type, announcement,picture);
                            return new RestaurantSignUpRes(RestaurantSignUpCode.SUCCESS);
                        } else {
                            return new RestaurantSignUpRes(RestaurantSignUpCode.NOACCOUNT);
                        }
                    } else {
                        return new RestaurantSignUpRes(RestaurantSignUpCode.NAMEEXIST);
                    }
                } else {
                    return new RestaurantSignUpRes(RestaurantSignUpCode.WAIT);
                }
            } else {
                return new RestaurantSignUpRes(RestaurantSignUpCode.EMAILEXIST);
            }
        } else {
            return new RestaurantSignUpRes(RestaurantSignUpCode.EMPTY);
        }
    }

    @Override
    public Response Login(String username, String password, HttpServletResponse response) throws UnsupportedEncodingException {
        if (!(username.equals("") || password.equals(""))) {
            JWTHelper helper = new JWTHelper();
            if (restaurantDataService.restaurantRidExist(username)) {
                if (restaurantDataService.verifyPassword(username, password)) {
                    String token = helper.createToken(username, "restaurant");
                    String name = restaurantDataService.getRestaurantName(username);

                    Cookie cookie = new Cookie("token", token);
                    cookie.setHttpOnly(true);
                    cookie.setPath("/service");
                    cookie.setMaxAge(3600);
                    response.addCookie(cookie);

                    Cookie idCookie = new Cookie("yummyId",username);
                    cookie.setPath("/service");
                    response.addCookie(idCookie);

                    return new LogInRes(LogInCode.SUCCESS, new LogInVo( "restaurant", username, name));
                } else {
                    return new LogInRes(LogInCode.WRONGPASSWORD);
                }
            } else if (managerDataService.managerEmailExist(username)) {
                if (managerDataService.verifyPassword(username, password)) {
                    String token = helper.createToken(username, "manager");
                    String mid = managerDataService.getMid(username);
                    String name = managerDataService.getManagerName(mid);

                    Cookie cookie = new Cookie("token", token);
                    cookie.setHttpOnly(true);
                    cookie.setPath("/service");
                    response.addCookie(cookie);

                    Cookie idCookie = new Cookie("yummyId",mid);
                    cookie.setPath("/service");
                    response.addCookie(idCookie);

                    return new LogInRes(LogInCode.SUCCESS, new LogInVo("manager", mid, name));
                } else {
                    return new LogInRes(LogInCode.WRONGPASSWORD);
                }
            } else {
                return new LogInRes(LogInCode.NOTEXIST);
            }
        } else {
            return new LogInRes(LogInCode.EMPTY);
        }
    }

    @Override
    public Response getRestaurantTypeList() {
        RestTypeListVo vo = restaurantDataService.getRestaurantTypeList();
        return new GetRestaurantTypeListRes(GetRestaurantTypeListCode.SUCCESS, vo);
    }

    @Override
    public Response getFoodInfo(String fid) {
        if (foodDataService.foodExist(fid)) {
            FoodDetail foodDetail = foodDataService.getFoodDetail(fid);
            return new GetFoodInfoRes(GetFoodInfoCode.SUCCESS, foodDetail);
        } else {
            return new GetFoodInfoRes(GetFoodInfoCode.Fail);
        }
    }
}
