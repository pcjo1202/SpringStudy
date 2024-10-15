package com.ssafy.step1.setter;

public class GreetingServiceImpl implements GreetingService {
	private OutputService outputter; // 의존 객체
	
	public void setOutputter(OutputService outputter) { // 짝궁 받기 Setter DI
		this.outputter = outputter;
	}
	
	@Override
	public void sayHello(String name) {
		outputter.println("Hello!" + name);
	}

}
