package com.inf.sp2.member;


import com.inf.sp2.config.AppConfig;
import com.inf.sp2.service.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {

        //생성자 주입을 이용한 객체 생성
        //AppConfig ac = new AppConfig();
        //MemberService ms = ac.memberService();

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService ms = ac.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);

        ms.join(member);
        Member findMember = ms.findMember(1L);

        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
