package learnjavaspring.core;

import learnjavaspring.core.member.Grade;
import learnjavaspring.core.member.Member;
import learnjavaspring.core.member.MemberService;
import learnjavaspring.core.member.MemberServiceImpl;
import learnjavaspring.core.order.Order;
import learnjavaspring.core.order.OrderService;
import learnjavaspring.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order = " + order.calculatePrice());

    }
}
