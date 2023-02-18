package com.inf.sp2.discount;

import com.inf.sp2.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
