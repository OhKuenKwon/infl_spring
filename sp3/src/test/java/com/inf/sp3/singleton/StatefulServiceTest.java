package com.inf.sp3.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import static org.assertj.core.api.Assertions.assertThat;

class StatefulServiceTest {
    @Test
    @DisplayName("싱글톤 패턴의 문제점")
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService sv1 = ac.getBean(StatefulService.class);
        StatefulService sv2 = ac.getBean(StatefulService.class);

        sv1.order("userA", 10000);
        sv2.order("userB", 20000);

        int price1 = sv1.getPrice();
        int price2 = sv2.getPrice();

        System.out.println("sv1의 price = " + price1);
        System.out.println("sv2의 price = " + price2);

        assertThat(sv1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig{
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}