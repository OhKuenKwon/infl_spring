package com.inf.sp3.beanfind;

import com.inf.sp3.discount.DiscountPolicy;
import com.inf.sp3.discount.FixDiscountPolicy;
import com.inf.sp3.discount.RateDiscountPolicy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextExtendsFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    @DisplayName("부모 타입으로 조회시 자식이 둘 이상 있으면, 중복오류 발생")
    void findBeanByParentTypeDuplicate() {
        //DiscountPolicy bean = ac.getBean(DiscountPolicy.class);
        assertThrows(NoUniqueBeanDefinitionException.class, () -> ac.getBean(DiscountPolicy.class));
    }

    @Test
    @DisplayName("부모 타입으로 조회시 자식이 둘 이상 있으면, 빈 이름을 지정하면 된다.")
    void findBeanByParentTypeBeanName() {
        DiscountPolicy rd = ac.getBean("reateDicountPolicy", RateDiscountPolicy.class);
        assertThat(rd).isInstanceOf(RateDiscountPolicy.class);
    }

    @Test
    @DisplayName("특정 하위 타입으로 조회")
    void findBeanBySubType() {
        RateDiscountPolicy bean = ac.getBean(RateDiscountPolicy.class);
        assertThat(bean).isInstanceOf(RateDiscountPolicy.class);
        System.out.println("bean = " + bean);
    }

    @Test
    @DisplayName("부모타입으로 모두 조회하기")
    void findAllBeanByParentType() {
       Map<String, DiscountPolicy> bot = ac.getBeansOfType(DiscountPolicy.class);
       assertThat(bot.size()).isEqualTo(2);
       for(String key: bot.keySet()){
           System.out.println("key = " + key + " value = " + bot.get(key));
       }
    }

    @Test
    @DisplayName("부모타입으로 모두 조회하기")
    void findAllBeanByObjectType() {
        Map<String, Object> bot = ac.getBeansOfType(Object.class);
        for(String key: bot.keySet()){
            System.out.println("key = " + key + " value = " + bot.get(key));
        }
    }

    @Configuration
    static class TestConfig {
        @Bean
        public DiscountPolicy reateDicountPolicy() {
            return new RateDiscountPolicy();
        }

        @Bean
        public DiscountPolicy fixDiscountPolicy() {
            return new FixDiscountPolicy();
        }
    }
}
