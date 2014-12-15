package com.community.app.module.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.community.app.module.bean.AppUserNews;
import com.community.app.module.bean.BusinessActivityParticipate;
import com.community.app.module.service.AppUserNewsService;
import com.community.app.module.service.BusinessActivityParticipateService;
import com.community.app.module.service.BusinessActivityService;
import com.community.app.module.vo.AppUserNewsQuery;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessActivityParticipateQuery;

@Controller
@RequestMapping("/business/businessActivityParticipate")
public class BusinessActivityParticipateController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessActivityParticipateController.class);
	@Autowired
	private BusinessActivityParticipateService businessActivityParticipateService;
	@Autowired
	private AppUserNewsService appUserNewsService;
	@Autowired
	private BusinessActivityService businessActivityService;
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessActivityParticipate管理页时发生错误：/business/businessActivityParticipate/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessActivityParticipate/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="getPageList")
	public void getPageList(BusinessActivityParticipateQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			query.setActId(query.getActId());
			query.setSort("rank");
			query.setOrder("asc");
			query.setRows(20);
			BaseBean baseBean = businessActivityParticipateService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",");
			result.append("\"pageId\":").append(baseBean.getPager().getPageId()).append(",");
			result.append("\"pageSize\":").append(baseBean.getPager().getPageSize()).append(",");
			result.append("\"pageCount\":").append(baseBean.getPager().getPageCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessActivityParticipate businessActivityParticipate = (BusinessActivityParticipate) baseBean.getList().get(i);
				result.append("{")
			    .append("\"memberId\":\"").append(businessActivityParticipate.getMemberId()).append("\"").append(",")
			    .append("\"actId\":\"").append(businessActivityParticipate.getActId()).append("\"").append(",")
			    .append("\"userId\":\"").append(businessActivityParticipate.getUserId()).append("\"").append(",")
			    .append("\"joinTime\":\"").append(businessActivityParticipate.getJoinTime()).append("\"").append(",")
			    .append("\"isAward\":\"").append(businessActivityParticipate.getIsAward()).append("\"").append(",")
			    .append("\"rank\":\"").append(businessActivityParticipate.getRank()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessActivityParticipate.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessActivityParticipate.getEditTime()).append("\"").append(",")
			    .append("\"isnotice\":\"").append(businessActivityParticipate.getIsnotice()).append("\"").append(",")
			    .append("\"userId\":\"").append(businessActivityParticipate.getUserId()).append("\"").append(",")
			    .append("\"realname\":\"").append(businessActivityParticipate.getRealname()).append("\"").append(",")
			    .append("\"portrait\":\"").append(businessActivityParticipate.getPortrait()).append("\"").append(",")
			    
			    .append("\"estateId\":\"").append(businessActivityParticipate.getEstateId()).append("\"").append(",")
			    .append("\"estateName\":\"").append(businessActivityParticipate.getEstateName() == null ? "":businessActivityParticipate.getEstateName()).append("\"").append(",")
			    .append("\"buildingName\":\"").append(businessActivityParticipate.getBuildingName() == null ? "":businessActivityParticipate.getBuildingName()).append("\"").append(",")
			    .append("\"unitName\":\"").append(businessActivityParticipate.getUnitName() == null ? "":businessActivityParticipate.getUnitName()).append("\"").append(",")
			    .append("\"houseNo\":\"").append(businessActivityParticipate.getHouseNo() == null ? "":businessActivityParticipate.getHouseNo()).append("\"").append(",")
			    
			    .append("\"nickname\":\"").append(businessActivityParticipate.getNickname() == null ? "":businessActivityParticipate.getNickname()).append("\"").append(",")
			    .append("\"tel\":\"").append(businessActivityParticipate.getTel() == null ? "":businessActivityParticipate.getTel()).append("\"").append(",")
			    
			    .append("\"editor\":\"").append(businessActivityParticipate.getEditor()).append("\"")
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
			GSLogger.error("显示businessActivityParticipate列表时发生错误：/business/businessActivityParticipate/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessActivityParticipateQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessActivityParticipate新增页时发生错误：/business/businessActivityParticipate/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessActivityParticipate/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessActivityParticipate
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessActivityParticipateQuery query) {
		BusinessActivityParticipate businessActivityParticipate = new BusinessActivityParticipate();
		String json = "";
		try{
		    businessActivityParticipate.setActId(query.getActId());
		    businessActivityParticipate.setUserId(query.getUserId());
		    businessActivityParticipate.setJoinTime(query.getJoinTime());
		    businessActivityParticipate.setIsAward(query.getIsAward());
		    businessActivityParticipate.setRank(query.getRank());
		    businessActivityParticipate.setCreateTime(query.getCreateTime());
		    businessActivityParticipate.setEditTime(query.getEditTime());
		    businessActivityParticipate.setEditor(query.getEditor());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        businessActivityParticipate.setCreateTime(ts);
	        businessActivityParticipate.setEditTime(ts);
			businessActivityParticipateService.save(businessActivityParticipate);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessActivityParticipate信息时发生错误：/business/businessActivityParticipate/save", e);
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
	public ModelAndView modify(BusinessActivityParticipateQuery query) {	
		BusinessActivityParticipate businessActivityParticipate=new BusinessActivityParticipate();
		
		try{
			businessActivityParticipate = businessActivityParticipateService.findById(query.getMemberId());
		}catch(Exception e){
			GSLogger.error("进入businessActivityParticipate修改页时发生错误：/business/businessActivityParticipate/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessActivityParticipate/modify");
		mav.addObject("businessActivityParticipate", businessActivityParticipate);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessActivityParticipateQuery query) {
		BusinessActivityParticipate businessActivityParticipate = null;
		String json = "";
		try{
		    businessActivityParticipate = businessActivityParticipateService.findById(query.getMemberId());
		    businessActivityParticipate.setActId(query.getActId());
		    businessActivityParticipate.setUserId(query.getUserId());
		    businessActivityParticipate.setJoinTime(query.getJoinTime());
		    businessActivityParticipate.setIsAward(query.getIsAward());
		    businessActivityParticipate.setRank(query.getRank());
		    businessActivityParticipate.setCreateTime(query.getCreateTime());
		    businessActivityParticipate.setEditTime(query.getEditTime());
		    businessActivityParticipate.setEditor(query.getEditor());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        businessActivityParticipate.setEditTime(ts);
			businessActivityParticipateService.update(businessActivityParticipate);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessActivityParticipate信息时发生错误：/business/businessActivityParticipate/update", e);
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
						businessActivityParticipateService.delete(new Integer(ids[i]));
					}
				}else{
					businessActivityParticipateService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessActivityParticipate时发生错误：/business/businessActivityParticipate/delete", e);
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
	 * 活动中获取发送给用户的消息
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="getActivityNewsPageList")
	public void getActivityNewsPageList(AppUserNewsQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			Map paramMap = new HashMap();
			paramMap.put("userId", query.getUserId());
			paramMap.put("id", query.getId());
			paramMap.put("type", 6);
			
			List<AppUserNews>  appUserNewsList = appUserNewsService.findByMap(paramMap);
			result.append("{\"total\":").append(appUserNewsList.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<appUserNewsList.size();i++) {
				AppUserNews appUserNews = (AppUserNews) appUserNewsList.get(i);
				result.append("{")
			    .append("\"content\":\"").append(appUserNews.getContent()).append("\"").append(",")
			    .append("\"createTime\":\"").append(appUserNews.getCreateTime()).append("\"")
				.append("}").append(",");
			}
			json = result.toString();
			if(appUserNewsList.size() > 0) {
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
			GSLogger.error("显示businessActivityParticipate列表时发生错误：/business/businessActivityParticipate/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 活动中保存发送给用户的消息
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="saveActivityNews")
	public void saveActivityNews(HttpServletRequest request, HttpServletResponse response, AppUserNewsQuery query) {
		String json = "";
		try{
			AppUserNews appUserNews = new AppUserNews();
			appUserNews.setUserId(query.getUserId());
			appUserNews.setCreateTime(new Timestamp(System.currentTimeMillis()));
			appUserNews.setNewTitle("活动通知");
			appUserNews.setType(6);//系统信息
			String memberId = request.getParameter("memberId");
			if(memberId != null) {
				appUserNews.setId(new Integer(memberId));
			}			
			appUserNews.setContent(query.getContent());
			//appUserNews.setLastMessage(query.getContent());
			//appUserNews.setLastMessageName(query.getUserId()+"");
			appUserNewsService.save(appUserNews);
			
			if(memberId != null) {
				BusinessActivityParticipate businessActivityParticipate = new BusinessActivityParticipate();
				businessActivityParticipate.setMemberId(new Integer(memberId));
				businessActivityParticipate.setIsnotice(1);
				businessActivityParticipateService.update(businessActivityParticipate);
			}			
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessActivityParticipate信息时发生错误：/business/businessActivityParticipate/update", e);
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
