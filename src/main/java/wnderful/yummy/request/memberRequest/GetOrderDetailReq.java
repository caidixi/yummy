package wnderful.yummy.request.memberRequest;

public class GetOrderDetailReq {
    private String uid;
    private String oid;

    public GetOrderDetailReq() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }
}
