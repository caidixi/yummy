package wnderful.yummy.responseCode.ManagerResponseCode;

public enum GetApplyListCode {
    SUCCESS(0,"获取注册申请列表成功");
    private int code;
    private String message;

    GetApplyListCode(int code, String message) {
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
