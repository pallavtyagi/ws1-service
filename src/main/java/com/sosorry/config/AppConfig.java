package com.sosorry.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sosorry.model.Images;
import com.sosorry.mongodao.ImagesDao;
import com.sosorry.mongodao.UserDao;
import com.sosorry.mongodao.VideosDao;

public class AppConfig {

	
	/*
	 * This function will initialize the spring beans
	 */
	
	private static boolean isInit=false;
	private static ApplicationContext ctx;
	private static UserDao userDao;
	private static ImagesDao imageDao;
	private static VideosDao videoDao;
	public static void init() {

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
	public static ApplicationContext getCtx() {
		return ctx;
	}
	private static void setInit(boolean isInit) {
		AppConfig.isInit = isInit;
	}
	public static UserDao getUserDao() {
		return userDao;
	}
	public static ImagesDao getImageDao() {
		return imageDao;
	}
	public static VideosDao getVideoDao() {
		return videoDao;
	}
	

}

