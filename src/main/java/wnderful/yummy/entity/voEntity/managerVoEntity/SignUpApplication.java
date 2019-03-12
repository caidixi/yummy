package wnderful.yummy.entity.voEntity.managerVoEntity;

public class SignUpApplication {
    private String rid;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String type;
    private String announcement;

    public SignUpApplication() {
    }

    public SignUpApplication(String rid, String name, String email, String phone, String address, String type, String announcement) {
        this.rid = rid;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.type = type;
        this.announcement = announcement;
    }

    public String getRid() {
        return rid;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getType() {
        return type;
    }

    public String getAnnouncement() {
        return announcement;
    }
}
