package wnderful.yummy.responseCode.memberResponseCode;

public enum ModPasswordCode {
    SUCCESS(0,"修改会员密码成功"),
    NOTEXIST(1,"用户不存在"),
    CANCEL(2,"用户已注销"),
    EMPTY(3,"密码不得为空"),
    REPEAT(4,"新旧密码不可重复"),
    WRONG(5,"密码错误"),
    CODEERROR(6,"验证码错误");
    private int code;
    private String message;

    ModPasswordCode(int code, String message) {
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
