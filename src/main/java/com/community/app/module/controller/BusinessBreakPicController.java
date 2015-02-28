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

import com.community.app.module.bean.BusinessBreakPic;
import com.community.app.module.service.BusinessBreakPicService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessBreakPicQuery;

@Controller
@RequestMapping("/business/businessBreakPic")
public class BusinessBreakPicController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessBreakPicController.class);
	@Autowired
	private BusinessBreakPicService businessBreakPicService;
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessBreakPic管理页时发生错误：/business/businessBreakPic/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessBreakPic/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessBreakPicQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessBreakPicService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessBreakPic businessBreakPic = (BusinessBreakPic) baseBean.getList().get(i);
				result.append("{")
			    .append("\"picId\":\"").append(businessBreakPic.getPicId()).append("\"").append(",")
			    .append("\"breakId\":\"").append(businessBreakPic.getBreakId()).append("\"").append(",")
			    .append("\"picUrl\":\"").append(businessBreakPic.getPicUrl()).append("\"").append(",")
			    .append("\"size\":\"").append(businessBreakPic.getSize()).append("\"").append(",")
			    .append("\"widthHeight\":\"").append(businessBreakPic.getWidthHeight()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessBreakPic.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessBreakPic.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessBreakPic.getEditor()).append("\"")
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
			GSLogger.error("显示businessBreakPic列表时发生错误：/business/businessBreakPic/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessBreakPicQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessBreakPic新增页时发生错误：/business/businessBreakPic/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessBreakPic/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessBreakPic
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessBreakPicQuery query) {
		BusinessBreakPic businessBreakPic = new BusinessBreakPic();
		String json = "";
		try{
		    businessBreakPic.setBreakId(query.getBreakId());
		    businessBreakPic.setPicUrl(query.getPicUrl());
		    businessBreakPic.setSize(query.getSize());
		    businessBreakPic.setWidthHeight(query.getWidthHeight());
		    businessBreakPic.setCreateTime(query.getCreateTime());
		    businessBreakPic.setEditTime(query.getEditTime());
		    businessBreakPic.setEditor(query.getEditor());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        businessBreakPic.setCreateTime(ts);
	        businessBreakPic.setEditTime(ts);
			businessBreakPicService.save(businessBreakPic);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessBreakPic信息时发生错误：/business/businessBreakPic/save", e);
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
	public ModelAndView modify(BusinessBreakPicQuery query) {	
		BusinessBreakPic businessBreakPic=new BusinessBreakPic();
		
		try{
			businessBreakPic = businessBreakPicService.findById(query.getPicId());
		}catch(Exception e){
			GSLogger.error("进入businessBreakPic修改页时发生错误：/business/businessBreakPic/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessBreakPic/modify");
		mav.addObject("businessBreakPic", businessBreakPic);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessBreakPicQuery query) {
		BusinessBreakPic businessBreakPic = null;
		String json = "";
		try{
		    businessBreakPic = businessBreakPicService.findById(query.getPicId());
		    businessBreakPic.setBreakId(query.getBreakId());
		    businessBreakPic.setPicUrl(query.getPicUrl());
		    businessBreakPic.setSize(query.getSize());
		    businessBreakPic.setWidthHeight(query.getWidthHeight());
		    businessBreakPic.setCreateTime(query.getCreateTime());
		    businessBreakPic.setEditTime(query.getEditTime());
		    businessBreakPic.setEditor(query.getEditor());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        businessBreakPic.setEditTime(ts);
			businessBreakPicService.update(businessBreakPic);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessBreakPic信息时发生错误：/business/businessBreakPic/update", e);
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
						businessBreakPicService.delete(new Integer(ids[i]));
					}
				}else{
					businessBreakPicService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessBreakPic时发生错误：/business/businessBreakPic/delete", e);
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
