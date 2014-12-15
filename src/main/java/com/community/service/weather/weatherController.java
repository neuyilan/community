package com.community.service.weather;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.community.app.module.bean.AppAutomobileNumber;
import com.community.app.module.bean.AppStatisticsClick;
import com.community.app.module.bean.AppUser;
import com.community.app.module.service.AppAutomobileNumberService;
import com.community.app.module.service.AppPushLogService;
import com.community.app.module.service.AppStatisticsClickService;
import com.community.app.module.service.AppUserConfigService;
import com.community.app.module.vo.AppAutomobileNumberQuery;
import com.community.framework.utils.propertiesUtil;


/**
 * 天气和限行相关处理接口
 * 包括：
 * @author whh-2_000
 *
 */



@Controller
@RequestMapping("/service/weather")
public class weatherController {
	private static Logger GSLogger = LoggerFactory.getLogger(weatherController.class);
	
	@Autowired
	private AppAutomobileNumberService appAutomobileNumberService;
	@Autowired
	private AppStatisticsClickService appStatisticsClickService;
	
	
	
	/**
	 * 用户查看最新天气
	 * @param 
	 * @return
	 * json
	 */
	@RequestMapping(value="getWeather")
	public void getVersionNumber(HttpServletRequest request, HttpServletResponse response,AppAutomobileNumberQuery query) {
		Properties p = propertiesUtil.getProperties("weather.properties");
		String json = "";
		json += "{";
		json += "\"errorCode\":\"200\",";
		json += "\"message\":\"获取成功\",";
		json += "\"content\":{";
		json += "\"data\":\""+p.getProperty("date1")+"\",";
		json += "\"nowTemp\":\""+p.getProperty("nowTemp")+"\",";
		json += "\"weath\":\""+p.getProperty("weath1")+"\",";
		json += "\"temp\":\""+p.getProperty("temp1")+"\",";
		json += "\"wind\":\""+p.getProperty("wind1")+"\",";
		json += "\"pm25\":\""+p.getProperty("pm251")+"\",";
		json += "\"pm25Key\":\""+p.getProperty("pm25")+"\",";
		json += "\"list\":[";
		for (int i = 2; i < 6; i++) {
			json += "{";
			json += "\"day\":\""+p.getProperty("day"+i)+"\",";
			json += "\"weath\":\""+p.getProperty("weath"+i)+"\",";
			json += "\"temp\":\""+p.getProperty("temp"+i)+"\"";
			json += "},";
		}
		json = json.substring(0, json.length()-1);
		json += "]";
		json += "}";
		json += "}";
		
		
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			AppStatisticsClick appStatisticsClick = new AppStatisticsClick();
			appStatisticsClick.setCreateTime(ts);
			appStatisticsClick.setEditTime(ts);
			if(null==query.getUserId()){
				appStatisticsClick.setUserId(0);
			}else{
				appStatisticsClick.setUserId(query.getUserId());
			}
			appStatisticsClick.setType(100);
			appStatisticsClick.setTypeName("天气");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户查看限行接口
	 * @param 
	 * @return
	 * json
	 */
	@RequestMapping(value="getLimit")
	public void getLimit(HttpServletRequest request, HttpServletResponse response,AppAutomobileNumberQuery query) {
		Properties p = propertiesUtil.getProperties("limit.properties");
		Properties p1 = propertiesUtil.getProperties("config.properties");
		String ip = p1.getProperty("imageIp");  

		String json = "";
		String today = p.getProperty("today");
		String tomorrow = p.getProperty("tomorrow");
		
		List<AppAutomobileNumber> list = appAutomobileNumberService.findByExample(query);
		
		json += "{";
		json += "\"errorCode\":\"200\",";
		json += "\"message\":\"获取成功\",";
		json += "\"content\":{";
		if(today.contains("和")){
			String[] arr =today.split("和");
			json += "\"todayState\":\"0\",";
			json += "\"todayArr\":[\""+arr[0]+"\",\""+arr[1].substring(0, 1)+"\"],";
		}else if (today.contains("单号限行") || today.contains("双号限行")) {
			json += "\"todayState\":\"2\",";
			json += "\"todayAlert\":\""+today+"\",";
		}else {
			json += "\"todayState\":\"1\",";
		}
		
		if(tomorrow.contains("和")){
			String[] arr =tomorrow.split("和");
			json += "\"tomorrowState\":\"0\",";
			json += "\"tomorrowArr\":[\""+arr[0]+"\",\""+arr[1].substring(0, 1)+"\"],";
		}else if (tomorrow.contains("单号限行") || tomorrow.contains("双号限行")) {
			json += "\"tomorrowState\":\"2\",";
			json += "\"tomorrowAlert\":\""+tomorrow+"\",";
		}else {
			json += "\"tomorrowState\":\"1\",";
		}
		json += "\"image\":\""+ip+p.getProperty("image")+"\",";
		json += "\"list\":[";
		for (AppAutomobileNumber appAutomobileNumber : list) {
			json += "\""+appAutomobileNumber.getNumberName()+"\",";
		}
		if (list.size()>0) {
			json = json.substring(0, json.length()-1);
		}
		json += "]";
		json += "}";
		json += "}";
		
		
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			AppStatisticsClick appStatisticsClick = new AppStatisticsClick();
			appStatisticsClick.setCreateTime(ts);
			appStatisticsClick.setEditTime(ts);
			if(null==query.getUserId()){
				appStatisticsClick.setUserId(0);
			}else{
				appStatisticsClick.setUserId(query.getUserId());
			}
			appStatisticsClick.setType(101);
			appStatisticsClick.setTypeName("限行");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户添加车辆尾号接口
	 * @param 
	 * @return
	 * json
	 */
	@RequestMapping(value="addNumber")
	public void addNumber(HttpServletRequest request, HttpServletResponse response, AppAutomobileNumberQuery query) {
		AppAutomobileNumber appAutomobileNumber = new AppAutomobileNumber();
		String json = "";
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			appAutomobileNumber.setNumberName(query.getNumberName());
		    appAutomobileNumber.setUserId(query.getUserId());
		    appAutomobileNumber.setCreateTime(ts);
		    appAutomobileNumber.setEditTime(ts);
		    appAutomobileNumber.setEditor("");
			appAutomobileNumberService.save(appAutomobileNumber);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"保存成功\"";
			json += "}";
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"保存失败\"";
			json += "}";
			e.printStackTrace();
		}
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户删除车辆尾号接口
	 * @param 
	 * @return
	 * json
	 */
	@RequestMapping(value="deleteNumber")
	public void deleteNumber(HttpServletRequest request, HttpServletResponse response, AppAutomobileNumberQuery query) {
		AppAutomobileNumber appAutomobileNumber = new AppAutomobileNumber();
		String json = "";
		try{
			appAutomobileNumber.setNumberName(query.getNumberName());
		    appAutomobileNumber.setUserId(query.getUserId());
			appAutomobileNumberService.delete(appAutomobileNumber);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"删除成功\"";
			json += "}";
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"删除失败\"";
			json += "}";
			e.printStackTrace();
		}
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户修改车辆尾号接口
	 * @param 
	 * @return
	 * json
	 */
	@RequestMapping(value="updateNumber")
	public void updateNumber(HttpServletRequest request, HttpServletResponse response, AppAutomobileNumberQuery query) {
		AppAutomobileNumber appAutomobileNumber = new AppAutomobileNumber();
		String json = "";
		try{
			appAutomobileNumber.setNumberName(query.getDeleteNumber());
		    appAutomobileNumber.setUserId(query.getUserId());
			appAutomobileNumberService.delete(appAutomobileNumber);
			Timestamp  ts=new Timestamp(new Date().getTime());
			appAutomobileNumber.setNumberName(query.getAddNumber());
		    appAutomobileNumber.setCreateTime(ts);
		    appAutomobileNumber.setEditTime(ts);
		    appAutomobileNumber.setEditor("");
			appAutomobileNumberService.save(appAutomobileNumber);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"修改成功\"";
			json += "}";
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"修改失败\"";
			json += "}";
			e.printStackTrace();
		}
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
