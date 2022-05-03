package jwjung.spring.remind.service;

import jwjung.spring.remind.domain.Member;
import jwjung.spring.remind.domain.MemberGrade;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Transactional(readOnly = true)
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class MemberServiceImplSpringTest {

    @Autowired private MemberService memberService;
    @Autowired private EntityManager em;

    @Test
    @Transactional
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
        em.flush();
    }
}
