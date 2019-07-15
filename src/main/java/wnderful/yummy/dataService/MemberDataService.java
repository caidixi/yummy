package wnderful.yummy.dataService;

import org.springframework.web.multipart.MultipartFile;
import wnderful.yummy.vo.memberVo.GetAddressListVo;
import wnderful.yummy.vo.memberVo.GetMemInfoVo;

import java.io.IOException;

public interface MemberDataService {

    boolean memberPhoneExist(String phoneNumber);

    boolean memberUidExist(String uid);

    boolean memberNameExist(String name);

    boolean memberAddressExist(String uid,String addressId);

    boolean memberIsCancel(String uid);

    boolean memberIsCancelByPhone(String phoneNumber);

    boolean verifyPasswordByPhone(String phoneNumber,String password);

    boolean verifyPasswordByUid(String uid, String password);

    long newMemberAddress(String uid, String name, String gender, String location, String detailAddress, double lng, double lat, String phone);

    void newMember(String phoneNumber, String password,String name);

    void memberLogOff(String uid);

    void resetMemPassword(String phone,String newPassword);

    void modMemPassword(String phone, String newPassword);

    void modMemberAddress(String addressId, String name, String gender, String location, String detailAddress, double lng, double lat, String phone);

    void modMemberAvatar(MultipartFile image,String uid) throws IOException;

    void deleteMemberAddress(String addressId);

    String getUidByPhone(String phoneNumber);

    GetMemInfoVo getMemInfo(String uid);

    String getMemberName(String uid);

    GetAddressListVo getMemberAddressList(String uid);
}
