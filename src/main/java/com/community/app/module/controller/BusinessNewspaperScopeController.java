package com.community.app.module.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.community.app.module.bean.BusinessNewspaperScope;
import com.community.app.module.service.BusinessNewspaperScopeService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessNewspaperScopeQuery;


@Controller
@RequestMapping("/business/businessNewspaperScope")
public class BusinessNewspaperScopeController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessNewspaperScopeController.class);
	@Autowired
	private BusinessNewspaperScopeService businessNewspaperScopeService;
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessNewspaperScope管理页时发生错误：/business/businessNewspaperScope/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessNewspaperScope/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessNewspaperScopeQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessNewspaperScopeService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessNewspaperScope businessNewspaperScope = (BusinessNewspaperScope) baseBean.getList().get(i);
				result.append("{")
			    .append("\"scopeId\":\"").append(businessNewspaperScope.getScopeId()).append("\"").append(",")
			    .append("\"newspaperId\":\"").append(businessNewspaperScope.getNewspaperId()).append("\"").append(",")
			    .append("\"comId\":\"").append(businessNewspaperScope.getComId()).append("\"").append(",")
			    .append("\"comName\":\"").append(businessNewspaperScope.getComName()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessNewspaperScope.getCreateTime()).append("\"")
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
			GSLogger.error("显示businessNewspaperScope列表时发生错误：/business/businessNewspaperScope/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessNewspaperScopeQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessNewspaperScope新增页时发生错误：/business/businessNewspaperScope/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessNewspaperScope/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessNewspaperScope
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessNewspaperScopeQuery query) {
		BusinessNewspaperScope businessNewspaperScope = new BusinessNewspaperScope();
		String json = "";
		try{
		    businessNewspaperScope.setNewspaperId(query.getNewspaperId());
		    businessNewspaperScope.setComId(query.getComId());
		    businessNewspaperScope.setComName(query.getComName());
		    businessNewspaperScope.setCreateTime(query.getCreateTime());
			businessNewspaperScopeService.save(businessNewspaperScope);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessNewspaperScope信息时发生错误：/business/businessNewspaperScope/save", e);
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
	public ModelAndView modify(BusinessNewspaperScopeQuery query) {	
		BusinessNewspaperScope businessNewspaperScope=new BusinessNewspaperScope();
		
		try{
			businessNewspaperScope = businessNewspaperScopeService.findById(query.getScopeId());
		}catch(Exception e){
			GSLogger.error("进入businessNewspaperScope修改页时发生错误：/business/businessNewspaperScope/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessNewspaperScope/modify");
		mav.addObject("businessNewspaperScope", businessNewspaperScope);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessNewspaperScopeQuery query) {
		BusinessNewspaperScope businessNewspaperScope = null;
		String json = "";
		try{
		    businessNewspaperScope = businessNewspaperScopeService.findById(query.getScopeId());
		    businessNewspaperScope.setNewspaperId(query.getNewspaperId());
		    businessNewspaperScope.setComId(query.getComId());
		    businessNewspaperScope.setComName(query.getComName());
		    businessNewspaperScope.setCreateTime(query.getCreateTime());
			businessNewspaperScopeService.update(businessNewspaperScope);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessNewspaperScope信息时发生错误：/business/businessNewspaperScope/update", e);
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
						businessNewspaperScopeService.delete(new Integer(ids[i]));
					}
				}else{
					businessNewspaperScopeService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessNewspaperScope时发生错误：/business/businessNewspaperScope/delete", e);
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