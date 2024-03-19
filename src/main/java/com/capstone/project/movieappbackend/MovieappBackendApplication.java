package com.capstone.project.movieappbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.capstone.project.movieappbackend")
public class MovieappBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieappBackendApplication.class, args);
	}

}
