package com.dmm.middleware.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Mean
 * @date 2025/1/11 16:49
 * @description ApiTestApplication
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.dmm.middleware.*"})
public class ApiTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiTestApplication.class, args);
	}

}

