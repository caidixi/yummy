package wnderful.yummy.blserviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import wnderful.yummy.blservice.MemberService;
import wnderful.yummy.dataService.MemberRestaurantDataService;
import wnderful.yummy.dataServiceImpl.*;
import wnderful.yummy.entity.FoodOrder;
import wnderful.yummy.response.ManagerAddressResponse.AddAddressRes;
import wnderful.yummy.response.ManagerAddressResponse.DeleteAddressRes;
import wnderful.yummy.response.ManagerAddressResponse.GetAddressListRes;
import wnderful.yummy.response.ManagerAddressResponse.ModifyAddressRes;
import wnderful.yummy.response.MemberResponse.*;
import wnderful.yummy.response.Response;
import wnderful.yummy.responseCode.memberAddressResponseCode.AddAddressResCode;
import wnderful.yummy.responseCode.memberAddressResponseCode.DeleteAddressResCode;
import wnderful.yummy.responseCode.memberAddressResponseCode.GetAddressListResCode;
import wnderful.yummy.responseCode.memberAddressResponseCode.ModifyAddressResCode;
import wnderful.yummy.responseCode.memberResponseCode.*;
import wnderful.yummy.vo.memberVo.MemGetOrderListVo;
import wnderful.yummy.vo.memberVo.*;

import java.io.IOException;

@Service
public class MemberServiceImpl implements MemberService {

    private MemberDataServiceImpl memberDataService;
    private RestaurantDataServiceImpl restaurantDataService;
    private FoodDataServiceImpl foodDataService;
    private OrderDataServiceImpl orderDataService;
    private AccountDataServiceImpl accountDataService;
    private RestaurantFoodDataServiceImpl restaurantFoodDataService;
    private MemberOrderDataServiceImpl memberOrderDataService;
    private MemberRestaurantDataService memberRestaurantDataService;

