package com.sosorry.controller;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sosorry.config.AppConfig;
import com.sosorry.config.UriConstants;
import com.sosorry.model.Images;
import com.sosorry.model.Videos;

@Controller
public class MediaControler {
	

	private static final Logger logger = Logger.getLogger(MediaControler.class);
	
	@RequestMapping(value = UriConstants.GET_IMAGE_BY_ID, method = RequestMethod.GET)
	public @ResponseBody Images getUsersById(@PathVariable String imageid) {
		if(AppConfig.getInstance().getImageDao()==null || AppConfig.getInstance().getImageDao().equals(""))
			logger.debug("ERROR!!!");
		return AppConfig.getInstance().getImageDao().getById(imageid);
	}
	

	@RequestMapping(value=UriConstants.GET_IMAGES, method=RequestMethod.GET)
    public @ResponseBody List<Images> getImages()
    {
		logger.debug("getImages called");
		return AppConfig.getInstance().getImageDao().getImages();
    }
	
	@RequestMapping(value=UriConstants.GET_VIDEOS, method=RequestMethod.GET)
    public @ResponseBody List<Videos> getVideo()
    {
		logger.debug("getVideos called");
		return AppConfig.getInstance().getVideoDao().getVideos();
    }
	
	
	@RequestMapping(value=UriConstants.POST_CREATE_IMAGES, method=RequestMethod.POST)
	public @ResponseBody String createImages(@RequestBody List<Images> images)
	{
		logger.debug("createImages called");
		for (Images image : images) {
			logger.debug("adding new Image - "+image.toString());
			AppConfig.getInstance().getImageDao().create(image);			
		}
		//AppConfig.getInstance().getImageDao().create(images);
		return "SUCCESS";
	}


}
