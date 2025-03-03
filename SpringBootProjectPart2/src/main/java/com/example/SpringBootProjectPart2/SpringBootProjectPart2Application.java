package com.example.SpringBootProjectPart2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootProjectPart2Application {


	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootProjectPart2Application.class, args);

		ProductService service = context.getBean(ProductService.class);
		service.getAllProduct().forEach(System.out::println);
	}

}
