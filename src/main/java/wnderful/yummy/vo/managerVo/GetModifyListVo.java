package wnderful.yummy.vo.managerVo;

import wnderful.yummy.entity.voEntity.managerVoEntity.ModApplication;

public class GetModifyListVo {
    private ModApplication[] applications;

    public GetModifyListVo(ModApplication[] applications) {
        this.applications = applications;
    }

    public GetModifyListVo() {
        applications = new ModApplication[1];
        applications[0] = new ModApplication();
    }

    public ModApplication[] getApplications() {
        return applications;
    }
}
