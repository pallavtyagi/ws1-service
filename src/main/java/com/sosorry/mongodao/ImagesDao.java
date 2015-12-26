package com.sosorry.mongodao;

import java.util.List;



import org.apache.log4j.Logger;
//import org.apache.log4j.Logger;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.sosorry.model.Images;


public class ImagesDao implements GenMongoDao{

	private static final Logger logger = Logger.getLogger(ImagesDao.class);
	private MongoOperations mongoOps;
    private static final String IMAGE_COLLECION = "images";
    private static final String IMAGE_ID = "id";
    
    public ImagesDao(MongoOperations mongoOps)
    {
    
    	this.mongoOps=mongoOps;
    }
	@Override
	public void create(Object obj) {
		
		this.mongoOps.insert(obj);
	}

	@Override
	public Images getById(String id) {
		
		logger.debug("Getting imgage for id - "+id);
		System.out.println("TEST");
		Images image1 = null;
		
		
		image1=this.mongoOps.findOne(new Query().addCriteria(Criteria.where(IMAGE_ID).is(id)),
				Images.class, IMAGE_COLLECION);
		
		return image1;
	}

	@Override
	public void update(Object data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		
	}
	
	public List<Images> getImages()
	{
		logger.debug("sending all images data. ");
		return this.mongoOps.findAll(Images.class);
	}

}
