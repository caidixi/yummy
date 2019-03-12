package wnderful.yummy.blservice;

import wnderful.yummy.entity.FoodOrder;
import wnderful.yummy.response.Response;

public interface MemberService {
    Response getInformation(String uid);

    Response modifyInformation(String uid,String newName,String newPhone,String address1
    ,String address2,String address3);

    Response modifyPassword(String uid,String oldPassword,String newPassword);

    Response getRestaurantList(String uid);

    Response getRestaurantDetail(String uid,String rid);

    Response makeOrder(String uid, String rid, String address, int numberOfDinner,String remark, FoodOrder[] foodOrders);

    Response payOrder(String uid,String accountId,String accountPassword,String oid);

    Response getOrderList(String uid);

    Response getOrderDetail(String uid,String oid);

    Response cancelOrder(String uid,String oid);

    Response confirmOrder(String uid,String oid);

    Response getDetailByTime(String uid);

    Response getDetailByMoney(String uid);

    Response getDetailByRestaurant(String uid);

    Response verifyPassword(String uid,String password);

    Response logOff(String uid);
}
