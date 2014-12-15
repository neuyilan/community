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



import com.community.app.module.bean.BusinessCommunity;
import com.community.app.module.service.BusinessCommunityService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessCommunityQuery;


@Controller
@RequestMapping("/business/businessCommunity")
public class BusinessCommunityController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessCommunityController.class);
	@Autowired
	private BusinessCommunityService businessCommunityService;
	
	private final String LIST_ACTION = "redirect:/business/businessCommunity/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessCommunity管理页时发生错误：/business/businessCommunity/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessCommunity/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessCommunityQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessCommunityService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessCommunity businessCommunity = (BusinessCommunity) baseBean.getList().get(i);
				result.append("{")
			    .append("\"comId\":\"").append(businessCommunity.getComId()).append("\"").append(",")
			    .append("\"orgId\":\"").append(businessCommunity.getOrgId()).append("\"").append(",")
			    .append("\"comName\":\"").append(businessCommunity.getComName()).append("\"").append(",")
			    .append("\"comBrief\":\"").append(businessCommunity.getComBrief()).append("\"").append(",")
			    .append("\"comService\":\"").append(businessCommunity.getComService()).append("\"").append(",")
			    .append("\"comTel\":\"").append(businessCommunity.getComTel()).append("\"").append(",")
			    .append("\"comEmail\":\"").append(businessCommunity.getComEmail()).append("\"").append(",")
			    .append("\"comWeixin\":\"").append(businessCommunity.getComWeixin()).append("\"").append(",")
			    .append("\"comIcon\":\"").append(businessCommunity.getComIcon()).append("\"").append(",")
			    .append("\"comLongitude\":\"").append(businessCommunity.getComLongitude()).append("\"").append(",")
			    .append("\"comLatitude\":\"").append(businessCommunity.getComLatitude()).append("\"").append(",")
			    .append("\"crateTime\":\"").append(businessCommunity.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessCommunity.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessCommunity.getEditor()).append("\"").append(",")
			    .append("\"comCode\":\"").append(businessCommunity.getComCode()).append("\"")
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
			GSLogger.error("显示businessCommunity列表时发生错误：/business/businessCommunity/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessCommunityQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessCommunity新增页时发生错误：/business/businessCommunity/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessCommunity/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessCommunity
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessCommunityQuery query) {
		BusinessCommunity businessCommunity = new BusinessCommunity();
		String json = "";
		try{
		    businessCommunity.setOrgId(query.getOrgId());
		    businessCommunity.setComName(query.getComName());
		    businessCommunity.setComBrief(query.getComBrief());
		    businessCommunity.setComService(query.getComService());
		    businessCommunity.setComTel(query.getComTel());
		    businessCommunity.setComEmail(query.getComEmail());
		    businessCommunity.setComWeixin(query.getComWeixin());
		    businessCommunity.setComIcon(query.getComIcon());
		    businessCommunity.setComLongitude(query.getComLongitude());
		    businessCommunity.setComLatitude(query.getComLatitude());
		    businessCommunity.setCreateTime(query.getCrateTime());
		    businessCommunity.setEditTime(query.getEditTime());
		    businessCommunity.setEditor(query.getEditor());
		    businessCommunity.setComCode(query.getComCode());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        businessCommunity.setCreateTime(ts);
	        businessCommunity.setEditTime(ts);
			businessCommunityService.save(businessCommunity);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessCommunity信息时发生错误：/business/businessCommunity/save", e);
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
	public ModelAndView modify(BusinessCommunityQuery query) {	
		BusinessCommunity businessCommunity=new BusinessCommunity();
		
		try{
			businessCommunity = businessCommunityService.findById(query.getComId());
		}catch(Exception e){
			GSLogger.error("进入businessCommunity修改页时发生错误：/business/businessCommunity/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessCommunity/modify");
		mav.addObject("businessCommunity", businessCommunity);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessCommunityQuery query) {
		BusinessCommunity businessCommunity = null;
		String json = "";
		try{
		    businessCommunity = businessCommunityService.findById(query.getComId());
		    businessCommunity.setOrgId(query.getOrgId());
		    businessCommunity.setComName(query.getComName());
		    businessCommunity.setComBrief(query.getComBrief());
		    businessCommunity.setComService(query.getComService());
		    businessCommunity.setComTel(query.getComTel());
		    businessCommunity.setComEmail(query.getComEmail());
		    businessCommunity.setComWeixin(query.getComWeixin());
		    businessCommunity.setComIcon(query.getComIcon());
		    businessCommunity.setComLongitude(query.getComLongitude());
		    businessCommunity.setComLatitude(query.getComLatitude());
		    businessCommunity.setCreateTime(query.getCrateTime());
		    businessCommunity.setEditTime(query.getEditTime());
		    businessCommunity.setEditor(query.getEditor());
		    businessCommunity.setComCode(query.getComCode());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        businessCommunity.setEditTime(ts);
			businessCommunityService.update(businessCommunity);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessCommunity信息时发生错误：/business/businessCommunity/update", e);
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
						businessCommunityService.delete(new Integer(ids[i]));
					}
				}else{
					businessCommunityService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessCommunity时发生错误：/business/businessCommunity/delete", e);
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
