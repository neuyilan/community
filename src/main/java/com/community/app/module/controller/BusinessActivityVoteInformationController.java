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

import com.community.app.module.bean.BusinessActivityVoteInformation;
import com.community.app.module.service.BusinessActivityService;
import com.community.app.module.service.BusinessActivityVoteInformationService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessActivityQuery;
import com.community.app.module.vo.BusinessActivityVoteInformationQuery;

@Controller
@RequestMapping("/business/businessActivityVoteInformation")
public class BusinessActivityVoteInformationController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessActivityVoteInformationController.class);
	@Autowired
	private BusinessActivityVoteInformationService businessActivityVoteInformationService;
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
			GSLogger.error("进入businessActivityVoteInformation管理页时发生错误：/business/businessActivityVoteInformation/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessActivityVoteInformation/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessActivityVoteInformationQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			query.setActId(query.getActId());
			query.setSort("optionsId");
			query.setOrder("asc");
			query.setRows(20);
			BaseBean baseBean = businessActivityVoteInformationService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",");
			result.append("\"pageId\":").append(baseBean.getPager().getPageId()).append(",");
			result.append("\"pageSize\":").append(baseBean.getPager().getPageSize()).append(",");
			result.append("\"pageCount\":").append(baseBean.getPager().getPageCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessActivityVoteInformation businessActivityVoteInformation = (BusinessActivityVoteInformation) baseBean.getList().get(i);
				result.append("{")
			    .append("\"informationId\":\"").append(businessActivityVoteInformation.getInformationId()).append("\"").append(",")
			    .append("\"userId\":\"").append(businessActivityVoteInformation.getUserId()).append("\"").append(",")
			    .append("\"actId\":\"").append(businessActivityVoteInformation.getActId()).append("\"").append(",")
			    .append("\"optionsId\":\"").append(businessActivityVoteInformation.getOptionsId()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessActivityVoteInformation.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessActivityVoteInformation.getEditTime()).append("\"").append(",")
			    .append("\"realname\":\"").append(businessActivityVoteInformation.getRealname()).append("\"").append(",")
			    .append("\"portrait\":\"").append(businessActivityVoteInformation.getPortrait()).append("\"").append(",")
			    
			    .append("\"estateId\":\"").append(businessActivityVoteInformation.getEstateId()).append("\"").append(",")
			    .append("\"estateName\":\"").append(businessActivityVoteInformation.getEstateName() == null ? "":businessActivityVoteInformation.getEstateName()).append("\"").append(",")
			    .append("\"buildingName\":\"").append(businessActivityVoteInformation.getBuildingName() == null ? "":businessActivityVoteInformation.getBuildingName()).append("\"").append(",")
			    .append("\"unitName\":\"").append(businessActivityVoteInformation.getUnitName() == null ? "":businessActivityVoteInformation.getUnitName()).append("\"").append(",")
			    .append("\"houseNo\":\"").append(businessActivityVoteInformation.getHouseNo() == null ? "":businessActivityVoteInformation.getHouseNo()).append("\"").append(",")
			    
			    .append("\"nickname\":\"").append(businessActivityVoteInformation.getNickname() == null ? "":businessActivityVoteInformation.getNickname()).append("\"").append(",")
			    .append("\"tel\":\"").append(businessActivityVoteInformation.getTel() == null ? "":businessActivityVoteInformation.getTel()).append("\"").append(",")
			   
			    .append("\"editor\":\"").append(businessActivityVoteInformation.getEditor()).append("\"")
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
			GSLogger.error("显示businessActivityVoteInformation列表时发生错误：/business/businessActivityVoteInformation/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessActivityVoteInformationQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessActivityVoteInformation新增页时发生错误：/business/businessActivityVoteInformation/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessActivityVoteInformation/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessActivityVoteInformation
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessActivityVoteInformationQuery query) {
		BusinessActivityVoteInformation businessActivityVoteInformation = new BusinessActivityVoteInformation();
		String json = "";
		try{
			BusinessActivityVoteInformationQuery businessActivityVoteInformationQuery = new BusinessActivityVoteInformationQuery();
			businessActivityVoteInformationQuery.setActId(query.getID());
			businessActivityVoteInformationQuery.setUserId(query.getUserId());
			int count = businessActivityVoteInformationService.selectCount(businessActivityVoteInformationQuery);
			if(count>0){
				json += "{";
				json += "\"errorCode\":\"400\",";
				json += "\"message\":\"您已经投过票了\"";
				json += "}";
			}else {
				String[] arr = query.getIds().split(",");
				Timestamp  ts=new Timestamp(new Date().getTime());
				for (int i = 0; i < arr.length; i++) {
					businessActivityVoteInformation.setUserId(query.getUserId());
				    businessActivityVoteInformation.setActId(query.getID());
				    businessActivityVoteInformation.setOptionsId(new Integer(arr[i]));
				    businessActivityVoteInformation.setCreateTime(ts);
				    businessActivityVoteInformation.setEditTime(ts);
				    businessActivityVoteInformation.setEditor("");
					businessActivityVoteInformationService.save(businessActivityVoteInformation);
					//参与人增加
					BusinessActivityQuery businessActivityQuery = new BusinessActivityQuery();
					businessActivityQuery.setActId(query.getID());
					businessActivityService.addParticipants(businessActivityQuery);
				}
				//保存成功
				json += "{";
				json += "\"errorCode\":\"200\",";
				json += "\"message\":\"参与成功\"";
				json += "}";
			}
			
		} catch(Exception e) {
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"保存失败\",";
			json += "}";
			GSLogger.error("保存businessActivityVoteInformation信息时发生错误：/business/businessActivityVoteInformation/save", e);
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
	public ModelAndView modify(BusinessActivityVoteInformationQuery query) {	
		BusinessActivityVoteInformation businessActivityVoteInformation=new BusinessActivityVoteInformation();
		
		try{
			businessActivityVoteInformation = businessActivityVoteInformationService.findById(query.getInformationId());
		}catch(Exception e){
			GSLogger.error("进入businessActivityVoteInformation修改页时发生错误：/business/businessActivityVoteInformation/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessActivityVoteInformation/modify");
		mav.addObject("businessActivityVoteInformation", businessActivityVoteInformation);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessActivityVoteInformationQuery query) {
		BusinessActivityVoteInformation businessActivityVoteInformation = null;
		String json = "";
		try{
		    businessActivityVoteInformation = businessActivityVoteInformationService.findById(query.getInformationId());
		    businessActivityVoteInformation.setUserId(query.getUserId());
		    businessActivityVoteInformation.setActId(query.getActId());
		    businessActivityVoteInformation.setOptionsId(query.getOptionsId());
		    businessActivityVoteInformation.setCreateTime(query.getCreateTime());
		    businessActivityVoteInformation.setEditTime(query.getEditTime());
		    businessActivityVoteInformation.setEditor(query.getEditor());
			businessActivityVoteInformationService.update(businessActivityVoteInformation);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessActivityVoteInformation信息时发生错误：/business/businessActivityVoteInformation/update", e);
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
						businessActivityVoteInformationService.delete(new Integer(ids[i]));
					}
				}else{
					businessActivityVoteInformationService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessActivityVoteInformation时发生错误：/business/businessActivityVoteInformation/delete", e);
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
