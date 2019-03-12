package wnderful.yummy.responseCode.memberResponseCode;

public enum ModMemberInfoCode {
    SUCCESS(0,"修改会员信息成功"),
    NOTEXIST(1,"用户不存在"),
    CANCEL(2,"用户已注销"),
    EMPTYADDRESS(3,"姓名与首地址不得为空");
    private int code;
    private String message;

    ModMemberInfoCode(int code, String message) {
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
