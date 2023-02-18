package com.inf.sp3.config;

import com.inf.sp3.discount.DiscountPolicy;
import com.inf.sp3.discount.RateDiscountPolicy;
import com.inf.sp3.repository.MemberRepository;
import com.inf.sp3.service.MemberService;
import com.inf.sp3.service.MemberServiceImpl;
import com.inf.sp3.repository.MemoryMemberRepository;
import com.inf.sp3.service.OrderService;
import com.inf.sp3.service.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//이 클래스는 각 역할에 대한 구현체를 지정해 주는 역할
//1. 저장장치 객체 지정 후 주입
//2. 디스카운트 정책 지정 후 주입

@Configuration
public class AppConfig {

    //스프링 컨테이너에 빈 객체 등록
    @Bean
    public DiscountPolicy discountPolicy(){
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

    @Bean
    public MemberRepository memberRepository(){
        System.out.println("call AppConfig.memberRepository");
        //MemoryMemberRepository 객체 생성후 MemberRepository로 업캐스팅 후 return
        return new MemoryMemberRepository();
    }

    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        //사용할 구체적 객체(저장방법)를 생성자에 의해 주입 후 return
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        //사용할 구체적 객체(디스카운트 정책, 저장방법)를 생성자에 의해 주입 후 return
        return new OrderServiceImpl(discountPolicy(), memberRepository());
    }
}
