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
import com.community.app.module.vo.BaseBean;

import com.community.app.module.bean.BusinessRepairPic;
import com.community.app.module.service.BusinessRepairPicService;
import com.community.app.module.vo.BusinessRepairPicQuery;

@Controller
@RequestMapping("/business/businessRepairPic")
public class BusinessRepairPicController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessRepairPicController.class);
	@Autowired
	private BusinessRepairPicService businessRepairPicService;
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessRepairPic管理页时发生错误：/business/businessRepairPic/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessRepairPic/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessRepairPicQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessRepairPicService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessRepairPic businessRepairPic = (BusinessRepairPic) baseBean.getList().get(i);
				result.append("{")
			    .append("\"picId\":\"").append(businessRepairPic.getPicId()).append("\"").append(",")
			    .append("\"repairId\":\"").append(businessRepairPic.getRepairId()).append("\"").append(",")
			    .append("\"picUrl\":\"").append(businessRepairPic.getPicUrl()).append("\"").append(",")
			    .append("\"size\":\"").append(businessRepairPic.getSize()).append("\"").append(",")
			    .append("\"widthHeight\":\"").append(businessRepairPic.getWidthHeight()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessRepairPic.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessRepairPic.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessRepairPic.getEditor()).append("\"")
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
			GSLogger.error("显示businessRepairPic列表时发生错误：/business/businessRepairPic/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessRepairPicQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessRepairPic新增页时发生错误：/business/businessRepairPic/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessRepairPic/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessRepairPic
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessRepairPicQuery query) {
		BusinessRepairPic businessRepairPic = new BusinessRepairPic();
		String json = "";
		try{
		    businessRepairPic.setRepairId(query.getRepairId());
		    businessRepairPic.setPicUrl(query.getPicUrl());
		    businessRepairPic.setSize(query.getSize());
		    businessRepairPic.setWidthHeight(query.getWidthHeight());
	        businessRepairPic.setCreateTime(new Timestamp(new Date().getTime()));
	        businessRepairPic.setEditTime(new Timestamp(new Date().getTime()));
		    businessRepairPic.setEditor(query.getEditor());
			businessRepairPicService.save(businessRepairPic);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessRepairPic信息时发生错误：/business/businessRepairPic/save", e);
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
	public ModelAndView modify(BusinessRepairPicQuery query) {	
		BusinessRepairPic businessRepairPic=new BusinessRepairPic();
		
		try{
			businessRepairPic = businessRepairPicService.findById(query.getPicId());
		}catch(Exception e){
			GSLogger.error("进入businessRepairPic修改页时发生错误：/business/businessRepairPic/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessRepairPic/modify");
		mav.addObject("businessRepairPic", businessRepairPic);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessRepairPicQuery query) {
		BusinessRepairPic businessRepairPic = null;
		String json = "";
		try{
		    businessRepairPic = businessRepairPicService.findById(query.getPicId());
		    businessRepairPic.setRepairId(query.getRepairId());
		    businessRepairPic.setPicUrl(query.getPicUrl());
		    businessRepairPic.setSize(query.getSize());
		    businessRepairPic.setWidthHeight(query.getWidthHeight());
		    businessRepairPic.setEditor(query.getEditor());
		    businessRepairPic.setEditTime(new Timestamp(new Date().getTime()));
			businessRepairPicService.update(businessRepairPic);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessRepairPic信息时发生错误：/business/businessRepairPic/update", e);
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
						businessRepairPicService.delete(new Integer(ids[i]));
					}
				}else{
					businessRepairPicService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessRepairPic时发生错误：/business/businessRepairPic/delete", e);
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