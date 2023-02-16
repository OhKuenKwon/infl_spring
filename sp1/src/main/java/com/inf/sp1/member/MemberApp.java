package com.inf.sp1.member;

import com.inf.sp1.config.AppConfig;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig ac = new AppConfig();

        MemberService memberService = ac.memberService();

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
