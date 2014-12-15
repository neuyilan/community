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


import com.community.app.module.bean.BusinessStationService;
import com.community.app.module.service.BusinessStationServiceService;
import com.community.app.module.vo.BusinessStationServiceQuery;


@Controller
@RequestMapping("/business/businessStationService")
public class BusinessStationServiceController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessStationServiceController.class);
	@Autowired
	private BusinessStationServiceService businessStationServiceService;
	
	private final String LIST_ACTION = "redirect:/business/businessStationService/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessStationService管理页时发生错误：/business/businessStationService/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessStationService/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessStationServiceQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessStationServiceService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessStationService businessStationService = (BusinessStationService) baseBean.getList().get(i);
				result.append("{")
			    .append("\"serviceId\":\"").append(businessStationService.getServiceId()).append("\"").append(",")
			    .append("\"stationId\":\"").append(businessStationService.getStationId()).append("\"").append(",")
			    .append("\"serviceName\":\"").append(businessStationService.getServiceName()).append("\"").append(",")
			    .append("\"servicePic\":\"").append(businessStationService.getServicePic()).append("\"").append(",")
			    .append("\"content\":\"").append(businessStationService.getContent()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessStationService.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessStationService.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessStationService.getEditor()).append("\"")
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
			GSLogger.error("显示businessStationService列表时发生错误：/business/businessStationService/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessStationServiceQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessStationService新增页时发生错误：/business/businessStationService/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessStationService/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessStationService
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessStationServiceQuery query) {
		BusinessStationService businessStationService = new BusinessStationService();
		String json = "";
		try{
		    businessStationService.setStationId(query.getStationId());
		    businessStationService.setServiceName(query.getServiceName());
		    businessStationService.setServicePic(query.getServicePic());
		    businessStationService.setContent(query.getContent());
		    businessStationService.setCreateTime(query.getCreateTime());
		    businessStationService.setEditTime(query.getEditTime());
		    businessStationService.setEditor(query.getEditor());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        businessStationService.setCreateTime(ts);
	        businessStationService.setEditTime(ts);
			businessStationServiceService.save(businessStationService);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessStationService信息时发生错误：/business/businessStationService/save", e);
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
	public ModelAndView modify(BusinessStationServiceQuery query) {	
		BusinessStationService businessStationService=new BusinessStationService();
		
		try{
			businessStationService = businessStationServiceService.findById(query.getServiceId());
		}catch(Exception e){
			GSLogger.error("进入businessStationService修改页时发生错误：/business/businessStationService/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessStationService/modify");
		mav.addObject("businessStationService", businessStationService);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessStationServiceQuery query) {
		BusinessStationService businessStationService = null;
		String json = "";
		try{
		    businessStationService = businessStationServiceService.findById(query.getServiceId());
		    businessStationService.setStationId(query.getStationId());
		    businessStationService.setServiceName(query.getServiceName());
		    businessStationService.setServicePic(query.getServicePic());
		    businessStationService.setContent(query.getContent());
		    businessStationService.setCreateTime(query.getCreateTime());
		    businessStationService.setEditTime(query.getEditTime());
		    businessStationService.setEditor(query.getEditor());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        businessStationService.setEditTime(ts);
			businessStationServiceService.update(businessStationService);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessStationService信息时发生错误：/business/businessStationService/update", e);
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
						businessStationServiceService.delete(new Integer(ids[i]));
					}
				}else{
					businessStationServiceService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessStationService时发生错误：/business/businessStationService/delete", e);
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
