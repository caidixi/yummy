package wnderful.yummy.dataServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wnderful.yummy.dao.module.*;
import wnderful.yummy.dao.repository.MemberRepository;
import wnderful.yummy.dao.repository.RestaurantCollectionRepository;
import wnderful.yummy.dao.repository.RestaurantRepository;
import wnderful.yummy.dataService.MemberRestaurantDataService;
import wnderful.yummy.entity.voEntity.RestDetail;
import wnderful.yummy.util.LocationHelper;
import wnderful.yummy.vo.memberVo.GetRestListVo;

import java.util.List;

@Service
public class MemberRestaurantDataServiceImpl implements MemberRestaurantDataService {
    private MemberRepository memberRepository;
    private RestaurantRepository restaurantRepository;
    private RestaurantCollectionRepository restaurantCollectionRepository;


    @Autowired
    public MemberRestaurantDataServiceImpl(MemberRepository memberRepository, RestaurantRepository restaurantRepository,
                                           RestaurantCollectionRepository restaurantCollectionRepository) {
        this.memberRepository = memberRepository;
        this.restaurantRepository = restaurantRepository;
        this.restaurantCollectionRepository = restaurantCollectionRepository;
    }

    @Override
    public void addRestaurantCollection(String uid, String rid) {
        Member member = memberRepository.findMemberByUid(Long.parseLong(uid));
        Restaurant restaurant = restaurantRepository.findRestaurantByRid(rid);
        assert member!=null&&restaurant!=null;
        if(restaurantCollectionRepository.findByRestaurantAndMember(restaurant,member)==null){
            RestaurantCollection collection = new RestaurantCollection(restaurant,member);
            restaurantCollectionRepository.save(collection);
        }
    }

    @Override
    public void cancelRestaurantCollection(String uid, String rid) {
        Member member = memberRepository.findMemberByUid(Long.parseLong(uid));
        Restaurant restaurant = restaurantRepository.findRestaurantByRid(rid);
        assert member!=null&&restaurant!=null;
        RestaurantCollection collection = restaurantCollectionRepository.findByRestaurantAndMember(restaurant,member);
        if(collection!=null){
            restaurantCollectionRepository.delete(collection);
        }
    }

    @Override
    public GetRestListVo getCollectRestaurant(String uid, String city, double lng, double lat) {
        Member member = memberRepository.findMemberByUid(Long.parseLong(uid));
        assert member!=null;
        List<RestaurantCollection> collections = member.getCollections();
        RestDetail[] restDetails = new RestDetail[collections.size()];
        for (int i = 0; i < collections.size(); i++) {
            RestaurantCollection collection = collections.get(i);
            Restaurant restaurant = collection.getRestaurant();
            double distance = LocationHelper.getDistance(restaurant.getLng(), restaurant.getLat(),lng,lat);
            int arriveTime = LocationHelper.getArriveTime(distance);
            RestDetail restDetail = new RestDetail(restaurant.getName(),restaurant.getRid(),restaurant.getRestaurantPoint(),restaurant.getPicture(),restaurant.getStartingPrice(),restaurant.getDeliverPrice(),arriveTime);
            restDetails[i] = restDetail;
        }
        return new GetRestListVo(restDetails);
    }
}
