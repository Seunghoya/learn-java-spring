package learnjavaspring.core;

import learnjavaspring.core.discount.FixDiscountPolicy;
import learnjavaspring.core.member.MemberService;
import learnjavaspring.core.member.MemberServiceImpl;
import learnjavaspring.core.member.MemoryMemberRepository;
import learnjavaspring.core.order.OrderService;
import learnjavaspring.core.order.OrderServiceImpl;

public class AppConfig {
    // 애플리케이션에서 실제 동작이 필요한 구현 객체를 생성
    // ex) MemberServiceImpl, OrderServiceImpl, MemoryMemberRepository, FixDiscountPolicy ...

    // 생성한 객체 인스턴스의 참조를 생성자를 통해 주입해준다.
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

}
