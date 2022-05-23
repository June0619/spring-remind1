package jwjung.spring.remind.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class EmailSenderServiceTest {

    @Test
    void statefulTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(EmailSenderConfig.class);

        // 두명의 클라이언트가 각자 호출하는 상황이라고 가정한다
        EmailSenderService serviceA = ac.getBean(EmailSenderService.class);
        EmailSenderService serviceB = ac.getBean(EmailSenderService.class);

        String emailA = "addrA@email.com";
        String emailB = "addrB@email.co.kr";

        // 서로 다른 이메일을 대상으로 로직을 수행한다.
        serviceA.send(emailA);
        serviceB.send(emailB);

        String resultA = serviceA.getResult();
        String resultB = serviceB.getResult();

        System.out.println("resultA = " + resultA);
        assertThat(resultA).isNotEqualTo(emailA);

        ac.close();
    }


    //스프링 컨테이너를 위한 Config 객체
    static class EmailSenderConfig {
        @Bean
        public EmailSenderService emailSenderService() {
            return new EmailSenderService();
        }
    }
}