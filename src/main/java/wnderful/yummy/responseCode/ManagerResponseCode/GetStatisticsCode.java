package wnderful.yummy.responseCode.ManagerResponseCode;

public enum GetStatisticsCode {
    SUCCESS(0,"获取统计信息成功");
    private int code;
    private String message;

    GetStatisticsCode(int code, String message) {
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
