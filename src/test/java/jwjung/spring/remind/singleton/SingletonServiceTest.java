package jwjung.spring.remind.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class SingletonServiceTest {

    @Test
    @DisplayName("[테스트] 자바 싱글톤 테스트")
    void singletonTest() {
        // private 기본생성자를 통해 다음과 같이 신규 객체를 선언할 수 없다.
//        SingletonService singletonService = new SingletonService();

        // 다음과 같이 두개의 싱글톤 서비스 객체를 선언한다고 가정하자.
        SingletonService singletonServiceA = SingletonService.getInstance();
        SingletonService singletonServiceB = SingletonService.getInstance();

        // 선언해 둔 메서드를 통해 참조값도 실제로 확인해보자.
        singletonServiceA.singletonObjectCall();
        singletonServiceB.singletonObjectCall();

        // isSameAs 메서드를 통해 참조값이 같은지 테스트한다.
        assertThat(singletonServiceA).isSameAs(singletonServiceB);
    }

}
