package wnderful.yummy.vo.commonVo;

public class LogInVo {
    private String token;
    private String type;
    private String id;
    private String name;

    public LogInVo() {
    }

    public LogInVo(String token, String type, String id,String name) {
        this.token = token;
        this.type = type;
        this.id = id;
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
