package jwjung.spring.remind.config;

import jwjung.spring.remind.repository.JpaMemberRepository;
import jwjung.spring.remind.repository.MemberRepository;
import jwjung.spring.remind.repository.MemoryMemberRepository;
import jwjung.spring.remind.service.MemberService;
import jwjung.spring.remind.service.MemberServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class MemberConfig {

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

}
