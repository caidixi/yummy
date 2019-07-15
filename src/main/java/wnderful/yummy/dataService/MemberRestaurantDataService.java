package wnderful.yummy.dataService;

import wnderful.yummy.vo.memberVo.GetRestListVo;

public interface MemberRestaurantDataService {

    void addRestaurantCollection(String uid,String rid);

    void cancelRestaurantCollection(String uid,String rid);

   GetRestListVo getCollectRestaurant(String uid,String city,double lng,double lat);
}
