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

import com.community.app.module.bean.BusinessTel;
import com.community.app.module.service.BusinessTelService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessTelQuery;


@Controller
@RequestMapping("/business/businessTel")
public class BusinessTelController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessTelController.class);
	@Autowired
	private BusinessTelService businessTelService;
	
	private final String LIST_ACTION = "redirect:/business/businessTel/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessTel管理页时发生错误：/business/businessTel/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessTel/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessTelQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessTelService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessTel businessTel = (BusinessTel) baseBean.getList().get(i);
				result.append("{")
			    .append("\"telId\":\"").append(businessTel.getTelId()).append("\"").append(",")
			    .append("\"groupId\":\"").append(businessTel.getGroupId()).append("\"").append(",")
			    .append("\"tel\":\"").append(businessTel.getTel()).append("\"").append(",")
			    .append("\"telName\":\"").append(businessTel.getTelName()).append("\"")
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
			GSLogger.error("显示businessTel列表时发生错误：/business/businessTel/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessTelQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessTel新增页时发生错误：/business/businessTel/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessTel/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessTel
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessTelQuery query) {
		BusinessTel businessTel = new BusinessTel();
		String json = "";
		try{
		    businessTel.setGroupId(query.getGroupId());
		    businessTel.setTel(query.getTel());
		    businessTel.setTelName(query.getTelName());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        //businessTel.setCreateTime(ts);
	        //businessTel.setEditTime(ts);
			businessTelService.save(businessTel);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessTel信息时发生错误：/business/businessTel/save", e);
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
	public ModelAndView modify(BusinessTelQuery query) {	
		BusinessTel businessTel=new BusinessTel();
		
		try{
			businessTel = businessTelService.findById(query.getTelId());
		}catch(Exception e){
			GSLogger.error("进入businessTel修改页时发生错误：/business/businessTel/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessTel/modify");
		mav.addObject("businessTel", businessTel);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessTelQuery query) {
		BusinessTel businessTel = null;
		String json = "";
		try{
		    businessTel = businessTelService.findById(query.getTelId());
		    businessTel.setGroupId(query.getGroupId());
		    businessTel.setTel(query.getTel());
		    businessTel.setTelName(query.getTelName());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        //businessTel.setEditTime(ts);
			businessTelService.update(businessTel);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessTel信息时发生错误：/business/businessTel/update", e);
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
						businessTelService.delete(new Integer(ids[i]));
					}
				}else{
					businessTelService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessTel时发生错误：/business/businessTel/delete", e);
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
