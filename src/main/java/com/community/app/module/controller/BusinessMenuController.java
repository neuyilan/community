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


import com.community.app.module.bean.BusinessMenu;
import com.community.app.module.service.BusinessMenuService;
import com.community.app.module.vo.BusinessMenuQuery;


@Controller
@RequestMapping("/business/businessMenu")
public class BusinessMenuController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessMenuController.class);
	@Autowired
	private BusinessMenuService businessMenuService;
	
	private final String LIST_ACTION = "redirect:/business/businessMenu/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessMenu管理页时发生错误：/business/businessMenu/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessMenu/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessMenuQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessMenuService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessMenu businessMenu = (BusinessMenu) baseBean.getList().get(i);
				result.append("{")
			    .append("\"menuId\":\"").append(businessMenu.getMenuId()).append("\"").append(",")
			    .append("\"name\":\"").append(businessMenu.getName()).append("\"").append(",")
			    .append("\"url\":\"").append(businessMenu.getUrl()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessMenu.getCreateTime()).append("\"").append(",")
			    .append("\"modifyTime\":\"").append(businessMenu.getModifyTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessMenu.getEditor()).append("\"").append(",")
			    .append("\"parentId\":\"").append(businessMenu.getParentId()).append("\"").append(",")
			    .append("\"ord\":\"").append(businessMenu.getOrd()).append("\"").append(",")
			    .append("\"leaf\":\"").append(businessMenu.getLeaf()).append("\"").append(",")
			    .append("\"code\":\"").append(businessMenu.getCode()).append("\"").append(",")
			    .append("\"selectedIcon\":\"").append(businessMenu.getSelectedIcon()).append("\"").append(",")
			    .append("\"unSelectedIcon\":\"").append(businessMenu.getUnSelectedIcon()).append("\"")
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
			GSLogger.error("显示businessMenu列表时发生错误：/business/businessMenu/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessMenuQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessMenu新增页时发生错误：/business/businessMenu/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessMenu/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessMenu
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessMenuQuery query) {
		BusinessMenu businessMenu = new BusinessMenu();
		String json = "";
		try{
		    businessMenu.setName(query.getName());
		    businessMenu.setUrl(query.getUrl());
		    businessMenu.setCreateTime(query.getCreateTime());
		    businessMenu.setModifyTime(query.getModifyTime());
		    businessMenu.setEditor(query.getEditor());
		    businessMenu.setParentId(query.getParentId());
		    businessMenu.setOrd(query.getOrd());
		    businessMenu.setLeaf(query.getLeaf());
		    businessMenu.setCode(query.getCode());
		    businessMenu.setSelectedIcon(query.getSelectedIcon());
		    businessMenu.setUnSelectedIcon(query.getUnSelectedIcon());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        businessMenu.setCreateTime(ts);
	        //businessMenu.setEditTime(ts);
			businessMenuService.save(businessMenu);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessMenu信息时发生错误：/business/businessMenu/save", e);
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
	public ModelAndView modify(BusinessMenuQuery query) {	
		BusinessMenu businessMenu=new BusinessMenu();
		
		try{
			businessMenu = businessMenuService.findById(query.getMenuId());
		}catch(Exception e){
			GSLogger.error("进入businessMenu修改页时发生错误：/business/businessMenu/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessMenu/modify");
		mav.addObject("businessMenu", businessMenu);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessMenuQuery query) {
		BusinessMenu businessMenu = null;
		String json = "";
		try{
		    businessMenu = businessMenuService.findById(query.getMenuId());
		    businessMenu.setName(query.getName());
		    businessMenu.setUrl(query.getUrl());
		    businessMenu.setCreateTime(query.getCreateTime());
		    businessMenu.setModifyTime(query.getModifyTime());
		    businessMenu.setEditor(query.getEditor());
		    businessMenu.setParentId(query.getParentId());
		    businessMenu.setOrd(query.getOrd());
		    businessMenu.setLeaf(query.getLeaf());
		    businessMenu.setCode(query.getCode());
		    businessMenu.setSelectedIcon(query.getSelectedIcon());
		    businessMenu.setUnSelectedIcon(query.getUnSelectedIcon());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        //businessMenu.setEditTime(ts);
			businessMenuService.update(businessMenu);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessMenu信息时发生错误：/business/businessMenu/update", e);
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
						businessMenuService.delete(new Integer(ids[i]));
					}
				}else{
					businessMenuService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessMenu时发生错误：/business/businessMenu/delete", e);
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
