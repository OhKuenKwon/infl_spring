package com.inf.sp1.service;

import com.inf.sp1.member.Member;
import com.inf.sp1.repository.MemberRepository;
import com.inf.sp1.repository.MemoryMemberRepository;

public class MemberServiceImpl implements MemberService {
    //DIP, OCP 원리에 위배되는 코드 --> 생성자 주입 방식으로 수정
    //private final MemberRepository mr = new MemoryMemberRepository();

    //생성자 주입을 위한 코드
    private final MemberRepository mr;

    //MemberServiceImpl 클래스는 Repository객체에 의존하지 않게됨
    //어떤 Repository가 사용될지는 AppConfig에서 결정하여 생성자에 주입됨
    public MemberServiceImpl(MemberRepository mr){
        this.mr = mr;
    }

    public void join(Member member) {
        mr.save(member);
    }

    public Member findMember(Long memberId) {
        return mr.findById(memberId);
    }
}