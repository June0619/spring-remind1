package jwjung.spring.remind.config;

import jwjung.spring.remind.repository.MemberRepository;
import jwjung.spring.remind.repository.MemoryMemberRepository;
import jwjung.spring.remind.service.MemberService;
import jwjung.spring.remind.service.MemberServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class MemberConfig {

//    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

//    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

}
