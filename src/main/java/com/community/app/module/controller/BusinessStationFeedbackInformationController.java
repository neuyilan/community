package com.community.app.module.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.community.app.module.bean.BusinessStationFeedbackInformation;
import com.community.app.module.service.BusinessStationFeedbackInformationService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessStationFeedbackInformationQuery;

@Controller
@RequestMapping("/business/businessStationFeedbackInformation")
public class BusinessStationFeedbackInformationController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessStationFeedbackInformationController.class);
	@Autowired
	private BusinessStationFeedbackInformationService businessStationFeedbackInformationService;
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessStationFeedbackInformation管理页时发生错误：/business/businessStationFeedbackInformation/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessStationFeedbackInformation/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessStationFeedbackInformationQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessStationFeedbackInformationService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessStationFeedbackInformation businessStationFeedbackInformation = (BusinessStationFeedbackInformation) baseBean.getList().get(i);
				result.append("{")
			    .append("\"inforId\":\"").append(businessStationFeedbackInformation.getInforId()).append("\"").append(",")
			    .append("\"feedId\":\"").append(businessStationFeedbackInformation.getFeedId()).append("\"").append(",")
			    .append("\"userId\":\"").append(businessStationFeedbackInformation.getUserId()).append("\"").append(",")
			    .append("\"feedTime\":\"").append(businessStationFeedbackInformation.getFeedTime()).append("\"").append(",")
			    .append("\"source\":\"").append(businessStationFeedbackInformation.getSource()).append("\"").append(",")
			    .append("\"flag\":\"").append(businessStationFeedbackInformation.getFlag()).append("\"")
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
			GSLogger.error("显示businessStationFeedbackInformation列表时发生错误：/business/businessStationFeedbackInformation/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessStationFeedbackInformationQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessStationFeedbackInformation新增页时发生错误：/business/businessStationFeedbackInformation/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessStationFeedbackInformation/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessStationFeedbackInformation
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessStationFeedbackInformationQuery query) {
		BusinessStationFeedbackInformation businessStationFeedbackInformation = new BusinessStationFeedbackInformation();
		String json = "";
		try{
		    businessStationFeedbackInformation.setFeedId(query.getFeedId());
		    businessStationFeedbackInformation.setUserId(query.getUserId());
		    businessStationFeedbackInformation.setFeedTime(query.getFeedTime());
		    businessStationFeedbackInformation.setSource(query.getSource());
		    businessStationFeedbackInformation.setFlag(query.getFlag());
			businessStationFeedbackInformationService.save(businessStationFeedbackInformation);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessStationFeedbackInformation信息时发生错误：/business/businessStationFeedbackInformation/save", e);
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
	public ModelAndView modify(BusinessStationFeedbackInformationQuery query) {	
		BusinessStationFeedbackInformation businessStationFeedbackInformation=new BusinessStationFeedbackInformation();
		
		try{
			businessStationFeedbackInformation = businessStationFeedbackInformationService.findById(query.getInforId());
		}catch(Exception e){
			GSLogger.error("进入businessStationFeedbackInformation修改页时发生错误：/business/businessStationFeedbackInformation/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessStationFeedbackInformation/modify");
		mav.addObject("businessStationFeedbackInformation", businessStationFeedbackInformation);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessStationFeedbackInformationQuery query) {
		BusinessStationFeedbackInformation businessStationFeedbackInformation = null;
		String json = "";
		try{
		    businessStationFeedbackInformation = businessStationFeedbackInformationService.findById(query.getInforId());
		    businessStationFeedbackInformation.setFeedId(query.getFeedId());
		    businessStationFeedbackInformation.setUserId(query.getUserId());
		    businessStationFeedbackInformation.setFeedTime(query.getFeedTime());
		    businessStationFeedbackInformation.setSource(query.getSource());
		    businessStationFeedbackInformation.setFlag(query.getFlag());
			businessStationFeedbackInformationService.update(businessStationFeedbackInformation);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessStationFeedbackInformation信息时发生错误：/business/businessStationFeedbackInformation/update", e);
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
						businessStationFeedbackInformationService.delete(new Integer(ids[i]));
					}
				}else{
					businessStationFeedbackInformationService.delete(new Integer(id));
				}
			}
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessStationFeedbackInformation时发生错误：/business/businessStationFeedbackInformation/delete", e);
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