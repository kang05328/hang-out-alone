package com.hang.out.alone.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
    private String account;
    private String password;
    private String address;
    private int memberType;
}
