package com.inf.sp3.repository;

import com.inf.sp3.member.Member;

public interface MemberRepository {
    //DB에 멤버정보 저장, 멤버정보 검색
    void save(Member member);
    Member findById(Long memberId);
}
