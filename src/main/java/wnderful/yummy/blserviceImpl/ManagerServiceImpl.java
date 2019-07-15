package wnderful.yummy.blserviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wnderful.yummy.blservice.ManagerService;
import wnderful.yummy.dataServiceImpl.ManagerDataServiceImpl;
import wnderful.yummy.dataServiceImpl.RestaurantDataServiceImpl;
import wnderful.yummy.response.ManagerResponse.*;
import wnderful.yummy.response.Response;
import wnderful.yummy.responseCode.managerResponseCode.*;
import wnderful.yummy.vo.managerVo.*;

@Service
public class ManagerServiceImpl implements ManagerService {
    private RestaurantDataServiceImpl restaurantDataService;
    private ManagerDataServiceImpl managerDataService;

    @Autowired
    public ManagerServiceImpl(RestaurantDataServiceImpl restaurantDataService, ManagerDataServiceImpl managerDataService) {
        this.restaurantDataService = restaurantDataService;
        this.managerDataService = managerDataService;
    }

    @Override
    public Response getApplyList() {
        GetApplyListVo vo = restaurantDataService.getApplyList();
        return new GetApplyListRes(GetApplyListCode.SUCCESS, vo);
    }

    @Override
    public Response approveApplication(String mid, String rid, String attitude) {
        if (managerDataService.managerMidExist(mid)) {
            if (restaurantDataService.restaurantApplicationRidExist(rid)) {
                switch (attitude) {
                    case "approve":
                        restaurantDataService.approveApplication(mid, rid);
                        return new ApproveApplicationRes(ApproveApplicationCode.SUCCESS);
                    case "refuse":
                        restaurantDataService.refuseApplication(mid, rid);
                        return new ApproveApplicationRes(ApproveApplicationCode.SUCCESS);
                    default:
                        return new ApproveApplicationRes(ApproveApplicationCode.FAIL);
                }
            } else {
                return new ApproveApplicationRes(ApproveApplicationCode.FAIL);
            }
        } else {
            return new ApproveApplicationRes(ApproveApplicationCode.NOTEXIST);
        }
    }

    @Override
    public Response getModifyList() {
        GetModifyListVo vo = restaurantDataService.getModifyList();
        return new GetModifyListRes(GetModifyListCode.SUCCESS, vo);
    }

    @Override
    public Response approveModification(String mid, String rid, String attitude) {
        if (managerDataService.managerMidExist(mid)) {
            if (restaurantDataService.restaurantModificationExist(rid)) {
                switch (attitude) {
                    case "approve":
                        restaurantDataService.approveModification(mid, rid);
                        return new ApproveModificationRes(ApproveModificationCode.SUCCESS);
                    case "refuse":
                        restaurantDataService.refuseModification(mid, rid);
                        return new ApproveModificationRes(ApproveModificationCode.SUCCESS);
                    default:
                        return new ApproveModificationRes(ApproveModificationCode.FAIL);
                }
            } else {
                return new ApproveModificationRes(ApproveModificationCode.FAIL);
            }
        } else {
            return new ApproveModificationRes(ApproveModificationCode.NOTEXIST);
        }
    }

    @Override
    public Response getRestaurantStatistics() {
        RestStatisticsVo vo = managerDataService.getRestStatistics();
        return new GetRestaurantStatisticsRes(GetStatisticsCode.SUCCESS, vo);
    }

    @Override
    public Response getMemberStatistics() {
        MemberStatisticsVo vo = managerDataService.getMemberStatistics();
        return new GetMemberStatisticsRes(GetStatisticsCode.SUCCESS, vo);
    }

    @Override
    public Response getFinancialStatistics() {
        FinancialStatisticsVo vo = managerDataService.getFinancialStatistic();
        return new GetFinancialStatisticsRes(GetStatisticsCode.SUCCESS, vo);
    }
}
