package wnderful.yummy.blservice;

import wnderful.yummy.entity.FullReduction;
import wnderful.yummy.response.Response;

public interface RestaurantService {
    Response getInformation(String rid);

    Response getDetail(String rid);

    Response modifyInformation(String rid,String newName,String newPhone,String newAddress,String newAccountId,String newType,String newAnnouncement,String newPicture);

    Response newFood(String rid,String foodName,String announcement,double price,double packagePrice,int number,String picture,double discount,int discountLimit);

    Response newDiscount(String rid, double totalDiscount, FullReduction[] fullReductions);

    Response modifyFood(String rid,String fid,String newFoodName,String newAnnouncement,double newPrice,double newPackagePrice,int newNumber,String newPicture,double newDiscount,int newDiscountLimit);

    Response deleteFood(String rid,String fid);

    Response getOrderList(String rid);

    Response getDetailByTime(String rid);

    Response getDetailByFood(String rid);

    Response getDetailByMember(String rid);
}
