package wnderful.yummy.request.restaurantRequest;

public class ModFoodReq {
    private String rid;
    private String fid;
    private String newFoodName;
    private String newAnnouncement;
    private double newPrice;
    private double newPackagePrice;
    private int newNumber;
    private String picture;
    private String type;

    public ModFoodReq() {
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getNewFoodName() {
        return newFoodName;
    }

    public void setNewFoodName(String newFoodName) {
        this.newFoodName = newFoodName;
    }

    public String getNewAnnouncement() {
        return newAnnouncement;
    }

    public void setNewAnnouncement(String newAnnouncement) {
        this.newAnnouncement = newAnnouncement;
    }

    public double getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(double newPrice) {
        this.newPrice = newPrice;
    }

    public double getNewPackagePrice() {
        return newPackagePrice;
    }

    public void setNewPackagePrice(double newPackagePrice) {
        this.newPackagePrice = newPackagePrice;
    }

    public int getNewNumber() {
        return newNumber;
    }

    public void setNewNumber(int newNumber) {
        this.newNumber = newNumber;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
