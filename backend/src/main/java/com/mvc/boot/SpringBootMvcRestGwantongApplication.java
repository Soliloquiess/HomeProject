package com.mvc.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages= {"com.mvc.boot.dao"})
public class SpringBootMvcRestGwantongApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMvcRestGwantongApplication.class, args);
	}

}
