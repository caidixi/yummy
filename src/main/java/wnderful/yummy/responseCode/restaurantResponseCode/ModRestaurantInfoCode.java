package wnderful.yummy.responseCode.restaurantResponseCode;

public enum ModRestaurantInfoCode {
    SUCCESS(0,"修改餐厅信息成功"),
    NOTEXIST(1,"餐厅不存在"),
    NOACCOUNT(2,"银行账号不存在"),
    EMPTYADDRESS(3,"姓名、电话和地址不得为空"),
    WAIT(4,"正在审核，请等待");
    private int code;
    private String message;

    ModRestaurantInfoCode(int code, String message) {
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
