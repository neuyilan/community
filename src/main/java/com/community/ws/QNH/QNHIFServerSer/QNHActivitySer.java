package com.community.ws.QNH.QNHIFServerSer;


import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import com.community.app.module.service.BusinessHelpService;


public class QNHActivitySer {
	@Autowired
	BusinessHelpService businessHelpService ;
	/*
	 * fill logic business
	 */
	public String addActivity(String reqStr)
	{
//		List<BusinessHelp> aa = businessHelpService.findAll();
//		for(BusinessHelp bh : aa)
//			System.out.println(bh.getHelpId());
//		"errorCode":200,
//		"message":"发布成功",
		JSONObject  json = new JSONObject();
		json.element("errorCode", 200);
		json.element("message", "发布成功");
	
		System.out.println(reqStr); 
		JSONObject jsn = JSONObject.fromObject(reqStr);
		System.out.println(jsn.get("actContent"));
//		actContent jsn.
		return json.toString();
	}

	
}
