package com.afaqy.internship.travelapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages  = {"com.murilohenzo"})
public class TravelAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelAppApplication.class, args);
	}

}
