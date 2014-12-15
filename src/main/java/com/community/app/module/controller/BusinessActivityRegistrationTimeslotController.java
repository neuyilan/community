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

import com.community.app.module.bean.BusinessActivityRegistrationTimeslot;
import com.community.app.module.service.BusinessActivityRegistrationTimeslotService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessActivityRegistrationTimeslotQuery;


@Controller
@RequestMapping("/business/businessActivityRegistrationTimeslot")
public class BusinessActivityRegistrationTimeslotController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessActivityRegistrationTimeslotController.class);
	@Autowired
	private BusinessActivityRegistrationTimeslotService businessActivityRegistrationTimeslotService;
		
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessActivityRegistrationTimeslot管理页时发生错误：/business/businessActivityRegistrationTimeslot/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessActivityRegistrationTimeslot/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessActivityRegistrationTimeslotQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessActivityRegistrationTimeslotService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessActivityRegistrationTimeslot businessActivityRegistrationTimeslot = (BusinessActivityRegistrationTimeslot) baseBean.getList().get(i);
				result.append("{")
			    .append("\"timeSlotId\":\"").append(businessActivityRegistrationTimeslot.getTimeSlotId()).append("\"").append(",")
			    .append("\"actId\":\"").append(businessActivityRegistrationTimeslot.getActId()).append("\"").append(",")
			    .append("\"timeSlotName\":\"").append(businessActivityRegistrationTimeslot.getTimeSlotName()).append("\"").append(",")
			    .append("\"number\":\"").append(businessActivityRegistrationTimeslot.getNumber()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessActivityRegistrationTimeslot.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessActivityRegistrationTimeslot.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessActivityRegistrationTimeslot.getEditor()).append("\"")
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
			GSLogger.error("显示businessActivityRegistrationTimeslot列表时发生错误：/business/businessActivityRegistrationTimeslot/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessActivityRegistrationTimeslotQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessActivityRegistrationTimeslot新增页时发生错误：/business/businessActivityRegistrationTimeslot/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessActivityRegistrationTimeslot/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessActivityRegistrationTimeslot
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessActivityRegistrationTimeslotQuery query) {
		BusinessActivityRegistrationTimeslot businessActivityRegistrationTimeslot = new BusinessActivityRegistrationTimeslot();
		String json = "";
		try{
		    businessActivityRegistrationTimeslot.setActId(query.getActId());
		    businessActivityRegistrationTimeslot.setTimeSlotName(query.getTimeSlotName());
		    businessActivityRegistrationTimeslot.setNumber(query.getNumber());
		    businessActivityRegistrationTimeslot.setCreateTime(query.getCreateTime());
		    businessActivityRegistrationTimeslot.setEditTime(query.getEditTime());
		    businessActivityRegistrationTimeslot.setEditor(query.getEditor());
			businessActivityRegistrationTimeslotService.save(businessActivityRegistrationTimeslot);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessActivityRegistrationTimeslot信息时发生错误：/business/businessActivityRegistrationTimeslot/save", e);
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
	public ModelAndView modify(BusinessActivityRegistrationTimeslotQuery query) {	
		BusinessActivityRegistrationTimeslot businessActivityRegistrationTimeslot=new BusinessActivityRegistrationTimeslot();
		
		try{
			businessActivityRegistrationTimeslot = businessActivityRegistrationTimeslotService.findById(query.getTimeSlotId());
		}catch(Exception e){
			GSLogger.error("进入businessActivityRegistrationTimeslot修改页时发生错误：/business/businessActivityRegistrationTimeslot/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessActivityRegistrationTimeslot/modify");
		mav.addObject("businessActivityRegistrationTimeslot", businessActivityRegistrationTimeslot);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessActivityRegistrationTimeslotQuery query) {
		BusinessActivityRegistrationTimeslot businessActivityRegistrationTimeslot = null;
		String json = "";
		try{
		    businessActivityRegistrationTimeslot = businessActivityRegistrationTimeslotService.findById(query.getTimeSlotId());
		    businessActivityRegistrationTimeslot.setActId(query.getActId());
		    businessActivityRegistrationTimeslot.setTimeSlotName(query.getTimeSlotName());
		    businessActivityRegistrationTimeslot.setNumber(query.getNumber());
		    businessActivityRegistrationTimeslot.setCreateTime(query.getCreateTime());
		    businessActivityRegistrationTimeslot.setEditTime(query.getEditTime());
		    businessActivityRegistrationTimeslot.setEditor(query.getEditor());
			businessActivityRegistrationTimeslotService.update(businessActivityRegistrationTimeslot);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessActivityRegistrationTimeslot信息时发生错误：/business/businessActivityRegistrationTimeslot/update", e);
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
						businessActivityRegistrationTimeslotService.delete(new Integer(ids[i]));
					}
				}else{
					businessActivityRegistrationTimeslotService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessActivityRegistrationTimeslot时发生错误：/business/businessActivityRegistrationTimeslot/delete", e);
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
