package jwjung.spring.remind.test;

import jwjung.spring.remind.config.MemberAutoConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComponentScanTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MemberAutoConfig.class);

    @Test
    @DisplayName("전체 애플리케이션 빈 조회하기")
    void findAllBeans() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {

            BeanDefinition beanDefinition = ac.getBeanDefinition(beanName);

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {

                Object bean = ac.getBean(beanName);
                System.out.println("beanName = " + beanName + " | bean = " + bean);
            }
        }
    }
}
