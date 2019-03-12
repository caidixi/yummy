package wnderful.yummy.responseCode.memberResponseCode;

public enum CancelOrderCode {
    SUCCESS(0,"取消订单成功"),
    NOTEXIST(1,"用户不存在"),
    CANCEL(2,"用户已注销"),
    HASCANCEL(3,"订单已取消");
    private int code;
    private String message;

    CancelOrderCode(int code, String message) {
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
