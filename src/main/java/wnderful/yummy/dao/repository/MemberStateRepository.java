package wnderful.yummy.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wnderful.yummy.dao.module.MemberState;

public interface MemberStateRepository extends JpaRepository<MemberState,String> {
    MemberState findMemberStateByName(String name);
}
