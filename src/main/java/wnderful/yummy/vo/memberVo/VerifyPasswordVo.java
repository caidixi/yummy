package wnderful.yummy.vo.memberVo;

public class VerifyPasswordVo {
    private String correct;

    public VerifyPasswordVo(String correct) {
        this.correct = correct;
    }

    public VerifyPasswordVo() {
    }

    public String getCorrect() {
        return correct;
    }
}
