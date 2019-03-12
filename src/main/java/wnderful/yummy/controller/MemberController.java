package wnderful.yummy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    public Response login(@RequestParam("uid") String uid) {
        return memberService.getInformation(uid);
    }

    @PostMapping("/modifyInformation")
    public Response modifyInformation(@RequestBody ModMemberInfoReq modMemberInfoReq) {
        return memberService.modifyInformation(modMemberInfoReq.getUid(), modMemberInfoReq.getNewName(),modMemberInfoReq.getNewPhone(),
                modMemberInfoReq.getAddress1(), modMemberInfoReq.getAddress2(), modMemberInfoReq.getAddress3());
    }

    @PostMapping("/modifyPassword")
    public Response modifyPassword(@RequestBody ModPasswordReq modPasswordReq) {
        return memberService.modifyPassword(modPasswordReq.getUid(), modPasswordReq.getOldPassword(), modPasswordReq.getNewPassword());
    }

    @GetMapping("/getRestaurantList")
    public Response getRestaurantList(@RequestParam("uid") String uid) {
        return memberService.getRestaurantList(uid);
    }

    @PostMapping("/getRestaurantDetail")
    public Response getRestaurantDetail(@RequestBody GetRestDetailReq getRestDetailReq) {
        return memberService.getRestaurantDetail(getRestDetailReq.getUid(), getRestDetailReq.getRid());
    }

    @PostMapping("/makeOrder")
    public Response makeOrder(@RequestBody MakeOrderReq makeOrderReq) {
        return memberService.makeOrder(makeOrderReq.getUid(), makeOrderReq.getRid(), makeOrderReq.getAddress(), makeOrderReq.getNumOfDinner(),makeOrderReq.getRemark(), makeOrderReq.getFoods());
    }

    @PostMapping("/payOrder")
    public Response payOrder(@RequestBody PayOrderReq payOrderReq) {
        return memberService.payOrder(payOrderReq.getUid(),payOrderReq.getAccountId(),payOrderReq.getAccountPassword(), payOrderReq.getOid());
    }

    @GetMapping("/getOrderList")
    public Response getOrderList(@RequestParam("uid") String uid) {
        return memberService.getOrderList(uid);
    }

    @PostMapping("/getOrderDetail")
    public Response getOrderDetail(@RequestBody GetOrderDetailReq getOrderDetailReq) {
        return memberService.getOrderDetail(getOrderDetailReq.getUid(), getOrderDetailReq.getOid());
    }

    @PostMapping("/cancelOrder")
    public Response cancelOrder(@RequestBody CancelOrderReq cancelOrderReq) {
        return memberService.cancelOrder(cancelOrderReq.getUid(), cancelOrderReq.getOid());
    }

    @PostMapping("/confirmOrder")
    public Response confirmOrder(@RequestBody ConfirmOrderReq confirmOrderReq) {
        return memberService.confirmOrder(confirmOrderReq.getUid(), confirmOrderReq.getOid());
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
}
