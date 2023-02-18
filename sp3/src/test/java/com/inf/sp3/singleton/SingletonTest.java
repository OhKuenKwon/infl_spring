package com.inf.sp3.singleton;

import com.inf.sp3.config.AppConfig;
import com.inf.sp3.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {
    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig ac = new AppConfig();
        MemberService ms1 = ac.memberService();
        MemberService ms2 = ac.memberService();

        //참조값이 다른 것을 확인
        System.out.println("memberService1 =" + ms1);
        System.out.println("memberService2 =" + ms2);

        //ms1과 ms2는 서로 다름
        assertThat(ms1).isNotSameAs(ms2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 생성")
    void singletonServiceTest() {
        //아래와 같이 생성자를 이용하여 객체 생성할수 없음
        //SingletonService ss = new SingletonService();

        SingletonService ss1 = SingletonService.getInstance();
        SingletonService ss2 = SingletonService.getInstance();
        System.out.println("ss1 =" + ss1);
        System.out.println("ss2 =" + ss2);

        //ms1과 ms2는 서로 다름
        assertThat(ss1).isSameAs(ss2);
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService ms1 = ac.getBean("memberService", MemberService.class);
        MemberService ms2 = ac.getBean("memberService", MemberService.class);

        //참조값이 같음을 확인
        //스프링컨테이너에서 만들어지는 객체는 싱글톤 객체임을 알수 있음
        System.out.println("memberService1 =" + ms1);
        System.out.println("memberService2 =" + ms2);

        //ms1과 ms2는 서로 같음
        assertThat(ms1).isSameAs(ms2);
    }
}
