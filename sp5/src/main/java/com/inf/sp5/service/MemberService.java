package com.inf.sp5.service;

import com.inf.sp5.member.Member;

public interface MemberService {
    //등록 및 찾기 Action
    void join(Member member);
    Member findMember(Long memberId);
}
