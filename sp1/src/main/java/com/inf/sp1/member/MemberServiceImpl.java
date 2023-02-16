package com.inf.sp1.member;

public class MemberServiceImpl implements MemberService{

    //DB 접근을 위한 객체 생성
    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    //위 코드는 DIP 위반 --> 따라서 아래와 같이 인터페이스를 선언만 해주어 DIP 위반하지 않도록 함

    private MemberRepository memberRepository;

    //join, findMember 함수 수행을 위한 Repository 객체는 AppConfig에서 구체화 하여
    // 이 클래스의 생성자를 통해 주입해줌. 따라서 이 클래스에서는 join, findMember에만 집중하면됨
    // --> 관심사 분리(이 클래스는 join, findMember만 집중, Repository 객체는 AppConfig에서 주입
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
}
