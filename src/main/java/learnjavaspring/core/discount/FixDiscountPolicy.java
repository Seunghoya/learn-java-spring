package learnjavaspring.core.discount;

import learnjavaspring.core.annotation.MainDiscountPolicy;
import learnjavaspring.core.member.Grade;
import learnjavaspring.core.member.Member;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy // @Qualifier은 @Primary보다 우선순위를 가진다.
public class FixDiscountPolicy implements DiscountPolicy {
    // implememts shortcut => ctrl + i
    private int discountFixAmount = 1000; // 1000원 할인 적용

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
