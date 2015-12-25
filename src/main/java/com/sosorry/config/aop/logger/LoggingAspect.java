package com.sosorry.config.aop.logger;


import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspect {
	
	//private static final Logger logger = Logger.getLogger("");
	private static Logger logger;
	@Before("execution(* com.sosorry.controller.MediaControler.getImages())")
	public void logArround(JoinPoint joinPoint)
	{
		logger=Logger.getLogger(""+joinPoint.getTarget().getClass().getName()+"."+joinPoint.getSignature().getName());
		///String methodName = joinPoint.getTarget().getClass().getName()+":"+joinPoint.getSignature().getName();
		logger.setLevel(Level.ALL);
		logger.debug("***************START via Around*********************");
		logger.info("called.");
		logger.info("completed");
		logger.info("***************Completed****************************");
		
	}
	

}
