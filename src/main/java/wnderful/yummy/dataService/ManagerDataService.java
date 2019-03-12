package wnderful.yummy.dataService;

import wnderful.yummy.vo.managerVo.FinancialStatisticsVo;
import wnderful.yummy.vo.managerVo.MemberStatisticsVo;
import wnderful.yummy.vo.managerVo.RestStatisticsVo;

public interface ManagerDataService {
    boolean verifyPassword(String email,String password);

    boolean managerEmailExist(String email);

    boolean managerMidExist(String mid);

    String getMid(String email);

    String getManagerName(String mid);

    RestStatisticsVo getRestStatistics();

    MemberStatisticsVo getMemberStatistics();

    FinancialStatisticsVo getFinancialStatistic();
}
