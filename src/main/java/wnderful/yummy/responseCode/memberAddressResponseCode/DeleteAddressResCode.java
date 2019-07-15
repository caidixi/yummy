package wnderful.yummy.responseCode.memberAddressResponseCode;

public enum DeleteAddressResCode {
    SUCCESS(0,"删除地址成功"),
    FAIL(1,"删除地址失败");
    private int code;
    private String message;

    DeleteAddressResCode(int code, String message) {
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
