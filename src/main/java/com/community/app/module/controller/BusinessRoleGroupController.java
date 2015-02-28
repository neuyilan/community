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

import com.community.app.module.bean.BusinessRoleGroup;
import com.community.app.module.service.BusinessRoleGroupService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessRoleGroupQuery;


@Controller
@RequestMapping("/business/businessRoleGroup")
public class BusinessRoleGroupController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessRoleGroupController.class);
	@Autowired
	private BusinessRoleGroupService businessRoleGroupService;
	
	private final String LIST_ACTION = "redirect:/business/businessRoleGroup/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessRoleGroup管理页时发生错误：/business/businessRoleGroup/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessRoleGroup/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessRoleGroupQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessRoleGroupService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessRoleGroup businessRoleGroup = (BusinessRoleGroup) baseBean.getList().get(i);
				result.append("{")
			    .append("\"groupId\":\"").append(businessRoleGroup.getGroupId()).append("\"").append(",")
			    .append("\"groupName\":\"").append(businessRoleGroup.getGroupName()).append("\"").append(",")
			    .append("\"groupDesc\":\"").append(businessRoleGroup.getGroupDesc()).append("\"")
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
			GSLogger.error("显示businessRoleGroup列表时发生错误：/business/businessRoleGroup/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessRoleGroupQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessRoleGroup新增页时发生错误：/business/businessRoleGroup/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessRoleGroup/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessRoleGroup
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessRoleGroupQuery query) {
		BusinessRoleGroup businessRoleGroup = new BusinessRoleGroup();
		String json = "";
		try{
		    businessRoleGroup.setGroupName(query.getGroupName());
		    businessRoleGroup.setGroupDesc(query.getGroupDesc());
			businessRoleGroupService.save(businessRoleGroup);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessRoleGroup信息时发生错误：/business/businessRoleGroup/save", e);
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
	public ModelAndView modify(BusinessRoleGroupQuery query) {	
		BusinessRoleGroup businessRoleGroup=new BusinessRoleGroup();
		
		try{
			businessRoleGroup = businessRoleGroupService.findById(query.getGroupId());
		}catch(Exception e){
			GSLogger.error("进入businessRoleGroup修改页时发生错误：/business/businessRoleGroup/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessRoleGroup/modify");
		mav.addObject("businessRoleGroup", businessRoleGroup);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessRoleGroupQuery query) {
		BusinessRoleGroup businessRoleGroup = null;
		String json = "";
		try{
		    businessRoleGroup = businessRoleGroupService.findById(query.getGroupId());
		    businessRoleGroup.setGroupName(query.getGroupName());
		    businessRoleGroup.setGroupDesc(query.getGroupDesc());
			businessRoleGroupService.update(businessRoleGroup);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessRoleGroup信息时发生错误：/business/businessRoleGroup/update", e);
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
						businessRoleGroupService.delete(new Integer(ids[i]));
					}
				}else{
					businessRoleGroupService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessRoleGroup时发生错误：/business/businessRoleGroup/delete", e);
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
