package com.inf.sp5.autowried;

import com.inf.sp5.AutoAppConfig;
import com.inf.sp5.discount.DiscountPolicy;
import com.inf.sp5.member.Grade;
import com.inf.sp5.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.springframework.stereotype.Component;

public class AllBeanTest {
    @Test
    @DisplayName("빈 테스트")
    void findAllBean() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);
        DiscountService ds = ac.getBean(DiscountService.class);

        Member member = new Member(1L, "userA", Grade.VIP);
        int dcPrice = ds.discount(member, 10000,"fixDiscountPolicy");

        Assertions.assertThat(ds).isInstanceOf(DiscountService.class);
        Assertions.assertThat(dcPrice).isEqualTo(1000);

/*        int dcPrice = ds.discount(member, 10000,"rateDiscountPolicy");
        Assertions.assertThat(ds).isInstanceOf(DiscountService.class);
        Assertions.assertThat(dcPrice).isEqualTo(2000);*/
    }

    @Component
     public static class DiscountService {
        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policies;

        //모든 DiscountPolicy를 다 가져와 생성자에서 Dependency Injection 한다.
        @Autowired
        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
            this.policyMap = policyMap;
            this.policies = policies;
            System.out.println("policyMap = " + policyMap);
            System.out.println("policies = " + policies);
        }

        //할인 정책에 따른 할인
        public int discount(Member member, int price, String discountCode) {

            //멤버와 가격, 디스카운트코드를 가져와서 디스카운트 정책에 따라 디스카운트함
            DiscountPolicy discountPolicy = policyMap.get(discountCode);
            System.out.println("discountCode = " + discountCode);
            System.out.println("discountPolicy = " + discountPolicy);

            //디스카운트정책에 따른 discount 실행 후 return
            return discountPolicy.discount(member, price);
        }
    }
}
/* 아래와 같이 출력됨
policyMap = {fixDiscountPolicy=com.inf.sp5.discount.FixDiscountPolicy@1ad777f, rateDiscountPolicy=com.inf.sp5.discount.RateDiscountPolicy@5bbbdd4b}
policies = [com.inf.sp5.discount.FixDiscountPolicy@1ad777f, com.inf.sp5.discount.RateDiscountPolicy@5bbbdd4b]
*/
