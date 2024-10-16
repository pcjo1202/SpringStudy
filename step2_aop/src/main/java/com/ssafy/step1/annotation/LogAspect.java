package com.ssafy.step1.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Aspect
@Component("logAspect")
public class LogAspect {
	
	//public void jdk.proxy2.$Proxy12.sayHello(java.lang.String)
	@Before("execution(* say*(java.lang.String, ..))")
//	@Before("execution(* sayHello(java.lang.String,*))")
//	@Before("execution(* say*(java.lang.String,*))")
	public void beforeLogging(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		String arg = (String) joinPoint.getArgs()[0];
		if(arg.length() < 2) {
			throw new IllegalArgumentException("매개변수의 문자열의 길이가 잘못되었습니다");
		}
		System.out.println(methodName+ ", 메소드 호출 전... , 매개변수 : " +arg);
	}
}
