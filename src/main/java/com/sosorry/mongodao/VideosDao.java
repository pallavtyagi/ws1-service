package com.sosorry.mongodao;

import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.sosorry.model.Images;
import com.sosorry.model.Videos;

public class VideosDao implements GenMongoDao{
	//private static final Logger logger = Logger.getLogger(ImagesDao.class);
	
		private MongoOperations mongoOps;
	    private static final String VIDEO_COLLECTION = "videos";
	    private static final String VIDEO_ID = "id";
	    
	    public VideosDao(MongoOperations mongoOps)
	    {
	    
	    	this.mongoOps=mongoOps;
	    }
		@Override
		public void create(Object obj) {
			
			this.mongoOps.insert(obj);
		}

		@Override
		public Videos getById(String id) {
			
		//	logger.debug("Getting imgage for id - "+id);
			System.out.println("TEST");
			Videos image1 = null;
			
			
			image1=this.mongoOps.findOne(new Query().addCriteria(Criteria.where(VIDEO_ID).is(id)),
					Videos.class, VIDEO_COLLECTION);
			
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
		
		public List<Videos> getVideos()
		{
			//logger.debug("get all images... ");
			return this.mongoOps.findAll(Videos.class);
		}

}
