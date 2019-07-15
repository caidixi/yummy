package wnderful.yummy.responseCode.memberResponseCode;

public enum EvaluateOrderCode {
    SUCCESS(0,"评价订单成功"),
    NOTEXIST(1,"订单不存在"),
    CANTEVALUATE(2,"订单无法评价"),
    FAIL(3,"订单无法评价（未完成或已评价）");
    private int code;
    private String message;

    EvaluateOrderCode(int code, String message) {
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
