package com.hang.out.alone.service;

import com.hang.out.alone.dto.Member;
import com.hang.out.alone.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    private MemberMapper mapper;

    public void createMember(Member member) {
    }

    //예외처리 메소드들
    private boolean isValidId() {
        return false;
    }

    private boolean isValidPw() {
        return false;
    }

    private boolean isValidAddress() {
        return false;
    }

    private boolean isValidType() {
        return false;
    }

    public Member getMember() {
        return mapper.getAccount();
    }

    public Member insertMember(Member member) {
        return mapper.createAccount(member);
    }

    private void updateMember() {

    }

    private void deleteMember() {

    }

}
