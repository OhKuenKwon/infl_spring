package com.inf.sp2.beanfind;

import com.inf.sp2.config.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//컨테이너에 등록된 모든 빈 조회
public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBeans() {
       String[] beanNames = ac.getBeanDefinitionNames();
       for(String beanName : beanNames){
           Object bean = ac.getBean(beanName);
           System.out.println("name = " + beanName + ", object=" + bean);
       }
    }

    @Test
    @DisplayName("어플리케이션 빈 출력하기")
    void findApplicationBeans() {
        String[] beanDefNames = ac.getBeanDefinitionNames();
        for (String beanDefName : beanDefNames) {
            BeanDefinition bd = ac.getBeanDefinition(beanDefName);

            //Role ROLE_APPLICATION: 직접 등록한 애플리케이션 빈
            //Role ROLE_INFRASTRUCTURE: 스프링이 내부에서 사용하는 빈
            if (bd.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanDefName);
                System.out.println("name=" + beanDefName + " object=" + bean);
            }
        }
    }
}
