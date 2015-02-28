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

import com.community.app.module.bean.BusinessChinmedichenacareSupport;
import com.community.app.module.service.BusinessChinmedichenacareSupportService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessChinmedichenacareSupportQuery;


@Controller
@RequestMapping("/business/businessChinmedichenacareSupport")
public class BusinessChinmedichenacareSupportController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessChinmedichenacareSupportController.class);
	@Autowired
	private BusinessChinmedichenacareSupportService businessChinmedichenacareSupportService;
	
	private final String LIST_ACTION = "redirect:/business/businessChinmedichenacareSupport/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessChinmedichenacareSupport管理页时发生错误：/business/businessChinmedichenacareSupport/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessChinmedichenacareSupport/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessChinmedichenacareSupportQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessChinmedichenacareSupportService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessChinmedichenacareSupport businessChinmedichenacareSupport = (BusinessChinmedichenacareSupport) baseBean.getList().get(i);
				result.append("{")
			    .append("\"cmchId\":\"").append(businessChinmedichenacareSupport.getCmchId()).append("\"").append(",")
			    .append("\"userId\":\"").append(businessChinmedichenacareSupport.getUserId()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessChinmedichenacareSupport.getCreateTime()).append("\"")
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
			GSLogger.error("显示businessChinmedichenacareSupport列表时发生错误：/business/businessChinmedichenacareSupport/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessChinmedichenacareSupportQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessChinmedichenacareSupport新增页时发生错误：/business/businessChinmedichenacareSupport/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessChinmedichenacareSupport/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessChinmedichenacareSupport
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessChinmedichenacareSupportQuery query) {
		BusinessChinmedichenacareSupport businessChinmedichenacareSupport = new BusinessChinmedichenacareSupport();
		String json = "";
		try{
		    businessChinmedichenacareSupport.setCreateTime(query.getCreateTime());
			businessChinmedichenacareSupportService.save(businessChinmedichenacareSupport);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessChinmedichenacareSupport信息时发生错误：/business/businessChinmedichenacareSupport/save", e);
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
	public ModelAndView modify(BusinessChinmedichenacareSupportQuery query) {	
		BusinessChinmedichenacareSupport businessChinmedichenacareSupport=new BusinessChinmedichenacareSupport();
		
		try{
			businessChinmedichenacareSupport = businessChinmedichenacareSupportService.findById(query.getCmchId());
			businessChinmedichenacareSupport = businessChinmedichenacareSupportService.findById(query.getUserId());
		}catch(Exception e){
			GSLogger.error("进入businessChinmedichenacareSupport修改页时发生错误：/business/businessChinmedichenacareSupport/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessChinmedichenacareSupport/modify");
		mav.addObject("businessChinmedichenacareSupport", businessChinmedichenacareSupport);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessChinmedichenacareSupportQuery query) {
		BusinessChinmedichenacareSupport businessChinmedichenacareSupport = null;
		String json = "";
		try{
		    businessChinmedichenacareSupport = businessChinmedichenacareSupportService.findById(query.getCmchId());
		    businessChinmedichenacareSupport = businessChinmedichenacareSupportService.findById(query.getUserId());
		    businessChinmedichenacareSupport.setCreateTime(query.getCreateTime());
			businessChinmedichenacareSupportService.update(businessChinmedichenacareSupport);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessChinmedichenacareSupport信息时发生错误：/business/businessChinmedichenacareSupport/update", e);
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
						businessChinmedichenacareSupportService.delete(new Integer(ids[i]));
					}
				}else{
					businessChinmedichenacareSupportService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessChinmedichenacareSupport时发生错误：/business/businessChinmedichenacareSupport/delete", e);
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
