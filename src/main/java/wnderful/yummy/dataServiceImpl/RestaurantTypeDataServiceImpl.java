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
            restaurantTypeRepository.saveAndFlush(new RestaurantType(RestaurantTypeName.FASTFOOD.getStateName()));
            restaurantTypeRepository.saveAndFlush(new RestaurantType(RestaurantTypeName.SNACK.getStateName()));
            restaurantTypeRepository.saveAndFlush(new RestaurantType(RestaurantTypeName.MAIN.getStateName()));
            restaurantTypeRepository.saveAndFlush(new RestaurantType(RestaurantTypeName.SUPERMARKET.getStateName()));
            restaurantTypeRepository.saveAndFlush(new RestaurantType(RestaurantTypeName.FRUIT.getStateName()));
            restaurantTypeRepository.saveAndFlush(new RestaurantType(RestaurantTypeName.TEA.getStateName()));
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
    public RestaurantType getMainType() {
        return restaurantTypeRepository.findByName(RestaurantTypeName.MAIN.getStateName());
    }

    @Override
    public RestaurantType getSuperMarketType() {
        return restaurantTypeRepository.findByName(RestaurantTypeName.SUPERMARKET.getStateName());
    }

    @Override
    public RestaurantType getFruitType() {
        return restaurantTypeRepository.findByName(RestaurantTypeName.FRUIT.getStateName());
    }

    @Override
    public RestaurantType getTeaType() {
        return restaurantTypeRepository.findByName(RestaurantTypeName.TEA.getStateName());
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
