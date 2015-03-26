package com.community.ws.QNH.QNHIFServer;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.axiom.om.OMElement;
import org.apache.axis2.context.MessageContext;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.community.app.module.bean.BusinessActivity;
import com.community.app.module.bean.BusinessActivityScope;
import com.community.app.module.bean.ManageEstate;
import com.community.app.module.service.BusinessActivityScopeService;
import com.community.app.module.service.BusinessActivityService;
import com.community.app.module.service.BusinessHelpService;
import com.community.app.module.service.ManageEstateService;
import com.community.app.module.vo.ManageEstateQuery;
import com.community.ws.common.HeaderOMElement;

/**
 * @author Administrator 2.1.4	新增活动
 *
 */
public class QNHActivitySer {
	@Autowired
	BusinessHelpService businessHelpService;
	@Autowired
	private BusinessActivityService businessActivityService;
	@Autowired
	private ManageEstateService manageEstateService;
	@Autowired
	private BusinessActivityScopeService businessActivityScopeService;
	

	/*
	 * fill logic business
	 */
	public String addActivity(String reqStr) {

		System.out.println(reqStr);
		JSONObject json = new JSONObject();
		json.element("errorCode", 200).element("message", "新增活动成功！");
		MessageContext msgContext = MessageContext.getCurrentMessageContext();
		/**暂时解决方案*/
		OMElement el = msgContext.getEnvelope().getBody().getFirstElement().getFirstElement();
		reqStr = el.getText();
		/**校验 qhn WS 用户密码*/
		if(!HeaderOMElement.checkWSUser(msgContext))
		{
			json.clear();
			json.element("errorCode", 400).element("message", "新增活动失败 ， 用户名或密码错误！");
			return json.toString();
		}
		
		
		try {
			JSONObject jsn = JSONObject.fromObject(reqStr);
			/**判断活动是否存在*/
	        if (StringUtils.isNotBlank(jsn.get("QNHActId").toString()))
	        {
	        	Map<String,Object> conMap = new HashMap<String,Object>();
	        	conMap.put("QNHActId", jsn.get("QNHActId").toString());
	        	List<BusinessActivity> qnhActs = businessActivityService.findByMap(conMap);
	        	if (CollectionUtils.isNotEmpty(qnhActs))
	        	{
	        		json.clear();
	        		json.element("errorCode", 400).element("message", "新增活动失败 ，活动已存在，有问题请联系OK家！");
	        		return json.toString();
	        	}
	        }
	                	
			BusinessActivity businessActivity = new BusinessActivity();
			
		 	businessActivity.setTypeId(new Integer(jsn.get("typeId").toString()));
	    	businessActivity.setTypeName("青年汇线下活动");
		    businessActivity.setActName(jsn.get("actName").toString().toString().replaceAll("(\r?\n()+)", "").replace("\"", ""));
		    businessActivity.setActContent(jsn.get("actContent").toString());
		    businessActivity.setBrief(jsn.get("actContent").toString().replaceAll("(\r?\n()+)", "").replace("\"", ""));
		    businessActivity.setActPic(jsn.get("actPic").toString());
		    businessActivity.setActPicNo("");
		    businessActivity.setUserType(0);
		    businessActivity.setPublisherId(0); //发布人ID
		    businessActivity.setState(0);
		    businessActivity.setVisits(0);
		    businessActivity.setComments(0);
		    businessActivity.setSupports(0);
		    businessActivity.setParticpates(0);
		    businessActivity.setIsComment(0);
		    businessActivity.setRecommend(2);
		    businessActivity.setIsPush(0);
			businessActivity.setCreateTime(new Timestamp(System.currentTimeMillis()));
			businessActivity.setEditTime(new Timestamp(System.currentTimeMillis()));
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			if(jsn.get("endTime") != null  && (new Integer(jsn.get("typeId").toString()) == 5)) {
		    	 businessActivity.setStartTime(sdf.format(sdf.parse(jsn.get("startTime").toString())));
				 businessActivity.setEndTime(sdf.format(sdf.parse(jsn.get("endTime").toString())));
				 SimpleDateFormat sfDate = new SimpleDateFormat("yyyy-MM-dd");
				 SimpleDateFormat sfTime = new SimpleDateFormat("HH:mm");
				 Date date = sdf.parse(jsn.get("endTime").toString());
				 Date dt = new Date(date.getTime()-1800000);
				 businessActivity.setPublishDate(sfDate.format(sfDate.parse(jsn.get("endTime").toString())));
				 businessActivity.setPublishTime(sfTime.format(dt));
	        }
			businessActivity.setEditor(jsn.get("QNHName").toString());
	        businessActivity.setIsImportant(0);
	        
	        businessActivity.setIsTimingPush(0);
	        businessActivity.setTimingPushconTent("");
	        businessActivity.setQNHActId(jsn.get("QNHActId").toString());
	        businessActivity.setQNHId(jsn.get("QNHId").toString());
	        businessActivity.setQNHName(jsn.get("QNHName").toString());
	        businessActivity.setIsQNH(1);
	        businessActivity.setTimeslot(sdf.format(sdf.parse(jsn.get("actStartTime").toString()))+"-"+sdf.format(sdf.parse(jsn.get("actEndTime").toString())));
			businessActivityService.save(businessActivity);
			ManageEstateQuery manageEstateQuery = new ManageEstateQuery();
			manageEstateQuery.setEstateLatitude(new Double(jsn.get("latitude").toString()));
			manageEstateQuery.setEstateLongitude(new Double(jsn.get("longitude").toString()));
			List<ManageEstate> list = manageEstateService.findBy3Km(manageEstateQuery);
			String str = "";
			for (ManageEstate manageEstate : list) {
            	BusinessActivityScope scope = new BusinessActivityScope();
            	scope.setActId(businessActivity.getActId());
            	scope.setCreateTime(new Timestamp(System.currentTimeMillis()));
            	scope.setEstateId(manageEstate.getEstateId());
            	scope.setEstateName(manageEstate.getEstateName());
            	str += manageEstate.getEstateName()+',';
            	businessActivityScopeService.save(scope);
			}
			if (list.size()>0) {
				str = str.substring(0, str.length()-1);
				BusinessActivity businessActivity1 = new BusinessActivity();
				businessActivity1.setActId(businessActivity.getActId());
				businessActivity1.setActScope(str);
		        businessActivityService.update(businessActivity1);
			}
//			"content":{
//				code:{
//				uuid: 88023f8d-e710-487c-9c78-38dd90ceda68, 
//				type:4,
//				ID:1
//				}
			
			json.element("content", new JSONObject().element("code",new JSONObject().element("uuid", "88023f8d-e710-487c-9c78-38dd90ceda68")
					.element("type", "4").element("ID", businessActivity.getActId())));
			System.out.println(json.toString());
			System.out.println(jsn.get("actContent"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			json.clear();
			json.element("errorCode", 400).element("message", "新增活动失败 - json解析失败");
			e.printStackTrace();
		}
		
		return json.toString();
	}

	public static void main(String[] args) {
//		JSONObject json = new JSONObject();
//		json.element("errorCode", 200).element("message", "新增活动成功！");
//		json.element("content", new JSONObject().element("code",new JSONObject().element("uuid", "88023f8d-e710-487c-9c78-38dd90ceda68")
//				.element("type", "4").element("ID","1").toString()));
		
		
		JSONObject json = new JSONObject();
		json.element("errorCode", 200).element("message", "新增活动成功！");
		json.clear();
		json.element("errorCodes", 400).element("messages", "新增活动失败 ， 用户名或密码错误！");

		System.out.println(json.toString());
	}

}
