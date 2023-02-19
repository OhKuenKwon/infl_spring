package com.inf.sp5.service;

import com.inf.sp5.annotation.MainDiscountPolicy;
import com.inf.sp5.annotation.SubDiscountPolicy;
import com.inf.sp5.discount.DiscountPolicy;
import com.inf.sp5.member.Member;
import com.inf.sp5.order.Order;
import com.inf.sp5.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    //*** discount 정책을 적용하기 위한 [방법 1]
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    //--> 이 코드는 OrderServiceImpl이 추상적인 것(DiscountPolicy)에 의존하여 DIP를 만족하는듯 하지만,
    //OrderServiceImple이 구체적인 것(FixDiscountPolicy, RateDiscountPolicy)에도 의존하여,
    //DIP(의존역전원칙-구체적인것이 추상적인 것에 의존해야함)를 위반하고 있다.


    //*** discount 정책을 적용하기 위한 [방법 2]
    //DIP(의존역전원칙)을 만족하게 하기 위해 OrderServiceImpl이 추상적인 것(DiscountPolicy에만 의존하도록
    //아래와 같이 코드 수정함
    private final DiscountPolicy discountPolicy;

    //--> 그러나 이경우 실행하면 null point exception이 일어남
    //--> 따라서 이 문제를 해결하려면, 누군가 클라이언트인 OderServiceImpl에 DiscountPolicy의 구현객체를
    // 대신 생성하여 주입해 주어야 한다.

    //유사한 방법으로 아래 변수도 DIP 적용
    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;

    //lombok을 사용하는 경우 이 생성자를 자동으로 생성하므로 작성할 필요가 없다.
    //단, private final로 선언된 필드에 대해서만 초기화 시키므로 초기화시킬 필드롤 final로 선언 할것
    //final이 있는 경우와 없는 경우의 생성자를 Ctrl+F12로 확인해 볼 것

    @Autowired
    //public OrderServiceImpl(@Qualifier("mainDCPolicy") DiscountPolicy discountPolicy, MemberRepository memberRepository) {
    public OrderServiceImpl(@MainDiscountPolicy DiscountPolicy discountPolicy, MemberRepository memberRepository) {
        this.discountPolicy = discountPolicy;
        this.memberRepository = memberRepository;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트용 코드
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}