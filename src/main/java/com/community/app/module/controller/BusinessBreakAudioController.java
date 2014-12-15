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

import com.community.app.module.bean.BusinessBreakAudio;
import com.community.app.module.service.BusinessBreakAudioService;
import com.community.app.module.vo.BusinessBreakAudioQuery;

@Controller
@RequestMapping("/business/businessBreakAudio")
public class BusinessBreakAudioController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessBreakAudioController.class);
	@Autowired
	private BusinessBreakAudioService businessBreakAudioService;
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessBreakAudio管理页时发生错误：/business/businessBreakAudio/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessBreakAudio/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessBreakAudioQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessBreakAudioService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessBreakAudio businessBreakAudio = (BusinessBreakAudio) baseBean.getList().get(i);
				result.append("{")
			    .append("\"audioId\":\"").append(businessBreakAudio.getAudioId()).append("\"").append(",")
			    .append("\"breakId\":\"").append(businessBreakAudio.getBreakId()).append("\"").append(",")
			    .append("\"picUrl\":\"").append(businessBreakAudio.getPicUrl()).append("\"").append(",")
			    .append("\"size\":\"").append(businessBreakAudio.getSize()).append("\"").append(",")
			    .append("\"time\":\"").append(businessBreakAudio.getTime()).append("\"").append(",")
			    .append("\"format\":\"").append(businessBreakAudio.getFormat()).append("\"").append(",")
			    .append("\"createTime2\":\"").append(businessBreakAudio.getCreateTime2()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessBreakAudio.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessBreakAudio.getEditor()).append("\"")
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
			GSLogger.error("显示businessBreakAudio列表时发生错误：/business/businessBreakAudio/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessBreakAudioQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessBreakAudio新增页时发生错误：/business/businessBreakAudio/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessBreakAudio/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessBreakAudio
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessBreakAudioQuery query) {
		BusinessBreakAudio businessBreakAudio = new BusinessBreakAudio();
		String json = "";
		try{
		    businessBreakAudio.setBreakId(query.getBreakId());
		    businessBreakAudio.setPicUrl(query.getPicUrl());
		    businessBreakAudio.setSize(query.getSize());
		    businessBreakAudio.setTime(query.getTime());
		    businessBreakAudio.setFormat(query.getFormat());
		    businessBreakAudio.setCreateTime2(query.getCreateTime2());
		    businessBreakAudio.setEditTime(query.getEditTime());
		    businessBreakAudio.setEditor(query.getEditor());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        //businessBreakAudio.setCreateTime(ts);
	        businessBreakAudio.setEditTime(ts);
			businessBreakAudioService.save(businessBreakAudio);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessBreakAudio信息时发生错误：/business/businessBreakAudio/save", e);
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
	public ModelAndView modify(BusinessBreakAudioQuery query) {	
		BusinessBreakAudio businessBreakAudio=new BusinessBreakAudio();
		
		try{
			businessBreakAudio = businessBreakAudioService.findById(query.getAudioId());
		}catch(Exception e){
			GSLogger.error("进入businessBreakAudio修改页时发生错误：/business/businessBreakAudio/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessBreakAudio/modify");
		mav.addObject("businessBreakAudio", businessBreakAudio);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessBreakAudioQuery query) {
		BusinessBreakAudio businessBreakAudio = null;
		String json = "";
		try{
		    businessBreakAudio = businessBreakAudioService.findById(query.getAudioId());
		    businessBreakAudio.setBreakId(query.getBreakId());
		    businessBreakAudio.setPicUrl(query.getPicUrl());
		    businessBreakAudio.setSize(query.getSize());
		    businessBreakAudio.setTime(query.getTime());
		    businessBreakAudio.setFormat(query.getFormat());
		    businessBreakAudio.setCreateTime2(query.getCreateTime2());
		    businessBreakAudio.setEditTime(query.getEditTime());
		    businessBreakAudio.setEditor(query.getEditor());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        businessBreakAudio.setEditTime(ts);
			businessBreakAudioService.update(businessBreakAudio);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessBreakAudio信息时发生错误：/business/businessBreakAudio/update", e);
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
						businessBreakAudioService.delete(new Integer(ids[i]));
					}
				}else{
					businessBreakAudioService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessBreakAudio时发生错误：/business/businessBreakAudio/delete", e);
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
