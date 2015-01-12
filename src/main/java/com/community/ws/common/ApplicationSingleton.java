package com.community.ws.common;

import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
 * 获取 ApplicationContext Singleton
 * 
 */
public class ApplicationSingleton {
	
	private static ClassPathXmlApplicationContext instance = null;

	private static synchronized void syncInit() {
		if (instance == null) {
			instance = new ClassPathXmlApplicationContext("applicationContext.xml");
		}
	}
	
	public static ClassPathXmlApplicationContext getInstance() {
		if (instance == null) {
			syncInit();
		}
		return instance;
	}
	
}
