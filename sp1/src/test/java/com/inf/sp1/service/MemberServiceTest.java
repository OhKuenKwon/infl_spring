package com.inf.sp1.service;

import com.inf.sp1.config.AppConfig;
import com.inf.sp1.member.Grade;
import com.inf.sp1.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MemberServiceTest {

    MemberService ms;

    @BeforeEach
    public void beforeEach(){
        AppConfig ac = new AppConfig();
        ms = ac.memberService();
    }

    @Test
    @DisplayName("멤버 서비스 테스트")
    void memberServiceTest() {
        //given : mb1은 저장소에 저장하기 위한 Member 객체
        Member mb1 = new Member(1L, "memberA", Grade.VIP);

        //when : mb1을 저장소에 저장-join, 저장된 객체를 조회하여 fMb에 대입-findMember
        ms.join(mb1);
        Member fMb = ms.findMember(1L);

        //then : 저장하기전 데이터와 저장후 데이터 비교
        Assertions.assertThat(mb1).isEqualTo(fMb);

        System.out.println("fMb.getId() = " + fMb.getId());
        System.out.println("fMb.getName() = " + fMb.getName());
        System.out.println("fMb.getGrade() = " + fMb.getGrade());
    }
}