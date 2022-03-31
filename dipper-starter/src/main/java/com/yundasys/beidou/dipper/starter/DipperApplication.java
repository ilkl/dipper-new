package com.yundasys.beidou.dipper.starter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(scanBasePackages = "com.yundasys.beidou.dipper.*")
@MapperScan(basePackages = "com.yundasys.beidou.dipper.mapper")
@EnableWebMvc //解决springboot 2.6 与 knife4j 冲突问题
//@ServletComponentScan(basePackages = "com.yundasys.beidou.dipper.controller")
public class DipperApplication {
	public static void main(String[] args) {
		SpringApplication.run(DipperApplication.class, args);
	}
}
