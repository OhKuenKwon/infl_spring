package com.inf.sp3.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import static org.assertj.core.api.Assertions.assertThat;

class StatelessServiceTest {
    @Test
    @DisplayName("싱글톤 패턴의 문제점")
    void statelessServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatelessService sv1 = ac.getBean(StatelessService.class);
        StatelessService sv2 = ac.getBean(StatelessService.class);

        int u1price = sv1.order("userA", 10000);
        int u2price = sv2.order("userB", 20000);

        //int price = sv1.getPrice();
        System.out.println("sv1의 price = " + u1price);
        System.out.println("sv2의 price = " + u2price);
        //assertThat(sv1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig{
        @Bean
        public StatelessService statelessService() {
            return new StatelessService();
        }
    }
}