package com.inf.sp3.singleton;

import com.inf.sp3.config.AppConfig;
import com.inf.sp3.repository.MemberRepository;
import com.inf.sp3.service.MemberServiceImpl;
import com.inf.sp3.service.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {
    @Test
    @DisplayName("스프링컨테이너에서 생성된 객체의 싱글톤 확인")
    void configTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl ms = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl os = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository mr1 = ac.getBean("memberRepository", MemberRepository.class);

        MemberRepository mr2 = ms.getMemberRepository();
        MemberRepository mr3 = os.getMemberRepository();

        System.out.println("mr1->memberRepository = " + mr1);
        System.out.println("mr2->memberRepository = " + mr2);
        System.out.println("mr->memberRepository = " + mr3);

        //위 3개 모두 같은 인스턴스로 조회된다.

        Assertions.assertThat(ms.getMemberRepository()).isSameAs(mr1);
        Assertions.assertThat(os.getMemberRepository()).isSameAs(mr1);
    }

    @Test
    @DisplayName("@Configuration 과 싱글톤")
    void configDeep() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);
        System.out.println("bean = " + bean.getClass());

        //출력하면, AppConfig@CGLIB 가 보임 --> 이 클래스가 싱글톤을 보장하도록 함
        //AppConfig의 바이트코드 생성과정에서 컨테이너에서 AppConfig@CGLIB로 변경
        //같은 객체가 여러번 호출될때 이 AppConfig@CGLIB가 내부적으로 처음 생성되는
        //Bean은 새로 등록하지만, 그 이후부터는 한번 등록된 것은 기존의 것을 return 해줌
        //단, 이렇게 되는 이유는 AppConfig에서 @Configuration을 넣어두었기 때문이다.
        //만약 @Configuration이 없으면 싱글톤이 보장되지 않음
    }
}
