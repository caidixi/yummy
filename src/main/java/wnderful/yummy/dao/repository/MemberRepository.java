package wnderful.yummy.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wnderful.yummy.dao.module.Member;
import wnderful.yummy.dao.module.MemberState;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member,Long> {
    Member findMemberByEmail(String email);

    Member findMemberByUid(Long uid);

    List<Member> findByMemberState(MemberState memberState);
}
