package wnderful.yummy.responseCode.memberResponseCode;

public enum ConfirmOrderCode {
    SUCCESS(0,"确认订单成功"),
    NOTEXIST(1,"用户不存在"),
    CANCEL(2,"用户已注销"),
    FAIL(3,"订单不可确认（已取消/未支付或已确认）");
    private int code;
    private String message;

    ConfirmOrderCode(int code, String message) {
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
