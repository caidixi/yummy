package wnderful.yummy.dataServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wnderful.yummy.dao.module.RestaurantType;
import wnderful.yummy.dao.repository.RestaurantTypeRepository;
import wnderful.yummy.dataService.RestaurantTypeDataService;
import wnderful.yummy.entity.entityInModule.RestaurantTypeName;

import java.util.List;

@Service
public class RestaurantTypeDataServiceImpl implements RestaurantTypeDataService {
    private RestaurantTypeRepository restaurantTypeRepository;

    @Autowired
    public RestaurantTypeDataServiceImpl(RestaurantTypeRepository restaurantTypeRepository) {
        this.restaurantTypeRepository = restaurantTypeRepository;
        if(restaurantTypeRepository.findAll().size()==0){
            restaurantTypeRepository.save(new RestaurantType(RestaurantTypeName.FASTFOOD.getStateName()));
            restaurantTypeRepository.save(new RestaurantType(RestaurantTypeName.SNACK.getStateName()));
            restaurantTypeRepository.save(new RestaurantType(RestaurantTypeName.WESTERN.getStateName()));
            restaurantTypeRepository.save(new RestaurantType(RestaurantTypeName.REGIONAL.getStateName()));
            restaurantTypeRepository.save(new RestaurantType(RestaurantTypeName.NOODLE.getStateName()));
        }
    }

    @Override
    public RestaurantType getFastFoodType() {
        return restaurantTypeRepository.findByName(RestaurantTypeName.FASTFOOD.getStateName());
    }

    @Override
    public RestaurantType getSnackType() {
        return restaurantTypeRepository.findByName(RestaurantTypeName.SNACK.getStateName());
    }

    @Override
    public RestaurantType getWesternType() {
        return restaurantTypeRepository.findByName(RestaurantTypeName.WESTERN.getStateName());
    }

    @Override
    public RestaurantType getRegionalType() {
        return restaurantTypeRepository.findByName(RestaurantTypeName.REGIONAL.getStateName());
    }

    @Override
    public RestaurantType getNoodleType() {
        return restaurantTypeRepository.findByName(RestaurantTypeName.NOODLE.getStateName());
    }

    @Override
    public RestaurantType getByName(String name) {
        return restaurantTypeRepository.findByName(name);
    }

    @Override
    public List<RestaurantType> getAllType() {
        return restaurantTypeRepository.findAll();
    }
}
