package com.hang.out.alone.controller;

import com.hang.out.alone.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//Controller, RestController 차이점 확인
@Controller("/member")
public class MemberController {

    //TODO : 회원 가입
    @RequestMapping("/sign-in")
    public void signIn() {

    }
}
