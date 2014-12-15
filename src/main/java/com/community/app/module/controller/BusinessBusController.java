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


import com.community.app.module.bean.BusinessBus;
import com.community.app.module.service.BusinessBusService;
import com.community.app.module.vo.BusinessBusQuery;


@Controller
@RequestMapping("/business/businessBus")
public class BusinessBusController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessBusController.class);
	@Autowired
	private BusinessBusService businessBusService;
	
	private final String LIST_ACTION = "redirect:/business/businessBus/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessBus管理页时发生错误：/business/businessBus/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessBus/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessBusQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessBusService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessBus businessBus = (BusinessBus) baseBean.getList().get(i);
				result.append("{")
			    .append("\"busId\":\"").append(businessBus.getBusId()).append("\"").append(",")
			    .append("\"busName\":\"").append(businessBus.getBusName()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessBus.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessBus.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessBus.getEditor()).append("\"").append(",")
			    .append("\"starTime\":\"").append(businessBus.getStarTime()).append("\"").append(",")
			    .append("\"endTime\":\"").append(businessBus.getEndTime()).append("\"").append(",")
			    .append("\"starName\":\"").append(businessBus.getStarName()).append("\"").append(",")
			    .append("\"endName\":\"").append(businessBus.getEndName()).append("\"").append(",")
			    .append("\"count\":\"").append(businessBus.getCount()).append("\"").append(",")
			    .append("\"type\":\"").append(businessBus.getType()).append("\"")
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
			GSLogger.error("显示businessBus列表时发生错误：/business/businessBus/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessBusQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessBus新增页时发生错误：/business/businessBus/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessBus/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessBus
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessBusQuery query) {
		BusinessBus businessBus = new BusinessBus();
		String json = "";
		try{
		    businessBus.setBusName(query.getBusName());
		    businessBus.setCreateTime(query.getCreateTime());
		    businessBus.setEditTime(query.getEditTime());
		    businessBus.setEditor(query.getEditor());
		    businessBus.setStarTime(query.getStarTime());
		    businessBus.setEndTime(query.getEndTime());
		    businessBus.setStarName(query.getStarName());
		    businessBus.setEndName(query.getEndName());
		    businessBus.setCount(query.getCount());
		    businessBus.setType(query.getType());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        businessBus.setCreateTime(ts);
	        businessBus.setEditTime(ts);
			businessBusService.save(businessBus);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessBus信息时发生错误：/business/businessBus/save", e);
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
	public ModelAndView modify(BusinessBusQuery query) {	
		BusinessBus businessBus=new BusinessBus();
		
		try{
			businessBus = businessBusService.findById(query.getBusId());
		}catch(Exception e){
			GSLogger.error("进入businessBus修改页时发生错误：/business/businessBus/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessBus/modify");
		mav.addObject("businessBus", businessBus);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessBusQuery query) {
		BusinessBus businessBus = null;
		String json = "";
		try{
		    businessBus = businessBusService.findById(query.getBusId());
		    businessBus.setBusName(query.getBusName());
		    businessBus.setCreateTime(query.getCreateTime());
		    businessBus.setEditTime(query.getEditTime());
		    businessBus.setEditor(query.getEditor());
		    businessBus.setStarTime(query.getStarTime());
		    businessBus.setEndTime(query.getEndTime());
		    businessBus.setStarName(query.getStarName());
		    businessBus.setEndName(query.getEndName());
		    businessBus.setCount(query.getCount());
		    businessBus.setType(query.getType());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        businessBus.setEditTime(ts);
			businessBusService.update(businessBus);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessBus信息时发生错误：/business/businessBus/update", e);
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
						businessBusService.delete(new Integer(ids[i]));
					}
				}else{
					businessBusService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessBus时发生错误：/business/businessBus/delete", e);
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
