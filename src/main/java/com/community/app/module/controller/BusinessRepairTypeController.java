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

import com.community.app.module.bean.BusinessRepairType;
import com.community.app.module.service.BusinessRepairTypeService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessRepairTypeQuery;


@Controller
@RequestMapping("/business/businessRepairType")
public class BusinessRepairTypeController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessRepairTypeController.class);
	@Autowired
	private BusinessRepairTypeService businessRepairTypeService;
	
	private final String LIST_ACTION = "redirect:/business/businessRepairType/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessRepairType管理页时发生错误：/business/businessRepairType/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessRepairType/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessRepairTypeQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessRepairTypeService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessRepairType businessRepairType = (BusinessRepairType) baseBean.getList().get(i);
				result.append("{")
			    .append("\"typeId\":\"").append(businessRepairType.getTypeId()).append("\"").append(",")
			    .append("\"typeName\":\"").append(businessRepairType.getTypeName()).append("\"").append(",")
			    .append("\"typeDesc\":\"").append(businessRepairType.getTypeDesc()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessRepairType.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessRepairType.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessRepairType.getEditor()).append("\"")
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
			GSLogger.error("显示businessRepairType列表时发生错误：/business/businessRepairType/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessRepairTypeQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessRepairType新增页时发生错误：/business/businessRepairType/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessRepairType/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessRepairType
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessRepairTypeQuery query) {
		BusinessRepairType businessRepairType = new BusinessRepairType();
		String json = "";
		try{
		    businessRepairType.setTypeName(query.getTypeName());
		    businessRepairType.setTypeDesc(query.getTypeDesc());
		    businessRepairType.setCreateTime(query.getCreateTime());
		    businessRepairType.setEditTime(query.getEditTime());
		    businessRepairType.setEditor(query.getEditor());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        businessRepairType.setCreateTime(ts);
	        businessRepairType.setEditTime(ts);
			businessRepairTypeService.save(businessRepairType);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessRepairType信息时发生错误：/business/businessRepairType/save", e);
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
	public ModelAndView modify(BusinessRepairTypeQuery query) {	
		BusinessRepairType businessRepairType=new BusinessRepairType();
		
		try{
			businessRepairType = businessRepairTypeService.findById(query.getTypeId());
		}catch(Exception e){
			GSLogger.error("进入businessRepairType修改页时发生错误：/business/businessRepairType/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessRepairType/modify");
		mav.addObject("businessRepairType", businessRepairType);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessRepairTypeQuery query) {
		BusinessRepairType businessRepairType = null;
		String json = "";
		try{
		    businessRepairType = businessRepairTypeService.findById(query.getTypeId());
		    businessRepairType.setTypeName(query.getTypeName());
		    businessRepairType.setTypeDesc(query.getTypeDesc());
		    businessRepairType.setCreateTime(query.getCreateTime());
		    businessRepairType.setEditTime(query.getEditTime());
		    businessRepairType.setEditor(query.getEditor());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        businessRepairType.setEditTime(ts);
			businessRepairTypeService.update(businessRepairType);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessRepairType信息时发生错误：/business/businessRepairType/update", e);
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
						businessRepairTypeService.delete(new Integer(ids[i]));
					}
				}else{
					businessRepairTypeService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessRepairType时发生错误：/business/businessRepairType/delete", e);
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
