package com.inf.sp2.member;

public interface MemberRepository {
    //DB에 멤버정보 저장, 멤버정보 검색
    void save(Member member);
    Member findById(Long memberId);
}
