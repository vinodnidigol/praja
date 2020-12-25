package com.project.news.prajathathva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class PrajathathvaApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(PrajathathvaApplication.class, args);
	}

}
