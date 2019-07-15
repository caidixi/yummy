package wnderful.yummy.responseCode.memberResponseCode;

public enum ModifyAvatarCode {
    SUCCESS(0,"修改头像成功"),
    NOTEXIST(1,"用户不存在"),
    FAIL(2,"修改头像失败");
    private int code;
    private String message;

    ModifyAvatarCode(int code, String message) {
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
