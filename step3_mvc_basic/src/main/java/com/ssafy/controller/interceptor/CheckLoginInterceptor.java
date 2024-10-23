package com.ssafy.controller.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class CheckLoginInterceptor implements HandlerInterceptor {
	
	Logger log = LoggerFactory.getLogger(CheckLoginInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("userName") == null) {
			log.info("CheckLoginInterceptor: login 안된 상태....");
			response.sendRedirect(request.getContextPath() + "/user/loginForm.do");
			return false;
		}
		
		return true;
	}
	
}
