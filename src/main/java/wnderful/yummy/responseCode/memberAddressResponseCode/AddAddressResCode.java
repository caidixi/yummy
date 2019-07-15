package wnderful.yummy.responseCode.memberAddressResponseCode;

public enum AddAddressResCode {
    SUCCESS(0,"添加地址成功"),
    FAIL(1,"添加地址失败");
    private int code;
    private String message;

    AddAddressResCode(int code, String message) {
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
