package wnderful.yummy.responseCode.memberResponseCode;

public enum VerifyPasswordCode {
    SUCCESS(0,"验证成功"),
    NOTEXIST(1,"账号不存在"),
    CANCEL(2,"账号已注销"),
    FAIL(3,"验证失败");
    private int code;
    private String message;

    VerifyPasswordCode(int code, String message) {
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
