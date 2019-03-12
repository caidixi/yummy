package wnderful.yummy.responseCode.restaurantResponseCode;

public enum GetRestaurantInfoCode {
    SUCCESS(0,"获取会员信息成功"),
    NOTEXIST(1,"餐厅不存在");
    private int code;
    private String message;

    GetRestaurantInfoCode(int code, String message) {
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
