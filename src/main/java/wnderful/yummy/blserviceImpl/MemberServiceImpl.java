package wnderful.yummy.blserviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wnderful.yummy.blservice.MemberService;
import wnderful.yummy.dataServiceImpl.*;
import wnderful.yummy.entity.FoodOrder;
import wnderful.yummy.response.MemberResponse.*;
import wnderful.yummy.response.Response;
import wnderful.yummy.responseCode.memberResponseCode.*;
import wnderful.yummy.vo.memberVo.MemGetOrderListVo;
import wnderful.yummy.vo.memberVo.*;

@Service
public class MemberServiceImpl implements MemberService {

    private MemberDataServiceImpl memberDataService;
    private RestaurantDataServiceImpl restaurantDataService;
    private FoodDataServiceImpl foodDataService;
    private OrderDataServiceImpl orderDataService;
    private AccountDataServiceImpl accountDataService;
    private RestaurantFoodDataServiceImpl restaurantFoodDataService;
    private MemberOrderDataServiceImpl memberOrderDataService;

    @Autowired
    public MemberServiceImpl(MemberDataServiceImpl memberDataService, RestaurantDataServiceImpl restaurantDataService,
                             FoodDataServiceImpl foodDataService, OrderDataServiceImpl orderDataService,
                             AccountDataServiceImpl accountDataService, RestaurantFoodDataServiceImpl restaurantFoodDataService,
                             MemberOrderDataServiceImpl memberOrderDataService) {
        this.memberDataService = memberDataService;
        this.restaurantDataService = restaurantDataService;
        this.foodDataService = foodDataService;
        this.orderDataService = orderDataService;
        this.accountDataService = accountDataService;
        this.restaurantFoodDataService = restaurantFoodDataService;
        this.memberOrderDataService = memberOrderDataService;
    }

    @Override
    public Response getInformation(String uid) {
        if (memberDataService.memberUidExist(uid)) {
            if (!memberDataService.memberIsCancel(uid)) {
                GetMemInfoVo infoVo = memberDataService.getMemInfo(uid);
                return new GetMemInfoRes(GetMemberInfoCode.SUCCESS, infoVo);
            } else {
                return new GetMemInfoRes(GetMemberInfoCode.CANCEL);
            }
        } else {
            return new GetMemInfoRes(GetMemberInfoCode.NOTEXIST);
        }
    }

    @Override
    public Response modifyInformation(String uid, String newName, String newPhone, String address1, String address2, String address3) {
        if (memberDataService.memberUidExist(uid)) {
            if (!memberDataService.memberIsCancel(uid)) {
                if (!(address1.equals("") || newName.equals(""))) {
                    memberDataService.modMemInfo(uid, newName, newPhone, address1, address2, address3);
                    return new ModMemInfoRes(ModMemberInfoCode.SUCCESS);
                } else {
                    return new ModMemInfoRes(ModMemberInfoCode.EMPTYADDRESS);
                }
            } else {
                return new ModMemInfoRes(ModMemberInfoCode.CANCEL);
            }
        } else {
            return new ModMemInfoRes(ModMemberInfoCode.NOTEXIST);
        }
    }

    @Override
    public Response modifyPassword(String uid, String oldPassword, String newPassword) {
        if (memberDataService.memberUidExist(uid)) {
            if (!memberDataService.memberIsCancel(uid)) {
                if (!(oldPassword.equals("") || newPassword.equals(""))) {
                    if (!oldPassword.equals(newPassword)) {
                        if (memberDataService.verifyPasswordByUid(uid, oldPassword)) {
                            memberDataService.modMemPassword(uid, newPassword);
                            return new ModPasswordRes(ModPasswordCode.SUCCESS);
                        } else {
                            return new ModPasswordRes(ModPasswordCode.WRONG);
                        }
                    } else {
                        return new ModPasswordRes(ModPasswordCode.REPEAT);
                    }
                } else {
                    return new ModPasswordRes(ModPasswordCode.EMPTY);
                }
            } else {
                return new ModPasswordRes(ModPasswordCode.CANCEL);
            }
        } else {
            return new ModPasswordRes(ModPasswordCode.NOTEXIST);
        }
    }

    @Override
    public Response getRestaurantList(String uid) {
        GetRestListVo vo = restaurantDataService.getRestaurantList(uid);
        return new GetRestaurantListRes(GetRestaurantListCode.SUCCESS, vo);
    }

