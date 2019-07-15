package wnderful.yummy.responseCode.memberResponseCode;

public enum GetCollectionListResCode {
    SUCCESS(0,"获取收藏列表成功"),
    FAIL(1,"获取收藏列表失败");
    private int code;
    private String message;

    GetCollectionListResCode(int code, String message) {
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
