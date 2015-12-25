package com.sosorry.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.sosorry.config.aop.logger.LoggingAspect;



@Configuration
@ComponentScan(value = { "com.sosorry.config" })
@EnableWebMvc
public class AopConfig {
	
	@Bean
	@Autowired
	public LoggingAspect getLoggingAspect()
	{
		return new LoggingAspect();
	}

}
