package com.inf.sp2.order;

import com.inf.sp2.config.AppConfig;
import com.inf.sp2.member.Grade;
import com.inf.sp2.member.Member;
import com.inf.sp2.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
//        AppConfig ac = new AppConfig();
//        MemberService memberService = ac.memberService();
//        OrderService orderService = ac.orderService();

        ApplicationContext actx = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = actx.getBean("memberService", MemberService.class);
        OrderService orderService = actx.getBean("orderService", OrderService.class);

        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);
        System.out.println("member = " + member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order);
    }
}
