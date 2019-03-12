package wnderful.yummy.dataServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wnderful.yummy.dao.module.Address;
import wnderful.yummy.dao.module.Member;
import wnderful.yummy.dao.module.MemberState;
import wnderful.yummy.dao.repository.MemberRepository;
import wnderful.yummy.dao.repository.MemberStateRepository;
import wnderful.yummy.dataService.MemberDataService;
import wnderful.yummy.entity.entityInModule.MemberStateName;
import wnderful.yummy.util.EmailHelper;
import wnderful.yummy.util.PasswordHelper;
import wnderful.yummy.util.SHAHelper;
import wnderful.yummy.vo.memberVo.GetMemInfoVo;

@Service
public class MemberDataServiceImpl implements MemberDataService {
    private MemberRepository memberRepository;
    private MemberStateDataServiceImpl memberStateDataService;
    private MemberStateRepository memberStateRepository;
    private EmailHelper emailHelper;

    @Autowired
    public MemberDataServiceImpl(MemberRepository memberRepository, MemberStateDataServiceImpl memberStateDataService, MemberStateRepository memberStateRepository, EmailHelper emailHelper) {
        this.memberRepository = memberRepository;
        this.memberStateDataService = memberStateDataService;
        this.memberStateRepository = memberStateRepository;
        this.emailHelper = emailHelper;
    }

    @Override
    public boolean memberEmailExist(String email) {
        return memberRepository.findMemberByEmail(email)!=null;
    }

    @Override
    public boolean memberUidExist(String uid) {
        return memberRepository.findMemberByUid(Long.parseLong(uid))!=null;
    }

    @Override
    public boolean memberIsCancel(String uid) {
        Member member =  memberRepository.findMemberByUid(Long.parseLong(uid));
        if(member!=null){
            MemberState state  = member.getMemberState();
            String stateName = state.getName();
            return stateName.equals("cancel");
        }else {
            System.out.println("Error in method : memberIsCancel, in class MemberDataServiceImpl");
            return false;
        }
    }

    @Override
    public boolean verifyPassword(String email, String password) {
        Member member = memberRepository.findMemberByEmail(email);
        if(member!=null){
            String truePassword  = member.getPassword();
            String encryptPassword = SHAHelper.getResult(password);
            return truePassword.equals(encryptPassword);
        }else {
            System.out.println("Error in method : verifyPassword, in class MemberDataServiceImpl");
            return false;
        }
    }

    @Override
    public boolean verifyPasswordByUid(String uid, String password) {
        Member member = memberRepository.findMemberByUid(Long.parseLong(uid));
        if(member!=null){
            String truePassword  = member.getPassword();
            String encryptPassword = SHAHelper.getResult(password);
            return truePassword.equals(encryptPassword);
        }else {
            System.out.println("Error in method : verifyPasswordByUid, in class MemberDataServiceImpl");
            return false;
        }
    }

    @Override
    public void newMember(String name, String email, String phone, String addressInfo) {
        memberStateRepository.save(new MemberState(MemberStateName.NORMAL.getStateName()    ));
        String password = PasswordHelper.getRandomPassword();
        String encryptPassword = SHAHelper.getResult(password);
        MemberState memberState = memberStateDataService.getNormalState();
        if(memberState!=null){
            Address address = new Address(addressInfo,"","");
            Member member = new Member(name,encryptPassword,phone,email,memberState,address);
            memberRepository.save(member);
            emailHelper.sendMemberEmail(email,password);
        }else {
            System.out.println("Error in method : newMember, in class MemberDataServiceImpl");
        }
    }

    @Override
    public void modMemInfo(String uid, String newName, String newPhone, String address1, String address2, String address3) {
        Member member = memberRepository.findMemberByUid(Long.parseLong(uid));
        if(member!=null){
            Address address = member.getAddress();
            address.setLocationInfo1(address1);
            address.setLocationInfo2(address2);
            address.setLocationInfo3(address3);
            member.setName(newName);
            member.setPhone(newPhone);
            member.setAddress(address);
            memberRepository.save(member);
        }else {
            System.out.println("Error in method : modMemInfo, in class MemberDataServiceImpl");
        }
    }

    @Override
    public void modMemPassword(String uid, String newPassword) {
        Member member = memberRepository.findMemberByUid(Long.parseLong(uid));
        if(member!=null){
            String encryptPassword = SHAHelper.getResult(newPassword);
            member.setPassword(encryptPassword);
            memberRepository.save(member);
        }else {
            System.out.println("Error in method : modMemPassword, in class MemberDataServiceImpl");
        }
    }

    @Override
    public void memberLogOff(String uid) {
        Member member = memberRepository.findMemberByUid(Long.parseLong(uid));
        if(member!=null){
            MemberState memberState = memberStateDataService.getCancelState();
            member.setMemberState(memberState);
            memberRepository.save(member);
        }else {
            System.out.println("Error in method : memberLogOff, in class MemberDataServiceImpl");
        }
    }

    @Override
    public GetMemInfoVo getMemInfo(String uid) {
        Member member = memberRepository.findMemberByUid(Long.parseLong(uid));
        if(member!=null){
            Address address = member.getAddress();
            String locationInfo1 = address.getLocationInfo1();
            String locationInfo2 = address.getLocationInfo2();
            String locationInfo3 = address.getLocationInfo3();
            return new GetMemInfoVo(uid,member.getName(),member.getPhone(),member.getEmail(),member.getLevel(),member.getXp(),
                    locationInfo1,locationInfo2,locationInfo3);
        }else {
            System.out.println("Error in method : GetMemInfoVo, in class MemberDataServiceImpl");
            return null;
        }
    }

    @Override
    public String getUid(String email) {
        Member member = memberRepository.findMemberByEmail(email);
        assert member!=null;
        return member.getUid();
    }

    @Override
    public String getMemberName(String uid) {
        Member member = memberRepository.findMemberByUid(Long.parseLong(uid));
        assert member!=null;
        return member.getName();
    }
}