    @Autowired
    public MemberServiceImpl(MemberDataServiceImpl memberDataService, RestaurantDataServiceImpl restaurantDataService,
                             FoodDataServiceImpl foodDataService, OrderDataServiceImpl orderDataService,
                             AccountDataServiceImpl accountDataService, RestaurantFoodDataServiceImpl restaurantFoodDataService,
                             MemberOrderDataServiceImpl memberOrderDataService,MemberRestaurantDataService memberRestaurantDataService) {
        this.memberDataService = memberDataService;
        this.restaurantDataService = restaurantDataService;
        this.foodDataService = foodDataService;
        this.orderDataService = orderDataService;
        this.accountDataService = accountDataService;
        this.restaurantFoodDataService = restaurantFoodDataService;
        this.memberOrderDataService = memberOrderDataService;
        this.memberRestaurantDataService = memberRestaurantDataService;
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
    public Response modifyAvatar(MultipartFile image, String uid) {
        if (memberDataService.memberUidExist(uid)) {
            if (!memberDataService.memberIsCancel(uid)) {
                try{
                    memberDataService.modMemberAvatar(image,uid);
                    return new ModifyAvatarRes(ModifyAvatarCode.SUCCESS);
                }catch (IOException ex){
                    ex.printStackTrace();
                    return new ModifyAvatarRes(ModifyAvatarCode.FAIL);
                }
            } else {
                return new ModifyAvatarRes(ModifyAvatarCode.NOTEXIST);
            }
        } else {
            return new ModifyAvatarRes(ModifyAvatarCode.NOTEXIST);
        }
    }

    @Override
    public Response getAddressList(String uid) {
        if (memberDataService.memberUidExist(uid)) {
            if (!memberDataService.memberIsCancel(uid)) {
                GetAddressListVo vo = memberDataService.getMemberAddressList(uid);
                return new GetAddressListRes(GetAddressListResCode.SUCCESS, vo);
            } else {
                return new GetAddressListRes(GetAddressListResCode.FAIL);
            }
        } else {
            return new GetAddressListRes(GetAddressListResCode.FAIL);
        }
    }

    @Override
    public Response addAddress(String uid, String name, String gender, String location, String detailAddress, double lng, double lat, String phone) {
        if (memberDataService.memberUidExist(uid)) {
            if (!memberDataService.memberIsCancel(uid)) {
                long addressId = memberDataService.newMemberAddress(uid, name, gender, location, detailAddress, lng, lat, phone);
                return new AddAddressRes(AddAddressResCode.SUCCESS,new AddressIdVo(addressId));
            } else {
                return new AddAddressRes(AddAddressResCode.FAIL);
            }
        } else {
            return new AddAddressRes(AddAddressResCode.FAIL);
        }
    }

    @Override
    public Response modifyAddress(String uid, String addressId, String name, String gender, String location, String detailAddress, double lng, double lat, String phone) {
        if (memberDataService.memberUidExist(uid)) {
            if (!memberDataService.memberIsCancel(uid)) {
                if (memberDataService.memberAddressExist(uid, addressId)) {
                    memberDataService.modMemberAddress(addressId, name, gender, location, detailAddress, lng, lat, phone);
                    return new ModifyAddressRes(ModifyAddressResCode.SUCCESS);
                } else {
                    return new ModifyAddressRes(ModifyAddressResCode.FAIL);
                }
            } else {
                return new ModifyAddressRes(ModifyAddressResCode.FAIL);
            }
        } else {
            return new ModifyAddressRes(ModifyAddressResCode.FAIL);
        }
    }

    @Override
    public Response deleteAddress(String uid, String addressId) {
        if (memberDataService.memberUidExist(uid)) {
            if (!memberDataService.memberIsCancel(uid)) {
                if (memberDataService.memberAddressExist(uid, addressId)) {
                    memberDataService.deleteMemberAddress(addressId);
                    return new DeleteAddressRes(DeleteAddressResCode.SUCCESS);
                } else {
                    return new DeleteAddressRes(DeleteAddressResCode.FAIL);
                }
            } else {
                return new DeleteAddressRes(DeleteAddressResCode.FAIL);
            }
        } else {
            return new DeleteAddressRes(DeleteAddressResCode.FAIL);
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
    public Response getRestaurantList(String type,String city,double lng,double lat) {
        GetRestListVo vo = restaurantDataService.getRestaurantList( type, city, lng, lat);
        return new GetRestaurantListRes(GetRestaurantListCode.SUCCESS, vo);
    }

    @Override
    public Response searchRestaurantByName(String name, String city, double lng, double lat) {
        GetRestListVo vo = restaurantDataService.searchRestaurantByName( name, city, lng, lat);
        return new GetRestaurantListRes(GetRestaurantListCode.SUCCESS, vo);
    }

    @Override
    public Response searchFoodByName(String name, String city, double lng, double lat) {
        SearchFoodVo vo = restaurantFoodDataService.searchFoodByName(name,city,lng,lat);
        return new SearchFoodRes(SearchFoodCode.SUCCESS,vo);
    }

    @Override
    public Response getRestaurantDetail( String rid) {
        if (restaurantDataService.restaurantRidExist(rid)) {
            GetRestDetailVo vo = restaurantFoodDataService.getRestaurantDetailFromMember(rid);
            return new GetRestDetailRes(GetRestDetailCode.SUCCESS, vo);
        } else {
            return new GetRestDetailRes(GetRestDetailCode.RESTNOTEXIST);
        }
    }

    @Override
    public Response makeOrder(String uid, String rid, String addressId, int numberOfDinner, String remark,double totalPrice, FoodOrder[] foodOrders) {
        if (memberDataService.memberUidExist(uid)) {
            if (!memberDataService.memberIsCancel(uid)) {
                if (memberDataService.memberAddressExist(uid,addressId)) {
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
                                String oid = orderDataService.makeOrder(uid, rid, addressId, numberOfDinner, remark,totalPrice, foodOrders);
                                if(!oid.equals("")){
                                    return new MakeOrderRes(MakeOrderCode.SUCCESS,new MakeOrderVo(oid));
                                }else{
                                    return new MakeOrderRes(MakeOrderCode.MONEYERROR);
                                }
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
    public Response payOrder(String uid, String accountId, String accountPassword, String oid) {
        if (memberDataService.memberUidExist(uid)) {
            if (orderDataService.orderIsUnpaid(oid)) {
                if (!orderDataService.orderIsOvertime(oid)) {
                    if (accountDataService.accountExist(accountId)) {
                        if (memberOrderDataService.orderCanPay(oid, accountId)) {
                            if (accountDataService.checkPassword(accountId, accountPassword)) {
                                memberOrderDataService.payOrder(accountId, oid);
                                return new PayOrderRes(PayOrderCode.SUCCESS);
                            } else {
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
                if (orderDataService.orderIsUnpaid(oid) || orderDataService.orderIsPaid(oid)) {
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
                    orderDataService.confirmOrder(uid, oid);
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
    public Response evaluateOrder(String uid, String oid, int point) {
        if (orderDataService.orderExist(oid)) {
            if (orderDataService.orderIsFromMember(oid,uid)) {
                if (orderDataService.orderIsDone(oid)) {
                    orderDataService.evaluateOrder(oid,point);
                    return new EvaluateOrderRes(EvaluateOrderCode.SUCCESS);
                } else {
                    return new EvaluateOrderRes(EvaluateOrderCode.FAIL);
                }
            } else {
                return new EvaluateOrderRes(EvaluateOrderCode.CANTEVALUATE);
            }
        } else {
            return new EvaluateOrderRes(EvaluateOrderCode.NOTEXIST);
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

    @Override
    public Response collectRestaurant(String uid, String rid) {
        if(memberDataService.memberUidExist(uid)&&restaurantDataService.restaurantRidExist(rid)){
            memberRestaurantDataService.addRestaurantCollection(uid,rid);
            return new AddCollectionRes(AddCollectionResCode.SUCCESS);
        }else{
            return new AddCollectionRes(AddCollectionResCode.FAIL);
        }
    }

    @Override
    public Response cancelCollectRestaurant(String uid, String rid) {
        if(memberDataService.memberUidExist(uid)&&restaurantDataService.restaurantRidExist(rid)){
            memberRestaurantDataService.cancelRestaurantCollection(uid,rid);
            return new DeleteCollectionRes(DeleteCollectionResCode.SUCCESS);
        }else{
            return new DeleteCollectionRes(DeleteCollectionResCode.FAIL);
        }
    }

    @Override
    public Response getCollectRestaurantList(String uid, String city, double lng, double lat) {
        if(memberDataService.memberUidExist(uid)){
           GetRestListVo vo =  memberRestaurantDataService.getCollectRestaurant(uid,city,lng,lat);
            return new GetCollectionListRes(GetCollectionListResCode.SUCCESS,vo);
        }else{
            return new GetCollectionListRes(GetCollectionListResCode.FAIL);
        }
    }
}
