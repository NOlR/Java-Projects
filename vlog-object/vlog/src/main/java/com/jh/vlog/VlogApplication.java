package com.jh.vlog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@MapperScan("com.jh.vlog.mapper")
@SpringBootApplication
        //(exclude = {DataSourceAutoConfiguration.class})
public class VlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(VlogApplication.class, args);
    }

}
