package jwjung.spring.remind.repository;

import jwjung.spring.remind.domain.Member;
import jwjung.spring.remind.domain.MemberGrade;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class JpaMemberRepositoryTest {

    @Autowired MemberRepository memberRepository;

    @Test
    @Transactional
    @DisplayName("회원 JPA 레포지터리 저장")
    void save() {
        //given
        Member member = Member.builder()
                .name("TEST_USER")
                .grade(MemberGrade.ADMIN)
                .build();

        memberRepository.save(member);

        //when
        Optional<Member> optionalMember = memberRepository.findOne(member.getId());
        Member findMember = optionalMember.orElseGet(Member::new);

        //then
        assertThat(findMember).isEqualTo(member);
        assertThat(findMember).isSameAs(member);
    }
}