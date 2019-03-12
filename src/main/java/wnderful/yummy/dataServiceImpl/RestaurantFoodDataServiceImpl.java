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
import wnderful.yummy.vo.memberVo.GetRestDetailVo;
import wnderful.yummy.vo.restaurantVo.RestDetailVo;

import java.util.List;

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
    public void newFood(String rid, String foodName, String announcement, double price, double packagePrice, int number, String picture, double discount, int discountLimit) {
        Restaurant restaurant = restaurantRepository.findRestaurantByRid(rid);
        FoodState foodState = foodStateDataService.getNormalFoodState();
        assert restaurant!=null&&foodState!=null;
        Food food = new Food(foodName,number,announcement,price,packagePrice,picture,discount,discountLimit,foodState,restaurant);
        foodRepository.save(food);
    }

    @Override
    public GetRestDetailVo getRestaurantDetailFromMember(String rid) {
        Restaurant restaurant = restaurantRepository.findRestaurantByRid(rid);
        assert restaurant!=null;
        //FullReductionList fullReductionList = JSON.parseObject(restaurant.getFullReduction(),FullReductionList.class);
        FoodDetail[] foodDetails =getFoodDetail(restaurant);
        return new GetRestDetailVo(restaurant.getName(),restaurant.getPicture(),restaurant.getRid(),restaurant.getAddress(),
                restaurant.getAnnouncement(),restaurant.getTotalDiscount(),foodDetails);
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
            foodDetails[i] = new FoodDetail(food.getName(),food.getFid(),food.getAnnouncement(),food.getPicture(),food.getPrice(),food.getPackagePrice(),food.getDiscount(),food.getDiscountLimit(),food.getNumber());
        }
        return foodDetails;
    }
}
