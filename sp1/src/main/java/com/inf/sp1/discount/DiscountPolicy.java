package com.inf.sp1.discount;

import com.inf.sp1.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
