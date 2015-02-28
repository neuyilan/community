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

import com.community.app.module.bean.BusinessAnnoVisit;
import com.community.app.module.service.BusinessAnnoVisitService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessAnnoVisitQuery;


@Controller
@RequestMapping("/business/businessAnnoVisit")
public class BusinessAnnoVisitController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessAnnoVisitController.class);
	@Autowired
	private BusinessAnnoVisitService businessAnnoVisitService;
	
	private final String LIST_ACTION = "redirect:/business/businessAnnoVisit/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessAnnoVisit管理页时发生错误：/business/businessAnnoVisit/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessAnnoVisit/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessAnnoVisitQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessAnnoVisitService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessAnnoVisit businessAnnoVisit = (BusinessAnnoVisit) baseBean.getList().get(i);
				result.append("{")
			    .append("\"visitId\":\"").append(businessAnnoVisit.getVisitId()).append("\"").append(",")
			    .append("\"annoId\":\"").append(businessAnnoVisit.getAnnoId()).append("\"").append(",")
			    .append("\"userId\":\"").append(businessAnnoVisit.getUserId()).append("\"").append(",")
			    .append("\"userName\":\"").append(businessAnnoVisit.getUserName()).append("\"").append(",")
			    .append("\"viewTime\":\"").append(businessAnnoVisit.getViewTime()).append("\"").append(",")
			    .append("\"userAddress\":\"").append(businessAnnoVisit.getUserAddress()).append("\"")
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
			GSLogger.error("显示businessAnnoVisit列表时发生错误：/business/businessAnnoVisit/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessAnnoVisitQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessAnnoVisit新增页时发生错误：/business/businessAnnoVisit/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessAnnoVisit/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessAnnoVisit
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessAnnoVisitQuery query) {
		BusinessAnnoVisit businessAnnoVisit = new BusinessAnnoVisit();
		String json = "";
		try{
		    businessAnnoVisit.setAnnoId(query.getAnnoId());
		    businessAnnoVisit.setUserId(query.getUserId());
		    businessAnnoVisit.setUserName(query.getUserName());
		    businessAnnoVisit.setViewTime(query.getViewTime());
		    businessAnnoVisit.setUserAddress(query.getUserAddress());
			businessAnnoVisitService.save(businessAnnoVisit);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessAnnoVisit信息时发生错误：/business/businessAnnoVisit/save", e);
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
	public ModelAndView modify(BusinessAnnoVisitQuery query) {	
		BusinessAnnoVisit businessAnnoVisit=new BusinessAnnoVisit();
		
		try{
			businessAnnoVisit = businessAnnoVisitService.findById(query.getVisitId());
		}catch(Exception e){
			GSLogger.error("进入businessAnnoVisit修改页时发生错误：/business/businessAnnoVisit/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessAnnoVisit/modify");
		mav.addObject("businessAnnoVisit", businessAnnoVisit);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessAnnoVisitQuery query) {
		BusinessAnnoVisit businessAnnoVisit = null;
		String json = "";
		try{
		    businessAnnoVisit = businessAnnoVisitService.findById(query.getVisitId());
		    businessAnnoVisit.setAnnoId(query.getAnnoId());
		    businessAnnoVisit.setUserId(query.getUserId());
		    businessAnnoVisit.setUserName(query.getUserName());
		    businessAnnoVisit.setViewTime(query.getViewTime());
		    businessAnnoVisit.setUserAddress(query.getUserAddress());
			businessAnnoVisitService.update(businessAnnoVisit);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessAnnoVisit信息时发生错误：/business/businessAnnoVisit/update", e);
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
						businessAnnoVisitService.delete(new Integer(ids[i]));
					}
				}else{
					businessAnnoVisitService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessAnnoVisit时发生错误：/business/businessAnnoVisit/delete", e);
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
