package com.inf.sp2.config;

import com.inf.sp2.discount.DiscountPolicy;
import com.inf.sp2.discount.FixDiscountPolicy;
import com.inf.sp2.repository.MemberRepository;
import com.inf.sp2.repository.MemoryMemberRepository;
import com.inf.sp2.service.MemberService;
import com.inf.sp2.service.MemberServiceImpl;
import com.inf.sp2.service.OrderService;
import com.inf.sp2.service.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    //중복 제거를 위한 AppConfig Refactoring
/*    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }*/

    //제어의 역전(Inversion of Control) 및 관심사 분리
    //구현 객체는 자신의 로직을 실행하는 역할만 담당하고, 프로그램의 제어 흐름은
    //이제 AppConfig가 수행

    //생성자주입
    //AppConfig 클래스는 Repository와 DiscountPolicy를 결정하여 구현할 객체를 생성하고,
    //생성자에 주입하여 이를 사용하는 클래스인 MemberServiceImpl, OrderServiceImpl에 전달함

    //Dependency Injection
    //실행 시점(런타임)에 외부에서 실제 구현 객체를 생성하고 클라이언트에 전달해서
    //클라이언트와 서버의 실제 의존관계가 연결 되는 것을 의존관계 주입이라 함

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    //구체적인 Repository 지정
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    //구체적인 Discount 정책 지정
    @Bean
    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }
}
