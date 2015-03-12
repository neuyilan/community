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


import com.community.app.module.bean.BusinessActivityQnhInformation;
import com.community.app.module.service.BusinessActivityQnhInformationService;
import com.community.app.module.vo.BusinessActivityQnhInformationQuery;


@Controller
@RequestMapping("/business/businessActivityQnhInformation")
public class BusinessActivityQnhInformationController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessActivityQnhInformationController.class);
	@Autowired
	private BusinessActivityQnhInformationService businessActivityQnhInformationService;
	
	private final String LIST_ACTION = "redirect:/business/businessActivityQnhInformation/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessActivityQnhInformation管理页时发生错误：/business/businessActivityQnhInformation/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessActivityQnhInformation/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessActivityQnhInformationQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessActivityQnhInformationService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessActivityQnhInformation businessActivityQnhInformation = (BusinessActivityQnhInformation) baseBean.getList().get(i);
				result.append("{")
			    .append("\"informationId\":\"").append(businessActivityQnhInformation.getInformationId()).append("\"").append(",")
			    .append("\"userId\":\"").append(businessActivityQnhInformation.getUserId()).append("\"").append(",")
			    .append("\"actId\":\"").append(businessActivityQnhInformation.getActId()).append("\"").append(",")
			    .append("\"realname\":\"").append(businessActivityQnhInformation.getRealname()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessActivityQnhInformation.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessActivityQnhInformation.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessActivityQnhInformation.getEditor()).append("\"")
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
			GSLogger.error("显示businessActivityQnhInformation列表时发生错误：/business/businessActivityQnhInformation/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessActivityQnhInformationQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessActivityQnhInformation新增页时发生错误：/business/businessActivityQnhInformation/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessActivityQnhInformation/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessActivityQnhInformation
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessActivityQnhInformationQuery query) {
		BusinessActivityQnhInformation businessActivityQnhInformation = new BusinessActivityQnhInformation();
		String json = "";
		try{
		    businessActivityQnhInformation.setUserId(query.getUserId());
		    businessActivityQnhInformation.setActId(query.getActId());
		    businessActivityQnhInformation.setRealname(query.getRealname());
		    businessActivityQnhInformation.setCreateTime(query.getCreateTime());
		    businessActivityQnhInformation.setEditTime(query.getEditTime());
		    businessActivityQnhInformation.setEditor(query.getEditor());
			businessActivityQnhInformationService.save(businessActivityQnhInformation);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessActivityQnhInformation信息时发生错误：/business/businessActivityQnhInformation/save", e);
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
	public ModelAndView modify(BusinessActivityQnhInformationQuery query) {	
		BusinessActivityQnhInformation businessActivityQnhInformation=new BusinessActivityQnhInformation();
		
		try{
			businessActivityQnhInformation = businessActivityQnhInformationService.findById(query.getInformationId());
		}catch(Exception e){
			GSLogger.error("进入businessActivityQnhInformation修改页时发生错误：/business/businessActivityQnhInformation/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessActivityQnhInformation/modify");
		mav.addObject("businessActivityQnhInformation", businessActivityQnhInformation);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessActivityQnhInformationQuery query) {
		BusinessActivityQnhInformation businessActivityQnhInformation = null;
		String json = "";
		try{
		    businessActivityQnhInformation = businessActivityQnhInformationService.findById(query.getInformationId());
		    businessActivityQnhInformation.setUserId(query.getUserId());
		    businessActivityQnhInformation.setActId(query.getActId());
		    businessActivityQnhInformation.setRealname(query.getRealname());
		    businessActivityQnhInformation.setCreateTime(query.getCreateTime());
		    businessActivityQnhInformation.setEditTime(query.getEditTime());
		    businessActivityQnhInformation.setEditor(query.getEditor());
			businessActivityQnhInformationService.update(businessActivityQnhInformation);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessActivityQnhInformation信息时发生错误：/business/businessActivityQnhInformation/update", e);
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
						businessActivityQnhInformationService.delete(new Integer(ids[i]));
					}
				}else{
					businessActivityQnhInformationService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessActivityQnhInformation时发生错误：/business/businessActivityQnhInformation/delete", e);
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
