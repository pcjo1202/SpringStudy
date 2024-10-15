package com.ssafy.step3.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Service("greeting")
public class GreetingServiceImpl implements GreetingService {
	private OutputService outputter; // 의존 객체
	
	@Autowired
	public GreetingServiceImpl(OutputService outputter) {
		super();
		this.outputter = outputter;
	}
	
	@Override
	public void sayHello(String name) {
		outputter.println("Hello!" + name);
	}

}
