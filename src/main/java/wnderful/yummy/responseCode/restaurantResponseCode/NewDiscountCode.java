package wnderful.yummy.responseCode.restaurantResponseCode;

public enum NewDiscountCode {
    SUCCESS(0,"修改餐厅优惠信息成功"),
    NOTEXIST(1,"餐厅不存在"),
    WRONGFORMAT(2,"错误的数据格式");
    private int code;
    private String message;

    NewDiscountCode(int code, String message) {
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
