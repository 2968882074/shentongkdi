package com.yidu.shentongkdi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.yidu.shentongkdi.dao")
@SpringBootApplication
public class ShentongkdiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShentongkdiApplication.class, args);
    }

}
