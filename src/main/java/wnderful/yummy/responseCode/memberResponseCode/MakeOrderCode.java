package wnderful.yummy.responseCode.memberResponseCode;

public enum MakeOrderCode {
    SUCCESS(0,"提交订单成功"),
    NOTEXIST(1,"用户不存在"),
    CANCEL(2,"用户已注销"),
    RESTNOTEXIST(3,"餐厅不存在"),
    EMPTYADDRESS(4,"地址不得为空"),
    FOODNOTEXIST(5,"部分食物不存在"),
    FULL(6,"部分食物已售罄");
    private int code;
    private String message;

    MakeOrderCode(int code, String message) {
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
