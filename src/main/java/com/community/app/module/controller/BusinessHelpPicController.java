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

import com.community.app.module.bean.BusinessHelpPic;
import com.community.app.module.service.BusinessHelpPicService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessHelpPicQuery;

@Controller
@RequestMapping("/business/businessHelpPic")
public class BusinessHelpPicController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessHelpPicController.class);
	@Autowired
	private BusinessHelpPicService businessHelpPicService;;
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessHelpPic管理页时发生错误：/business/businessHelpPic/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessHelpPic/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessHelpPicQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessHelpPicService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessHelpPic businessHelpPic = (BusinessHelpPic) baseBean.getList().get(i);
				result.append("{")
			    .append("\"picId\":\"").append(businessHelpPic.getPicId()).append("\"").append(",")
			    .append("\"helpId\":\"").append(businessHelpPic.getHelpId()).append("\"").append(",")
			    .append("\"picUrl\":\"").append(businessHelpPic.getPicUrl()).append("\"").append(",")
			    .append("\"size\":\"").append(businessHelpPic.getSize()).append("\"").append(",")
			    .append("\"widthHeight\":\"").append(businessHelpPic.getWidthHeight()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessHelpPic.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessHelpPic.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessHelpPic.getEditor()).append("\"")
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
			GSLogger.error("显示businessHelpPic列表时发生错误：/business/businessHelpPic/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessHelpPicQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessHelpPic新增页时发生错误：/business/businessHelpPic/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessHelpPic/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessHelpPic
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessHelpPicQuery query) {
		BusinessHelpPic businessHelpPic = new BusinessHelpPic();
		String json = "";
		try{
		    businessHelpPic.setHelpId(query.getHelpId());
		    businessHelpPic.setPicUrl(query.getPicUrl());
		    businessHelpPic.setSize(query.getSize());
		    businessHelpPic.setWidthHeight(query.getWidthHeight());
		    businessHelpPic.setCreateTime(query.getCreateTime());
		    businessHelpPic.setEditTime(query.getEditTime());
		    businessHelpPic.setEditor(query.getEditor());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        businessHelpPic.setCreateTime(ts);
	        businessHelpPic.setEditTime(ts);
			businessHelpPicService.save(businessHelpPic);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessHelpPic信息时发生错误：/business/businessHelpPic/save", e);
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
	public ModelAndView modify(BusinessHelpPicQuery query) {	
		BusinessHelpPic businessHelpPic=new BusinessHelpPic();
		
		try{
			businessHelpPic = businessHelpPicService.findById(query.getPicId());
		}catch(Exception e){
			GSLogger.error("进入businessHelpPic修改页时发生错误：/business/businessHelpPic/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessHelpPic/modify");
		mav.addObject("businessHelpPic", businessHelpPic);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessHelpPicQuery query) {
		BusinessHelpPic businessHelpPic = null;
		String json = "";
		try{
		    businessHelpPic = businessHelpPicService.findById(query.getPicId());
		    businessHelpPic.setHelpId(query.getHelpId());
		    businessHelpPic.setPicUrl(query.getPicUrl());
		    businessHelpPic.setSize(query.getSize());
		    businessHelpPic.setWidthHeight(query.getWidthHeight());
		    businessHelpPic.setCreateTime(query.getCreateTime());
		    businessHelpPic.setEditTime(query.getEditTime());
		    businessHelpPic.setEditor(query.getEditor());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        businessHelpPic.setEditTime(ts);
			businessHelpPicService.update(businessHelpPic);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessHelpPic信息时发生错误：/business/businessHelpPic/update", e);
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
						businessHelpPicService.delete(new Integer(ids[i]));
					}
				}else{
					businessHelpPicService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessHelpPic时发生错误：/business/businessHelpPic/delete", e);
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
