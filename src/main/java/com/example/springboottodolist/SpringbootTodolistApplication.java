package com.example.springboottodolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.example"})

public class SpringbootTodolistApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootTodolistApplication.class, args);
	}

}
