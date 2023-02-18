package com.inf.sp3.beanfind;

import com.inf.sp3.config.AppConfig;
import com.inf.sp3.service.MemberService;
import com.inf.sp3.service.MemberServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new
            AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        MemberService ms = ac.getBean("memberService", MemberService.class);
        assertThat(ms).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("이름없이 타입으로만 조회")
    void findBeanByType() {
        MemberService ms = ac.getBean(MemberService.class);
        assertThat(ms).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2() {
        MemberService ms = ac.getBean("memberService", MemberServiceImpl.class);
        assertThat(ms).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회 실패 테스트")
    void findBeanByNameFail() {
        //MemberService ms = ac.getBean("helloBean", MemberService.class);
        //assertThat(ms).isInstanceOf(MemberServiceImpl.class);
        assertThrows(NoSuchBeanDefinitionException.class, ()->
                ac.getBean("helloBean", MemberService.class));
    }
}