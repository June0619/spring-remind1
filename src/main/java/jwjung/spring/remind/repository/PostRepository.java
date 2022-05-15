package jwjung.spring.remind.repository;

import jwjung.spring.remind.domain.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepository {

    void save(Post post);
    Optional<Post> findOne(Long postId);
    List<Post> findAll();
}
