package jpabook.jpashop.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Transactional
    @Test
    public void testMember() throws Exception {
        Member member = new Member();
        member.setUsername("memberA");

        Long saveId = memberRepository.save(member);
        Member foundMember = memberRepository.find(saveId);

        System.out.println(foundMember.getUsername() + " == " + member.getUsername());
        Assertions.assertThat(foundMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(foundMember.getUsername()).isEqualTo(member.getUsername());
    }
}