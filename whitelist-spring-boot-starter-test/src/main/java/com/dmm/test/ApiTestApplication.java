package com.dmm.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Mean
 * @date 2025/1/11 16:49
 * @description ApiTestApplication
 */
@SpringBootApplication
// @ComponentScan(basePackages = {"com.dmm.middleware.*"})      // 扫描指定包,一种引入切面的方式，感觉这种方式更正确
public class ApiTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiTestApplication.class, args);
	}
}

