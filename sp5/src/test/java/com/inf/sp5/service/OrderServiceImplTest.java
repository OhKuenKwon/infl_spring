package com.inf.sp5.service;

import com.inf.sp5.AutoAppConfig;
import com.inf.sp5.discount.DiscountPolicy;
import com.inf.sp5.member.Grade;
import com.inf.sp5.member.Member;
import com.inf.sp5.order.Order;
import com.inf.sp5.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    ApplicationContext actx = new AnnotationConfigApplicationContext(AutoAppConfig.class);

    @Test
    @DisplayName("주문 서비스 테스트")
    void orderServiceTest() {

        MemberService ms = actx.getBean( MemberService.class);
        OrderService ods = actx.getBean( OrderService.class);

        //given : mb1은 저장소에 저장하기 위한 Member 객체, od1은 주문 객체
        long memberId = 1L;
        Member mb = new Member(memberId, "memberA", Grade.VIP);

        //when : mb1을 저장소에 저장-join, 저장된 객체를 조회하여 fMb에 대입-findMember
        ms.join(mb);
        Member fMb = ms.findMember(1L);
        Order fOds = ods.createOrder(memberId, "itemA", 10000);

        //then : 저장하기전 데이터와 저장후 데이터 비교
        //Assertions.assertThat(fOds.getDiscountPrice()).isEqualTo(1000); //Fix
        Assertions.assertThat(fOds.getDiscountPrice()).isEqualTo(2000);   //Rate

        System.out.println("fMb.getId() = " + fMb.getId());
        System.out.println("fMb.getName() = " + fMb.getName());
        System.out.println("fMb.getGrade() = " + fMb.getGrade());
        System.out.println("fOds.getItemName() = " + fOds.getItemName());
        System.out.println("fOds.getItemPrice() = " + fOds.getItemPrice());
        System.out.println("fOds.getDiscountPrice() = " + fOds.getDiscountPrice());
    }

    @Test
    @DisplayName("DiscountPolicy 타입의 빈 모두 조회하기")
    void findAllBeanByParentType1() {
        Map<String, DiscountPolicy> beansOfType = actx.getBeansOfType(DiscountPolicy.class);
        Assertions.assertThat(beansOfType.size()).isEqualTo(2);
        for(String key: beansOfType.keySet()){
            System.out.println("key = " + key + " value = " + beansOfType.get(key));
        }
    }

    @Test
    @DisplayName("MemberRepository 타입의 빈 모두 조회하기")
    void findAllBeanByParentType2() {
        Map<String, MemberRepository> beansOfType = actx.getBeansOfType(MemberRepository.class);
        Assertions.assertThat(beansOfType.size()).isEqualTo(1);
        for(String key: beansOfType.keySet()){
            System.out.println("key = " + key + " value = " + beansOfType.get(key));
        }
    }
}