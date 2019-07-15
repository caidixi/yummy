package wnderful.yummy.responseCode.memberAddressResponseCode;

public enum  GetAddressListResCode {
    SUCCESS(0,"获取地址列表成功"),
    FAIL(1,"获取地址列表失败");
    private int code;
    private String message;

    GetAddressListResCode(int code, String message) {
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
