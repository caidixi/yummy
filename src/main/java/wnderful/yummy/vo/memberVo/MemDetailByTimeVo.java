package wnderful.yummy.vo.memberVo;

import wnderful.yummy.entity.voEntity.MemberStatisticByTime;

public class MemDetailByTimeVo {
    private String uid;
    private String name;
    private MemberStatisticByTime[] mouths;

    public MemDetailByTimeVo(String uid, String name, MemberStatisticByTime[] mouths) {
        this.uid = uid;
        this.name = name;
        this.mouths = mouths;
    }

    public MemDetailByTimeVo() {
        this.mouths = new MemberStatisticByTime[1];
        mouths[0] = new MemberStatisticByTime();
    }

    public String getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public MemberStatisticByTime[] getMouths() {
        return mouths;
    }
}
