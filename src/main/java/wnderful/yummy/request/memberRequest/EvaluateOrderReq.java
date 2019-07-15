package wnderful.yummy.request.memberRequest;

public class EvaluateOrderReq {
    private String uid;
    private String oid;
    private int point;

    public EvaluateOrderReq() {
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

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
