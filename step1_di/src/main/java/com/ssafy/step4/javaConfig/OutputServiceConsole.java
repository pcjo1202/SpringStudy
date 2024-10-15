package com.ssafy.step4.javaConfig;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


public class OutputServiceConsole implements OutputService {

	@Override
	public void println(String msg) {
		System.out.println(msg);
	}

}
