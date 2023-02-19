package com.inf.sp5.member;
import com.inf.sp5.AutoAppConfig;
import com.inf.sp5.service.MemberService;

import lombok.ToString;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@ToString

public class MemberApp {

    //lombok 테스트
    private String tname;
    private int age;

    public static void main(String[] args) {
//        AppConfig ac = new AppConfig();
//        MemberService memberService = ac.memberService();

        ApplicationContext actx = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        MemberService memberService = actx.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());

        //lombok 테스트
        MemberApp ma = new MemberApp();
        ma.setTname("LombokTest");
        System.out.println("ma.getTname() = " + ma.getTname());
        System.out.println("ma.toString() = " + ma.toString());
    }
}
