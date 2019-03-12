package wnderful.yummy.responseCode.baseResponseCode;

public enum RestaurantSignUpCode {
    SUCCESS(0,"餐厅注册申请已发送"),
    EMPTY(1,"输入信息不得为空"),
    EMAILEXIST(2,"账号已存在"),
    NAMEEXIST(3,"餐厅名不可重复"),
    WAIT(4,"已申请，请耐心等侯"),
    NOACCOUNT(5,"没有此银行账号");
    private int code;
    private String message;

    RestaurantSignUpCode(int code, String message) {
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
