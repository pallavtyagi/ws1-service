package com.sosorry.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sosorry.config.AppConfig;
import com.sosorry.config.UriConstants;
import com.sosorry.model.Images;
import com.sosorry.model.Users;
import com.sosorry.model.Videos;
import com.sosorry.mongodao.ImagesDao;
import com.sosorry.mongodao.UserDao;

@Controller
public class MediaControler {
	
	private ImagesDao iDao;
	

	UserDao userDao;
	private boolean isInit = false;

	private ApplicationContext ctx;

	@RequestMapping(value = UriConstants.GET_IMAGE_BY_ID, method = RequestMethod.GET)
	public @ResponseBody Images getUsersById(@PathVariable String imageid) {
		if (!AppConfig.isInit())
			AppConfig.init();
		if(AppConfig.getImageDao()==null || AppConfig.getImageDao().equals(""))
			System.out.println("ERROR!!!!!!");
		return AppConfig.getImageDao().getById(imageid);
	}
	

	@RequestMapping(value=UriConstants.GET_IMAGES, method=RequestMethod.GET)
    public @ResponseBody List<Images> getImages()
    {
		if (!AppConfig.isInit())
			AppConfig.init();
		
    	return AppConfig.getImageDao().getImages();
    }
	
	@RequestMapping(value=UriConstants.GET_VIDEOS, method=RequestMethod.GET)
    public @ResponseBody List<Videos> getVideo()
    {
		if (!AppConfig.isInit())
			AppConfig.init();
		
    	return AppConfig.getVideoDao().getVideos();
    }


}
