package com.sosorry.config.aop.logger;


import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspect {
	
	Logger logger = Logger.getLogger(getClass());
	
	@Around("execution(get*)")
	public void logArround(JoinPoint joinPoint)
	{
		String methodName = joinPoint.getTarget().getClass().getName()+":"+joinPoint.getSignature().getName();
		logger.info("***************START via Around*********************");
		logger.info(methodName+"called.");
		logger.info(methodName+joinPoint.getTarget().getClass().getName()+":completed");
		logger.info("***************Completed****************************");
		
	}
	

}
