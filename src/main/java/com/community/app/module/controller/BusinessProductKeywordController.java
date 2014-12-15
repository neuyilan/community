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


import com.community.app.module.bean.BusinessProductKeyword;
import com.community.app.module.service.BusinessProductKeywordService;
import com.community.app.module.vo.BusinessProductKeywordQuery;


@Controller
@RequestMapping("/business/businessProductKeyword")
public class BusinessProductKeywordController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessProductKeywordController.class);
	@Autowired
	private BusinessProductKeywordService businessProductKeywordService;
	
	private final String LIST_ACTION = "redirect:/business/businessProductKeyword/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessProductKeyword管理页时发生错误：/business/businessProductKeyword/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessProductKeyword/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessProductKeywordQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessProductKeywordService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessProductKeyword businessProductKeyword = (BusinessProductKeyword) baseBean.getList().get(i);
				result.append("{")
			    .append("\"keywordId\":\"").append(businessProductKeyword.getKeywordId()).append("\"").append(",")
			    .append("\"keyword\":\"").append(businessProductKeyword.getKeyword()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessProductKeyword.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessProductKeyword.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessProductKeyword.getEditor()).append("\"")
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
			GSLogger.error("显示businessProductKeyword列表时发生错误：/business/businessProductKeyword/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessProductKeywordQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessProductKeyword新增页时发生错误：/business/businessProductKeyword/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessProductKeyword/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessProductKeyword
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessProductKeywordQuery query) {
		BusinessProductKeyword businessProductKeyword = new BusinessProductKeyword();
		String json = "";
		try{
		    businessProductKeyword.setKeyword(query.getKeyword());
		    businessProductKeyword.setCreateTime(query.getCreateTime());
		    businessProductKeyword.setEditTime(query.getEditTime());
		    businessProductKeyword.setEditor(query.getEditor());
			businessProductKeywordService.save(businessProductKeyword);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessProductKeyword信息时发生错误：/business/businessProductKeyword/save", e);
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
	public ModelAndView modify(BusinessProductKeywordQuery query) {	
		BusinessProductKeyword businessProductKeyword=new BusinessProductKeyword();
		
		try{
			businessProductKeyword = businessProductKeywordService.findById(query.getKeywordId());
		}catch(Exception e){
			GSLogger.error("进入businessProductKeyword修改页时发生错误：/business/businessProductKeyword/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessProductKeyword/modify");
		mav.addObject("businessProductKeyword", businessProductKeyword);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessProductKeywordQuery query) {
		BusinessProductKeyword businessProductKeyword = null;
		String json = "";
		try{
		    businessProductKeyword = businessProductKeywordService.findById(query.getKeywordId());
		    businessProductKeyword.setKeyword(query.getKeyword());
		    businessProductKeyword.setCreateTime(query.getCreateTime());
		    businessProductKeyword.setEditTime(query.getEditTime());
		    businessProductKeyword.setEditor(query.getEditor());
			businessProductKeywordService.update(businessProductKeyword);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessProductKeyword信息时发生错误：/business/businessProductKeyword/update", e);
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
						businessProductKeywordService.delete(new Integer(ids[i]));
					}
				}else{
					businessProductKeywordService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessProductKeyword时发生错误：/business/businessProductKeyword/delete", e);
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
