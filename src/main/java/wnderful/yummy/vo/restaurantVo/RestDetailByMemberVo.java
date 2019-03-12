package wnderful.yummy.vo.restaurantVo;

import wnderful.yummy.entity.voEntity.RestStatisticByMember;

import java.util.ArrayList;

public class RestDetailByMemberVo {
    private String rid;
    private String  name;
    private RestStatisticByMember[] members;

    public RestDetailByMemberVo(String rid, String name, ArrayList<RestStatisticByMember> restStatisticByMembers) {
        this.rid = rid;
        this.name = name;
        this.members = new RestStatisticByMember[restStatisticByMembers.size()];
        for(int i = 0;i < restStatisticByMembers.size();i++){
            members[i] = restStatisticByMembers.get(i);
        }
    }

    public RestDetailByMemberVo() {
        members = new RestStatisticByMember[1];
        members[0] = new RestStatisticByMember();
    }

    public String getRid() {
        return rid;
    }

    public String getName() {
        return name;
    }

    public RestStatisticByMember[] getMembers() {
        return members;
    }
}
