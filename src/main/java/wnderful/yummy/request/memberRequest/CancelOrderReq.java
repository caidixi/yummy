package wnderful.yummy.request.memberRequest;

public class CancelOrderReq {
    private String uid;
    private String oid;

    public CancelOrderReq() {
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
