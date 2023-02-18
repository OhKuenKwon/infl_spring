package com.inf.sp2.service;

import com.inf.sp2.discount.DiscountPolicy;
import com.inf.sp2.member.Member;
import com.inf.sp2.order.Order;
import com.inf.sp2.repository.MemberRepository;

public class OrderServiceImpl implements OrderService {

    //IOP, OCP 을 위반하는 부분
    //private final MemberRepository mr = new MemoryMemberRepository();
    //private final DiscountPolicy dp = new FixDiscountPolicy();

    //생성자 주입을 위한 코드
    private final MemberRepository mr;
    private final DiscountPolicy dp;

    //OrderServiceImpl 클래스는 Repository객체와 DiscountPolicy에 의존하지 않게됨
    //어떤 Repository와 DiscountPolicy가 사용될지는 AppConfig에서 결정하여 생성자에 주입됨
    public OrderServiceImpl(MemberRepository mr, DiscountPolicy dp){
        this.mr = mr;
        this.dp = dp;
    }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = mr.findById(memberId);
        int discountPrice = dp.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}