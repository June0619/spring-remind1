package jwjung.spring.remind.service;

import jwjung.spring.remind.repository.MemberRepository;
import jwjung.spring.remind.repository.MemoryMemberRepository;
import jwjung.spring.remind.domain.Member;
import jwjung.spring.remind.domain.MemberGrade;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MemberServiceImplTest {

    private MemberService memberService;

    @BeforeEach
    void beforeEach() {
        MemberRepository memberRepository = new MemoryMemberRepository();
        this.memberService = new MemberServiceImpl(memberRepository);
    }

    @Test
    @DisplayName("[단위] 회원가입 성공")
    void join() {
        //given
        Member member = Member.builder()
                .name("TEST_MAN")
                .grade(MemberGrade.USER)
                .build();

        //when
        Long joinedId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(joinedId).get();
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getGrade()).isEqualTo(member.getGrade());
    }

}