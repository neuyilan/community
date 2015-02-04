package com.community.framework.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class DefaultConfig {

	static Properties prop=new Properties();
	
	static{
		
	    InputStream is;
	    
		try {
			is = DefaultConfig.class.getClassLoader().getResourceAsStream("config.properties");
			prop.load(is);
			
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public static String getProperty(String key ){
		return prop.getProperty(key);
	}
	
//	public static void main(String[] args) {
//		System.out.println(DefaultConfig.getProperty("phpIp"));
//	}
	
}
