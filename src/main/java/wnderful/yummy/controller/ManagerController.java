package wnderful.yummy.controller;

import org.springframework.web.bind.annotation.*;
import wnderful.yummy.blserviceImpl.ManagerServiceImpl;
import wnderful.yummy.request.managerRequest.ApproveAppReq;
import wnderful.yummy.request.managerRequest.ApproveModReq;
import wnderful.yummy.response.Response;

@RestController
@RequestMapping(value = "/service/manager")
public class ManagerController {
    private final ManagerServiceImpl managerService;

    public ManagerController(ManagerServiceImpl managerService) {
        this.managerService = managerService;
    }

    @PostMapping("/approveModification")
    public Response approveModification(@RequestBody ApproveModReq approveModReq){
        return managerService.approveModification(approveModReq.getMid(),approveModReq.getRid(),approveModReq.getAttitude());
    }

    @PostMapping("/approveApplication")
    public Response approveApplication(@RequestBody ApproveAppReq approveAppReq){
        return managerService.approveApplication(approveAppReq.getMid(),approveAppReq.getRid(),approveAppReq.getAttitude());
    }

    @GetMapping("/getApplyList")
    public Response getApplyList() {
        return managerService.getApplyList();
    }

    @GetMapping("/getModifyList")
    public Response getModifyList() {
        return managerService.getModifyList();
    }

    @GetMapping("/getRestaurantStatistics")
    public Response getRestaurantStatistics() {
        return managerService.getRestaurantStatistics();
    }

    @GetMapping("/getMemberStatistics")
    public Response getMemberStatistics() {
        return managerService.getMemberStatistics();
    }

    @GetMapping("/getFinancialStatistics")
    public Response getFinancialStatistics() {
        return managerService.getFinancialStatistics();
    }
}
