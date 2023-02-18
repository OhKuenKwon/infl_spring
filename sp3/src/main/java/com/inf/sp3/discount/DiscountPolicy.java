package com.inf.sp3.discount;

import com.inf.sp3.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
