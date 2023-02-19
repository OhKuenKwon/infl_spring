package com.inf.sp5.repository;

import com.inf.sp5.member.Member;

public interface MemberRepository {
    //DB에 멤버정보 저장, 멤버정보 검색
    void save(Member member);
    Member findById(Long memberId);
}
