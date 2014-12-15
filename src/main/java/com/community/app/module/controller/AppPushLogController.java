package com.community.app.module.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.community.app.module.vo.BaseBean;


import com.community.app.module.bean.AppPushLog;
import com.community.app.module.service.AppPushLogService;
import com.community.app.module.vo.AppPushLogQuery;


@Controller
@RequestMapping("/app/appPushLog")
public class AppPushLogController {
	private static Logger GSLogger = LoggerFactory.getLogger(AppPushLogController.class);
	@Autowired
	private AppPushLogService appPushLogService;
	
	private final String LIST_ACTION = "redirect:/app/appPushLog/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入appPushLog管理页时发生错误：/app/appPushLog/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/app/appPushLog/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(AppPushLogQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = appPushLogService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				AppPushLog appPushLog = (AppPushLog) baseBean.getList().get(i);
				result.append("{")
			    .append("\"logId\":\"").append(appPushLog.getLogId()).append("\"").append(",")
			    .append("\"userId\":\"").append(appPushLog.getUserId()).append("\"").append(",")
			    .append("\"userName\":\"").append(appPushLog.getUserName()).append("\"").append(",")
			    .append("\"baiduId\":\"").append(appPushLog.getBaiduId()).append("\"").append(",")
			    .append("\"channelId\":\"").append(appPushLog.getChannelId()).append("\"").append(",")
			    .append("\"title\":\"").append(appPushLog.getTitle()).append("\"").append(",")
			    .append("\"description\":\"").append(appPushLog.getDescription()).append("\"").append(",")
			    .append("\"sendTime\":\"").append(appPushLog.getSendTime()).append("\"").append(",")
			    .append("\"sendState\":\"").append(appPushLog.getSendState()).append("\"").append(",")
			    .append("\"senderId\":\"").append(appPushLog.getSenderId()).append("\"").append(",")
			    .append("\"senderName\":\"").append(appPushLog.getSenderName()).append("\"")
				.append("}").append(",");
			}
			json = result.toString();
			if(baseBean.getList().size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]}";
			
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(Exception e){
			GSLogger.error("显示appPushLog列表时发生错误：/app/appPushLog/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(AppPushLogQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入appPushLog新增页时发生错误：/app/appPushLog/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/app/appPushLog/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param appPushLog
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, AppPushLogQuery query) {
		AppPushLog appPushLog = new AppPushLog();
		String json = "";
		try{
		    appPushLog.setUserId(query.getUserId());
		    appPushLog.setUserName(query.getUserName());
		    appPushLog.setBaiduId(query.getBaiduId());
		    appPushLog.setChannelId(query.getChannelId());
		    appPushLog.setTitle(query.getTitle());
		    appPushLog.setDescription(query.getDescription());
		    appPushLog.setSendTime(query.getSendTime());
		    appPushLog.setSendState(query.getSendState());
		    appPushLog.setSenderId(query.getSenderId());
		    appPushLog.setSenderName(query.getSenderName());
			appPushLogService.save(appPushLog);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存appPushLog信息时发生错误：/app/appPushLog/save", e);
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
	 * 进入修改页
	 * @return
	 */
	@RequestMapping(value="modify")
	public ModelAndView modify(AppPushLogQuery query) {	
		AppPushLog appPushLog=new AppPushLog();
		
		try{
			appPushLog = appPushLogService.findById(query.getLogId());
		}catch(Exception e){
			GSLogger.error("进入appPushLog修改页时发生错误：/app/appPushLog/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/app/appPushLog/modify");
		mav.addObject("appPushLog", appPushLog);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, AppPushLogQuery query) {
		AppPushLog appPushLog = null;
		String json = "";
		try{
		    appPushLog = appPushLogService.findById(query.getLogId());
		    appPushLog.setUserId(query.getUserId());
		    appPushLog.setUserName(query.getUserName());
		    appPushLog.setBaiduId(query.getBaiduId());
		    appPushLog.setChannelId(query.getChannelId());
		    appPushLog.setTitle(query.getTitle());
		    appPushLog.setDescription(query.getDescription());
		    appPushLog.setSendTime(query.getSendTime());
		    appPushLog.setSendState(query.getSendState());
		    appPushLog.setSenderId(query.getSenderId());
		    appPushLog.setSenderName(query.getSenderName());
			appPushLogService.update(appPushLog);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑appPushLog信息时发生错误：/app/appPushLog/update", e);
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
	 * 删除单个或多个对象
	 * @param id
	 * @return
	 */
	@RequestMapping(value="delete")
	public void delete(@RequestParam(value="id") String id, HttpServletResponse response) {
		String json = "";
		try{
			if(id != null) {
				if(id.indexOf(',') > -1) {
					String[] ids = id.split(",");
					for(int i=0;i<ids.length;i++) {
						appPushLogService.delete(new Integer(ids[i]));
					}
				}else{
					appPushLogService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除AppPushLog时发生错误：/app/appPushLog/delete", e);
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
