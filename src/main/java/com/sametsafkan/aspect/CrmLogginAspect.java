package com.sametsafkan.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class CrmLogginAspect {

	@Pointcut("execution(* com.sametsafkan.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.sametsafkan.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.sametsafkan.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	public void forAppFlow() {}
	
	@Before("forAppFlow()")
	public void before(JoinPoint joinpoint) {
		log.info("========>>> Before Method : " + joinpoint.getSignature().toShortString());
		Object[] args = joinpoint.getArgs();
		for(Object o : args)
			log.info(o.toString());
	}
	
	@AfterReturning(pointcut = "forAppFlow()",
			returning = "result")
	public void afterReturnin(JoinPoint joinpoint, Object result) {
		log.info("========>>> After Returning Method : " + joinpoint.getSignature().toShortString());
		log.info("========>>> After Returning Result : " + result);
	}
}
