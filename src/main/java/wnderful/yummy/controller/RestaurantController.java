package wnderful.yummy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wnderful.yummy.blserviceImpl.RestaurantServiceImpl;
import wnderful.yummy.request.restaurantRequest.*;
import wnderful.yummy.response.Response;

@RestController
@RequestMapping(value = "/service/restaurant")
public class RestaurantController {
    private final RestaurantServiceImpl restaurantService;

    @Autowired
    public RestaurantController(RestaurantServiceImpl restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/getInformation")
    public Response getInformation(@RequestParam("rid") String rid) {
        return restaurantService.getInformation(rid);
    }

    @GetMapping("/getDetail")
    public Response getDetail(@RequestParam("rid") String rid) {
        return restaurantService.getDetail(rid);
    }

    @PostMapping("/modifyInformation")
    public Response modifyInformation(@RequestBody ModRestInfoReq modRestInfoReq) {
        return restaurantService.modifyInformation(modRestInfoReq.getRid(),modRestInfoReq.getNewName(), modRestInfoReq.getNewPhone(),
                modRestInfoReq.getNewAddress(),modRestInfoReq.getNewAccountId(),modRestInfoReq.getNewType(),
                modRestInfoReq.getNewAnnouncement(),modRestInfoReq.getNewPicture());
    }

    @PostMapping("/newFood")
    public Response newFood(@RequestBody NewFoodReq newFoodReq) {
       return restaurantService.newFood(newFoodReq.getRid(),newFoodReq.getFoodName(),newFoodReq.getAnnouncement(),newFoodReq.getPrice(),
               newFoodReq.getPackagePrice(),newFoodReq.getNumber(),newFoodReq.getPicture(),newFoodReq.getType());
    }

    @PostMapping("/newDiscount")
    public Response newDiscount(@RequestBody NewDiscountReq newDiscountReq) {
        return restaurantService.newDiscount(newDiscountReq.getRid(),newDiscountReq.getTotalDiscount(),
                newDiscountReq.getFullReductions());
    }

    @PostMapping("/modifyFood")
    public Response modifyFood(@RequestBody ModFoodReq modFoodReq) {
        return restaurantService.modifyFood(modFoodReq.getRid(),modFoodReq.getFid(),modFoodReq.getNewFoodName(),
                modFoodReq.getNewAnnouncement(),modFoodReq.getNewPrice(),modFoodReq.getNewPackagePrice(),modFoodReq.getNewNumber(),
                modFoodReq.getPicture(),modFoodReq.getType());
    }

    @PostMapping("/deleteFood")
    public Response deleteFood(@RequestBody DeleteFoodReq deleteFoodReq) {
        return restaurantService.deleteFood(deleteFoodReq.getRid(),deleteFoodReq.getFid());
    }

    @GetMapping("/getOrderList")
    public Response getOrderList(@RequestParam("rid") String rid) {
        return restaurantService.getOrderList(rid);
    }

    @GetMapping("/getDetailByTime")
    public Response getDetailByTime(@RequestParam("rid") String rid) {
        return restaurantService.getDetailByTime(rid);
    }

    @GetMapping("/getDetailByFood")
    public Response getDetailByFood(@RequestParam("rid") String rid) {
        return restaurantService.getDetailByFood(rid);
    }

    @GetMapping("/getDetailByMember")
    public Response getDetailByMember(@RequestParam("rid") String rid) {
        return restaurantService.getDetailByMember(rid);
    }
}
