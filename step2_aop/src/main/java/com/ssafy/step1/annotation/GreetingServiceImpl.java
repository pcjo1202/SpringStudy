package com.ssafy.step1.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Service("greeting")
public class GreetingServiceImpl implements GreetingService {

	@Override
	public void sayHello(String name) {
		System.out.println("Hello!" + name);
	}

	@Override
	public void sayGoodBye(String name) {
		System.out.println("Good bye" + name);
		
	}

}
