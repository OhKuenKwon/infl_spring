package com.inf.sp2.service;

import com.inf.sp2.member.Member;

public interface MemberService {
    void join(Member member);
    Member findMember(Long memberId);
}