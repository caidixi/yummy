package wnderful.yummy.request.newBaseRequest;

public class MemberLogInWithCodeReq {
    private String phone;
    private String verificationCode;

    public MemberLogInWithCodeReq() {
    }


    public MemberLogInWithCodeReq(String phone, String verificationCode) {
        this.phone = phone;
        this.verificationCode = verificationCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }
}
