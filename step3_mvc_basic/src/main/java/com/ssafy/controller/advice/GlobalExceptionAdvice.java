package com.ssafy.controller.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionAdvice {
	
	@ExceptionHandler
	private String handleException(Exception e, Model model) {
		e.printStackTrace();
		model.addAttribute("errorMsg", e.getMessage());
		return"global_error";
	}
}
