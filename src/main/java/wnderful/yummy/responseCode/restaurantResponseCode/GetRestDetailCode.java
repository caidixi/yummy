package wnderful.yummy.responseCode.restaurantResponseCode;

public enum GetRestDetailCode {
    SUCCESS(0,"获取餐厅详细信息成功"),
    RESTNOTEXIST(2,"餐厅不存在");
    private int code;
    private String message;

    GetRestDetailCode(int code, String message) {
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
