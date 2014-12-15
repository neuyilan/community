package com.community.app.module.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.community.app.module.bean.AppFocusScope;
import com.community.app.module.service.AppFocusScopeService;
import com.community.app.module.vo.AppFocusScopeQuery;
import com.community.app.module.vo.BaseBean;

@Controller
@RequestMapping("/app/appFocusScope")
public class AppFocusScopeController {
	private static Logger GSLogger = LoggerFactory.getLogger(AppFocusScopeController.class);
	@Autowired
	private AppFocusScopeService appFocusScopeService;
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入appFocusScope管理页时发生错误：/app/appFocusScope/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/app/appFocusScope/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(AppFocusScopeQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = appFocusScopeService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				AppFocusScope appFocusScope = (AppFocusScope) baseBean.getList().get(i);
				result.append("{")
			    .append("\"scopeId\":\"").append(appFocusScope.getScopeId()).append("\"").append(",")
			    .append("\"focusId\":\"").append(appFocusScope.getFocusId()).append("\"").append(",")
			    .append("\"estateId\":\"").append(appFocusScope.getEstateId()).append("\"").append(",")
			    .append("\"createTime\":\"").append(appFocusScope.getCreateTime()).append("\"")
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
			GSLogger.error("显示appFocusScope列表时发生错误：/app/appFocusScope/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(AppFocusScopeQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入appFocusScope新增页时发生错误：/app/appFocusScope/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/app/appFocusScope/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param appFocusScope
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, AppFocusScopeQuery query) {
		AppFocusScope appFocusScope = new AppFocusScope();
		String json = "";
		try{
		    appFocusScope.setFocusId(query.getFocusId());
		    appFocusScope.setEstateId(query.getEstateId());
		    appFocusScope.setCreateTime(query.getCreateTime());
			appFocusScopeService.save(appFocusScope);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存appFocusScope信息时发生错误：/app/appFocusScope/save", e);
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
	public ModelAndView modify(AppFocusScopeQuery query) {	
		AppFocusScope appFocusScope=new AppFocusScope();
		
		try{
			appFocusScope = appFocusScopeService.findById(query.getScopeId());
		}catch(Exception e){
			GSLogger.error("进入appFocusScope修改页时发生错误：/app/appFocusScope/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/app/appFocusScope/modify");
		mav.addObject("appFocusScope", appFocusScope);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, AppFocusScopeQuery query) {
		AppFocusScope appFocusScope = null;
		String json = "";
		try{
		    appFocusScope = appFocusScopeService.findById(query.getScopeId());
		    appFocusScope.setFocusId(query.getFocusId());
		    appFocusScope.setEstateId(query.getEstateId());
		    appFocusScope.setCreateTime(query.getCreateTime());
			appFocusScopeService.update(appFocusScope);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑appFocusScope信息时发生错误：/app/appFocusScope/update", e);
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
						appFocusScopeService.delete(new Integer(ids[i]));
					}
				}else{
					appFocusScopeService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除AppFocusScope时发生错误：/app/appFocusScope/delete", e);
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
