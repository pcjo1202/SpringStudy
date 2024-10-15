package com.ssafy.step2.constructor;

public class GreetingServiceImpl implements GreetingService {
	private OutputService outputter; // 의존 객체
	
	public GreetingServiceImpl(OutputService outputter) {
		super();
		this.outputter = outputter;
	}
	
	@Override
	public void sayHello(String name) {
		outputter.println("Hello!" + name);
	}

}
