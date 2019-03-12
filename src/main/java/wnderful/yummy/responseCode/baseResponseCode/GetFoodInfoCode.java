package wnderful.yummy.responseCode.baseResponseCode;

public enum GetFoodInfoCode {
    SUCCESS(0,"获取食品信息成功"),
    Fail(1,"无此食品");
    private int code;
    private String message;

    GetFoodInfoCode(int code, String message) {
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
