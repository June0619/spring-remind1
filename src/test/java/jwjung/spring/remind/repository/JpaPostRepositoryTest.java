package jwjung.spring.remind.repository;

import jwjung.spring.remind.domain.Member;
import jwjung.spring.remind.domain.MemberGrade;
import jwjung.spring.remind.domain.Post;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class JpaPostRepositoryTest {

    @Autowired private PostRepository postRepository;

    @Test
    @Transactional
    @DisplayName("포스트 JPA 레포지터리 저장")
    void save() {

        //given
        Member author = Member.builder()
                .name("testMember")
                .grade(MemberGrade.USER)
                .build();

        Post post = Post.builder()
                .author(author)
                .text("본문 테스트")
                .build();

        postRepository.save(post);

        //when
        Post findPost = postRepository.findOne(post.getId()).get();
        Member findAuthor = findPost.getAuthor();

        //then
        assertThat(findPost).isEqualTo(post);
        assertThat(findAuthor).isEqualTo(author);

    }



}
