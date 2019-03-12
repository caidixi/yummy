package wnderful.yummy.request.restaurantRequest;

public class ModRestInfoReq {
    private String rid;
    private String newName;
    private String newPhone;
    private String newAddress;
    private String newAccountId;
    private String newType;
    private String newAnnouncement;
    private String newPicture;

    public ModRestInfoReq() {
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getNewPhone() {
        return newPhone;
    }

    public void setNewPhone(String newPhone) {
        this.newPhone = newPhone;
    }

    public String getNewAddress() {
        return newAddress;
    }

    public void setNewAddress(String newAddress) {
        this.newAddress = newAddress;
    }

    public String getNewType() {
        return newType;
    }

    public void setNewType(String newType) {
        this.newType = newType;
    }

    public String getNewAnnouncement() {
        return newAnnouncement;
    }

    public void setNewAnnouncement(String newAnnouncement) {
        this.newAnnouncement = newAnnouncement;
    }

    public String getNewAccountId() {
        return newAccountId;
    }

    public void setNewAccountId(String newAccountId) {
        this.newAccountId = newAccountId;
    }

    public String getNewPicture() {
        return newPicture;
    }

    public void setNewPicture(String newPicture) {
        this.newPicture = newPicture;
    }
}
