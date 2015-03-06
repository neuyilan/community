package com.community.ws.QH.QHIFServer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.community.app.module.bean.BusinessHelp;
import com.community.app.module.service.BusinessHelpService;


public class QHActivitySer {
	@Autowired
	BusinessHelpService businessHelpService ;
	
//	private static ApplicationContext ctx;
//	 MessageContext msgCtx = MessageContext
//	org.apache.axis2.context.MessageContext
	
	public String addActivity(String reqStr)
	{
		List<BusinessHelp> aa = businessHelpService.findAll();
		for(BusinessHelp bh : aa)
			System.out.println(bh.getHelpId());
		System.out.println(reqStr); 
		return "";
	}

	
}
