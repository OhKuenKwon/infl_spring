package com.inf.sp3.order;

import com.inf.sp3.config.AppConfig;
import com.inf.sp3.member.Grade;
import com.inf.sp3.member.Member;
import com.inf.sp3.service.MemberService;
import com.inf.sp3.service.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig ac = new AppConfig();
        memberService = ac.memberService();
        orderService = ac.orderService();
    }

    @Test
    void createOrder() {
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

        memberId = 2L;
        member = new Member(memberId, "memberB", Grade.VIP);
        memberService.join(member);
        order = orderService.createOrder(memberId, "itemB", 20000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(2000);
    }

}