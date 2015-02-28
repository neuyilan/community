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

import com.community.app.module.bean.BusinessLifeType;
import com.community.app.module.service.BusinessLifeTypeService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessLifeTypeQuery;


@Controller
@RequestMapping("/business/businessLifeType")
public class BusinessLifeTypeController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessLifeTypeController.class);
	@Autowired
	private BusinessLifeTypeService businessLifeTypeService;
	
	private final String LIST_ACTION = "redirect:/business/businessLifeType/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessLifeType管理页时发生错误：/business/businessLifeType/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessLifeType/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessLifeTypeQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessLifeTypeService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessLifeType businessLifeType = (BusinessLifeType) baseBean.getList().get(i);
				result.append("{")
			    .append("\"typeId\":\"").append(businessLifeType.getTypeId()).append("\"").append(",")
			    .append("\"typeName\":\"").append(businessLifeType.getTypeName()).append("\"").append(",")
			    .append("\"typeDesc\":\"").append(businessLifeType.getTypeDesc()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessLifeType.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessLifeType.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessLifeType.getEditor()).append("\"")
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
			GSLogger.error("显示businessLifeType列表时发生错误：/business/businessLifeType/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessLifeTypeQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessLifeType新增页时发生错误：/business/businessLifeType/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessLifeType/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessLifeType
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessLifeTypeQuery query) {
		BusinessLifeType businessLifeType = new BusinessLifeType();
		String json = "";
		try{
		    businessLifeType.setTypeName(query.getTypeName());
		    businessLifeType.setTypeDesc(query.getTypeDesc());
		    businessLifeType.setCreateTime(query.getCreateTime());
		    businessLifeType.setEditTime(query.getEditTime());
		    businessLifeType.setEditor(query.getEditor());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        businessLifeType.setCreateTime(ts);
	        businessLifeType.setEditTime(ts);
			businessLifeTypeService.save(businessLifeType);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessLifeType信息时发生错误：/business/businessLifeType/save", e);
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
	public ModelAndView modify(BusinessLifeTypeQuery query) {	
		BusinessLifeType businessLifeType=new BusinessLifeType();
		
		try{
			businessLifeType = businessLifeTypeService.findById(query.getTypeId());
		}catch(Exception e){
			GSLogger.error("进入businessLifeType修改页时发生错误：/business/businessLifeType/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessLifeType/modify");
		mav.addObject("businessLifeType", businessLifeType);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessLifeTypeQuery query) {
		BusinessLifeType businessLifeType = null;
		String json = "";
		try{
		    businessLifeType = businessLifeTypeService.findById(query.getTypeId());
		    businessLifeType.setTypeName(query.getTypeName());
		    businessLifeType.setTypeDesc(query.getTypeDesc());
		    businessLifeType.setCreateTime(query.getCreateTime());
		    businessLifeType.setEditTime(query.getEditTime());
		    businessLifeType.setEditor(query.getEditor());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        businessLifeType.setEditTime(ts);
			businessLifeTypeService.update(businessLifeType);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessLifeType信息时发生错误：/business/businessLifeType/update", e);
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
						businessLifeTypeService.delete(new Integer(ids[i]));
					}
				}else{
					businessLifeTypeService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessLifeType时发生错误：/business/businessLifeType/delete", e);
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
