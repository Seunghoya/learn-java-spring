package learnjavaspring.core;

import learnjavaspring.core.discount.DiscountPolicy;
import learnjavaspring.core.discount.FixDiscountPolicy;
import learnjavaspring.core.discount.RateDiscountPolicy;
import learnjavaspring.core.member.MemberRepository;
import learnjavaspring.core.member.MemberService;
import learnjavaspring.core.member.MemberServiceImpl;
import learnjavaspring.core.member.MemoryMemberRepository;
import learnjavaspring.core.order.OrderService;
import learnjavaspring.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    // 애플리케이션에서 실제 동작이 필요한 구현 객체를 생성
    // ex) MemberServiceImpl, OrderServiceImpl, MemoryMemberRepository, FixDiscountPolicy ...

    // 생성한 객체 인스턴스의 참조를 생성자를 통해 주입해준다.
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public DiscountPolicy discountPolicy() {
        // 할인 정책을 변경하기 위해서 코드 단 한 줄만 수정하면 된다.
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

}
