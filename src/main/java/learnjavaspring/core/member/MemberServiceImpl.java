package learnjavaspring.core.member;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    // MemberRepository 인터페이스를 의존하지만 new MemmoryMemberRepository는 구현체를 의존하는 문제가 있다.(DIP OCP 위반사항)

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
