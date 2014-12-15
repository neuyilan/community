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


import com.community.app.module.bean.BusinessNewsSupport;
import com.community.app.module.service.BusinessNewsSupportService;
import com.community.app.module.vo.BusinessNewsSupportQuery;


@Controller
@RequestMapping("/business/businessNewsSupport")
public class BusinessNewsSupportController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessNewsSupportController.class);
	@Autowired
	private BusinessNewsSupportService businessNewsSupportService;
	
	private final String LIST_ACTION = "redirect:/business/businessNewsSupport/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessNewsSupport管理页时发生错误：/business/businessNewsSupport/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessNewsSupport/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessNewsSupportQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessNewsSupportService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessNewsSupport businessNewsSupport = (BusinessNewsSupport) baseBean.getList().get(i);
				result.append("{")
			    .append("\"newsId\":\"").append(businessNewsSupport.getNewsId()).append("\"").append(",")
			    .append("\"userId\":\"").append(businessNewsSupport.getUserId()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessNewsSupport.getCreateTime()).append("\"")
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
			GSLogger.error("显示businessNewsSupport列表时发生错误：/business/businessNewsSupport/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessNewsSupportQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessNewsSupport新增页时发生错误：/business/businessNewsSupport/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessNewsSupport/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessNewsSupport
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessNewsSupportQuery query) {
		BusinessNewsSupport businessNewsSupport = new BusinessNewsSupport();
		String json = "";
		try{
		    businessNewsSupport.setCreateTime(query.getCreateTime());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        businessNewsSupport.setCreateTime(ts);
	        //businessNewsSupport.setEditTime(ts);
			businessNewsSupportService.save(businessNewsSupport);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessNewsSupport信息时发生错误：/business/businessNewsSupport/save", e);
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
	public ModelAndView modify(BusinessNewsSupportQuery query) {	
		BusinessNewsSupport businessNewsSupport=new BusinessNewsSupport();
		
		try{
			businessNewsSupport = businessNewsSupportService.findById(query.getNewsId());
			businessNewsSupport = businessNewsSupportService.findById(query.getUserId());
		}catch(Exception e){
			GSLogger.error("进入businessNewsSupport修改页时发生错误：/business/businessNewsSupport/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessNewsSupport/modify");
		mav.addObject("businessNewsSupport", businessNewsSupport);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessNewsSupportQuery query) {
		BusinessNewsSupport businessNewsSupport = null;
		String json = "";
		try{
		    businessNewsSupport = businessNewsSupportService.findById(query.getNewsId());
		    businessNewsSupport = businessNewsSupportService.findById(query.getUserId());
		    businessNewsSupport.setCreateTime(query.getCreateTime());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        //businessNewsSupport.setEditTime(ts);
			businessNewsSupportService.update(businessNewsSupport);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessNewsSupport信息时发生错误：/business/businessNewsSupport/update", e);
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
						businessNewsSupportService.delete(new Integer(ids[i]));
					}
				}else{
					businessNewsSupportService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessNewsSupport时发生错误：/business/businessNewsSupport/delete", e);
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
