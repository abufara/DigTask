package com.abufara.digtask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.abufara"})
public class DigTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigTaskApplication.class, args);
	}

}
