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

import com.community.app.module.bean.BusinessUserResource;
import com.community.app.module.service.BusinessUserResourceService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessUserResourceQuery;


@Controller
@RequestMapping("/business/businessUserResource")
public class BusinessUserResourceController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessUserResourceController.class);
	@Autowired
	private BusinessUserResourceService businessUserResourceService;
	
	private final String LIST_ACTION = "redirect:/business/businessUserResource/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessUserResource管理页时发生错误：/business/businessUserResource/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessUserResource/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessUserResourceQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessUserResourceService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessUserResource businessUserResource = (BusinessUserResource) baseBean.getList().get(i);
				result.append("{")
			    .append("\"usreId\":\"").append(businessUserResource.getUsreId()).append("\"").append(",")
			    .append("\"userId\":\"").append(businessUserResource.getUserId()).append("\"").append(",")
			    .append("\"estateId\":\"").append(businessUserResource.getEstateId()).append("\"").append(",")
			    .append("\"buildingId\":\"").append(businessUserResource.getBuildingId()).append("\"").append(",")
			    .append("\"unitId\":\"").append(businessUserResource.getUnitId()).append("\"").append(",")
			    .append("\"estateName\":\"").append(businessUserResource.getEstateName()).append("\"").append(",")
			    .append("\"buildingName\":\"").append(businessUserResource.getBuildingName()).append("\"").append(",")
			    .append("\"unitName\":\"").append(businessUserResource.getUnitName()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessUserResource.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessUserResource.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessUserResource.getEditor()).append("\"")
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
			GSLogger.error("显示businessUserResource列表时发生错误：/business/businessUserResource/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessUserResourceQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessUserResource新增页时发生错误：/business/businessUserResource/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessUserResource/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessUserResource
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessUserResourceQuery query) {
		BusinessUserResource businessUserResource = new BusinessUserResource();
		String json = "";
		try{
		    businessUserResource.setUserId(query.getUserId());
		    businessUserResource.setEstateId(query.getEstateId());
		    businessUserResource.setBuildingId(query.getBuildingId());
		    businessUserResource.setUnitId(query.getUnitId());
		    businessUserResource.setEstateName(query.getEstateName());
		    businessUserResource.setBuildingName(query.getBuildingName());
		    businessUserResource.setUnitName(query.getUnitName());
		    businessUserResource.setCreateTime(query.getCreateTime());
		    businessUserResource.setEditTime(query.getEditTime());
		    businessUserResource.setEditor(query.getEditor());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        businessUserResource.setCreateTime(ts);
	        businessUserResource.setEditTime(ts);
			businessUserResourceService.save(businessUserResource);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessUserResource信息时发生错误：/business/businessUserResource/save", e);
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
	public ModelAndView modify(BusinessUserResourceQuery query) {	
		BusinessUserResource businessUserResource=new BusinessUserResource();
		
		try{
			businessUserResource = businessUserResourceService.findById(query.getUsreId());
		}catch(Exception e){
			GSLogger.error("进入businessUserResource修改页时发生错误：/business/businessUserResource/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessUserResource/modify");
		mav.addObject("businessUserResource", businessUserResource);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessUserResourceQuery query) {
		BusinessUserResource businessUserResource = null;
		String json = "";
		try{
		    businessUserResource = businessUserResourceService.findById(query.getUsreId());
		    businessUserResource.setUserId(query.getUserId());
		    businessUserResource.setEstateId(query.getEstateId());
		    businessUserResource.setBuildingId(query.getBuildingId());
		    businessUserResource.setUnitId(query.getUnitId());
		    businessUserResource.setEstateName(query.getEstateName());
		    businessUserResource.setBuildingName(query.getBuildingName());
		    businessUserResource.setUnitName(query.getUnitName());
		    businessUserResource.setCreateTime(query.getCreateTime());
		    businessUserResource.setEditTime(query.getEditTime());
		    businessUserResource.setEditor(query.getEditor());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        businessUserResource.setEditTime(ts);
			businessUserResourceService.update(businessUserResource);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessUserResource信息时发生错误：/business/businessUserResource/update", e);
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
						businessUserResourceService.delete(new Integer(ids[i]));
					}
				}else{
					businessUserResourceService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessUserResource时发生错误：/business/businessUserResource/delete", e);
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
