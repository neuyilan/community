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


import com.community.app.module.bean.BusinessBusStation;
import com.community.app.module.service.BusinessBusStationService;
import com.community.app.module.vo.BusinessBusStationQuery;


@Controller
@RequestMapping("/business/businessBusStation")
public class BusinessBusStationController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessBusStationController.class);
	@Autowired
	private BusinessBusStationService businessBusStationService;
	
	private final String LIST_ACTION = "redirect:/business/businessBusStation/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessBusStation管理页时发生错误：/business/businessBusStation/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessBusStation/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessBusStationQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessBusStationService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessBusStation businessBusStation = (BusinessBusStation) baseBean.getList().get(i);
				result.append("{")
			    .append("\"stationId\":\"").append(businessBusStation.getStationId()).append("\"").append(",")
			    .append("\"stationName\":\"").append(businessBusStation.getStationName()).append("\"").append(",")
			    .append("\"estateLongitude\":\"").append(businessBusStation.getEstateLongitude()).append("\"").append(",")
			    .append("\"estateLatitude\":\"").append(businessBusStation.getEstateLatitude()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessBusStation.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessBusStation.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessBusStation.getEditor()).append("\"")
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
			GSLogger.error("显示businessBusStation列表时发生错误：/business/businessBusStation/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessBusStationQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessBusStation新增页时发生错误：/business/businessBusStation/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessBusStation/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessBusStation
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessBusStationQuery query) {
		BusinessBusStation businessBusStation = new BusinessBusStation();
		String json = "";
		try{
		    businessBusStation.setStationName(query.getStationName());
		    businessBusStation.setEstateLongitude(query.getEstateLongitude());
		    businessBusStation.setEstateLatitude(query.getEstateLatitude());
		    businessBusStation.setCreateTime(query.getCreateTime());
		    businessBusStation.setEditTime(query.getEditTime());
		    businessBusStation.setEditor(query.getEditor());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        businessBusStation.setCreateTime(ts);
	        businessBusStation.setEditTime(ts);
			businessBusStationService.save(businessBusStation);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessBusStation信息时发生错误：/business/businessBusStation/save", e);
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
	public ModelAndView modify(BusinessBusStationQuery query) {	
		BusinessBusStation businessBusStation=new BusinessBusStation();
		
		try{
			businessBusStation = businessBusStationService.findById(query.getStationId());
		}catch(Exception e){
			GSLogger.error("进入businessBusStation修改页时发生错误：/business/businessBusStation/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessBusStation/modify");
		mav.addObject("businessBusStation", businessBusStation);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessBusStationQuery query) {
		BusinessBusStation businessBusStation = null;
		String json = "";
		try{
		    businessBusStation = businessBusStationService.findById(query.getStationId());
		    businessBusStation.setStationName(query.getStationName());
		    businessBusStation.setEstateLongitude(query.getEstateLongitude());
		    businessBusStation.setEstateLatitude(query.getEstateLatitude());
		    businessBusStation.setCreateTime(query.getCreateTime());
		    businessBusStation.setEditTime(query.getEditTime());
		    businessBusStation.setEditor(query.getEditor());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        businessBusStation.setEditTime(ts);
			businessBusStationService.update(businessBusStation);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessBusStation信息时发生错误：/business/businessBusStation/update", e);
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
						businessBusStationService.delete(new Integer(ids[i]));
					}
				}else{
					businessBusStationService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessBusStation时发生错误：/business/businessBusStation/delete", e);
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
