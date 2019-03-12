package wnderful.yummy.responseCode.memberResponseCode;

public enum GetOrderListCode {
    SUCCESS(0,"获取会员订单成功"),
    NOTEXIST(1,"用户不存在"),
    CANCEL(2,"用户已注销");
    private int code;
    private String message;

    GetOrderListCode(int code, String message) {
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
