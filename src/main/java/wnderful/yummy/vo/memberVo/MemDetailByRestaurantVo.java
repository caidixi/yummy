package wnderful.yummy.vo.memberVo;


import wnderful.yummy.entity.voEntity.MemberStatisticByRestaurant;

import java.util.ArrayList;

public class MemDetailByRestaurantVo {
    private String uid;
    private String name;
    private MemberStatisticByRestaurant[] restaurants;

    public MemDetailByRestaurantVo() {
        this.restaurants = new MemberStatisticByRestaurant[1];
        restaurants[0] = new MemberStatisticByRestaurant();
    }

    public MemDetailByRestaurantVo(String uid, String name, ArrayList<MemberStatisticByRestaurant> memberStatisticByRestaurants) {
        this.uid = uid;
        this.name = name;
        this.restaurants = new MemberStatisticByRestaurant[memberStatisticByRestaurants.size()];
        for(int i = 0;i < memberStatisticByRestaurants.size();i++){
            restaurants[i] = memberStatisticByRestaurants.get(i);
        }
    }

    public String getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public MemberStatisticByRestaurant[] getRestaurants() {
        return restaurants;
    }
}
