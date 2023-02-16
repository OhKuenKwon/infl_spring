package com.inf.sp1.order;

import com.inf.sp1.discount.DiscountPolicy;
import com.inf.sp1.member.Member;
import com.inf.sp1.member.MemberRepository;
import com.inf.sp1.member.MemoryMemberRepository;

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
    private DiscountPolicy discountPolicy;

    //--> 그러나 이경우 실행하면 null point exception이 일어남
    //--> 따라서 이 문제를 해결하려면, 누군가 클라이언트인 OderServiceImpl에 DiscountPolicy의 구현객체를
    // 대신 생성하여 주입해 주어야 한다.

    //유사한 방법으로 아래 변수도 DIP 적용
    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    private MemberRepository memberRepository;

    public OrderServiceImpl(DiscountPolicy discountPolicy, MemberRepository memberRepository) {
        this.discountPolicy = discountPolicy;
        this.memberRepository = memberRepository;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}