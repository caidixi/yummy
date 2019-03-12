package wnderful.yummy.responseCode.memberResponseCode;

public enum GetOrderDetailCode {
    SUCCESS(0,"获取餐厅详细信息成功"),
    NOTEXIST(1,"用户不存在"),
    CANCEL(2,"用户已注销"),
    ORDERNOTEXIST(3,"订单不存在");
    private int code;
    private String message;

    GetOrderDetailCode(int code, String message) {
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
