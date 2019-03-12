package wnderful.yummy.responseCode.restaurantResponseCode;

public enum DeleteFoodCode {
    SUCCESS(0,"删除菜品成功"),
    RESTNOTEXIST(1,"餐厅不存在"),
    FOODNOTEXIST(2,"食品不存在");
    private int code;
    private String message;

    DeleteFoodCode(int code, String message) {
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
