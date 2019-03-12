package wnderful.yummy.blserviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wnderful.yummy.blservice.BaseService;
import wnderful.yummy.dataServiceImpl.*;
import wnderful.yummy.entity.voEntity.FoodDetail;
import wnderful.yummy.response.BaseResponse.GetFoodInfoRes;
import wnderful.yummy.response.BaseResponse.LogInRes;
import wnderful.yummy.response.BaseResponse.MemberSignUpRes;
import wnderful.yummy.response.BaseResponse.RestaurantSignUpRes;
import wnderful.yummy.response.Response;
import wnderful.yummy.response.RestaurantResponse.GetRestaurantTypeListRes;
import wnderful.yummy.responseCode.baseResponseCode.GetFoodInfoCode;
import wnderful.yummy.responseCode.baseResponseCode.LogInCode;
import wnderful.yummy.responseCode.baseResponseCode.MemberSignUpCode;
import wnderful.yummy.responseCode.baseResponseCode.RestaurantSignUpCode;
import wnderful.yummy.responseCode.restaurantResponseCode.GetRestaurantTypeListCode;
import wnderful.yummy.util.JWTHelper;
import wnderful.yummy.vo.commonVo.LogInVo;
import wnderful.yummy.vo.restaurantVo.RestTypeListVo;

import java.io.UnsupportedEncodingException;

@Service
public class BaseServiceImpl implements BaseService {
    private MemberDataServiceImpl memberDataService;
    private RestaurantDataServiceImpl restaurantDataService;
    private ManagerDataServiceImpl managerDataService;
    private AccountDataServiceImpl accountDataService;
    private FoodDataServiceImpl foodDataService;

    @Autowired
    public BaseServiceImpl(MemberDataServiceImpl memberDataService, RestaurantDataServiceImpl restaurantDataService,
                           ManagerDataServiceImpl managerDataService, AccountDataServiceImpl accountDataService, FoodDataServiceImpl foodDataService) {
        this.memberDataService = memberDataService;
        this.restaurantDataService = restaurantDataService;
        this.managerDataService = managerDataService;
        this.accountDataService = accountDataService;
        this.foodDataService = foodDataService;
    }

    @Override
    public Response memberSignUp(String name, String email, String phone, String address) {
        if(!(name.equals("")||email.equals("")||phone.equals("")||address.equals(""))){
            if(!memberDataService.memberEmailExist(email)){
                memberDataService.newMember(name,email,phone,address);
                return new MemberSignUpRes(MemberSignUpCode.SUCCESS);
            }else {
                return new MemberSignUpRes(MemberSignUpCode.EXIST);
            }
        }else {
            return new MemberSignUpRes(MemberSignUpCode.EMPTY);
        }
    }

    @Override
    public Response restaurantSignUp(String name, String email, String phone, String address,String accountId, String type, String announcement) {
        if(!(name.equals("")||email.equals("")||phone.equals("")||address.equals("")||announcement.equals(""))){
            if(!restaurantDataService.restaurantEmailExist(email)){
                if(!restaurantDataService.restaurantApplicationExist(email)){
                    if(!restaurantDataService.restaurantNameExist(name)){
                        if(accountDataService.accountExist(accountId)){
                            restaurantDataService.newSignUpApplication(name,email,phone,address,accountId,type,announcement);
                            return new RestaurantSignUpRes(RestaurantSignUpCode.SUCCESS);
                        }else {
                            return new RestaurantSignUpRes(RestaurantSignUpCode.NOACCOUNT);
                        }
                    }else {
                        return new RestaurantSignUpRes(RestaurantSignUpCode.NAMEEXIST);
                    }
                }else {
                    return new RestaurantSignUpRes(RestaurantSignUpCode.WAIT);
                }
            }else {
                return new RestaurantSignUpRes(RestaurantSignUpCode.EMAILEXIST);
            }
        }else {
            return new RestaurantSignUpRes(RestaurantSignUpCode.EMPTY);
        }
    }

    @Override
    public Response Login(String username, String password) throws UnsupportedEncodingException {
        if(!(username.equals("")||password.equals(""))){
            JWTHelper helper = new JWTHelper();
            if(memberDataService.memberEmailExist(username)){
                if(memberDataService.verifyPassword(username,password)){
                    String token = helper.createToken(username,password,"member");
                    String uid = memberDataService.getUid(username);
                    String name = memberDataService.getMemberName(uid);
                    if(!memberDataService.memberIsCancel(uid)){
                        return new LogInRes(LogInCode.SUCCESS,new LogInVo(token,"member",uid,name));
                    }else {
                        return new LogInRes(LogInCode.NOTEXIST);
                    }
                }else {
                    return new LogInRes(LogInCode.WRONGPASSWORD);
                }
            } else if(restaurantDataService.restaurantRidExist(username)){
                if(restaurantDataService.verifyPassword(username,password)){
                    String token = helper.createToken(username,password,"restaurant");
                    String name = restaurantDataService.getRestaurantName(username);
                    return new LogInRes(LogInCode.SUCCESS,new LogInVo(token,"restaurant",username,name));
                }else {
                    return new LogInRes(LogInCode.WRONGPASSWORD);
                }
            }else if(managerDataService.managerEmailExist(username)){
                if(managerDataService.verifyPassword(username,password)){
                    String token = helper.createToken(username,password,"manager");
                    String mid = managerDataService.getMid(username);
                    String name = managerDataService.getManagerName(mid);
                    return new LogInRes(LogInCode.SUCCESS,new LogInVo(token,"manager",mid,name));
                }else {
                    return new LogInRes(LogInCode.WRONGPASSWORD);
                }
            }else {
                return new LogInRes(LogInCode.NOTEXIST);
            }
        }else {
            return new LogInRes(LogInCode.EMPTY);
        }
    }

    @Override
    public Response getRestaurantTypeList() {
        RestTypeListVo vo = restaurantDataService.getRestaurantTypeList();
        return new GetRestaurantTypeListRes(GetRestaurantTypeListCode.SUCCESS,vo);
    }

    @Override
    public Response getFoodInfo(String fid) {
        if(foodDataService.foodExist(fid)){
            FoodDetail foodDetail = foodDataService.getFoodDetail(fid);
            return new GetFoodInfoRes(GetFoodInfoCode.SUCCESS,foodDetail);
        }else {
            return new GetFoodInfoRes(GetFoodInfoCode.Fail);
        }
    }
}
