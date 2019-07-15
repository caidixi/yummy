package wnderful.yummy.dataService;


import wnderful.yummy.entity.voEntity.FoodDetail;

public interface FoodDataService {
   boolean foodExist(String fid);

   boolean foodEnough(String fid,int number);

   void modFood( String fid, String newFoodName, String newAnnouncement, double newPrice,
                double newPackagePrice, int newNumber, String newPicture, String newType);

   void deleteFood(String fid);

   FoodDetail getFoodDetail(String fid);
}
