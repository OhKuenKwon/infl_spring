package com.inf.sp1.discount;

import com.inf.sp1.member.Grade;
import com.inf.sp1.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RateDiscountPolicyTest {

    RateDiscountPolicy dp = new RateDiscountPolicy();
    @Test
    @DisplayName("VIP는 10% 할인율 적용")
    void rateDiscountPolicyVIP() {
        //given
        Member mb1 = new Member(1L,"memberVIP", Grade.VIP);

        //when
        int discount = dp.discount(mb1, 10000);

        //then
        Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아닌 경우 할인율 적용되지 않음")
    void rateDiscountPolicyNoVIP() {
        //given
        Member mb1 = new Member(1L,"memberVIP", Grade.BASIC);

        //when
        int discount = dp.discount(mb1, 10000);

        //then
        Assertions.assertThat(discount).isEqualTo(0);
    }
}