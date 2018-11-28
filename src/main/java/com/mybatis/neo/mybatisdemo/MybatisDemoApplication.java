package com.mybatis.neo.mybatisdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 *  采用扫包的形式，不用每一个mapper接口添加   @Mapper注解
 */

@SpringBootApplication
@MapperScan("com.mybatis.neo.mybatisdemo.mapper")
public class MybatisDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisDemoApplication.class, args);
    }
}
