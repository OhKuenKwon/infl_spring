package com.inf.sp0.service;

import com.inf.sp0.discount.DiscountPolicy;
import com.inf.sp0.discount.FixDiscountPolicy;
import com.inf.sp0.member.Member;
import com.inf.sp0.order.Order;
import com.inf.sp0.repository.MemberRepository;
import com.inf.sp0.repository.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    //IOP, OCP 을 위반하는 부분
    private final MemberRepository mr = new MemoryMemberRepository();
    private final DiscountPolicy dp = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = mr.findById(memberId);
        int discountPrice = dp.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}