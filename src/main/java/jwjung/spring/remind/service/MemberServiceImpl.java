package jwjung.spring.remind.service;

import jwjung.spring.remind.domain.Member;
import jwjung.spring.remind.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final  MemberRepository memberRepository;

    @Override
    @Transactional
    public Long join(Member member) {
        memberRepository.save(member);
        return member.getId();
    }

    @Override
    @Transactional
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }

}
