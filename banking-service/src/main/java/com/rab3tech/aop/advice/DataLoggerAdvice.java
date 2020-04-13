package com.rab3tech.aop.advice;

import java.util.Arrays;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DataLoggerAdvice {
	
private static final Logger logger = LoggerFactory.getLogger(DataLoggerAdvice.class);
	
	//What kind of method calls I would intercept
	//execution(* PACKAGE.*.*(..))
	//Weaving & Weaver
    //.* - all the classes
    //.* = all the method
     //.. method with any parameter
    //* -any access specifier 
	@Before("execution(* com.rab3tech.customer.service.impl.*.*(..))")
	public void before(JoinPoint joinPoint){
		String name=joinPoint.getSignature().getName();
		logger.info(" Method name = "+name+" is called at "+new Date());
		logger.info(" Method inputs are  {}", Arrays.asList(joinPoint.getArgs()));
	}

}
