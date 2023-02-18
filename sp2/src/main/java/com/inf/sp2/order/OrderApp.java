package com.inf.sp2.order;

import com.inf.sp2.config.AppConfig;
import com.inf.sp2.member.Grade;
import com.inf.sp2.member.Member;
import com.inf.sp2.service.MemberService;
import com.inf.sp2.service.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {

        //생성자 주입을 이용한 객체 생성
        //AppConfig ac = new AppConfig();
        //MemberService ms = ac.memberService();
        //OrderService ods = ac.orderService();

        //스프링컨테이너(ApplicatioContext)를 이용한 객체 생성 - 1. Bean 방식
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        //Bean 이름은 메소드이름을 사용
        //  --> @Bean(name="memberService2")로 직접 부여할수도 있음
        MemberService ms = ac.getBean("memberService", MemberService.class);
        OrderService ods = ac.getBean("orderService", OrderService.class);

        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);

        ms.join(member);
        Order order = ods.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
