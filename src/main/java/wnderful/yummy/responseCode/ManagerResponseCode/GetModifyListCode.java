package wnderful.yummy.responseCode.ManagerResponseCode;

public enum GetModifyListCode {
    SUCCESS(0,"获取餐厅信息修改申请列表成功");
    private int code;
    private String message;

    GetModifyListCode(int code, String message) {
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
