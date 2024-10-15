package com.ssafy.step2.constructor;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GrettingTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
		
		GreetingService greeting = context.getBean("greeting", GreetingService.class);
		greeting.sayHello("박창조");
	}
}
