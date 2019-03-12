package wnderful.yummy.vo.managerVo;

import wnderful.yummy.entity.voEntity.managerVoEntity.SignUpApplication;

public class GetApplyListVo {
    private SignUpApplication[] applications;

    public GetApplyListVo(SignUpApplication[] applications) {
        this.applications = applications;
    }

    public GetApplyListVo() {
        applications = new SignUpApplication[1];
        applications[0] = new SignUpApplication();
    }

    public SignUpApplication[] getApplications() {
        return applications;
    }
}
