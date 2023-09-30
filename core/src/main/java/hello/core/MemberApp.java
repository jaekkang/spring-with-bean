package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig ac = new AppConfig();
//        MemberService ms = ac.memberService();

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService ms =  ac.getBean("memberService", MemberService.class);

        Member m = new Member(1L, "memberA", Grade.VIP);
        ms.join(m);

        Member findMember = ms.findMember(1L);
        System.out.println("new m = " + m.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
