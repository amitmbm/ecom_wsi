package com.ami.test;

import java.io.FileInputStream;
import java.util.Properties;

import com.wsi.creational.ILogger;
import com.wsi.creational.LoggerManager;
import com.wsi.enums.LogLevel;

/**
 * 
 * @author Amit Khandelwal
 * 
 * 1. This class is used to read the test-data from the from the JSON file ,
 * And using test-data it will create the various integ and orch Svcs.
 * 
 * 2. it will publish all the integ and orch Svcs , so that svcs can be used 
 * to hit run-time anywhere.
 *
 */
public class TestUtility  {
   
	static final ILogger logger = LoggerManager.getLoggerFactory().getLogger(
			TestUtility.class.getName());
	public static Properties props = null;
	
	static {
		loadProperties();
	}
    
	public static final String manageUrl = props.getProperty("manageUrl");
	public static final String dataUrl = props.getProperty("dataUrl");
	public static final String userUrl = props.getProperty("userUrl");
	
     private static void loadProperties() {
 		if (props != null)
 			return;
 		try {
 			String properties = "src/test/resources/testProperties.properties";
 			props = new Properties();
 			FileInputStream fStream = new FileInputStream(properties);
 			props.load(fStream);
 			fStream.close();
 		} catch (Exception e) {
 			logger.logException(LogLevel.ERROR, "failed to load prop", e);
 		}
 	}
     
}

