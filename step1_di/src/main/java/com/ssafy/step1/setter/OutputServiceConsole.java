package com.ssafy.step1.setter;

public class OutputServiceConsole implements OutputService {

	@Override
	public void println(String msg) {
		System.out.println(msg);
	}

}
