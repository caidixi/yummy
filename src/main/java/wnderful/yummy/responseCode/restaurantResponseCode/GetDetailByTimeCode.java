package wnderful.yummy.responseCode.restaurantResponseCode;

public enum GetDetailByTimeCode {
    SUCCESS(0,"获取餐厅统计信息（时间）成功"),
    NOTEXIST(1,"餐厅不存在");
    private int code;
    private String message;

    GetDetailByTimeCode(int code, String message) {
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
