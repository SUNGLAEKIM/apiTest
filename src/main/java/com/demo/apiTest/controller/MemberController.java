package com.demo.apiTest.controller;

import com.demo.apiTest.domain.Member;
import com.demo.apiTest.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/member")
public class MemberController {

    @Autowired
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/save")
    public Member save(Member m) {
        return memberService.save(m);
    }

    @GetMapping("find_id")
    public Member findById(@RequestParam("id") Long id) {
        return memberService.findById(id);
    }

    @GetMapping("find_name")
    public Member findByName(@RequestParam("name") String name) {
        return memberService.findByName(name).get();
    }

    @GetMapping("find_all")
    public List<Member> findAll() {
        return memberService.findAll();
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
