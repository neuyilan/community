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

import com.community.app.module.bean.BusinessShopFlow;
import com.community.app.module.service.BusinessShopFlowService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessShopFlowQuery;


@Controller
@RequestMapping("/business/businessShopFlow")
public class BusinessShopFlowController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessShopFlowController.class);
	@Autowired
	private BusinessShopFlowService businessShopFlowService;
	
	private final String LIST_ACTION = "redirect:/business/businessShopFlow/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessShopFlow管理页时发生错误：/business/businessShopFlow/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessShopFlow/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessShopFlowQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessShopFlowService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessShopFlow businessShopFlow = (BusinessShopFlow) baseBean.getList().get(i);
				result.append("{")
			    .append("\"flowId\":\"").append(businessShopFlow.getFlowId()).append("\"").append(",")
			    .append("\"userId\":\"").append(businessShopFlow.getUserId()).append("\"").append(",")
			    .append("\"shopId\":\"").append(businessShopFlow.getShopId()).append("\"").append(",")
			    .append("\"clickTime\":\"").append(businessShopFlow.getClickTime()).append("\"")
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
			GSLogger.error("显示businessShopFlow列表时发生错误：/business/businessShopFlow/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessShopFlowQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessShopFlow新增页时发生错误：/business/businessShopFlow/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessShopFlow/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessShopFlow
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessShopFlowQuery query) {
		BusinessShopFlow businessShopFlow = new BusinessShopFlow();
		String json = "";
		try{
		    businessShopFlow.setUserId(query.getUserId());
		    businessShopFlow.setShopId(query.getShopId());
		    businessShopFlow.setClickTime(query.getClickTime());
			businessShopFlowService.save(businessShopFlow);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessShopFlow信息时发生错误：/business/businessShopFlow/save", e);
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
	public ModelAndView modify(BusinessShopFlowQuery query) {	
		BusinessShopFlow businessShopFlow=new BusinessShopFlow();
		
		try{
			businessShopFlow = businessShopFlowService.findById(query.getFlowId());
		}catch(Exception e){
			GSLogger.error("进入businessShopFlow修改页时发生错误：/business/businessShopFlow/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessShopFlow/modify");
		mav.addObject("businessShopFlow", businessShopFlow);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessShopFlowQuery query) {
		BusinessShopFlow businessShopFlow = null;
		String json = "";
		try{
		    businessShopFlow = businessShopFlowService.findById(query.getFlowId());
		    businessShopFlow.setUserId(query.getUserId());
		    businessShopFlow.setShopId(query.getShopId());
		    businessShopFlow.setClickTime(query.getClickTime());
			businessShopFlowService.update(businessShopFlow);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessShopFlow信息时发生错误：/business/businessShopFlow/update", e);
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
						businessShopFlowService.delete(new Integer(ids[i]));
					}
				}else{
					businessShopFlowService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessShopFlow时发生错误：/business/businessShopFlow/delete", e);
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
