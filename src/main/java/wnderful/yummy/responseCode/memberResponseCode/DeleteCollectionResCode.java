package wnderful.yummy.responseCode.memberResponseCode;

public enum DeleteCollectionResCode {
    SUCCESS(0,"删除收藏成功"),
    FAIL(1,"删除收藏失败");
    private int code;
    private String message;

    DeleteCollectionResCode(int code, String message) {
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
