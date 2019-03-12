package wnderful.yummy.dataService;

import wnderful.yummy.dao.module.MemberState;

public interface MemberStateDataService {
    MemberState getNormalState();

    MemberState getCancelState();
}
