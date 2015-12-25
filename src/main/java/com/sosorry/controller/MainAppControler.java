package com.sosorry.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sosorry.config.UriConstants;


@Controller
public class MainAppControler {
	
	@RequestMapping(value = UriConstants.WELCOME,  method = RequestMethod.GET)
	public void getUsersById() {
		
	}
}
