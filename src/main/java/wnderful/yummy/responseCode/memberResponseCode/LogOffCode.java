package wnderful.yummy.responseCode.memberResponseCode;

public enum LogOffCode {
    SUCCESS(0,"注销成功"),
    NOTEXIST(1,"账号不存在"),
    CANCEL(2,"账号已注销");
    private int code;
    private String message;

    LogOffCode(int code, String message) {
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
