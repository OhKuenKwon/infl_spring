package com.inf.sp4.member;

import com.inf.sp4.config.AppConfig;
import com.inf.sp4.service.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig ac = new AppConfig();
//        MemberService memberService = ac.memberService();

        ApplicationContext actx = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = actx.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
