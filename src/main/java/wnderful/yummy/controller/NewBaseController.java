package wnderful.yummy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wnderful.yummy.blserviceImpl.NewBaseServiceImpl;
import wnderful.yummy.request.memberRequest.ResetPasswordReq;
import wnderful.yummy.request.newBaseRequest.MemberLogInWithCodeReq;
import wnderful.yummy.request.newBaseRequest.MemberLogInWithPasswordReq;
import wnderful.yummy.request.newBaseRequest.MemberSignUpReq;
import wnderful.yummy.response.Response;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping(value = "/newCommon")
public class NewBaseController {
    private NewBaseServiceImpl newBaseService;

    @Autowired
    public NewBaseController(NewBaseServiceImpl newBaseService) {
        this.newBaseService = newBaseService;
    }

    @GetMapping(value = "/getVerificationCode")
    public Response getVerificationCode(@RequestParam("tel") String tel){
        return newBaseService.getVerificationCode(tel);
    }

    @PostMapping("/memberSignUp")
    public Response memberSignUp(@RequestBody MemberSignUpReq memberSignUpReq){
        return newBaseService.memberSignUp(memberSignUpReq.getPhone(),memberSignUpReq.getPassword(),memberSignUpReq.getName());
    }

    @PostMapping("/memberLogIn/code")
    public Response memberLogInWithCode(@RequestBody MemberLogInWithCodeReq memberLogInWithCodeReq, HttpServletResponse response) throws UnsupportedEncodingException {
        return newBaseService.memberLogInWithCode(memberLogInWithCodeReq.getPhone(), memberLogInWithCodeReq.getVerificationCode(),response);
    }

    @PostMapping("/memberLogIn/password")
    public Response memberLogInWithPassword(@RequestBody MemberLogInWithPasswordReq memberLogInWithPasswordReq, HttpServletResponse response) throws UnsupportedEncodingException {
        return newBaseService.memberLogInWithPassword(memberLogInWithPasswordReq.getPhone(), memberLogInWithPasswordReq.getPassword(),response);
    }

    @PostMapping("/memberResetPassword")
    public Response memberResetPassword(@RequestBody ResetPasswordReq resetPasswordReq){
        return newBaseService.resetPassword(resetPasswordReq.getPhone(),resetPasswordReq.getVerificationCode(),resetPasswordReq.getNewPassword());

    }
}
