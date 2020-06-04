package com.youxiue.dbsharding.simple;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: xfb
 * @projectName: sharding-test->ShardingJdbcSimpleApplication
 * @description: TODO
 * @date: 2020/05/31 13:54
 */
@SpringBootApplication
@MapperScan("com.youxiue.dbsharding.simple.dao")
public class ShardingJdbcSimpleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingJdbcSimpleApplication.class, args);
    }
}
