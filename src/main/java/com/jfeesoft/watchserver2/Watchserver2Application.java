package com.jfeesoft.watchserver2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.jfeesoft.watchserver2")
public class Watchserver2Application {

	public static void main(String[] args) {
		SpringApplication.run(Watchserver2Application.class, args);
	}
}
