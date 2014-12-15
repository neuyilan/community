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


import com.community.app.module.bean.AppUserNews;
import com.community.app.module.service.AppUserNewsService;
import com.community.app.module.vo.AppUserNewsQuery;


@Controller
@RequestMapping("/app/appUserNews")
public class AppUserNewsController {
	private static Logger GSLogger = LoggerFactory.getLogger(AppUserNewsController.class);
	@Autowired
	private AppUserNewsService appUserNewsService;
	
	private final String LIST_ACTION = "redirect:/app/appUserNews/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入appUserNews管理页时发生错误：/app/appUserNews/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/app/appUserNews/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(AppUserNewsQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = appUserNewsService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				AppUserNews appUserNews = (AppUserNews) baseBean.getList().get(i);
				result.append("{")
			    .append("\"newsId\":\"").append(appUserNews.getNewsId()).append("\"").append(",")
			    .append("\"newTitle\":\"").append(appUserNews.getNewTitle()).append("\"").append(",")
			    .append("\"userId\":\"").append(appUserNews.getUserId()).append("\"").append(",")
			    .append("\"type\":\"").append(appUserNews.getType()).append("\"").append(",")
			    .append("\"content\":\"").append(appUserNews.getContent()).append("\"").append(",")
			    .append("\"id\":\"").append(appUserNews.getId()).append("\"").append(",")
			    .append("\"createTime\":\"").append(appUserNews.getCreateTime()).append("\"").append(",")
			    .append("\"lastMessage\":\"").append(appUserNews.getLastMessage()).append("\"").append(",")
			    .append("\"lastMessageName\":\"").append(appUserNews.getLastMessageName()).append("\"")
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
			GSLogger.error("显示appUserNews列表时发生错误：/app/appUserNews/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(AppUserNewsQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入appUserNews新增页时发生错误：/app/appUserNews/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/app/appUserNews/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param appUserNews
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, AppUserNewsQuery query) {
		AppUserNews appUserNews = new AppUserNews();
		String json = "";
		try{
		    appUserNews.setNewTitle(query.getNewTitle());
		    appUserNews.setUserId(query.getUserId());
		    appUserNews.setType(query.getType());
		    appUserNews.setContent(query.getContent());
		    appUserNews.setId(query.getId());
		    appUserNews.setCreateTime(query.getCreateTime());
		    appUserNews.setLastMessage(query.getLastMessage());
		    appUserNews.setLastMessageName(query.getLastMessageName());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        appUserNews.setCreateTime(ts);
	        //appUserNews.setEditTime(ts);
			appUserNewsService.save(appUserNews);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存appUserNews信息时发生错误：/app/appUserNews/save", e);
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
	public ModelAndView modify(AppUserNewsQuery query) {	
		AppUserNews appUserNews=new AppUserNews();
		
		try{
			appUserNews = appUserNewsService.findById(query.getNewsId());
		}catch(Exception e){
			GSLogger.error("进入appUserNews修改页时发生错误：/app/appUserNews/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/app/appUserNews/modify");
		mav.addObject("appUserNews", appUserNews);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, AppUserNewsQuery query) {
		AppUserNews appUserNews = null;
		String json = "";
		try{
		    appUserNews = appUserNewsService.findById(query.getNewsId());
		    appUserNews.setNewTitle(query.getNewTitle());
		    appUserNews.setUserId(query.getUserId());
		    appUserNews.setType(query.getType());
		    appUserNews.setContent(query.getContent());
		    appUserNews.setId(query.getId());
		    appUserNews.setCreateTime(query.getCreateTime());
		    appUserNews.setLastMessage(query.getLastMessage());
		    appUserNews.setLastMessageName(query.getLastMessageName());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        //appUserNews.setEditTime(ts);
			appUserNewsService.update(appUserNews);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑appUserNews信息时发生错误：/app/appUserNews/update", e);
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
						appUserNewsService.delete(new Integer(ids[i]));
					}
				}else{
					appUserNewsService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除AppUserNews时发生错误：/app/appUserNews/delete", e);
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
