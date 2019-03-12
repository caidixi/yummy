package wnderful.yummy.dao.module;

import javax.persistence.*;

@Entity
public class ModifyApplication {
    @Id
    @GeneratedValue
    private Long modId;

    @Column(nullable = false,columnDefinition = "varchar(255) character set utf8")
    private String newName;

    @Column(nullable = false)
    private String newPhone;

    @Column(nullable = false,columnDefinition = "varchar(255) character set utf8")
    private String newAddress;

    @Column(nullable = false,columnDefinition = "varchar(255) character set utf8")
    private String newType;

    @Column(nullable = false,columnDefinition = "varchar(255) character set utf8")
    private String newAnnouncement;

    @Column(nullable = false)
    private String newAccountId;

    @Column(nullable = false,columnDefinition = "varchar(255) character set utf8")
    private String newPicture;

    @Column(nullable = false,unique = true)
    private String rid;

    public ModifyApplication() {
    }

    public ModifyApplication(String newName, String newPhone, String newAddress, String newType, String newAnnouncement,
                             String newAccountId,String newPicture,String  rid) {
        this.newName = newName;
        this.newPhone = newPhone;
        this.newAddress = newAddress;
        this.newType = newType;
        this.newAnnouncement = newAnnouncement;
        this.newAccountId = newAccountId;
        this.newPicture = newPicture;
        this.rid = rid;
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

    public String getRid() {
        return rid;
    }

    public Long getModId() {
        return modId;
    }
}
