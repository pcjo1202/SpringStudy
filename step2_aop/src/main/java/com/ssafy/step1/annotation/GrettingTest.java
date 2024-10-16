package com.ssafy.step1.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GrettingTest {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
//		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext1.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		GreetingService greeting = context.getBean("greeting", GreetingService.class);
		System.out.println(greeting.getClass().getSimpleName());
		greeting.sayHello("박창조");
		greeting.sayGoodBye("박창종");
		
//		System.out.println(greeting.getClass().getDeclaredMethod("sayHello", String.class));
	}
}
