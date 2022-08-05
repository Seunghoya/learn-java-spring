package learnjavaspring.core.discount;

import learnjavaspring.core.member.Grade;
import learnjavaspring.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary // DiscountPolicy처럼 같은 이름의 빈이 여러개 있을 때 우선순위를 갖는다.
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
