package wnderful.yummy.dataServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import wnderful.yummy.dao.module.Address;
import wnderful.yummy.dao.module.Member;
import wnderful.yummy.dao.module.MemberState;
import wnderful.yummy.dao.repository.AddressRepository;
import wnderful.yummy.dao.repository.MemberRepository;
import wnderful.yummy.dao.repository.MemberStateRepository;
import wnderful.yummy.dataService.MemberDataService;
import wnderful.yummy.entity.entityInModule.MemberStateName;
import wnderful.yummy.entity.voEntity.memberVo.AddressInfo;
import wnderful.yummy.util.CosHelper;
import wnderful.yummy.util.SHAHelper;
import wnderful.yummy.vo.memberVo.GetAddressListVo;
import wnderful.yummy.vo.memberVo.GetMemInfoVo;

import java.io.IOException;
import java.util.List;

@Service
public class MemberDataServiceImpl implements MemberDataService {
    private MemberRepository memberRepository;
    private MemberStateDataServiceImpl memberStateDataService;
    private MemberStateRepository memberStateRepository;
    private AddressRepository addressRepository;
    private CosHelper cosHelper;

    @Autowired
    public MemberDataServiceImpl(MemberRepository memberRepository, MemberStateDataServiceImpl memberStateDataService,
                                 MemberStateRepository memberStateRepository, AddressRepository addressRepository, CosHelper cosHelper) {
        this.memberRepository = memberRepository;
        this.memberStateDataService = memberStateDataService;
        this.memberStateRepository = memberStateRepository;
        this.addressRepository = addressRepository;
        this.cosHelper = cosHelper;
    }

    @Override
    public boolean memberPhoneExist(String phoneNumber) {
        return memberRepository.findMemberByPhone(phoneNumber) != null;
    }

    @Override
    public boolean memberUidExist(String uid) {
        return memberRepository.findMemberByUid(Long.parseLong(uid)) != null;
    }

    @Override
    public boolean memberNameExist(String name) {
        return memberRepository.findMemberByName(name) != null;
    }

    @Override
    public boolean memberAddressExist(String uid, String addressId) {
        Address address = addressRepository.findByAddressId(Long.parseLong(addressId));
        return address != null && address.getMember() != null && address.getMember().getUid().equals(uid);
    }

    @Override
    public boolean memberIsCancel(String uid) {
        Member member = memberRepository.findMemberByUid(Long.parseLong(uid));
        if (member != null) {
            MemberState state = member.getMemberState();
            String stateName = state.getName();
            return stateName.equals("cancel");
        } else {
            System.out.println("member not found : memberIsCancel, in class MemberDataServiceImpl");
            return false;
        }
    }

    @Override
    public boolean memberIsCancelByPhone(String phoneNumber) {
        Member member = memberRepository.findMemberByPhone(phoneNumber);
        if (member != null) {
            MemberState state = member.getMemberState();
            String stateName = state.getName();
            return stateName.equals("cancel");
        } else {
            System.out.println("member not found in method : memberIsCancelByPhone, in class MemberDataServiceImpl");
            return false;
        }
    }

    @Override
    public boolean verifyPasswordByPhone(String phoneNumber, String password) {
        Member member = memberRepository.findMemberByPhone(phoneNumber);
        if (member != null) {
            String truePassword = member.getPassword();
            String encryptPassword = SHAHelper.getResult(password);
            return truePassword.equals(encryptPassword);
        } else {
            System.out.println("Error in method : verifyPasswordByPhone,in class MemberDataServiceImpl");
            return false;
        }
    }

    @Override
    public boolean verifyPasswordByUid(String uid, String password) {
        Member member = memberRepository.findMemberByUid(Long.parseLong(uid));
        if (member != null) {
            String truePassword = member.getPassword();
            String encryptPassword = SHAHelper.getResult(password);
            return truePassword.equals(encryptPassword);
        } else {
            System.out.println("Error in method : verifyPasswordByUid, in class MemberDataServiceImpl");
            return false;
        }
    }

    @Override
    public long newMemberAddress(String uid, String name, String gender, String location, String detailAddress, double lng, double lat, String phone) {
        Member member = memberRepository.findMemberByUid(Long.parseLong(uid));
        assert member != null;
        Address address = new Address(name, gender, location, detailAddress, lng, lat, phone, member);
        return addressRepository.saveAndFlush(address).getAddressId();
    }

