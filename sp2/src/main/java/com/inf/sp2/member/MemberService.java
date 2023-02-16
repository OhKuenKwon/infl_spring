package com.inf.sp2.member;

public interface MemberService {
    //등록 및 찾기 Action
    void join(Member member);
    Member findMember(Long memberId);
}
