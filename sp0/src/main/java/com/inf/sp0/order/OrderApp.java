package com.inf.sp0.order;

import com.inf.sp0.member.Grade;
import com.inf.sp0.member.Member;
import com.inf.sp0.service.MemberService;
import com.inf.sp0.service.MemberServiceImpl;
import com.inf.sp0.service.OrderService;
import com.inf.sp0.service.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {

        MemberService ms = new MemberServiceImpl();
        OrderService ods = new OrderServiceImpl();

        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);

        ms.join(member);
        Order order = ods.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
