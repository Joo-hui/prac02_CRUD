package com.sparta.prac02crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Prac02CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(Prac02CrudApplication.class, args);
	}

}
