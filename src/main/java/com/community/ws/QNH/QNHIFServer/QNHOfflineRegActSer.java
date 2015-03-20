package com.community.ws.QNH.QNHIFServer;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.axiom.om.OMElement;
import org.apache.axis2.context.MessageContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.community.app.module.bean.AppUser;
import com.community.app.module.bean.BusinessActivity;
import com.community.app.module.bean.BusinessActivityQnhInformation;
import com.community.app.module.service.AppUserService;
import com.community.app.module.service.BusinessActivityQnhInformationService;
import com.community.app.module.service.BusinessActivityService;
import com.community.app.module.service.BusinessHelpService;
import com.community.app.module.vo.BusinessActivityQnhInformationQuery;
import com.community.app.module.vo.BusinessActivityQuery;
import com.community.ws.common.HeaderOMElement;

/**
 * @author Administrator 2.1.6 线下报名活动
 * 
 */
public class QNHOfflineRegActSer {
	@Autowired
	BusinessHelpService businessHelpService;
	@Autowired
	AppUserService appUserService;
	@Autowired
	private BusinessActivityQnhInformationService businessActivityQnhInformationService;
	@Autowired
	private BusinessActivityService businessActivityService;

	public String regAct(String reqStr) {
		List<BusinessActivityQnhInformation> BusinessActivityQnhInformationList= null;
		System.out.println(reqStr);
		String json = "";
		JSONObject jsonString = new JSONObject();
		jsonString.element("errorCode", 200).element("message", "报名成功！");
		MessageContext msgContext = MessageContext.getCurrentMessageContext();
		/**暂时解决方案*/
		OMElement el = msgContext.getEnvelope().getBody().getFirstElement().getFirstElement();
		reqStr = el.getText();
		/** 校验 qhn WS 用户密码 */
		if (!HeaderOMElement.checkWSUser(msgContext)) {
			jsonString.element("errorCode", 400).element("message", "报名失败 ， 用户名或密码错误！");
			return json.toString();
		}
		// {"QNHActId":"5","cellphone":"1283333"};
		JSONObject reqJson = JSONObject.fromObject(reqStr);
		reqJson.get("QNHActId");
		try{
			if (appUserService.whetherRepeat(String.valueOf(reqJson.get("cellphone")))) {
				jsonString.element("errorCode", 400).element("message", "报名失败/手机号未注册");
			}else {
				BusinessActivityQuery businessActivityQuery = new BusinessActivityQuery();
				businessActivityQuery.setQNHActId(reqJson.get("QNHActId").toString());
				List<BusinessActivity> businessActivityList= businessActivityService.findByExample(businessActivityQuery);
				AppUser appUser = appUserService.getAppUserByTel(reqJson.get("cellphone").toString());
				if (businessActivityList != null && businessActivityList.size()>0) {
					BusinessActivityQnhInformationQuery businessActivityQnhInformationQuery = new BusinessActivityQnhInformationQuery();
					businessActivityQnhInformationQuery.setActId(businessActivityList.get(0).getActId());
					businessActivityQnhInformationQuery.setUserId(appUser.getUserId());
					BusinessActivityQnhInformationList = businessActivityQnhInformationService.findByExample(businessActivityQnhInformationQuery);
					
					if(BusinessActivityQnhInformationList.size()>0) {//已参与活动
						json = "";
						json += "{";
						json += "\"errorCode\":\"400\",";
						json += "\"message\":\"您已经参与活动！不能重复参与！\"";
						json += "}";
					}else {
						Timestamp  ts=new Timestamp(new Date().getTime());
						BusinessActivityQnhInformation businessActivityQnhInformation = new BusinessActivityQnhInformation();
						businessActivityQnhInformation.setActId(businessActivityList.get(0).getActId());
						businessActivityQnhInformation.setUserId(appUser.getUserId());
						businessActivityQnhInformation.setState(0);
						businessActivityQnhInformation.setRealname(reqJson.get("realname").toString());
						businessActivityQnhInformation.setCreateTime(ts);
						businessActivityQnhInformation.setEditTime(ts);
						businessActivityQnhInformation.setEditor("");
						businessActivityQnhInformation.setTel(reqJson.get("cellphone").toString());
						businessActivityQnhInformationService.save(businessActivityQnhInformation);
						json += "{";
						json += "\"errorCode\":\"200\",";
						json += "\"message\":\"参与成功\"";
						json += "}";
					}
				}else {
					json = "";
					json += "{";
					json += "\"errorCode\":\"400\",";
					json += "\"message\":\"活动不存在！\"";
					json += "}";
				}
				
				
			}
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"参与失败\"";
			json += "}";
		}
		return json;
	}

}