    @Override
    public void newMember(String phoneNumber, String password, String name) {
        String encryptPassword = SHAHelper.getResult(password);
        MemberState memberState = memberStateDataService.getNormalState();
        if (memberState != null) {
            String defaultAvatar = cosHelper.getDefaultAvatarUrl();
            Member member = new Member(phoneNumber, encryptPassword, name, defaultAvatar,memberState);
            memberRepository.save(member);
        } else {
            System.out.println("Error in method : newMember, in class MemberDataServiceImpl");
        }
    }


    @Override
    public void resetMemPassword(String phone, String newPassword) {
        Member member = memberRepository.findMemberByPhone(phone);
        if (member != null) {
            String encryptPassword = SHAHelper.getResult(newPassword);
            member.setPassword(encryptPassword);
            memberRepository.save(member);
        } else {
            System.out.println("Error in method : modMemPassword, in class MemberDataServiceImpl");
        }
    }

    @Override
    public void modMemPassword(String uid, String newPassword) {
        Member member = memberRepository.findMemberByUid(Long.parseLong(uid));
        assert member!=null;
        String encryptPassword = SHAHelper.getResult(newPassword);
        member.setPassword(encryptPassword);
        memberRepository.save(member);
    }

    @Override
    public void modMemberAddress(String addressId, String name, String gender, String location, String detailAddress, double lng, double lat, String phone) {
        Address address = addressRepository.findByAddressId(Long.parseLong(addressId));
        assert address != null;
        address.setName(name);
        address.setGender(gender);
        address.setLocation(location);
        address.setDetailAddress(detailAddress);
        address.setLng(lng);
        address.setLat(lat);
        address.setPhone(phone);
        addressRepository.save(address);
    }

    @Override
    public void modMemberAvatar(MultipartFile image, String uid) throws IOException {
        Member member = memberRepository.findMemberByUid(Long.parseLong(uid));
        assert member != null;
        cosHelper.cosUpload("avatar", uid, image);
        String url = cosHelper.getURL("avatar", uid, image.getOriginalFilename());
        member.setAvatar(url);
        memberRepository.save(member);
    }

    @Override
    public void deleteMemberAddress(String addressId) {
        Address address = addressRepository.findByAddressId(Long.parseLong(addressId));
        assert address != null;
        addressRepository.delete(address);
    }

    @Override
    public void memberLogOff(String uid) {
        Member member = memberRepository.findMemberByUid(Long.parseLong(uid));
        if (member != null) {
            MemberState memberState = memberStateDataService.getCancelState();
            member.setMemberState(memberState);
            memberRepository.save(member);
        } else {
            System.out.println("Error in method : memberLogOff, in class MemberDataServiceImpl");
        }
    }

    @Override
    public GetMemInfoVo getMemInfo(String uid) {
        Member member = memberRepository.findMemberByUid(Long.parseLong(uid));
        if (member != null) {
            return new GetMemInfoVo(uid, member.getName(), member.getPhone(), member.getAvatar());
        } else {
            System.out.println("Error in method : GetMemInfoVo, in class MemberDataServiceImpl");
            return null;
        }
    }

    @Override
    public String getUidByPhone(String phoneNumber) {
        Member member = memberRepository.findMemberByPhone(phoneNumber);
        assert member != null;
        return member.getUid();
    }


    @Override
    public String getMemberName(String uid) {
        Member member = memberRepository.findMemberByUid(Long.parseLong(uid));
        assert member != null;
        return member.getName();
    }

    @Override
    public GetAddressListVo getMemberAddressList(String uid) {
        Member member = memberRepository.findMemberByUid(Long.parseLong(uid));
        assert member != null;
        assert member.getMemberState().getName().equals("normal");
        GetAddressListVo vo = new GetAddressListVo();
        List<Address> addressList = member.getAddress();
        if (addressList != null && addressList.size() > 0) {
            for (Address address : addressList) {
                AddressInfo addressInfo = new AddressInfo(address.getAddressId().toString(), address.getName(), address.getGender(), address.getLocation(), address.getDetailAddress(), address.getLng(), address.getLat(), address.getPhone());
                vo.addAddress(addressInfo);
            }
        }
        return vo;
    }
}
