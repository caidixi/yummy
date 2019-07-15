package wnderful.yummy.dataServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wnderful.yummy.dao.module.*;
import wnderful.yummy.dao.repository.*;
import wnderful.yummy.dataService.RestaurantDataService;
import wnderful.yummy.entity.FullReduction;
//import wnderful.yummy.entity.entityInModule.FullReductionList;
//import com.alibaba.fastjson.JSON;
import wnderful.yummy.entity.entityInModule.RestaurantStateName;
import wnderful.yummy.entity.voEntity.RestDetail;
import wnderful.yummy.entity.voEntity.managerVoEntity.ModApplication;
import wnderful.yummy.entity.voEntity.managerVoEntity.SignUpApplication;
import wnderful.yummy.util.*;
import wnderful.yummy.vo.managerVo.GetApplyListVo;
import wnderful.yummy.vo.managerVo.GetModifyListVo;
import wnderful.yummy.vo.memberVo.GetRestListVo;
import wnderful.yummy.vo.restaurantVo.*;

import java.util.List;
import java.util.UUID;

@Service
public class RestaurantDataServiceImpl implements RestaurantDataService {
    private RestaurantRepository restaurantRepository;
    private RestaurantTypeDataServiceImpl restaurantTypeDataService;
    private RestaurantStateDataServiceImpl restaurantStateDataService;
    private ModifyApplicationRepository modifyApplicationRepository;
    private SafeEmailHelper emailHelper;

    @Autowired
    public RestaurantDataServiceImpl(RestaurantRepository restaurantRepository, RestaurantTypeDataServiceImpl restaurantTypeDataService,
                                     ModifyApplicationRepository modifyApplicationRepository,
                                     RestaurantStateDataServiceImpl restaurantStateDataService, SafeEmailHelper emailHelper) {
        this.restaurantRepository = restaurantRepository;
        this.restaurantTypeDataService = restaurantTypeDataService;
        this.modifyApplicationRepository = modifyApplicationRepository;
        this.restaurantStateDataService = restaurantStateDataService;
        this.emailHelper = emailHelper;
    }

    @Override
    public boolean restaurantRidExist(String rid) {
        //不包括未通过/待审核的餐厅(包括已审核)
        Restaurant restaurant = restaurantRepository.findRestaurantByRid(rid);
        if (restaurant != null) {
            return restaurantIsNormal(restaurant);
        } else {
            return false;
        }
    }


    @Override
    public boolean restaurantEmailExist(String email) {
        //不包括未通过/待审核的餐厅(包括已审核)
        Restaurant restaurant = restaurantRepository.findRestaurantByEmail(email);
        if (restaurant != null) {
            return restaurantIsNormal(restaurant);
        } else {
            return false;
        }
    }

    @Override
    public boolean restaurantNameExist(String name) {
        //包括待审核/已审核(不包括未通过)
        Restaurant restaurant = restaurantRepository.findRestaurantByName(name);
        if (restaurant != null) {
            return !restaurantIsCancel(restaurant);
        } else {
            return false;
        }
    }


    @Override
    public boolean restaurantApplicationExist(String email) {
        //不包括未通过/已审核的餐厅(包括未审核)
        Restaurant restaurant = restaurantRepository.findRestaurantByEmail(email);
        if (restaurant != null) {
            return restaurantIsExamine(restaurant);
        } else {
            return false;
        }
    }

    @Override
    public boolean restaurantApplicationRidExist(String rid) {
        //不包括未通过/已审核的餐厅(包括未审核)
        Restaurant restaurant = restaurantRepository.findRestaurantByRid(rid);
        if (restaurant != null) {
            return restaurantIsExamine(restaurant);
        } else {
            return false;
        }
    }

    @Override
    public boolean restaurantModificationExist(String rid) {
        return modifyApplicationRepository.findByRid(rid)!=null;
    }

    @Override
    public boolean verifyPassword(String rid, String password) {
        Restaurant restaurant = restaurantRepository.findRestaurantByRid(rid);
        assert restaurant != null && restaurantIsNormal(restaurant);
        String encryptPassword = SHAHelper.getResult(password);
        String truePassword = restaurant.getPassword();
        return encryptPassword.equals(truePassword);
    }

    @Override
    public void approveApplication(String mid, String rid) {
        Restaurant restaurant = restaurantRepository.findRestaurantByRid(rid);
        assert restaurant != null && restaurantIsExamine(restaurant);
        String email = restaurant.getEmail();
        String password = PasswordHelper.getRandomPassword();
        String encryptPassword = SHAHelper.getResult(password);
        RestaurantState restaurantState = restaurantStateDataService.getNormalRestState();
        restaurant.setRestaurantState(restaurantState);
        restaurant.setPassword(encryptPassword);
        emailHelper.sendRestaurantEmail(email, rid, password);
        restaurantRepository.save(restaurant);
    }

