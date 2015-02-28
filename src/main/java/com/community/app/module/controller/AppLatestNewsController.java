package com.community.app.module.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.community.app.module.bean.AppLatestNews;
import com.community.app.module.service.AppLatestNewsService;
import com.community.app.module.vo.AppLatestNewsQuery;
import com.community.app.module.vo.BaseBean;


@Controller
@RequestMapping("/app/appLatestNews")
public class AppLatestNewsController {
	private static Logger GSLogger = LoggerFactory.getLogger(AppLatestNewsController.class);
	@Autowired
	private AppLatestNewsService appLatestNewsService;
	
	private final String LIST_ACTION = "redirect:/app/appLatestNews/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入appLatestNews管理页时发生错误：/app/appLatestNews/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/app/appLatestNews/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(AppLatestNewsQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = appLatestNewsService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				AppLatestNews appLatestNews = (AppLatestNews) baseBean.getList().get(i);
				result.append("{")
			    .append("\"newsId\":\"").append(appLatestNews.getNewsId()).append("\"").append(",")
			    .append("\"typeId\":\"").append(appLatestNews.getTypeId()).append("\"").append(",")
			    .append("\"sourceId\":\"").append(appLatestNews.getSourceId()).append("\"").append(",")
			    .append("\"estateId\":\"").append(appLatestNews.getEstateId()).append("\"").append(",")
			    .append("\"userId\":\"").append(appLatestNews.getUserId()).append("\"").append(",")
			    .append("\"to\":\"").append(appLatestNews.getTo()).append("\"")
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
			GSLogger.error("显示appLatestNews列表时发生错误：/app/appLatestNews/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(AppLatestNewsQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入appLatestNews新增页时发生错误：/app/appLatestNews/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/app/appLatestNews/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param appLatestNews
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, AppLatestNewsQuery query) {
		AppLatestNews appLatestNews = new AppLatestNews();
		String json = "";
		try{
		    appLatestNews.setTypeId(query.getTypeId());
		    appLatestNews.setSourceId(query.getSourceId());
		    appLatestNews.setEstateId(query.getEstateId());
		    appLatestNews.setUserId(query.getUserId());
		    appLatestNews.setTo(query.getTo());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        //appLatestNews.setCreateTime(ts);
	        //appLatestNews.setEditTime(ts);
			appLatestNewsService.save(appLatestNews);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存appLatestNews信息时发生错误：/app/appLatestNews/save", e);
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
	public ModelAndView modify(AppLatestNewsQuery query) {	
		AppLatestNews appLatestNews=new AppLatestNews();
		
		try{
			appLatestNews = appLatestNewsService.findById(query.getNewsId());
		}catch(Exception e){
			GSLogger.error("进入appLatestNews修改页时发生错误：/app/appLatestNews/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/app/appLatestNews/modify");
		mav.addObject("appLatestNews", appLatestNews);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, AppLatestNewsQuery query) {
		AppLatestNews appLatestNews = null;
		String json = "";
		try{
		    appLatestNews = appLatestNewsService.findById(query.getNewsId());
		    appLatestNews.setTypeId(query.getTypeId());
		    appLatestNews.setSourceId(query.getSourceId());
		    appLatestNews.setEstateId(query.getEstateId());
		    appLatestNews.setUserId(query.getUserId());
		    appLatestNews.setTo(query.getTo());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        //appLatestNews.setEditTime(ts);
			appLatestNewsService.update(appLatestNews);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑appLatestNews信息时发生错误：/app/appLatestNews/update", e);
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
						appLatestNewsService.delete(new Integer(ids[i]));
					}
				}else{
					appLatestNewsService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除AppLatestNews时发生错误：/app/appLatestNews/delete", e);
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
