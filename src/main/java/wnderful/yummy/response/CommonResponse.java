package wnderful.yummy.response;

public class CommonResponse extends Response {
    private Object body;

    public CommonResponse() {
    }

    public CommonResponse(int result, String opinion) {
        super(result, opinion);
    }

    public CommonResponse(int result, String opinion, Object body) {
        super(result, opinion);
        this.body = body;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
