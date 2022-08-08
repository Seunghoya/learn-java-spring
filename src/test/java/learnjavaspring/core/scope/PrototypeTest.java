package learnjavaspring.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.*;

public class PrototypeTest {
    // 프로토타입 빈은 싱글톤 빈과는 다르게 클라이언트 요청이 있을 때 생성되었다가 생성된 빈을 반환하면 삭제된다.
    // 다른 스프링 컨테이너에 같은 요청이 오면 새로운 프로토타입 빈을 생성해 반환하고 다시 삭제되는 일을 반복한다.

    // 핵심은 스프링 컨테이너는 프로토타입 빈을 생성하고 DI, 초기화 까지만 처리한다는 것이다.

    // 클라이언트에 빈을 반환한 이후 스프링 컨테이너는 더이상 프로토타입 빈을 관리하지 않는다.
    // 따라서 @PreDestroy같은 종료 메서드를 호출하지 않는다.

    @Test
    public void prototypeBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);

        System.out.println("find prototypeBean1");
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);

        System.out.println("find prototypeBean2");
        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);

        System.out.println("prototypeBean1 = " + prototypeBean1);
        System.out.println("prototypeBean2 = " + prototypeBean2);

        assertThat(prototypeBean1).isNotSameAs(prototypeBean2);
        ac.close();

    }

    @Scope("prototype")
    static class PrototypeBean {
        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("PrototypeBean.destroy");
        }
    }
}
