package com.community.app.module.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.community.app.module.bean.AppFocusScope;
import com.community.app.module.bean.AppHomepage;
import com.community.app.module.bean.AppHomepageScope;
import com.community.app.module.bean.AppLatestNews;
import com.community.app.module.bean.AppPushLog;
import com.community.app.module.bean.AppUser;
import com.community.app.module.bean.AppUserConfig;
import com.community.app.module.bean.AppUserNews;
import com.community.app.module.bean.BusinessAnnoScope;
import com.community.app.module.bean.BusinessFocus;
import com.community.app.module.bean.BusinessPosition;
import com.community.app.module.bean.BusinessStation;
import com.community.app.module.bean.BusinessUserResource;
import com.community.app.module.bean.ManageEstate;
import com.community.app.module.bean.ShiroUser;
import com.community.framework.utils.CommonUtils;
import com.community.framework.utils.Uploader;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.community.app.module.vo.BaseBean;
import com.community.app.module.bean.BusinessAnno;
import com.community.app.module.common.EstateBean;
import com.community.app.module.common.ModuleConst;
import com.community.app.module.push.AppPushNotificationUtil;
import com.community.app.module.service.AppEstateUserService;
import com.community.app.module.service.AppFocusScopeService;
import com.community.app.module.service.AppHomepageScopeService;
import com.community.app.module.service.AppHomepageService;
import com.community.app.module.service.AppLatestNewsService;
import com.community.app.module.service.AppPushLogService;
import com.community.app.module.service.AppUserConfigService;
import com.community.app.module.service.AppUserNewsService;
import com.community.app.module.service.AppUserService;
import com.community.app.module.service.BusinessAnnoScopeService;
import com.community.app.module.service.BusinessAnnoService;
import com.community.app.module.service.BusinessFocusService;
import com.community.app.module.service.BusinessPositionService;
import com.community.app.module.service.BusinessStationService;
import com.community.app.module.service.ManageBuildingService;
import com.community.app.module.service.ManageEstateService;
import com.community.app.module.vo.BusinessAnnoQuery;

import static com.community.framework.utils.CommonUtils.*;

