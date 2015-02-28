package com.community.app.module.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.community.app.module.bean.BusinessActivityMessagelog;
import com.community.app.module.service.BusinessActivityMessagelogService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessActivityMessagelogQuery;


@Controller
@RequestMapping("/business/businessActivityMessagelog")
public class BusinessActivityMessagelogController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessActivityMessagelogController.class);
	@Autowired
	private BusinessActivityMessagelogService businessActivityMessagelogService;
	
	private final String LIST_ACTION = "redirect:/business/businessActivityMessagelog/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessActivityMessagelog管理页时发生错误：/business/businessActivityMessagelog/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessActivityMessagelog/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessActivityMessagelogQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessActivityMessagelogService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessActivityMessagelog businessActivityMessagelog = (BusinessActivityMessagelog) baseBean.getList().get(i);
				result.append("{")
			    .append("\"recordId\":\"").append(businessActivityMessagelog.getRecordId()).append("\"").append(",")
			    .append("\"messageId\":\"").append(businessActivityMessagelog.getMessageId()).append("\"").append(",")
			    .append("\"userId\":\"").append(businessActivityMessagelog.getUserId()).append("\"").append(",")
			    .append("\"pushTime\":\"").append(businessActivityMessagelog.getPushTime()).append("\"").append(",")
			    .append("\"userName\":\"").append(businessActivityMessagelog.getUserName()).append("\"").append(",")
			    .append("\"pushState\":\"").append(businessActivityMessagelog.getPushState()).append("\"")
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
			GSLogger.error("显示businessActivityMessagelog列表时发生错误：/business/businessActivityMessagelog/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessActivityMessagelogQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessActivityMessagelog新增页时发生错误：/business/businessActivityMessagelog/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessActivityMessagelog/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessActivityMessagelog
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessActivityMessagelogQuery query) {
		BusinessActivityMessagelog businessActivityMessagelog = new BusinessActivityMessagelog();
		String json = "";
		try{
		    businessActivityMessagelog.setMessageId(query.getMessageId());
		    businessActivityMessagelog.setUserId(query.getUserId());
		    businessActivityMessagelog.setPushTime(query.getPushTime());
		    businessActivityMessagelog.setUserName(query.getUserName());
		    businessActivityMessagelog.setPushState(query.getPushState());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        //businessActivityMessagelog.setCreateTime(ts);
	        //businessActivityMessagelog.setEditTime(ts);
			businessActivityMessagelogService.save(businessActivityMessagelog);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessActivityMessagelog信息时发生错误：/business/businessActivityMessagelog/save", e);
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
	public ModelAndView modify(BusinessActivityMessagelogQuery query) {	
		BusinessActivityMessagelog businessActivityMessagelog=new BusinessActivityMessagelog();
		
		try{
			businessActivityMessagelog = businessActivityMessagelogService.findById(query.getRecordId());
		}catch(Exception e){
			GSLogger.error("进入businessActivityMessagelog修改页时发生错误：/business/businessActivityMessagelog/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessActivityMessagelog/modify");
		mav.addObject("businessActivityMessagelog", businessActivityMessagelog);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessActivityMessagelogQuery query) {
		BusinessActivityMessagelog businessActivityMessagelog = null;
		String json = "";
		try{
		    businessActivityMessagelog = businessActivityMessagelogService.findById(query.getRecordId());
		    businessActivityMessagelog.setMessageId(query.getMessageId());
		    businessActivityMessagelog.setUserId(query.getUserId());
		    businessActivityMessagelog.setPushTime(query.getPushTime());
		    businessActivityMessagelog.setUserName(query.getUserName());
		    businessActivityMessagelog.setPushState(query.getPushState());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        //businessActivityMessagelog.setEditTime(ts);
			businessActivityMessagelogService.update(businessActivityMessagelog);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessActivityMessagelog信息时发生错误：/business/businessActivityMessagelog/update", e);
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
						businessActivityMessagelogService.delete(new Integer(ids[i]));
					}
				}else{
					businessActivityMessagelogService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessActivityMessagelog时发生错误：/business/businessActivityMessagelog/delete", e);
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
