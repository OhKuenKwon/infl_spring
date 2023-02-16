package com.inf.sp1.discount;

import com.inf.sp1.member.Grade;
import com.inf.sp1.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy dp = new RateDiscountPolicy();
    
        @Test
        @DisplayName("vip는 10% 할인이 적용되어야 한다.")
        void RateDiscountPolicyTest(){
            //given
            Member mb = new Member(1L, "memberVIP", Grade.VIP);
            //when
            int discount = dp.discount(mb, 10000);
            //then
           assertThat(discount).isEqualTo(1000);
        }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
    void vip_x() {
        //given
        Member member = new Member(2L, "memberBASIC", Grade.BASIC);
        //when
        int discount = dp.discount(member, 10000);
        //then
        assertThat(discount).isEqualTo(0);
    }

}