package wnderful.yummy.responseCode.memberAddressResponseCode;

public enum ModifyAddressResCode {
    SUCCESS(0,"修改地址成功"),
    FAIL(1,"修改地址失败");
    private int code;
    private String message;

    ModifyAddressResCode(int code, String message) {
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
