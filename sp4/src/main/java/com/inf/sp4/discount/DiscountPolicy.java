package com.inf.sp4.discount;

import com.inf.sp4.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
