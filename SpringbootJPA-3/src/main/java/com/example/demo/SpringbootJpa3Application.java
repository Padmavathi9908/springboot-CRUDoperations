package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
public class SpringbootJpa3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpa3Application.class, args);
	}

}
