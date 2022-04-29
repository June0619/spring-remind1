package jwjung.spring.remind.service;

import jwjung.spring.remind.domain.Member;
import jwjung.spring.remind.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

public class MemberServiceImpl implements MemberService {

    private MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Long join(Member member) {
        memberRepository.save(member);
        return member.getId();
    }

    @Override
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }

}
