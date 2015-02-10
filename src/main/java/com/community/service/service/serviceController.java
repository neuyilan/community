package com.community.service.service;


/**
 * 服务相关处理接口
 * 包括：
 * @author whh-2_000
 *
 */

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.community.app.module.bean.AppPushLog;
import com.community.app.module.bean.AppUser;
import com.community.app.module.push.AppPushNotificationUtil;
import com.community.app.module.service.AppPushLogService;
import com.community.app.module.service.AppUserService;
import com.community.app.module.service.BusinessAnnoService;
import com.community.app.module.vo.AppUserQuery;
import com.community.framework.utils.DateUtil;
import com.community.framework.utils.JsonUtils;
import com.community.framework.utils.propertiesUtil;


@Controller
@RequestMapping("/service/service")
public class serviceController {
	private static Logger GSLogger = LoggerFactory.getLogger(serviceController.class);
	@Autowired
	private BusinessAnnoService businessAnnoService;
	@Autowired
	private AppUserService appUserService;
	@Autowired
	private AppPushLogService appPushLogService;
	
	/**
	 * 用户查看最新版本号
	 * @param 
	 * @return
	 * json
	 */
	@RequestMapping(value="getVersionNumber")
	public void getVersionNumber(HttpServletRequest request, HttpServletResponse response) {
		Properties p = propertiesUtil.getProperties("appConfig.properties");
		String json = "";
		if ("1".equals(request.getParameter("type"))) {
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"获取成功\",";
			json += "\"content\":{";
			json += "\"versionNumber\":\""+p.getProperty("iosVersionNumber")+"\",";
			json += "\"url\":\""+p.getProperty("iosUrl")+"\",";
			json += "\"content\":\""+p.getProperty("iosContent")+"\",";
			json += "\"type\":\""+p.getProperty("iosType")+"\"";
			json += "}";
			json += "}";
		}else {
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"获取成功\",";
			json += "\"content\":{";
			json += "\"versionNumber\":\""+p.getProperty("androidVersionNumber")+"\",";
			json += "\"url\":\""+p.getProperty("androidUrl")+"\",";
			json += "\"content\":\""+p.getProperty("androidContent")+"\",";
			json += "\"type\":\""+p.getProperty("androidType")+"\"";
			json += "}";
			json += "}";
		}
		
		
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(JsonUtils.stringToJson(json));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 更新用户百度id
	 * 
	 * @param userId,sessionid,baiduId,channelId
	 *    
	 * @return json
	 */
	@RequestMapping(value = "updateBaiduId")
	public void updateBaiduId(HttpServletRequest request,
			HttpServletResponse response,AppUserQuery query) {
		String json = "";
		try{
			if(query.getUserId()!=null){
				AppUser appUser = new AppUser();
				Timestamp  ts=new Timestamp(new Date().getTime());
		        appUser.setEditTime(ts);
		        appUser.setBaiduId(query.getBaiduId());
		        appUser.setChannelId(query.getChannelId());
		        appUser.setDeviceType(query.getDeviceType());
		        appUser.setUserId(query.getUserId());
				AppUser MemberVO = appUserService.findById(query.getUserId());
				appUserService.updateBaiduId(appUser);
				appUserService.update(appUser);
				if (!query.getChannelId().equals(MemberVO.getChannelId()) && !query.getBaiduId().equals(MemberVO.getBaiduId())) {
					if(MemberVO.getBaiduId() != null && !"".equals(MemberVO.getBaiduId()) && MemberVO.getChannelId() != null && !"".equals(MemberVO.getChannelId())) {
		        		if(MemberVO.getDeviceType()==4){
		        			String typeString="";
		        			if (query.getDeviceType()==4) {
		        				typeString="iphone";
							}else{
								typeString="android";
							}
		        			String title = "OK家";
							String description = "您的帐号于"+DateUtil.getInterval(ts)+"在另一台"+typeString+"手机上登录。如果不是您本人操作，则密码可能已泄漏。";
							
							Map paramMap = new HashMap();
							paramMap.put("messageType", 15);
							paramMap.put("ID", MemberVO.getUserId());
							
							Integer success = AppPushNotificationUtil.pushNotification(
									title, 
									description, 
									MemberVO.getDeviceType(),
									Long.valueOf(MemberVO.getChannelId()).longValue(), 
									MemberVO.getBaiduId(),
									paramMap
									);
							//记录推送日志
							AppPushLog appPushLog = new AppPushLog();
							appPushLog.setUserId(MemberVO.getUserId());
						    appPushLog.setUserName(MemberVO.getRealname());
						    appPushLog.setBaiduId(MemberVO.getBaiduId());
						    appPushLog.setChannelId(MemberVO.getChannelId());
						    appPushLog.setTitle(title);
						    appPushLog.setDescription(description);
						    appPushLog.setSendTime(new Timestamp(System.currentTimeMillis()));
						    appPushLog.setSendState(success);
						    appPushLog.setSenderId(MemberVO.getUserId());
						    appPushLog.setSenderName(MemberVO.getNickname());
							appPushLogService.save(appPushLog);
		        		}else {
		        			String typeString="";
		        			if (query.getDeviceType()==4) {
		        				typeString="iphone";
							}else{
								typeString="android";
							}
		        			String title = "OK家";
							String description = "您的帐号于"+DateUtil.getInterval(ts)+"在另一台"+typeString+"手机上登录。如果不是您本人操作，则密码可能已泄漏。";
							
							Map paramMap = new HashMap();
							paramMap.put("messageType", 15);
							paramMap.put("message", description);
							
							Integer success = AppPushNotificationUtil.AndroidPushMessageSample(
									Long.valueOf(MemberVO.getChannelId()).longValue(), 
									MemberVO.getBaiduId(),
									paramMap
									);
							//记录推送日志
							AppPushLog appPushLog = new AppPushLog();
							appPushLog.setUserId(MemberVO.getUserId());
						    appPushLog.setUserName(MemberVO.getRealname());
						    appPushLog.setBaiduId(MemberVO.getBaiduId());
						    appPushLog.setChannelId(MemberVO.getChannelId());
						    appPushLog.setTitle(title);
						    appPushLog.setDescription(description);
						    appPushLog.setSendTime(new Timestamp(System.currentTimeMillis()));
						    appPushLog.setSendState(success);
						    appPushLog.setSenderId(MemberVO.getUserId());
						    appPushLog.setSenderName(MemberVO.getNickname());
							appPushLogService.save(appPushLog);
	        			}
						
						
					}
				}
				json += "{";
				json += "\"errorCode\":\"200\",";
				json += "\"message\":\"获取成功\"";
				json += "}";
			}else {
				json += "{";
				json += "\"errorCode\":\"400\",";
				json += "\"message\":\"用户id为null\"";
				json += "}";
			}
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"获取失败\"";
			json += "}";
			e.printStackTrace();
		}
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(JsonUtils.stringToJson(json));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 判断设备号是否一致
	 * 
	 * @param userId,sessionid,baiduId,channelId
	 *    
	 * @return json
	 */
	@RequestMapping(value = "JudgeBaiduId")
	public void JudgeBaiduId(HttpServletRequest request,
			HttpServletResponse response,AppUserQuery query) {
		String json = "";
		try{
			if(query.getUserId()!=null){
				json += "{";
				json += "\"errorCode\":\"200\",";
				json += "\"message\":\"获取成功\",";
				json += "\"content\":{";
				AppUser appUser = appUserService.findById(query.getUserId());
				if (!query.getChannelId().equals(appUser.getChannelId()) && !query.getBaiduId().equals(appUser.getBaiduId())) {
					String typeString="";
	    			if (appUser.getDeviceType()==4) {
	    				typeString="iphone";
					}else{
						typeString="android";
					}
	    			String title = "OK家";
					String description = "您的帐号于"+DateUtil.getInterval(appUser.getLastLoginTime())+"在另一台"+typeString+"手机上登录。如果不是您本人操作，则密码可能已泄漏。";
					json += "\"state\":\"2\",";
					json += "\"content\":\""+description+"\"";
				}else{
					json += "\"state\":\"1\",";
					json += "\"content\":\"\"";
				}
				json += "}";
				json += "}";
			}else {
				json = "";
				json += "{";
				json += "\"errorCode\":\"400\",";
				json += "\"message\":\"用户id为null\"";
				json += "}";
			}
			
			
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"获取失败\"";
			json += "}";
			e.printStackTrace();
		}
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(JsonUtils.stringToJson(json));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
