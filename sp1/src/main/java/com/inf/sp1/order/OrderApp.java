package com.inf.sp1.order;

import com.inf.sp1.config.AppConfig;
import com.inf.sp1.member.Grade;
import com.inf.sp1.member.Member;
import com.inf.sp1.member.MemberService;
import com.inf.sp1.member.MemberServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig ac = new AppConfig();
        MemberService memberService = ac.memberService();
        OrderService orderService = ac.orderService();

        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);
        System.out.println("member = " + member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order);
    }
}
