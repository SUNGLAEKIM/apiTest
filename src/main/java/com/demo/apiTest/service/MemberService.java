package com.demo.apiTest.service;

import com.demo.apiTest.domain.Member;
import com.demo.apiTest.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public Member save(Member member) {
        memberRepository.save(member);
        return member;
    }

    public Member findById(Long id) {
        return memberRepository.findById(id);
    }

    public Optional<Member> findByName(String name) {
        return memberRepository.findByName(name);
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    /**
     *     Member save(Member member);
     *
     *     Member findById(Long id);
     *
     *     Member findByName(String name);
     *
     *     List<Member> findAll();
     */
}
