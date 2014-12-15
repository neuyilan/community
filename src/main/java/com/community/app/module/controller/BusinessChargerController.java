package com.community.app.module.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.community.app.module.service.BusinessChargeAnnoService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.community.app.module.vo.BaseBean;

import com.community.app.module.bean.BusinessCharger;
import com.community.app.module.service.BusinessChargerService;
import com.community.app.module.vo.BusinessChargerQuery;

@Controller
@RequestMapping("/business/businessCharger")
public class BusinessChargerController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessChargerController.class);
	@Autowired
	private BusinessChargerService businessChargerService;
    @Autowired
	private BusinessChargeAnnoService businessChargeAnnoService;
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessCharger管理页时发生错误：/business/businessCharger/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessCharger/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessChargerQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessChargerService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessCharger businessCharger = (BusinessCharger) baseBean.getList().get(i);
				result.append("{")
			    .append("\"payerId\":\"").append(businessCharger.getPayerId()).append("\"").append(",")
			    .append("\"reportId\":\"").append(businessCharger.getReportId()).append("\"").append(",")
			    .append("\"name\":\"").append(businessCharger.getName()).append("\"").append(",")
			    .append("\"cellphone\":\"").append(businessCharger.getCellphone()).append("\"").append(",")
			    .append("\"building\":\"").append(businessCharger.getBuilding()).append("\"").append(",")
			    .append("\"unit\":\"").append(businessCharger.getUnit()).append("\"").append(",")
			    .append("\"floor\":\"").append(businessCharger.getFloor()).append("\"").append(",")
			    .append("\"house\":\"").append(businessCharger.getHouse()).append("\"").append(",")
			    .append("\"publishTime\":\"").append(businessCharger.getPublishTime()).append("\"").append(",")
			    .append("\"isReported\":\"").append(businessCharger.getIsReported()).append("\"").append(",")
			    .append("\"isRead\":\"").append(businessCharger.getIsRead()).append("\"")
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
				e.printStackTrace();
			}
		}catch(Exception e){
			GSLogger.error("显示businessCharger列表时发生错误：/business/businessCharger/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessChargerQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessCharger新增页时发生错误：/business/businessCharger/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessCharger/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessChargerQuery query) {
		BusinessCharger businessCharger = new BusinessCharger();
		String json = "";
		try{
		    businessCharger.setReportId(query.getReportId());
		    businessCharger.setName(query.getName());
		    businessCharger.setCellphone(query.getCellphone());
		    businessCharger.setBuilding(query.getBuilding());
		    businessCharger.setUnit(query.getUnit());
		    businessCharger.setFloor(query.getFloor());
		    businessCharger.setHouse(query.getHouse());
		    businessCharger.setPublishTime(query.getPublishTime());
		    businessCharger.setIsReported(query.getIsReported());
		    businessCharger.setIsRead(query.getIsRead());
		    
			businessChargerService.save(businessCharger);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessCharger信息时发生错误：/business/businessCharger/save", e);
			e.printStackTrace();
		}
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入修改页
	 * @return
	 */
	@RequestMapping(value="modify")
	public ModelAndView modify(BusinessChargerQuery query) {
		BusinessCharger businessCharger=new BusinessCharger();
		
		try{
			businessCharger = businessChargerService.findById(query.getPayerId());
		}catch(Exception e){
			GSLogger.error("进入businessCharger修改页时发生错误：/business/businessCharger/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/chargeAnno/modify");
		mav.addObject("businessCharger", businessCharger);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessChargerQuery query) {
		BusinessCharger businessCharger = null;
		String json = "";
		try{
		    businessCharger = businessChargerService.findById(query.getPayerId());
		    businessCharger.setReportId(query.getReportId());
		    businessCharger.setName(query.getName());
		    businessCharger.setCellphone(query.getCellphone());
		    businessCharger.setBuilding(query.getBuilding());
		    businessCharger.setUnit(query.getUnit());
		    businessCharger.setFloor(query.getFloor());
		    businessCharger.setHouse(query.getHouse());
		    businessCharger.setPublishTime(query.getPublishTime());
		    businessCharger.setIsReported(query.getIsReported());
		    businessCharger.setIsRead(query.getIsRead());
		    
			businessChargerService.update(businessCharger);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessCharger信息时发生错误：/business/businessCharger/update", e);
			e.printStackTrace();
		}
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
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
						businessChargerService.delete(new Integer(ids[i]));
					}
				}else{
					businessChargerService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessCharger时发生错误：/business/businessCharger/delete", e);
			e.printStackTrace();
		}
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}