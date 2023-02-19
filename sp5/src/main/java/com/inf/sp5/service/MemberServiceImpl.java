package com.inf.sp5.service;

import com.inf.sp5.member.Member;
import com.inf.sp5.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    //DB 접근을 위한 객체 생성
    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    //위 코드는 DIP 위반 --> 따라서 아래와 같이 인터페이스를 선언만 해주어 DIP 위반하지 않도록 함

    private final MemberRepository memberRepository;

    //join, findMember 함수 수행을 위한 Repository 객체는 AppConfig에서 구체화 하여
    // 이 클래스의 생성자를 통해 주입해줌. 따라서 이 클래스에서는 join, findMember에만 집중하면됨
    // --> 관심사 분리(이 클래스는 join, findMember만 집중, Repository 객체는 AppConfig 에서 주입)

    //lombok을 사용하는 경우 이 생성자를 자동으로 생성하므로 작성할 필요가 없다.
    //단, private final로 선언된 필드에 대해서만 초기화 시키므로 초기화시킬 필드롤 final로 선언 할것
    //final이 있는 경우와 없는 경우의 생성자를 Ctrl+F12로 확인해 볼 것
    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트용 코드
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
