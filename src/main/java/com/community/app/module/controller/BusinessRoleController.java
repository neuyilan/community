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

import com.community.app.module.bean.BusinessRole;
import com.community.app.module.service.BusinessRoleService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessRoleQuery;


@Controller
@RequestMapping("/business/businessRole")
public class BusinessRoleController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessRoleController.class);
	@Autowired
	private BusinessRoleService businessRoleService;
	
	private final String LIST_ACTION = "redirect:/business/businessRole/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessRole管理页时发生错误：/business/businessRole/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessRole/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessRoleQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessRoleService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessRole businessRole = (BusinessRole) baseBean.getList().get(i);
				result.append("{")
			    .append("\"roleId\":\"").append(businessRole.getRoleId()).append("\"").append(",")
			    .append("\"groupId\":\"").append(businessRole.getGroupId()).append("\"").append(",")
			    .append("\"roleName\":\"").append(businessRole.getRoleName()).append("\"").append(",")
			    .append("\"roleDesc\":\"").append(businessRole.getRoleDesc()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessRole.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessRole.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessRole.getEditor()).append("\"").append(",")
			    .append("\"isSpecial\":\"").append(businessRole.getIsSpecial()).append("\"")
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
			GSLogger.error("显示businessRole列表时发生错误：/business/businessRole/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessRoleQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessRole新增页时发生错误：/business/businessRole/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessRole/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessRole
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessRoleQuery query) {
		BusinessRole businessRole = new BusinessRole();
		String json = "";
		try{
		    businessRole.setGroupId(query.getGroupId());
		    businessRole.setRoleName(query.getRoleName());
		    businessRole.setRoleDesc(query.getRoleDesc());
		    businessRole.setCreateTime(query.getCreateTime());
		    businessRole.setEditTime(query.getEditTime());
		    businessRole.setEditor(query.getEditor());
		    businessRole.setIsSpecial(query.getIsSpecial());
			businessRoleService.save(businessRole);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessRole信息时发生错误：/business/businessRole/save", e);
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
	public ModelAndView modify(BusinessRoleQuery query) {	
		BusinessRole businessRole=new BusinessRole();
		
		try{
			businessRole = businessRoleService.findById(query.getRoleId());
		}catch(Exception e){
			GSLogger.error("进入businessRole修改页时发生错误：/business/businessRole/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessRole/modify");
		mav.addObject("businessRole", businessRole);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessRoleQuery query) {
		BusinessRole businessRole = null;
		String json = "";
		try{
		    businessRole = businessRoleService.findById(query.getRoleId());
		    businessRole.setGroupId(query.getGroupId());
		    businessRole.setRoleName(query.getRoleName());
		    businessRole.setRoleDesc(query.getRoleDesc());
		    businessRole.setCreateTime(query.getCreateTime());
		    businessRole.setEditTime(query.getEditTime());
		    businessRole.setEditor(query.getEditor());
		    businessRole.setIsSpecial(query.getIsSpecial());
			businessRoleService.update(businessRole);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessRole信息时发生错误：/business/businessRole/update", e);
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
						businessRoleService.delete(new Integer(ids[i]));
					}
				}else{
					businessRoleService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessRole时发生错误：/business/businessRole/delete", e);
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
