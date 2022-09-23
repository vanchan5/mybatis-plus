package com.baomidou.mybatisplus.test;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author : cheng
 * @version : V0.1
 * @Description:
 * @since 2020/12/17 22:13
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class} )
@MapperScan("com.baomidou.mybatisplus.test.web.mapper")
@ComponentScan(basePackages = {"com.baomidou.mybatisplus.test.**"})
@Slf4j
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
        log.info("http://localhost:8080/swagger");
    }
}
