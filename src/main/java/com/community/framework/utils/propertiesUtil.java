package com.community.framework.utils;



import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * properties工具类
 * 
 */
public class propertiesUtil {
	/**
	 * 利用java.util.Properties读取属性文件
	 * @return
	 */
	public static Properties  getProperties(String name){
		InputStream inputStream = propertiesUtil.class.getClassLoader().getResourceAsStream(name);   
		  Properties p = new Properties();   
		  try {   
		   p.load(inputStream);   
		  } catch (IOException e1) {   
		   e1.printStackTrace();   
		  }   
		return p;
	}
}
