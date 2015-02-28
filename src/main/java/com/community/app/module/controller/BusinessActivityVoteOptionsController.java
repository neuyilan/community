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

import com.community.app.module.bean.BusinessActivityVoteOptions;
import com.community.app.module.service.BusinessActivityVoteOptionsService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessActivityVoteOptionsQuery;

@Controller
@RequestMapping("/business/businessActivityVoteOptions")
public class BusinessActivityVoteOptionsController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessActivityVoteOptionsController.class);
	@Autowired
	private BusinessActivityVoteOptionsService businessActivityVoteOptionsService;
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessActivityVoteOptions管理页时发生错误：/business/businessActivityVoteOptions/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessActivityVoteOptions/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessActivityVoteOptionsQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessActivityVoteOptionsService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessActivityVoteOptions businessActivityVoteOptions = (BusinessActivityVoteOptions) baseBean.getList().get(i);
				result.append("{")
			    .append("\"optionsId\":\"").append(businessActivityVoteOptions.getOptionsId()).append("\"").append(",")
			    .append("\"actId\":\"").append(businessActivityVoteOptions.getActId()).append("\"").append(",")
			    .append("\"content\":\"").append(businessActivityVoteOptions.getContent()).append("\"").append(",")
			    .append("\"image\":\"").append(businessActivityVoteOptions.getImage()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessActivityVoteOptions.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessActivityVoteOptions.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessActivityVoteOptions.getEditor()).append("\"")
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
			GSLogger.error("显示businessActivityVoteOptions列表时发生错误：/business/businessActivityVoteOptions/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessActivityVoteOptionsQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessActivityVoteOptions新增页时发生错误：/business/businessActivityVoteOptions/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessActivityVoteOptions/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessActivityVoteOptions
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessActivityVoteOptionsQuery query) {
		BusinessActivityVoteOptions businessActivityVoteOptions = new BusinessActivityVoteOptions();
		String json = "";
		try{
		    businessActivityVoteOptions.setActId(query.getActId());
		    businessActivityVoteOptions.setContent(query.getContent());
		    businessActivityVoteOptions.setImage(query.getImage());
		    businessActivityVoteOptions.setCreateTime(query.getCreateTime());
		    businessActivityVoteOptions.setEditTime(query.getEditTime());
		    businessActivityVoteOptions.setEditor(query.getEditor());
			businessActivityVoteOptionsService.save(businessActivityVoteOptions);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessActivityVoteOptions信息时发生错误：/business/businessActivityVoteOptions/save", e);
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
	public ModelAndView modify(BusinessActivityVoteOptionsQuery query) {	
		BusinessActivityVoteOptions businessActivityVoteOptions=new BusinessActivityVoteOptions();
		
		try{
			businessActivityVoteOptions = businessActivityVoteOptionsService.findById(query.getOptionsId());
		}catch(Exception e){
			GSLogger.error("进入businessActivityVoteOptions修改页时发生错误：/business/businessActivityVoteOptions/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessActivityVoteOptions/modify");
		mav.addObject("businessActivityVoteOptions", businessActivityVoteOptions);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessActivityVoteOptionsQuery query) {
		BusinessActivityVoteOptions businessActivityVoteOptions = null;
		String json = "";
		try{
		    businessActivityVoteOptions = businessActivityVoteOptionsService.findById(query.getOptionsId());
		    businessActivityVoteOptions.setActId(query.getActId());
		    businessActivityVoteOptions.setContent(query.getContent());
		    businessActivityVoteOptions.setImage(query.getImage());
		    businessActivityVoteOptions.setCreateTime(query.getCreateTime());
		    businessActivityVoteOptions.setEditTime(query.getEditTime());
		    businessActivityVoteOptions.setEditor(query.getEditor());
			businessActivityVoteOptionsService.update(businessActivityVoteOptions);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessActivityVoteOptions信息时发生错误：/business/businessActivityVoteOptions/update", e);
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
						businessActivityVoteOptionsService.delete(new Integer(ids[i]));
					}
				}else{
					businessActivityVoteOptionsService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessActivityVoteOptions时发生错误：/business/businessActivityVoteOptions/delete", e);
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