    @Override
    public void refuseApplication(String mid, String rid) {
        Restaurant restaurant = restaurantRepository.findRestaurantByRid(rid);
        assert restaurant != null && restaurantIsExamine(restaurant);
        RestaurantState restaurantState = restaurantStateDataService.getFailRestState();
        restaurant.setRestaurantState(restaurantState);
        restaurantRepository.save(restaurant);
    }

    @Override
    public void approveModification(String mid, String rid) {
        Restaurant restaurant = restaurantRepository.findRestaurantByRid(rid);
        assert restaurant != null && restaurantIsNormal(restaurant);
        ModifyApplication modifyApplication = modifyApplicationRepository.findByRid(rid);
        RestaurantType restaurantType = restaurantTypeDataService.getByName(modifyApplication.getNewType());
        restaurant.setAnnouncement(modifyApplication.getNewAnnouncement());
        restaurant.setAddress(modifyApplication.getNewAddress());
        restaurant.setName(modifyApplication.getNewName());
        restaurant.setAccountId(modifyApplication.getNewAccountId());
        restaurant.setPhone(modifyApplication.getNewPhone());
        restaurant.setRestaurantType(restaurantType);
        restaurant.setPicture(modifyApplication.getNewPicture());
        modifyApplicationRepository.delete(modifyApplication);
        restaurantRepository.save(restaurant);
    }

    @Override
    public void refuseModification(String mid, String rid) {
        Restaurant restaurant = restaurantRepository.findRestaurantByRid(rid);
        assert restaurant != null && restaurantIsNormal(restaurant);
        ModifyApplication modifyApplication = modifyApplicationRepository.findByRid(rid);
        modifyApplicationRepository.delete(modifyApplication);
    }

    @Override
    public void newSignUpApplication(String name, String email, String phone, String address,double lng,double lat,String city, String accountId, String type, String announcement,String picture) {
        Restaurant restaurant = restaurantRepository.findRestaurantByEmail(email);
        RestaurantState restaurantState = restaurantStateDataService.getExamineRestState();
        RestaurantType restaurantType = restaurantTypeDataService.getByName(type);
        assert restaurantType!=null;
        if(restaurant != null){
            restaurant.setName(name);
            restaurant.setPhone(phone);
            restaurant.setAddress(address);
            restaurant.setAccountId(accountId);
            restaurant.setRestaurantType(restaurantType);
            restaurant.setAnnouncement(announcement);
            restaurant.setRestaurantState(restaurantState);
            restaurant.setLng(lng);
            restaurant.setLat(lat);
            restaurant.setCity(city);
            restaurant.setPicture(picture);
            restaurantRepository.save(restaurant);
        }else {
            String rid = createRestaurantId();
            Restaurant newRestaurant = new Restaurant(rid, name, email, phone, address,lng,lat,city,announcement, "", accountId,picture, restaurantType, restaurantState);
            restaurantRepository.save(newRestaurant);
        }
    }

    @Override
    public void modRestaurantInfo(String rid, String newName, String newPhone, String newAddress, String newAccountId, String newType, String newAnnouncement, String newPicture) {
        Restaurant restaurant = restaurantRepository.findRestaurantByRid(rid);
        assert restaurant != null && restaurantIsNormal(restaurant);
        ModifyApplication modifyApplication = new ModifyApplication(newName, newPhone, newAddress, newType, newAnnouncement, newAccountId, newPicture,rid);
        modifyApplicationRepository.save(modifyApplication);
    }

    @Override
    public void modRestaurantDiscount(String rid, double totalDiscount, FullReduction[] fullReductions) {
        Restaurant restaurant = restaurantRepository.findRestaurantByRid(rid);
        assert restaurant != null && restaurantIsNormal(restaurant);
        restaurant.setTotalDiscount(totalDiscount);
        //FullReductionList list = new FullReductionList(fullReductions);
        //String fullReduction = JSON.toJSONString(list);
        //restaurant.setFullReduction(fullReduction);
        restaurantRepository.save(restaurant);
    }

    @Override
    public String getRestaurantName(String rid) {
        Restaurant restaurant = restaurantRepository.findRestaurantByRid(rid);
        assert restaurant!=null;
        return restaurant.getName();
    }

    @Override
    public GetRestListVo getRestaurantList(String type,String city,double lng,double lat) {
        RestaurantState restaurantState = restaurantStateDataService.getNormalRestState();
        RestaurantType restaurantType = restaurantTypeDataService.getByName(type);
        List<Restaurant> restaurants = restaurantRepository.findByRestaurantStateAndCityContainingAndRestaurantType(restaurantState,city,restaurantType);
        RestDetail[] restDetails = getRestDetail(restaurants,lng,lat);
        return new GetRestListVo(restDetails);
    }

