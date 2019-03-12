package wnderful.yummy.vo.memberVo;

public class PayOrderVo {
    private String uid;
    private String oid;

    public PayOrderVo() {
    }

    public PayOrderVo(String uid, String oid) {
        this.uid = uid;
        this.oid = oid;
    }

    public String getUid() {
        return uid;
    }

    public String getOid() {
        return oid;
    }
}
