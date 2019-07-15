package wnderful.yummy.vo.memberVo;

public class GetMemInfoVo {
    private String uid;
    private String name;
    private String phone;
    private String avatar;

    public GetMemInfoVo() {
    }

    public GetMemInfoVo(String uid, String name, String phone, String avatar) {
        this.uid = uid;
        this.name = name;
        this.phone = phone;
        this.avatar = avatar;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
