package com.dk.clothing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class DkClothingApplication {

	public static void main(String[] args) {
		SpringApplication.run(DkClothingApplication.class, args);
	}
}
