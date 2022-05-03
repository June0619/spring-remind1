package jwjung.spring.remind.repository;

import jwjung.spring.remind.domain.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public class MemoryMemberRepository implements MemberRepository {

    private static HashMap<Long, Member> memory = new HashMap<>();
    private static long sequence;

    @Override
    public void save(Member member) {
        member.setId(++sequence);
        memory.put(member.getId(), member);
    }

    @Override
    public Optional<Member> findOne(Long memberId) {
        return Optional.ofNullable(memory.get(memberId));
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(memory.values());
    }
}
