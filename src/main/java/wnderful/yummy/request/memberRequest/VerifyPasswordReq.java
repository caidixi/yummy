package wnderful.yummy.request.memberRequest;

public class VerifyPasswordReq {
    private String uid;
    private String password;

    public VerifyPasswordReq() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
