package wnderful.yummy.vo.managerVo;

public class MemberStatisticsVo {
    private int memberNumber;
    private int logOffMemberNumber;

    public MemberStatisticsVo() {
    }

    public MemberStatisticsVo(int memberNumber, int logOffMemberNumber) {
        this.memberNumber = memberNumber;
        this.logOffMemberNumber = logOffMemberNumber;
    }

    public int getLogOffMemberNumber() {
        return logOffMemberNumber;
    }

    public int getMemberNumber() {
        return memberNumber;
    }
}
