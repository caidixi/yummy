package wnderful.yummy.responseCode;

public enum GlobalRepCode {
    SERVERFAIL(-100,"服务器异常"),
    TOKENERROR(-101,"token错误");


    private int code;
    private String message;

    GlobalRepCode(int code, String message) {
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
