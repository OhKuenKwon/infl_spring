package com.inf.sp5.scan;

import com.inf.sp5.AutoAppConfig;
import com.inf.sp5.service.MemberService;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.assertj.core.api.Assertions.*;

public class AutoAppConfigTest {
    @Test
    @DisplayName("AutoConfig 테스트")
    void basicScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigReactiveWebApplicationContext(AutoAppConfig.class);
        MemberService ms = ac.getBean(MemberService.class);
        assertThat(ms).isInstanceOf(MemberService.class);
    }
}
