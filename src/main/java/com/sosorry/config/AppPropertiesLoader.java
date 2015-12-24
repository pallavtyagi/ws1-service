package com.sosorry.config;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class AppPropertiesLoader {
	
	private static final Logger logger = LoggerFactory.getLogger(AppPropertiesLoader.class);
	
	private Properties properties;
	private static AppPropertiesLoader instance=null;

	private AppPropertiesLoader() {}
	
	@Autowired
	@Lazy
	public static AppPropertiesLoader getInstance()
	{
		if(instance==null)
		{
			logger.debug("AppPropertiedLoader Instanciated");
			instance=new AppPropertiesLoader();
		}
		return instance;
	}
	
	// loading the properties from the final file...
	public boolean loadProperties() {
		logger.info("Loading configurations");
		boolean flag = false;
		InputStream fileStream = null;
		properties = new Properties();
		
		//String propFileName = System.getProperty("propValue")+".properties";
		String propFileName="current.properties";
		logger.info( "Property File - "+propFileName+" Loaded!!!");
		try {
			fileStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			if (fileStream != null) {
				logger.debug("Loading properties.."+propFileName);
				properties.load(fileStream);
			} else {
				throw new FileNotFoundException("Property File not found - " + propFileName);
			}

			for (Entry<Object, Object> keySet : properties.entrySet()) {
				//System.out.println(keySet.getKey() + "-->"+ keySet.getValue());
				logger.debug(keySet.getKey() + "-->"+ keySet.getValue());
			}
			flag=true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return flag;

	}
	
	public Map<Object, Object> getConfigs()
	{
		return properties;
		
	}
}
