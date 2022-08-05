package learnjavaspring.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    // AppConfig를 통해 memberRepository를 주입받아 memberRepository에 할당해줌으로써(생성자 주입)
    // 기존의 의존성 문제(DIP원칙)를 해결.

    // MemberServiceImpl입장에서 생성자를 통해 어떤 구현객체가 들어올 지 알 수 없고
    // 의존관계에 대한 문제는 외부에 맡긴채 기능 구현에만 집중한다.

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