@Controller
@RequestMapping("/business/businessAnno")
public class BusinessAnnoController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessAnnoController.class);
	@Autowired
	private BusinessAnnoService businessAnnoService;
	@Autowired
	private BusinessPositionService businessPositionService;
	@Autowired
	private ManageEstateService manageEstateService;
	@Autowired
	private ManageBuildingService manageBuildingService;
	@Autowired
	private BusinessAnnoScopeService businessAnnoScopeService;
	@Autowired
	private BusinessFocusService businessFocusService;
	@Autowired
	private AppEstateUserService appEstateUserService;
	@Autowired
	private AppHomepageService appHomepageService;
	@Autowired
	private AppHomepageScopeService appHomepageScopeService;
	@Autowired
	private AppUserService appUserService;
	@Autowired
	private AppPushLogService appPushLogService;
	@Autowired
	private BusinessStationService businessStationService;
	@Autowired
	private AppFocusScopeService appFocusScopeService;
	@Autowired
	private AppUserNewsService appUserNewsService;
	@Autowired
	private AppLatestNewsService appLatestNewsService;
	@Autowired
	private AppUserConfigService appUserConfigService;
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="list")
	public ModelAndView list(HttpServletRequest request, BusinessAnnoQuery query) {
        BaseBean baseBean = new BaseBean();
        String orgType = "";
		try{
			ShiroUser shiroUser = CommonUtils.getUser();
			if(shiroUser.getCurOrgType() != null && !"".equals(shiroUser.getCurOrgType())) {
				orgType = shiroUser.getCurOrgType();
			}else{
				orgType = shiroUser.getOrgType();
			}
			if(ModuleConst.PROPERTY_CODE.equals(orgType)) {//物业人员 获取小区ID 设置公告类型
				if(!ModuleConst.OPERATION_CODE.equals(shiroUser.getOrgType())) { //当前访问人不是运营是物业
					query.setCurUserId(shiroUser.getUserId());
				}	
				if(shiroUser.getCurEstateId() != null && shiroUser.getCurEstateId() != 0) {
					query.setCurEstateId(shiroUser.getCurEstateId());
				}
				query.setOrgType(ModuleConst.PROPERTY_CODE);
				Integer[] types = {0,1};
				query.setAnnoTypes(types);//0:物业通知类公告 1:物业信息传达类公告
			}else if(ModuleConst.STATION_CODE.equals(orgType)) {//驿站人员 获取小区ID 设置公告类型
				if(!ModuleConst.OPERATION_CODE.equals(shiroUser.getOrgType())) { //当前访问人不是运营是物业
					query.setCurUserId(shiroUser.getUserId());
				}
				if(shiroUser.getCurEstateId() != null && shiroUser.getCurEstateId() != 0) {
					query.setCurEstateId(shiroUser.getCurEstateId());
				}
				Integer[] types = {4};
				query.setAnnoTypes(types);// 4:驿站公告
			}if(ModuleConst.OPERATION_CODE.equals(orgType)) {//运营人员 设置公告类型
				if(shiroUser.getCurEstateId() != null && shiroUser.getCurEstateId() != 0) {
					query.setCurEstateId(shiroUser.getCurEstateId());
				}
				Integer[] types = {2,3};
				query.setAnnoTypes(types);// 2:运营内容公告 3:运营外部公告
			}
			if((query.getSort() == null || "".equals(query.getSort())) && (query.getSort() == null || "".equals(query.getSort()))) {
				query.setSort("editTime");
			}			
			query.setOrder("desc");
			Subject currentUser = SecurityUtils.getSubject();  
			if (currentUser.isPermitted("anno_add_anno")) {  //新增公告功能展示会影响分页
				query.setRows(11);
			} else {  
				query.setRows(12);
			}
			
			baseBean = businessAnnoService.findAllPage(query);
		}catch(Exception e){
			GSLogger.error("进入businessAnno管理页时发生错误：/business/businessAnno/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/anno/list");
		mav.addObject("baseBean", baseBean);
		mav.addObject("pager", baseBean.getPager());
		mav.addObject("publishState", query.getPublishState());
		mav.addObject("sort", query.getSort());
		mav.addObject("orgType", orgType);
		mav.addObject("timeScope", query.getTimeScope());
		return mav;
	}
	
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="getPageList")
	public void getPageList(BusinessAnnoQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			ShiroUser shiroUser = CommonUtils.getUser();
			String orgType = "";
			if(shiroUser.getCurOrgType() != null && !"".equals(shiroUser.getCurOrgType())) {
				orgType = shiroUser.getCurOrgType();
			}else{
				orgType = shiroUser.getOrgType();
			}
			if(ModuleConst.PROPERTY_CODE.equals(orgType)) {//物业人员 获取小区ID 设置公告类型
				if(!ModuleConst.OPERATION_CODE.equals(shiroUser.getOrgType())) { //当前访问人不是运营是物业
					query.setCurUserId(shiroUser.getUserId());
				}
				if(shiroUser.getCurEstateId() != null && shiroUser.getCurEstateId() != 0) {
					query.setCurEstateId(shiroUser.getCurEstateId());
				}
				query.setOrgType(ModuleConst.PROPERTY_CODE);
				Integer[] types = {0,1};
				query.setAnnoTypes(types);//0:物业通知类公告 1:物业信息传达类公告
			}else if(ModuleConst.STATION_CODE.equals(orgType)) {//驿站人员 获取小区ID 设置公告类型
				if(!ModuleConst.OPERATION_CODE.equals(shiroUser.getOrgType())) { //当前访问人不是运营是物业
					query.setCurUserId(shiroUser.getUserId());
				}
				if(shiroUser.getCurEstateId() != null && shiroUser.getCurEstateId() != 0) {
					query.setCurEstateId(shiroUser.getCurEstateId());
				}
				Integer[] types = {4};
				query.setAnnoTypes(types);// 4:驿站公告
			}if(ModuleConst.OPERATION_CODE.equals(orgType)) {//运营人员 设置公告类型
				if(shiroUser.getCurEstateId() != null && shiroUser.getCurEstateId() != 0) {
					query.setCurEstateId(shiroUser.getCurEstateId());
				}
				Integer[] types = {2,3};
				query.setAnnoTypes(types);// 2:运营内容公告 3:系统公告
			}
			query.setOrder("desc");
			if(!("").equals(query.getOrderBy()) && query.getOrderBy() != null) {
				query.setSort(query.getOrderBy());
			}else{
				query.setSort("editTime");
			}
			Subject currentUser = SecurityUtils.getSubject();  
			if (currentUser.isPermitted("anno_add_anno")) {  //新增公告功能展示会影响分页
				query.setRows(11);
			} else {  
				query.setRows(12);
			}
			BaseBean baseBean = businessAnnoService.findAllPage(query);
			//result.append("{\"total\":\"").append(baseBean.getCount()+"_"+baseBean.getPager().getPageCount()).append("\",");
			result.append("{\"total\":").append(baseBean.getCount()).append(",");
			result.append("\"pageId\":").append(baseBean.getPager().getPageId()).append(",");
			result.append("\"pageCount\":").append(baseBean.getPager().getPageCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessAnno businessAnno = (BusinessAnno) baseBean.getList().get(i);
				result.append("{")
			    .append("\"annoId\":\"").append(businessAnno.getAnnoId()).append("\"").append(",")
			    .append("\"annoTitle\":\"").append(businessAnno.getAnnoTitle()).append("\"").append(",")
			    .append("\"brief\":\"").append(businessAnno.getBrief()).append("\"").append(",")
			    .append("\"annoContent\":\"").append(businessAnno.getAnnoContent().replace("\"", "\\\"")).append("\"").append(",")
			    .append("\"annoType\":\"").append(businessAnno.getAnnoType()).append("\"").append(",")
			    .append("\"annoScope\":\"").append(businessAnno.getAnnoScope()).append("\"").append(",")
			    .append("\"annoScopeInfo\":\"").append(businessAnno.getAnnoScopeInfo()).append("\"").append(",")
			    .append("\"annoPic\":\"").append(businessAnno.getAnnoPic()).append("\"").append(",")
			    .append("\"userLevel\":\"").append(businessAnno.getUserLevel()).append("\"").append(",")
			    .append("\"publisherId\":\"").append(businessAnno.getPublisherId()).append("\"").append(",")
			    .append("\"publisherName\":\"").append(businessAnno.getPublisherName()).append("\"").append(",")
			    .append("\"publishTime\":\"").append(businessAnno.getPublishTime()).append("\"").append(",")
			    .append("\"publishState\":\"").append(businessAnno.getPublishState()).append("\"").append(",")
			    .append("\"auditorId\":\"").append(businessAnno.getAuditorId()).append("\"").append(",")
			    .append("\"auditorName\":\"").append(businessAnno.getAuditorName()).append("\"").append(",")
			    .append("\"auditTime\":\"").append(businessAnno.getAuditTime()).append("\"").append(",")
			    .append("\"setTime\":\"").append(businessAnno.getSetTime()).append("\"").append(",")
			    .append("\"isPush\":\"").append(businessAnno.getIsPush()).append("\"").append(",")
			    .append("\"isRecommend\":\"").append(businessAnno.getIsRecommend()).append("\"").append(",")
			    .append("\"isImportant\":\"").append(businessAnno.getIsImportant()).append("\"").append(",")
			    .append("\"isRemind\":\"").append(businessAnno.getIsRemind()).append("\"").append(",")
			    .append("\"visits\":\"").append(businessAnno.getVisits()).append("\"").append(",")
			    .append("\"supports\":\"").append(businessAnno.getSupports()).append("\"").append(",")
			    .append("\"comments\":\"").append(businessAnno.getComments()).append("\"").append(",")
			    .append("\"annoState\":\"").append(businessAnno.getAnnoState()).append("\"").append(",")
			    .append("\"delMemo\":\"").append(businessAnno.getDelMemo()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessAnno.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessAnno.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessAnno.getEditor()).append("\"")
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
			GSLogger.error("显示businessAnno列表时发生错误：/business/businessAnno/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessAnnoQuery query) {		
		ModelAndView mav = null;
		try{
		}catch(Exception e){
			GSLogger.error("进入businessAnno新增页时发生错误：/business/businessAnno/add", e);
			e.printStackTrace();
		}
		ShiroUser shiroUser = CommonUtils.getUser();
		if(shiroUser.getOrgType().equals(ModuleConst.PROPERTY_CODE)) {//物业
			mav = new ModelAndView("/module/anno/propAdd");
		}else if(shiroUser.getOrgType().equals(ModuleConst.STATION_CODE)) {//驿站
			mav = new ModelAndView("/module/anno/stationAdd");
		}if(shiroUser.getOrgType().equals(ModuleConst.OPERATION_CODE)) {//运营
			mav = new ModelAndView("/module/anno/operationAdd");
		}
		return mav;
	}
	
	/**
	 * 保存物业公告对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="savePropAnno")
	public void savePropAnno(HttpServletRequest request, HttpServletResponse response, BusinessAnnoQuery query) {
        int userid = CommonUtils.getUser().getUserId();
        String username = CommonUtils.getUser().getUserName();
		BusinessAnno businessAnno = new BusinessAnno();
		String json = "";
		try{
			ShiroUser shiroUser = getUser();
			// 获取用户所在物业管理的小区
			List estateList = shiroUser.getEstateList();
			ManageEstate manageEstate = (ManageEstate) estateList.get(0);
            businessAnno.setPublisherId(userid);
            businessAnno.setPublisherName(username);
		    businessAnno.setAnnoTitle(query.getAnnoTitle());
		    businessAnno.setBrief(query.getBrief());
		    businessAnno.setAnnoContent(query.getAnnoContent());
		    businessAnno.setAnnoType(query.getAnnoType());
		    businessAnno.setAnnoScope(manageEstate.getEstateId().toString());
		    businessAnno.setAnnoBuilding(query.getAnnoBuilding());
		    businessAnno.setAnnoScopeInfo(query.getAnnoScopeInfo());
		    businessAnno.setAnnoPic(query.getAnnoPic());
		    businessAnno.setAppPic(query.getAppPic());
		    businessAnno.setPublishTime(new Timestamp(System.currentTimeMillis()));
		    businessAnno.setPublishState(query.getPublishState());
		    businessAnno.setSetTime(query.getSetTime());
		    businessAnno.setIsImportant(query.getIsImportant()==null?0:query.getIsImportant());
		    if(query.getSetTime() != null && !"".equals(query.getSetTime())) {
		    	businessAnno.setIsRemind(1); // 需要提醒
		    }
		    businessAnno.setVisits(0);
		    businessAnno.setSupports(0);
		    businessAnno.setComments(0);
		    businessAnno.setAnnoState(0);
		    businessAnno.setCreateTime(new Timestamp(System.currentTimeMillis()));
		    businessAnno.setEditTime(new Timestamp(System.currentTimeMillis()));
		    businessAnno.setEditor(username);
			businessAnnoService.save(businessAnno);
			// 保存发布范围
			String annoSope = query.getAnnoBuilding();
			String[] annoScopes = annoSope.split(",");
			for(int i=0;i<annoScopes.length;i++) {
				String[] scope = annoScopes[i].split(":");
				BusinessAnnoScope businessAnnoScope = new BusinessAnnoScope();
				businessAnnoScope.setAnnoId(businessAnno.getAnnoId());
				businessAnnoScope.setProId(shiroUser.getOrgId());
				businessAnnoScope.setEstateId(new Integer(scope[0]));
				businessAnnoScope.setEstateName(scope[1]);
				businessAnnoScope.setCreateTime(new Timestamp(System.currentTimeMillis()));
				businessAnnoScopeService.save(businessAnnoScope);
			}
			//发布状态
			if(businessAnno.getPublishState() == 0) {
				// 发布到首页
				AppHomepage appHomepage = new AppHomepage();
				appHomepage.setId(businessAnno.getAnnoId());
				appHomepage.setTitle(businessAnno.getAnnoTitle());
				appHomepage.setBrief(businessAnno.getBrief());
				appHomepage.setPic(businessAnno.getAppPic());
				
				if(businessAnno.getAnnoType() == 0) {  // 物业通知类公告
					appHomepage.setType(3);  // 3物业通知
				} else if(businessAnno.getAnnoType() == 1){ // 物业信息传达类公告
					appHomepage.setType(2);	// 2物业公告
				}
				
				appHomepage.setPublishTime(new Timestamp(System.currentTimeMillis()));
				appHomepage.setTop(businessAnno.getIsImportant());
				appHomepageService.save(appHomepage);
				
				for(int i=0;i<annoScopes.length;i++) {
                 	String[] estate = annoScopes[i].split(":");
                 	AppHomepageScope appHomepageScope = new AppHomepageScope();
     				appHomepageScope.setHomePageId(appHomepage.getHomePageId());
     				appHomepageScope.setId(new Integer(estate[0])); //小区id
     				appHomepageScope.setCreateTime(new Timestamp(System.currentTimeMillis()));
     				appHomepageScopeService.save(appHomepageScope);
                 }
			
				
				//重要通知向小区内的所有居民发送公告
				if(businessAnno.getIsImportant() == 1 && annoScopes.length > 0) {
					for(int i=0;i<annoScopes.length;i++) {
						String[] scope = annoScopes[i].split(":");
						Integer estateId = new Integer(scope[0]);
						//查询该小区下的userId, baiduId, channelId
						List appUserList = appUserService.findUserPushIds(estateId);
						AppPushLog appPushLog = new AppPushLog();
						String title = "OK家";
						String description = "【物业】"+businessAnno.getAnnoTitle();
						
						Map paramMap = new HashMap();
						paramMap.put("messageType", 1);
						paramMap.put("ID", businessAnno.getAnnoId());
						paramMap.put("title", businessAnno.getAnnoTitle());
						paramMap.put("pic", businessAnno.getAppPic());
						
						for(int j=0;j<appUserList.size();j++) {
							AppUser appUser = (AppUser) appUserList.get(j);
							//System.out.println("name  "+appUser.getRealname() + "baiudId   "+appUser.getBaiduId());
							if(appUser.getBaiduId() != null && !"".equals(appUser.getBaiduId()) && appUser.getChannelId() != null && !"".equals(appUser.getChannelId())) {
								//物业通知(通过PC后台，"重要通知")
								Integer success = AppPushNotificationUtil.pushNotification(
										title, 
										description, 
										appUser.getDeviceType(),
										Long.valueOf(appUser.getChannelId()).longValue(), 
										appUser.getBaiduId(),
										paramMap
										);
								//记录推送日志
								appPushLog.setUserId(appUser.getUserId());
							    appPushLog.setUserName(appUser.getRealname());
							    appPushLog.setBaiduId(appUser.getBaiduId());
							    appPushLog.setChannelId(appUser.getChannelId());
							    appPushLog.setTitle(title);
							    appPushLog.setDescription(description);
							    appPushLog.setSendTime(new Timestamp(System.currentTimeMillis()));
							    appPushLog.setSendState(success);
							    appPushLog.setSenderId(shiroUser.getUserId());
							    appPushLog.setSenderName(shiroUser.getUserName());
								appPushLogService.save(appPushLog);
							}							
						}
					}
				}
			}
			
			// 保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessAnno信息时发生错误：/business/businessAnno/savePropAnno", e);
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
	 * 编辑物业公告对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="updatePropAnno")
	public void updatePropAnno(HttpServletRequest request, HttpServletResponse response, BusinessAnnoQuery query) {
        int userid = CommonUtils.getUser().getUserId();
        String username = CommonUtils.getUser().getUserName();
		BusinessAnno businessAnno = new BusinessAnno();
		String json = "";
		try{
			businessAnno = businessAnnoService.findById(query.getAnnoId());
			ShiroUser shiroUser = getUser();
			//获取用户所在物业管理的小区
			List estateList = shiroUser.getEstateList();
			ManageEstate manageEstate = (ManageEstate) estateList.get(0);
            businessAnno.setPublisherId(shiroUser.getUserId());
            businessAnno.setPublisherName(shiroUser.getUserName());
		    businessAnno.setAnnoTitle(query.getAnnoTitle());
		    businessAnno.setBrief(query.getBrief());
		    if(query.getAnnoContent() != null && !"".equals(query.getAnnoContent())) {
		    	businessAnno.setAnnoContent(query.getAnnoContent());
		    }
		    businessAnno.setIsImportant(query.getIsImportant()==null?0:query.getIsImportant());
		    businessAnno.setAnnoType(query.getAnnoType());
		    businessAnno.setAnnoScope(manageEstate.getEstateId().toString());
		    businessAnno.setAnnoBuilding(query.getAnnoBuilding());
		    businessAnno.setAnnoScopeInfo(query.getAnnoScopeInfo());
		    String path = request.getContextPath();
		    String ctx = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
		    if(query.getAnnoPic() != null && !query.getAnnoPic().equals("")) {
		    	File file = new File(ctx + businessAnno.getAnnoPic());
		    	if(file.exists()) {
		    		file.delete();
		    	}
		    	businessAnno.setAnnoPic(query.getAnnoPic());
		    }
		    if(query.getAppPic() != null && !query.getAppPic().equals("")) {
		    	File file = new File(ctx + businessAnno.getAppPic());
		    	if(file.exists()) {
		    		file.delete();
		    	}
		    	businessAnno.setAppPic(query.getAppPic());
		    }
		    //businessAnno.setUserLevel(query.getUserLevel());
		    if(query.getPublishState() != null && query.getPublishState() == 0) {
		    	businessAnno.setPublishTime(new Timestamp(System.currentTimeMillis()));
		    	businessAnno.setPublishState(query.getPublishState());
		    	businessAnno.setPublisherId(CommonUtils.getUser().getUserId());
		    	businessAnno.setPublisherName(CommonUtils.getUser().getUserName());
		    }else{
		    	businessAnno.setPublishState(query.getPublishState());
		    }
		    
		    if(query.getSetTime() != null && !"".equals(query.getSetTime())) {
		    	businessAnno.setSetTime(query.getSetTime());
		    	businessAnno.setIsRemind(1);//需要提醒
		    }		    
		    businessAnno.setIsImportant(query.getIsImportant());
		    businessAnno.setEditTime(new Timestamp(System.currentTimeMillis()));
		    businessAnno.setEditor(username);
			businessAnnoService.update(businessAnno);
			//保存发布范围
			Map paramMap = new HashMap();
			paramMap.put("annoId", query.getAnnoId());
			List scopeList = businessAnnoScopeService.findByMap(paramMap);
			for(int i=0;i<scopeList.size();i++){
				BusinessAnnoScope scope = (BusinessAnnoScope) scopeList.get(i);
				businessAnnoScopeService.delete(scope.getAnnoId());
			}
			//保存发布范围
			String annoSope = query.getAnnoBuilding();
			String[] annoScopes = annoSope.split(",");
			for(int i=0;i<annoScopes.length;i++) {
				String[] scope = annoScopes[i].split(":");
				BusinessAnnoScope businessAnnoScope = new BusinessAnnoScope();
				businessAnnoScope.setAnnoId(businessAnno.getAnnoId());
				businessAnnoScope.setProId(shiroUser.getOrgId());
				businessAnnoScope.setEstateId(new Integer(scope[0]));
				businessAnnoScope.setEstateName(scope[1]);
				businessAnnoScope.setCreateTime(new Timestamp(System.currentTimeMillis()));
				businessAnnoScopeService.save(businessAnnoScope);
			}
			
			//发布状态
			if(businessAnno.getPublishState() == 0) {
				//发布到首页
				AppHomepage appHomepage = new AppHomepage();
				appHomepage.setId(businessAnno.getAnnoId());
				appHomepage.setTitle(businessAnno.getAnnoTitle());
				appHomepage.setBrief(businessAnno.getBrief());
				appHomepage.setPic(businessAnno.getAppPic());
				
				if(businessAnno.getAnnoType() == 0) {  // 物业通知类公告
					appHomepage.setType(3);  // 3物业通知
				} else if(businessAnno.getAnnoType() == 1){ // 物业信息传达类公告
					appHomepage.setType(2);	// 2物业公告
				}
				
				appHomepage.setPublishTime(new Timestamp(System.currentTimeMillis()));
				appHomepage.setTop(businessAnno.getIsImportant());
				appHomepageService.save(appHomepage);
				
				for(int i=0;i<annoScopes.length;i++) {
                 	String[] estate = annoScopes[i].split(":");
                 	AppHomepageScope appHomepageScope = new AppHomepageScope();
     				appHomepageScope.setHomePageId(appHomepage.getHomePageId());
     				appHomepageScope.setId(new Integer(estate[0])); //小区id
     				appHomepageScope.setCreateTime(new Timestamp(System.currentTimeMillis()));
     				appHomepageScopeService.save(appHomepageScope);
                 }
				
				//重要通知向小区内的所有居民发送公告
				if(businessAnno.getIsImportant() == 1 && annoScopes.length > 0) {
					for(int i=0;i<annoScopes.length;i++) {
						String[] scope = annoScopes[i].split(":");
						Integer estateId = new Integer(scope[0]);
						//查询该小区下的userId, baiduId, channelId
						List appUserList = appUserService.findUserPushIds(estateId);
						AppPushLog appPushLog = new AppPushLog();
						String title = "OK家";
						String description = "【物业】"+businessAnno.getAnnoTitle();
						
						paramMap = new HashMap();
						paramMap.put("messageType", 1);
						paramMap.put("ID", businessAnno.getAnnoId());
						paramMap.put("title", businessAnno.getAnnoTitle());
						paramMap.put("pic", businessAnno.getAppPic());
						
						for(int j=0;j<appUserList.size();j++) {
							AppUser appUser = (AppUser) appUserList.get(j);
							if(appUser.getBaiduId() != null && !"".equals(appUser.getBaiduId()) && appUser.getChannelId() != null && !"".equals(appUser.getChannelId())) {
								Integer success = AppPushNotificationUtil.pushNotification(
										title, 
										description, 
										appUser.getDeviceType(),
										Long.valueOf(appUser.getChannelId()).longValue(), 
										appUser.getBaiduId(),
										paramMap
										);
								//记录推送日志
								appPushLog.setUserId(appUser.getUserId());
							    appPushLog.setUserName(appUser.getRealname());
							    appPushLog.setBaiduId(appUser.getBaiduId());
							    appPushLog.setChannelId(appUser.getChannelId());
							    appPushLog.setTitle(title);
							    appPushLog.setDescription(description);
							    appPushLog.setSendTime(new Timestamp(System.currentTimeMillis()));
							    appPushLog.setSendState(success);
							    appPushLog.setSenderId(shiroUser.getUserId());
							    appPushLog.setSenderName(shiroUser.getUserName());
								appPushLogService.save(appPushLog);
							}
						}
					}
				}
			}

			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessAnno信息时发生错误：/business/businessAnno/savePropAnno", e);
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
	 * 保存驿站公告对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="saveStationAnno")
	public void saveStationAnno(HttpServletRequest request, HttpServletResponse response, BusinessAnnoQuery query) {
        int userid = CommonUtils.getUser().getUserId();
        String username = CommonUtils.getUser().getUserName();
		BusinessAnno businessAnno = new BusinessAnno();
		String json = "";
		try{
			ShiroUser shiroUser = getUser();
			List estateList = shiroUser.getEstateList();
			ManageEstate manageEstate = (ManageEstate) estateList.get(0);
            businessAnno.setPublisherId(userid);
            businessAnno.setAnnoScope(String.valueOf(manageEstate.getEstateId()));
            businessAnno.setAnnoBuilding(query.getAnnoBuilding());
            businessAnno.setAnnoScopeInfo(query.getAnnoScopeInfo());
            businessAnno.setPublisherName(username);
		    businessAnno.setAnnoTitle(query.getAnnoTitle());
		    businessAnno.setBrief(query.getBrief());
		    businessAnno.setAnnoContent(query.getAnnoContent());
		    businessAnno.setAnnoType(4);//驿站公告
		    //businessAnno.setAnnoScopeInfo(manageEstate.getEstateName());
		    businessAnno.setAnnoPic(query.getAnnoPic());
		    businessAnno.setAppPic(query.getAppPic());
		    //businessAnno.setUserLevel(query.getUserLevel());
		    businessAnno.setPublishTime(new Timestamp(System.currentTimeMillis()));
		    businessAnno.setPublishState(query.getPublishState());
		    businessAnno.setIsRecommend(query.getIsRecommend());
		    //businessAnno.setAuditorId(query.getAuditorId());
		    //businessAnno.setAuditorName(query.getAuditorName());
		    //businessAnno.setAuditTime(query.getAuditTime());
		    //businessAnno.setSetTime(query.getSetTime());
		    businessAnno.setIsPush(query.getIsPush());
		    businessAnno.setIsImportant(query.getIsImportant() == null?0:query.getIsImportant());
		    //if(query.getSetTime() != null && !"".equals(query.getSetTime())) {
		    // businessAnno.setIsRemind(1);//需要提醒
		    //}
		    businessAnno.setVisits(0);
		    businessAnno.setSupports(0);
		    businessAnno.setComments(0);
		    businessAnno.setAnnoState(0);
		    //businessAnno.setDelMemo(query.getDelMemo());
		    businessAnno.setCreateTime(new Timestamp(System.currentTimeMillis()));
		    businessAnno.setEditTime(new Timestamp(System.currentTimeMillis()));
		    businessAnno.setEditor(username);
			businessAnnoService.save(businessAnno);
			
			//保存发布范围
			String annoSope = query.getAnnoBuilding();
			String[] annoScopes = annoSope.split(",");
			for(int i=0;i<annoScopes.length;i++) {
				String[] scope = annoScopes[i].split(":");
				BusinessAnnoScope businessAnnoScope = new BusinessAnnoScope();
				businessAnnoScope.setAnnoId(businessAnno.getAnnoId());
				businessAnnoScope.setProId(shiroUser.getOrgId());
				businessAnnoScope.setEstateId(new Integer(scope[0]));
				businessAnnoScope.setEstateName(scope[1]);
				businessAnnoScope.setCreateTime(new Timestamp(System.currentTimeMillis()));
				businessAnnoScopeService.save(businessAnnoScope);
			}
			
			//发布状态
			if(query.getIsRecommend() != null && businessAnno.getPublishState() == 0) {
				if(query.getIsRecommend() == 1) {
					BusinessFocus businessFocus = new BusinessFocus();
					businessFocus.setTitle(businessAnno.getAnnoTitle());
				    businessFocus.setState(2);   // 待审核
				    businessFocus.setPicUrl(businessAnno.getAnnoPic());
				    businessFocus.setPageUrl("");
				    businessFocus.setSourceId(businessAnno.getAnnoId());
				    businessFocus.setSourceType(2);	// 来源类型
				    businessFocus.setIshtml(0);  // 静态
				    businessFocus.setAuditInfo("");
				    businessFocus.setFocusScope(businessAnno.getAnnoScopeInfo());  //展示范围
				    businessFocus.setVisits(0);
				    businessFocus.setSupports(0);
				    businessFocus.setSelectorId(shiroUser.getUserId());
				    businessFocus.setSelectorName(shiroUser.getUserName());
				    businessFocus.setSelectTime(new Timestamp(System.currentTimeMillis()));
				    
					businessFocusService.save(businessFocus);
					
					AppFocusScope appFocusScope = new AppFocusScope();
					for(int i=0; i<annoScopes.length; i++) {
						  String[] scope = annoScopes[i].split(":");
						  appFocusScope.setFocusId(businessFocus.getFocusId());
						  appFocusScope.setEstateId(new Integer(scope[0]));
						  appFocusScope.setCreateTime(new Timestamp(System.currentTimeMillis()));
						  appFocusScopeService.save(appFocusScope);
					}
				} 
				
				//执行推送接口
				//重要通知向小区内的所有居民发送公告
				if(businessAnno.getIsPush() != null && businessAnno.getIsPush() == 1) {//可推送
					for(int i=0;i<annoScopes.length;i++) {
						String[] scope = annoScopes[i].split(":");
						Integer estateId = new Integer(scope[0]);
						ManageEstate manageEstate1 = manageEstateService.findById(estateId);
						BusinessStation businessStation = businessStationService.findById(manageEstate1.getStationId());
						//查询该小区下的userId, baiduId, channelId
						List appUserList = appUserService.findUserPushIds(estateId);
						AppPushLog appPushLog = new AppPushLog();
						String title = "OK家";
						String description = "【"+businessStation.getStaName()+"】"+businessAnno.getAnnoTitle();						
						
						Map paramMap = new HashMap();
						paramMap.put("messageType", 2);
						paramMap.put("ID", businessAnno.getAnnoId());
						paramMap.put("title", businessAnno.getAnnoTitle());
						paramMap.put("pic", businessAnno.getAppPic());
						
						for(int j=0;j<appUserList.size();j++) {
							AppUser appUser = (AppUser) appUserList.get(j);
							if(appUser.getBaiduId() != null && !"".equals(appUser.getBaiduId()) && appUser.getChannelId() != null && !"".equals(appUser.getChannelId())) {
								System.out.println("name  "+appUser.getRealname()+"  baiudId "+appUser.getBaiduId()+"   channelId   "+appUser.getChannelId());
								Integer success = AppPushNotificationUtil.pushNotification(
										title, 
										description, 
										appUser.getDeviceType(),
										Long.valueOf(appUser.getChannelId()).longValue(), 
										appUser.getBaiduId(),
										paramMap
										);
								//记录推送日志
								appPushLog.setUserId(appUser.getUserId());
							    appPushLog.setUserName(appUser.getRealname());
							    appPushLog.setBaiduId(appUser.getBaiduId());
							    appPushLog.setChannelId(appUser.getChannelId());
							    appPushLog.setTitle(title);
							    appPushLog.setDescription(description);
							    appPushLog.setSendTime(new Timestamp(System.currentTimeMillis()));
							    appPushLog.setSendState(success);
							    appPushLog.setSenderId(shiroUser.getUserId());
							    appPushLog.setSenderName(shiroUser.getUserName());
								appPushLogService.save(appPushLog);
							}
						}
					}
				}
			}
			
			if(businessAnno.getPublishState() == 0){
				//发布到首页
				AppHomepage appHomepage = new AppHomepage();
				appHomepage.setId(businessAnno.getAnnoId());
				appHomepage.setTitle(businessAnno.getAnnoTitle());
				appHomepage.setBrief(businessAnno.getBrief());
				appHomepage.setPic(businessAnno.getAppPic());
				appHomepage.setType(1);   // 4:驿站公告
				appHomepage.setPublishTime(new Timestamp(System.currentTimeMillis()));
				appHomepage.setTop(businessAnno.getIsImportant());
				appHomepageService.save(appHomepage);
				
				// 保存发布范围
				annoSope = query.getAnnoBuilding();
				annoScopes = annoSope.split(",");
				for(int i=0;i<annoScopes.length;i++) {
					String[] scope = annoScopes[i].split(":");
					AppHomepageScope appHomepageScope = new AppHomepageScope();
					appHomepageScope.setId(new Integer(scope[0]));
					appHomepageScope.setHomePageId(appHomepage.getHomePageId());
					appHomepageScope.setCreateTime(new Timestamp(System.currentTimeMillis()));
					appHomepageScopeService.save(appHomepageScope);
				}
			}
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessAnno信息时发生错误：/business/businessAnno/saveStationAnno", e);
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
	 * 修改驿站公告对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="updateStationAnno")
	public void updateStationAnno(HttpServletRequest request, HttpServletResponse response, BusinessAnnoQuery query) {
        int userid = CommonUtils.getUser().getUserId();
        String username = CommonUtils.getUser().getUserName();
		BusinessAnno businessAnno = new BusinessAnno();
		String json = "";
		try{
			businessAnno = businessAnnoService.findById(query.getAnnoId());
			ShiroUser shiroUser = getUser();
			List estateList = shiroUser.getEstateList();
			ManageEstate manageEstate = (ManageEstate) estateList.get(0);
            businessAnno.setPublisherId(userid);
            businessAnno.setAnnoScope(String.valueOf(manageEstate.getEstateId()));
            businessAnno.setAnnoBuilding(query.getAnnoBuilding());
            businessAnno.setAnnoScopeInfo(query.getAnnoScopeInfo());
            businessAnno.setPublisherName(username);
		    businessAnno.setAnnoTitle(query.getAnnoTitle());
		    businessAnno.setBrief(query.getBrief());
		    businessAnno.setAnnoContent(query.getAnnoContent());
		    //businessAnno.setAnnoType(4);//驿站公告
		    //businessAnno.setAnnoScopeInfo(manageEstate.getEstateName());
		    String path = request.getContextPath();
		    String ctx = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
		    if(query.getAnnoPic() != null && !query.getAnnoPic().equals("")) {
		    	File file = new File(ctx + businessAnno.getAnnoPic());
		    	if(file.exists()) {
		    		file.delete();
		    	}
		    	businessAnno.setAnnoPic(query.getAnnoPic());
		    }
		    if(query.getAppPic() != null && !query.getAppPic().equals("")) {
		    	File file = new File(ctx + businessAnno.getAppPic());
		    	if(file.exists()) {
		    		file.delete();
		    	}
		    	businessAnno.setAppPic(query.getAppPic());
		    }
		    //businessAnno.setUserLevel(query.getUserLevel());
		    if(query.getPublishState() != null && query.getPublishState() == 0) {
		    	businessAnno.setPublishTime(new Timestamp(System.currentTimeMillis()));
		    	businessAnno.setPublishState(query.getPublishState());
		    	businessAnno.setPublisherId(CommonUtils.getUser().getUserId());
		    	businessAnno.setPublisherName(CommonUtils.getUser().getUserName());
		    }else{
		    	businessAnno.setPublishState(query.getPublishState());
		    }
		    businessAnno.setIsRecommend(query.getIsRecommend());
		    //businessAnno.setAuditorId(query.getAuditorId());
		    //businessAnno.setAuditorName(query.getAuditorName());
		    //businessAnno.setAuditTime(query.getAuditTime());
		    //businessAnno.setSetTime(query.getSetTime());
		    businessAnno.setIsPush(query.getIsPush());
		    //businessAnno.setVisits(0);
		    //businessAnno.setSupports(0);
		    //businessAnno.setComments(0);
		    //businessAnno.setAnnoState(0);
		    //businessAnno.setDelMemo(query.getDelMemo());
		    //businessAnno.setCreateTime(new Timestamp(System.currentTimeMillis()));
		    businessAnno.setEditTime(new Timestamp(System.currentTimeMillis()));
		    businessAnno.setEditor(username);
			businessAnnoService.update(businessAnno);
			//保存发布范围
			Map paramMap = new HashMap();
			paramMap.put("annoId", query.getAnnoId());
			List scopeList = businessAnnoScopeService.findByMap(paramMap);
			for(int i=0;i<scopeList.size();i++){
				BusinessAnnoScope scope = (BusinessAnnoScope) scopeList.get(i);
				businessAnnoScopeService.delete(scope.getAnnoId());
			}
			//保存发布范围
			String annoSope = query.getAnnoBuilding();
			String[] annoScopes = annoSope.split(",");
			for(int i=0;i<annoScopes.length;i++) {
				String[] scope = annoScopes[i].split(":");
				BusinessAnnoScope businessAnnoScope = new BusinessAnnoScope();
				businessAnnoScope.setAnnoId(businessAnno.getAnnoId());
				businessAnnoScope.setProId(shiroUser.getOrgId());
				businessAnnoScope.setEstateId(new Integer(scope[0]));
				businessAnnoScope.setEstateName(scope[1]);
				businessAnnoScope.setCreateTime(new Timestamp(System.currentTimeMillis()));
				businessAnnoScopeService.save(businessAnnoScope);
			}
						
			//如果要推荐到焦点图，则保存在焦点图中一条记录
			if(query.getIsRecommend() != null && businessAnno.getPublishState() == 0) {
				if(query.getIsRecommend() == 1) {
					BusinessFocus businessFocus = new BusinessFocus();
					businessFocus.setTitle(businessAnno.getAnnoTitle());
				    businessFocus.setState(2);   // 待审核
				    businessFocus.setPicUrl(businessAnno.getAnnoPic());
				    businessFocus.setPageUrl("");
				    businessFocus.setSourceId(businessAnno.getAnnoId());
				    businessFocus.setSourceType(2);	// 来源类型
				    businessFocus.setIshtml(0);  // 静态
				    businessFocus.setAuditInfo("");
				    businessFocus.setFocusScope(businessAnno.getAnnoScopeInfo());  //展示范围
				    businessFocus.setVisits(0);
				    businessFocus.setSupports(0);
				    businessFocus.setSelectorId(shiroUser.getUserId());
				    businessFocus.setSelectorName(shiroUser.getUserName());
				    businessFocus.setSelectTime(new Timestamp(System.currentTimeMillis()));
				    
					businessFocusService.save(businessFocus);
					
					AppFocusScope appFocusScope = new AppFocusScope();
					for(int i=0; i<annoScopes.length; i++) {
						  String[] scope = annoScopes[i].split(":");
						  appFocusScope.setFocusId(businessFocus.getFocusId());
						  appFocusScope.setEstateId(new Integer(scope[0]));
						  appFocusScope.setCreateTime(new Timestamp(System.currentTimeMillis()));
						  appFocusScopeService.save(appFocusScope);
					}
				} 
			}
			
			if(businessAnno.getPublishState() == 0){ 
				//发布到首页
				AppHomepage appHomepage = new AppHomepage();
				appHomepage.setId(businessAnno.getAnnoId());
				appHomepage.setTitle(businessAnno.getAnnoTitle());
				appHomepage.setBrief(businessAnno.getBrief());
				appHomepage.setPic(businessAnno.getAppPic());
				appHomepage.setType(1);   // 4:驿站公告
				appHomepage.setPublishTime(new Timestamp(System.currentTimeMillis()));
				appHomepage.setTop(businessAnno.getIsImportant());
				appHomepageService.save(appHomepage);
				
				// 保存发布范围
				annoSope = query.getAnnoBuilding();
				annoScopes = annoSope.split(",");
				for(int i=0;i<annoScopes.length;i++) {
					String[] scope = annoScopes[i].split(":");
					AppHomepageScope appHomepageScope = new AppHomepageScope();
					appHomepageScope.setId(new Integer(scope[0]));
					appHomepageScope.setHomePageId(appHomepage.getHomePageId());
					appHomepageScope.setCreateTime(new Timestamp(System.currentTimeMillis()));
					appHomepageScopeService.save(appHomepageScope);
				}
			}
			
			//发布状态
			if(businessAnno.getPublishState() == 0) {
				//执行推送接口
				//重要通知向小区内的所有居民发送公告
				if(businessAnno.getIsPush() != null && businessAnno.getIsPush() == 1) {//可推送
					for(int i=0;i<annoScopes.length;i++) {
						String[] scope = annoScopes[i].split(":");
						Integer estateId = new Integer(scope[0]);
						ManageEstate manageEstate1 = manageEstateService.findById(estateId);
						BusinessStation businessStation = businessStationService.findById(manageEstate1.getStationId());
						//BusinessStation businessStation = businessStationService.findById(manageEstate.getStationId());
						//查询该小区下的userId, baiduId, channelId
						List appUserList = appUserService.findUserPushIds(estateId);
						AppPushLog appPushLog = new AppPushLog();
						String title = "OK家";
						String description = "【"+businessStation.getStaName()+"】"+businessAnno.getAnnoTitle();	
						
						paramMap = new HashMap();
						paramMap.put("messageType", 2);
						paramMap.put("ID", businessAnno.getAnnoId());
						paramMap.put("title", businessAnno.getAnnoTitle());
						paramMap.put("pic", businessAnno.getAppPic());
						
						for(int j=0;j<appUserList.size();j++) {
							AppUser appUser = (AppUser) appUserList.get(j);
							if(appUser.getBaiduId() != null && !"".equals(appUser.getBaiduId()) && appUser.getChannelId() != null && !"".equals(appUser.getChannelId())) {
								Integer success = AppPushNotificationUtil.pushNotification(
										title, 
										description, 
										appUser.getDeviceType(),
										Long.valueOf(appUser.getChannelId()).longValue(), 
										appUser.getBaiduId(),
										paramMap
										);
								//记录推送日志
								appPushLog.setUserId(appUser.getUserId());
							    appPushLog.setUserName(appUser.getRealname());
							    appPushLog.setBaiduId(appUser.getBaiduId());
							    appPushLog.setChannelId(appUser.getChannelId());
							    appPushLog.setTitle(title);
							    appPushLog.setDescription(description);
							    appPushLog.setSendTime(new Timestamp(System.currentTimeMillis()));
							    appPushLog.setSendState(success);
							    appPushLog.setSenderId(shiroUser.getUserId());
							    appPushLog.setSenderName(shiroUser.getUserName());
								appPushLogService.save(appPushLog);
							}
						}
					}
				}
			}

			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessAnno信息时发生错误：/business/businessAnno/saveStationAnno", e);
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
	 * 保存运营公告对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="saveOperationAnno")
	public void saveOperationAnno(HttpServletRequest request, HttpServletResponse response, BusinessAnnoQuery query) {
        int userid = CommonUtils.getUser().getUserId();
        String username = CommonUtils.getUser().getUserName();
		BusinessAnno businessAnno = new BusinessAnno();
		String json = "";
		try{
			ShiroUser shiroUser = getUser();
			//BusinessPosition businessPosition = businessPositionService.findById(shiroUser.getPositionId());
			//获取用户所在物业管理的小区
			//Map paramMap = new HashMap();
			//paramMap.put("proId", businessPosition.getOrgId());
			//List estateList = manageEstateService.findByMap(paramMap);
			//ManageEstate manageEstate = (ManageEstate) estateList.get(0);
            businessAnno.setPublisherId(userid);
            businessAnno.setPublisherName(username);
		    businessAnno.setAnnoTitle(query.getAnnoTitle());
		    businessAnno.setBrief(query.getBrief());
		    businessAnno.setAnnoContent(query.getAnnoContent());
		    businessAnno.setAnnoType(query.getAnnoType());
		    //businessAnno.setAnnoScope(manageEstate.getEstateId().toString());
		    //businessAnno.setAnnoBuilding(query.getAnnoBuilding());
		    businessAnno.setAnnoScopeInfo(query.getAnnoScopeInfo());
		    //businessAnno.setAnnoPic(query.getAnnoPic());
		    businessAnno.setUserLevel(query.getUserLevel());
		    businessAnno.setPublishTime(new Timestamp(System.currentTimeMillis()));
		    businessAnno.setPublishState(query.getPublishState());
		    //businessAnno.setAuditorId(query.getAuditorId());
		    //businessAnno.setAuditorName(query.getAuditorName());
		   // businessAnno.setAuditTime(query.getAuditTime());
		    //businessAnno.setSetTime(query.getSetTime());
		    businessAnno.setIsPush(query.getIsPush());
		    //businessAnno.setIsImportant(query.getIsImportant());
		    //if(query.getSetTime() != null && !"".equals(query.getSetTime())) {
		    //	businessAnno.setIsRemind(1);//需要提醒
		    //}
		    businessAnno.setVisits(0);
		    businessAnno.setSupports(0);
		    businessAnno.setComments(0);
		    businessAnno.setAnnoState(0);
		    //businessAnno.setDelMemo(query.getDelMemo());
		    businessAnno.setCreateTime(new Timestamp(System.currentTimeMillis()));
		    businessAnno.setEditTime(new Timestamp(System.currentTimeMillis()));
		    businessAnno.setEditor(username);
			businessAnnoService.save(businessAnno);
			
			//保存公告范围
			String scope = query.getScope();
			String[] estates = null;
			BusinessAnnoScope businessAnnoScope = new BusinessAnnoScope();
			if(scope.indexOf(",") > -1) {
				estates = scope.split(",");
				for(int i=0;i<estates.length;i++) {
					String[] estate = estates[i].split(":");
					businessAnnoScope.setAnnoId(businessAnno.getAnnoId());
					businessAnnoScope.setEstateId(new Integer(estate[0]));
					businessAnnoScope.setProId(shiroUser.getOrgId());
					businessAnnoScope.setEstateName(estate[1]);
					if(businessAnno.getAnnoType() == 2) { //内部公告
						businessAnnoScope.setScopeType(new Integer(estate[2])); //范围类型
					}					
					businessAnnoScope.setCreateTime(new Timestamp(System.currentTimeMillis()));
					businessAnnoScopeService.save(businessAnnoScope);
				}
			}else{
				String[] estate = scope.split(":");
				businessAnnoScope.setAnnoId(businessAnno.getAnnoId());
				businessAnnoScope.setEstateId(new Integer(estate[0]));
				businessAnnoScope.setProId(shiroUser.getOrgId());
				businessAnnoScope.setEstateName(estate[1]);
				if(businessAnno.getAnnoType() == 2) { //内部公告
					businessAnnoScope.setScopeType(new Integer(estate[2])); //范围类型
				}				
				businessAnnoScope.setCreateTime(new Timestamp(System.currentTimeMillis()));
				businessAnnoScopeService.save(businessAnnoScope);
			}
			
			//重要通知向小区内的所有居民发送公告
			if(businessAnno.getPublishState() == 0 && businessAnno.getIsPush() == 1) {//可推送
				estates = scope.split(","); 
				for(int i=0;i<estates.length;i++) {
					String[] estate = estates[i].split(":");
					Integer estateId = new Integer(estate[0]);
					//查询该小区下的userId, baiduId, channelId
					List appUserList = appUserService.findUserPushIds(estateId);
					AppPushLog appPushLog = new AppPushLog();
					String title = "OK家";
					String description = "【系统消息】有一条来自OK家的最新通知，看看发生了什么？";
					
					Map paramMap = new HashMap();
					paramMap.put("messageType", 14);
					paramMap.put("ID", businessAnno.getAnnoId());
					paramMap.put("title", businessAnno.getAnnoTitle());
					paramMap.put("pic", businessAnno.getAppPic());
					
					for(int j=0;j<appUserList.size();j++) {
						AppUser appUser = (AppUser) appUserList.get(j);
						Map paramMapTemp = new HashMap();
						paramMapTemp.put("userId", appUser.getUserId());
						List configList = appUserConfigService.findByMap(paramMapTemp);
						AppUserConfig appUserConfig = null;
						if(configList != null) {
							appUserConfig = (AppUserConfig) configList.get(0);
						}	
						if(appUserConfig != null 
								&& appUserConfig.getServiceSwitch() == 0 
								&& appUser.getBaiduId() != null 
								&& !"".equals(appUser.getBaiduId()) 
								&& appUser.getChannelId() != null 
								&& !"".equals(appUser.getChannelId())) {
							System.out.println(appUser.getRealname() + "    " +appUserConfig.getServiceSwitch());
							//物业通知(通过PC后台，"重要通知")
							Integer success = AppPushNotificationUtil.pushNotification(
									title, 
									description, 
									appUser.getDeviceType(),
									Long.valueOf(appUser.getChannelId()).longValue(), 
									appUser.getBaiduId(),
									paramMap
									);
							//记录推送日志
							appPushLog.setUserId(appUser.getUserId());
						    appPushLog.setUserName(appUser.getRealname());
						    appPushLog.setBaiduId(appUser.getBaiduId());
						    appPushLog.setChannelId(appUser.getChannelId());
						    appPushLog.setTitle(title);
						    appPushLog.setDescription(description);
						    appPushLog.setSendTime(new Timestamp(System.currentTimeMillis()));
						    appPushLog.setSendState(success);
						    appPushLog.setSenderId(shiroUser.getUserId());
						    appPushLog.setSenderName(shiroUser.getUserName());
							appPushLogService.save(appPushLog);
						}							
					}
				}
			}
			
			//发布的系统公告要发送系统消息
			if(businessAnno.getPublishState() == 0) {
				//重要通知向小区内的所有居民发送公告
				if(businessAnno.getAnnoType() == 3) {
					estates = scope.split(",");
					for(int i=0;i<estates.length;i++) {
						String[] estate = estates[i].split(":");
						Integer estateId = new Integer(estate[0]);
						//查询该小区下的userId
						List appUserList = appUserService.findUserPushIds(estateId);
						AppUserNews appUserNews = null;
						for(int j=0;j<appUserList.size();j++) {
							AppUser appUser = (AppUser) appUserList.get(j);
							appUserNews = new AppUserNews();
							appUserNews.setUserId(appUser.getUserId());
							appUserNews.setCreateTime(new Timestamp(System.currentTimeMillis()));
							appUserNews.setNewTitle(businessAnno.getAnnoTitle());
							appUserNews.setType(6);
							appUserNews.setId(businessAnno.getAnnoId());
							appUserNews.setContent(businessAnno.getAnnoContent());
							appUserNews.setLastMessage("");
							appUserNews.setLastMessageName("");
							appUserNewsService.saveReply(appUserNews);
							AppLatestNews appLatestNews = new AppLatestNews();
							appLatestNews.setUserId(appUser.getUserId());
							appLatestNews.setTypeId(7);
							appLatestNews.setSourceId(businessAnno.getAnnoId());
							appLatestNews.setTo(0);
							appLatestNews.setEstateId(0);
							appLatestNewsService.save_app(appLatestNews);
							appLatestNews.setTypeId(8);
							appLatestNewsService.save_app(appLatestNews);
							appLatestNews.setTypeId(10);
							appLatestNewsService.save_app(appLatestNews);
						}
					}
				}
			}

			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessAnno信息时发生错误：/business/businessAnno/save", e);
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
	 * 编辑运营公告对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="updateOperationAnno")
	public void updateOperationAnno(HttpServletRequest request, HttpServletResponse response, BusinessAnnoQuery query) {
        int userid = CommonUtils.getUser().getUserId();
        String username = CommonUtils.getUser().getUserName();
		BusinessAnno businessAnno = new BusinessAnno();
		String json = "";
		try{
			businessAnno = businessAnnoService.findById(query.getAnnoId());
			ShiroUser shiroUser = getUser();
			//Map paramMap = new HashMap();
			//paramMap.put("proId", shiroUser.getOrgId());
			//List estateList = manageEstateService.findByMap(paramMap);
			//ManageEstate manageEstate = (ManageEstate) estateList.get(0);
            businessAnno.setPublisherId(userid);
            businessAnno.setPublisherName(username);
		    businessAnno.setAnnoTitle(query.getAnnoTitle());
		    businessAnno.setBrief(query.getBrief());
		    businessAnno.setAnnoContent(query.getAnnoContent());
		    businessAnno.setAnnoType(query.getAnnoType());
		    //businessAnno.setAnnoScope(manageEstate.getEstateId().toString());
		    //businessAnno.setAnnoBuilding(query.getAnnoBuilding());
		    businessAnno.setAnnoScopeInfo(query.getAnnoScopeInfo());
		    //businessAnno.setAnnoPic(query.getAnnoPic());
		    businessAnno.setUserLevel(query.getUserLevel());
		    businessAnno.setPublishTime(new Timestamp(System.currentTimeMillis()));
		    businessAnno.setPublishState(query.getPublishState());
		    //businessAnno.setAuditorId(query.getAuditorId());
		    //businessAnno.setAuditorName(query.getAuditorName());
		   // businessAnno.setAuditTime(query.getAuditTime());
		    //businessAnno.setSetTime(query.getSetTime());
		    businessAnno.setIsPush(query.getIsPush());
		    //businessAnno.setIsImportant(query.getIsImportant());
		    //if(query.getSetTime() != null && !"".equals(query.getSetTime())) {
		    //	businessAnno.setIsRemind(1);//需要提醒
		    //}
		    //businessAnno.setVisits(0);
		    //businessAnno.setSupports(0);
		    //businessAnno.setComments(0);
		    //businessAnno.setAnnoState(0);
		    //businessAnno.setDelMemo(query.getDelMemo());
		    //businessAnno.setCreateTime(new Timestamp(System.currentTimeMillis()));
		    businessAnno.setEditTime(new Timestamp(System.currentTimeMillis()));
		    businessAnno.setEditor(username);
			businessAnnoService.update(businessAnno);
			
			//保存公告范围
			Map paramMap = new HashMap();
			paramMap.put("annoId", businessAnno.getAnnoId());
			List list = businessAnnoScopeService.findByMap(paramMap);
			for(int i=0;i<list.size();i++) {
				BusinessAnnoScope businessAnnoScope = (BusinessAnnoScope) list.get(i);
				businessAnnoScopeService.delete(businessAnnoScope.getAnnoId());
			}
			String scope = query.getScope();
			String[] estates = null;
			if(scope != null && !"".equals(scope)) {
				BusinessAnnoScope businessAnnoScope = new BusinessAnnoScope();
				if(scope.indexOf(",") > -1) {
					estates = scope.split(",");
					for(int i=0;i<estates.length;i++) {
						String[] estate = estates[i].split(":");
						businessAnnoScope.setAnnoId(businessAnno.getAnnoId());
						businessAnnoScope.setEstateId(new Integer(estate[0]));
						businessAnnoScope.setProId(shiroUser.getOrgId());
						businessAnnoScope.setEstateName(estate[1]);
						if(businessAnno.getAnnoType() == 2) { //内部公告
							businessAnnoScope.setScopeType(new Integer(estate[2])); //范围类型
						}	
						businessAnnoScope.setCreateTime(new Timestamp(System.currentTimeMillis()));
						businessAnnoScopeService.save(businessAnnoScope);
					}
				}else{
					String[] estate = scope.split(":");
					businessAnnoScope.setAnnoId(businessAnno.getAnnoId());
					businessAnnoScope.setEstateId(new Integer(estate[0]));
					businessAnnoScope.setProId(shiroUser.getOrgId());
					businessAnnoScope.setEstateName(estate[1]);
					if(businessAnno.getAnnoType() == 2) { //内部公告
						businessAnnoScope.setScopeType(new Integer(estate[2])); //范围类型
					}	
					businessAnnoScope.setCreateTime(new Timestamp(System.currentTimeMillis()));
					businessAnnoScopeService.save(businessAnnoScope);
				}
			}
			
			//重要通知向小区内的所有居民发送公告
			if(businessAnno.getPublishState() == 0 && businessAnno.getIsPush() == 1) {//可推送
				for(int i=0;i<estates.length;i++) {
					String[] estate = estates[i].split(":");
					Integer estateId = new Integer(estate[0]);
					//查询该小区下的userId, baiduId, channelId
					List appUserList = appUserService.findUserPushIds(estateId);
					AppPushLog appPushLog = new AppPushLog();
					String title = "OK家";
					String description = "【系统消息】有一条来自OK家的最新通知，看看发生了什么？";
					
					paramMap = new HashMap();
					paramMap.put("messageType", 14);
					paramMap.put("ID", businessAnno.getAnnoId());
					paramMap.put("title", businessAnno.getAnnoTitle());
					paramMap.put("pic", businessAnno.getAppPic());
					
					for(int j=0;j<appUserList.size();j++) {
						AppUser appUser = (AppUser) appUserList.get(j);
						Map paramMapTemp = new HashMap();
						paramMap.put("userId", appUser.getUserId());
						List configList = appUserConfigService.findByMap(paramMapTemp);
						AppUserConfig appUserConfig = null;
						if(configList != null) {
							appUserConfig = (AppUserConfig) configList.get(0);
						}	
						if(appUserConfig != null 
								&& appUserConfig.getServiceSwitch() == 0 
								&& appUser.getBaiduId() != null 
								&& !"".equals(appUser.getBaiduId()) 
								&& appUser.getChannelId() != null 
								&& !"".equals(appUser.getChannelId())) {
							//物业通知(通过PC后台，"重要通知")
							Integer success = AppPushNotificationUtil.pushNotification(
									title, 
									description, 
									appUser.getDeviceType(),
									Long.valueOf(appUser.getChannelId()).longValue(), 
									appUser.getBaiduId(),
									paramMap
									);
							//记录推送日志
							appPushLog.setUserId(appUser.getUserId());
						    appPushLog.setUserName(appUser.getRealname());
						    appPushLog.setBaiduId(appUser.getBaiduId());
						    appPushLog.setChannelId(appUser.getChannelId());
						    appPushLog.setTitle(title);
						    appPushLog.setDescription(description);
						    appPushLog.setSendTime(new Timestamp(System.currentTimeMillis()));
						    appPushLog.setSendState(success);
						    appPushLog.setSenderId(shiroUser.getUserId());
						    appPushLog.setSenderName(shiroUser.getUserName());
							appPushLogService.save(appPushLog);
						}							
					}
				}
			}
			
			//发布的系统公告要发送系统消息
			if(businessAnno.getPublishState() == 0) {
				//重要通知向小区内的所有居民发送公告
				if(businessAnno.getAnnoType() == 3) {
					estates = scope.split(",");
					for(int i=0;i<estates.length;i++) {
						String[] estate = estates[i].split(":");
						Integer estateId = new Integer(estate[0]);
						//查询该小区下的userId
						List appUserList = appUserService.findUserPushIds(estateId);
						AppUserNews appUserNews = null;
						for(int j=0;j<appUserList.size();j++) {
							AppUser appUser = (AppUser) appUserList.get(j);
							appUserNews = new AppUserNews();
							appUserNews.setUserId(appUser.getUserId());
							appUserNews.setCreateTime(new Timestamp(System.currentTimeMillis()));
							appUserNews.setNewTitle(businessAnno.getAnnoTitle());
							appUserNews.setType(6);
							appUserNews.setId(businessAnno.getAnnoId());
							appUserNews.setContent(businessAnno.getAnnoContent());
							appUserNews.setLastMessage("");
							appUserNews.setLastMessageName("");
							appUserNewsService.saveReply(appUserNews);
							AppLatestNews appLatestNews = new AppLatestNews();
							appLatestNews.setUserId(appUser.getUserId());
							appLatestNews.setTypeId(7);
							appLatestNews.setSourceId(businessAnno.getAnnoId());
							appLatestNews.setTo(0);
							appLatestNews.setEstateId(0);
							appLatestNewsService.save_app(appLatestNews);
							appLatestNews.setTypeId(8);
							appLatestNewsService.save_app(appLatestNews);
							appLatestNews.setTypeId(10);
							appLatestNewsService.save_app(appLatestNews);
						}
					}
				}
			}
			
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessAnno信息时发生错误：/business/businessAnno/save", e);
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
	 * 获取用户所在机构管理的小区的楼栋
	 * @param response
	 */
	@RequestMapping(value="getBuildingsByUser")
	public void getBuildingsByUser(HttpServletResponse response) {
		JSONObject jsonObj = new JSONObject();
		JSONArray arr = new JSONArray();
		try{
			ShiroUser shiroUser = CommonUtils.getUser();
			BusinessPosition businessPosition = businessPositionService.findById(shiroUser.getPositionId());
			//判断是哪种结构并获取该结构下的小区列表
			//获取用户所在物业的小区
			List estateList = null;
			JSONObject estateObj = null;
			//Map paramMap = new HashMap();
			if(ModuleConst.COMMUNITY_CODE.equals(businessPosition.getOrgType())) {//社区
				//paramMap.put("comId", businessPosition.getOrgId());
				estateList = shiroUser.getEstateBeanList();
				for(int i=0;i<estateList.size();i++) {
					EstateBean estate = (EstateBean) estateList.get(i);
					estateObj = new JSONObject();
					estateObj.put("id", "eatate_"+estate.getEstateId());
					estateObj.put("text", estate.getEstateName());
					estateObj.put("checkbox", true);
					//obj.put("state", "close");
					arr.add(estateObj);
				}
			}else if(ModuleConst.PROPERTY_CODE.equals(businessPosition.getOrgType())) {//物业
				//paramMap.put("proId", businessPosition.getOrgId());
				//estateList = manageEstateService.findByMap(paramMap);
				estateList = shiroUser.getEstateBeanList();
				for(int i=0;i<estateList.size();i++) {
					EstateBean estate = (EstateBean) estateList.get(i);
					estateObj = new JSONObject();
					estateObj.put("id", "eatate_"+estate.getEstateId());
					estateObj.put("text", estate.getEstateName());
					estateObj.put("checkbox", true);
					estateObj.put("state", "close");
					/*paramMap = new HashMap();
					paramMap.put("estateId", estate.getEstateId());
					List buildingList = manageBuildingService.findByMap(paramMap);
					JSONArray buildingArr = new JSONArray();
					for(int j=0;j<buildingList.size();j++) {
						JSONObject buildingObj = new JSONObject();
						ManageBuilding manageBuilding = (ManageBuilding) buildingList.get(j);
						buildingObj.put("id", "building_"+manageBuilding.getBuildingId());
						buildingObj.put("text", manageBuilding.getBuildingName());
						buildingArr.add(buildingObj);
					}
					estateObj.put("children", buildingArr);*/
					arr.add(estateObj);
				}
			}else if(ModuleConst.STATION_CODE.equals(businessPosition.getOrgType())) {//驿站
				//paramMap.put("stationId", businessPosition.getOrgId());
				//estateList = manageEstateService.findByMap(paramMap);
				estateList = shiroUser.getEstateBeanList();
				for(int i=0;i<estateList.size();i++) {
					EstateBean estate = (EstateBean) estateList.get(i);
					estateObj = new JSONObject();
					estateObj.put("id", "eatate_"+estate.getEstateId());
					estateObj.put("text", estate.getEstateName());
					estateObj.put("state", "close");
					/*paramMap = new HashMap();
					paramMap.put("estateId", estate.getEstateId());
					List buildingList = manageBuildingService.findByMap(paramMap);
					JSONArray buildingArr = new JSONArray();
					for(int j=0;j<buildingList.size();j++) {
						JSONObject buildingObj = new JSONObject();
						ManageBuilding manageBuilding = (ManageBuilding) buildingList.get(j);
						buildingObj.put("id", "building_"+manageBuilding.getBuildingId());
						buildingObj.put("text", manageBuilding.getBuildingName());
						buildingArr.add(buildingObj);
					}
					estateObj.put("children", buildingArr);*/
					arr.add(estateObj);
				}
			}
		
			jsonObj.put("success", true);
			jsonObj.put("result", arr);
		}catch(Exception e){
			jsonObj.put("success", false);
			jsonObj.put("message", "获取失败");
			GSLogger.error("获取用户所在机构管理的小区的楼栋：/business/businessUser/getBuildingsByUser", e);
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
	 * 进入修改页
	 * @return
	 */
	@RequestMapping(value="modify")
	public ModelAndView modify(BusinessAnnoQuery query) {	
		BusinessAnno businessAnno = null;
		ModelAndView mav = new ModelAndView();
		try{
			businessAnno = businessAnnoService.findById(query.getAnnoId());
            //businessAnno.setScope("-1"); //初始化范围
		}catch(Exception e){
			GSLogger.error("进入businessAnno修改页时发生错误：/business/businessAnno/modify", e);
			e.printStackTrace();
		}
		
		ShiroUser shiroUser = CommonUtils.getUser();
		if(shiroUser.getOrgType().equals(ModuleConst.PROPERTY_CODE)) {//物业
			mav = new ModelAndView("/module/anno/propModify");
		}else if(shiroUser.getOrgType().equals(ModuleConst.STATION_CODE)) {//驿站
			mav = new ModelAndView("/module/anno/stationModify");
		}if(shiroUser.getOrgType().equals(ModuleConst.OPERATION_CODE)) {//运营
			mav = new ModelAndView("/module/anno/operationModify");
		}
		//保存公告范围
		Map paramMap = new HashMap();
		paramMap.put("annoId", businessAnno.getAnnoId());
		List list = businessAnnoScopeService.findByMap(paramMap);
		StringBuilder sb = new StringBuilder();
		if(list.size() > 0){
			for(int i=0;i<list.size();i++) {
				BusinessAnnoScope businessAnnoScope = (BusinessAnnoScope) list.get(i);
				if(businessAnno.getAnnoType() == 2) {//内部公告
					sb.append(businessAnnoScope.getEstateId()+":"+businessAnnoScope.getEstateName()+":"+businessAnnoScope.getScopeType()+",");
				}else{
					sb.append(businessAnnoScope.getEstateId()+":"+businessAnnoScope.getEstateName()+",");
				}
			}
			mav.addObject("scope", sb.toString().subSequence(0, sb.toString().length()-1));
		}
		mav.addObject("businessAnno", businessAnno);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param businessAnno
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessAnno businessAnno) {
		//BusinessAnno businessAnno = null;
		String json = "";
        int userid = getUser().getUserId();
        String username = getUser().getUserName();
		try{
            businessAnno.setPublisherId(userid);
            businessAnno.setPublisherName(username);

	        Timestamp  ts=new Timestamp(new Date().getTime());
	        businessAnno.setEditTime(ts);

            String scopeString = businessAnno.getScope();
            if(scopeString != null && !"-1".equals(scopeString)) {
                //删除旧范围
                //businessUserResourceService.deleteByUserId(businessUser.getUserId());
                //保存范围 business_user_resource
                //可取到 小区 楼栋和单元
                String[] rows = scopeString.split("\\,");
                for(String row : rows) {
                    String[] attrs = row.split("\\&");
                    String estateId = "";
                    String estateName = "";
                    String buildingId = "";
                    String buildingName = "";
                    String unitId = "";
                    String unitName = "";
                    for(String attr : attrs) {
                        String[] values = attr.split("\\|");
                        String param_id = ((values[0]).split("\\_"))[1]; //id
                        String param_name = values[1];                    //name
                        //小区
                        if(attr.indexOf("eatate") == 0) {
                            estateId = param_id; //小区ID
                            estateName = param_name; //小区名称
                        }
                        //楼栋
                        else if(attr.indexOf("building") == 0) {
                            buildingId = param_id;
                            buildingName = param_name;
                        }
                        //单元
                        else if(attr.indexOf("unit") == 0) {
                            unitId = param_id;
                            unitName = param_name;
                        }
                    }
                    BusinessUserResource businessUserResource = new BusinessUserResource();
                    //businessUserResource.setUserId(businessUser.getUserId());
                    if(!"".equals(estateId)) {
                        businessUserResource.setEstateId(Integer.parseInt(estateId));
                    }
                    businessUserResource.setEstateName(estateName);
                    if(!"".equals(buildingId)) {
                        businessUserResource.setBuildingId(Integer.parseInt(buildingId));
                    }
                    businessUserResource.setBuildingName(buildingName);

                    if(!"".equals(unitId)) {
                        businessUserResource.setUnitId(Integer.parseInt(unitId));
                    }
                    businessUserResource.setUnitName(unitName);
                    businessUserResource.setCreateTime(ts);
                    //businessUserResourceService.save(businessUserResource);
                }
            }

			businessAnnoService.update(businessAnno);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessAnno信息时发生错误：/business/businessAnno/update", e);
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
						businessAnnoService.delete(new Integer(ids[i]));
					}
				}else{
					BusinessAnno businessAnno = businessAnnoService.findById(new Integer(id));
					Boolean  result = businessAnnoService.delete(new Integer(id));
					if(result) {
						businessAnnoScopeService.delete(new Integer(id));
						Map paramMap = new HashMap();
						paramMap.put("id", Integer.parseInt(id));
						if(businessAnno.getAnnoType()==0) {  // 0:物业通知类公告 
							paramMap.put("type", 3);
						} else if(businessAnno.getAnnoType()==1) {  // 1:物业信息传达类公告 
							paramMap.put("type", 2);
						}else if(businessAnno.getAnnoType()==4) {  // 4:驿站公告
							paramMap.put("type", 1);
						}
						List<AppHomepage> list = appHomepageService.findByMap(paramMap);
						AppHomepage AppHomepage = (AppHomepage)list.get(0);
						if(list.size() == 1) {
							appHomepageService.delete(AppHomepage);
							appHomepageScopeService.delete(AppHomepage.getHomePageId());
						}
					}
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessAnno时发生错误：/business/businessAnno/delete", e);
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
     * 上传图片附件
     * @param myfile
     * @return
     */
    @RequestMapping(value="uploadAnnoImg")
    public @ResponseBody String uploadAttach(HttpServletRequest request, @RequestParam MultipartFile[] myfile) {
        String smallPicName = "";
        String fname2 = "";
        String smallPicpath = "";
        Map paramMap = null;
        //上传附件
        try {
            Uploader uploader = new Uploader(request);
            //paramMap = uploader.upload("anno");
            uploader.upload("anno");
        } catch(Exception e) {
        	e.printStackTrace();
        }
        //返回图片全路径
        return (String) paramMap.get("uploadFile");
    }

    @RequestMapping(value="getAnnoJson")
    public void getAnnoJson(@RequestParam(value="annoId") String annoId, HttpServletResponse response) {
        int id = Integer.parseInt(annoId);
        BusinessAnno businessAnno = new BusinessAnno();
        businessAnno = businessAnnoService.findById(id);
        StringBuilder result = new StringBuilder();
        result.append("{")
                .append("\"annoId\":\"").append(businessAnno.getAnnoId()).append("\"").append(",")
                .append("\"annoTitle\":\"").append(businessAnno.getAnnoTitle()).append("\"").append(",")
                .append("\"annoContent\":\"").append(businessAnno.getAnnoContent().replace("\"", "\\\"")).append("\"").append(",")
                .append("\"annoType\":\"").append(businessAnno.getAnnoType()).append("\"").append(",")
                .append("\"annoScope\":\"").append(businessAnno.getAnnoScopeInfo()).append("\"").append(",")
                .append("\"annoPic\":\"").append(businessAnno.getAnnoPic()).append("\"").append(",")
                .append("\"userLevel\":\"").append(businessAnno.getUserLevel()).append("\"").append(",")
                .append("\"publisherId\":\"").append(businessAnno.getPublisherId()).append("\"").append(",")
                .append("\"publisherName\":\"").append(businessAnno.getPublisherName()).append("\"").append(",")
                .append("\"publishTime\":\"").append(businessAnno.getPublishTime()).append("\"").append(",")
                .append("\"publishState\":\"").append(businessAnno.getPublishState()).append("\"").append(",")
                .append("\"auditorId\":\"").append(businessAnno.getAuditorId()).append("\"").append(",")
                .append("\"auditorName\":\"").append(businessAnno.getAuditorName()).append("\"").append(",")
                .append("\"auditTime\":\"").append(businessAnno.getAuditTime()).append("\"").append(",")
                .append("\"setTime\":\"").append(businessAnno.getSetTime()).append("\"").append(",")
                .append("\"isPush\":\"").append(businessAnno.getIsPush()).append("\"").append(",")
                .append("\"isImportant\":\"").append(businessAnno.getIsImportant()).append("\"").append(",")
                .append("\"isRemind\":\"").append(businessAnno.getIsRemind()).append("\"").append(",")
                .append("\"visits\":\"").append(businessAnno.getVisits()).append("\"").append(",")
                .append("\"supports\":\"").append(businessAnno.getSupports()).append("\"").append(",")
                .append("\"comments\":\"").append(businessAnno.getComments()).append("\"").append(",")
                .append("\"annoState\":\"").append(businessAnno.getAnnoState()).append("\"").append(",")
                .append("\"delMemo\":\"").append(businessAnno.getDelMemo()).append("\"").append(",")
                .append("\"createTime\":\"").append(businessAnno.getCreateTime()).append("\"").append(",")
                .append("\"editTime\":\"").append(businessAnno.getEditTime()).append("\"").append(",")
                .append("\"editor\":\"").append(businessAnno.getEditor()).append("\"")
                .append("}");

                response.setHeader("Cache-Control", "no-cache");
                response.setCharacterEncoding("utf-8");
                try {
                    response.getWriter().write(result.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
    }

    /**
     * 获取公告内容
     * @param annoId
     * @param response
     */
    @RequestMapping(value="getAnnoContent")
    public void getAnnoContent(@RequestParam(value="annoId") String annoId, HttpServletResponse response) {
        int id = Integer.parseInt(annoId);
        BusinessAnno businessAnno = businessAnnoService.findById(id);
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("utf-8");
        try {
            response.getWriter().write(businessAnno.getAnnoContent());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 跳转更新页面
     * @param annoId
     */
    @RequestMapping(value="updateAnno")
    public ModelAndView updateAnno(@RequestParam(value="annoId") String annoId) {
        BusinessAnno businessAnno = businessAnnoService.findById(Integer.parseInt(annoId));
        ModelAndView mav = new ModelAndView("/module/anno/modify");
        mav.addObject("businessAnno", businessAnno);
        return mav;
    }
    
    /**
	 * 撤回发布公告对象
	 * @param request
	 * @param businessAnno
	 * @return
	 */
	@RequestMapping(value="cancelAnnoPublishState")
	public void cancelAnnoPublishState(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="annoId") Integer annoId) {
		
		BusinessAnno businessAnno = businessAnnoService.findById(annoId);
		String json = "";
		try{
			businessAnno.setPublishState(1);
			businessAnno.setEditTime(new Timestamp(System.currentTimeMillis()));
			businessAnno.setIsImportant(0);
			businessAnnoService.update(businessAnno);
			
			if(businessAnno.getPublishState() == 1) {
				Map paramMap = new HashMap();
				paramMap.put("id", annoId);
				if(businessAnno.getAnnoType() == 0) {  	// 物业通知类公告
					paramMap.put("type", 3);  // 3物业通知
				} else if(businessAnno.getAnnoType() == 1){ 	// 物业信息传达类公告
					paramMap.put("type", 2);  // 2物业公告
				} else if(businessAnno.getAnnoType() == 4){ 	// 驿站公告
					paramMap.put("type", 1);   // 4:驿站公告
				}
				List<AppHomepage> list = appHomepageService.findByMap(paramMap);
				if(list.size() == 1) {
					AppHomepage AppHomepage = (AppHomepage)list.get(0);
					appHomepageService.delete(AppHomepage);
					appHomepageScopeService.delete(AppHomepage.getHomePageId());
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"撤回发布成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"true\",\"message\":\"撤回发布失败\"}"; 
			GSLogger.error("显示businessAnno列表时发生错误：/business/businessAnno/list", e);
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
     * 接受
     * @param annoId
     * @param response
     */
    @RequestMapping(value="acceptAnno")
    public void acceptAnno(@RequestParam(value="annoId") String annoId, HttpServletResponse response) {
        int id = Integer.parseInt(annoId);
        String json = "";
        try{
        	BusinessAnno businessAnno = businessAnnoService.findById(id);
        	businessAnno.setPublishState(0);//审核通过 发布
        	businessAnno.setAuditorId(CommonUtils.getUser().getUserId());
        	businessAnno.setAuditorName(CommonUtils.getUser().getUserName());
        	businessAnno.setAuditTime(new Timestamp(System.currentTimeMillis()));
        	businessAnno.setEditTime(new Timestamp(System.currentTimeMillis()));
        	businessAnno.setEditor(CommonUtils.getUser().getUserName());
        	businessAnnoService.update(businessAnno);
        	
        	// 驿站推荐到焦点图列表
			if(businessAnno.getIsRecommend() != null && businessAnno.getPublishState() == 0) {
				if(businessAnno.getIsRecommend() == 1) {
					BusinessFocus businessFocus = new BusinessFocus();
					businessFocus.setTitle(businessAnno.getAnnoTitle());
				    businessFocus.setState(2);   // 待审核
				    businessFocus.setPicUrl(businessAnno.getAnnoPic());
				    businessFocus.setPageUrl("");
				    businessFocus.setSourceId(businessAnno.getAnnoId());
				    businessFocus.setSourceType(2);	// 来源类型
				    businessFocus.setIshtml(0);  // 静态
				    businessFocus.setAuditInfo("");
				    businessFocus.setFocusScope(businessAnno.getAnnoScopeInfo());  //展示范围
				    businessFocus.setVisits(0);
				    businessFocus.setSupports(0);
				    businessFocus.setSelectorId(getUser().getUserId());
				    businessFocus.setSelectorName(getUser().getUserName());
				    businessFocus.setSelectTime(new Timestamp(System.currentTimeMillis()));
				    
					businessFocusService.save(businessFocus);
					
					AppFocusScope appFocusScope = new AppFocusScope();
					String annoSope = businessAnno.getAnnoBuilding();
					String[] annoScopes = annoSope.split(",");
					for(int i=0; i<annoScopes.length; i++) {
						  String[] scope = annoScopes[i].split(":");
						  appFocusScope.setFocusId(businessFocus.getFocusId());
						  appFocusScope.setEstateId(new Integer(scope[0]));
						  appFocusScope.setCreateTime(new Timestamp(System.currentTimeMillis()));
						  appFocusScopeService.save(appFocusScope);
					}
				}
			}
			
        	// 发布到首页
			if(businessAnno.getPublishState() == 0) {
				if(businessAnno.getAnnoType() == 0 || businessAnno.getAnnoType() == 1 || businessAnno.getAnnoType() == 4) {  	
					AppHomepage appHomepage = new AppHomepage();
					appHomepage.setId(businessAnno.getAnnoId());
					appHomepage.setTitle(businessAnno.getAnnoTitle());
					appHomepage.setBrief(businessAnno.getBrief());
					appHomepage.setPic(businessAnno.getAppPic());
					if(businessAnno.getAnnoType() == 0) {  	// 物业通知类公告
						appHomepage.setType(3);  // 3物业通知
					} else if(businessAnno.getAnnoType() == 1){ 	// 物业信息传达类公告
						appHomepage.setType(2);	// 2物业公告
					} else if(businessAnno.getAnnoType() == 4){ 	// 驿站公告
						appHomepage.setType(1);   // 4:驿站公告
					}
					appHomepage.setPublishTime(new Timestamp(System.currentTimeMillis()));
					appHomepage.setTop(businessAnno.getIsImportant());
					appHomepageService.save(appHomepage);
					
	            	AppHomepageScope appHomepageScope = new AppHomepageScope();
					
					Map paramMap = new HashMap();
	    		    paramMap.put("annoId", businessAnno.getAnnoId());
	    		    List<BusinessAnnoScope> list =businessAnnoScopeService.findByMap(paramMap);
	    		    for(int i=0; i<list.size(); i++) {
	    		    	BusinessAnnoScope businessAnnoScope = (BusinessAnnoScope)list.get(i);
	    				appHomepageScope.setHomePageId(appHomepage.getHomePageId());
	    				appHomepageScope.setId(businessAnnoScope.getEstateId()); 	// 小区id
	    				appHomepageScope.setCreateTime(new Timestamp(System.currentTimeMillis()));
	    				appHomepageScopeService.save(appHomepageScope);
	                }
				} 
			}
			
			//发布的系统公告要发送系统消息
			if(businessAnno.getPublishState() == 0) {
				//重要通知向小区内的所有居民发送公告
				if(businessAnno.getAnnoType() == 3) {
					Map map = new HashMap();
					map.put("annoId", businessAnno.getAnnoId());
					List annoScopeList = businessAnnoScopeService.findByMap(map);
					for(int i=0;i<annoScopeList.size();i++) {
						BusinessAnnoScope businessAnnoScope = (BusinessAnnoScope) annoScopeList.get(i);
						Integer estateId = businessAnnoScope.getEstateId();
						//查询该小区下的userId
						List appUserList = appUserService.findUserPushIds(estateId);
						AppUserNews appUserNews = null;
						for(int j=0;j<appUserList.size();j++) {
							AppUser appUser = (AppUser) appUserList.get(j);
							appUserNews = new AppUserNews();
							appUserNews.setUserId(appUser.getUserId());
							appUserNews.setCreateTime(new Timestamp(System.currentTimeMillis()));
							appUserNews.setNewTitle(businessAnno.getAnnoTitle());
							appUserNews.setType(6);
							appUserNews.setId(businessAnno.getAnnoId());
							appUserNews.setContent(businessAnno.getAnnoContent());
							appUserNews.setLastMessage("");
							appUserNews.setLastMessageName("");
							appUserNewsService.saveReply(appUserNews);
							AppLatestNews appLatestNews = new AppLatestNews();
							appLatestNews.setUserId(appUser.getUserId());
							appLatestNews.setTypeId(7);
							appLatestNews.setSourceId(businessAnno.getAnnoId());
							appLatestNews.setTo(0);
							appLatestNews.setEstateId(0);
							appLatestNewsService.save_app(appLatestNews);
							appLatestNews.setTypeId(8);
							appLatestNewsService.save_app(appLatestNews);
							appLatestNews.setTypeId(10);
							appLatestNewsService.save_app(appLatestNews);
						}
					}
				}
			}
			
			//重要通知向小区内的所有居民发送公告
			if(businessAnno.getPublishState() == 0 && businessAnno.getIsPush() == 1) {//可推送
				Map paramMap = new HashMap();
				paramMap.put("annoId", businessAnno.getAnnoId());
				List annoScopeList = businessAnnoScopeService.findByMap(paramMap);
				for(int i=0;i<annoScopeList.size();i++) {
					BusinessAnnoScope businessAnnoScope = (BusinessAnnoScope) annoScopeList.get(i);
					Integer estateId = businessAnnoScope.getEstateId();
					//查询该小区下的userId, baiduId, channelId
					List appUserList = appUserService.findUserPushIds(estateId);
					AppPushLog appPushLog = new AppPushLog();
					String title = "OK家";
					String description = "【系统消息】有一条来自OK家的最新通知，看看发生了什么？";
					
					paramMap = new HashMap();
					paramMap.put("messageType", 14);
					paramMap.put("ID", businessAnno.getAnnoId());
					paramMap.put("title", businessAnno.getAnnoTitle());
					paramMap.put("pic", businessAnno.getAppPic());
					
					for(int j=0;j<appUserList.size();j++) {
						AppUser appUser = (AppUser) appUserList.get(j);
						if(appUser.getBaiduId() != null && !"".equals(appUser.getBaiduId()) && appUser.getChannelId() != null && !"".equals(appUser.getChannelId())) {
							//物业通知(通过PC后台，"重要通知")
							Integer success = AppPushNotificationUtil.pushNotification(
									title, 
									description, 
									appUser.getDeviceType(),
									Long.valueOf(appUser.getChannelId()).longValue(), 
									appUser.getBaiduId(),
									paramMap
									);
							//记录推送日志
							appPushLog.setUserId(appUser.getUserId());
						    appPushLog.setUserName(appUser.getRealname());
						    appPushLog.setBaiduId(appUser.getBaiduId());
						    appPushLog.setChannelId(appUser.getChannelId());
						    appPushLog.setTitle(title);
						    appPushLog.setDescription(description);
						    appPushLog.setSendTime(new Timestamp(System.currentTimeMillis()));
						    appPushLog.setSendState(success);
						    appPushLog.setSenderId(getUser().getUserId());
						    appPushLog.setSenderName(getUser().getUserName());
							appPushLogService.save(appPushLog);
						}							
					}
				}
			}
			
            response.setHeader("Cache-Control", "no-cache");
            response.setCharacterEncoding("utf-8");
			
			json = "{\"success\":\"true\",\"message\":\"接受成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"接受失败\"}";
			GSLogger.error("显示businessAnno列表时发生错误：/business/businessAnno/list", e);
			e.printStackTrace();
		}
        try {
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 拒绝
     * @param annoId
     * @param response
     */
    @RequestMapping(value="refuseAnno")
    public void refuseAnno(@RequestParam(value="annoId") String annoId, HttpServletRequest request, HttpServletResponse response) {
    	int id = Integer.parseInt(annoId);
        String json = "";
        try{
        	String refuseMemo = request.getParameter("refuseMemo");
        	BusinessAnno businessAnno = businessAnnoService.findById(id);
        	businessAnno.setPublishState(3);//未通过
        	businessAnno.setDelMemo(refuseMemo);
        	businessAnno.setEditTime(new Timestamp(System.currentTimeMillis()));
        	businessAnno.setEditor(CommonUtils.getUser().getUserName());
        	businessAnnoService.update(businessAnno);
            response.setHeader("Cache-Control", "no-cache");
            response.setCharacterEncoding("utf-8");
			
			json = "{\"success\":\"true\",\"message\":\"拒绝成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"拒绝失败\"}";
			GSLogger.error("删除BusinessAnno时发生错误：/business/businessAnno/refuseAnno", e);
			e.printStackTrace();
		}
        try {
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 根据annoId和驿站类型查询当前所有置顶的驿站公告
     * @param query
     * @param response
     */
    @RequestMapping(value="setTop")
    public void setTop(@RequestParam(value="annoId") String annoId, HttpServletResponse response) {
        String json = "";
        try{
        	int size = 2;  //最大置顶数
        	Map paramMap = new HashMap();
        	paramMap.put("annoType" ,4);  //驿站公告
        	paramMap.put("isImportant",  1);
        	List<BusinessAnno> list = businessAnnoService.findByMap(paramMap);
        	
        	BusinessAnno businessAnno = businessAnnoService.findById(Integer.parseInt(annoId));
        	
        	//查询出"驿站"列表中置顶的条数小于最大置顶数
        	if(list.size() < size) {
    			json = "{\"annotitle\":\""+businessAnno.getAnnoTitle()+"\",\"oldannotitle\":\"\",\"oldannoId\":\"\"}";
        	} else {
    			json = "{\"annotitle\":\""+businessAnno.getAnnoTitle()+"\",\"oldannotitle\":\""+ list.get(0).getAnnoTitle()+"\",\"oldannoId\":\"" + list.get(0).getAnnoId()+"\"}";
        	}
            response.setHeader("Cache-Control", "no-cache");
            response.setCharacterEncoding("utf-8");
		}catch(Exception e){
			GSLogger.error("删除BusinessAnno时发生错误：/business/businessAnno/setTop", e);
			e.printStackTrace();
		}
        try {
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
	 * 置顶驿站公告
	 * @param request
	 * @param businessAnno
	 * @return
	 */
	@RequestMapping(value="updateAnnoImportantState")
	public void updateAnnoImportantState(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="id") String id, @RequestParam(value="oldannoId") String oldannoId) {
		BusinessAnno businessAnno0 = new BusinessAnno();
		BusinessAnno businessAnno = new BusinessAnno();
		String json = "";
		try{
			if(!oldannoId.trim().equals("")) {
				businessAnno0.setAnnoId(Integer.parseInt(oldannoId));
				businessAnno0.setIsImportant(0);
				businessAnno0.setImportantTime(null);
				businessAnno0.setEditTime(new Timestamp(System.currentTimeMillis()));
				businessAnno0.setEditor(CommonUtils.getUser().getUserName());
				businessAnnoService.update(businessAnno0);
			} 
			businessAnno.setAnnoId(Integer.parseInt(id));
			businessAnno.setIsImportant(1);
			businessAnno.setImportantTime(new Timestamp(System.currentTimeMillis()));
			businessAnno.setEditTime(new Timestamp(System.currentTimeMillis()));
        	businessAnno.setEditor(CommonUtils.getUser().getUserName());
			businessAnnoService.update(businessAnno);
			
			Map paramMap = new HashMap();
			paramMap.put("id", businessAnno.getAnnoId());
			List list = appHomepageService.findByMap(paramMap);
			AppHomepage appHomepage = (AppHomepage)list.get(0);
			if(appHomepage != null) {
				if(appHomepage.getTop() == 0 && businessAnno.getIsImportant() == 1) {
					appHomepage.setTop(1);
					appHomepageService.update(appHomepage);
				}
			}
			
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"置顶成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"置顶失败\"}";
			GSLogger.error("显示businessAnno列表时发生错误：/business/businessAnno/list", e);
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