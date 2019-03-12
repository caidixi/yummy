package wnderful.yummy.responseCode.memberResponseCode;

public enum PayOrderCode {
    SUCCESS(0,"支付订单成功"),
    NOTEXIST(1,"用户不存在"),
    FAIL(2,"订单不可支付(被取消或已被支付)"),
    OVERTIME(3,"支付超时，订单已取消"),
    NOACCOUNT(4,"无此银行账户"),
    NOBALANCE(5,"余额不足"),
    WRONGPASSSWORD(6,"银行密码错误");

    private int code;
    private String message;

    PayOrderCode(int code, String message) {
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
