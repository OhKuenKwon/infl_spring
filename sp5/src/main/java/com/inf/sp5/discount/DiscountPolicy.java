package com.inf.sp5.discount;

import com.inf.sp5.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
