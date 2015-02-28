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

import com.community.app.module.bean.BusinessRepairAudio;
import com.community.app.module.service.BusinessRepairAudioService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessRepairAudioQuery;


@Controller
@RequestMapping("/business/businessRepairAudio")
public class BusinessRepairAudioController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessRepairAudioController.class);
	@Autowired
	private BusinessRepairAudioService businessRepairAudioService;
	
	private final String LIST_ACTION = "redirect:/business/businessRepairAudio/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessRepairAudio管理页时发生错误：/business/businessRepairAudio/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessRepairAudio/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessRepairAudioQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessRepairAudioService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessRepairAudio businessRepairAudio = (BusinessRepairAudio) baseBean.getList().get(i);
				result.append("{")
			    .append("\"audioId\":\"").append(businessRepairAudio.getAudioId()).append("\"").append(",")
			    .append("\"repairId\":\"").append(businessRepairAudio.getRepairId()).append("\"").append(",")
			    .append("\"picUrl\":\"").append(businessRepairAudio.getPicUrl()).append("\"").append(",")
			    .append("\"size\":\"").append(businessRepairAudio.getSize()).append("\"").append(",")
			    .append("\"time\":\"").append(businessRepairAudio.getTime()).append("\"").append(",")
			    .append("\"format\":\"").append(businessRepairAudio.getFormat()).append("\"").append(",")
			    .append("\"createTime2\":\"").append(businessRepairAudio.getCreateTime2()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessRepairAudio.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessRepairAudio.getEditor()).append("\"")
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
			GSLogger.error("显示businessRepairAudio列表时发生错误：/business/businessRepairAudio/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessRepairAudioQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessRepairAudio新增页时发生错误：/business/businessRepairAudio/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessRepairAudio/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessRepairAudio
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessRepairAudioQuery query) {
		BusinessRepairAudio businessRepairAudio = new BusinessRepairAudio();
		String json = "";
		try{
		    businessRepairAudio.setRepairId(query.getRepairId());
		    businessRepairAudio.setPicUrl(query.getPicUrl());
		    businessRepairAudio.setSize(query.getSize());
		    businessRepairAudio.setTime(query.getTime());
		    businessRepairAudio.setFormat(query.getFormat());
		    businessRepairAudio.setCreateTime2(query.getCreateTime2());
		    businessRepairAudio.setEditTime(query.getEditTime());
		    businessRepairAudio.setEditor(query.getEditor());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        //businessRepairAudio.setCreateTime(ts);
	        businessRepairAudio.setEditTime(ts);
			businessRepairAudioService.save(businessRepairAudio);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessRepairAudio信息时发生错误：/business/businessRepairAudio/save", e);
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
	public ModelAndView modify(BusinessRepairAudioQuery query) {	
		BusinessRepairAudio businessRepairAudio=new BusinessRepairAudio();
		
		try{
			businessRepairAudio = businessRepairAudioService.findById(query.getAudioId());
		}catch(Exception e){
			GSLogger.error("进入businessRepairAudio修改页时发生错误：/business/businessRepairAudio/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessRepairAudio/modify");
		mav.addObject("businessRepairAudio", businessRepairAudio);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessRepairAudioQuery query) {
		BusinessRepairAudio businessRepairAudio = null;
		String json = "";
		try{
		    businessRepairAudio = businessRepairAudioService.findById(query.getAudioId());
		    businessRepairAudio.setRepairId(query.getRepairId());
		    businessRepairAudio.setPicUrl(query.getPicUrl());
		    businessRepairAudio.setSize(query.getSize());
		    businessRepairAudio.setTime(query.getTime());
		    businessRepairAudio.setFormat(query.getFormat());
		    businessRepairAudio.setCreateTime2(query.getCreateTime2());
		    businessRepairAudio.setEditTime(query.getEditTime());
		    businessRepairAudio.setEditor(query.getEditor());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        businessRepairAudio.setEditTime(ts);
			businessRepairAudioService.update(businessRepairAudio);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessRepairAudio信息时发生错误：/business/businessRepairAudio/update", e);
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
						businessRepairAudioService.delete(new Integer(ids[i]));
					}
				}else{
					businessRepairAudioService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessRepairAudio时发生错误：/business/businessRepairAudio/delete", e);
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
