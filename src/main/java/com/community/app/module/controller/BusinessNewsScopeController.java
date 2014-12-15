package com.community.app.module.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.community.app.module.vo.BaseBean;


import com.community.app.module.bean.BusinessNewsScope;
import com.community.app.module.service.BusinessNewsScopeService;
import com.community.app.module.vo.BusinessNewsScopeQuery;


@Controller
@RequestMapping("/business/businessNewsScope")
public class BusinessNewsScopeController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessNewsScopeController.class);
	@Autowired
	private BusinessNewsScopeService businessNewsScopeService;
	
	private final String LIST_ACTION = "redirect:/business/businessNewsScope/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessNewsScope管理页时发生错误：/business/businessNewsScope/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessNewsScope/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessNewsScopeQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessNewsScopeService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessNewsScope businessNewsScope = (BusinessNewsScope) baseBean.getList().get(i);
				result.append("{")
			    .append("\"scopeId\":\"").append(businessNewsScope.getScopeId()).append("\"").append(",")
			    .append("\"newsId\":\"").append(businessNewsScope.getNewsId()).append("\"").append(",")
			    .append("\"comId\":\"").append(businessNewsScope.getComId()).append("\"").append(",")
			    .append("\"comName\":\"").append(businessNewsScope.getComName()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessNewsScope.getCreateTime()).append("\"")
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
			GSLogger.error("显示businessNewsScope列表时发生错误：/business/businessNewsScope/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessNewsScopeQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessNewsScope新增页时发生错误：/business/businessNewsScope/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessNewsScope/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessNewsScope
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessNewsScopeQuery query) {
		BusinessNewsScope businessNewsScope = new BusinessNewsScope();
		String json = "";
		try{
		    businessNewsScope.setNewsId(query.getNewsId());
		    businessNewsScope.setComId(query.getComId());
		    businessNewsScope.setComName(query.getComName());
		    businessNewsScope.setCreateTime(query.getCreateTime());
			businessNewsScopeService.save(businessNewsScope);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessNewsScope信息时发生错误：/business/businessNewsScope/save", e);
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
	public ModelAndView modify(BusinessNewsScopeQuery query) {	
		BusinessNewsScope businessNewsScope=new BusinessNewsScope();
		
		try{
			businessNewsScope = businessNewsScopeService.findById(query.getScopeId());
		}catch(Exception e){
			GSLogger.error("进入businessNewsScope修改页时发生错误：/business/businessNewsScope/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessNewsScope/modify");
		mav.addObject("businessNewsScope", businessNewsScope);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessNewsScopeQuery query) {
		BusinessNewsScope businessNewsScope = null;
		String json = "";
		try{
		    businessNewsScope = businessNewsScopeService.findById(query.getScopeId());
		    businessNewsScope.setNewsId(query.getNewsId());
		    businessNewsScope.setComId(query.getComId());
		    businessNewsScope.setComName(query.getComName());
		    businessNewsScope.setCreateTime(query.getCreateTime());
			businessNewsScopeService.update(businessNewsScope);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessNewsScope信息时发生错误：/business/businessNewsScope/update", e);
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
						businessNewsScopeService.delete(new Integer(ids[i]));
					}
				}else{
					businessNewsScopeService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessNewsScope时发生错误：/business/businessNewsScope/delete", e);
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
