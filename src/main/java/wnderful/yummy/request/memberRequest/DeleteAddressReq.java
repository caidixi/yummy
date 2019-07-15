package wnderful.yummy.request.memberRequest;

public class DeleteAddressReq {
    private String uid;
    private String addressId;

    public DeleteAddressReq() {
    }

    public DeleteAddressReq(String uid, String addressId) {
        this.uid = uid;
        this.addressId = addressId;
    }

    public String getUid() {
        return uid;
    }

    public String getAddressId() {
        return addressId;
    }
}
