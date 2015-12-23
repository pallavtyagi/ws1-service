package com.sosorry.config;

//import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.sosorry.mongodao.ImagesDao;
import com.sosorry.mongodao.UserDao;
import com.sosorry.mongodao.VideosDao;

@Configuration
@ComponentScan(value = { "com.sosorry.config" })
public class DBConfigurations {
	
	//private static final Logger logger = Logger.getLogger(DBConfigurations.class);

	@Bean
	public MongoDbFactory getMongoDbFactory() throws Exception {
		//return new SimpleMongoDbFactory(new MongoClient("localhost", 9999),	"shoutservice");
		// return new SimpleMongoDbFactory(new MongoClient(new
		// MongoClientURI("mongodb://admin:9EeZrdmzi4EL@<hostname>OPENSHIFT_MONGODB_DB_HOST:OPENSHIFT_MONGODB_DB_PORT")),"ws1");

		 return new SimpleMongoDbFactory(new MongoClient(new MongoClientURI(System.getenv("OPENSHIFT_MONGODB_DB_URL"))),"ws1");
	}

	@Bean
	public MongoTemplate getMongoTemplate() throws Exception {
		return new MongoTemplate(getMongoDbFactory());
	}

	@Bean
	public UserDao getUser() {
		UserDao userDao = null;
		try {
			userDao = new UserDao(getMongoTemplate());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userDao;
	}

	@Bean
	public ImagesDao getImages() {
		ImagesDao imagesDao = null;
		try {
			imagesDao = new ImagesDao(getMongoTemplate());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return imagesDao;
	}

	@Bean
	public VideosDao getVideos() {
		VideosDao videosDao = null;
		try {
			videosDao = new VideosDao(getMongoTemplate());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return videosDao;
	}

}
