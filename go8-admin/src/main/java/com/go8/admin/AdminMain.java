package com.go8.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.go8")
@MapperScan({"com.go8.goods.mapper","com.go8.cms.mapper"})
public class AdminMain {
    public static void main(String[] args) {
        SpringApplication.run(AdminMain.class,args);
    }
}
