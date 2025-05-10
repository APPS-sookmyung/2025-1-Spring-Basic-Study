package Hello.Hello_spring.repository;

import org.springframework.stereotype.Repository;
import java.util.*;

public class MemotyMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Memver> findById(Long id) { return Optional.ofNullable(store.get(id)); }

    @Override
    public Optional<Member> findByName(String name){
        return store.values().stream().filter(m -> m.getName().equals(name)).findAny();
    }
}



