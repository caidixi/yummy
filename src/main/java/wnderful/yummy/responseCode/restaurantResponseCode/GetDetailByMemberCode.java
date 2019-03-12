package wnderful.yummy.responseCode.restaurantResponseCode;

public enum GetDetailByMemberCode {
    SUCCESS(0,"获取餐厅统计信息（会员）成功"),
    NOTEXIST(1,"餐厅不存在");
    private int code;
    private String message;

    GetDetailByMemberCode(int code, String message) {
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
