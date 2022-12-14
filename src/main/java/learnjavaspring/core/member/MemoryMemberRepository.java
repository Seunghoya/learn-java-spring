package learnjavaspring.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    // 동시성 이슈가 있을 수 있기 때문에 HashMap가 아닌 ConcurrnetHashMap 사용을 권장함.
    // https://devlog-wjdrbs96.tistory.com/269

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
