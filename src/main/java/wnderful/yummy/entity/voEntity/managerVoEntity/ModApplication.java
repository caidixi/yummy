package wnderful.yummy.entity.voEntity.managerVoEntity;

public class ModApplication {
    private String rid;
    private String newName;
    private String newPhone;
    private String newAddress;
    private String newType;
    private String newAnnouncement;
    private String newAccountId;
    private String newPicture;

    public ModApplication(String rid, String newName, String newPhone, String newAddress, String newType, String newAnnouncement, String newAccountId, String newPicture) {
        this.rid = rid;
        this.newName = newName;
        this.newPhone = newPhone;
        this.newAddress = newAddress;
        this.newType = newType;
        this.newAnnouncement = newAnnouncement;
        this.newAccountId = newAccountId;
        this.newPicture = newPicture;
    }

    public ModApplication() {
    }

    public String getRid() {
        return rid;
    }

    public String getNewName() {
        return newName;
    }

    public String getNewPhone() {
        return newPhone;
    }

    public String getNewAddress() {
        return newAddress;
    }

    public String getNewType() {
        return newType;
    }

    public String getNewAnnouncement() {
        return newAnnouncement;
    }

    public String getNewAccountId() {
        return newAccountId;
    }

    public String getNewPicture() {
        return newPicture;
    }
}
