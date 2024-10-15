package com.ssafy.step1.setter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class OutputServiceFile implements OutputService {

	@Override
	public void println(String msg) {
		try(PrintWriter out = new PrintWriter(new FileWriter("msg.txt", true))){
			out.println(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
