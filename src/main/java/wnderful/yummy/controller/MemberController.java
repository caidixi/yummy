package wnderful.yummy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import wnderful.yummy.blserviceImpl.MemberServiceImpl;
import wnderful.yummy.request.memberRequest.*;
import wnderful.yummy.response.Response;

@RestController
@RequestMapping(value = "/service/member")
public class MemberController {
    private final MemberServiceImpl memberService;

    @Autowired
    public MemberController(MemberServiceImpl memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/getInformation")
    public Response getInformation(@RequestParam("uid") String uid) {
        return memberService.getInformation(uid);
    }

    @PostMapping("/modifyAvatar")
    public Response modifyAvatar(@RequestParam("image") MultipartFile imageObject, @RequestParam("uid") String uid) {
        return memberService.modifyAvatar(imageObject, uid);
    }

    @GetMapping("/getAddressList")
    public Response getAddressList(@RequestParam("uid") String uid) {
        return memberService.getAddressList(uid);
    }

    @PostMapping("/addAddress")
    public Response addAddress(@RequestBody AddAddressReq addAddressReq) {
        return memberService.addAddress(addAddressReq.getUid(), addAddressReq.getName(), addAddressReq.getGender(), addAddressReq.getLocation(),
                addAddressReq.getDetailAddress(), addAddressReq.getLng(), addAddressReq.getLat(), addAddressReq.getPhone());
    }

    @PostMapping("/modifyAddress")
    public Response modifyAddress(@RequestBody ModifyAddressReq modifyAddressReq) {
        return memberService.modifyAddress(modifyAddressReq.getUid(), modifyAddressReq.getAddressId(), modifyAddressReq.getName(),
                modifyAddressReq.getGender(), modifyAddressReq.getLocation(), modifyAddressReq.getDetailAddress(), modifyAddressReq.getLng(), modifyAddressReq.getLat(), modifyAddressReq.getPhone());
    }

    @PostMapping("/deleteAddress")
    public Response deleteAddress(@RequestBody DeleteAddressReq deleteAddressReq) {
        return memberService.deleteAddress(deleteAddressReq.getUid(), deleteAddressReq.getAddressId());
    }

    @PostMapping("/modifyPassword")
    public Response modifyPassword(@RequestBody ModPasswordReq modPasswordReq) {
        return memberService.modifyPassword(modPasswordReq.getUid(), modPasswordReq.getOldPassword(), modPasswordReq.getNewPassword());
    }

    @PostMapping("/makeOrder")
    public Response makeOrder(@RequestBody MakeOrderReq makeOrderReq) {
        return memberService.makeOrder(makeOrderReq.getUid(), makeOrderReq.getRid(), makeOrderReq.getAddressId(), makeOrderReq.getNumOfDinner(), makeOrderReq.getRemark(),makeOrderReq.getTotalPrice(), makeOrderReq.getFoods());
    }

    @PostMapping("/payOrder")
    public Response payOrder(@RequestBody PayOrderReq payOrderReq) {
        return memberService.payOrder(payOrderReq.getUid(), payOrderReq.getAccountId(), payOrderReq.getAccountPassword(), payOrderReq.getOid());
    }

    @GetMapping("/getOrderList")
    public Response getOrderList(@RequestParam("uid") String uid) {
        return memberService.getOrderList(uid);
    }

    @GetMapping("/getOrderDetail")
    public Response getOrderDetail(@RequestParam("uid") String uid,@RequestParam("oid") String oid) {
        return memberService.getOrderDetail(uid,oid);
    }

    @PostMapping("/cancelOrder")
    public Response cancelOrder(@RequestBody CancelOrderReq cancelOrderReq) {
        return memberService.cancelOrder(cancelOrderReq.getUid(), cancelOrderReq.getOid());
    }

    @PostMapping("/confirmOrder")
    public Response confirmOrder(@RequestBody ConfirmOrderReq confirmOrderReq) {
        return memberService.confirmOrder(confirmOrderReq.getUid(), confirmOrderReq.getOid());
    }

    @PostMapping("/evaluateOrder")
    public Response evaluateOrder(@RequestBody EvaluateOrderReq evaluateOrderReq) {
        return memberService.evaluateOrder(evaluateOrderReq.getUid(), evaluateOrderReq.getOid(),evaluateOrderReq.getPoint());
    }

    @GetMapping("/getDetailByTime")
    public Response getDetailByTime(@RequestParam("uid") String uid) {
        return memberService.getDetailByTime(uid);
    }

    @GetMapping("/getDetailByMoney")
    public Response getDetailByMoney(@RequestParam("uid") String uid) {
        return memberService.getDetailByMoney(uid);
    }

    @GetMapping("/getDetailByRestaurant")
    public Response getDetailByRestaurant(@RequestParam("uid") String uid) {
        return memberService.getDetailByRestaurant(uid);
    }

    @PostMapping("/verifyPassword")
    public Response verifyPassword(@RequestBody VerifyPasswordReq verifyPasswordReq) {
        return memberService.verifyPassword(verifyPasswordReq.getUid(), verifyPasswordReq.getPassword());
    }

    @GetMapping("/logOff")
    public Response logOff(@RequestParam("uid") String uid) {
        return memberService.logOff(uid);
    }

    @PostMapping("/collectRestaurant")
    public Response collectRestaurant(@RequestBody GetRestDetailReq restDetailReq) {
        return memberService.collectRestaurant(restDetailReq.getUid(),restDetailReq.getRid());
    }

    @PostMapping("/cancelCollectRestaurant")
    public Response cancelCollectRestaurant(@RequestBody GetRestDetailReq restDetailReq) {
        return memberService.cancelCollectRestaurant(restDetailReq.getUid(),restDetailReq.getRid());
    }

    @GetMapping("/getCollectRestaurantList")
    public Response getCollectRestaurantList(@RequestParam("uid") String uid,@RequestParam("city") String city,@RequestParam("lng") double lng,@RequestParam("lat") double lat){
        return memberService.getCollectRestaurantList(uid,city,lng,lat);
    }
}
