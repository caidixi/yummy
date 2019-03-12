package wnderful.yummy.request.restaurantRequest;

public class DeleteFoodReq {
    private String rid;
    private String fid;

    public DeleteFoodReq() {
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }
}
