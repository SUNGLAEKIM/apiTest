package com.demo.apiTest.repository;

import com.demo.apiTest.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository {

    Member save(Member member);

    Member findById(Long id);

    Optional<Member> findByName(String name);

    List<Member> findAll();

}
