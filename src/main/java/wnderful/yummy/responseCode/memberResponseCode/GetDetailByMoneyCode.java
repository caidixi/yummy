package wnderful.yummy.responseCode.memberResponseCode;

public enum GetDetailByMoneyCode {
    SUCCESS(0,"获取统计信息（金额）成功"),
    NOTEXIST(1,"用户不存在"),
    CANCEL(2,"用户已注销");
    private int code;
    private String message;

    GetDetailByMoneyCode(int code, String message) {
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
