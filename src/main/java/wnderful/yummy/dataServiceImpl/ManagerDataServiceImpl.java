package wnderful.yummy.dataServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wnderful.yummy.dao.module.Manager;
import wnderful.yummy.dao.module.Member;
import wnderful.yummy.dao.module.Order;
import wnderful.yummy.dao.module.Restaurant;
import wnderful.yummy.dao.repository.ManagerRepository;
import wnderful.yummy.dao.repository.MemberRepository;
import wnderful.yummy.dao.repository.OrderRepository;
import wnderful.yummy.dao.repository.RestaurantRepository;
import wnderful.yummy.dataService.ManagerDataService;
import wnderful.yummy.util.SHAHelper;
import wnderful.yummy.vo.managerVo.FinancialStatisticsVo;
import wnderful.yummy.vo.managerVo.MemberStatisticsVo;
import wnderful.yummy.vo.managerVo.RestStatisticsVo;

import java.util.List;

@Service
public class ManagerDataServiceImpl implements ManagerDataService {
    private ManagerRepository managerRepository;
    private RestaurantRepository restaurantRepository;
    private MemberRepository memberRepository;
    private OrderRepository orderRepository;
    private RestaurantStateDataServiceImpl restaurantStateDataService;
    private MemberStateDataServiceImpl memberStateDataService;
    private OrderStateDataServiceImpl orderStateDataService;

    @Autowired
    public ManagerDataServiceImpl(ManagerRepository managerRepository, RestaurantRepository restaurantRepository,
                                  MemberRepository memberRepository, OrderRepository orderRepository, RestaurantStateDataServiceImpl restaurantStateDataService, MemberStateDataServiceImpl memberStateDataService, OrderStateDataServiceImpl orderStateDataService) {
        this.managerRepository = managerRepository;
        this.restaurantRepository = restaurantRepository;
        this.memberRepository = memberRepository;
        this.orderRepository = orderRepository;
        this.restaurantStateDataService = restaurantStateDataService;
        this.memberStateDataService = memberStateDataService;
        this.orderStateDataService = orderStateDataService;
        if(managerRepository.findAll().size()==0){
            managerRepository.save(new Manager((long) 1,"default@163.com","default",SHAHelper.getResult("123456")));
        }
    }

    @Override
    public boolean verifyPassword(String email, String password) {
        Manager manager = managerRepository.findByEmail(email);
        assert manager!=null;
        String truePassword = manager.getPassword();
        String encryptPassword = SHAHelper.getResult(password);
        return encryptPassword.equals(truePassword);
    }

    @Override
    public boolean managerEmailExist(String email) {
        return managerRepository.findByEmail(email)!=null;
    }

    @Override
    public boolean managerMidExist(String mid) {
        return managerRepository.findByMid(Long.parseLong(mid))!=null;
    }

    @Override
    public RestStatisticsVo getRestStatistics() {
        List<Restaurant> restaurantList = restaurantRepository.findByRestaurantState(restaurantStateDataService.getNormalRestState());
        List<Restaurant> applicationList = restaurantRepository.findByRestaurantState(restaurantStateDataService.getExamineRestState());
        return new RestStatisticsVo(restaurantList.size(),applicationList.size());
    }

    @Override
    public MemberStatisticsVo getMemberStatistics() {
        List<Member> memberList = memberRepository.findByMemberState(memberStateDataService.getNormalState());
        List<Member> cancelList = memberRepository.findByMemberState(memberStateDataService.getCancelState());
        return new MemberStatisticsVo(memberList.size(),cancelList.size());
    }

    @Override
    public FinancialStatisticsVo getFinancialStatistic() {
        List<Order> orderList = orderRepository.findByOrderState(orderStateDataService.getDoneOrderState());
        double turnover = 0;
        for(Order order:orderList){
            turnover+=order.getTotalPrice();
        }
        return new FinancialStatisticsVo(orderList.size(),turnover);
    }

    @Override
    public String getMid(String email) {
        Manager manager = managerRepository.findByEmail(email);
        assert manager!=null;
        return Long.toString(manager.getMid());
    }

    @Override
    public String getManagerName(String mid) {
        Manager manager = managerRepository.findByMid(Long.parseLong(mid));
        assert manager!=null;
        return manager.getName();
    }
}
