package com.community.app.module.controller;

import static com.community.framework.utils.CommonUtils.getUser;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.community.app.module.bean.BusinessCommunity;
import com.community.app.module.bean.BusinessNewspaper;
import com.community.app.module.bean.BusinessNewspaperScope;
import com.community.app.module.bean.ShiroUser;
import com.community.app.module.service.BusinessCommunityService;
import com.community.app.module.service.BusinessNewspaperScopeService;
import com.community.app.module.service.BusinessNewspaperService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessNewspaperQuery;
import com.community.framework.utils.CommonUtils;
import com.community.framework.utils.JsonUtils;

@Controller
@RequestMapping("/business/businessNewspaper")
public class BusinessNewspaperController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessNewspaperController.class);
	@Autowired
	private BusinessNewspaperService businessNewspaperService;
	@Autowired
	private BusinessCommunityService businessCommunityService;
	@Autowired
	private BusinessNewspaperScopeService businessNewspaperScopeService;
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="list")
	public ModelAndView list(BusinessNewspaperQuery query) {		
		ShiroUser shiroUser = CommonUtils.getUser();
		Map map = new HashMap();
		BaseBean baseBean = new BaseBean();
		List<BusinessCommunity> list = new ArrayList<BusinessCommunity>();
		try{
			Subject currentUser = SecurityUtils.getSubject();  
			if (currentUser.isPermitted("dzb_publish_dzb")) {
				query.setRows(11);
			} else {  
				query.setRows(12);
			}
			query.setOrder("desc");
			query.setSort("editTime");
			//if(!ModuleConst.OPERATION_CODE.equals(shiroUser.getOrgType())) { 
				query.setCurUserId(shiroUser.getUserId());
			//}
			if(shiroUser.getCurEstateId() != null) {
				query.setCurEstateId(shiroUser.getCurEstateId());
			}		
			if(shiroUser.getCurComId() != null && shiroUser.getCurComId() != 0) {
				query.setComId(shiroUser.getCurComId());
				map.put("comId", shiroUser.getCurComId());
			}
			baseBean = businessNewspaperService.findAllPage(query);
			
			map.put("userId", shiroUser.getUserId());
			//map.put("orgType", shiroUser.getOrgType());
			
			list = businessCommunityService.findComsByUser(map);
		}catch(Exception e){
			GSLogger.error("进入businessNewspaper管理页时发生错误：/business/businessNewspaper/list", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/newspaper/list");
		mav.addObject("list", list);
		mav.addObject("baseBean", baseBean);
		mav.addObject("pager", baseBean.getPager());
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="getPageList")
	public void getPageList(BusinessNewspaperQuery query, HttpServletResponse response) {
		String json = "";
		ShiroUser shiroUser = CommonUtils.getUser();
		StringBuilder result = new StringBuilder();
		try{
			Subject currentUser = SecurityUtils.getSubject();  
			if (currentUser.isPermitted("dzb_publish_dzb")) {
				query.setRows(11);
			} else {  
				query.setRows(12);
			}
			//if(!ModuleConst.OPERATION_CODE.equals(shiroUser.getOrgType())) { 
				query.setCurUserId(shiroUser.getUserId());
			//}
			if(shiroUser.getCurEstateId() != null) {
				query.setCurEstateId(shiroUser.getCurEstateId());
			}
			if(shiroUser.getCurComId() != null && shiroUser.getCurComId() != 0) {
				query.setComId(shiroUser.getCurComId());
			}
			query.setOrder("desc");
			query.setSort("editTime");
			
			BaseBean baseBean = businessNewspaperService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",");
			result.append("\"pageId\":").append(baseBean.getPager().getPageId()).append(",");
			result.append("\"pageCount\":").append(baseBean.getPager().getPageCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessNewspaper businessNewspaper = (BusinessNewspaper) baseBean.getList().get(i);
				result.append("{")
			    .append("\"newspaperId\":\"").append(businessNewspaper.getNewspaperId()).append("\"").append(",")
			    .append("\"title\":\"").append(JsonUtils.stringToJson(businessNewspaper.getTitle().replace("\"", "\\\"").replaceAll("(\r?\n()+)", ""))).append("\"").append(",")
			    .append("\"pic\":\"").append(businessNewspaper.getPic()).append("\"").append(",")
			    .append("\"url\":\"").append(businessNewspaper.getUrl()).append("\"").append(",")
			    .append("\"comId\":\"").append(businessNewspaper.getComId()).append("\"").append(",")
			    .append("\"comNameScope\":\"").append(businessNewspaper.getComNameScope()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessNewspaper.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessNewspaper.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessNewspaper.getEditor()).append("\"")
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
				e.printStackTrace();
			}
		}catch(Exception e){
			GSLogger.error("显示businessNewspaper列表时发生错误：/business/businessNewspaper/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessNewspaperQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessNewspaper新增页时发生错误：/business/businessNewspaper/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/newspaper/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessNewspaper
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessNewspaperQuery query) {
		BusinessNewspaper businessNewspaper = new BusinessNewspaper();
		String json = "";
		String comNameScope = "";
		try{
			ShiroUser shiroUser = CommonUtils.getUser();
		    Map map = new HashMap();
			map.put("userId", shiroUser.getUserId());
			map.put("orgType", shiroUser.getOrgType());
			map.put("comId", shiroUser.getCurComId());
			List comList = businessCommunityService.findComsByUser(map);
		    for(int i=0; i<comList.size(); i++) {
		    	BusinessCommunity businessCommunity = (BusinessCommunity)comList.get(i);
				comNameScope+="," + businessCommunity.getComName();
			}
		    businessNewspaper.setTitle(query.getTitle());
		    businessNewspaper.setPic(query.getPic());
		    businessNewspaper.setUrl(query.getUrl());
		    businessNewspaper.setComNameScope(comNameScope.substring(1));
		    businessNewspaper.setEditor(getUser().getUserName());
	        businessNewspaper.setCreateTime(new Timestamp(new Date().getTime()));
	        businessNewspaper.setEditTime(new Timestamp(new Date().getTime()));
			businessNewspaperService.save(businessNewspaper);
			
			for(int i=0; i<comList.size(); i++) {
				BusinessCommunity businessCommunity = (BusinessCommunity)comList.get(i);
				BusinessNewspaperScope bnsQuery = new BusinessNewspaperScope();
				bnsQuery.setNewspaperId(businessNewspaper.getNewspaperId());
				bnsQuery.setComId(businessCommunity.getComId());
				bnsQuery.setComName(businessCommunity.getComName());
				businessNewspaperScopeService.save(bnsQuery);
			}
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessNewspaper信息时发生错误：/business/businessNewspaper/save", e);
			e.printStackTrace();
		}
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入修改页
	 * @return
	 */
	@RequestMapping(value="modify")
	public ModelAndView modify(BusinessNewspaperQuery query) {	
		BusinessNewspaper businessNewspaper=new BusinessNewspaper();
		
		try{
			businessNewspaper = businessNewspaperService.findById(query.getNewspaperId());
		}catch(Exception e){
			GSLogger.error("进入businessNewspaper修改页时发生错误：/business/businessNewspaper/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/newspaper/modify");
		mav.addObject("businessNewspaper", businessNewspaper);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessNewspaperQuery query) {
		BusinessNewspaper businessNewspaper = null;
		String comNameScope = "";
		String json = "";
		try{
			ShiroUser shiroUser = CommonUtils.getUser();
		    Map map = new HashMap();
			map.put("userId", shiroUser.getUserId());
			map.put("orgType", shiroUser.getOrgType());
			map.put("comId", shiroUser.getCurComId());
			List comList = businessCommunityService.findComsByUser(map);
		    for(int i=0; i<comList.size(); i++) {
		    	BusinessCommunity businessCommunity = (BusinessCommunity)comList.get(i);
				comNameScope+="," + businessCommunity.getComName();
			}
		    businessNewspaper = businessNewspaperService.findById(query.getNewspaperId());
		    businessNewspaper.setTitle(query.getTitle());
		    businessNewspaper.setPic(query.getPic());
		    businessNewspaper.setUrl(query.getUrl());
		    businessNewspaper.setComNameScope(comNameScope.substring(1));
		    businessNewspaper.setEditor(getUser().getUserName());
	        businessNewspaper.setEditTime(new Timestamp(new Date().getTime()));
			businessNewspaperService.update(businessNewspaper);
			
			businessNewspaperScopeService.delete(businessNewspaper.getNewspaperId());
			for(int i=0; i<comList.size(); i++) {
				BusinessCommunity businessCommunity = (BusinessCommunity)comList.get(i);
				BusinessNewspaperScope bnsQuery = new BusinessNewspaperScope();
				bnsQuery.setNewspaperId(businessNewspaper.getNewspaperId());
				bnsQuery.setComId(businessCommunity.getComId());
				bnsQuery.setComName(businessCommunity.getComName());
				businessNewspaperScopeService.save(bnsQuery);
			}
			
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessNewspaper信息时发生错误：/business/businessNewspaper/update", e);
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
						businessNewspaperService.delete(new Integer(ids[i]));
					}
				}else{
					businessNewspaperService.delete(new Integer(id));
					businessNewspaperScopeService.delete(new Integer(id));
				}
			}
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessNewspaper时发生错误：/business/businessNewspaper/delete", e);
			e.printStackTrace();
		}
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}