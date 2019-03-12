package wnderful.yummy.dataServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wnderful.yummy.dao.module.MemberState;
import wnderful.yummy.dao.repository.MemberStateRepository;
import wnderful.yummy.dataService.MemberStateDataService;
import wnderful.yummy.entity.entityInModule.MemberStateName;

@Service
public class MemberStateDataServiceImpl implements MemberStateDataService {
    private MemberStateRepository memberStateRepository;

    @Autowired
    public MemberStateDataServiceImpl(MemberStateRepository memberStateRepository) {
        this.memberStateRepository = memberStateRepository;
        if(memberStateRepository.findAll().size()==0){
            memberStateRepository.save(new MemberState(MemberStateName.NORMAL.getStateName()));
            memberStateRepository.save(new MemberState(MemberStateName.CANCEL.getStateName()));
        }
    }

    @Override
    public MemberState getNormalState() {
        return memberStateRepository.findMemberStateByName(MemberStateName.NORMAL.getStateName());
    }

    @Override
    public MemberState getCancelState() {
        return memberStateRepository.findMemberStateByName(MemberStateName.CANCEL.getStateName());
    }
}
