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

import com.community.app.module.bean.BusinessFeedbackPic;
import com.community.app.module.service.BusinessFeedbackPicService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessFeedbackPicQuery;


@Controller
@RequestMapping("/business/businessFeedbackPic")
public class BusinessFeedbackPicController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessFeedbackPicController.class);
	@Autowired
	private BusinessFeedbackPicService businessFeedbackPicService;
	
	private final String LIST_ACTION = "redirect:/business/businessFeedbackPic/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessFeedbackPic管理页时发生错误：/business/businessFeedbackPic/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessFeedbackPic/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessFeedbackPicQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessFeedbackPicService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessFeedbackPic businessFeedbackPic = (BusinessFeedbackPic) baseBean.getList().get(i);
				result.append("{")
			    .append("\"picId\":\"").append(businessFeedbackPic.getPicId()).append("\"").append(",")
			    .append("\"feedbackId\":\"").append(businessFeedbackPic.getFeedbackId()).append("\"").append(",")
			    .append("\"picUrl\":\"").append(businessFeedbackPic.getPicUrl()).append("\"").append(",")
			    .append("\"size\":\"").append(businessFeedbackPic.getSize()).append("\"").append(",")
			    .append("\"widthHeight\":\"").append(businessFeedbackPic.getWidthHeight()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessFeedbackPic.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessFeedbackPic.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessFeedbackPic.getEditor()).append("\"")
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
			GSLogger.error("显示businessFeedbackPic列表时发生错误：/business/businessFeedbackPic/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessFeedbackPicQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessFeedbackPic新增页时发生错误：/business/businessFeedbackPic/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessFeedbackPic/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessFeedbackPic
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessFeedbackPicQuery query) {
		BusinessFeedbackPic businessFeedbackPic = new BusinessFeedbackPic();
		String json = "";
		try{
		    businessFeedbackPic.setFeedbackId(query.getFeedbackId());
		    businessFeedbackPic.setPicUrl(query.getPicUrl());
		    businessFeedbackPic.setSize(query.getSize());
		    businessFeedbackPic.setWidthHeight(query.getWidthHeight());
		    businessFeedbackPic.setCreateTime(query.getCreateTime());
		    businessFeedbackPic.setEditTime(query.getEditTime());
		    businessFeedbackPic.setEditor(query.getEditor());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        businessFeedbackPic.setCreateTime(ts);
	        businessFeedbackPic.setEditTime(ts);
			businessFeedbackPicService.save(businessFeedbackPic);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessFeedbackPic信息时发生错误：/business/businessFeedbackPic/save", e);
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
	public ModelAndView modify(BusinessFeedbackPicQuery query) {	
		BusinessFeedbackPic businessFeedbackPic=new BusinessFeedbackPic();
		
		try{
			businessFeedbackPic = businessFeedbackPicService.findById(query.getPicId());
		}catch(Exception e){
			GSLogger.error("进入businessFeedbackPic修改页时发生错误：/business/businessFeedbackPic/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessFeedbackPic/modify");
		mav.addObject("businessFeedbackPic", businessFeedbackPic);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessFeedbackPicQuery query) {
		BusinessFeedbackPic businessFeedbackPic = null;
		String json = "";
		try{
		    businessFeedbackPic = businessFeedbackPicService.findById(query.getPicId());
		    businessFeedbackPic.setFeedbackId(query.getFeedbackId());
		    businessFeedbackPic.setPicUrl(query.getPicUrl());
		    businessFeedbackPic.setSize(query.getSize());
		    businessFeedbackPic.setWidthHeight(query.getWidthHeight());
		    businessFeedbackPic.setCreateTime(query.getCreateTime());
		    businessFeedbackPic.setEditTime(query.getEditTime());
		    businessFeedbackPic.setEditor(query.getEditor());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        businessFeedbackPic.setEditTime(ts);
			businessFeedbackPicService.update(businessFeedbackPic);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessFeedbackPic信息时发生错误：/business/businessFeedbackPic/update", e);
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
						businessFeedbackPicService.delete(new Integer(ids[i]));
					}
				}else{
					businessFeedbackPicService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessFeedbackPic时发生错误：/business/businessFeedbackPic/delete", e);
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
