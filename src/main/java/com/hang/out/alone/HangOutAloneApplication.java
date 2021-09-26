package com.hang.out.alone;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com/hang/out/alone/mapper")
@SpringBootApplication
public class HangOutAloneApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(HangOutAloneApplication.class, args);
    }
}
