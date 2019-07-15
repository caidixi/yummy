package wnderful.yummy.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wnderful.yummy.dao.module.Member;
import wnderful.yummy.dao.module.MemberState;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member,Long> {

    Member findMemberByUid(Long uid);

    Member findMemberByPhone(String phone);

    Member findMemberByName(String name);

    List<Member> findByMemberState(MemberState memberState);
}
