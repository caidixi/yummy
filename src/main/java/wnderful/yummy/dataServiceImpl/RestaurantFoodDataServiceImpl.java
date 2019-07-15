package wnderful.yummy.dataServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wnderful.yummy.dao.module.Food;
import wnderful.yummy.dao.module.FoodState;
import wnderful.yummy.dao.module.Restaurant;
import wnderful.yummy.dao.repository.FoodRepository;
import wnderful.yummy.dao.repository.RestaurantRepository;
import wnderful.yummy.dataService.RestaurantFoodDataService;
import wnderful.yummy.entity.voEntity.FoodDetail;
import wnderful.yummy.entity.voEntity.SearchFoodResult;
import wnderful.yummy.util.LocationHelper;
import wnderful.yummy.vo.memberVo.GetRestDetailVo;
import wnderful.yummy.vo.memberVo.SearchFoodVo;
import wnderful.yummy.vo.restaurantVo.RestDetailVo;

import java.util.List;
import java.util.UUID;

@Service
public class RestaurantFoodDataServiceImpl implements RestaurantFoodDataService {
    private FoodRepository foodRepository;
    private RestaurantRepository restaurantRepository;
    private FoodStateDataServiceImpl foodStateDataService;

    @Autowired
    public RestaurantFoodDataServiceImpl(FoodRepository foodRepository, RestaurantRepository restaurantRepository, FoodStateDataServiceImpl foodStateDataService) {
        this.foodRepository = foodRepository;
        this.restaurantRepository = restaurantRepository;
        this.foodStateDataService = foodStateDataService;
    }

    @Override
    public void newFood(String rid, String foodName, String announcement, double price, double packagePrice, int number, String picture, String type) {
        Restaurant restaurant = restaurantRepository.findRestaurantByRid(rid);
        FoodState foodState = foodStateDataService.getNormalFoodState();
        assert restaurant!=null&&foodState!=null;
        String fid = createFoodId();
        Food food = new Food(fid,foodName,number,announcement,price,packagePrice,picture,type,foodState,restaurant);
        foodRepository.save(food);
    }

    @Override
    public GetRestDetailVo getRestaurantDetailFromMember(String rid) {
        Restaurant restaurant = restaurantRepository.findRestaurantByRid(rid);
        assert restaurant!=null;
        FoodDetail[] foodDetails =getFoodDetail(restaurant);
        return new GetRestDetailVo(restaurant.getName(),restaurant.getRestaurantPoint(),restaurant.getPicture(),restaurant.getStartingPrice(),restaurant.getDeliverPrice(),restaurant
                .getPhone(),restaurant.getAddress(),restaurant.getAnnouncement(),restaurant.getLng(),restaurant.getLat(),foodDetails);
    }

    @Override
    public RestDetailVo getRestaurantDetailFromRest(String rid) {
        Restaurant restaurant = restaurantRepository.findRestaurantByRid(rid);
        assert restaurant!=null;
        //FullReductionList fullReductionList = JSON.parseObject(restaurant.getFullReduction(),FullReductionList.class);
        FoodDetail[] foodDetails =getFoodDetail(restaurant);
        return new RestDetailVo(restaurant.getName(),rid,restaurant.getTotalDiscount(),foodDetails);
    }

    private FoodDetail[] getFoodDetail(Restaurant restaurant){
        FoodState foodState = foodStateDataService.getCancelFoodState();
        List<Food> foods = foodRepository.findByRestaurantAndFoodStateNot(restaurant,foodState);
        FoodDetail[] foodDetails = new FoodDetail[foods.size()];
        for(int  i = 0;i < foods.size();i++){
            Food food = foods.get(i);
            foodDetails[i] = new FoodDetail(food.getName(),food.getFid(),food.getType(),food.getAnnouncement(),food.getPicture(),food.getPrice(),food.getPackagePrice(),food.getNumber());
        }
        return foodDetails;
    }

    @Override
    public SearchFoodVo searchFoodByName(String name, String city, double lng, double lat) {
        List<Food> foods = foodRepository.findByRestaurantCityAndNameContaining(city,name);
        SearchFoodResult[] searchFoodResults = new SearchFoodResult[foods.size()];
        for(int i = 0;i < foods.size();i++){
            Food food = foods.get(i);
            Restaurant restaurant = food.getRestaurant();
            double distance = LocationHelper.getDistance(restaurant.getLng(), restaurant.getLat(),lng,lat);
            int arriveTime = LocationHelper.getArriveTime(distance);
            SearchFoodResult searchFoodResult = new SearchFoodResult(restaurant.getName(),restaurant.getRid(),restaurant.
                    getRestaurantPoint(),restaurant.getPicture(),restaurant.getStartingPrice(),restaurant.getDeliverPrice(),
                    arriveTime,food.getFid(),food.getType(),food.getPackagePrice(),food.getName(),food.getPicture(),food.getPrice(),food.getAnnouncement(),food.getNumber());
            searchFoodResults[i] = searchFoodResult;
        }
        return new SearchFoodVo(searchFoodResults);
    }

    private String createFoodId() {
        while (true) {
            String fid = UUID.randomUUID().toString().substring(0, 9);
            if (foodRepository.findByFid(fid) == null) {
                return fid;
            }
        }
    }
}
