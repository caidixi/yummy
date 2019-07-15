package wnderful.yummy.responseCode.managerResponseCode;

public enum ApproveApplicationCode {
    SUCCESS(0,"审核注册申请成功"),
    NOTEXIST(1,"经理不存在"),
    FAIL(2,"餐厅无法审核");
    private int code;
    private String message;

    ApproveApplicationCode(int code, String message) {
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
