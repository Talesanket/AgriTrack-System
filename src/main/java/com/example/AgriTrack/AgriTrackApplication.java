package com.example.AgriTrack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
 
@SpringBootApplication
@ComponentScan("com")
@EntityScan("com")
public class AgriTrackApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgriTrackApplication.class, args);
		System.out.println("Hello everone");
	}

}
