package learnjavaspring.core.beanfind;

import learnjavaspring.core.AppConfig;
import learnjavaspring.core.member.MemberService;
import learnjavaspring.core.member.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class ApplicationContextBasicFindTest {
    // 스프링 컨테이너에서 스프링 빈을 찾는 방법 => getBean()을 활용
    // getBean(타입) or getBean(빈이름, 타입)
    // 조회 대상 스프링 빈이 없으면 예외 발생 => NoSuchBeanDefinitionException

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("타입으로만 조회")
    void findBeanByType() {
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2() {
        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회X")
    void findBeanByNameX() {
//        MemberService xxxx = ac.getBean("xxxx", MemberService.class);
        Assertions.assertThrows(
                NoSuchBeanDefinitionException.class,
                () -> ac.getBean("xxxx", MemberService.class)
                // 아래의 로직이 실행될 때, 위의 에러가 발생해야 성공.
        );
    }
}
