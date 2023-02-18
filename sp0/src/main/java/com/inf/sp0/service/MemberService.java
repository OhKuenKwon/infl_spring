package com.inf.sp0.service;

import com.inf.sp0.member.Member;

public interface MemberService {
    void join(Member member);
    Member findMember(Long memberId);
}