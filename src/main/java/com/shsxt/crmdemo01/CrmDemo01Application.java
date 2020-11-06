package com.shsxt.crmdemo01;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.shsxt.crmdemo01.dao")
public class CrmDemo01Application {

    public static void main(String[] args) {

        SpringApplication.run(CrmDemo01Application.class, args);
    }


}
