package com.sosorry.controller;

import java.util.ArrayList;
import java.util.List;

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
	

	@RequestMapping(value = UriConstants.GET_IMAGE_BY_ID, method = RequestMethod.GET)
	public @ResponseBody Images getUsersById(@PathVariable String imageid) {
		if(AppConfig.getInstance().getImageDao()==null || AppConfig.getInstance().getImageDao().equals(""))
			System.out.println("ERROR!!!!!!");
		return AppConfig.getInstance().getImageDao().getById(imageid);
	}
	

	@RequestMapping(value=UriConstants.GET_IMAGES, method=RequestMethod.GET)
    public @ResponseBody List<Images> getImages()
    {
		return AppConfig.getInstance().getImageDao().getImages();
    }
	
	@RequestMapping(value=UriConstants.GET_VIDEOS, method=RequestMethod.GET)
    public @ResponseBody List<Videos> getVideo()
    {
		return AppConfig.getInstance().getVideoDao().getVideos();
    }
	
	
	@RequestMapping(value=UriConstants.POST_CREATE_IMAGES, method=RequestMethod.POST)
	public @ResponseBody String createImages(@RequestBody List<Images> images)
	{
		for (Images image : images) {
			AppConfig.getInstance().getImageDao().create(image);			
		}
		//AppConfig.getInstance().getImageDao().create(images);
		return "SUCCESS";
	}


}
