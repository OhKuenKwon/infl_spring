package com.inf.sp0.member;


import com.inf.sp0.service.MemberService;
import com.inf.sp0.service.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {

        MemberService ms = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);

        ms.join(member);
        Member findMember = ms.findMember(1L);

        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
