package com.hang.out.alone.service;

import com.hang.out.alone.dto.Member;
import com.hang.out.alone.mapper.MemberMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class MemberService {
    @Autowired
    private MemberMapper mapper;

    public void createMember(Member member) {
        try{
            isValidId(member.getAccount());
            isValidPw(member.getPassword());
            isValidAddress(member.getAddress());
            isValidType(member.getMemberType());
        } catch (Exception e) { //TODO 프로젝트에서 정의한 예외처리로 변경
            System.out.println(e);
        }

        try{
            insertMember(member);
        } catch (Exception e) {
            System.out.println(e);
        }
        log.info("new account created : {}", member.getAccount());
    }

    private boolean isValidId(String account) {
        if(account.length()<5 || account.length()>20) {
            //TODO 예외처리
        }
       return true;
    }

    private boolean isValidPw(String pw) {
        if(pw.length()<5 || pw.length()>20) {
            //TODO 예외처리
        }
        return true;
    }

    private boolean isValidAddress(String add) {
        if(add.length()<5 || add.length()>20) {
            //TODO 예외처리
        }
        return true;
    }

    private boolean isValidType(int t) {
        if(t!=2) {
            //TODO 예외처리
        }
        return true;
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
