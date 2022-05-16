package jwjung.spring.remind.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional(readOnly = true)
public class JpaPostRepositoryTest {

    @Test
    @Transactional
    @DisplayName("포스트 JPA 레포지터리 저장")
    void save() {

    }



}
