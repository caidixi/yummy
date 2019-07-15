package wnderful.yummy.responseCode.newBaseResponseCode.baseResponseCode;

public enum VerificationResponseCode {
    SUCCESS(0,"获取验证码成功"),
    WRONGFORMAT(2,"错误的数据格式"),
    FREQUENT(3,"操作过于频繁，请稍后再试"),
    FAIL(1,"发送失败");
    private int code;
    private String message;

    VerificationResponseCode(int code, String message) {
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
