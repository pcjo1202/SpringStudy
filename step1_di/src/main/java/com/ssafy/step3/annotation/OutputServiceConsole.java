package com.ssafy.step3.annotation;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service("outputter")
public class OutputServiceConsole implements OutputService {

	@Override
	public void println(String msg) {
		System.out.println(msg);
	}

}
