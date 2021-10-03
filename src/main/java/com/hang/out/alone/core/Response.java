package com.hang.out.alone.core;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response {
    private boolean success;
    private String result;
    private String message;
}
