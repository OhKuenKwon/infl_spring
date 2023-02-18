package com.inf.sp2.xml;

import com.inf.sp2.service.MemberService;
import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class XmlAppContextTest {
    @Test
    void xmlAppContextTest() {
        ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");

        MemberService ms = ac.getBean("memberService", MemberService.class);
        assertThat(ms).isInstanceOf(MemberService.class);
    }
}
