package com.example.FxDeal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.annotation.Validated;

@SpringBootApplication
@Validated
public class FxDealApplication {


	public static void main(String[] args) {
		SpringApplication.run(FxDealApplication.class, args);
	}

}
