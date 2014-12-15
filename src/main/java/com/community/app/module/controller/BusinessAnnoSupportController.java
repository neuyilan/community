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


import com.community.app.module.bean.BusinessAnnoSupport;
import com.community.app.module.service.BusinessAnnoSupportService;
import com.community.app.module.vo.BusinessAnnoSupportQuery;


@Controller
@RequestMapping("/business/businessAnnoSupport")
public class BusinessAnnoSupportController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessAnnoSupportController.class);
	@Autowired
	private BusinessAnnoSupportService businessAnnoSupportService;
	
	private final String LIST_ACTION = "redirect:/business/businessAnnoSupport/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessAnnoSupport管理页时发生错误：/business/businessAnnoSupport/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessAnnoSupport/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessAnnoSupportQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessAnnoSupportService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessAnnoSupport businessAnnoSupport = (BusinessAnnoSupport) baseBean.getList().get(i);
				result.append("{")
			    //.append("\"supportId\":\"").append(businessAnnoSupport.getSupportId()).append("\"").append(",")
			    .append("\"annoId\":\"").append(businessAnnoSupport.getAnnoId()).append("\"").append(",")
			    .append("\"userId\":\"").append(businessAnnoSupport.getUserId()).append("\"").append(",")
			    //.append("\"userName\":\"").append(businessAnnoSupport.getUserName()).append("\"").append(",")
			    //.append("\"viewTime\":\"").append(businessAnnoSupport.getViewTime()).append("\"").append(",")
			    //.append("\"userAddress\":\"").append(businessAnnoSupport.getUserAddress()).append("\"")
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
			GSLogger.error("显示businessAnnoSupport列表时发生错误：/business/businessAnnoSupport/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessAnnoSupportQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessAnnoSupport新增页时发生错误：/business/businessAnnoSupport/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessAnnoSupport/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessAnnoSupport
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessAnnoSupportQuery query) {
		BusinessAnnoSupport businessAnnoSupport = new BusinessAnnoSupport();
		String json = "";
		try{
		    businessAnnoSupport.setAnnoId(query.getAnnoId());
		    businessAnnoSupport.setUserId(query.getUserId());
		    //businessAnnoSupport.setUserName(query.getUserName());
		    //businessAnnoSupport.setViewTime(query.getViewTime());
		    //businessAnnoSupport.setUserAddress(query.getUserAddress());
			businessAnnoSupportService.save(businessAnnoSupport);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessAnnoSupport信息时发生错误：/business/businessAnnoSupport/save", e);
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
	public ModelAndView modify(BusinessAnnoSupportQuery query) {	
		BusinessAnnoSupport businessAnnoSupport=new BusinessAnnoSupport();
		
		try{
			businessAnnoSupport = businessAnnoSupportService.findById(query.getAnnoId());
		}catch(Exception e){
			GSLogger.error("进入businessAnnoSupport修改页时发生错误：/business/businessAnnoSupport/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessAnnoSupport/modify");
		mav.addObject("businessAnnoSupport", businessAnnoSupport);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessAnnoSupportQuery query) {
		BusinessAnnoSupport businessAnnoSupport = null;
		String json = "";
		try{
		    businessAnnoSupport = businessAnnoSupportService.findById(query.getAnnoId());
		    businessAnnoSupport.setAnnoId(query.getAnnoId());
		    businessAnnoSupport.setUserId(query.getUserId());
		    /*businessAnnoSupport.setUserName(query.getUserName());
		    businessAnnoSupport.setViewTime(query.getViewTime());
		    businessAnnoSupport.setUserAddress(query.getUserAddress());*/
			businessAnnoSupportService.update(businessAnnoSupport);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessAnnoSupport信息时发生错误：/business/businessAnnoSupport/update", e);
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
						businessAnnoSupportService.delete(new Integer(ids[i]));
					}
				}else{
					businessAnnoSupportService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessAnnoSupport时发生错误：/business/businessAnnoSupport/delete", e);
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
