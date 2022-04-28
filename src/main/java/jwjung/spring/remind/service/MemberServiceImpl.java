package jwjung.spring.remind.service;

import jwjung.spring.remind.domain.Member;
import jwjung.spring.remind.repository.MemberRepository;
import jwjung.spring.remind.repository.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public Long join(Member member) {
        memberRepository.save(member);
        return member.getId();
    }

    @Override
    public Optional<Member> findOne(Long memberId) {
        return Optional.empty();
    }

}
