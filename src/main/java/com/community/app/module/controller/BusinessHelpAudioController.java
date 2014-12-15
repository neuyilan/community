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


import com.community.app.module.bean.BusinessHelpAudio;
import com.community.app.module.service.BusinessHelpAudioService;
import com.community.app.module.vo.BusinessHelpAudioQuery;


@Controller
@RequestMapping("/business/businessHelpAudio")
public class BusinessHelpAudioController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessHelpAudioController.class);
	@Autowired
	private BusinessHelpAudioService businessHelpAudioService;
	
	private final String LIST_ACTION = "redirect:/business/businessHelpAudio/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessHelpAudio管理页时发生错误：/business/businessHelpAudio/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessHelpAudio/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessHelpAudioQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessHelpAudioService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessHelpAudio businessHelpAudio = (BusinessHelpAudio) baseBean.getList().get(i);
				result.append("{")
			    .append("\"audioId\":\"").append(businessHelpAudio.getAudioId()).append("\"").append(",")
			    .append("\"helpId\":\"").append(businessHelpAudio.getHelpId()).append("\"").append(",")
			    .append("\"picUrl\":\"").append(businessHelpAudio.getPicUrl()).append("\"").append(",")
			    .append("\"size\":\"").append(businessHelpAudio.getSize()).append("\"").append(",")
			    .append("\"time\":\"").append(businessHelpAudio.getTime()).append("\"").append(",")
			    .append("\"format\":\"").append(businessHelpAudio.getFormat()).append("\"").append(",")
			    .append("\"createTime2\":\"").append(businessHelpAudio.getCreateTime2()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessHelpAudio.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessHelpAudio.getEditor()).append("\"")
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
			GSLogger.error("显示businessHelpAudio列表时发生错误：/business/businessHelpAudio/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessHelpAudioQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessHelpAudio新增页时发生错误：/business/businessHelpAudio/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessHelpAudio/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessHelpAudio
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessHelpAudioQuery query) {
		BusinessHelpAudio businessHelpAudio = new BusinessHelpAudio();
		String json = "";
		try{
		    businessHelpAudio.setHelpId(query.getHelpId());
		    businessHelpAudio.setPicUrl(query.getPicUrl());
		    businessHelpAudio.setSize(query.getSize());
		    businessHelpAudio.setTime(query.getTime());
		    businessHelpAudio.setFormat(query.getFormat());
		    businessHelpAudio.setCreateTime2(query.getCreateTime2());
		    businessHelpAudio.setEditTime(query.getEditTime());
		    businessHelpAudio.setEditor(query.getEditor());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        //businessHelpAudio.setCreateTime(ts);
	        businessHelpAudio.setEditTime(ts);
			businessHelpAudioService.save(businessHelpAudio);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessHelpAudio信息时发生错误：/business/businessHelpAudio/save", e);
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
	public ModelAndView modify(BusinessHelpAudioQuery query) {	
		BusinessHelpAudio businessHelpAudio=new BusinessHelpAudio();
		
		try{
			businessHelpAudio = businessHelpAudioService.findById(query.getAudioId());
		}catch(Exception e){
			GSLogger.error("进入businessHelpAudio修改页时发生错误：/business/businessHelpAudio/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessHelpAudio/modify");
		mav.addObject("businessHelpAudio", businessHelpAudio);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessHelpAudioQuery query) {
		BusinessHelpAudio businessHelpAudio = null;
		String json = "";
		try{
		    businessHelpAudio = businessHelpAudioService.findById(query.getAudioId());
		    businessHelpAudio.setHelpId(query.getHelpId());
		    businessHelpAudio.setPicUrl(query.getPicUrl());
		    businessHelpAudio.setSize(query.getSize());
		    businessHelpAudio.setTime(query.getTime());
		    businessHelpAudio.setFormat(query.getFormat());
		    businessHelpAudio.setCreateTime2(query.getCreateTime2());
		    businessHelpAudio.setEditTime(query.getEditTime());
		    businessHelpAudio.setEditor(query.getEditor());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        businessHelpAudio.setEditTime(ts);
			businessHelpAudioService.update(businessHelpAudio);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessHelpAudio信息时发生错误：/business/businessHelpAudio/update", e);
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
						businessHelpAudioService.delete(new Integer(ids[i]));
					}
				}else{
					businessHelpAudioService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessHelpAudio时发生错误：/business/businessHelpAudio/delete", e);
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
