package wnderful.yummy.responseCode.restaurantResponseCode;

public enum GetOrderListCode {
    SUCCESS(0,"餐厅获取订单信息成功"),
    NOTEXIST(1,"餐厅不存在");
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
