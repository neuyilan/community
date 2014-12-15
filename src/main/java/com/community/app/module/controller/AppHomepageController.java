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
import org.springframework.web.servlet.ModelAndView;
import com.community.app.module.vo.BaseBean;

import com.community.app.module.bean.AppHomepage;
import com.community.app.module.service.AppHomepageService;
import com.community.app.module.vo.AppHomepageQuery;

@Controller
@RequestMapping("/app/appHomepage")
public class AppHomepageController {
	private static Logger GSLogger = LoggerFactory.getLogger(AppHomepageController.class);
	@Autowired
	private AppHomepageService appHomepageService;
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入appHomepage管理页时发生错误：/app/appHomepage/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/app/appHomepage/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(AppHomepageQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = appHomepageService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				AppHomepage appHomepage = (AppHomepage) baseBean.getList().get(i);
				result.append("{")
			    .append("\"homePageId\":\"").append(appHomepage.getHomePageId()).append("\"").append(",")
			    .append("\"id\":\"").append(appHomepage.getId()).append("\"").append(",")
			    .append("\"title\":\"").append(appHomepage.getTitle()).append("\"").append(",")
			    .append("\"brief\":\"").append(appHomepage.getBrief()).append("\"").append(",")
			    .append("\"pic\":\"").append(appHomepage.getPic()).append("\"").append(",")
			    .append("\"type\":\"").append(appHomepage.getType()).append("\"").append(",")
			    .append("\"publishTime\":\"").append(appHomepage.getPublishTime()).append("\"")
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
			GSLogger.error("显示appHomepage列表时发生错误：/app/appHomepage/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(AppHomepageQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入appHomepage新增页时发生错误：/app/appHomepage/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/app/appHomepage/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param appHomepage
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, AppHomepageQuery query) {
		AppHomepage appHomepage = new AppHomepage();
		String json = "";
		try{
		    appHomepage.setId(query.getId());
		    appHomepage.setTitle(query.getTitle());
		    appHomepage.setBrief(query.getBrief());
		    appHomepage.setPic(query.getPic());
		    appHomepage.setType(query.getType());
		    appHomepage.setPublishTime(query.getPublishTime());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        //appHomepage.setCreateTime(ts);
	       // appHomepage.setEditTime(ts);
			appHomepageService.save(appHomepage);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存appHomepage信息时发生错误：/app/appHomepage/save", e);
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
	public ModelAndView modify(AppHomepageQuery query) {	
		AppHomepage appHomepage=new AppHomepage();
		
		try{
			appHomepage = appHomepageService.findById(query.getHomePageId());
		}catch(Exception e){
			GSLogger.error("进入appHomepage修改页时发生错误：/app/appHomepage/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/app/appHomepage/modify");
		mav.addObject("appHomepage", appHomepage);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, AppHomepageQuery query) {
		AppHomepage appHomepage = null;
		String json = "";
		try{
		    appHomepage = appHomepageService.findById(query.getHomePageId());
		    appHomepage.setId(query.getId());
		    appHomepage.setTitle(query.getTitle());
		    appHomepage.setBrief(query.getBrief());
		    appHomepage.setPic(query.getPic());
		    appHomepage.setType(query.getType());
		    appHomepage.setPublishTime(query.getPublishTime());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        //appHomepage.setEditTime(ts);
			appHomepageService.update(appHomepage);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑appHomepage信息时发生错误：/app/appHomepage/update", e);
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
	//@RequestMapping(value="delete")
	/*public void delete(@RequestParam(value="id") String id, HttpServletResponse response) {
		String json = "";
		try{
			if(id != null) {
				if(id.indexOf(',') > -1) {
					String[] ids = id.split(",");
					for(int i=0;i<ids.length;i++) {
						appHomepageService.delete(new Integer(ids[i]));
					}
				}else{
					appHomepageService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除AppHomepage时发生错误：/app/appHomepage/delete", e);
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
	}*/
}