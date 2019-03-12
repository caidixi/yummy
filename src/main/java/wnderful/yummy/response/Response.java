package wnderful.yummy.response;

public class Response {
    private int result;
    private String opinion;

    public Response() {
    }

    public Response(int result, String opinion) {
        this.result = result;
        this.opinion = opinion;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }
}
