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


import com.community.app.module.bean.BusinessNewsView;
import com.community.app.module.service.BusinessNewsViewService;
import com.community.app.module.vo.BusinessNewsViewQuery;


@Controller
@RequestMapping("/business/businessNewsView")
public class BusinessNewsViewController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessNewsViewController.class);
	@Autowired
	private BusinessNewsViewService businessNewsViewService;
	
	private final String LIST_ACTION = "redirect:/business/businessNewsView/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessNewsView管理页时发生错误：/business/businessNewsView/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessNewsView/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessNewsViewQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessNewsViewService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessNewsView businessNewsView = (BusinessNewsView) baseBean.getList().get(i);
				result.append("{")
			    .append("\"viewId\":\"").append(businessNewsView.getViewId()).append("\"").append(",")
			    .append("\"newsId\":\"").append(businessNewsView.getNewsId()).append("\"").append(",")
			    .append("\"viewerId\":\"").append(businessNewsView.getViewerId()).append("\"").append(",")
			    .append("\"viewTime\":\"").append(businessNewsView.getViewTime()).append("\"").append(",")
			    .append("\"viewerCom\":\"").append(businessNewsView.getViewerCom()).append("\"")
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
			GSLogger.error("显示businessNewsView列表时发生错误：/business/businessNewsView/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessNewsViewQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessNewsView新增页时发生错误：/business/businessNewsView/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessNewsView/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessNewsView
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessNewsViewQuery query) {
		BusinessNewsView businessNewsView = new BusinessNewsView();
		String json = "";
		try{
		    businessNewsView.setNewsId(query.getNewsId());
		    businessNewsView.setViewerId(query.getViewerId());
		    businessNewsView.setViewTime(query.getViewTime());
		    businessNewsView.setViewerCom(query.getViewerCom());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        //businessNewsView.setCreateTime(ts);
	        //businessNewsView.setEditTime(ts);
			businessNewsViewService.save(businessNewsView);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessNewsView信息时发生错误：/business/businessNewsView/save", e);
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
	public ModelAndView modify(BusinessNewsViewQuery query) {	
		BusinessNewsView businessNewsView=new BusinessNewsView();
		
		try{
			businessNewsView = businessNewsViewService.findById(query.getViewId());
		}catch(Exception e){
			GSLogger.error("进入businessNewsView修改页时发生错误：/business/businessNewsView/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessNewsView/modify");
		mav.addObject("businessNewsView", businessNewsView);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessNewsViewQuery query) {
		BusinessNewsView businessNewsView = null;
		String json = "";
		try{
		    businessNewsView = businessNewsViewService.findById(query.getViewId());
		    businessNewsView.setNewsId(query.getNewsId());
		    businessNewsView.setViewerId(query.getViewerId());
		    businessNewsView.setViewTime(query.getViewTime());
		    businessNewsView.setViewerCom(query.getViewerCom());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        //businessNewsView.setEditTime(ts);
			businessNewsViewService.update(businessNewsView);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessNewsView信息时发生错误：/business/businessNewsView/update", e);
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
						businessNewsViewService.delete(new Integer(ids[i]));
					}
				}else{
					businessNewsViewService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessNewsView时发生错误：/business/businessNewsView/delete", e);
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
