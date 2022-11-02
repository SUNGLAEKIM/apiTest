package com.demo.apiTest.repository;

import com.demo.apiTest.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class JpaMemberRepository implements MemberRepository{

    @Autowired
    private EntityManager em;

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Member findById(Long id) {
        Member member = em.find(Member.class, id);
        return member;
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select a from Member a where a.name = :name", Member.class).setParameter("name", name).getResultList();
        return result.stream().parallel().findAny();
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select a from Member a", Member.class).getResultList();
    }
}
