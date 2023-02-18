package com.inf.sp1.order;

import com.inf.sp1.config.AppConfig;
import com.inf.sp1.member.Grade;
import com.inf.sp1.member.Member;
import com.inf.sp1.service.MemberService;
import com.inf.sp1.service.MemberServiceImpl;
import com.inf.sp1.service.OrderService;
import com.inf.sp1.service.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {

        //생성자 주입을 이용한 객체 생성
        AppConfig ac = new AppConfig();
        MemberService ms = ac.memberService();
        OrderService ods = ac.orderService();

        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);

        ms.join(member);
        Order order = ods.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
