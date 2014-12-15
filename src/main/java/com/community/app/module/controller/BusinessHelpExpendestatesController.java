package com.community.app.module.controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.community.app.module.bean.BusinessHelpExpendestates;
import com.community.app.module.service.BusinessHelpExpendestatesService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessHelpExpendestatesQuery;

@Controller
@RequestMapping("/business/businessHelpExpendestates")
public class BusinessHelpExpendestatesController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessHelpExpendestatesController.class);
	@Autowired
	private BusinessHelpExpendestatesService businessHelpExpendestatesService;
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessHelpExpendestates管理页时发生错误：/business/businessHelpExpendestates/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessHelpExpendestates/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessHelpExpendestatesQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessHelpExpendestatesService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessHelpExpendestates businessHelpExpendestates = (BusinessHelpExpendestates) baseBean.getList().get(i);
				result.append("{")
			    .append("\"expendEstatesId\":\"").append(businessHelpExpendestates.getExpendEstatesId()).append("\"").append(",")
			    .append("\"helpId\":\"").append(businessHelpExpendestates.getHelpId()).append("\"").append(",")
			    .append("\"estateId\":\"").append(businessHelpExpendestates.getEstateId()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessHelpExpendestates.getCreateTime()).append("\"")
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
			GSLogger.error("显示businessHelpExpendestates列表时发生错误：/business/businessHelpExpendestates/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessHelpExpendestatesQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessHelpExpendestates新增页时发生错误：/business/businessHelpExpendestates/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessHelpExpendestates/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessHelpExpendestates
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessHelpExpendestatesQuery query) {
		BusinessHelpExpendestates businessHelpExpendestates = new BusinessHelpExpendestates();
		String json = "";
		try{
		    if(query.getScope() != null) {
				String[] scope = query.getScope().split(",");
				for(int i=0;i<scope.length;i++) {
					businessHelpExpendestates.setHelpId(query.getHelpId());
				    businessHelpExpendestates.setEstateId(Integer.parseInt(scope[i].split(":")[0]));
				    businessHelpExpendestates.setCreateTime(new Timestamp(System.currentTimeMillis()));
					businessHelpExpendestatesService.save(businessHelpExpendestates);
				}
			}
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessHelpExpendestates信息时发生错误：/business/businessHelpExpendestates/save", e);
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
	public ModelAndView modify(BusinessHelpExpendestatesQuery query) {	
		BusinessHelpExpendestates businessHelpExpendestates=new BusinessHelpExpendestates();
		
		try{
			businessHelpExpendestates = businessHelpExpendestatesService.findById(query.getExpendEstatesId());
		}catch(Exception e){
			GSLogger.error("进入businessHelpExpendestates修改页时发生错误：/business/businessHelpExpendestates/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessHelpExpendestates/modify");
		mav.addObject("businessHelpExpendestates", businessHelpExpendestates);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessHelpExpendestatesQuery query) {
		BusinessHelpExpendestates businessHelpExpendestates = null;
		String json = "";
		try{
		    businessHelpExpendestates = businessHelpExpendestatesService.findById(query.getExpendEstatesId());
		    businessHelpExpendestates.setHelpId(query.getHelpId());
		    businessHelpExpendestates.setEstateId(query.getEstateId());
		    businessHelpExpendestates.setCreateTime(query.getCreateTime());
			businessHelpExpendestatesService.update(businessHelpExpendestates);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessHelpExpendestates信息时发生错误：/business/businessHelpExpendestates/update", e);
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
						businessHelpExpendestatesService.delete(new Integer(ids[i]));
					}
				}else{
					businessHelpExpendestatesService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessHelpExpendestates时发生错误：/business/businessHelpExpendestates/delete", e);
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
