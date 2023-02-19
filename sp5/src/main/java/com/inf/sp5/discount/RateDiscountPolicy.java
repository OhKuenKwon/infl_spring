package com.inf.sp5.discount;

import com.inf.sp5.annotation.MainDiscountPolicy;
import com.inf.sp5.member.Grade;
import com.inf.sp5.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
//@Qualifier("mainDCPolicy")
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy{
    private  int discountPercent = 20;
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
