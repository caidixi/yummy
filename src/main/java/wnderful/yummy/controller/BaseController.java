package wnderful.yummy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wnderful.yummy.blserviceImpl.BaseServiceImpl;
import wnderful.yummy.blserviceImpl.MemberServiceImpl;
import wnderful.yummy.request.baseRequest.LoginRequest;
import wnderful.yummy.request.baseRequest.RestSignUpReq;
import wnderful.yummy.response.Response;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping(value = "/common")
public class BaseController {
    private final BaseServiceImpl baseService;
    private final MemberServiceImpl memberService;

    @Autowired
    public BaseController(BaseServiceImpl baseService,MemberServiceImpl memberService) {
        this.baseService = baseService;
        this.memberService = memberService;
    }

    @PostMapping("/logIn")
    public Response login(@RequestBody LoginRequest loginRequest, HttpServletResponse response) throws UnsupportedEncodingException {
        return baseService.Login(loginRequest.getUsername(),loginRequest.getPassword(),response);
    }

    @PostMapping("/restaurantSignUp")
    public Response restaurantSignUp(@RequestBody RestSignUpReq restSignUpReq){
        return baseService.restaurantSignUp(restSignUpReq.getName(),restSignUpReq.getEmail(),restSignUpReq.getPhone(),
                restSignUpReq.getAddress(),restSignUpReq.getLng(),restSignUpReq.getLat(),restSignUpReq.getCity(),restSignUpReq.getAccountId(),restSignUpReq.getType(),restSignUpReq.getAnnouncement(),restSignUpReq.getPicture());
    }

    @GetMapping("/getRestaurantList")
    public Response getRestaurantList(@RequestParam("type") String type, @RequestParam("city") String city, @RequestParam("lng") double lng, @RequestParam("lat") double lat) {
        return memberService.getRestaurantList(type, city, lng, lat);
    }

    @GetMapping("/searchRestaurant")
    public Response searchRestaurant(@RequestParam("restaurantName") String name, @RequestParam("city") String city, @RequestParam("lng") double lng, @RequestParam("lat") double lat) {
        return memberService.searchRestaurantByName(name, city, lng, lat);
    }

    @GetMapping("/searchRestaurantFood")
    public Response searchRestaurantFood(@RequestParam("foodName") String name, @RequestParam("city") String city, @RequestParam("lng") double lng, @RequestParam("lat") double lat) {
        return memberService.searchFoodByName(name, city, lng, lat);
    }

    @GetMapping("/getRestaurantDetail")
    public Response getRestaurantDetail(@RequestParam("rid") String rid) {
        return memberService.getRestaurantDetail(rid);
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
