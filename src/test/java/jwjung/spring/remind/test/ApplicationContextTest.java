package jwjung.spring.remind.test;

import jwjung.spring.remind.config.MemberConfig;
import jwjung.spring.remind.repository.JpaMemberRepository;
import jwjung.spring.remind.repository.MemberRepository;
import jwjung.spring.remind.repository.MemoryMemberRepository;
import jwjung.spring.remind.service.MemberService;
import jwjung.spring.remind.service.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MemberConfig.class);

    @Test
    @DisplayName("회원 서비스 빈 찾아오기")
    void findMemberServiceBean() {
        MemberService memberService = ac.getBean(MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("회원 리포지토리 빈 찾아오기")
    void findMemberRepositoryBean() {
        MemberRepository memberRepository = ac.getBean(MemberRepository.class);
        Assertions.assertThat(memberRepository).isInstanceOf(MemoryMemberRepository.class);
    }

}
