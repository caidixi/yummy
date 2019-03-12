package wnderful.yummy.blserviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wnderful.yummy.blservice.RestaurantService;
import wnderful.yummy.dataServiceImpl.*;
import wnderful.yummy.entity.FullReduction;
import wnderful.yummy.response.Response;
import wnderful.yummy.response.RestaurantResponse.*;
import wnderful.yummy.responseCode.restaurantResponseCode.*;
import wnderful.yummy.vo.restaurantVo.*;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    private RestaurantDataServiceImpl restaurantDataService;
    private FoodDataServiceImpl foodDataService;
    private AccountDataServiceImpl accountDataService;
    private RestaurantFoodDataServiceImpl restaurantFoodDataService;
    private OrderDataServiceImpl orderDataService;

    @Autowired
    public RestaurantServiceImpl(RestaurantDataServiceImpl restaurantDataService, FoodDataServiceImpl foodDataService,
                                 AccountDataServiceImpl accountDataService, RestaurantFoodDataServiceImpl restaurantFoodDataService,
                                 OrderDataServiceImpl orderDataService) {
        this.restaurantDataService = restaurantDataService;
        this.foodDataService = foodDataService;
        this.accountDataService = accountDataService;
        this.restaurantFoodDataService = restaurantFoodDataService;
        this.orderDataService = orderDataService;
    }

    @Override
    public Response getInformation(String rid) {
        if(restaurantDataService.restaurantRidExist(rid)){
            RestGetInfoVo vo = restaurantDataService.getRestaurantInfo(rid);
            return new GetRestaurantInfoRes(GetRestaurantInfoCode.SUCCESS,vo);
        }else {
            return new GetRestaurantInfoRes(GetRestaurantInfoCode.NOTEXIST);
        }
    }

    @Override
    public Response getDetail(String rid) {
        if(restaurantDataService.restaurantRidExist(rid)){
            RestDetailVo vo = restaurantFoodDataService.getRestaurantDetailFromRest(rid);
            return new GetRestDetailRes(GetRestDetailCode.SUCCESS,vo);
        }else {
            return new GetRestDetailRes(GetRestDetailCode.RESTNOTEXIST);
        }
    }

    @Override
    public Response modifyInformation(String rid, String newName, String newPhone, String newAddress,String newAccountId,
                                      String newType, String newAnnouncement,String newPicture) {
        if(restaurantDataService.restaurantRidExist(rid)){
            if(accountDataService.accountExist(newAccountId)){
                if(!restaurantDataService.restaurantModificationExist(rid)){
                    if(!(newAddress.equals("")||newName.equals("")||newPhone.equals("")||newAnnouncement.equals(""))){
                        restaurantDataService.modRestaurantInfo(rid,newName,newPhone,newAddress,newAccountId,newType,newAnnouncement,newPicture);
                        return new ModRestaurantInfoRes(ModRestaurantInfoCode.SUCCESS);
                    }else {
                        return new ModRestaurantInfoRes(ModRestaurantInfoCode.EMPTYADDRESS);
                    }
                }else {
                    return new ModRestaurantInfoRes(ModRestaurantInfoCode.WAIT);
                }
            }else{
                return new ModRestaurantInfoRes(ModRestaurantInfoCode.NOACCOUNT);
            }
        }else {
            return new ModRestaurantInfoRes(ModRestaurantInfoCode.NOTEXIST);
        }
    }

    @Override
    public Response newFood(String rid,String foodName, String announcement, double price, double packagePrice, int number,
                            String picture, double discount, int discountLimit) {
        if(restaurantDataService.restaurantRidExist(rid)){
            System.out.println(price+" "+packagePrice+" "+number+ " "+ discount+" "+ discountLimit);
            if(price>0&&packagePrice>0&&number>0&&discount>0&&discount<=1){
                if (discount == 1){
                    discountLimit = 10000;
                }
                restaurantFoodDataService.newFood(rid,foodName,announcement,price,packagePrice,number,picture,discount,discountLimit);
                return new NewFoodRes(NewFoodCode.SUCCESS);
            }else {
                return new NewFoodRes(NewFoodCode.WRONGFORMAT);
            }
        }else {
            return new NewFoodRes(NewFoodCode.NOTEXIST);
        }
    }

    @Override
    public Response newDiscount(String rid, double totalDiscount, FullReduction[] fullReductions) {
        if(restaurantDataService.restaurantRidExist(rid)){
            boolean rightFormat = true;
            if(fullReductions!=null){
                for(FullReduction reduction:fullReductions){
                    if(reduction.getAmount()<0||reduction.getReduce()<0||reduction.getAmount()<reduction.getReduce()){
                        rightFormat = false;
                    }
                }
            }
            if(totalDiscount>0&&totalDiscount<=1&&rightFormat){
                restaurantDataService.modRestaurantDiscount(rid,totalDiscount,fullReductions);
                return new NewDiscountRes(NewDiscountCode.SUCCESS);
            }else {
                return new NewDiscountRes(NewDiscountCode.WRONGFORMAT);
            }
        }else {
            return new NewDiscountRes(NewDiscountCode.NOTEXIST);
        }
    }

    @Override
    public Response modifyFood(String rid, String fid, String newFoodName, String newAnnouncement, double newPrice,
                               double newPackagePrice, int newNumber, String newPicture, double newDiscount, int newDiscountLimit) {
        if(restaurantDataService.restaurantRidExist(rid)){
            if(foodDataService.foodExist(fid)){
                System.out.println(newPrice+" "+newPackagePrice+" "+ newNumber+" "+ newDiscount);
                if(newPrice>0&&newPackagePrice>0&&newNumber>0&&newDiscount>0&&newDiscount<=1){
                    if(newDiscount==1){
                        newDiscountLimit = 10000;
                    }
                    foodDataService.modFood(fid,newFoodName,newAnnouncement,newPrice,newPackagePrice,newNumber,newPicture,newDiscount,newDiscountLimit);
                    return new ModFoodRes(ModFoodCode.SUCCESS);
                }else {
                    return new ModFoodRes(ModFoodCode.WRONGFORMAT);
                }
            }else {
                return new ModFoodRes(ModFoodCode.FOODNOTEXIST);
            }
        }else {
            return new ModFoodRes(ModFoodCode.RESTNOTEXIST);
        }
    }

    @Override
    public Response deleteFood(String rid, String fid) {
        if(restaurantDataService.restaurantRidExist(rid)){
            if(foodDataService.foodExist(fid)){
                foodDataService.deleteFood(fid);
                return new DeleteFoodRes(DeleteFoodCode.SUCCESS);
            }else {
                return new DeleteFoodRes(DeleteFoodCode.FOODNOTEXIST);
            }
        }else {
            return new DeleteFoodRes(DeleteFoodCode.RESTNOTEXIST);
        }
    }

    @Override
    public Response getOrderList(String rid) {
        if(restaurantDataService.restaurantRidExist(rid)){
            RestGetOrderListVo vo = orderDataService.getRestaurantOrderList(rid);
            return new GetOrderListRes(GetOrderListCode.SUCCESS,vo);
        }else {
            return new GetOrderListRes(GetOrderListCode.NOTEXIST);
        }
    }

    @Override
    public Response getDetailByTime(String rid) {
        if(restaurantDataService.restaurantRidExist(rid)){
            RestDetailByTimeVo vo = orderDataService.getRestaurantDetailByTime(rid);
            return new GetRestDetailByTimeRes(GetDetailByTimeCode.SUCCESS,vo);
        }else {
            return new GetRestDetailByTimeRes(GetDetailByTimeCode.NOTEXIST);
        }
    }

    @Override
    public Response getDetailByFood(String rid) {
        if(restaurantDataService.restaurantRidExist(rid)){
            RestDetailByFoodVo vo = orderDataService.getRestaurantDetailByFood(rid);
            return new GetRestDetailByFoodRes(GetDetailByFoodCode.SUCCESS,vo);
        }else {
            return new GetRestDetailByFoodRes(GetDetailByFoodCode.NOTEXIST);
        }
    }

    @Override
    public Response getDetailByMember(String rid) {
        if(restaurantDataService.restaurantRidExist(rid)){
            RestDetailByMemberVo vo = orderDataService.getRestaurantDetailByMember(rid);
            return new GetRestDetailByMemberRes(GetDetailByMemberCode.SUCCESS,vo);
        }else {
            return new GetRestDetailByMemberRes(GetDetailByMemberCode.NOTEXIST);
        }
    }
}
