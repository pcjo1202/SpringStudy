package com.ssafy.step4.javaConfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GrettingTest {
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		GreetingService greeting = context.getBean("greeting", GreetingService.class);
		greeting.sayHello("박창조");
	}
}