    @Override
    public GetRestListVo searchRestaurantByName(String name, String city, double lng, double lat) {
        RestaurantState restaurantState = restaurantStateDataService.getNormalRestState();
        List<Restaurant> restaurants = restaurantRepository.findByRestaurantStateAndCityContainingAndNameContaining(restaurantState,city,name);
        RestDetail[] restDetails = getRestDetail(restaurants,lng,lat);
        return new GetRestListVo(restDetails);
    }

    @Override
    public RestGetInfoVo getRestaurantInfo(String rid) {
        Restaurant restaurant = restaurantRepository.findRestaurantByRid(rid);
        assert restaurant != null && restaurantIsNormal(restaurant);
        return new RestGetInfoVo(restaurant.getName(), rid, restaurant.getEmail(), restaurant.getPhone(), restaurant.getAddress()
                , restaurant.getRestaurantType().getName(), restaurant.getAnnouncement(),restaurant.getAccountId(),restaurant.getPicture());
    }

    @Override
    public RestTypeListVo getRestaurantTypeList() {
        List<RestaurantType> restaurantTypes = restaurantTypeDataService.getAllType();
        String[] typeNames = new String[restaurantTypes.size()];
        for (int i = 0; i < restaurantTypes.size(); i++) {
            String typeName = restaurantTypes.get(i).getName();
            typeNames[i] = typeName;
        }
        return new RestTypeListVo(typeNames);
    }

    @Override
    public GetApplyListVo getApplyList() {
        RestaurantState restaurantState = restaurantStateDataService.getExamineRestState();
        List<Restaurant> restaurants = restaurantRepository.findByRestaurantState(restaurantState);
        SignUpApplication[] applications = new SignUpApplication[restaurants.size()];
        for (int i = 0; i < restaurants.size(); i++) {
            Restaurant restaurant = restaurants.get(i);
            SignUpApplication application = new SignUpApplication(restaurant.getRid(),restaurant.getName(), restaurant.getEmail(),
                    restaurant.getPhone(), restaurant.getAddress(), restaurant.getRestaurantType().getName(), restaurant.getAnnouncement());
            applications[i] = application;
        }
        return new GetApplyListVo(applications);
    }

    @Override
    public GetModifyListVo getModifyList() {
        List<ModifyApplication> modifyApplications = modifyApplicationRepository.findAll();
        ModApplication[] modApplications = new ModApplication[modifyApplications.size()];
        for (int i = 0; i < modifyApplications.size(); i++) {
            ModifyApplication modifyApplication = modifyApplications.get(i);
            Restaurant restaurant = restaurantRepository.findRestaurantByRid(modifyApplication.getRid());
            assert restaurant!=null;
            ModApplication modApplication = new ModApplication(restaurant.getRid(),modifyApplication.getNewName(),
                    modifyApplication.getNewPhone(),modifyApplication.getNewAddress(),modifyApplication.getNewType(),
                    modifyApplication.getNewAnnouncement(),modifyApplication.getNewAccountId(),modifyApplication.getNewPicture());
            modApplications[i] = modApplication;
        }
        return new GetModifyListVo(modApplications);
    }

    private String createRestaurantId() {
        while (true) {
            String rid = UUID.randomUUID().toString().substring(0, 7);
            if (restaurantRepository.findRestaurantByRid(rid) == null) {
                return rid;
            }
        }
    }

    private boolean restaurantIsNormal(Restaurant restaurant) {
        RestaurantState restaurantState = restaurant.getRestaurantState();
        String stateName = restaurantState.getName();
        return stateName.equals(RestaurantStateName.NORMAL.getStateName());
    }

    private boolean restaurantIsCancel(Restaurant restaurant) {
        RestaurantState restaurantState = restaurant.getRestaurantState();
        String stateName = restaurantState.getName();
        return stateName.equals(RestaurantStateName.FAIL.getStateName());
    }

    private boolean restaurantIsExamine(Restaurant restaurant) {
        RestaurantState restaurantState = restaurant.getRestaurantState();
        String stateName = restaurantState.getName();
        return stateName.equals(RestaurantStateName.EXAMINE.getStateName());
    }

    private RestDetail[] getRestDetail(List<Restaurant> restaurants,double lng,double lat){
        RestDetail[] restDetails = new RestDetail[restaurants.size()];
        for (int i = 0; i < restaurants.size(); i++) {
            Restaurant restaurant = restaurants.get(i);
            double distance = LocationHelper.getDistance(restaurant.getLng(), restaurant.getLat(),lng,lat);
            int arriveTime = LocationHelper.getArriveTime(distance);
            RestDetail restDetail = new RestDetail(restaurant.getName(),restaurant.getRid(),restaurant.getRestaurantPoint(),restaurant.getPicture(),restaurant.getStartingPrice(),restaurant.getDeliverPrice(),arriveTime);
            restDetails[i] = restDetail;
        }
        return restDetails;
    }
}
