package jpabook.jpashop.service;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void 회원가입() throws Exception {
        Member member = new Member();
        member.setName("memberA");
        member.setAddress(new Address("Seoul", "Bomun", "12345"));

        Long memberId = memberService.join(member);

        assertEquals(member, memberRepository.findOne(memberId));
        assertEquals(memberId, member.getId());
    }

    @Test
    public void 중복회원_예외() throws Exception {
        Member memberA = new Member();
        memberA.setName("lee");
        Member memberB = new Member();
        memberB.setName("lee");

        memberService.join(memberA);
        try {
            memberService.join(memberB);
        } catch (IllegalStateException e) {
            return;
        }

        fail("중복회훤 예외 발생");

    }
}