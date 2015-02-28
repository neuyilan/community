package com.community.app.module.controller;

import static com.community.framework.utils.CommonUtils.getUser;

import java.io.IOException;
import java.sql.Timestamp;
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

import com.community.app.module.bean.AppFocusScope;
import com.community.app.module.bean.BusinessFocus;
import com.community.app.module.bean.BusinessUserResource;
import com.community.app.module.bean.ShiroUser;
import com.community.app.module.common.CommunityBean;
import com.community.app.module.common.ModuleConst;
import com.community.app.module.service.AppFocusScopeService;
import com.community.app.module.service.BusinessCommunityService;
import com.community.app.module.service.BusinessFocusService;
import com.community.app.module.service.BusinessUserResourceService;
import com.community.app.module.service.ManageEstateService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessFocusQuery;
import com.community.framework.utils.CommonUtils;

@Controller
@RequestMapping("/business/businessFocus")
public class BusinessFocusController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessFocusController.class);
	@Autowired
	private BusinessFocusService businessFocusService;
	@Autowired
	private BusinessCommunityService businessCommunityService;
	@Autowired
	private ManageEstateService manageEstateService;
	@Autowired
	private AppFocusScopeService appFocusScopeService;
	@Autowired
	private BusinessUserResourceService businessUserResourceService;
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="list")
	public ModelAndView list(BusinessFocusQuery query) {		
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
			if (currentUser.isPermitted("focus_publish")) {  //新增焦点图功能展示会影响分页
				query.setRows(11);
			} else {  
				query.setRows(12);
			}
			baseBean = businessFocusService.findAllPage(query);
		}catch(Exception e){
			GSLogger.error("进入businessFocus管理页时发生错误：/business/businessFocus/list", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/focus/list");
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
	public void getPageList(BusinessFocusQuery query, HttpServletResponse response) {
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
			if (currentUser.isPermitted("focus_publish")) {  //新增焦点图功能展示会影响分页
				query.setRows(11);
			} else {  
				query.setRows(12);
			}
			BaseBean baseBean = businessFocusService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",");
			result.append("\"pageId\":").append(baseBean.getPager().getPageId()).append(",");
			if(CommonUtils.hasRole(ModuleConst.OPERATION_CODE)) {
				result.append("\"role\":").append("\"operation\"").append(",");
			 }
			result.append("\"pageCount\":").append(baseBean.getPager().getPageCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessFocus businessFocus = (BusinessFocus) baseBean.getList().get(i);
				result.append("{")
			    .append("\"focusId\":\"").append(businessFocus.getFocusId()).append("\"").append(",")
			    .append("\"title\":\"").append(businessFocus.getTitle()).append("\"").append(",")
			    .append("\"content\":\"").append(businessFocus.getContent().replace("\"", "\\\"")).append("\"").append(",")
			    .append("\"picUrl\":\"").append(businessFocus.getPicUrl()).append("\"").append(",")
			    .append("\"sourceType\":\"").append(businessFocus.getSourceType()).append("\"").append(",")
			    .append("\"sourceId\":\"").append(businessFocus.getSourceId()).append("\"").append(",")
			    .append("\"selectTime\":\"").append(businessFocus.getSelectTime()).append("\"").append(",")
			    .append("\"state\":\"").append(businessFocus.getState()).append("\"").append(",")
			    .append("\"pageUrl\":\"").append(businessFocus.getPageUrl()).append("\"").append(",")
			    .append("\"selectorId\":\"").append(businessFocus.getSelectorId()).append("\"").append(",")
			    .append("\"selectorName\":\"").append(businessFocus.getSelectorName()).append("\"").append(",")
			    .append("\"auditorId\":\"").append(businessFocus.getAuditorId()).append("\"").append(",")
			    .append("\"auditTime\":\"").append(businessFocus.getAuditTime()).append("\"").append(",")
			    .append("\"auditorName\":\"").append(businessFocus.getAuditorName()).append("\"").append(",")
			    .append("\"startTime\":\"").append(businessFocus.getStartTime()).append("\"").append(",")
			    .append("\"endTime\":\"").append(businessFocus.getEndTime()).append("\"").append(",")
			    .append("\"visits\":\"").append(businessFocus.getVisits()).append("\"").append(",")
			    .append("\"focusScope\":\"").append(businessFocus.getFocusScope()).append("\"").append(",")
			    .append("\"ishtml\":\"").append(businessFocus.getIshtml()).append("\"").append(",")
			    .append("\"supports\":\"").append(businessFocus.getSupports()).append("\"")
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
			GSLogger.error("显示businessFocus列表时发生错误：/business/businessFocus/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取用户展示的所有社区下的小区列表
	 * @param response
	 */
	@RequestMapping(value="getExpendScopeTree")
	public void getExpendScopeTree(HttpServletResponse response) {
		JSONObject jsonObj = new JSONObject();
		JSONArray comArr = new JSONArray();
		
		try{
			ShiroUser shiroUser = CommonUtils.getUser();
			// if(ModuleConst.OPERATION_CODE.equals(shiroUser.getOrgType())) {//驿站
			// List comList = businessCommunityService.findAll();
			Map map = new HashMap();
			//map.put("userId", shiroUser.getUserId());
			//map.put("orgType", shiroUser.getOrgType());
			//map.put("comId", shiroUser.getCurComId());
			
			//List comList = businessCommunityService.findComsByUser(map);
			List comList = shiroUser.getComList();
			JSONObject comObj = null;
			Map paramMap = null;
			for(int i=0;i<comList.size();i++) {
				//BusinessCommunity community = (BusinessCommunity) comList.get(i);
				CommunityBean community = (CommunityBean) comList.get(i);
				comObj = new JSONObject();
				paramMap = new HashMap();
				paramMap.put("comId", community.getComId());
				paramMap.put("userId", shiroUser.getUserId());
				//List estateList = manageEstateService.findByMap(paramMap);
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
						estateObj.put("checkbox", true);
						estateObj.put("state", "close");
						estateArr.add(estateObj);
					}
					comObj.put("children", estateArr);
					comArr.add(comObj);
				}				
			}
			// }
			jsonObj.put("success", true);
			jsonObj.put("result", comArr);
		}catch(Exception e){
			jsonObj.put("success", false);
			jsonObj.put("message", "获取失败");
			GSLogger.error("获取用户要扩散到的所有社区下的小区列表：/business/businessFocus/getExpendScopeTree", e);
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
     * 查询焦点图详情信息
     * @param query
     * @param response
     */
    @RequestMapping(value="getFocusDetail")
    public void getFocusDetail(BusinessFocusQuery query, HttpServletResponse response) {
        try{
        	BusinessFocus businessFocus = businessFocusService.findById(query.getFocusId());
        	JSONObject jsons= JSONObject.fromObject(businessFocus);
        	
            response.setHeader("Cache-Control", "no-cache");
            response.setCharacterEncoding("utf-8");
            try {
                response.getWriter().write(jsons.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }catch(Exception e){
            GSLogger.error("显示BusinessFocus列表时发生错误：/business/businessFocus/list", e);
            e.printStackTrace();
        }
    }
    
    /**
	 * 撤回发布焦点图
	 * @param request
	 * @param businessBreak
	 * @return
	 */
	@RequestMapping(value="cancelFocusPublishState")
	public void cancelFocusPublishState(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="id") String id) {
		BusinessFocusQuery query = new BusinessFocusQuery();
		query.setFocusId(Integer.parseInt(id));
		BusinessFocus businessFocus = businessFocusService.findById(query.getFocusId());
		String json = "";
		try{
			ShiroUser shiroUser = CommonUtils.getUser();
			businessFocus.setState(1);  // 待发布
		    businessFocus.setSelectTime(new Timestamp(System.currentTimeMillis()));
		    
		    businessFocus.setAuditInfo("");
			businessFocus.setAuditorId(shiroUser.getUserId());
			businessFocus.setAuditorName(shiroUser.getUserName());
			businessFocusService.update(businessFocus);
			
			json = "{\"success\":\"true\",\"message\":\"撤回发布成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"true\",\"message\":\"撤回发布失败\"}"; 
			GSLogger.error("显示businessFocus列表时发生错误：/business/businessFocus/list", e);
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
	@RequestMapping(value="updateFocusState")
	public void updateFocusState(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="id") String id, @RequestParam(value="auditInfo") String auditInfo) {
		BusinessFocusQuery query = new BusinessFocusQuery();
		query.setFocusId(Integer.parseInt(id));
		BusinessFocus businessFocus = businessFocusService.findById(query.getFocusId());
		String json = "";
		try{
			if(!auditInfo.equals("")) {
				businessFocus.setState(3);  // 未通过
				businessFocus.setAuditInfo(auditInfo);
			} else {
				businessFocus.setState(0);  // 已发布
				businessFocus.setAuditInfo("");
			}
		    businessFocus.setSelectTime(new Timestamp(System.currentTimeMillis()));
		    
			businessFocus.setAuditorId(getUser().getUserId());
			businessFocus.setAuditorName(getUser().getUserName());
			businessFocus.setAuditTime(new Timestamp(System.currentTimeMillis()));
		    
			businessFocusService.update(businessFocus);
			
			if(!auditInfo.equals("")) { json = "{\"success\":\"true\",\"message\":\"拒绝成功\"}"; } 
			else { json = "{\"success\":\"true\",\"message\":\"发布成功\"}"; }
		} catch(Exception e) {
			if(!auditInfo.equals("")) { json = "{\"success\":\"true\",\"message\":\"拒绝失败\"}"; } 
			else { json = "{\"success\":\"false\",\"message\":\"发布失败\"}"; }
			
			GSLogger.error("显示businessFocus列表时发生错误：/business/businessFocus/list", e);
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
	public ModelAndView add(BusinessFocusQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessFocus新增页时发生错误：/business/businessFocus/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/focus/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessFocus
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessFocusQuery query) {
		BusinessFocus businessFocus = new BusinessFocus();
	    ShiroUser shiroUser = CommonUtils.getUser();
		String json = "";
		try{
		    businessFocus.setTitle(query.getTitle());
		    businessFocus.setPicUrl(query.getPicUrl());
		    businessFocus.setState(query.getState());  
		    businessFocus.setPageUrl(query.getPageUrl());
		    businessFocus.setSourceType(5);	// 来源类型 5后台发布
		    businessFocus.setIshtml(1);  // 静态
		    businessFocus.setAuditInfo("");
		    
		    businessFocus.setFocusScope(query.getFocusScopeInfo());
		    businessFocus.setVisits(0);
		    businessFocus.setSupports(0);
		    
		    businessFocus.setSelectorId(shiroUser.getUserId());
		    businessFocus.setSelectorName(shiroUser.getUserName());
		    businessFocus.setSelectTime(new Timestamp(System.currentTimeMillis()));
		    businessFocus.setAuditorId(shiroUser.getUserId());
		    businessFocus.setAuditorName(shiroUser.getUserName());
		    businessFocus.setAuditTime(new Timestamp(System.currentTimeMillis()));
		    
		    businessFocus.setContent(query.getContent());
		    businessFocus.setStartTime(query.getStartTime());
		    businessFocus.setEndTime(query.getEndTime());
			businessFocusService.save(businessFocus);
			
			// 保存展示范围
			String focusSope = query.getFocusScope();
			String[] focusSopes = focusSope.split(",");
			for(int i=0;i<focusSopes.length;i++) {
				String[] scope = focusSopes[i].split(":");
				AppFocusScope appFocusScope = new AppFocusScope();
				appFocusScope.setFocusId(businessFocus.getFocusId());
				appFocusScope.setEstateId(Integer.parseInt(scope[0]));
				appFocusScope.setCreateTime(new Timestamp(System.currentTimeMillis()));
				appFocusScopeService.save(appFocusScope);
			}
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessFocus信息时发生错误：/business/businessFocus/save", e);
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
	public ModelAndView modify(BusinessFocusQuery query) {	
		BusinessFocus businessFocus=new BusinessFocus();
		ModelAndView mav = new ModelAndView("/module/focus/modify");
		try{
			businessFocus = businessFocusService.findById(query.getFocusId());
			//保存展示范围
			Map paramMap = new HashMap();
			paramMap.put("focusId", businessFocus.getFocusId());
			List list = appFocusScopeService.findByMap(paramMap);
			StringBuilder sb = new StringBuilder();
			if(list.size() > 0){
				for(int i=0;i<list.size();i++) {
					AppFocusScope appFocusScope = (AppFocusScope) list.get(i);
					sb.append(appFocusScope.getEstateId()+":"+appFocusScope.getEstateName()+",");
				}
				mav.addObject("scope", sb.toString().subSequence(0, sb.toString().length()-1));
			}
		}catch(Exception e){
			GSLogger.error("进入businessFocus修改页时发生错误：/business/businessFocus/modify", e);
			e.printStackTrace();
		}
		mav.addObject("businessFocus", businessFocus);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessFocusQuery query) {
		BusinessFocus businessFocus = null;
		String json = "";
		try{
		    ShiroUser shiroUser = CommonUtils.getUser();
		    businessFocus = businessFocusService.findById(query.getFocusId());
		    businessFocus.setTitle(query.getTitle());
		    businessFocus.setPicUrl(query.getPicUrl());
		    businessFocus.setPageUrl(query.getPageUrl());
		    businessFocus.setState(query.getState());  
		    businessFocus.setAuditInfo("");
		    
		    businessFocus.setSelectTime(new Timestamp(System.currentTimeMillis()));
		    businessFocus.setFocusScope(query.getFocusScopeInfo());
		    businessFocus.setAuditorId(shiroUser.getUserId());
		    businessFocus.setAuditorName(shiroUser.getUserName());
		    businessFocus.setAuditTime(new Timestamp(System.currentTimeMillis()));
		    
			businessFocusService.update(businessFocus);
			
			// 删除展示范围
			Map paramMap = new HashMap();
			paramMap.put("focusId", query.getFocusId());
			List scopeList = appFocusScopeService.findByMap(paramMap);
			for(int i=0;i<scopeList.size();i++){
				AppFocusScope appFocusScope = (AppFocusScope) scopeList.get(i);
				appFocusScopeService.delete(appFocusScope.getScopeId());
			}
			// 保存展示范围
			String focusSope = query.getFocusScope();
			String[] focusSopes = focusSope.split(",");
			for(int i=0;i<focusSopes.length;i++) {
				String[] scope = focusSopes[i].split(":");
				AppFocusScope appFocusScope = new AppFocusScope();
				appFocusScope.setFocusId(businessFocus.getFocusId());
				appFocusScope.setEstateId(Integer.parseInt(scope[0]));
				appFocusScope.setCreateTime(new Timestamp(System.currentTimeMillis()));
				appFocusScopeService.save(appFocusScope);
			}
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessFocus信息时发生错误：/business/businessFocus/update", e);
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
						businessFocusService.delete(new Integer(ids[i]));
					}
				}else{
					businessFocusService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessFocus时发生错误：/business/businessFocus/delete", e);
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