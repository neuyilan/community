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


import com.community.app.module.bean.BusinessAnnoScope;
import com.community.app.module.service.BusinessAnnoScopeService;
import com.community.app.module.vo.BusinessAnnoScopeQuery;


@Controller
@RequestMapping("/business/businessAnnoScope")
public class BusinessAnnoScopeController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessAnnoScopeController.class);
	@Autowired
	private BusinessAnnoScopeService businessAnnoScopeService;
	
	private final String LIST_ACTION = "redirect:/business/businessAnnoScope/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessAnnoScope管理页时发生错误：/business/businessAnnoScope/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessAnnoScope/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessAnnoScopeQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessAnnoScopeService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessAnnoScope businessAnnoScope = (BusinessAnnoScope) baseBean.getList().get(i);
				result.append("{")
			    .append("\"scopeId\":\"").append(businessAnnoScope.getScopeId()).append("\"").append(",")
			    .append("\"annoId\":\"").append(businessAnnoScope.getAnnoId()).append("\"").append(",")
			    .append("\"estateId\":\"").append(businessAnnoScope.getEstateId()).append("\"").append(",")
			    .append("\"estateName\":\"").append(businessAnnoScope.getEstateName()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessAnnoScope.getCreateTime()).append("\"")
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
			GSLogger.error("显示businessAnnoScope列表时发生错误：/business/businessAnnoScope/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessAnnoScopeQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessAnnoScope新增页时发生错误：/business/businessAnnoScope/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessAnnoScope/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessAnnoScope
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessAnnoScopeQuery query) {
		BusinessAnnoScope businessAnnoScope = new BusinessAnnoScope();
		String json = "";
		try{
		    businessAnnoScope.setAnnoId(query.getAnnoId());
		    businessAnnoScope.setEstateId(query.getEstateId());
		    businessAnnoScope.setEstateName(query.getEstateName());
		    businessAnnoScope.setCreateTime(query.getCreateTime());
			businessAnnoScopeService.save(businessAnnoScope);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessAnnoScope信息时发生错误：/business/businessAnnoScope/save", e);
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
	public ModelAndView modify(BusinessAnnoScopeQuery query) {	
		BusinessAnnoScope businessAnnoScope=new BusinessAnnoScope();
		
		try{
			businessAnnoScope = businessAnnoScopeService.findById(query.getScopeId());
		}catch(Exception e){
			GSLogger.error("进入businessAnnoScope修改页时发生错误：/business/businessAnnoScope/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessAnnoScope/modify");
		mav.addObject("businessAnnoScope", businessAnnoScope);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessAnnoScopeQuery query) {
		BusinessAnnoScope businessAnnoScope = null;
		String json = "";
		try{
		    businessAnnoScope = businessAnnoScopeService.findById(query.getScopeId());
		    businessAnnoScope.setAnnoId(query.getAnnoId());
		    businessAnnoScope.setEstateId(query.getEstateId());
		    businessAnnoScope.setEstateName(query.getEstateName());
		    businessAnnoScope.setCreateTime(query.getCreateTime());
			businessAnnoScopeService.update(businessAnnoScope);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessAnnoScope信息时发生错误：/business/businessAnnoScope/update", e);
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
						businessAnnoScopeService.delete(new Integer(ids[i]));
					}
				}else{
					businessAnnoScopeService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessAnnoScope时发生错误：/business/businessAnnoScope/delete", e);
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
