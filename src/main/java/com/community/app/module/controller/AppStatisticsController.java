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


import com.community.app.module.bean.AppStatistics;
import com.community.app.module.service.AppStatisticsService;
import com.community.app.module.vo.AppStatisticsQuery;


@Controller
@RequestMapping("/app/appStatistics")
public class AppStatisticsController {
	private static Logger GSLogger = LoggerFactory.getLogger(AppStatisticsController.class);
	@Autowired
	private AppStatisticsService appStatisticsService;
	
	private final String LIST_ACTION = "redirect:/app/appStatistics/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入appStatistics管理页时发生错误：/app/appStatistics/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/app/appStatistics/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(AppStatisticsQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = appStatisticsService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				AppStatistics appStatistics = (AppStatistics) baseBean.getList().get(i);
				result.append("{")
			    .append("\"statiId\":\"").append(appStatistics.getStatiId()).append("\"").append(",")
			    .append("\"type\":\"").append(appStatistics.getType()).append("\"").append(",")
			    .append("\"typeName\":\"").append(appStatistics.getTypeName()).append("\"").append(",")
			    .append("\"createTime\":\"").append(appStatistics.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(appStatistics.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(appStatistics.getEditor()).append("\"")
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
			GSLogger.error("显示appStatistics列表时发生错误：/app/appStatistics/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(AppStatisticsQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入appStatistics新增页时发生错误：/app/appStatistics/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/app/appStatistics/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param appStatistics
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, AppStatisticsQuery query) {
		AppStatistics appStatistics = new AppStatistics();
		String json = "";
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
		    appStatistics.setType(query.getType());
		    appStatistics.setTypeName(query.getTypeName());
		    appStatistics.setCreateTime(ts);
		    appStatistics.setEditTime(ts);
		    appStatistics.setEditor("");
			appStatisticsService.save(appStatistics);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存appStatistics信息时发生错误：/app/appStatistics/save", e);
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
	public ModelAndView modify(AppStatisticsQuery query) {	
		AppStatistics appStatistics=new AppStatistics();
		
		try{
			appStatistics = appStatisticsService.findById(query.getStatiId());
		}catch(Exception e){
			GSLogger.error("进入appStatistics修改页时发生错误：/app/appStatistics/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/app/appStatistics/modify");
		mav.addObject("appStatistics", appStatistics);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, AppStatisticsQuery query) {
		AppStatistics appStatistics = null;
		String json = "";
		try{
		    appStatistics = appStatisticsService.findById(query.getStatiId());
		    appStatistics.setType(query.getType());
		    appStatistics.setTypeName(query.getTypeName());
		    appStatistics.setCreateTime(query.getCreateTime());
		    appStatistics.setEditTime(query.getEditTime());
		    appStatistics.setEditor(query.getEditor());
			appStatisticsService.update(appStatistics);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑appStatistics信息时发生错误：/app/appStatistics/update", e);
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
						appStatisticsService.delete(new Integer(ids[i]));
					}
				}else{
					appStatisticsService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除AppStatistics时发生错误：/app/appStatistics/delete", e);
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
