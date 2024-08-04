package com.mwom.moyeora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication

public class MoyeoraBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoyeoraBackApplication.class, args);
	}

}
