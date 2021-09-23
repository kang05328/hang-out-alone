package com.hang.out.alone;

import com.hang.out.alone.dto.Member;
import com.hang.out.alone.service.MemberService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@Log4j2
//Mybatis test
public class TestRunner implements ApplicationRunner {
    @Autowired
    MemberService ms;

    public void run(ApplicationArguments args) throws Exception {
        //TEST: MemberService
        Member getMember = ms.getMember();
//        Member signMember = ms.insertMember();

        log.info("getMem Test : {}", getMember.getPassword());
//        log.info("signIn Test : {}", signMember.getAccount());

    }
}
