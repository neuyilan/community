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

import com.community.app.module.bean.AppStatisticsClick;
import com.community.app.module.service.AppStatisticsClickService;
import com.community.app.module.vo.AppStatisticsClickQuery;
import com.community.app.module.vo.BaseBean;



@Controller
@RequestMapping("/app/appStatisticsClick")
public class AppStatisticsClickController {
	private static Logger GSLogger = LoggerFactory.getLogger(AppStatisticsClickController.class);
	@Autowired
	private AppStatisticsClickService appStatisticsClickService;
	
	private final String LIST_ACTION = "redirect:/app/appStatisticsClick/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入appStatisticsClick管理页时发生错误：/app/appStatisticsClick/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/app/appStatisticsClick/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(AppStatisticsClickQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = appStatisticsClickService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				AppStatisticsClick appStatisticsClick = (AppStatisticsClick) baseBean.getList().get(i);
				result.append("{")
			    .append("\"statiId\":\"").append(appStatisticsClick.getStatiId()).append("\"").append(",")
			    .append("\"userId\":\"").append(appStatisticsClick.getUserId()).append("\"").append(",")
			    .append("\"type\":\"").append(appStatisticsClick.getType()).append("\"").append(",")
			    .append("\"typeName\":\"").append(appStatisticsClick.getTypeName()).append("\"").append(",")
			    .append("\"createTime\":\"").append(appStatisticsClick.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(appStatisticsClick.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(appStatisticsClick.getEditor()).append("\"")
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
			GSLogger.error("显示appStatisticsClick列表时发生错误：/app/appStatisticsClick/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(AppStatisticsClickQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入appStatisticsClick新增页时发生错误：/app/appStatisticsClick/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/app/appStatisticsClick/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param appStatisticsClick
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, AppStatisticsClickQuery query) {
		AppStatisticsClick appStatisticsClick = new AppStatisticsClick();
		String json = "";
		try{
		    appStatisticsClick.setUserId(query.getUserId());
		    appStatisticsClick.setType(query.getType());
		    appStatisticsClick.setTypeName(query.getTypeName());
		    appStatisticsClick.setCreateTime(query.getCreateTime());
		    appStatisticsClick.setEditTime(query.getEditTime());
		    appStatisticsClick.setEditor(query.getEditor());
			appStatisticsClickService.save(appStatisticsClick);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存appStatisticsClick信息时发生错误：/app/appStatisticsClick/save", e);
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
	public ModelAndView modify(AppStatisticsClickQuery query) {	
		AppStatisticsClick appStatisticsClick=new AppStatisticsClick();
		
		try{
			appStatisticsClick = appStatisticsClickService.findById(query.getStatiId());
		}catch(Exception e){
			GSLogger.error("进入appStatisticsClick修改页时发生错误：/app/appStatisticsClick/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/app/appStatisticsClick/modify");
		mav.addObject("appStatisticsClick", appStatisticsClick);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, AppStatisticsClickQuery query) {
		AppStatisticsClick appStatisticsClick = null;
		String json = "";
		try{
		    appStatisticsClick = appStatisticsClickService.findById(query.getStatiId());
		    appStatisticsClick.setUserId(query.getUserId());
		    appStatisticsClick.setType(query.getType());
		    appStatisticsClick.setTypeName(query.getTypeName());
		    appStatisticsClick.setCreateTime(query.getCreateTime());
		    appStatisticsClick.setEditTime(query.getEditTime());
		    appStatisticsClick.setEditor(query.getEditor());
			appStatisticsClickService.update(appStatisticsClick);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑appStatisticsClick信息时发生错误：/app/appStatisticsClick/update", e);
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
						appStatisticsClickService.delete(new Integer(ids[i]));
					}
				}else{
					appStatisticsClickService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除AppStatisticsClick时发生错误：/app/appStatisticsClick/delete", e);
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
