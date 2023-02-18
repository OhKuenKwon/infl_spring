package com.inf.sp1.service;

import com.inf.sp1.member.Member;

public interface MemberService {
    void join(Member member);
    Member findMember(Long memberId);
}