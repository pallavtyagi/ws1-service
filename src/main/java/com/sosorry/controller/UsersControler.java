package com.sosorry.controller;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sosorry.annotations.ServiceLogger;
import com.sosorry.config.UriConstants;
import com.sosorry.model.Users;
import com.sosorry.mongodao.UserDao;

@Controller
@ComponentScan(value="com.sosorry")
public class UsersControler {

	private static final Logger logger = Logger.getLogger(UsersControler.class);

	@Autowired
	UserDao userDao;
	
	//private boolean isInit = false;

	//private ApplicationContext ctx;

	@ServiceLogger
	@RequestMapping(value = UriConstants.GET_USER_BY_ID, method = RequestMethod.GET)
	public @ResponseBody Users getUsersById(@PathVariable String userid) {
		return userDao.getById(userid);
	}

	@RequestMapping(value = UriConstants.POST_CREATE_USER, method = RequestMethod.POST)
	public @ResponseBody Users createNewUser(@RequestBody Users user) {
		if (!isRegistered(user)) {
			System.out.println(user.getUserid());
			user.setId(user.getCountryCode() + user.getPhone());
			user.setLastUpdateDate(new Date().toString());
			user.setCreateDate(new Date().toString());
			user.setUserid(user.getId());

			userDao.update(user);
			
			return user;
		}
		return null;
	}

	@RequestMapping(value = UriConstants.POST_UPDATE_USER, method = RequestMethod.POST)
	public @ResponseBody Users updateUser(@RequestBody Users user) {

		Users userDb = getUsersById(user.getId());
		if (userDb == null) {
			return null;
		}
		user.setUserid(userDb.getId());
		user.setLastUpdateDate(new Date().toString());
		if (userDb.getCreateDate() != null)
			user.setCreateDate(userDb.getCreateDate());
		else
			user.setCreateDate(new Date().toString());

		userDao.update(user);
		return user;
	}

	@RequestMapping(value = UriConstants.GET_DELETE_USER, method = RequestMethod.GET)
	public @ResponseBody Users deleteUserById(@PathVariable String userid) {
		Users user = getUsersById(userid);
		if (isRegistered(user) && !isDeleted(user)) {
			userDao.deleteById(userid);
			return getUsersById(userid);
		}
		return null;
	}


	/*
	 * Util functions for checking the basic validations
	 */
	private boolean isDeleted(Users user) {
		Users user1 = getUsersById(user.getUserid());
		if (user1.getIsDeleted().equalsIgnoreCase("Y"))
			return true;
		return false;
	}

	private boolean isRegistered(Users user) {
		Users user1 = getUsersById(user.getUserid());
		if (user1 != null)
			return true;
		return false;
	}

}
