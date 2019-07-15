package wnderful.yummy.blserviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wnderful.yummy.blservice.NewBaseService;
import wnderful.yummy.dataService.MemberDataService;
import wnderful.yummy.response.BaseResponse.LogInRes;
import wnderful.yummy.response.BaseResponse.MemberSignUpRes;
import wnderful.yummy.response.MemberResponse.ModPasswordRes;
import wnderful.yummy.response.Response;
import wnderful.yummy.response.newBaseResponse.GetVerificationCodeRes;
import wnderful.yummy.responseCode.baseResponseCode.LogInCode;
import wnderful.yummy.responseCode.baseResponseCode.MemberSignUpCode;
import wnderful.yummy.responseCode.memberResponseCode.ModPasswordCode;
import wnderful.yummy.responseCode.newBaseResponseCode.baseResponseCode.VerificationResponseCode;
import wnderful.yummy.util.JWTHelper;
import wnderful.yummy.util.SmsHelper;
import wnderful.yummy.vo.commonVo.LogInVo;
import wnderful.yummy.vo.newCommonVo.GetVerificationCodeVo;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@Service
public class NewBaseServiceImpl implements NewBaseService {
    private SmsHelper smsHelper;
    private MemberDataService memberDataService;
    private Map<String, String> phoneNumberMap = new HashMap<>();

    @Autowired
    public NewBaseServiceImpl(SmsHelper smsHelper, MemberDataService memberDataService) {
        this.smsHelper = smsHelper;
        this.memberDataService = memberDataService;
    }

    @Override
    public Response getVerificationCode(String phoneNumber) {
        final String verificationCode = (int) (Math.random() * 1000000) + "";
        int resCode = smsHelper.sendMessage(phoneNumber, verificationCode);
        if (resCode == 0) {
            phoneNumberMap.put(phoneNumber, verificationCode);
            return new GetVerificationCodeRes(VerificationResponseCode.SUCCESS, new GetVerificationCodeVo(verificationCode));
        } else if (resCode == 2) {
            return new GetVerificationCodeRes(VerificationResponseCode.WRONGFORMAT);
        } else if (resCode == 33 || resCode == 8 || resCode == 9 || resCode == 19) {
            return new GetVerificationCodeRes(VerificationResponseCode.FREQUENT);
        } else {
            return new GetVerificationCodeRes(VerificationResponseCode.FAIL);
        }
    }

    @Override
    public Response memberSignUp(String phoneNumber, String password, String name) {
        if (!(phoneNumber.equals("") || password.equals(""))) {
            if (!memberDataService.memberPhoneExist(phoneNumber)) {
                if (!memberDataService.memberNameExist(name)) {
                    memberDataService.newMember(phoneNumber, password, name);
                    phoneNumberMap.remove(phoneNumber);
                    return new MemberSignUpRes(MemberSignUpCode.SUCCESS);
                } else {
                    return new MemberSignUpRes(MemberSignUpCode.REPEAT);
                }
            } else {
                return new MemberSignUpRes(MemberSignUpCode.EXIST);
            }
        } else {
            return new MemberSignUpRes(MemberSignUpCode.EMPTY);
        }
    }

    @Override
    public Response resetPassword(String phone, String verificationCode, String newPassword) {
        if (memberDataService.memberPhoneExist(phone)) {
            if (!memberDataService.memberIsCancelByPhone(phone)) {
                if (phoneNumberMap.containsKey(phone)) {
                    String trueCode = phoneNumberMap.get(phone);
                    if (trueCode.equals(verificationCode)) {
                        memberDataService.resetMemPassword(phone, newPassword);
                        return new ModPasswordRes(ModPasswordCode.SUCCESS);
                    } else {
                        return new ModPasswordRes(ModPasswordCode.CODEERROR);
                    }
                } else {
                    return new ModPasswordRes(ModPasswordCode.CODEERROR);
                }
            } else {
                return new ModPasswordRes(ModPasswordCode.CANCEL);
            }
        } else {
            return new ModPasswordRes(ModPasswordCode.NOTEXIST);
        }

    }

    @Override
    public Response memberLogInWithCode(String phoneNumber, String verificationCode, HttpServletResponse httpServletResponse) throws UnsupportedEncodingException {
        if (!(phoneNumber.equals("") || verificationCode.equals(""))) {
            if (memberDataService.memberPhoneExist(phoneNumber)) {
                if (!memberDataService.memberIsCancelByPhone(phoneNumber)) {
                    if (phoneNumberMap.containsKey(phoneNumber)) {
                        String trueCode = phoneNumberMap.get(phoneNumber);
                        if (trueCode.equals(verificationCode)) {
                            JWTHelper helper = new JWTHelper();
                            String token = helper.createToken(phoneNumber, "member");
                            String uid = memberDataService.getUidByPhone(phoneNumber);
                            String name = memberDataService.getMemberName(uid);

                            Cookie cookie = new Cookie("token", token);
                            cookie.setHttpOnly(true);
                            cookie.setPath("/service");
                            cookie.setMaxAge(3600);
                            httpServletResponse.addCookie(cookie);

                            Cookie idCookie = new Cookie("yummyId",uid);
                            cookie.setPath("/service");
                            httpServletResponse.addCookie(idCookie);

                            phoneNumberMap.remove(phoneNumber);
                            return new LogInRes(LogInCode.SUCCESS, new LogInVo("member", uid, name));
                        } else {
                            return new LogInRes(LogInCode.WRONGCODE);
                        }
                    } else {
                        return new LogInRes(LogInCode.NOCODE);
                    }
                } else {
                    return new LogInRes(LogInCode.CANCEL);
                }
            } else {
                return new LogInRes(LogInCode.NOTEXIST);
            }
        } else {
            return new LogInRes(LogInCode.EMPTY);
        }
    }

    @Override
    public Response memberLogInWithPassword(String phoneNumber, String password, HttpServletResponse httpServletResponse) throws UnsupportedEncodingException {
        if (!(phoneNumber.equals("") || password.equals(""))) {
            if (memberDataService.memberPhoneExist(phoneNumber)) {
                if (!memberDataService.memberIsCancelByPhone(phoneNumber)) {
                    if (memberDataService.verifyPasswordByPhone(phoneNumber, password)) {
                        JWTHelper helper = new JWTHelper();
                        String token = helper.createToken(phoneNumber, "member");
                        String uid = memberDataService.getUidByPhone(phoneNumber);
                        String name = memberDataService.getMemberName(uid);

                        Cookie cookie = new Cookie("token", token);
                        cookie.setHttpOnly(true);
                        cookie.setPath("/service");
                        cookie.setMaxAge(3600);
                        httpServletResponse.addCookie(cookie);

                        Cookie idCookie = new Cookie("yummyId",uid);
                        cookie.setPath("/service");
                        httpServletResponse.addCookie(idCookie);
                        return new LogInRes(LogInCode.SUCCESS, new LogInVo("member", uid, name));
                    } else {
                        return new LogInRes(LogInCode.WRONGPASSWORD);
                    }
                } else {
                    return new LogInRes(LogInCode.CANCEL);
                }
            } else {
                return new LogInRes(LogInCode.NOTEXIST);
            }
        } else {
            return new LogInRes(LogInCode.EMPTY);
        }
    }
}
