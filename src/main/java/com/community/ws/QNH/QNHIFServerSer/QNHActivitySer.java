package com.community.ws.QNH.QNHIFServerSer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.community.app.module.bean.BusinessHelp;
import com.community.app.module.service.BusinessHelpService;


public class QNHActivitySer {
	@Autowired
	BusinessHelpService businessHelpService ;
	
	public String addActivity(String reqStr)
	{
		List<BusinessHelp> aa = businessHelpService.findAll();
		for(BusinessHelp bh : aa)
			System.out.println(bh.getHelpId());
		System.out.println(reqStr); 
		return "终于成功了";
	}

	
}
