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


import com.community.app.module.bean.ManageFunction;
import com.community.app.module.service.ManageFunctionService;
import com.community.app.module.vo.ManageFunctionQuery;


@Controller
@RequestMapping("/manage/manageFunction")
public class ManageFunctionController {
	private static Logger GSLogger = LoggerFactory.getLogger(ManageFunctionController.class);
	@Autowired
	private ManageFunctionService manageFunctionService;
	
	private final String LIST_ACTION = "redirect:/manage/manageFunction/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入manageFunction管理页时发生错误：/manage/manageFunction/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageFunction/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(ManageFunctionQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = manageFunctionService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				ManageFunction manageFunction = (ManageFunction) baseBean.getList().get(i);
				result.append("{")
			    .append("\"functionId\":\"").append(manageFunction.getFunctionId()).append("\"").append(",")
			    .append("\"menuId\":\"").append(manageFunction.getMenuId()).append("\"").append(",")
			    .append("\"functionName\":\"").append(manageFunction.getFunctionName()).append("\"").append(",")
			    .append("\"functionDesc\":\"").append(manageFunction.getFunctionDesc()).append("\"").append(",")
			    .append("\"functionCode\":\"").append(manageFunction.getFunctionCode()).append("\"").append(",")
			    .append("\"createTime\":\"").append(manageFunction.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(manageFunction.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(manageFunction.getEditor()).append("\"")
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
			GSLogger.error("显示manageFunction列表时发生错误：/manage/manageFunction/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(ManageFunctionQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入manageFunction新增页时发生错误：/manage/manageFunction/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageFunction/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param manageFunction
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, ManageFunctionQuery query) {
		ManageFunction manageFunction = new ManageFunction();
		String json = "";
		try{
		    manageFunction.setMenuId(query.getMenuId());
		    manageFunction.setFunctionName(query.getFunctionName());
		    manageFunction.setFunctionDesc(query.getFunctionDesc());
		    manageFunction.setFunctionCode(query.getFunctionCode());
		    manageFunction.setCreateTime(query.getCreateTime());
		    manageFunction.setEditTime(query.getEditTime());
		    manageFunction.setEditor(query.getEditor());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        manageFunction.setCreateTime(ts);
	        manageFunction.setEditTime(ts);
			manageFunctionService.save(manageFunction);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存manageFunction信息时发生错误：/manage/manageFunction/save", e);
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
	public ModelAndView modify(ManageFunctionQuery query) {	
		ManageFunction manageFunction=new ManageFunction();
		
		try{
			manageFunction = manageFunctionService.findById(query.getFunctionId());
		}catch(Exception e){
			GSLogger.error("进入manageFunction修改页时发生错误：/manage/manageFunction/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageFunction/modify");
		mav.addObject("manageFunction", manageFunction);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, ManageFunctionQuery query) {
		ManageFunction manageFunction = null;
		String json = "";
		try{
		    manageFunction = manageFunctionService.findById(query.getFunctionId());
		    manageFunction.setMenuId(query.getMenuId());
		    manageFunction.setFunctionName(query.getFunctionName());
		    manageFunction.setFunctionDesc(query.getFunctionDesc());
		    manageFunction.setFunctionCode(query.getFunctionCode());
		    manageFunction.setCreateTime(query.getCreateTime());
		    manageFunction.setEditTime(query.getEditTime());
		    manageFunction.setEditor(query.getEditor());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        manageFunction.setEditTime(ts);
			manageFunctionService.update(manageFunction);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑manageFunction信息时发生错误：/manage/manageFunction/update", e);
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
						manageFunctionService.delete(new Integer(ids[i]));
					}
				}else{
					manageFunctionService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除ManageFunction时发生错误：/manage/manageFunction/delete", e);
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
