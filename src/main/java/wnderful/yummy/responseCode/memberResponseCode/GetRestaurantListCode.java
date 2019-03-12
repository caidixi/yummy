package wnderful.yummy.responseCode.memberResponseCode;

public enum GetRestaurantListCode {
    SUCCESS(0,"获取饭馆成功");
    private int code;
    private String message;

    GetRestaurantListCode(int code, String message) {
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
