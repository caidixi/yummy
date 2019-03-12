package wnderful.yummy.responseCode.restaurantResponseCode;

public enum GetRestaurantTypeListCode {
    SUCCESS(0,"获取餐厅类型列表成功");
    private int code;
    private String message;

    GetRestaurantTypeListCode(int code, String message) {
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
