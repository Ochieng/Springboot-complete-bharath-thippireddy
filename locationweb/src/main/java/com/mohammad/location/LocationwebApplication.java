package com.mohammad.location;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages =  "com.mohammad.location.entities")
public class LocationwebApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocationwebApplication.class, args);
	}

}
