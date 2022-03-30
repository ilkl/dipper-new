package com.yundasys.beidou.dipper.starter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.yundasys.beidou.dipper.*")
@MapperScan(basePackages = "com.yundasys.beidou.dipper.mapper")
public class DipperApplication {
	public static void main(String[] args) {
		SpringApplication.run(DipperApplication.class, args);
	}
}
