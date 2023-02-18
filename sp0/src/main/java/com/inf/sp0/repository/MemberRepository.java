package com.inf.sp0.repository;

import com.inf.sp0.member.Member;

public interface MemberRepository {
    void save(Member member);
    Member findById(Long memberId);
}
