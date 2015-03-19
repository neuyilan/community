package com.community.ws.QNH.QNHIFServer;

import net.sf.json.JSONObject;

import org.apache.axiom.om.OMElement;
import org.apache.axis2.context.MessageContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.community.app.module.service.AppUserService;
import com.community.app.module.service.BusinessHelpService;
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

	public String regAct(String reqStr) {
		System.out.println(reqStr);
		JSONObject json = new JSONObject();
		json.element("errorCode", 200).element("message", "报名成功！");
		MessageContext msgContext = MessageContext.getCurrentMessageContext();
		/**暂时解决方案*/
		OMElement el = msgContext.getEnvelope().getBody().getFirstElement().getFirstElement();
		reqStr = el.getText();
		/** 校验 qhn WS 用户密码 */
		if (!HeaderOMElement.checkWSUser(msgContext)) {
			json.element("errorCode", 400).element("message", "报名失败 ， 用户名或密码错误！");
			return json.toString();
		}
		// {"QNHActId":"5","cellphone":"1283333"};
		JSONObject reqJson = JSONObject.fromObject(reqStr);
		reqJson.get("QNHActId");

		if (appUserService.whetherRepeat(String.valueOf(reqJson.get("cellphone")))) {
			json.element("errorCode", 400).element("message", "报名失败/手机号未注册");
		}
		return json.toString();
	}

}
