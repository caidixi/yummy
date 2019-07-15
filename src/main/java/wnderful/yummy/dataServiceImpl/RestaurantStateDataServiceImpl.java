package wnderful.yummy.dataServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wnderful.yummy.dao.module.RestaurantState;
import wnderful.yummy.dao.repository.RestaurantStateRepository;
import wnderful.yummy.dataService.RestaurantStateDataService;
import wnderful.yummy.entity.entityInModule.RestaurantStateName;

@Service
public class RestaurantStateDataServiceImpl implements RestaurantStateDataService {
    private RestaurantStateRepository restaurantStateRepository;

    @Autowired
    public RestaurantStateDataServiceImpl(RestaurantStateRepository restaurantStateRepository) {
        this.restaurantStateRepository = restaurantStateRepository;
    }


    public void initialize(){
        if(restaurantStateRepository.findAll().size()==0){
            restaurantStateRepository.saveAndFlush(new RestaurantState(RestaurantStateName.FAIL.getStateName()));
            restaurantStateRepository.saveAndFlush(new RestaurantState(RestaurantStateName.EXAMINE.getStateName()));
            restaurantStateRepository.saveAndFlush(new RestaurantState(RestaurantStateName.NORMAL.getStateName()));
        }
    }

    @Override
    public RestaurantState getNormalRestState() {
        return restaurantStateRepository.findByName(RestaurantStateName.NORMAL.getStateName());
    }

    @Override
    public RestaurantState getExamineRestState() {
        return restaurantStateRepository.findByName(RestaurantStateName.EXAMINE.getStateName());
    }

    @Override
    public RestaurantState getFailRestState() {
        return restaurantStateRepository.findByName(RestaurantStateName.FAIL.getStateName());
    }
}
