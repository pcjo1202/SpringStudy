package com.ssafy.step4.javaConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	@Bean
	public GreetingService greeting() { // method 이름으로  Bean 등록
		return new GreetingServiceImpl(outputter());
	}
	
	@Bean
	public OutputService outputter() {
		return new OutputServiceConsole();
	}
}
