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

import com.community.app.module.bean.AppUserConfig;
import com.community.app.module.service.AppUserConfigService;
import com.community.app.module.vo.AppUserConfigQuery;
import com.community.app.module.vo.BaseBean;


@Controller
@RequestMapping("/app/appUserConfig")
public class AppUserConfigController {
	private static Logger GSLogger = LoggerFactory.getLogger(AppUserConfigController.class);
	@Autowired
	private AppUserConfigService appUserConfigService;
	
	private final String LIST_ACTION = "redirect:/app/appUserConfig/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入appUserConfig管理页时发生错误：/app/appUserConfig/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/app/appUserConfig/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(AppUserConfigQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = appUserConfigService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				AppUserConfig appUserConfig = (AppUserConfig) baseBean.getList().get(i);
				result.append("{")
			    .append("\"userId\":\"").append(appUserConfig.getUserId()).append("\"").append(",")
			    .append("\"helpSwitch\":\"").append(appUserConfig.getHelpSwitch()).append("\"").append(",")
			    .append("\"marketSwitch\":\"").append(appUserConfig.getMarketSwitch()).append("\"").append(",")
			    .append("\"createTime\":\"").append(appUserConfig.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(appUserConfig.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(appUserConfig.getEditor()).append("\"")
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
			GSLogger.error("显示appUserConfig列表时发生错误：/app/appUserConfig/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(AppUserConfigQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入appUserConfig新增页时发生错误：/app/appUserConfig/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/app/appUserConfig/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param appUserConfig
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, AppUserConfigQuery query) {
		AppUserConfig appUserConfig = new AppUserConfig();
		String json = "";
		try{
		    appUserConfig.setHelpSwitch(query.getHelpSwitch());
		    appUserConfig.setMarketSwitch(query.getMarketSwitch());
		    appUserConfig.setCreateTime(query.getCreateTime());
		    appUserConfig.setEditTime(query.getEditTime());
		    appUserConfig.setEditor(query.getEditor());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        appUserConfig.setCreateTime(ts);
	        appUserConfig.setEditTime(ts);
			appUserConfigService.save(appUserConfig);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存appUserConfig信息时发生错误：/app/appUserConfig/save", e);
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
	public ModelAndView modify(AppUserConfigQuery query) {	
		AppUserConfig appUserConfig=new AppUserConfig();
		
		try{
			appUserConfig = appUserConfigService.findById(query.getUserId());
		}catch(Exception e){
			GSLogger.error("进入appUserConfig修改页时发生错误：/app/appUserConfig/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/app/appUserConfig/modify");
		mav.addObject("appUserConfig", appUserConfig);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, AppUserConfigQuery query) {
		AppUserConfig appUserConfig = null;
		String json = "";
		try{
		    appUserConfig = appUserConfigService.findById(query.getUserId());
		    appUserConfig.setHelpSwitch(query.getHelpSwitch());
		    appUserConfig.setMarketSwitch(query.getMarketSwitch());
		    appUserConfig.setCreateTime(query.getCreateTime());
		    appUserConfig.setEditTime(query.getEditTime());
		    appUserConfig.setEditor(query.getEditor());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        appUserConfig.setEditTime(ts);
			appUserConfigService.update(appUserConfig);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑appUserConfig信息时发生错误：/app/appUserConfig/update", e);
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
						appUserConfigService.delete(new Integer(ids[i]));
					}
				}else{
					appUserConfigService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除AppUserConfig时发生错误：/app/appUserConfig/delete", e);
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
