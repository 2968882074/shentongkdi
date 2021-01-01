package com.yidu.shentongkdi;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Mapper
@SpringBootApplication
public class ShentongkdiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShentongkdiApplication.class, args);
    }
}
