package learnjavaspring.core.autowired;

import learnjavaspring.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }

    static class TestBean {
        @Autowired(required = false)
        public void setNoBean1(Member noBean1) {
            // 호출안됨
            // 자동 주입할 대상이 없으면 메서드 자체가 호출되지 않는다.
            System.out.println("noBean1 = " + noBean1);
        }

        @Autowired
        public void setNoBean2(@Nullable Member noBean2) {
            // 호출은 되나 값이 null로 들어온다.
            System.out.println("noBean2 = " + noBean2);
        }

        @Autowired
        public void setNoBean3(Optional<Member> noBean3) {
            // 호출은 되나 값이 Optional.empty로 들어온다.
            System.out.println("noBean3 = " + noBean3);
        }
    }
}
