package com.sosorry.mongodao;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import com.sosorry.model.Users;

@Component(value="userDao")
@Scope(value="prototype")
public class UserDao implements GenMongoDao{
	
	
	
	private static final Logger logger = Logger.getLogger(UserDao.class);
	private MongoOperations mongoOps;
    private static final String USER_COLLECION = "users";
    private static final String USER_ID = "id";
    
    @Autowired
	public UserDao(MongoOperations mongoOps)
	{
		this.mongoOps=mongoOps;
	}
	@Override
	public void create(Object obj) {
		logger.debug("Creating new user - "+((Users)obj).toString());
		this.mongoOps.insert((Users)obj, USER_COLLECION);
		
	}

	@Override
	public Users getById(String id) {

		Users user1=null;
		//System.out.println("UserDao - id - "+id);
		logger.info("getting user by id -"+id);
		//System.out.println("mongoOps Object - "+ this.mongoOps.toString());
		try {
		 user1 = this.mongoOps.findOne(
				new Query().addCriteria(Criteria.where(USER_ID).is(id)),
				Users.class, USER_COLLECION);
		//if(user1 != null)
		} catch(Exception e )
		{
			//System.out.println("NULL POINTER EXCEPION");
			//System.out.println("checking is mongo ops is null - "+(mongoOps==null));
			logger.info("Error:mongo operations object was null - "+(mongoOps==null));
		}
		//System.out.println("User returned is - "+user1.getEmail());
		return user1;
	}

	@Override
	public void update(Object data) {
		
		this.mongoOps.save((Users)data, USER_COLLECION);
		
	}

	/*
	 * This function will update the deleted status to Y and 
	 * update the deleted date but will not delete any info 
	 * physically from the DB.
	 * */
	@Override
	public void deleteById(String id) {
		Users user = this.getById(id);
		user.setIsDeleted("Y");
		user.setDeletedDate(new Date().toString());
		user.setLastUpdateDate(new Date().toString());
		
		this.update(user);
		
		
	}
	
	
	
	

}
