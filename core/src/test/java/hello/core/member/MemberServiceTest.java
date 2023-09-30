package hello.core.member;

import hello.core.AppConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService ms;
    @BeforeEach
    public void beforeEach() {
        AppConfig ac = new AppConfig();
        ms =  ac.memberService();
    }

    @Test
    void join() {
        // given
        Member m = new Member(1L, "memberA", Grade.VIP);

        //when
        ms.join(m);
        Member fm = ms.findMember(1L);
        //then
        Assertions.assertEquals(m, fm);
    }
}
