package com.youxiue.shopping.modules;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: xfb
 * @projectName: sharding-test->ShoppingApplication
 * @description: TODO
 * @date: 2020/06/04 14:22
 */
@SpringBootApplication
@MapperScan("com.youxiue.shopping.modules.*.mapper")
public class ShoppingApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShoppingApplication.class, args);
    }
}