    @Override
    public Response getRestaurantDetail(String uid, String rid) {
        if (memberDataService.memberUidExist(uid)) {
            if (restaurantDataService.restaurantRidExist(rid)) {
                GetRestDetailVo vo = restaurantFoodDataService.getRestaurantDetailFromMember(rid);
                return new GetRestDetailRes(GetRestDetailCode.SUCCESS, vo);
            } else {
                return new GetRestDetailRes(GetRestDetailCode.RESTNOTEXIST);
            }
        } else {
            return new GetRestDetailRes(GetRestDetailCode.NOTEXIST);
        }
    }

    @Override
    public Response makeOrder(String uid, String rid, String address, int numberOfDinner, String remark, FoodOrder[] foodOrders) {
        if (memberDataService.memberUidExist(uid)) {
            if (!memberDataService.memberIsCancel(uid)) {
                if (!address.equals("")) {
                    if (restaurantDataService.restaurantRidExist(rid)) {
                        boolean foodExist = true;
                        boolean foodEnough = true;
                        for (FoodOrder foodOrder : foodOrders) {
                            if (!foodDataService.foodExist(foodOrder.getFid())) {
                                foodExist = false;
                                break;
                            } else {
                                if (!foodDataService.foodEnough(foodOrder.getFid(), foodOrder.getNumber())) {
                                    foodEnough = false;
                                    break;
                                }
                            }
                        }
                        if (foodExist) {
                            if (foodEnough) {
                                MakeOrderVo vo = orderDataService.makeOrder(uid, rid, address, numberOfDinner, remark, foodOrders);
                                return new MakeOrderRes(MakeOrderCode.SUCCESS, vo);
                            } else {
                                return new MakeOrderRes(MakeOrderCode.FULL);
                            }
                        } else {
                            return new MakeOrderRes(MakeOrderCode.FOODNOTEXIST);
                        }
                    } else {
                        return new MakeOrderRes(MakeOrderCode.RESTNOTEXIST);
                    }
                } else {
                    return new MakeOrderRes(MakeOrderCode.EMPTYADDRESS);
                }
            } else {
                return new MakeOrderRes(MakeOrderCode.CANCEL);
            }
        } else {
            return new MakeOrderRes(MakeOrderCode.NOTEXIST);
        }
    }

    @Override
    public Response payOrder(String uid, String accountId,String accountPassword, String oid) {
        if (memberDataService.memberUidExist(uid)) {
            if (orderDataService.orderIsUnpaid(oid)) {
                if (!orderDataService.orderIsOvertime(oid)) {
                    if (accountDataService.accountExist(accountId)) {
                        if (memberOrderDataService.orderCanPay(oid,accountId)) {
                            if(accountDataService.checkPassword(accountId,accountPassword)){
                                memberOrderDataService.payOrder(accountId, oid);
                                return new PayOrderRes(PayOrderCode.SUCCESS);
                            }else {
                                return new PayOrderRes(PayOrderCode.WRONGPASSSWORD);
                            }
                        } else {
                            return new PayOrderRes(PayOrderCode.NOBALANCE);
                        }
                    } else {
                        return new PayOrderRes(PayOrderCode.NOACCOUNT);
                    }
                } else {
                    orderDataService.cancelOrder(oid);
                    return new PayOrderRes(PayOrderCode.OVERTIME);
                }
            } else {
                return new PayOrderRes(PayOrderCode.FAIL);
            }
        } else {
            return new PayOrderRes(PayOrderCode.NOTEXIST);
        }
    }

    @Override
    public Response getOrderList(String uid) {
        if (memberDataService.memberUidExist(uid)) {
            if (!memberDataService.memberIsCancel(uid)) {
                MemGetOrderListVo vo = orderDataService.getMemOrderList(uid);
                return new GetOrderListRes(GetOrderListCode.SUCCESS, vo);
            } else {
                return new GetOrderListRes(GetOrderListCode.CANCEL);
            }
        } else {
            return new GetOrderListRes(GetOrderListCode.NOTEXIST);
        }
    }

    @Override
    public Response getOrderDetail(String uid, String oid) {
        if (memberDataService.memberUidExist(uid)) {
            if (!memberDataService.memberIsCancel(uid)) {
                if (orderDataService.orderExist(oid)) {
                    GetOrderDetailVo vo = orderDataService.getOrderDetail(oid);
                    return new GetOrderDetailRes(GetOrderDetailCode.SUCCESS, vo);
                } else {
                    return new GetOrderDetailRes(GetOrderDetailCode.ORDERNOTEXIST);
                }
            } else {
                return new GetOrderDetailRes(GetOrderDetailCode.CANCEL);
            }
        } else {
            return new GetOrderDetailRes(GetOrderDetailCode.NOTEXIST);
        }
    }

