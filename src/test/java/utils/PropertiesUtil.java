package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertiesUtil {
	
	Logger logger = Logger.getLogger(PropertiesUtil.class);

	public void readPropertiesFromFile() {
		//System.out.println("Starting to read properties file");
		logger.info("Starting to read properties file");
		Properties props = new Properties();
		try {
			//Load properties from properties file into props object
			props.load(new FileInputStream(new File("src/test/resources/conf/config.properties")));
			// NOw load the props object into System properties
			System.getProperties().putAll(props);
		} catch (FileNotFoundException e) {
			//System.out.println("There is no config.properties file in given location");
			logger.info("There is no config.properties file in given location");

		} catch (IOException e) {
			//System.out.println("Error while reading properties from properties file");
			logger.info("Error while reading properties from properties file");

		}
		//System.out.println("Completed reading properties file and all properties are loaded into System properties succesfully");
		logger.info("Completed reading properties file and all properties are loaded into System properties succesfully");


	}
	
}
