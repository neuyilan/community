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

import com.community.app.module.bean.BusinessSponsor;
import com.community.app.module.service.BusinessSponsorService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessSponsorQuery;


@Controller
@RequestMapping("/business/businessSponsor")
public class BusinessSponsorController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessSponsorController.class);
	@Autowired
	private BusinessSponsorService businessSponsorService;
	
	private final String LIST_ACTION = "redirect:/business/businessSponsor/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessSponsor管理页时发生错误：/business/businessSponsor/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessSponsor/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessSponsorQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessSponsorService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessSponsor businessSponsor = (BusinessSponsor) baseBean.getList().get(i);
				result.append("{")
			    .append("\"sponsorId\":\"").append(businessSponsor.getSponsorId()).append("\"").append(",")
			    .append("\"userId\":\"").append(businessSponsor.getUserId()).append("\"").append(",")
			    .append("\"actId\":\"").append(businessSponsor.getActId()).append("\"").append(",")
			    .append("\"sponsorName\":\"").append(businessSponsor.getSponsorName()).append("\"").append(",")
			    .append("\"sponsorPhone\":\"").append(businessSponsor.getSponsorPhone()).append("\"").append(",")
			    .append("\"sponsorContent\":\"").append(businessSponsor.getSponsorContent()).append("\"").append(",")
			    .append("\"creatTime\":\"").append(businessSponsor.getCreatTime()).append("\"").append(",")
			    .append("\"flag\":\"").append(businessSponsor.getFlag()).append("\"")
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
			GSLogger.error("显示businessSponsor列表时发生错误：/business/businessSponsor/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessSponsorQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessSponsor新增页时发生错误：/business/businessSponsor/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessSponsor/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessSponsor
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessSponsorQuery query) {
		BusinessSponsor businessSponsor = new BusinessSponsor();
		String json = "";
		try{
		    businessSponsor.setUserId(query.getUserId());
		    businessSponsor.setActId(query.getActId());
		    businessSponsor.setSponsorName(query.getSponsorName());
		    businessSponsor.setSponsorPhone(query.getSponsorPhone());
		    businessSponsor.setSponsorContent(query.getSponsorContent());
		    businessSponsor.setCreatTime(query.getCreatTime());
		    businessSponsor.setFlag(query.getFlag());
			businessSponsorService.save(businessSponsor);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessSponsor信息时发生错误：/business/businessSponsor/save", e);
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
	public ModelAndView modify(BusinessSponsorQuery query) {	
		BusinessSponsor businessSponsor=new BusinessSponsor();
		
		try{
			businessSponsor = businessSponsorService.findById(query.getSponsorId());
		}catch(Exception e){
			GSLogger.error("进入businessSponsor修改页时发生错误：/business/businessSponsor/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessSponsor/modify");
		mav.addObject("businessSponsor", businessSponsor);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessSponsorQuery query) {
		BusinessSponsor businessSponsor = null;
		String json = "";
		try{
		    businessSponsor = businessSponsorService.findById(query.getSponsorId());
		    businessSponsor.setUserId(query.getUserId());
		    businessSponsor.setActId(query.getActId());
		    businessSponsor.setSponsorName(query.getSponsorName());
		    businessSponsor.setSponsorPhone(query.getSponsorPhone());
		    businessSponsor.setSponsorContent(query.getSponsorContent());
		    businessSponsor.setCreatTime(query.getCreatTime());
		    businessSponsor.setFlag(query.getFlag());
			businessSponsorService.update(businessSponsor);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessSponsor信息时发生错误：/business/businessSponsor/update", e);
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
						businessSponsorService.delete(new Integer(ids[i]));
					}
				}else{
					businessSponsorService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessSponsor时发生错误：/business/businessSponsor/delete", e);
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
