package com.inf.sp1.service;

import com.inf.sp1.config.AppConfig;
import com.inf.sp1.member.Grade;
import com.inf.sp1.member.Member;
import com.inf.sp1.order.Order;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderServiceImplTest {

    MemberService ms;
    OrderService ods;

    @BeforeEach
    public void beforeEach(){
        AppConfig ac = new AppConfig();
        ms = ac.memberService();
        ods = ac.orderService();
    }

    @Test
    @DisplayName("주문 서비스 테스트")
    void orderServiceTest() {

        //given : mb1은 저장소에 저장하기 위한 Member 객체, od1은 주문 객체
        long memberId = 1L;
        Member mb = new Member(memberId, "memberA", Grade.VIP);

        //when : mb1을 저장소에 저장-join, 저장된 객체를 조회하여 fMb에 대입-findMember
        ms.join(mb);
        Member fMb = ms.findMember(1L);
        Order fods = ods.createOrder(memberId, "itemA", 10000);

        //then : 저장하기전 데이터와 저장후 데이터 비교
        Assertions.assertThat(fods.getDiscountPrice()).isEqualTo(1000);

        System.out.println("fMb.getId() = " + fMb.getId());
        System.out.println("fMb.getName() = " + fMb.getName());
        System.out.println("fMb.getGrade() = " + fMb.getGrade());
        System.out.println("fods.getItemName() = " + fods.getItemName());
        System.out.println("fods.getItemPrice() = " + fods.getItemPrice());
        System.out.println("fods.getDiscountPrice() = " + fods.getDiscountPrice());
    }
}