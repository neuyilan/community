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
import com.community.app.module.vo.BaseBean;

import com.community.app.module.bean.BusinessBreakSelect;
import com.community.app.module.service.BusinessBreakSelectService;
import com.community.app.module.vo.BusinessBreakSelectQuery;

@Controller
@RequestMapping("/business/businessBreakSelect")
public class BusinessBreakSelectController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessBreakSelectController.class);
	@Autowired
	private BusinessBreakSelectService businessBreakSelectService;
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessBreakSelect管理页时发生错误：/business/businessBreakSelect/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessBreakSelect/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessBreakSelectQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessBreakSelectService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessBreakSelect businessBreakSelect = (BusinessBreakSelect) baseBean.getList().get(i);
				result.append("{")
			    .append("\"selectId\":\"").append(businessBreakSelect.getSelectId()).append("\"").append(",")
			    .append("\"breakId\":\"").append(businessBreakSelect.getBreakId()).append("\"").append(",")
			    .append("\"selectorId\":\"").append(businessBreakSelect.getSelectorId()).append("\"").append(",")
			    .append("\"selectTime\":\"").append(businessBreakSelect.getSelectTime()).append("\"").append(",")
			    .append("\"selectorName\":\"").append(businessBreakSelect.getSelectorName()).append("\"").append(",")
			    .append("\"comId\":\"").append(businessBreakSelect.getComId()).append("\"").append(",")
			    .append("\"comName\":\"").append(businessBreakSelect.getComName()).append("\"").append(",")
			    .append("\"isSelected\":\"").append(businessBreakSelect.getIsSelected()).append("\"")
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
			GSLogger.error("显示businessBreakSelect列表时发生错误：/business/businessBreakSelect/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessBreakSelectQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessBreakSelect新增页时发生错误：/business/businessBreakSelect/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessBreakSelect/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessBreakSelect
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessBreakSelectQuery query) {
		BusinessBreakSelect businessBreakSelect = new BusinessBreakSelect();
		String json = "";
		try{
		    businessBreakSelect.setBreakId(query.getBreakId());
		    businessBreakSelect.setSelectorId(query.getSelectorId());
		    businessBreakSelect.setSelectTime(query.getSelectTime());
		    businessBreakSelect.setSelectorName(query.getSelectorName());
		    businessBreakSelect.setComId(query.getComId());
		    businessBreakSelect.setComName(query.getComName());
		    businessBreakSelect.setIsSelected(query.getIsSelected());
	        //Timestamp  ts=new Timestamp(new Date().getTime());
	        //businessBreakSelect.setCreateTime(ts);
	        //businessBreakSelect.setEditTime(ts);
			businessBreakSelectService.save(businessBreakSelect);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessBreakSelect信息时发生错误：/business/businessBreakSelect/save", e);
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
	public ModelAndView modify(BusinessBreakSelectQuery query) {	
		BusinessBreakSelect businessBreakSelect=new BusinessBreakSelect();
		
		try{
			businessBreakSelect = businessBreakSelectService.findById(query.getSelectId());
		}catch(Exception e){
			GSLogger.error("进入businessBreakSelect修改页时发生错误：/business/businessBreakSelect/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessBreakSelect/modify");
		mav.addObject("businessBreakSelect", businessBreakSelect);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessBreakSelectQuery query) {
		BusinessBreakSelect businessBreakSelect = null;
		String json = "";
		try{
		    businessBreakSelect = businessBreakSelectService.findById(query.getSelectId());
		    businessBreakSelect.setBreakId(query.getBreakId());
		    businessBreakSelect.setSelectorId(query.getSelectorId());
		    businessBreakSelect.setSelectTime(query.getSelectTime());
		    businessBreakSelect.setSelectorName(query.getSelectorName());
		    businessBreakSelect.setComId(query.getComId());
		    businessBreakSelect.setComName(query.getComName());
		    businessBreakSelect.setIsSelected(query.getIsSelected());
	        //Timestamp  ts=new Timestamp(new Date().getTime());
	        //businessBreakSelect.setEditTime(ts);
			businessBreakSelectService.update(businessBreakSelect);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessBreakSelect信息时发生错误：/business/businessBreakSelect/update", e);
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
						businessBreakSelectService.delete(new Integer(ids[i]));
					}
				}else{
					businessBreakSelectService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessBreakSelect时发生错误：/business/businessBreakSelect/delete", e);
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