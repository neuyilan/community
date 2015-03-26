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

import com.community.app.module.bean.BusinessStationFeedback;
import com.community.app.module.service.BusinessStationFeedbackService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessStationFeedbackQuery;

@Controller
@RequestMapping("/business/businessStationFeedback")
public class BusinessStationFeedbackController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessStationFeedbackController.class);
	@Autowired
	private BusinessStationFeedbackService businessStationFeedbackService;
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessStationFeedback管理页时发生错误：/business/businessStationFeedback/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessStationFeedback/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessStationFeedbackQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessStationFeedbackService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessStationFeedback businessStationFeedback = (BusinessStationFeedback) baseBean.getList().get(i);
				result.append("{")
			    .append("\"feedId\":\"").append(businessStationFeedback.getFeedId()).append("\"").append(",")
			    .append("\"comId\":\"").append(businessStationFeedback.getComId()).append("\"").append(",")
			    .append("\"comName\":\"").append(businessStationFeedback.getComName()).append("\"").append(",")
			    .append("\"estateId\":\"").append(businessStationFeedback.getEstateId()).append("\"").append(",")
			    .append("\"estateName\":\"").append(businessStationFeedback.getEstateName()).append("\"").append(",")
			    .append("\"state\":\"").append(businessStationFeedback.getState()).append("\"").append(",")
			    .append("\"totalPoll\":\"").append(businessStationFeedback.getTotalPoll()).append("\"")
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
			GSLogger.error("显示businessStationFeedback列表时发生错误：/business/businessStationFeedback/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessStationFeedbackQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessStationFeedback新增页时发生错误：/business/businessStationFeedback/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessStationFeedback/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessStationFeedback
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessStationFeedbackQuery query) {
		BusinessStationFeedback businessStationFeedback = new BusinessStationFeedback();
		String json = "";
		try{
		    businessStationFeedback.setComId(query.getComId());
		    businessStationFeedback.setComName(query.getComName());
		    businessStationFeedback.setEstateId(query.getEstateId());
		    businessStationFeedback.setEstateName(query.getEstateName());
		    businessStationFeedback.setState(query.getState());
		    businessStationFeedback.setTotalPoll(query.getTotalPoll());
			businessStationFeedbackService.save(businessStationFeedback);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessStationFeedback信息时发生错误：/business/businessStationFeedback/save", e);
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
	public ModelAndView modify(BusinessStationFeedbackQuery query) {	
		BusinessStationFeedback businessStationFeedback=new BusinessStationFeedback();
		
		try{
			businessStationFeedback = businessStationFeedbackService.findById(query.getFeedId());
		}catch(Exception e){
			GSLogger.error("进入businessStationFeedback修改页时发生错误：/business/businessStationFeedback/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessStationFeedback/modify");
		mav.addObject("businessStationFeedback", businessStationFeedback);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessStationFeedbackQuery query) {
		BusinessStationFeedback businessStationFeedback = null;
		String json = "";
		try{
		    businessStationFeedback = businessStationFeedbackService.findById(query.getFeedId());
		    businessStationFeedback.setComId(query.getComId());
		    businessStationFeedback.setComName(query.getComName());
		    businessStationFeedback.setEstateId(query.getEstateId());
		    businessStationFeedback.setEstateName(query.getEstateName());
		    businessStationFeedback.setState(query.getState());
		    businessStationFeedback.setTotalPoll(query.getTotalPoll());
			businessStationFeedbackService.update(businessStationFeedback);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessStationFeedback信息时发生错误：/business/businessStationFeedback/update", e);
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
						businessStationFeedbackService.delete(new Integer(ids[i]));
					}
				}else{
					businessStationFeedbackService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessStationFeedback时发生错误：/business/businessStationFeedback/delete", e);
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