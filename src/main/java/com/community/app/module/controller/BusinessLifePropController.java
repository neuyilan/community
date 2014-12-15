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


import com.community.app.module.bean.BusinessLifeProp;
import com.community.app.module.service.BusinessLifePropService;
import com.community.app.module.vo.BusinessLifePropQuery;


@Controller
@RequestMapping("/business/businessLifeProp")
public class BusinessLifePropController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessLifePropController.class);
	@Autowired
	private BusinessLifePropService businessLifePropService;
	
	private final String LIST_ACTION = "redirect:/business/businessLifeProp/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessLifeProp管理页时发生错误：/business/businessLifeProp/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessLifeProp/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessLifePropQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessLifePropService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessLifeProp businessLifeProp = (BusinessLifeProp) baseBean.getList().get(i);
				result.append("{")
			    .append("\"lipoId\":\"").append(businessLifeProp.getLipoId()).append("\"").append(",")
			    .append("\"propId\":\"").append(businessLifeProp.getPropId()).append("\"").append(",")
			    .append("\"serviceId\":\"").append(businessLifeProp.getServiceId()).append("\"").append(",")
			    .append("\"propName\":\"").append(businessLifeProp.getPropName()).append("\"").append(",")
			    .append("\"propValue\":\"").append(businessLifeProp.getPropValue()).append("\"").append(",")
			    .append("\"propType\":\"").append(businessLifeProp.getPropType()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessLifeProp.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessLifeProp.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessLifeProp.getEditor()).append("\"")
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
			GSLogger.error("显示businessLifeProp列表时发生错误：/business/businessLifeProp/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessLifePropQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessLifeProp新增页时发生错误：/business/businessLifeProp/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessLifeProp/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessLifeProp
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessLifePropQuery query) {
		BusinessLifeProp businessLifeProp = new BusinessLifeProp();
		String json = "";
		try{
		    businessLifeProp.setPropId(query.getPropId());
		    businessLifeProp.setServiceId(query.getServiceId());
		    businessLifeProp.setPropName(query.getPropName());
		    businessLifeProp.setPropValue(query.getPropValue());
		    businessLifeProp.setPropType(query.getPropType());
		    businessLifeProp.setCreateTime(query.getCreateTime());
		    businessLifeProp.setEditTime(query.getEditTime());
		    businessLifeProp.setEditor(query.getEditor());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        businessLifeProp.setCreateTime(ts);
	        businessLifeProp.setEditTime(ts);
			businessLifePropService.save(businessLifeProp);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessLifeProp信息时发生错误：/business/businessLifeProp/save", e);
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
	public ModelAndView modify(BusinessLifePropQuery query) {	
		BusinessLifeProp businessLifeProp=new BusinessLifeProp();
		
		try{
			businessLifeProp = businessLifePropService.findById(query.getLipoId());
		}catch(Exception e){
			GSLogger.error("进入businessLifeProp修改页时发生错误：/business/businessLifeProp/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessLifeProp/modify");
		mav.addObject("businessLifeProp", businessLifeProp);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessLifePropQuery query) {
		BusinessLifeProp businessLifeProp = null;
		String json = "";
		try{
		    businessLifeProp = businessLifePropService.findById(query.getLipoId());
		    businessLifeProp.setPropId(query.getPropId());
		    businessLifeProp.setServiceId(query.getServiceId());
		    businessLifeProp.setPropName(query.getPropName());
		    businessLifeProp.setPropValue(query.getPropValue());
		    businessLifeProp.setPropType(query.getPropType());
		    businessLifeProp.setCreateTime(query.getCreateTime());
		    businessLifeProp.setEditTime(query.getEditTime());
		    businessLifeProp.setEditor(query.getEditor());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        businessLifeProp.setEditTime(ts);
			businessLifePropService.update(businessLifeProp);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessLifeProp信息时发生错误：/business/businessLifeProp/update", e);
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
						businessLifePropService.delete(new Integer(ids[i]));
					}
				}else{
					businessLifePropService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessLifeProp时发生错误：/business/businessLifeProp/delete", e);
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
