package com.qa.camera.config;

import java.time.LocalTime;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

public class AppConfig {

	@Bean
	@Primary
	public String serverStart() {
		return "Server started" + LocalTime.now();
	}
	
	
	@Bean
	public String check() {
	return "Other Messages, Checks & Verifications can go here....";
	}
	
	@Bean
	public ModelMapper mapToDTO() {
		return new ModelMapper();
	}
	
}
