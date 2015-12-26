package com.sosorry.config.aop.logger;


import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspect {
	
	private static Logger logger;
	//@Before("execution(* getImages())")
	@Before("execution(* com.sosorry.controller.MediaControler.*()) || execution(* com.sosorry.controller.UsersControler.*(..))")
	public void logBefore(JoinPoint joinPoint)
	{
		logger=Logger.getLogger(""+joinPoint.getTarget().getClass().getName()+"."+joinPoint.getSignature().getName());
		logger.info("***************************************");
		logger.info("service called");
		logger.info("Arguments - "+getStringForArgs(joinPoint.getArgs()));
	}
	@After("execution(* com.sosorry.controller.MediaControler.*()) || execution(* com.sosorry.controller.UsersControler.*(..))")
	public void logAfter(JoinPoint joinPoint)
	{
		logger=Logger.getLogger(""+joinPoint.getTarget().getClass().getName()+"."+joinPoint.getSignature().getName());
		logger.info("reterived successfully.");
		logger.info("***************************************");
	}
	
	String getStringForArgs(Object[] args)
	{
		String output="";
		for (int i = 0; i < args.length; i++) {
			output+=args[i].toString()+",";
		}
		return output;
	}
}
