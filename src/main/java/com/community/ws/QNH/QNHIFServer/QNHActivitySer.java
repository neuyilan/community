package com.community.ws.QNH.QNHIFServer;


import java.util.Iterator;

import net.sf.json.JSONObject;

import org.apache.axiom.om.OMElement;
import org.apache.axis2.AxisFault;
import org.apache.axis2.context.MessageContext;
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
		
		 MessageContext msgContext = MessageContext.getCurrentMessageContext();  
	        // 获取Head  
	        Iterator list = (Iterator) msgContext.getEnvelope().getHeader()  
	                .getFirstElement().getChildren();  
	        String Username = "";  
	        String Password = "";  
	        while (list.hasNext())  
	        {  
	            OMElement element = (OMElement) list.next();  
	            if (element.getLocalName().equals("Username"))  
	            {  
	                Username = element.getText();  
	            }  
	            if (element.getLocalName().equals("Password"))  
	            {  
	                Password = element.getText();  
	            }  
	        }  
	        if (!Username.equals("toone") || !Password.equals("111111"))  
	        {  
	            try {
					throw new AxisFault(  
					        " Authentication Fail! Check username/password ");
				} catch (AxisFault e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
	        }  
	        
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
