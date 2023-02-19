package com.inf.sp4.repository;

import com.inf.sp4.member.Member;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();

    //메모리에 데이터 저장
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    //메모리에 저장된 데이터 검색
    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