    @Override
    public Response cancelOrder(String uid, String oid) {
        if (memberDataService.memberUidExist(uid)) {
            if (!memberDataService.memberIsCancel(uid)) {
                if (orderDataService.orderIsUnpaid(oid)||orderDataService.orderIsPaid(oid)) {
                    orderDataService.cancelOrder(oid);
                    return new CancelOrderRes(CancelOrderCode.SUCCESS);
                } else {
                    return new CancelOrderRes(CancelOrderCode.HASCANCEL);
                }
            } else {
                return new CancelOrderRes(CancelOrderCode.CANCEL);
            }
        } else {
            return new CancelOrderRes(CancelOrderCode.NOTEXIST);
        }
    }

    @Override
    public Response confirmOrder(String uid, String oid) {
        if (memberDataService.memberUidExist(uid)) {
            if (!memberDataService.memberIsCancel(uid)) {
                if (orderDataService.orderIsPaid(oid)) {
                    orderDataService.confirmOrder(uid,oid);
                    return new ConfirmOrderRes(ConfirmOrderCode.SUCCESS);
                } else {
                    return new ConfirmOrderRes(ConfirmOrderCode.FAIL);
                }
            } else {
                return new ConfirmOrderRes(ConfirmOrderCode.CANCEL);
            }
        } else {
            return new ConfirmOrderRes(ConfirmOrderCode.NOTEXIST);
        }
    }

    @Override
    public Response getDetailByTime(String uid) {
        if (memberDataService.memberUidExist(uid)) {
            if (!memberDataService.memberIsCancel(uid)) {
                MemDetailByTimeVo vo = orderDataService.getMemDetailByTime(uid);
                return new GetDetailByTimeRes(GetDetailByTimeCode.SUCCESS, vo);
            } else {
                return new GetDetailByTimeRes(GetDetailByTimeCode.CANCEL);
            }
        } else {
            return new GetDetailByTimeRes(GetDetailByTimeCode.NOTEXIST);
        }
    }

    @Override
    public Response getDetailByMoney(String uid) {
        if (memberDataService.memberUidExist(uid)) {
            if (!memberDataService.memberIsCancel(uid)) {
                MemDetailByMoneyVo vo = orderDataService.getMemDetailByMoney(uid);
                return new GetDetailByMoneyRes(GetDetailByMoneyCode.SUCCESS, vo);
            } else {
                return new GetDetailByMoneyRes(GetDetailByMoneyCode.CANCEL);
            }
        } else {
            return new GetDetailByMoneyRes(GetDetailByMoneyCode.NOTEXIST);
        }
    }

    @Override
    public Response getDetailByRestaurant(String uid) {
        if (memberDataService.memberUidExist(uid)) {
            if (!memberDataService.memberIsCancel(uid)) {
                MemDetailByRestaurantVo vo = orderDataService.getMemDetailByRestaurant(uid);
                return new GetDetailByRestaurantRes(GetDetailByRestaurantCode.SUCCESS, vo);
            } else {
                return new GetDetailByRestaurantRes(GetDetailByRestaurantCode.CANCEL);
            }
        } else {
            return new GetDetailByRestaurantRes(GetDetailByRestaurantCode.NOTEXIST);
        }
    }

    @Override
    public Response verifyPassword(String uid, String password) {
        if (memberDataService.memberUidExist(uid)) {
            if (!memberDataService.memberIsCancel(uid)) {
                if (memberDataService.verifyPasswordByUid(uid, password)) {
                    return new VerifyPasswordRes(VerifyPasswordCode.SUCCESS, new VerifyPasswordVo("correct"));
                } else {
                    return new VerifyPasswordRes(VerifyPasswordCode.FAIL);
                }
            } else {
                return new VerifyPasswordRes(VerifyPasswordCode.CANCEL);
            }
        } else {
            return new VerifyPasswordRes(VerifyPasswordCode.NOTEXIST);
        }
    }

    @Override
    public Response logOff(String uid) {
        if (memberDataService.memberUidExist(uid)) {
            if (memberDataService.memberIsCancel(uid)) {
                return new LogOffRes(LogOffCode.CANCEL);
            } else {
                memberDataService.memberLogOff(uid);
                return new LogOffRes(LogOffCode.SUCCESS);
            }
        } else {
            return new LogOffRes(LogOffCode.NOTEXIST);
        }
    }
}
