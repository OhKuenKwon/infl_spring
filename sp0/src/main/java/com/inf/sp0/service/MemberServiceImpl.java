package com.inf.sp0.service;

import com.inf.sp0.member.Member;
import com.inf.sp0.repository.MemberRepository;
import com.inf.sp0.repository.MemoryMemberRepository;

public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    public void join(Member member) {
        memberRepository.save(member);
    }
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}