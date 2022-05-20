package jwjung.spring.remind.singleton;

import jwjung.spring.remind.config.MemberAutoConfig;
import jwjung.spring.remind.config.MemberConfig;
import jwjung.spring.remind.repository.MemberRepository;
import jwjung.spring.remind.service.MemberService;
import org.apache.catalina.core.ApplicationContext;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class ConfigurationSingletonTest {

    @Test
    @DisplayName("[테스트] 스프링 컨테이너 싱글톤 테스트")
    void autoConfigurationSingletonTest() {

        // given
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MemberAutoConfig.class);
        MemberService memberServiceA = ac.getBean(MemberService.class);
        MemberService memberServiceB = ac.getBean(MemberService.class);

        // then

        System.out.println("memberServiceA = " + memberServiceA);
        System.out.println("memberServiceB = " + memberServiceB);
        assertThat(memberServiceA).isSameAs(memberServiceB);

        ac.close();
    }

    @Test
    void configurationTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MemberConfig.class);
        MemberConfig memberConfig = ac.getBean(MemberConfig.class);

        System.out.println("memberConfig = " + memberConfig);
        ac.close();
    }

}
