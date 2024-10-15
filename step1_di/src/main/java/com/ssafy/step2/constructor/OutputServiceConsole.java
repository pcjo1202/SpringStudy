package com.ssafy.step2.constructor;

public class OutputServiceConsole implements OutputService {

	@Override
	public void println(String msg) {
		System.out.println(msg);
	}

}
