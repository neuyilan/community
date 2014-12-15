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


import com.community.app.module.bean.BusinessActivityMessage;
import com.community.app.module.service.BusinessActivityMessageService;
import com.community.app.module.vo.BusinessActivityMessageQuery;


@Controller
@RequestMapping("/business/businessActivityMessage")
public class BusinessActivityMessageController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessActivityMessageController.class);
	@Autowired
	private BusinessActivityMessageService businessActivityMessageService;
	
	private final String LIST_ACTION = "redirect:/business/businessActivityMessage/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessActivityMessage管理页时发生错误：/business/businessActivityMessage/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessActivityMessage/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessActivityMessageQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessActivityMessageService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessActivityMessage businessActivityMessage = (BusinessActivityMessage) baseBean.getList().get(i);
				result.append("{")
			    .append("\"messageId\":\"").append(businessActivityMessage.getMessageId()).append("\"").append(",")
			    .append("\"actId\":\"").append(businessActivityMessage.getActId()).append("\"").append(",")
			    .append("\"content\":\"").append(businessActivityMessage.getContent()).append("\"").append(",")
			    .append("\"publisherId\":\"").append(businessActivityMessage.getPublisherId()).append("\"").append(",")
			    .append("\"publisherName\":\"").append(businessActivityMessage.getPublisherName()).append("\"").append(",")
			    .append("\"publishTime\":\"").append(businessActivityMessage.getPublishTime()).append("\"").append(",")
			    .append("\"isPush\":\"").append(businessActivityMessage.getIsPush()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessActivityMessage.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessActivityMessage.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessActivityMessage.getEditor()).append("\"")
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
			GSLogger.error("显示businessActivityMessage列表时发生错误：/business/businessActivityMessage/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessActivityMessageQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessActivityMessage新增页时发生错误：/business/businessActivityMessage/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessActivityMessage/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessActivityMessage
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessActivityMessageQuery query) {
		BusinessActivityMessage businessActivityMessage = new BusinessActivityMessage();
		String json = "";
		try{
		    businessActivityMessage.setActId(query.getActId());
		    businessActivityMessage.setContent(query.getContent());
		    businessActivityMessage.setPublisherId(query.getPublisherId());
		    businessActivityMessage.setPublisherName(query.getPublisherName());
		    businessActivityMessage.setPublishTime(query.getPublishTime());
		    businessActivityMessage.setIsPush(query.getIsPush());
		    businessActivityMessage.setCreateTime(query.getCreateTime());
		    businessActivityMessage.setEditTime(query.getEditTime());
		    businessActivityMessage.setEditor(query.getEditor());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        businessActivityMessage.setCreateTime(ts);
	        businessActivityMessage.setEditTime(ts);
			businessActivityMessageService.save(businessActivityMessage);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessActivityMessage信息时发生错误：/business/businessActivityMessage/save", e);
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
	public ModelAndView modify(BusinessActivityMessageQuery query) {	
		BusinessActivityMessage businessActivityMessage=new BusinessActivityMessage();
		
		try{
			businessActivityMessage = businessActivityMessageService.findById(query.getMessageId());
		}catch(Exception e){
			GSLogger.error("进入businessActivityMessage修改页时发生错误：/business/businessActivityMessage/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessActivityMessage/modify");
		mav.addObject("businessActivityMessage", businessActivityMessage);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessActivityMessageQuery query) {
		BusinessActivityMessage businessActivityMessage = null;
		String json = "";
		try{
		    businessActivityMessage = businessActivityMessageService.findById(query.getMessageId());
		    businessActivityMessage.setActId(query.getActId());
		    businessActivityMessage.setContent(query.getContent());
		    businessActivityMessage.setPublisherId(query.getPublisherId());
		    businessActivityMessage.setPublisherName(query.getPublisherName());
		    businessActivityMessage.setPublishTime(query.getPublishTime());
		    businessActivityMessage.setIsPush(query.getIsPush());
		    businessActivityMessage.setCreateTime(query.getCreateTime());
		    businessActivityMessage.setEditTime(query.getEditTime());
		    businessActivityMessage.setEditor(query.getEditor());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        businessActivityMessage.setEditTime(ts);
			businessActivityMessageService.update(businessActivityMessage);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessActivityMessage信息时发生错误：/business/businessActivityMessage/update", e);
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
						businessActivityMessageService.delete(new Integer(ids[i]));
					}
				}else{
					businessActivityMessageService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessActivityMessage时发生错误：/business/businessActivityMessage/delete", e);
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
