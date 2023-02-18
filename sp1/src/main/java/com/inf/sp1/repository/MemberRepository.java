package com.inf.sp1.repository;

import com.inf.sp1.member.Member;

public interface MemberRepository {
    void save(Member member);
    Member findById(Long memberId);
}
