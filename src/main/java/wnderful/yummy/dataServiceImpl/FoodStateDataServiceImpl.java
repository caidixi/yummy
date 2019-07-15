package wnderful.yummy.dataServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wnderful.yummy.dao.module.FoodState;
import wnderful.yummy.dao.repository.FoodStateRepository;
import wnderful.yummy.dataService.FoodStateDataService;
import wnderful.yummy.entity.entityInModule.FoodStateName;

@Service
public class FoodStateDataServiceImpl implements FoodStateDataService {
    private FoodStateRepository foodStateRepository;

    @Autowired
    public FoodStateDataServiceImpl(FoodStateRepository foodStateRepository) {
        this.foodStateRepository = foodStateRepository;
    }

    @Override
    public void initialize() {
        if(foodStateRepository.findAll().size()==0){
            foodStateRepository.saveAndFlush(new FoodState(FoodStateName.CANCEL.getStateName()));
            foodStateRepository.saveAndFlush(new FoodState(FoodStateName.EMPTY.getStateName()));
            foodStateRepository.saveAndFlush(new FoodState(FoodStateName.NORMAL.getStateName()));
        }
    }

    @Override
    public FoodState getNormalFoodState() {
        return foodStateRepository.findByName(FoodStateName.NORMAL.getStateName());
    }

    @Override
    public FoodState getEmptyFoodState() {
        return foodStateRepository.findByName(FoodStateName.EMPTY.getStateName());
    }

    @Override
    public FoodState getCancelFoodState() {
        return foodStateRepository.findByName(FoodStateName.CANCEL.getStateName());
    }
}
