package com.inf.sp4.service;

import com.inf.sp4.member.Member;

public interface MemberService {
    //등록 및 찾기 Action
    void join(Member member);
    Member findMember(Long memberId);
}
