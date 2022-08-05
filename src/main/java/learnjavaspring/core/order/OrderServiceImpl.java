package learnjavaspring.core.order;

import learnjavaspring.core.discount.DiscountPolicy;
import learnjavaspring.core.discount.FixDiscountPolicy;
import learnjavaspring.core.discount.RateDiscountPolicy;
import learnjavaspring.core.member.Member;
import learnjavaspring.core.member.MemberRepository;
import learnjavaspring.core.member.MemberServiceImpl;
import learnjavaspring.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    /*
    * 할인 정책이 변경될 때 DIP 원칙이 지켜지지 않는다.
    * OrderServiceImpl는 OrderService를 의존하고 있으면서 동시에 DiscountPolicy를 함께 의존하고 있다.
    * 의존성 문제를 해결하기 위해서 관심사 분리를 적용해야 한다. */

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트 용도

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
