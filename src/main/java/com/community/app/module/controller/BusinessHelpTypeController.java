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

import com.community.app.module.bean.BusinessHelpType;
import com.community.app.module.service.BusinessHelpTypeService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessHelpTypeQuery;


@Controller
@RequestMapping("/business/businessHelpType")
public class BusinessHelpTypeController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessHelpTypeController.class);
	@Autowired
	private BusinessHelpTypeService businessHelpTypeService;
	
	private final String LIST_ACTION = "redirect:/business/businessHelpType/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessHelpType管理页时发生错误：/business/businessHelpType/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessHelpType/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessHelpTypeQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessHelpTypeService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessHelpType businessHelpType = (BusinessHelpType) baseBean.getList().get(i);
				result.append("{")
			    .append("\"typeId\":\"").append(businessHelpType.getTypeId()).append("\"").append(",")
			    .append("\"typeName\":\"").append(businessHelpType.getTypeName()).append("\"").append(",")
			    .append("\"typeImage\":\"").append(businessHelpType.getTypeImage()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessHelpType.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessHelpType.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessHelpType.getEditor()).append("\"")
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
			GSLogger.error("显示businessHelpType列表时发生错误：/business/businessHelpType/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessHelpTypeQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessHelpType新增页时发生错误：/business/businessHelpType/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessHelpType/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessHelpType
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessHelpTypeQuery query) {
		BusinessHelpType businessHelpType = new BusinessHelpType();
		String json = "";
		try{
		    businessHelpType.setTypeName(query.getTypeName());
		    businessHelpType.setTypeImage(query.getTypeImage());
		    businessHelpType.setCreateTime(query.getCreateTime());
		    businessHelpType.setEditTime(query.getEditTime());
		    businessHelpType.setEditor(query.getEditor());
			businessHelpTypeService.save(businessHelpType);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessHelpType信息时发生错误：/business/businessHelpType/save", e);
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
	public ModelAndView modify(BusinessHelpTypeQuery query) {	
		BusinessHelpType businessHelpType=new BusinessHelpType();
		
		try{
			businessHelpType = businessHelpTypeService.findById(query.getTypeId());
		}catch(Exception e){
			GSLogger.error("进入businessHelpType修改页时发生错误：/business/businessHelpType/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessHelpType/modify");
		mav.addObject("businessHelpType", businessHelpType);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessHelpTypeQuery query) {
		BusinessHelpType businessHelpType = null;
		String json = "";
		try{
		    businessHelpType = businessHelpTypeService.findById(query.getTypeId());
		    businessHelpType.setTypeName(query.getTypeName());
		    businessHelpType.setTypeImage(query.getTypeImage());
		    businessHelpType.setCreateTime(query.getCreateTime());
		    businessHelpType.setEditTime(query.getEditTime());
		    businessHelpType.setEditor(query.getEditor());
			businessHelpTypeService.update(businessHelpType);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessHelpType信息时发生错误：/business/businessHelpType/update", e);
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
						businessHelpTypeService.delete(new Integer(ids[i]));
					}
				}else{
					businessHelpTypeService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessHelpType时发生错误：/business/businessHelpType/delete", e);
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
