package jpabook.jpashop.service;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class OrderServiceTest {

    @Autowired
    EntityManager em;

    @Test
    public void 상품주문() throws Exception {
        Member member = new Member();
        member.setName("MemberA");
        member.setAddress((new Address("서울", "경기", "123-123")));
        em.persist(member);

        Item book = new Book();
        book.setName("JPA");
        book.setPrice()
                

    }

    @Test
    public void 주문취소() throws Exception {

    }

    @Test
    public void 상품주문_수량초과() throws Exception {

    }
}