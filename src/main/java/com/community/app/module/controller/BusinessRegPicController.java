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


import com.community.app.module.bean.BusinessRegPic;
import com.community.app.module.service.BusinessRegPicService;
import com.community.app.module.vo.BusinessRegPicQuery;


@Controller
@RequestMapping("/business/businessRegPic")
public class BusinessRegPicController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessRegPicController.class);
	@Autowired
	private BusinessRegPicService businessRegPicService;
	
	private final String LIST_ACTION = "redirect:/business/businessRegPic/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessRegPic管理页时发生错误：/business/businessRegPic/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessRegPic/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessRegPicQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessRegPicService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessRegPic businessRegPic = (BusinessRegPic) baseBean.getList().get(i);
				result.append("{")
			    .append("\"picId\":\"").append(businessRegPic.getPicId()).append("\"").append(",")
			    .append("\"regId\":\"").append(businessRegPic.getRegId()).append("\"").append(",")
			    .append("\"picUrl\":\"").append(businessRegPic.getPicUrl()).append("\"")
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
			GSLogger.error("显示businessRegPic列表时发生错误：/business/businessRegPic/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessRegPicQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessRegPic新增页时发生错误：/business/businessRegPic/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessRegPic/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessRegPic
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessRegPicQuery query) {
		BusinessRegPic businessRegPic = new BusinessRegPic();
		String json = "";
		try{
		    businessRegPic.setRegId(query.getRegId());
		    businessRegPic.setPicUrl(query.getPicUrl());
			businessRegPicService.save(businessRegPic);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessRegPic信息时发生错误：/business/businessRegPic/save", e);
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
	public ModelAndView modify(BusinessRegPicQuery query) {	
		BusinessRegPic businessRegPic=new BusinessRegPic();
		
		try{
			businessRegPic = businessRegPicService.findById(query.getPicId());
		}catch(Exception e){
			GSLogger.error("进入businessRegPic修改页时发生错误：/business/businessRegPic/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessRegPic/modify");
		mav.addObject("businessRegPic", businessRegPic);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessRegPicQuery query) {
		BusinessRegPic businessRegPic = null;
		String json = "";
		try{
		    businessRegPic = businessRegPicService.findById(query.getPicId());
		    businessRegPic.setRegId(query.getRegId());
		    businessRegPic.setPicUrl(query.getPicUrl());
			businessRegPicService.update(businessRegPic);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessRegPic信息时发生错误：/business/businessRegPic/update", e);
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
						businessRegPicService.delete(new Integer(ids[i]));
					}
				}else{
					businessRegPicService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessRegPic时发生错误：/business/businessRegPic/delete", e);
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
