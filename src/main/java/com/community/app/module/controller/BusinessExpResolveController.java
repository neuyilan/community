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

import com.community.app.module.bean.BusinessExpResolve;
import com.community.app.module.service.BusinessExpResolveService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessExpResolveQuery;


@Controller
@RequestMapping("/business/businessExpResolve")
public class BusinessExpResolveController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessExpResolveController.class);
	@Autowired
	private BusinessExpResolveService businessExpResolveService;
	
	private final String LIST_ACTION = "redirect:/business/businessExpResolve/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessExpResolve管理页时发生错误：/business/businessExpResolve/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessExpResolve/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessExpResolveQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessExpResolveService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessExpResolve businessExpResolve = (BusinessExpResolve) baseBean.getList().get(i);
				result.append("{")
			    .append("\"resolveId\":\"").append(businessExpResolve.getResolveId()).append("\"").append(",")
			    .append("\"expId\":\"").append(businessExpResolve.getExpId()).append("\"").append(",")
			    .append("\"resolverId\":\"").append(businessExpResolve.getResolverId()).append("\"").append(",")
			    .append("\"resolverName\":\"").append(businessExpResolve.getResolverName()).append("\"").append(",")
			    .append("\"resolveTime\":\"").append(businessExpResolve.getResolveTime()).append("\"").append(",")
			    .append("\"stateId\":\"").append(businessExpResolve.getStateId()).append("\"").append(",")
			    .append("\"state\":\"").append(businessExpResolve.getState()).append("\"").append(",")
			    .append("\"resolveMemo\":\"").append(businessExpResolve.getResolveMemo()).append("\"")
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
			GSLogger.error("显示businessExpResolve列表时发生错误：/business/businessExpResolve/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessExpResolveQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessExpResolve新增页时发生错误：/business/businessExpResolve/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessExpResolve/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessExpResolve
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessExpResolveQuery query) {
		BusinessExpResolve businessExpResolve = new BusinessExpResolve();
		String json = "";
		try{
		    businessExpResolve.setExpId(query.getExpId());
		    businessExpResolve.setResolverId(query.getResolverId());
		    businessExpResolve.setResolverName(query.getResolverName());
		    businessExpResolve.setResolveTime(query.getResolveTime());
		    businessExpResolve.setStateId(query.getStateId());
		    businessExpResolve.setState(query.getState());
		    businessExpResolve.setResolveMemo(query.getResolveMemo());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        //businessExpResolve.setCreateTime(ts);
	        //businessExpResolve.setEditTime(ts);
			businessExpResolveService.save(businessExpResolve);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessExpResolve信息时发生错误：/business/businessExpResolve/save", e);
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
	public ModelAndView modify(BusinessExpResolveQuery query) {	
		BusinessExpResolve businessExpResolve=new BusinessExpResolve();
		
		try{
			businessExpResolve = businessExpResolveService.findById(query.getResolveId());
		}catch(Exception e){
			GSLogger.error("进入businessExpResolve修改页时发生错误：/business/businessExpResolve/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessExpResolve/modify");
		mav.addObject("businessExpResolve", businessExpResolve);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessExpResolveQuery query) {
		BusinessExpResolve businessExpResolve = null;
		String json = "";
		try{
		    businessExpResolve = businessExpResolveService.findById(query.getResolveId());
		    businessExpResolve.setExpId(query.getExpId());
		    businessExpResolve.setResolverId(query.getResolverId());
		    businessExpResolve.setResolverName(query.getResolverName());
		    businessExpResolve.setResolveTime(query.getResolveTime());
		    businessExpResolve.setStateId(query.getStateId());
		    businessExpResolve.setState(query.getState());
		    businessExpResolve.setResolveMemo(query.getResolveMemo());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        //businessExpResolve.setEditTime(ts);
			businessExpResolveService.update(businessExpResolve);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessExpResolve信息时发生错误：/business/businessExpResolve/update", e);
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
						businessExpResolveService.delete(new Integer(ids[i]));
					}
				}else{
					businessExpResolveService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessExpResolve时发生错误：/business/businessExpResolve/delete", e);
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
