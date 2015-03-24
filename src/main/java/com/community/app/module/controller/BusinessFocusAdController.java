package com.community.app.module.controller;

import static com.community.framework.utils.CommonUtils.getUser;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.community.app.module.bean.AppFocusAdScope;
import com.community.app.module.bean.BusinessFocusAd;
import com.community.app.module.bean.BusinessOpertaion;
import com.community.app.module.bean.BusinessUserResource;
import com.community.app.module.bean.ShiroUser;
import com.community.app.module.common.CommunityBean;
import com.community.app.module.common.ModuleConst;
import com.community.app.module.service.AppFocusAdScopeService;
import com.community.app.module.service.BusinessCommunityService;
import com.community.app.module.service.BusinessFocusAdService;
import com.community.app.module.service.BusinessOpertaionService;
import com.community.app.module.service.BusinessUserResourceService;
import com.community.app.module.service.ManageEstateService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessFocusAdQuery;
import com.community.framework.utils.CommonUtils;
import com.community.framework.utils.JsonUtils;

@Controller
@RequestMapping("/business/businessFocusAd")
public class BusinessFocusAdController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessFocusAdController.class);
	@Autowired
	private BusinessFocusAdService businessFocusAdService;
	@Autowired
	private BusinessCommunityService businessCommunityService;
	@Autowired
	private ManageEstateService manageEstateService;
	@Autowired
	private AppFocusAdScopeService appFocusAdScopeService;
	@Autowired
	private BusinessUserResourceService businessUserResourceService;
	@Autowired
	private BusinessOpertaionService businessOpertaionService;
	
	/**
	 * 进入管理页
	 * @return
	 */
	/*@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessFocusAd管理页时发生错误：/business/businessFocusAd/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessFocusAd/enter");
		return mav;
	}*/
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="list")
	public ModelAndView list(BusinessFocusAdQuery query) {		
		BaseBean baseBean = new BaseBean();
		try{
			query.setSort("selectTime");
			query.setOrder("desc");
			
			ShiroUser shiroUser = CommonUtils.getUser();
			//if(ModuleConst.COMMUNITY_CODE.equals(shiroUser.getOrgType())) {
				query.setCurUserId(shiroUser.getUserId());
			//}			
				if(shiroUser.getCurEstateId() != null) {
					query.setCurEstateId(shiroUser.getCurEstateId());
				}	
			if(shiroUser.getCurComId() != null && shiroUser.getCurComId() != 0) {
				query.setCurComId(shiroUser.getCurComId());
			}
			Subject currentUser = SecurityUtils.getSubject();  
			if (currentUser.isPermitted("focus_ad_publish")) {  //新增焦点图功能展示会影响分页
				query.setRows(11);
			} else {  
				query.setRows(12);
			}
			baseBean = businessFocusAdService.findAllPage(query);
		}catch(Exception e){
			GSLogger.error("进入businessFocus管理页时发生错误：/business/businessFocusAd/list", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/focusad/list");
		if(CommonUtils.hasRole(ModuleConst.OPERATION_CODE)) {
			mav.addObject("role", "operation");
		 }
		mav.addObject("baseBean", baseBean);
		mav.addObject("state", query.getState());
		mav.addObject("pager", baseBean.getPager());
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="getPageList")
	public void getPageList(BusinessFocusAdQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			if(!("").equals(query.getOrderBy()) && query.getOrderBy() != null) {
				query.setSort(query.getOrderBy());
			}else{
				query.setSort("selectTime");
			}
			query.setOrder("desc");

			ShiroUser shiroUser = CommonUtils.getUser();
			//if(ModuleConst.COMMUNITY_CODE.equals(shiroUser.getOrgType())) {
				query.setCurUserId(shiroUser.getUserId());
			//}	
				if(shiroUser.getCurEstateId() != null) {
					query.setCurEstateId(shiroUser.getCurEstateId());
				}	
			if(shiroUser.getCurComId() != null && shiroUser.getCurComId() != 0) {
				query.setCurComId(shiroUser.getCurComId());
			}
			Subject currentUser = SecurityUtils.getSubject();  
			if (currentUser.isPermitted("focus_ad_publish")) {  //新增焦点图功能展示会影响分页
				query.setRows(11);
			} else {  
				query.setRows(12);
			}
			BaseBean baseBean = businessFocusAdService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",");
			result.append("\"pageId\":").append(baseBean.getPager().getPageId()).append(",");
			result.append("\"pageCount\":").append(baseBean.getPager().getPageCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessFocusAd businessFocusAd = (BusinessFocusAd) baseBean.getList().get(i);
				result.append("{")
			    .append("\"focusAdId\":\"").append(businessFocusAd.getFocusAdId()).append("\"").append(",")
			    .append("\"title\":\"").append(JsonUtils.stringToJson(businessFocusAd.getTitle().replace("\"", "\\\"").replaceAll("(\r?\n()+)", ""))).append("\"").append(",")
			    .append("\"content\":\"").append("").append("\"").append(",")
			    .append("\"picUrl\":\"").append(businessFocusAd.getPicUrl().replaceAll("(\r?\n()+)", "").replace("\"", "")).append("\"").append(",")
			    .append("\"sourceType\":\"").append(businessFocusAd.getSourceType()).append("\"").append(",")
			    .append("\"sourceId\":\"").append(businessFocusAd.getSourceId()).append("\"").append(",")
			    .append("\"selectTime\":\"").append(businessFocusAd.getSelectTime()).append("\"").append(",")
			    .append("\"state\":\"").append(businessFocusAd.getState()).append("\"").append(",")
			    .append("\"pageUrl\":\"").append(businessFocusAd.getPageUrl().replaceAll("(\r?\n()+)", "").replace("\"", "")).append("\"").append(",")
			    .append("\"selectorId\":\"").append(businessFocusAd.getSelectorId()).append("\"").append(",")
			    .append("\"selectorName\":\"").append(businessFocusAd.getSelectorName()).append("\"").append(",")
			    .append("\"auditorId\":\"").append(businessFocusAd.getAuditorId()).append("\"").append(",")
			    .append("\"auditTime\":\"").append(businessFocusAd.getAuditTime()).append("\"").append(",")
			    .append("\"auditorName\":\"").append(businessFocusAd.getAuditorName()).append("\"").append(",")
			    .append("\"auditInfo\":\"").append(businessFocusAd.getAuditInfo()).append("\"").append(",")
			    .append("\"startTime\":\"").append(businessFocusAd.getStartTime()).append("\"").append(",")
			    .append("\"endTime\":\"").append(businessFocusAd.getEndTime()).append("\"").append(",")
			    .append("\"visits\":\"").append(businessFocusAd.getVisits()).append("\"").append(",")
			    .append("\"supports\":\"").append(businessFocusAd.getSupports()).append("\"").append(",")
			    .append("\"ishtml\":\"").append(businessFocusAd.getIshtml()).append("\"").append(",")
			    .append("\"focusAdScope\":\"").append(businessFocusAd.getFocusAdScope()).append("\"")
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
			GSLogger.error("显示businessFocusAd列表时发生错误：/business/businessFocusAd/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取用户展示的所有社区下的小区列表
	 * @param response
	 */
	@RequestMapping(value="getExpendScopeTree")
	public void getExpendScopeTree(BusinessFocusAdQuery query, HttpServletResponse response) {
		JSONObject jsonObj = new JSONObject();
		JSONArray comArr = new JSONArray();
		
		try{
			ShiroUser shiroUser = CommonUtils.getUser();
			JSONObject allObj = new JSONObject();
			allObj.put("id", "allCom");
			allObj.put("text", "全部社区");
			JSONArray allArr = new JSONArray();
			List comList = shiroUser.getComList();
			
			List<String> tempList = null; 
			JSONObject comObj = null;
			Map paramMap = null;
			if(query.getFlag().equals("update")) {
				String strArr[] = query.getScope().split(",");
				tempList = Arrays.asList(strArr);
			} 
			
			for(int i=0;i<comList.size();i++) {
				CommunityBean community = (CommunityBean) comList.get(i);
				comObj = new JSONObject();
				paramMap = new HashMap();
				paramMap.put("comId", community.getComId());
				paramMap.put("userId", shiroUser.getUserId());
				
				List estateList = businessUserResourceService.findByMap(paramMap);
				if(estateList.size() > 0){
					comObj.put("id", "com_"+community.getComId());
					comObj.put("text", community.getComName());
					JSONArray estateArr = new JSONArray();
					for(int j=0;j<estateList.size();j++) {
						BusinessUserResource businessUserResource = (BusinessUserResource) estateList.get(j);
						JSONObject estateObj = new JSONObject();
						estateObj.put("id", "estate_"+businessUserResource.getEstateId());
						estateObj.put("text", businessUserResource.getEstateName());
						estateObj.put("state", "close");
						if(query.getFlag().equals("update")) {
							if(tempList.contains(businessUserResource.getEstateId()+"")) {
								estateObj.put("checked","true");
							}
						}
						estateArr.add(estateObj);
					}
					comObj.put("children", estateArr);
					comObj.put("state", "closed");
					allArr.add(comObj);
				}				
			}
			allObj.put("children", allArr);
			allObj.put("state", "closed");
			comArr.add(allObj);
			
			jsonObj.put("success", true);
			jsonObj.put("result", comArr);
		}catch(Exception e){
			jsonObj.put("success", false);
			jsonObj.put("message", "获取失败");
			GSLogger.error("获取用户要扩散到的所有社区下的小区列表：/business/businessFocusAd/getExpendScopeTree", e);
			e.printStackTrace();
		}
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(jsonObj.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
     * 查询全网焦点图详情信息
     * @param query
     * @param response
     */
    @RequestMapping(value="getFocusAdDetail")
    public void getFocusAdDetail(BusinessFocusAdQuery query, HttpServletResponse response) {
        try{
        	BusinessFocusAd businessFocusAd = businessFocusAdService.findById(query.getFocusAdId());
        	JSONObject jsons= JSONObject.fromObject(businessFocusAd);
        	
            response.setHeader("Cache-Control", "no-cache");
            response.setCharacterEncoding("utf-8");
            try {
                response.getWriter().write(jsons.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }catch(Exception e){
            GSLogger.error("显示BusinessFocus列表时发生错误：/business/businessFocusAd/list", e);
            e.printStackTrace();
        }
    }
    
    /**
	 * 撤回发布焦点图
	 * @param request
	 * @param businessBreak
	 * @return
	 */
	@RequestMapping(value="cancelFocusAdPublishState")
	public void cancelFocusAdPublishState(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="id") String id) {
		BusinessFocusAdQuery query = new BusinessFocusAdQuery();
		query.setFocusAdId(Integer.parseInt(id));
		BusinessFocusAd businessFocusAd = businessFocusAdService.findById(query.getFocusAdId());
		String json = "";
		try{
			ShiroUser shiroUser = CommonUtils.getUser();
			businessFocusAd.setState(1);  // 待发布
		    businessFocusAd.setSelectTime(new Timestamp(System.currentTimeMillis()));
		    
		    businessFocusAd.setAuditInfo("");
			businessFocusAd.setAuditorId(shiroUser.getUserId());
			businessFocusAd.setAuditorName(shiroUser.getUserName());
			businessFocusAdService.update(businessFocusAd);
			
			String state = "已撤回";
			BusinessOpertaion entity = new BusinessOpertaion(
					getUser().getUserId(), 
					getUser().getUserName(), 
					"focusAd", 
					"focusAd_cancle", 
					businessFocusAd.getFocusAdId(), 
					businessFocusAd.getTitle(), 
					state,
					request.getRemoteAddr());
			businessOpertaionService.save(entity);
			
			json = "{\"success\":\"true\",\"message\":\"撤回发布成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"true\",\"message\":\"撤回发布失败\"}"; 
			GSLogger.error("显示businessFocus列表时发生错误：/business/businessFocusAd/list", e);
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
	 * 发布/拒绝焦点图对象
	 * @param request
	 * @param businessFocus
	 * @return
	 */
	@RequestMapping(value="updateFocusAdState")
	public void updateFocusAdState(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="id") String id, @RequestParam(value="auditInfo") String auditInfo) {
		BusinessFocusAdQuery query = new BusinessFocusAdQuery();
		query.setFocusAdId(Integer.parseInt(id));
		BusinessFocusAd businessFocusAd = businessFocusAdService.findById(query.getFocusAdId());
		String json = "";
		try{
			if(!auditInfo.equals("")) {
				businessFocusAd.setState(3);  // 未通过
				businessFocusAd.setAuditInfo(auditInfo);
			} else {
				businessFocusAd.setState(0);  // 已发布
				businessFocusAd.setAuditInfo("");
			}
			businessFocusAd.setSelectTime(new Timestamp(System.currentTimeMillis()));
		    
			businessFocusAd.setAuditorId(getUser().getUserId());
			businessFocusAd.setAuditorName(getUser().getUserName());
			businessFocusAd.setAuditTime(new Timestamp(System.currentTimeMillis()));
		    
			businessFocusAdService.update(businessFocusAd);
			
			String state = "审核通过";
			BusinessOpertaion entity = new BusinessOpertaion(
					getUser().getUserId(), 
					getUser().getUserName(), 
					"focusAd", 
					"focusAd_auditor", 
					businessFocusAd.getFocusAdId(), 
					businessFocusAd.getTitle(), 
					state,
					request.getRemoteAddr());
			businessOpertaionService.save(entity);
			
			if(!auditInfo.equals("")) { json = "{\"success\":\"true\",\"message\":\"拒绝成功\"}"; } 
			else { json = "{\"success\":\"true\",\"message\":\"发布成功\"}"; }
		} catch(Exception e) {
			if(!auditInfo.equals("")) { json = "{\"success\":\"true\",\"message\":\"拒绝失败\"}"; } 
			else { json = "{\"success\":\"false\",\"message\":\"发布失败\"}"; }
			
			GSLogger.error("显示businessFocusAd列表时发生错误：/business/businessFocusAd/list", e);
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
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessFocusAdQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessFocusAd新增页时发生错误：/module/focus/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/focusad/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessFocusAd
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessFocusAdQuery query) {
		BusinessFocusAd businessFocusAd = new BusinessFocusAd();
		ShiroUser shiroUser = CommonUtils.getUser();
		String json = "";
		try{
		    businessFocusAd.setTitle(query.getTitle().replaceAll("(\r?\n()+)", "").replace("\"", ""));
		    businessFocusAd.setContent(query.getContent());
		    businessFocusAd.setPicUrl(query.getPicUrl());
		    businessFocusAd.setState(query.getState());
		    businessFocusAd.setPageUrl(query.getPageUrl());
		    
		    businessFocusAd.setSelectorId(shiroUser.getUserId());
		    businessFocusAd.setSelectorName(shiroUser.getUserName());
		    businessFocusAd.setSelectTime(new Timestamp(System.currentTimeMillis()));
		    businessFocusAd.setAuditorId(shiroUser.getUserId());
		    businessFocusAd.setAuditorName(shiroUser.getUserName());
		    businessFocusAd.setAuditTime(new Timestamp(System.currentTimeMillis()));
		    
		    businessFocusAd.setAuditInfo("");
		    businessFocusAd.setStartTime(query.getStartTime());
		    businessFocusAd.setEndTime(query.getEndTime());
		    businessFocusAd.setVisits(0);
		    businessFocusAd.setSupports(0);
		    
		    businessFocusAd.setSourceId(0);
		    businessFocusAd.setSourceType(5);	// 来源类型 5后台发布
		    businessFocusAd.setIshtml(1);  // 静态
		    businessFocusAd.setFocusAdScope(query.getFocusAdScopeInfo());
			businessFocusAdService.save(businessFocusAd);
			
			String state = "";
			if(businessFocusAd.getState() == 0) {
				state = "已发布";
			} else if(businessFocusAd.getState() == 1) {
				state = "未发布";
			} else if(businessFocusAd.getState() == 2) {
				state = "待审核";
			}
			BusinessOpertaion entity = new BusinessOpertaion(
					getUser().getUserId(), 
					getUser().getUserName(), 
					"focusAd", 
					"focusAd_save", 
					businessFocusAd.getFocusAdId(), 
					businessFocusAd.getTitle(), 
					state,
					request.getRemoteAddr());
			businessOpertaionService.save(entity);
			
			// 保存展示范围
			String focusSope = query.getFocusAdScope();
			String[] focusSopes = focusSope.split(",");
			for(int i=0;i<focusSopes.length;i++) {
				String[] scope = focusSopes[i].split(":");
				AppFocusAdScope appFocusAdScope = new AppFocusAdScope();
				appFocusAdScope.setFocusAdId(businessFocusAd.getFocusAdId());
				appFocusAdScope.setEstateId(Integer.parseInt(scope[0]));
				appFocusAdScope.setCreateTime(new Timestamp(System.currentTimeMillis()));
				appFocusAdScopeService.save(appFocusAdScope);
			}
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessFocusAd信息时发生错误：/business/businessFocusAd/save", e);
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
	public ModelAndView modify(BusinessFocusAdQuery query) {	
		BusinessFocusAd businessFocusAd=new BusinessFocusAd();
		ModelAndView mav = new ModelAndView("/module/focusad/modify");
		try{
			businessFocusAd = businessFocusAdService.findById(query.getFocusAdId());
			//保存展示范围
			Map paramMap = new HashMap();
			paramMap.put("focusAdId", businessFocusAd.getFocusAdId());
			List list = appFocusAdScopeService.findByMap(paramMap);
			StringBuilder sb = new StringBuilder();
			StringBuilder sbScope = new StringBuilder();
			if(list.size() > 0){
				for(int i=0;i<list.size();i++) {
					AppFocusAdScope appFocusAdScope = (AppFocusAdScope) list.get(i);
					sb.append(appFocusAdScope.getEstateId()+":"+appFocusAdScope.getEstateName()+",");
					sbScope.append(",").append(appFocusAdScope.getEstateId());
				}
				mav.addObject("scope", sb.toString().subSequence(0, sb.toString().length()-1));
				mav.addObject("scope1",  sbScope.toString().substring(1));
			}
		}catch(Exception e){
			GSLogger.error("进入businessFocus修改页时发生错误：/business/businessFocus/modify", e);
			e.printStackTrace();
		}
		mav.addObject("businessFocusAd", businessFocusAd);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessFocusAdQuery query) {
		BusinessFocusAd businessFocusAd = null;
		String json = "";
		try{
			ShiroUser shiroUser = CommonUtils.getUser();
		    businessFocusAd = businessFocusAdService.findById(query.getFocusAdId());
		    businessFocusAd.setTitle(query.getTitle().replaceAll("(\r?\n()+)", "").replace("\"", ""));
		    businessFocusAd.setPicUrl(query.getPicUrl());
		    businessFocusAd.setPageUrl(query.getPageUrl());
		    businessFocusAd.setState(query.getState());  
		    businessFocusAd.setAuditInfo("");
		    
		    businessFocusAd.setSelectTime(new Timestamp(System.currentTimeMillis()));
		    businessFocusAd.setFocusAdScope(query.getFocusAdScopeInfo());
		    businessFocusAd.setAuditorId(shiroUser.getUserId());
		    businessFocusAd.setAuditorName(shiroUser.getUserName());
		    businessFocusAd.setAuditTime(new Timestamp(System.currentTimeMillis()));
		    
			businessFocusAdService.update(businessFocusAd);
			
			String state = "";
			if(businessFocusAd.getState() == 0) {
				state = "已发布";
			} else if(businessFocusAd.getState() == 1) {
				state = "未发布";
			} else if(businessFocusAd.getState() == 2) {
				state = "待审核";
			}
			BusinessOpertaion entity = new BusinessOpertaion(
					getUser().getUserId(), 
					getUser().getUserName(), 
					"focusAd", 
					"focusAd_edit", 
					businessFocusAd.getFocusAdId(), 
					businessFocusAd.getTitle(), 
					state,
					request.getRemoteAddr());
			businessOpertaionService.save(entity);
			
			// 删除展示范围
			Map paramMap = new HashMap();
			paramMap.put("focusAdId", query.getFocusAdId());
			List scopeList = appFocusAdScopeService.findByMap(paramMap);
			for(int i=0;i<scopeList.size();i++){
				AppFocusAdScope appFocusAdScope = (AppFocusAdScope) scopeList.get(i);
				appFocusAdScopeService.delete(appFocusAdScope.getScopeId());
			}
			// 保存展示范围
			String focusAdSope = query.getFocusAdScope();
			String[] focusAdSopes = focusAdSope.split(",");
			for(int i=0;i<focusAdSopes.length;i++) {
				String[] scope = focusAdSopes[i].split(":");
				AppFocusAdScope appFocusAdScope = new AppFocusAdScope();
				appFocusAdScope.setFocusAdId(businessFocusAd.getFocusAdId());
				appFocusAdScope.setEstateId(Integer.parseInt(scope[0]));
				appFocusAdScope.setCreateTime(new Timestamp(System.currentTimeMillis()));
				appFocusAdScopeService.save(appFocusAdScope);
			}
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessFocusAd信息时发生错误：/business/businessFocusAd/update", e);
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
	public void delete(@RequestParam(value="id") String id, HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		BusinessFocusAd businessFocusAd = businessFocusAdService.findById(new Integer(id));
		try{
			if(id != null) {
				if(id.indexOf(',') > -1) {
					String[] ids = id.split(",");
					for(int i=0;i<ids.length;i++) {
						businessFocusAdService.delete(new Integer(ids[i]));
					}
				}else{
					businessFocusAdService.delete(new Integer(id));
					
					String state = "已删除";
					BusinessOpertaion entity = new BusinessOpertaion(
							getUser().getUserId(), 
							getUser().getUserName(), 
							"focusAd", 
							"focusAd_delete", 
							businessFocusAd.getFocusAdId(), 
							businessFocusAd.getTitle(), 
							state,
							request.getRemoteAddr());
					businessOpertaionService.save(entity);
					
					Map paramMap = new HashMap();
					paramMap.put("focusAdId", new Integer(id));
					List scopeList = appFocusAdScopeService.findByMap(paramMap);
					for(int i=0;i<scopeList.size();i++){
						AppFocusAdScope appFocusAdScope = (AppFocusAdScope) scopeList.get(i);
						appFocusAdScopeService.delete(appFocusAdScope.getScopeId());
					}
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessFocusAd时发生错误：/business/businessFocusAd/delete", e);
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