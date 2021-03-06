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

import com.community.app.module.bean.BusinessActivityType;
import com.community.app.module.service.BusinessActivityTypeService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessActivityTypeQuery;


@Controller
@RequestMapping("/business/businessActivityType")
public class BusinessActivityTypeController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessActivityTypeController.class);
	@Autowired
	private BusinessActivityTypeService businessActivityTypeService;
	
	private final String LIST_ACTION = "redirect:/business/businessActivityType/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessActivityType管理页时发生错误：/business/businessActivityType/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessActivityType/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessActivityTypeQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessActivityTypeService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessActivityType businessActivityType = (BusinessActivityType) baseBean.getList().get(i);
				result.append("{")
			    .append("\"typeId\":\"").append(businessActivityType.getTypeId()).append("\"").append(",")
			    .append("\"typeName\":\"").append(businessActivityType.getTypeName()).append("\"").append(",")
			    .append("\"typeDesc\":\"").append(businessActivityType.getTypeDesc()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessActivityType.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessActivityType.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessActivityType.getEditor()).append("\"")
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
			GSLogger.error("显示businessActivityType列表时发生错误：/business/businessActivityType/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessActivityTypeQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessActivityType新增页时发生错误：/business/businessActivityType/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessActivityType/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessActivityType
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessActivityTypeQuery query) {
		BusinessActivityType businessActivityType = new BusinessActivityType();
		String json = "";
		try{
		    businessActivityType.setTypeName(query.getTypeName());
		    businessActivityType.setTypeDesc(query.getTypeDesc());
		    businessActivityType.setCreateTime(query.getCreateTime());
		    businessActivityType.setEditTime(query.getEditTime());
		    businessActivityType.setEditor(query.getEditor());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        businessActivityType.setCreateTime(ts);
	        businessActivityType.setEditTime(ts);
			businessActivityTypeService.save(businessActivityType);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessActivityType信息时发生错误：/business/businessActivityType/save", e);
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
	public ModelAndView modify(BusinessActivityTypeQuery query) {	
		BusinessActivityType businessActivityType=new BusinessActivityType();
		
		try{
			businessActivityType = businessActivityTypeService.findById(query.getTypeId());
		}catch(Exception e){
			GSLogger.error("进入businessActivityType修改页时发生错误：/business/businessActivityType/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessActivityType/modify");
		mav.addObject("businessActivityType", businessActivityType);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessActivityTypeQuery query) {
		BusinessActivityType businessActivityType = null;
		String json = "";
		try{
		    businessActivityType = businessActivityTypeService.findById(query.getTypeId());
		    businessActivityType.setTypeName(query.getTypeName());
		    businessActivityType.setTypeDesc(query.getTypeDesc());
		    businessActivityType.setCreateTime(query.getCreateTime());
		    businessActivityType.setEditTime(query.getEditTime());
		    businessActivityType.setEditor(query.getEditor());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        businessActivityType.setEditTime(ts);
			businessActivityTypeService.update(businessActivityType);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessActivityType信息时发生错误：/business/businessActivityType/update", e);
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
						businessActivityTypeService.delete(new Integer(ids[i]));
					}
				}else{
					businessActivityTypeService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessActivityType时发生错误：/business/businessActivityType/delete", e);
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
