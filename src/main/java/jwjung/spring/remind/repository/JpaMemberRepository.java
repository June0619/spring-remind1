package jwjung.spring.remind.repository;

import jwjung.spring.remind.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository {

    @Override
    public void save(Member member) {

    }

    @Override
    public Optional<Member> findOne(Long memberId) {
        return Optional.empty();
    }

    @Override
    public List<Member> findAll() {
        return null;
    }
}
