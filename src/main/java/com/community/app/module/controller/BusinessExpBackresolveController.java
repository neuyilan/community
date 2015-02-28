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

import com.community.app.module.bean.BusinessExpBackresolve;
import com.community.app.module.service.BusinessExpBackresolveService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessExpBackresolveQuery;


@Controller
@RequestMapping("/business/businessExpBackresolve")
public class BusinessExpBackresolveController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessExpBackresolveController.class);
	@Autowired
	private BusinessExpBackresolveService businessExpBackresolveService;
	
	private final String LIST_ACTION = "redirect:/business/businessExpBackresolve/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessExpBackresolve管理页时发生错误：/business/businessExpBackresolve/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessExpBackresolve/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessExpBackresolveQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessExpBackresolveService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessExpBackresolve businessExpBackresolve = (BusinessExpBackresolve) baseBean.getList().get(i);
				result.append("{")
			    .append("\"resolveId\":\"").append(businessExpBackresolve.getResolveId()).append("\"").append(",")
			    .append("\"expId\":\"").append(businessExpBackresolve.getExpId()).append("\"").append(",")
			    .append("\"resolverId\":\"").append(businessExpBackresolve.getResolverId()).append("\"").append(",")
			    .append("\"resolverName\":\"").append(businessExpBackresolve.getResolverName()).append("\"").append(",")
			    .append("\"resolveTime\":\"").append(businessExpBackresolve.getResolveTime()).append("\"").append(",")
			    .append("\"stateId\":\"").append(businessExpBackresolve.getStateId()).append("\"").append(",")
			    .append("\"state\":\"").append(businessExpBackresolve.getState()).append("\"").append(",")
			    .append("\"resolveMemo\":\"").append(businessExpBackresolve.getResolveMemo()).append("\"").append(",")
			    .append("\"type\":\"").append(businessExpBackresolve.getType()).append("\"").append(",")
			    .append("\"videoTime\":\"").append(businessExpBackresolve.getVideoTime()).append("\"")
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
			GSLogger.error("显示businessExpBackresolve列表时发生错误：/business/businessExpBackresolve/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessExpBackresolveQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessExpBackresolve新增页时发生错误：/business/businessExpBackresolve/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessExpBackresolve/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessExpBackresolve
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessExpBackresolveQuery query) {
		BusinessExpBackresolve businessExpBackresolve = new BusinessExpBackresolve();
		String json = "";
		try{
		    businessExpBackresolve.setExpId(query.getExpId());
		    businessExpBackresolve.setResolverId(query.getResolverId());
		    businessExpBackresolve.setResolverName(query.getResolverName());
		    businessExpBackresolve.setResolveTime(query.getResolveTime());
		    businessExpBackresolve.setStateId(query.getStateId());
		    businessExpBackresolve.setState(query.getState());
		    businessExpBackresolve.setResolveMemo(query.getResolveMemo());
		    businessExpBackresolve.setType(query.getType());
		    businessExpBackresolve.setVideoTime(query.getVideoTime());
			businessExpBackresolveService.save(businessExpBackresolve);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessExpBackresolve信息时发生错误：/business/businessExpBackresolve/save", e);
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
	public ModelAndView modify(BusinessExpBackresolveQuery query) {	
		BusinessExpBackresolve businessExpBackresolve=new BusinessExpBackresolve();
		
		try{
			businessExpBackresolve = businessExpBackresolveService.findById(query.getResolveId());
		}catch(Exception e){
			GSLogger.error("进入businessExpBackresolve修改页时发生错误：/business/businessExpBackresolve/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessExpBackresolve/modify");
		mav.addObject("businessExpBackresolve", businessExpBackresolve);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessExpBackresolveQuery query) {
		BusinessExpBackresolve businessExpBackresolve = null;
		String json = "";
		try{
		    businessExpBackresolve = businessExpBackresolveService.findById(query.getResolveId());
		    businessExpBackresolve.setExpId(query.getExpId());
		    businessExpBackresolve.setResolverId(query.getResolverId());
		    businessExpBackresolve.setResolverName(query.getResolverName());
		    businessExpBackresolve.setResolveTime(query.getResolveTime());
		    businessExpBackresolve.setStateId(query.getStateId());
		    businessExpBackresolve.setState(query.getState());
		    businessExpBackresolve.setResolveMemo(query.getResolveMemo());
		    businessExpBackresolve.setType(query.getType());
		    businessExpBackresolve.setVideoTime(query.getVideoTime());
			businessExpBackresolveService.update(businessExpBackresolve);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessExpBackresolve信息时发生错误：/business/businessExpBackresolve/update", e);
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
						businessExpBackresolveService.delete(new Integer(ids[i]));
					}
				}else{
					businessExpBackresolveService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessExpBackresolve时发生错误：/business/businessExpBackresolve/delete", e);
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
