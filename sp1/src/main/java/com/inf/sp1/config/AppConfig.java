package com.inf.sp1.config;

import com.inf.sp1.discount.RateDiscountPolicy;
import com.inf.sp1.member.MemberService;
import com.inf.sp1.member.MemberServiceImpl;
import com.inf.sp1.member.MemoryMemberRepository;
import com.inf.sp1.order.OrderService;
import com.inf.sp1.order.OrderServiceImpl;

//이 클래스는 각 역할에 대한 구현체를 지정해 주는 역할
//1. 저장장치 객체 지정 후 주입
//2. 디스카운트 정책 지정 후 주입

public class AppConfig {

    public MemberService memberService(){
        //사용할 구체적 객체(저장방법)를 생성자에 의해 주입 후 return
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        //사용할 구체적 객체(디스카운트 정책, 저장방법)를 생성자에 의해 주입 후 return
        return new OrderServiceImpl(new RateDiscountPolicy(), new MemoryMemberRepository());
    }
}
