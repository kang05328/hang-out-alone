package com.hang.out.alone.controller;

import com.hang.out.alone.dto.Member;
import com.hang.out.alone.service.MemberService;
import org.springframework.web.bind.annotation.*;


@RestController
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    //TODO : 회원 가입
    @PostMapping(value = "/account")
    public void signIn(@RequestBody Member member) {
        System.out.println(member.getAccount());
        memberService.createMember(member);
    }

//    @GetMapping("/account")
//    public void logIn() {
//
//    }
//
//    @DeleteMapping("/account")
//    public void delete() {
//
//    }

    //TODO 회원정보 조회
    @GetMapping("/user")
    public Member getMember() {
        return memberService.getMember();
    }

//    @PostMapping
//    public Member updateMember() {
//    }

}
