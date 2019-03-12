package wnderful.yummy.vo.restaurantVo;

public class RestGetInfoVo {
    private String name;
    private String rid;
    private String email;
    private String phone;
    private String address;
    private String type;
    private String announcement;
    private String accountId;
    private String picture;

    public RestGetInfoVo() {
    }

    public RestGetInfoVo(String name, String rid, String email, String phone, String address, String type, String announcement, String accountId, String picture) {
        this.name = name;
        this.rid = rid;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.type = type;
        this.announcement = announcement;
        this.accountId = accountId;
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public String getRid() {
        return rid;
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

    public String getAccountId() {
        return accountId;
    }

    public String getPicture() {
        return picture;
    }
}
