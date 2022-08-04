package learnjavaspring.core;

import learnjavaspring.core.member.Grade;
import learnjavaspring.core.member.Member;
import learnjavaspring.core.member.MemberService;
import learnjavaspring.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        MemberService memberService = new MemberServiceImpl();
        // 이제 memberService는 AppConfig에서 가져와야 한다.

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        Member member = new Member(1L, "memberA", Grade.VIP);
//        memberService.join(member);

        // Spring 적용
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}
