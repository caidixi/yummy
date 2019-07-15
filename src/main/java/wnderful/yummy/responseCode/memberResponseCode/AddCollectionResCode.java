package wnderful.yummy.responseCode.memberResponseCode;

public enum AddCollectionResCode {
    SUCCESS(0,"添加收藏成功"),
    FAIL(1,"添加收藏失败");
    private int code;
    private String message;

    AddCollectionResCode(int code, String message) {
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
