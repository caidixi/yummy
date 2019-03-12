package wnderful.yummy.blservice;

import wnderful.yummy.response.Response;

public interface ManagerService {
    Response getApplyList();

    Response approveApplication(String mid,String rid,String attitude);

    Response getModifyList();

    Response approveModification(String mid,String rid,String attitude);

    Response getRestaurantStatistics();

    Response getMemberStatistics();

    Response getFinancialStatistics();
}
