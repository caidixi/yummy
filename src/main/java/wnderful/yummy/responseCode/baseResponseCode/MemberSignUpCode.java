package wnderful.yummy.responseCode.baseResponseCode;

public enum MemberSignUpCode {
    SUCCESS(0,"会员注册成功"),
    EMPTY(1,"输入信息不得为空"),
    EXIST(2,"账号已存在");
    private int code;
    private String message;

    MemberSignUpCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
