package com.mohammad.flightcheckin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.mohammad.flightcheckin.integration.dto")
public class FlightcheckinApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightcheckinApplication.class, args);
	}

}
