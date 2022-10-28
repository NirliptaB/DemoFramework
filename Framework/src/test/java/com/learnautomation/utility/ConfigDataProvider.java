package com.learnautomation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {

	Properties prop;
	
	public ConfigDataProvider()
	{
		
			File src = new File ("./Config/Config.properties");
			try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		}  catch (Exception e) {
			
			System.out.println("Unable to fetch Config file"+e.getMessage());
		}
	}
	
	public String getValueFromConfig(String key)
	{
		return prop.getProperty(key);
	}
}
