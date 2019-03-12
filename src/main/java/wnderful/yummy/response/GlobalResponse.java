package wnderful.yummy.response;


import wnderful.yummy.responseCode.GlobalRepCode;

public class GlobalResponse extends Response {

    public GlobalResponse(GlobalRepCode repCode) {
        this.setResult(repCode.getCode());
        this.setOpinion(repCode.getMessage());
    }
}
