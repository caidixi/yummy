package wnderful.yummy.request.memberRequest;

public class GetRestDetailReq {
    private String uid;
    private String rid;

    public GetRestDetailReq() {
    }

    public GetRestDetailReq(String uid, String rid) {
        this.uid = uid;
        this.rid = rid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }
}
