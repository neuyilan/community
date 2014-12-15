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


import com.community.app.module.bean.BusinessHealthydietSupport;
import com.community.app.module.service.BusinessHealthydietSupportService;
import com.community.app.module.vo.BusinessHealthydietSupportQuery;


@Controller
@RequestMapping("/business/businessHealthydietSupport")
public class BusinessHealthydietSupportController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessHealthydietSupportController.class);
	@Autowired
	private BusinessHealthydietSupportService businessHealthydietSupportService;
	
	private final String LIST_ACTION = "redirect:/business/businessHealthydietSupport/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessHealthydietSupport管理页时发生错误：/business/businessHealthydietSupport/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessHealthydietSupport/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessHealthydietSupportQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessHealthydietSupportService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessHealthydietSupport businessHealthydietSupport = (BusinessHealthydietSupport) baseBean.getList().get(i);
				result.append("{")
			    .append("\"healId\":\"").append(businessHealthydietSupport.getHealId()).append("\"").append(",")
			    .append("\"userId\":\"").append(businessHealthydietSupport.getUserId()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessHealthydietSupport.getCreateTime()).append("\"")
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
			GSLogger.error("显示businessHealthydietSupport列表时发生错误：/business/businessHealthydietSupport/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessHealthydietSupportQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessHealthydietSupport新增页时发生错误：/business/businessHealthydietSupport/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessHealthydietSupport/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessHealthydietSupport
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessHealthydietSupportQuery query) {
		BusinessHealthydietSupport businessHealthydietSupport = new BusinessHealthydietSupport();
		String json = "";
		try{
		    businessHealthydietSupport.setCreateTime(query.getCreateTime());
			businessHealthydietSupportService.save(businessHealthydietSupport);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessHealthydietSupport信息时发生错误：/business/businessHealthydietSupport/save", e);
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
	public ModelAndView modify(BusinessHealthydietSupportQuery query) {	
		BusinessHealthydietSupport businessHealthydietSupport=new BusinessHealthydietSupport();
		
		try{
			businessHealthydietSupport = businessHealthydietSupportService.findById(query.getHealId());
			businessHealthydietSupport = businessHealthydietSupportService.findById(query.getUserId());
		}catch(Exception e){
			GSLogger.error("进入businessHealthydietSupport修改页时发生错误：/business/businessHealthydietSupport/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessHealthydietSupport/modify");
		mav.addObject("businessHealthydietSupport", businessHealthydietSupport);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessHealthydietSupportQuery query) {
		BusinessHealthydietSupport businessHealthydietSupport = null;
		String json = "";
		try{
		    businessHealthydietSupport = businessHealthydietSupportService.findById(query.getHealId());
		    businessHealthydietSupport = businessHealthydietSupportService.findById(query.getUserId());
		    businessHealthydietSupport.setCreateTime(query.getCreateTime());
			businessHealthydietSupportService.update(businessHealthydietSupport);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessHealthydietSupport信息时发生错误：/business/businessHealthydietSupport/update", e);
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
						businessHealthydietSupportService.delete(new Integer(ids[i]));
					}
				}else{
					businessHealthydietSupportService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessHealthydietSupport时发生错误：/business/businessHealthydietSupport/delete", e);
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
