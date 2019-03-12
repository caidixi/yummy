package wnderful.yummy.dataService;

import wnderful.yummy.vo.memberVo.GetMemInfoVo;

public interface MemberDataService {
    boolean memberEmailExist(String email);

    boolean memberUidExist(String uid);

    boolean memberIsCancel(String uid);

    boolean verifyPassword(String email, String password);

    boolean verifyPasswordByUid(String uid, String password);

    void newMember(String name, String email, String phone, String addressInfo);

    void memberLogOff(String uid);

    void modMemPassword(String uid, String newPassword);

    void modMemInfo(String uid, String newName, String newPhone, String address1, String address2, String address3);

    String getUid(String email);

    GetMemInfoVo getMemInfo(String uid);

    String getMemberName(String uid);
}
