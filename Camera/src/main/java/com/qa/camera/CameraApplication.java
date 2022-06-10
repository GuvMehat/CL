package com.qa.camera;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;


@Component

@SpringBootApplication
public class CameraApplication {

	public static void main(String[] args) {
		SpringApplication.run(CameraApplication.class, args);
	}
	
}
