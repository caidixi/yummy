package wnderful.yummy.responseCode.baseResponseCode;

public enum LogInCode {
    SUCCESS(0,"登陆成功"),
    EMPTY(1,"输入信息不得为空"),
    NOTEXIST(2,"账号不存在"),
    WRONGPASSWORD(3,"密码错误");
    private int code;
    private String message;

    LogInCode(int code, String message) {
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
