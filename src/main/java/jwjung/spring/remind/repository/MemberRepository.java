package jwjung.spring.remind.repository;

import jwjung.spring.remind.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    void save(Member member);

    Optional<Member> findOne(Long memberId);

    List<Member> findAll();



}
