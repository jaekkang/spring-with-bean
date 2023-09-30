package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
//        AppConfig ac = new AppConfig();
//        MemberService ms = ac.memberService();
//        OrderService os = ac.orderService();

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService ms = ac.getBean("memberService", MemberService.class);
        OrderService os = ac.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        ms.join(member);

        Order order = os.createOrder(memberId, "itemA", 20000);

        System.out.println("order = " + order);
    }
}
