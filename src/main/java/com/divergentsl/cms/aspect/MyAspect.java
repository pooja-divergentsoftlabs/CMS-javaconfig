package com.divergentsl.cms.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
	
		private static Logger myLogger = LoggerFactory.getLogger(MyAspect.class);
		
		@Before("execution(* com.divergentsl.cms.dao.*.*(..))")
		public void beforeMethod() {
			myLogger.info("Before called");
		}
		
		@After("execution(* com.divergentsl.cms.dao.*.*(..))")
		public void afterMethod() {
			myLogger.info("After called");
		}
		
		@AfterReturning("execution(* com.divergentsl.cms.dao.*.*(..))")
		public void afterReturningMethod() {
			myLogger.info("after returning called");
		}
}
