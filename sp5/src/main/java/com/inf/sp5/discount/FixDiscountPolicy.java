package com.inf.sp5.discount;

import com.inf.sp5.annotation.SubDiscountPolicy;
import com.inf.sp5.member.Grade;
import com.inf.sp5.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@Qualifier("subDCPolicy")
@SubDiscountPolicy
public class FixDiscountPolicy implements DiscountPolicy{
    private int discountFixAmount = 1000; //1000원 할인
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
