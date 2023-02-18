package com.inf.sp2.repository;

import com.inf.sp2.member.Member;

public interface MemberRepository {
    void save(Member member);
    Member findById(Long memberId);
}
