package com.inf.sp0.discount;

import com.inf.sp0.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
