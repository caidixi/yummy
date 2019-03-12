package wnderful.yummy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wnderful.yummy.blserviceImpl.BaseServiceImpl;
import wnderful.yummy.request.baseRequest.LoginRequest;
import wnderful.yummy.request.baseRequest.MemberSignUpReq;
import wnderful.yummy.request.baseRequest.RestSignUpReq;
import wnderful.yummy.response.Response;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping(value = "/common")
public class BaseController {
    private final BaseServiceImpl baseService;

    @Autowired
    public BaseController(BaseServiceImpl baseService) {
        this.baseService = baseService;
    }

    @PostMapping("/logIn")
    public Response login(@RequestBody LoginRequest loginRequest) throws UnsupportedEncodingException {
        return baseService.Login(loginRequest.getUsername(),loginRequest.getPassword());
    }

    @PostMapping("/restaurantSignUp")
    public Response restaurantSignUp(@RequestBody RestSignUpReq restSignUpReq){
        return baseService.restaurantSignUp(restSignUpReq.getName(),restSignUpReq.getEmail(),restSignUpReq.getPhone(),
                restSignUpReq.getAddress(),restSignUpReq.getAccountId(),restSignUpReq.getType(),restSignUpReq.getAnnouncement());
    }

    @PostMapping("/memberSignUp")
    public Response memberSignUp(@RequestBody MemberSignUpReq memberSignUpReq){
        return baseService.memberSignUp(memberSignUpReq.getName(),memberSignUpReq.getEmail(),memberSignUpReq.getPhone(),
                memberSignUpReq.getAddress());
    }

    @GetMapping("/getRestaurantTypeList")
    public Response getRestaurantTypeList() {
        return baseService.getRestaurantTypeList();
    }

    @GetMapping("/getFoodInfo")
    public Response getFoodInfo(@RequestParam("fid") String fid) {
        return baseService.getFoodInfo(fid);
    }
}
