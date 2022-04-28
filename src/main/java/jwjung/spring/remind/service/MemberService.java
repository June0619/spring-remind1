package jwjung.spring.remind.service;

import jwjung.spring.remind.domain.Member;

import java.util.Optional;

public interface MemberService {

    Long join(Member member);
    Optional<Member> findOne(Long memberId);
}
