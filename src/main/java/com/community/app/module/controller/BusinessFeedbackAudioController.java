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

import com.community.app.module.bean.BusinessFeedbackAudio;
import com.community.app.module.service.BusinessFeedbackAudioService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessFeedbackAudioQuery;


@Controller
@RequestMapping("/business/businessFeedbackAudio")
public class BusinessFeedbackAudioController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessFeedbackAudioController.class);
	@Autowired
	private BusinessFeedbackAudioService businessFeedbackAudioService;
	
	private final String LIST_ACTION = "redirect:/business/businessFeedbackAudio/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessFeedbackAudio管理页时发生错误：/business/businessFeedbackAudio/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessFeedbackAudio/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessFeedbackAudioQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessFeedbackAudioService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessFeedbackAudio businessFeedbackAudio = (BusinessFeedbackAudio) baseBean.getList().get(i);
				result.append("{")
			    .append("\"audioId\":\"").append(businessFeedbackAudio.getAudioId()).append("\"").append(",")
			    .append("\"feedbackId\":\"").append(businessFeedbackAudio.getFeedbackId()).append("\"").append(",")
			    .append("\"picUrl\":\"").append(businessFeedbackAudio.getPicUrl()).append("\"").append(",")
			    .append("\"size\":\"").append(businessFeedbackAudio.getSize()).append("\"").append(",")
			    .append("\"time\":\"").append(businessFeedbackAudio.getTime()).append("\"").append(",")
			    .append("\"format\":\"").append(businessFeedbackAudio.getFormat()).append("\"").append(",")
			    .append("\"createTime2\":\"").append(businessFeedbackAudio.getCreateTime2()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessFeedbackAudio.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessFeedbackAudio.getEditor()).append("\"")
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
			GSLogger.error("显示businessFeedbackAudio列表时发生错误：/business/businessFeedbackAudio/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessFeedbackAudioQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessFeedbackAudio新增页时发生错误：/business/businessFeedbackAudio/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessFeedbackAudio/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessFeedbackAudio
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessFeedbackAudioQuery query) {
		BusinessFeedbackAudio businessFeedbackAudio = new BusinessFeedbackAudio();
		String json = "";
		try{
		    businessFeedbackAudio.setFeedbackId(query.getFeedbackId());
		    businessFeedbackAudio.setPicUrl(query.getPicUrl());
		    businessFeedbackAudio.setSize(query.getSize());
		    businessFeedbackAudio.setTime(query.getTime());
		    businessFeedbackAudio.setFormat(query.getFormat());
		    businessFeedbackAudio.setCreateTime2(query.getCreateTime2());
		    businessFeedbackAudio.setEditTime(query.getEditTime());
		    businessFeedbackAudio.setEditor(query.getEditor());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        //businessFeedbackAudio.setCreateTime(ts);
	        businessFeedbackAudio.setEditTime(ts);
			businessFeedbackAudioService.save(businessFeedbackAudio);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessFeedbackAudio信息时发生错误：/business/businessFeedbackAudio/save", e);
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
	public ModelAndView modify(BusinessFeedbackAudioQuery query) {	
		BusinessFeedbackAudio businessFeedbackAudio=new BusinessFeedbackAudio();
		
		try{
			businessFeedbackAudio = businessFeedbackAudioService.findById(query.getAudioId());
		}catch(Exception e){
			GSLogger.error("进入businessFeedbackAudio修改页时发生错误：/business/businessFeedbackAudio/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessFeedbackAudio/modify");
		mav.addObject("businessFeedbackAudio", businessFeedbackAudio);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessFeedbackAudioQuery query) {
		BusinessFeedbackAudio businessFeedbackAudio = null;
		String json = "";
		try{
		    businessFeedbackAudio = businessFeedbackAudioService.findById(query.getAudioId());
		    businessFeedbackAudio.setFeedbackId(query.getFeedbackId());
		    businessFeedbackAudio.setPicUrl(query.getPicUrl());
		    businessFeedbackAudio.setSize(query.getSize());
		    businessFeedbackAudio.setTime(query.getTime());
		    businessFeedbackAudio.setFormat(query.getFormat());
		    businessFeedbackAudio.setCreateTime2(query.getCreateTime2());
		    businessFeedbackAudio.setEditTime(query.getEditTime());
		    businessFeedbackAudio.setEditor(query.getEditor());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        businessFeedbackAudio.setEditTime(ts);
			businessFeedbackAudioService.update(businessFeedbackAudio);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessFeedbackAudio信息时发生错误：/business/businessFeedbackAudio/update", e);
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
						businessFeedbackAudioService.delete(new Integer(ids[i]));
					}
				}else{
					businessFeedbackAudioService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessFeedbackAudio时发生错误：/business/businessFeedbackAudio/delete", e);
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
