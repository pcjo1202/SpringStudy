package com.ssafy.step4.javaConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


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
