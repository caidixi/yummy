package wnderful.yummy.vo.commonVo;

public class LogInVo {
    private String type;
    private String id;
    private String name;

    public LogInVo() {
    }

    public LogInVo(String type, String id,String name) {
        this.type = type;
        this.id = id;
        this.name = name;
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
