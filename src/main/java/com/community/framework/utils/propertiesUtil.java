package com.community.framework.utils;



import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang.time.DateUtils;

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
