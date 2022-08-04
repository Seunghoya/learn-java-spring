package learnjavaspring.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {
    // 싱글톤 방식의 주의점

    /*
     * 싱글톤 방식은 기본적으로 여러 클라이언트가 하나의 객체 인스턴스를 공유하기 때문에
     * 싱글톤 객체는 상태를 유지(stateful)하게 설계하면 안된다.
     *
     * 무상태(stateless)로 설계해야 한다.
     * -> 특정 클라이언트에 의존적인 필드가 있으면 안된다.
     *    특정 클라이언트가 값을 변경할 수 있는 필드가 있으면 안된다.
     *    가급적 읽기만 가능해야 한다.
     *    필드 대신 자바에서 공유되지 않는 지역변수, 파라미터, ThreadLocal을 사용해야 한다.
     *
     * 스프링 빈의 필드에 공유값을 설정하면 정말 큰 장애가 발생할 수 있다.
     * */

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);


        // ThreadA: A사용자 10000원 주문
        statefulService1.order("userA", 10000);

        // ThreadB: B사용자 20000원 주문
        statefulService2.order("userB", 20000);

        // ThreadA: 사용자A 주문금액 조회
        int price = statefulService1.getPrice();
        System.out.println("price = " + price);

        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}