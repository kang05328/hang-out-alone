package com.hang.out.alone.mapper;

import com.hang.out.alone.dto.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    Member createAccount(Member member);
    Member getAccount(Member member);
}
