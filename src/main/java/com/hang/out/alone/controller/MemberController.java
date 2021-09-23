package com.hang.out.alone.controller;

import com.hang.out.alone.dto.Member;
import com.hang.out.alone.service.MemberService;
import org.springframework.web.bind.annotation.*;


//@RestController("/account") API 설계 확정후 사용여부 결정
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    //TODO : 회원 가입
    @PostMapping("/account")
    public void signIn(String id, String pw, String address, int memType) {
//        Member member = new Member();
//        member.setAccount(id);
//        member.setPassword(pw);
//        member.setAddress(address);
//        member.setMemberType(memType);
//        memberService.createMember(member);
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
