package com.community.ws.QNH.QNHIFServerSer;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import com.community.app.module.service.AppUserService;
import com.community.app.module.service.BusinessHelpService;

public class OnlineRegActSer {
	@Autowired
	BusinessHelpService businessHelpService ;
	@Autowired
	AppUserService appUserService;
	
	public String regAct(String reqStr)
	{
//		List<BusinessHelp> aa = businessHelpService.findAll();
//		for(BusinessHelp bh : aa)
//			System.out.println(bh.getHelpId());
		System.out.println(reqStr); 
		
		JSONObject  json = new JSONObject();
		
		//{"QNHActId":"5","cellphone":"23"};
		JSONObject reqJson  = JSONObject.fromObject(reqStr);
		reqJson.get("QNHActId");
		
		if (appUserService.whetherRepeat(String.valueOf(reqJson.get("cellphone"))))
		{
			json.element("errorCode", 400);
			json.element("message", "报名失败/手机号未注册");
		}else
		{
			json.element("errorCode", 200);
			json.element("message", "报名成功");
		}
		return json.toString();
	}

}
