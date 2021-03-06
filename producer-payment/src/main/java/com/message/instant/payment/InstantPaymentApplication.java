package com.message.instant.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class InstantPaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(InstantPaymentApplication.class, args);
	}

}
