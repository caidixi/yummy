package wnderful.yummy.dataServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wnderful.yummy.dao.module.Food;
import wnderful.yummy.dao.module.FoodState;
import wnderful.yummy.dao.repository.FoodRepository;
import wnderful.yummy.dataService.FoodDataService;
import wnderful.yummy.entity.voEntity.FoodDetail;

@Service
public class FoodDataServiceImpl implements FoodDataService {
    private FoodRepository foodRepository;
    private FoodStateDataServiceImpl foodStateDataService;

    @Autowired
    public FoodDataServiceImpl(FoodRepository foodRepository, FoodStateDataServiceImpl foodStateDataService) {
        this.foodRepository = foodRepository;
        this.foodStateDataService = foodStateDataService;
    }

    @Override
    public boolean foodExist(String fid) {
        //不包括被取消的食物
        FoodState foodState = foodStateDataService.getCancelFoodState();
        return foodRepository.findByFidAndFoodStateNot(Long.parseLong(fid), foodState) != null;
    }

    @Override
    public boolean foodEnough(String fid, int number) {
        FoodState foodState = foodStateDataService.getNormalFoodState();
        Food food = foodRepository.findByFidAndFoodState(Long.parseLong(fid), foodState);
        if (food != null) {
            return food.getNumber() > number;
        } else {
            return false;
        }
    }

    @Override
    public void modFood(String fid, String newFoodName, String newAnnouncement, double newPrice, double newPackagePrice,
                        int newNumber, String newPicture, double newDiscount, int newDiscountLimit) {
        FoodState foodState = foodStateDataService.getCancelFoodState();
        Food food = foodRepository.findByFidAndFoodStateNot(Long.parseLong(fid), foodState);
        assert food != null;
        food.setName(newFoodName);
        food.setAnnouncement(newAnnouncement);
        food.setPrice(newPrice);
        food.setPackagePrice(newPackagePrice);
        food.setNumber(newNumber);
        food.setPicture(newPicture);
        food.setDiscount(newDiscount);
        food.setDiscountLimit(newDiscountLimit);
        foodRepository.save(food);
    }

    @Override
    public void deleteFood(String fid) {
        FoodState foodState = foodStateDataService.getCancelFoodState();
        Food food = foodRepository.findByFidAndFoodStateNot(Long.parseLong(fid), foodState);
        assert food != null;
        food.setFoodState(foodState);
        foodRepository.save(food);
    }

    @Override
    public FoodDetail getFoodDetail(String fid) {
        FoodState foodState = foodStateDataService.getCancelFoodState();
        Food food = foodRepository.findByFidAndFoodStateNot(Long.parseLong(fid), foodState);
        assert food != null;
        return new FoodDetail(food.getName(), fid, food.getAnnouncement(), food.getPicture(), food.getPrice(), food.getPackagePrice(), food.getDiscount(), food.getDiscountLimit(), food.getNumber());
    }
}
