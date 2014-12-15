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

import com.community.app.module.bean.BusinessActivityScope;
import com.community.app.module.service.BusinessActivityScopeService;
import com.community.app.module.vo.BusinessActivityScopeQuery;


@Controller
@RequestMapping("/business/businessActivityScope")
public class BusinessActivityScopeController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessActivityScopeController.class);
	@Autowired
	private BusinessActivityScopeService businessActivityScopeService;
	
	private final String LIST_ACTION = "redirect:/business/businessActivityScope/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessActivityScope管理页时发生错误：/business/businessActivityScope/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessActivityScope/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessActivityScopeQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessActivityScopeService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessActivityScope businessActivityScope = (BusinessActivityScope) baseBean.getList().get(i);
				result.append("{")
			    .append("\"scopeId\":\"").append(businessActivityScope.getScopeId()).append("\"").append(",")
			    .append("\"actId\":\"").append(businessActivityScope.getActId()).append("\"").append(",")
			    .append("\"estateId\":\"").append(businessActivityScope.getEstateId()).append("\"").append(",")
			    .append("\"estateName\":\"").append(businessActivityScope.getEstateName()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessActivityScope.getCreateTime()).append("\"")
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
			GSLogger.error("显示businessActivityScope列表时发生错误：/business/businessActivityScope/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessActivityScopeQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessActivityScope新增页时发生错误：/business/businessActivityScope/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessActivityScope/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessActivityScope
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessActivityScopeQuery query) {
		BusinessActivityScope businessActivityScope = new BusinessActivityScope();
		String json = "";
		try{
		    businessActivityScope.setActId(query.getActId());
		    businessActivityScope.setEstateId(query.getEstateId());
		    businessActivityScope.setEstateName(query.getEstateName());
		    businessActivityScope.setCreateTime(query.getCreateTime());
			businessActivityScopeService.save(businessActivityScope);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessActivityScope信息时发生错误：/business/businessActivityScope/save", e);
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
	public ModelAndView modify(BusinessActivityScopeQuery query) {	
		BusinessActivityScope businessActivityScope=new BusinessActivityScope();
		
		try{
			businessActivityScope = businessActivityScopeService.findById(query.getScopeId());
		}catch(Exception e){
			GSLogger.error("进入businessActivityScope修改页时发生错误：/business/businessActivityScope/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessActivityScope/modify");
		mav.addObject("businessActivityScope", businessActivityScope);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessActivityScopeQuery query) {
		BusinessActivityScope businessActivityScope = null;
		String json = "";
		try{
		    businessActivityScope = businessActivityScopeService.findById(query.getScopeId());
		    businessActivityScope.setActId(query.getActId());
		    businessActivityScope.setEstateId(query.getEstateId());
		    businessActivityScope.setEstateName(query.getEstateName());
		    businessActivityScope.setCreateTime(query.getCreateTime());
			businessActivityScopeService.update(businessActivityScope);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessActivityScope信息时发生错误：/business/businessActivityScope/update", e);
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
						businessActivityScopeService.delete(new Integer(ids[i]));
					}
				}else{
					businessActivityScopeService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessActivityScope时发生错误：/business/businessActivityScope/delete", e);
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
