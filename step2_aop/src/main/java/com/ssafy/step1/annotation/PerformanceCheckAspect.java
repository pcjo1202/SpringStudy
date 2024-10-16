package com.ssafy.step1.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Aspect
@Component
public class PerformanceCheckAspect {
	
	@Pointcut("execution(* com.ssafy.step1..say*(..))")
	public void sayPointcut() {}
	
	// 2개 이상의 join point 를 사용한다면 around 로 !
	
	@Around("sayPointcut()")
	public Object checkTime(ProceedingJoinPoint joinPoint) {
		Signature s = joinPoint.getSignature();
		String methodName = s.getName();
		Object obj = null;
		
		try {
			System.out.println("==============수행시간 체크 시작================");
			long start = System.nanoTime();
			// before
			obj = joinPoint.proceed();
			
			// after returning
			long end = System.nanoTime();
			
			System.out.println(methodName + " 수행시간 : " + (end-start) + "ns");
			System.out.println("==============수행시간 체크 완료================");
		} catch (Throwable e) {
			// after throwing
			e.printStackTrace();
		}finally {
			// after
		}
		
		return obj;
	}
}
