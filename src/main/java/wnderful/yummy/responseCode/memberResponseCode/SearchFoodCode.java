package wnderful.yummy.responseCode.memberResponseCode;

public enum SearchFoodCode {
    SUCCESS(0,"搜索菜品成功");
    private int code;
    private String message;

    SearchFoodCode(int code, String message) {
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
