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


import com.community.app.module.bean.BusinessActivitySupport;
import com.community.app.module.service.BusinessActivitySupportService;
import com.community.app.module.vo.BusinessActivitySupportQuery;


@Controller
@RequestMapping("/business/businessActivitySupport")
public class BusinessActivitySupportController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessActivitySupportController.class);
	@Autowired
	private BusinessActivitySupportService businessActivitySupportService;
	
	private final String LIST_ACTION = "redirect:/business/businessActivitySupport/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessActivitySupport管理页时发生错误：/business/businessActivitySupport/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessActivitySupport/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessActivitySupportQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessActivitySupportService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessActivitySupport businessActivitySupport = (BusinessActivitySupport) baseBean.getList().get(i);
				result.append("{")
			    .append("\"actId\":\"").append(businessActivitySupport.getActId()).append("\"").append(",")
			    .append("\"userId\":\"").append(businessActivitySupport.getUserId()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessActivitySupport.getCreateTime()).append("\"")
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
			GSLogger.error("显示businessActivitySupport列表时发生错误：/business/businessActivitySupport/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessActivitySupportQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessActivitySupport新增页时发生错误：/business/businessActivitySupport/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessActivitySupport/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessActivitySupport
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessActivitySupportQuery query) {
		BusinessActivitySupport businessActivitySupport = new BusinessActivitySupport();
		String json = "";
		try{
		    businessActivitySupport.setCreateTime(query.getCreateTime());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        businessActivitySupport.setCreateTime(ts);
	       // businessActivitySupport.setEditTime(ts);
			businessActivitySupportService.save(businessActivitySupport);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessActivitySupport信息时发生错误：/business/businessActivitySupport/save", e);
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
	public ModelAndView modify(BusinessActivitySupportQuery query) {	
		BusinessActivitySupport businessActivitySupport=new BusinessActivitySupport();
		
		try{
			businessActivitySupport = businessActivitySupportService.findById(query.getActId());
			businessActivitySupport = businessActivitySupportService.findById(query.getUserId());
		}catch(Exception e){
			GSLogger.error("进入businessActivitySupport修改页时发生错误：/business/businessActivitySupport/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessActivitySupport/modify");
		mav.addObject("businessActivitySupport", businessActivitySupport);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessActivitySupportQuery query) {
		BusinessActivitySupport businessActivitySupport = null;
		String json = "";
		try{
		    businessActivitySupport = businessActivitySupportService.findById(query.getActId());
		    businessActivitySupport = businessActivitySupportService.findById(query.getUserId());
		    businessActivitySupport.setCreateTime(query.getCreateTime());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	       // businessActivitySupport.setEditTime(ts);
			businessActivitySupportService.update(businessActivitySupport);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessActivitySupport信息时发生错误：/business/businessActivitySupport/update", e);
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
						businessActivitySupportService.delete(new Integer(ids[i]));
					}
				}else{
					businessActivitySupportService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessActivitySupport时发生错误：/business/businessActivitySupport/delete", e);
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
