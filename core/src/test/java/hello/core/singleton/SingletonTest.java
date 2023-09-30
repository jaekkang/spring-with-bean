package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

public class SingletonTest {

    @Test
    @DisplayName("singleton이 없는 순수한 DI container")
    void PureContainer() {
        AppConfig ac = new AppConfig();

        // 1. 조회할때마다 객체 생성
        MemberService memberService1 = ac.memberService();

        // 2. 조회할때마다 객체 생성
        MemberService memberService2 = ac.memberService();

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);
    }

    @Test
    @DisplayName("use accept Singleton pattern object")
    void SingletonContainer() {

        SingletonService s1 = SingletonService.getInstance();
        SingletonService s2 = SingletonService.getInstance();

        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);

        assertSame(s1,s2);
    }

    @Test
    @DisplayName("Singleton pattern and Spring Container")
    void springContainer() {
//        AppConfig ac = new AppConfig();
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        // 1. 조회할때마다 객체 생성
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);

        // 2. 조회할때마다 객체 생성
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);
    }
}
