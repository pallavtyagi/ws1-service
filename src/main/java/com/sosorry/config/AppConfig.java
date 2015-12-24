package com.sosorry.config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.sosorry.controller.LoggingAspect;
import com.sosorry.mongodao.ImagesDao;
import com.sosorry.mongodao.UserDao;
import com.sosorry.mongodao.VideosDao;


@Component
@ComponentScan(value="com.sosorry.config")
public class AppConfig {

	
	/*
	 * This function will initialize the spring beans
	 */
	
	private static final Logger logger = Logger.getLogger(AppConfig.class);
	private static boolean isInit=false;
	private static ApplicationContext ctx;
	private static UserDao userDao;
	private static ImagesDao imageDao;
	private static VideosDao videoDao;
	private static AppConfig appInstance;
	
	private  AppConfig()
	{
		init();
	}
	
	public static AppConfig getInstance()
	{
		if(appInstance== null)
			appInstance= new AppConfig();
		return appInstance;
	}
	
	public static void init() {

		//logger.info("application level configurtion intialize.");
		ctx = new AnnotationConfigApplicationContext(DBConfigurations.class);
		userDao = ctx.getBean(UserDao.class);
		imageDao = ctx.getBean(ImagesDao.class);
		videoDao = ctx.getBean(VideosDao.class);
		if (AppPropertiesLoader.getInstance().getConfigs() == null)
			AppPropertiesLoader.getInstance().loadProperties();
		setInit(true);
	}
	public static boolean isInit() {
		return isInit;
	}
	public  ApplicationContext getCtx() {
		return ctx;
	}
	private static void setInit(boolean isInit) {
		logger.info("Application context intialize");
		AppConfig.isInit = isInit;
	}
	public UserDao getUserDao() {
		return userDao;
	}
	public ImagesDao getImageDao() {
		return imageDao;
	}
	public VideosDao getVideoDao() {
		return videoDao;
	}

	
	@Bean(name="logginAspect")
	@Autowired
	@Required
	public LoggingAspect getLoggingAspect()
	{
		return new LoggingAspect();
	}
}

