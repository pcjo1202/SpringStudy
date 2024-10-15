package com.ssafy.step5.javaConfig2;

import org.springframework.stereotype.Service;

@Service
public class OutputServiceConsole implements OutputService {

	@Override
	public void println(String msg) {
		System.out.println(msg);
	}

}
