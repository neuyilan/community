package com.community.framework.utils;

import java.io.File;
import java.io.FileInputStream;
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
	 * 
	 * @return
	 */
	private static String prtPath ="";
	public static Properties getProperties(String name) {
		Properties p = null;
		try {
			if (name.equals("pathConfig"))
				prtPath = getProperties("pathConfig").get("path").toString();
			//prtPath + name
			InputStream inputStream = new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\log4j.properties"));
			// propertiesUtil.class.getClassLoader().getResourceAsStream("C:\\Users\\Administrator\\Desktop\\log4j.properties");
			p = new Properties();

			p.load(inputStream);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return p;
	}

	public static void main(String[] args) {
		System.out.println(propertiesUtil.getProperties("").get(
				"log4j.appender.stdout"));
	}

}
