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


import com.community.app.module.bean.BusinessProductSupport;
import com.community.app.module.service.BusinessProductSupportService;
import com.community.app.module.vo.BusinessProductSupportQuery;


@Controller
@RequestMapping("/business/businessProductSupport")
public class BusinessProductSupportController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessProductSupportController.class);
	@Autowired
	private BusinessProductSupportService businessProductSupportService;
	
	private final String LIST_ACTION = "redirect:/business/businessProductSupport/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessProductSupport管理页时发生错误：/business/businessProductSupport/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessProductSupport/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessProductSupportQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessProductSupportService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessProductSupport businessProductSupport = (BusinessProductSupport) baseBean.getList().get(i);
				result.append("{")
			    .append("\"productId\":\"").append(businessProductSupport.getProductId()).append("\"").append(",")
			    .append("\"userId\":\"").append(businessProductSupport.getUserId()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessProductSupport.getCreateTime()).append("\"")
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
			GSLogger.error("显示businessProductSupport列表时发生错误：/business/businessProductSupport/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessProductSupportQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessProductSupport新增页时发生错误：/business/businessProductSupport/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessProductSupport/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessProductSupport
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessProductSupportQuery query) {
		BusinessProductSupport businessProductSupport = new BusinessProductSupport();
		String json = "";
		try{
		    businessProductSupport.setCreateTime(query.getCreateTime());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        businessProductSupport.setCreateTime(ts);
			businessProductSupportService.save(businessProductSupport);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessProductSupport信息时发生错误：/business/businessProductSupport/save", e);
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
	public ModelAndView modify(BusinessProductSupportQuery query) {	
		BusinessProductSupport businessProductSupport=new BusinessProductSupport();
		
		try{
			businessProductSupport = businessProductSupportService.findById(query.getProductId());
			businessProductSupport = businessProductSupportService.findById(query.getUserId());
		}catch(Exception e){
			GSLogger.error("进入businessProductSupport修改页时发生错误：/business/businessProductSupport/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessProductSupport/modify");
		mav.addObject("businessProductSupport", businessProductSupport);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessProductSupportQuery query) {
		BusinessProductSupport businessProductSupport = null;
		String json = "";
		try{
		    businessProductSupport = businessProductSupportService.findById(query.getProductId());
		    businessProductSupport = businessProductSupportService.findById(query.getUserId());
		    businessProductSupport.setCreateTime(query.getCreateTime());
	        Timestamp  ts=new Timestamp(new Date().getTime());
			businessProductSupportService.update(businessProductSupport);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessProductSupport信息时发生错误：/business/businessProductSupport/update", e);
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
						businessProductSupportService.delete(new Integer(ids[i]));
					}
				}else{
					businessProductSupportService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessProductSupport时发生错误：/business/businessProductSupport/delete", e);
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
