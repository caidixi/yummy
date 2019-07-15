package wnderful.yummy.blservice;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import wnderful.yummy.entity.FoodOrder;
import wnderful.yummy.response.Response;

public interface MemberService {
    Response getInformation(String uid);

    @Transactional
    Response modifyAvatar(MultipartFile image,String uid);

    Response getAddressList(String uid);

    Response addAddress(String uid,String name,String gender, String location,String detailAddress,double lng,double lat,String phone);

    Response modifyAddress(String uid,String addressId,String name,String gender, String location,String detailAddress,double lng,double lat,String phone);

    Response deleteAddress(String uid,String addressId);

    Response modifyPassword(String uid,String oldPassword,String newPassword);

    Response getRestaurantList(String type,String city,double lng,double lat);

    Response searchRestaurantByName(String name,String city,double lng,double lat);

    Response searchFoodByName(String name,String city,double lng,double lat);

    Response getRestaurantDetail(String rid);

    Response makeOrder(String uid, String rid, String addressId, int numberOfDinner,String remark,double totalPrice, FoodOrder[] foodOrders);

    Response payOrder(String uid,String accountId,String accountPassword,String oid);

    Response getOrderList(String uid);

    Response getOrderDetail(String uid,String oid);

    Response cancelOrder(String uid,String oid);

    Response confirmOrder(String uid,String oid);

    Response evaluateOrder(String uid,String oid,int point);

    Response getDetailByTime(String uid);

    Response getDetailByMoney(String uid);

    Response getDetailByRestaurant(String uid);

    Response verifyPassword(String uid,String password);

    Response logOff(String uid);

    Response collectRestaurant(String uid,String rid);

    Response cancelCollectRestaurant(String uid,String rid);

    Response getCollectRestaurantList(String uid,String city,double lng,double lat);
}
