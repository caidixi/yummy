package wnderful.yummy.responseCode.managerResponseCode;

public enum ApproveModificationCode {
    SUCCESS(0,"审核修改餐厅信息申请成功"),
    NOTEXIST(1,"经理不存在"),
    FAIL(2,"无修改申请");
    private int code;
    private String message;

    ApproveModificationCode(int code, String message) {
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
