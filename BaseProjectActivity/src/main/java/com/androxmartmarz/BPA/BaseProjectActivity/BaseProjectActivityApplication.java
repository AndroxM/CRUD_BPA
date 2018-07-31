package com.androxmartmarz.BPA.BaseProjectActivity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BaseProjectActivityApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaseProjectActivityApplication.class, args);
	}
}
