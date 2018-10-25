package com.analog.sd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SdApplication {

	static {
		System.getProperties().put("spring.config.location",
				"classpath:application.yml, file:./src/main/config/sd.yml");
	}

	public static void main(String[] args) {
		SpringApplication.run(SdApplication.class, args);
	}
}
