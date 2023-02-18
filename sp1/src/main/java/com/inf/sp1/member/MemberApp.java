package com.inf.sp1.member;


import com.inf.sp1.config.AppConfig;
import com.inf.sp1.service.MemberService;
import com.inf.sp1.service.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {

        //생성자 주입을 이용한 객체 생성
        AppConfig ac = new AppConfig();
        MemberService ms = ac.memberService();

        Member member = new Member(1L, "memberA", Grade.VIP);

        ms.join(member);
        Member findMember = ms.findMember(1L);

        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
