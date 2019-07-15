package wnderful.yummy.dataService;

import org.springframework.transaction.annotation.Transactional;
import wnderful.yummy.entity.FullReduction;
import wnderful.yummy.vo.managerVo.GetApplyListVo;
import wnderful.yummy.vo.managerVo.GetModifyListVo;
import wnderful.yummy.vo.memberVo.GetRestListVo;
import wnderful.yummy.vo.restaurantVo.*;

public interface RestaurantDataService {

    boolean restaurantEmailExist(String email);

    boolean restaurantRidExist(String rid);

    boolean restaurantApplicationExist(String email);

    boolean restaurantModificationExist(String rid);

    boolean restaurantApplicationRidExist(String rid);

    boolean restaurantNameExist(String name);

    boolean verifyPassword(String rid,String password);

    @Transactional
    void approveApplication(String mid, String rid);

    void refuseApplication(String mid, String rid);

    void approveModification(String mid, String rid);

    void refuseModification(String mid, String rid);

    void newSignUpApplication(String name, String email, String phone, String address,double lng,double lat,String city,String accountId, String type, String announcement,String picture);

    void modRestaurantInfo(String rid, String newName, String newPhone, String newAddress,String newAccountId, String newType, String newAnnouncement,String newPicture);

    void modRestaurantDiscount(String rid, double totalDiscount, FullReduction[] fullReductions);

    String getRestaurantName(String rid);

    GetRestListVo getRestaurantList(String type,String city,double lng,double lat);

    GetRestListVo searchRestaurantByName(String name,String city,double lng,double lat);

    RestGetInfoVo getRestaurantInfo(String rid);

    RestTypeListVo getRestaurantTypeList();

    GetApplyListVo getApplyList();

    GetModifyListVo getModifyList();
}
