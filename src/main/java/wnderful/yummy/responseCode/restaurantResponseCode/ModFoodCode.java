package wnderful.yummy.responseCode.restaurantResponseCode;

public enum ModFoodCode {
    SUCCESS(0,"添加菜品信息成功"),
    RESTNOTEXIST(1,"餐厅不存在"),
    FOODNOTEXIST(2,"食品不存在"),
    WRONGFORMAT(3,"错误的数据格式");
    private int code;
    private String message;

    ModFoodCode(int code, String message) {
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
