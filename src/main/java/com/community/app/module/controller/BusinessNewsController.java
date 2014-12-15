package com.community.app.module.controller;

import static com.community.framework.utils.CommonUtils.getUser;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.community.app.module.bean.AppFocusScope;
import com.community.app.module.bean.AppHomepage;
import com.community.app.module.bean.AppHomepageScope;
import com.community.app.module.bean.AppLatestNews;
import com.community.app.module.bean.AppPushLog;
import com.community.app.module.bean.AppUser;
import com.community.app.module.bean.AppUserConfig;
import com.community.app.module.bean.BusinessBreak;
import com.community.app.module.bean.BusinessCommunity;
import com.community.app.module.bean.BusinessFocus;
import com.community.app.module.bean.BusinessNews;
import com.community.app.module.bean.BusinessNewsScope;
import com.community.app.module.bean.ManageEstate;
import com.community.app.module.bean.ShiroUser;
import com.community.app.module.common.ModuleConst;
import com.community.app.module.push.AppPushNotificationUtil;
import com.community.app.module.service.AppFocusScopeService;
import com.community.app.module.service.AppHomepageScopeService;
import com.community.app.module.service.AppHomepageService;
import com.community.app.module.service.AppLatestNewsService;
import com.community.app.module.service.AppPushLogService;
import com.community.app.module.service.AppUserConfigService;
import com.community.app.module.service.AppUserService;
import com.community.app.module.service.BusinessBreakSelectService;
import com.community.app.module.service.BusinessBreakService;
import com.community.app.module.service.BusinessCommunityService;
import com.community.app.module.service.BusinessFocusService;
import com.community.app.module.service.BusinessNewsCommentService;
import com.community.app.module.service.BusinessNewsScopeService;
import com.community.app.module.service.BusinessNewsService;
import com.community.app.module.service.BusinessUserService;
import com.community.app.module.service.ManageEstateService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessNewsCommentQuery;
import com.community.app.module.vo.BusinessNewsQuery;
import com.community.framework.utils.CommonUtils;
import com.community.framework.utils.Uploader;

@Controller
@RequestMapping("/business/businessNews")
public class BusinessNewsController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessNewsController.class);
	@Autowired
	private BusinessNewsService businessNewsService;
	@Autowired
	private BusinessUserService businessUserService;
	@Autowired
	private BusinessCommunityService businessCommunityService;
	@Autowired
	private BusinessNewsCommentService businessNewsCommentService;
	@Autowired
	private BusinessBreakSelectService businessBreakSelectService;
	@Autowired
	private BusinessBreakService businessBreakService;
	@Autowired
	private AppHomepageService appHomepageService;
	@Autowired
	private AppHomepageScopeService appHomepageScopeService;
	@Autowired
	private AppLatestNewsService appLatestNewsService;
	@Autowired
	private AppUserService appUserService;
	@Autowired
	private AppPushLogService appPushLogService;
	@Autowired
	private BusinessFocusService businessFocusService;
	@Autowired
	private ManageEstateService manageEstateService;
	@Autowired
	private AppFocusScopeService appFocusScopeService;
	@Autowired
	private AppUserConfigService appUserConfigService;
	@Autowired
	private BusinessNewsScopeService businessNewsScopeService;
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="list")
	public ModelAndView list(BusinessNewsQuery query) {		
		BaseBean baseBean = new BaseBean();
		try{
			ShiroUser shiroUser = CommonUtils.getUser();
			if(!ModuleConst.OPERATION_CODE.equals(shiroUser.getOrgType())) { 
				query.setCurUserId(shiroUser.getUserId());
			}
			if(shiroUser.getCurComId() != null && shiroUser.getCurComId() != 0) {
				query.setCurComId(shiroUser.getCurComId());
			}
			// query.setRows(11);
			query.setOrder("desc");
			if((query.getSort() == null || "".equals(query.getSort())) && (query.getState() == null || "".equals(query.getState()))) {
				query.setSort("editTime");
			}	
			Subject currentUser = SecurityUtils.getSubject();  
			if (currentUser.isPermitted("news_publish")) {  //鏂板鏂伴椈鍔熻兘灞曠ず浼氬奖鍝嶅垎椤?
				query.setRows(11);
			} else {  
				query.setRows(12);
			}
			baseBean = businessNewsService.findAllPage(query);
			
		}catch(Exception e){
			GSLogger.error("进入businessNews管理页时发生错误：/business/businessNews/list", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/news/list");
		mav.addObject("baseBean", baseBean);
		mav.addObject("pager", baseBean.getPager());
		mav.addObject("sort", query.getSort());
		mav.addObject("state", query.getState());
		mav.addObject("dateField", query.getDateField());
		mav.addObject("timeScope", query.getTimeScope());
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="getPageList")
	public void getPageList(BusinessNewsQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			ShiroUser shiroUser = CommonUtils.getUser();
			if(!ModuleConst.OPERATION_CODE.equals(shiroUser.getOrgType())) { 
				query.setCurUserId(shiroUser.getUserId());
			}
			if(shiroUser.getCurComId() != null && shiroUser.getCurComId() != 0) {
				query.setCurComId(shiroUser.getCurComId());
			}
			// query.setRows(11);
			query.setOrder("desc");
			if(!("").equals(query.getOrderBy()) && query.getOrderBy() != null) {
				query.setSort(query.getOrderBy());
			}else{
				query.setSort("editTime");
			}
			Subject currentUser = SecurityUtils.getSubject();  
			if (currentUser.isPermitted("news_publish")) {  //社区和驿站根据小区范围数据范围不同
				query.setRows(11);
			} else {  
				query.setRows(12);
			}
			
			BaseBean baseBean = businessNewsService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",");
			result.append("\"pageId\":").append(baseBean.getPager().getPageId()).append(",");
			result.append("\"pageCount\":").append(baseBean.getPager().getPageCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessNews businessNews = (BusinessNews) baseBean.getList().get(i);
				result.append("{")
			    .append("\"newsId\":\"").append(businessNews.getNewsId()).append("\"").append(",")
			    .append("\"title\":\"").append(businessNews.getTitle()).append("\"").append(",")
			    .append("\"content\":\"").append(businessNews.getContent().replaceAll("(\r?\n()+)", "").replace("\"", "\\\"")).append("\"").append(",")
			    .append("\"pageUrl\":\"").append(businessNews.getPageUrl()).append("\"").append(",")
			    .append("\"brief\":\"").append(businessNews.getBrief()).append("\"").append(",")
			    .append("\"subjectPic\":\"").append(businessNews.getSubjectPic()).append("\"").append(",")
			    .append("\"newsType\":\"").append(businessNews.getNewsType()).append("\"").append(",")
			    .append("\"publisherId\":\"").append(businessNews.getPublisherId()).append("\"").append(",")
			    .append("\"publisherName\":\"").append(businessNews.getPublisherName()).append("\"").append(",")
			    .append("\"publishTime\":\"").append(businessNews.getPublishTime()).append("\"").append(",")
			    .append("\"comName\":\"").append(businessNews.getComName()).append("\"").append(",")
			    .append("\"state\":\"").append(businessNews.getState()).append("\"").append(",")
			    .append("\"auditorId\":\"").append(businessNews.getAuditorId()).append("\"").append(",")
			    .append("\"auditorName\":\"").append(businessNews.getAuditorName()).append("\"").append(",")
			    .append("\"auditTime\":\"").append(businessNews.getAuditTime()).append("\"").append(",")
			    .append("\"auditInfo\":\"").append(businessNews.getAuditInfo()).append("\"").append(",")
			    .append("\"visits\":\"").append(businessNews.getVisits()).append("\"").append(",")
			    .append("\"comments\":\"").append(businessNews.getComments()).append("\"").append(",")
			    .append("\"supports\":\"").append(businessNews.getSupports()).append("\"").append(",")
			    .append("\"publishScope\":\"").append(businessNews.getPublishScope()).append("\"").append(",")
			    .append("\"setTime\":\"").append(businessNews.getSetTime()).append("\"").append(",")
			    .append("\"isHot\":\"").append(businessNews.getIsHot()).append("\"").append(",")
			    .append("\"isAd\":\"").append(businessNews.getIsAd()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessNews.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessNews.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessNews.getEditor()).append("\"").append(",")
			    .append("\"isPush\":\"").append(businessNews.getIsPush()).append("\"").append(",")
			    .append("\"isRecommend\":\"").append(businessNews.getIsRecommend()).append("\"")
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
			GSLogger.error("显示businessNews列表时发生错误：/business/businessNews/list", e);
			e.printStackTrace();
		}
	}
	
	 /**
     * 查询新闻评论信息
     * @param query
     * @param response
     */    
    @RequestMapping(value="getNewsCommentList")
	public ModelAndView getNewsCommentList(@RequestParam(value="newsId") String newsId) {
        BaseBean baseBean = new BaseBean();
        BusinessNews businessNews = new BusinessNews();
		BusinessNewsCommentQuery query = new BusinessNewsCommentQuery();
		try{
            query.setNewsId(Integer.parseInt(newsId));
            query.setRows(12);
            query.setOrder("desc");
            query.setSort("commentId");
			
            baseBean = businessNewsCommentService.findAllPage_manage(query);
            businessNews = businessNewsService.findById(Integer.parseInt(newsId));
                 
		}catch(Exception e){
			GSLogger.error("进入businessNews管理页时发生错误：/business/businessNews/comment", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/news/comment");
        mav.addObject("baseBean", baseBean);
        mav.addObject("businessNews", businessNews);
        mav.addObject("pager", baseBean.getPager());
        
		return mav;
	}
    
    /**
     * 根据newId查询当前所有置顶的新闻
     * @param query
     * @param response
     */
    @RequestMapping(value="findAllHotById")
    public void findAllHotById(HttpServletResponse response, @RequestParam(value="id") String id) {
    	String json = "";
        try{
        	int size = 2;  //最大置顶数
        	List<BusinessNews> list = businessNewsService.findAllHotById();
        	BusinessNews businessNews = businessNewsService.findById(Integer.parseInt(id));
        	
        	//查询出列表中置顶的条数小于最大置顶数
        	if(list.size() < size) {
    			json = "{\"title\":\""+businessNews.getTitle()+"\",\"oldtitle\":\"\",\"oldnewsId\":\"\"}";
        	} else {
    			json = "{\"title\":\""+businessNews.getTitle()+"\",\"oldtitle\":\""+list.get(0).getTitle()+"\",\"oldnewsId\":\""+list.get(0).getNewsId()+"\"}";
        	}
        }catch(Exception e){
            GSLogger.error("显示businessNews列表时发生错误：/business/businessNews/list", e);
            e.printStackTrace();
        }
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("utf-8");
        try {
            response.getWriter().write(json.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
	 * 置顶纳新闻对象
	 * @param request
	 * @param businessBreak
	 * @return
	 */
	@RequestMapping(value="updateNewsHotState")
	public void updateNewsHotState(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="id") String id, @RequestParam(value="oldnewsId") String oldnewsId) {
		BusinessNews businessNews0 = new BusinessNews();
		BusinessNews businessNews = new BusinessNews();
		String json = "";
		try{
			if(!oldnewsId.trim().equals("")) {
				businessNews0.setNewsId(Integer.parseInt(oldnewsId));
				businessNews0.setIsHot(0);
				businessNews0.setHotTime(null);
				businessNews0.setEditTime(new Timestamp(System.currentTimeMillis()));
				businessNewsService.update(businessNews0);
			} 
			businessNews.setNewsId(Integer.parseInt(id));
			businessNews.setIsHot(1);
			businessNews.setHotTime(new Timestamp(System.currentTimeMillis()));
			businessNews.setEditTime(new Timestamp(System.currentTimeMillis()));
			businessNewsService.update(businessNews);
			
			Map paramMap = new HashMap();
			paramMap.put("id", businessNews.getNewsId());
			paramMap.put("type", "0");
			List list = appHomepageService.findByMap(paramMap);
			AppHomepage appHomepage = (AppHomepage)list.get(0);
			if(appHomepage != null) {
				if(appHomepage.getTop() != 1) {
					appHomepage.setTop(1);
					appHomepageService.update(appHomepage);
				}
			}
			
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"置顶成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"置顶失败\"}";
			GSLogger.error("显示businessNews列表时发生错误：/business/businessNews/list", e);
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
     * 查询新闻信息
     * @param query
     * @param response
     */
    @RequestMapping(value="getNewsDetail")
    public void getNewsDetail(BusinessNewsQuery query, HttpServletResponse response) {
        try{
        	BusinessNews businessNews = businessNewsService.findById(query.getNewsId());
        	JSONObject jsons= JSONObject.fromObject(businessNews);
        	
            response.setHeader("Cache-Control", "no-cache");
            response.setCharacterEncoding("utf-8");
            try {
                response.getWriter().write(jsons.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }catch(Exception e){
            GSLogger.error("显示businessNews列表时发生错误：/business/businessNews/list", e);
            e.printStackTrace();
        }
    }
    
    /**
	 * 撤回发布新闻对象
	 * @param request
	 * @param businessBreak
	 * @return
	 */
	@RequestMapping(value="cancelNewsPublishState")
	public void cancelNewsPublishState(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="id") String id) {
		BusinessNewsQuery query = new BusinessNewsQuery();
		query.setNewsId(Integer.parseInt(id));
		BusinessNews businessNews = businessNewsService.findById(query.getNewsId());
		String json = "";
		try{
			businessNews.setState(1);  // 未发布
		    businessNews.setEditTime(new Timestamp(System.currentTimeMillis()));
		    businessNews.setIsHot(0);
			int count = businessNewsService.update(businessNews);
			
			if(count>0 && businessNews.getState() == 1) {
				Map paramMap = new HashMap();
				paramMap.put("id", Integer.parseInt(id));
				paramMap.put("type", 0);
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
			GSLogger.error("显示businessNews列表时发生错误：/business/businessNews/list", e);
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
	 * 发布/拒绝新闻对象
	 * @param request
	 * @param businessBreak
	 * @return
	 */
	@RequestMapping(value="updateNewsState")
	public void updateNewsState(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="id") String id, @RequestParam(value="auditInfo") String auditInfo) {
		BusinessNewsQuery query = new BusinessNewsQuery();
		query.setNewsId(Integer.parseInt(id));
		BusinessNews businessNews = businessNewsService.findById(query.getNewsId());
		String json = "";
		try{
			if(!auditInfo.equals("")) {
				businessNews.setState(3);  // 未通过
				businessNews.setAuditInfo(auditInfo);
			} else {
				businessNews.setState(0);  // 已发布
			}

		    businessNews.setEditTime(new Timestamp(System.currentTimeMillis()));
		    businessNews.setAuditorId(getUser().getUserId());
		    businessNews.setAuditorName(getUser().getUserName());
		    businessNews.setAuditTime(new Timestamp(System.currentTimeMillis()));
		    businessNews.setPublishTime(new Timestamp(System.currentTimeMillis()));
		    
			int count = businessNewsService.update(businessNews);
			//发布并可以推送
			if(businessNews.getState() == 0) {
				//查询该社区下的userId, baiduId, channelId
				List appUserList = appUserService.findUserPushIdsByCom(businessNews.getPublishScope());
				AppPushLog appPushLog = new AppPushLog();
				if(businessNews.getIsPush() == 1) {
					String title = "OK家";
					String description = "【社区报】"+businessNews.getTitle();	
					
					Map paramMap = new HashMap();
					paramMap.put("messageType", 7);
					paramMap.put("ID", businessNews.getNewsId());
					paramMap.put("title", businessNews.getTitle());
					
					for(int j=0;j<appUserList.size();j++) {
						AppUser appUser = (AppUser) appUserList.get(j);
						if(appUser.getBaiduId() != null && !"".equals(appUser.getBaiduId()) && appUser.getChannelId() != null && !"".equals(appUser.getChannelId())) {
							System.out.println("居民     "+appUser.getRealname());
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
				
				//如果是爆料则给爆料人推送信息
				if(count>0 && businessNews.getNewsType() == 1) {
					BusinessBreak businessBreak = businessBreakService.findById(businessNews.getBreakId());
					businessBreak.setIsUsed(1);
					businessBreakService.update(businessBreak);
					
					AppLatestNews appLatestNews = new AppLatestNews();
					appLatestNews.setUserId(businessBreak.getBreakerId());
					appLatestNews.setTypeId(35);
					appLatestNews.setSourceId(query.getNewsId());
					appLatestNews.setTo(0);
					appLatestNews.setEstateId(0);
					appLatestNewsService.save_app(appLatestNews);
					appLatestNews.setTypeId(0);
					appLatestNewsService.save_app(appLatestNews);
					appLatestNews.setTypeId(34);
					appLatestNewsService.save_app(appLatestNews);
					
					AppUser appUser = appUserService.findById(businessBreak.getBreakerId());
					Map paramMapTemp = new HashMap();
					paramMapTemp.put("userId", appUser.getUserId());
					List configList = appUserConfigService.findByMap(paramMapTemp);
					AppUserConfig appUserConfig = null;
					if(configList != null) {
						appUserConfig = (AppUserConfig) configList.get(0);
					}	
					if(appUserConfig != null && appUserConfig.getBrokeSwitch() == 0 && appUser.getBaiduId() != null && !"".equals(appUser.getBaiduId()) && appUser.getChannelId() != null && !"".equals(appUser.getChannelId())) {
						String title = "OK家";
						String description = "【社区报】您发布的爆料，上新闻头条了！" + businessBreak.getBreakContent();
						
						Map paramMap = new HashMap();
						paramMap.put("messageType", 8);
						paramMap.put("ID", businessBreak.getBreakerId());
						paramMap.put("title", businessNews.getTitle());
						
						Integer success = AppPushNotificationUtil.pushNotification(
								title, 
								description, 
								appUser.getDeviceType(),
								Long.valueOf(appUser.getChannelId()).longValue(), 
								appUser.getBaiduId(),
								paramMap
								);
						//记录推送日志
						appPushLog = new AppPushLog();
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
			
			//发布新闻
			if(query.getIsRecommend() != null && businessNews.getState() == 0) {
				if(query.getIsRecommend() == 0) {
					StringBuilder sb = new StringBuilder();
					BusinessFocus businessFocus = new BusinessFocus();
					businessFocus.setTitle(businessNews.getTitle());
				    businessFocus.setState(2);   // 待审核
				    businessFocus.setPicUrl("/images/icon/tp01.jpg");
				    businessFocus.setPageUrl("");
				    businessFocus.setSourceId(businessNews.getNewsId());
				    businessFocus.setSourceType(0);	// 来源类型
				    businessFocus.setIshtml(0);  // 静态
				    businessFocus.setAuditInfo("");
				    
				    Map paramMap = new HashMap();
				    paramMap.put("comId", businessNews.getPublishScope());
				    List estateList = manageEstateService.findByMap(paramMap);
				    for(int j=0;j<estateList.size();j++) {
						ManageEstate manageEstate = (ManageEstate) estateList.get(j);
						sb.append(manageEstate.getEstateName()).append(",");
					}
				    
				    businessFocus.setFocusScope(sb.toString().substring(0, sb.toString().length()-1));  //展示范围
				    businessFocus.setVisits(0);
				    businessFocus.setSupports(0);
				    businessFocus.setSelectorId(getUser().getUserId());
				    businessFocus.setSelectorName(getUser().getUserName());
				    businessFocus.setSelectTime(new Timestamp(System.currentTimeMillis()));
					businessFocusService.save(businessFocus);
					
					AppFocusScope appFocusScope = new AppFocusScope();
					for(int j=0;j<estateList.size();j++) {
						  ManageEstate manageEstate = (ManageEstate) estateList.get(j);
						  appFocusScope.setFocusId(businessFocus.getFocusId());
						  appFocusScope.setEstateId(manageEstate.getEstateId());
						  appFocusScope.setCreateTime(new Timestamp(System.currentTimeMillis()));
						  appFocusScopeService.save(appFocusScope);
					}
				} 
			}
			if(businessNews.getState() == 0){
				AppHomepage appHomepage = new AppHomepage();
				appHomepage.setId(businessNews.getNewsId());
				appHomepage.setTitle(businessNews.getTitle());
				appHomepage.setBrief(businessNews.getBrief());
				appHomepage.setPic(businessNews.getAppPic());
				if(businessNews.getNewsType() == 1){
					appHomepage.setType(5);
				} else{
					appHomepage.setType(0);
				}
				appHomepage.setPublishTime(new Timestamp(System.currentTimeMillis()));
				// appHomepage.setTop(businessNews.getIsHot());
				appHomepage.setTop(businessNews.getIsRecommend()==null?0:businessNews.getIsRecommend());
				appHomepageService.save(appHomepage);
				
				Map paramMap = new HashMap();
				paramMap.put("newsId", businessNews.getNewsId());
				List scopeList = businessNewsScopeService.findByMap(paramMap);
				for(int i=0;i<scopeList.size();i++) {
					BusinessNewsScope scope = (BusinessNewsScope)scopeList.get(i);
					AppHomepageScope appHomepageScope = new AppHomepageScope();
					appHomepageScope.setId(scope.getComId());
					appHomepageScope.setHomePageId(appHomepage.getHomePageId());
					appHomepageScope.setCreateTime(new Timestamp(System.currentTimeMillis()));
					appHomepageScopeService.save(appHomepageScope);
				}
			}	
			if(!auditInfo.equals("")) { json = "{\"success\":\"true\",\"message\":\"拒绝成功\"}"; } 
			else { json = "{\"success\":\"true\",\"message\":\"发布成功\"}"; }
		} catch(Exception e) {
			if(!auditInfo.equals("")) { json = "{\"success\":\"true\",\"message\":\"拒绝失败\"}"; } 
			else { json = "{\"success\":\"false\",\"message\":\"发布失败\"}"; }
			
			GSLogger.error("显示businessNews列表时发生错误：/business/businessNews/list", e);
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
	 * 发布/拒绝新闻对象
	 * @param request
	 * @param businessBreak
	 * @return
	 */
	@RequestMapping(value="updateNewsStatePassNews")
	public void updateNewsStatePassNews(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="id") String id) {
		BusinessNewsQuery query = new BusinessNewsQuery();
		query.setNewsId(Integer.parseInt(id));
		BusinessNews businessNews = businessNewsService.findById(query.getNewsId());
		String json = "";
		try{
			businessNews.setState(4);  // 通过审核
		    businessNews.setEditTime(new Timestamp(System.currentTimeMillis()));
		    businessNews.setAuditorId(getUser().getUserId());
		    businessNews.setAuditorName(getUser().getUserName());
		    businessNews.setAuditTime(new Timestamp(System.currentTimeMillis()));
		    businessNews.setPublishTime(new Timestamp(System.currentTimeMillis()));
			businessNewsService.update(businessNews);
			json = "{\"success\":\"true\",\"message\":\"审核通过成功\"}"; 
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"审核通过失败\"}";
			GSLogger.error("显示businessNews列表时发生错误：/business/businessNews/list", e);
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
	public ModelAndView add(BusinessNewsQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessNews新增页时发生错误：/business/businessNews/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/news/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessNews
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessNewsQuery query) {
		BusinessNews businessNews = new BusinessNews();
		String json = "";
		try{
		    businessNews.setTitle(query.getTitle());
		    businessNews.setContent(query.getContent());
		    businessNews.setPageUrl("");
		    businessNews.setBrief(query.getBrief());
		    businessNews.setSubjectPic(query.getSubjectPic());
		    businessNews.setAppPic(query.getAppPic());
		    businessNews.setNewsType(0);
		    ShiroUser shiroUser = CommonUtils.getUser();
		    businessNews.setPublisherId(shiroUser.getUserId());
		    businessNews.setPublisherName(shiroUser.getUserName());
		    businessNews.setState(query.getState());
		    if(query.getState() == 0) {//已发布，保存发布时间，其他需要根据状态改变而保存发布时间
		    	businessNews.setPublishTime(new Timestamp(System.currentTimeMillis()));
		    }
		    businessNews.setAuditorId(0);
		    businessNews.setAuditorName("");
		    businessNews.setPublishTime(new Timestamp(System.currentTimeMillis()));
		    businessNews.setVisits(0);
		    businessNews.setComments(0);
		    businessNews.setSupports(0);
		    businessNews.setIsHot(0);
		    businessNews.setIsAd(0);
		    businessNews.setBreakId(query.getBreakId());
            //社区范围
		    BusinessCommunity businessCommunity = businessCommunityService.findById(getUser().getOrgId());
            if(businessCommunity == null) {
            	businessNews.setPublishScope(0);
    		    businessNews.setComName("");  //社区名称
            } else {
            	businessNews.setPublishScope(businessCommunity.getComId());
    		    businessNews.setComName(businessCommunity.getComName());  //社区名称
            }
            
		    businessNews.setEditor(getUser().getUserName());
		    businessNews.setIsPush(query.getIsPush());
		    if(query.getIsRecommend() != null) {//选择了推荐
		    	businessNews.setIsRecommend(query.getIsRecommend());
		    }
	        businessNews.setCreateTime(new Timestamp(System.currentTimeMillis()));
	        businessNews.setEditTime(new Timestamp(System.currentTimeMillis()));
	        
			businessNewsService.save(businessNews);
			
			//保存新闻范围
			String newsScope = query.getNewsScope();
			if(newsScope != null && !"".equals(newsScope)) {
				BusinessNewsScope scope = null;
				String[] coms = newsScope.split(",");
				for(int i=0;i<coms.length;i++) {
					String[] comId = coms[i].split(":");
					scope = new BusinessNewsScope();
					scope.setNewsId(businessNews.getNewsId());
					scope.setCreateTime(new Timestamp(System.currentTimeMillis()));
					scope.setComId(new Integer(comId[0]));
					scope.setComName(comId[1]);
					businessNewsScopeService.save(scope);
				}
			}
			
			if(query.getIsRecommend() != null && businessNews.getState() == 0) {
				if(query.getIsRecommend() == 0) {
					StringBuilder sb = new StringBuilder();
					BusinessFocus businessFocus = new BusinessFocus();
					businessFocus.setTitle(businessNews.getTitle());
				    businessFocus.setState(2);   // 待审核
				    businessFocus.setPicUrl("/images/icon/tp01.jpg");
				    businessFocus.setPageUrl("");
				    businessFocus.setSourceId(businessNews.getNewsId());
				    businessFocus.setSourceType(0);	// 来源类型
				    businessFocus.setIshtml(0);  // 静态
				    businessFocus.setAuditInfo("");
				    
				    Map paramMap = new HashMap();
				    paramMap.put("comId", businessNews.getPublishScope());
				    List estateList = manageEstateService.findByMap(paramMap);
				    for(int j=0;j<estateList.size();j++) {
						ManageEstate manageEstate = (ManageEstate) estateList.get(j);
						sb.append(manageEstate.getEstateName()).append(",");
					}
				    
				    businessFocus.setFocusScope(sb.toString().substring(0, sb.toString().length()-1));  //展示范围
				    businessFocus.setVisits(0);
				    businessFocus.setSupports(0);
				    businessFocus.setSelectorId(shiroUser.getUserId());
				    businessFocus.setSelectorName(shiroUser.getUserName());
				    businessFocus.setSelectTime(new Timestamp(System.currentTimeMillis()));
					businessFocusService.save(businessFocus);
					
					AppFocusScope appFocusScope = new AppFocusScope();
					for(int j=0;j<estateList.size();j++) {
						  ManageEstate manageEstate = (ManageEstate) estateList.get(j);
						  appFocusScope.setFocusId(businessFocus.getFocusId());
						  appFocusScope.setEstateId(manageEstate.getEstateId());
						  appFocusScope.setCreateTime(new Timestamp(System.currentTimeMillis()));
						  appFocusScopeService.save(appFocusScope);
					}
				}
				
			}
			if(businessNews.getState() == 0){
				AppHomepage appHomepage = new AppHomepage();
				appHomepage.setId(businessNews.getNewsId());
				appHomepage.setTitle(businessNews.getTitle());
				appHomepage.setBrief(businessNews.getBrief());
				appHomepage.setPic(businessNews.getAppPic());
				if(businessNews.getNewsType() == 1){
					appHomepage.setType(5);
				} else{
					appHomepage.setType(0);
				}
				appHomepage.setPublishTime(new Timestamp(System.currentTimeMillis()));
				// appHomepage.setTop(businessNews.getIsHot());
				appHomepage.setTop(businessNews.getIsRecommend()==null?0:businessNews.getIsRecommend());
				appHomepageService.save(appHomepage);
				
				if(newsScope != null && !"".equals(newsScope)) {
					String[] coms = newsScope.split(",");
					for(int i=0;i<coms.length;i++) {
						String[] comId = coms[i].split(":");
						AppHomepageScope appHomepageScope = new AppHomepageScope();
						appHomepageScope.setId(Integer.parseInt(comId[0]));
						appHomepageScope.setHomePageId(appHomepage.getHomePageId());
						appHomepageScope.setCreateTime(new Timestamp(System.currentTimeMillis()));
						appHomepageScopeService.save(appHomepageScope);
					}
				}
			}					
			//发布并可以推送
			if(businessNews.getState() == 0 && businessNews.getIsPush() == 1) {
				//查询该社区下的userId, baiduId, channelId
				List appUserList = appUserService.findUserPushIdsByCom(businessNews.getPublishScope());
				AppPushLog appPushLog = new AppPushLog();
				String title = "OK家";
				String description = "【社区报】"+businessNews.getTitle();		
				
				Map paramMap = new HashMap();
				paramMap.put("messageType", 7);
				paramMap.put("ID", businessNews.getNewsId());
				paramMap.put("title", businessNews.getTitle());
				
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
					    appPushLog.setSenderId(getUser().getUserId());
					    appPushLog.setSenderName(getUser().getUserName());
						appPushLogService.save(appPushLog);
					}
				}
			}	
			
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessNews信息时发生错误：/business/businessNews/save", e);
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
	public ModelAndView modify(BusinessNewsQuery query) {	
		BusinessNews businessNews = new BusinessNews();
		List scopeList = new ArrayList();
		String newsScope = "";
		try{
			businessNews = businessNewsService.findById(query.getNewsId());
			Map paramMap = new HashMap();
			paramMap.put("newsId", businessNews.getNewsId());
			scopeList = businessNewsScopeService.findByMap(paramMap);
			for(int i=0; i<scopeList.size(); i++) {
				BusinessNewsScope scope = (BusinessNewsScope)scopeList.get(i);
				newsScope+= "," + scope.getComId()+":"+scope.getComName();
			}
		}catch(Exception e){
			GSLogger.error("进入businessNews修改页时发生错误：/business/businessNews/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/news/modify");
		mav.addObject("businessNews", businessNews);
		mav.addObject("scopeList", scopeList);
		mav.addObject("newsScope", newsScope.substring(1));
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessNewsQuery query) {
		BusinessNews businessNews = null;
		String json = "";
		try{
		    businessNews = businessNewsService.findById(query.getNewsId());
		    businessNews.setTitle(query.getTitle());
		    businessNews.setContent(query.getContent());
		    businessNews.setPageUrl("");
		    businessNews.setBrief(query.getBrief());
		    String path = request.getContextPath();
		    String ctx = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
		    if(query.getSubjectPic() != null && !"".equals(query.getSubjectPic())) {
		    	File file = new File(ctx + businessNews.getSubjectPic());
		    	file.delete();
		    	businessNews.setSubjectPic(query.getSubjectPic());
		    }
		    if(query.getAppPic() != null  && !"".equals(query.getAppPic())) {
		    	File file = new File(ctx + businessNews.getAppPic());
		    	file.delete();
		    	businessNews.setAppPic(query.getAppPic());
		    }
		    if(query.getSelectId() != null && query.getBreakId() == 0 && query.getSelectId() == 0){
			    ShiroUser shiroUser = CommonUtils.getUser();
			    businessNews.setPublisherId(shiroUser.getUserId());
			    businessNews.setPublisherName(shiroUser.getUserName());
		    }
		    businessNews.setState(query.getState());
		    if(query.getState() == 0) {//已发布，保存发布时间，其他需要根据状态改变而保存发布时间
		    	businessNews.setPublishTime(new Timestamp(System.currentTimeMillis()));
		    }
		    businessNews.setAuditorId(0);
		    businessNews.setAuditorName("");
		    businessNews.setEditTime(new Timestamp(System.currentTimeMillis()));
		    businessNews.setEditor(getUser().getUserName());
		    businessNews.setIsPush(query.getIsPush());
		    if(query.getIsPush() == 1) {//选择了推送
		    	//推送处理逻辑
		    }
		    if(query.getIsRecommend() != null) {//选择了推荐
		    	businessNews.setIsRecommend(query.getIsRecommend());
		    }
			int count = businessNewsService.update(businessNews);
			
			//更新新闻范围
			String newsScope = query.getNewsScope();
			if(newsScope != null && !"".equals(newsScope)) {
				//先删除之前的范围
				businessNewsScopeService.deleteScopeByNews(businessNews.getNewsId());
				BusinessNewsScope scope = null;
				String[] coms = newsScope.split(",");
				for(int i=0;i<coms.length;i++) {
					String[] comId = coms[i].split(":");
					scope = new BusinessNewsScope();
					scope.setNewsId(businessNews.getNewsId());
					scope.setCreateTime(new Timestamp(System.currentTimeMillis()));
					scope.setComId(new Integer(comId[0]));
					scope.setComName(comId[1]);
					businessNewsScopeService.save(scope);
				}		
			}
				
			if(query.getIsRecommend() != null && businessNews.getState() == 0) {
				if(query.getIsRecommend() == 0) {
					StringBuilder sb = new StringBuilder();
					BusinessFocus businessFocus = new BusinessFocus();
					businessFocus.setTitle(businessNews.getTitle());
				    businessFocus.setState(2);   // 待审核
				    businessFocus.setPicUrl("/images/icon/tp01.jpg");
				    businessFocus.setPageUrl("");
				    businessFocus.setSourceId(businessNews.getNewsId());
				    businessFocus.setSourceType(0);	// 来源类型
				    businessFocus.setIshtml(0);  // 静态
				    businessFocus.setAuditInfo("");
				    
				    Map paramMap = new HashMap();
				    paramMap.put("comId", businessNews.getPublishScope());
				    List estateList = manageEstateService.findByMap(paramMap);
				    for(int j=0;j<estateList.size();j++) {
						ManageEstate manageEstate = (ManageEstate) estateList.get(j);
						sb.append(manageEstate.getEstateName()).append(",");
					}
				    
				    businessFocus.setFocusScope(sb.toString().substring(0, sb.toString().length()-1));  //展示范围
				    businessFocus.setVisits(0);
				    businessFocus.setSupports(0);
				    businessFocus.setSelectorId(getUser().getUserId());
				    businessFocus.setSelectorName(getUser().getUserName());
				    businessFocus.setSelectTime(new Timestamp(System.currentTimeMillis()));
					businessFocusService.save(businessFocus);
					
					AppFocusScope appFocusScope = new AppFocusScope();
					for(int j=0;j<estateList.size();j++) {
						  ManageEstate manageEstate = (ManageEstate) estateList.get(j);
						  appFocusScope.setFocusId(businessFocus.getFocusId());
						  appFocusScope.setEstateId(manageEstate.getEstateId());
						  appFocusScope.setCreateTime(new Timestamp(System.currentTimeMillis()));
						  appFocusScopeService.save(appFocusScope);
					}
				}

			}
			if(businessNews.getState() == 0){
				AppHomepage appHomepage = new AppHomepage();
				appHomepage.setId(businessNews.getNewsId());
				appHomepage.setTitle(businessNews.getTitle());
				appHomepage.setBrief(businessNews.getBrief());
				appHomepage.setPic(businessNews.getAppPic());
				if(businessNews.getNewsType() == 1){
					appHomepage.setType(5);
				} else{
					appHomepage.setType(0);
				}
				appHomepage.setPublishTime(new Timestamp(System.currentTimeMillis()));
				// appHomepage.setTop(businessNews.getIsHot());
				appHomepage.setTop(businessNews.getIsRecommend()==null?0:businessNews.getIsRecommend());
				appHomepageService.save(appHomepage);
				
				if(newsScope != null && !"".equals(newsScope)) {
					String[] coms = newsScope.split(",");
					for(int i=0;i<coms.length;i++) {
						String[] comId = coms[i].split(":");
						AppHomepageScope appHomepageScope = new AppHomepageScope();
						appHomepageScope.setId(Integer.parseInt(comId[0]));
						appHomepageScope.setHomePageId(appHomepage.getHomePageId());
						appHomepageScope.setCreateTime(new Timestamp(System.currentTimeMillis()));
						appHomepageScopeService.save(appHomepageScope);
					}
				}
			}
			//发布并可以推送
			if(businessNews.getState() == 0) {
				//查询该社区下的userId, baiduId, channelId
				List appUserList = appUserService.findUserPushIdsByCom(businessNews.getPublishScope());
				AppPushLog appPushLog = new AppPushLog();
				if(businessNews.getIsPush() == 1) {
					String title = "OK家";
					String description = "【社区报】"+businessNews.getTitle();	
					
					Map paramMap = new HashMap();
					paramMap.put("messageType", 7);
					paramMap.put("ID", businessNews.getNewsId());
					paramMap.put("title", businessNews.getTitle());
					
					for(int j=0;j<appUserList.size();j++) {
						AppUser appUser = (AppUser) appUserList.get(j);
						if(appUser.getBaiduId() != null && !"".equals(appUser.getBaiduId()) && appUser.getChannelId() != null && !"".equals(appUser.getChannelId())) {
							System.out.println("居民     "+appUser.getRealname());
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
				
				//如果是爆料则给爆料人推送信息
				if(count>0 && businessNews.getNewsType() == 1) {
					BusinessBreak businessBreak = businessBreakService.findById(query.getBreakId());
					businessBreak.setIsUsed(1);
					businessBreakService.update(businessBreak);
					
					AppLatestNews appLatestNews = new AppLatestNews();
					appLatestNews.setUserId(businessBreak.getBreakerId());
					appLatestNews.setTypeId(35);
					appLatestNews.setSourceId(query.getNewsId());
					appLatestNews.setTo(0);
					appLatestNews.setEstateId(0);
					appLatestNewsService.save_app(appLatestNews);
					appLatestNews.setTypeId(0);
					appLatestNewsService.save_app(appLatestNews);
					appLatestNews.setTypeId(34);
					appLatestNewsService.save_app(appLatestNews);
					
					AppUser appUser = appUserService.findById(businessBreak.getBreakerId());
					Map paramMapTemp = new HashMap();
					paramMapTemp.put("userId", appUser.getUserId());
					List configList = appUserConfigService.findByMap(paramMapTemp);
					AppUserConfig appUserConfig = null;
					if(configList != null) {
						appUserConfig = (AppUserConfig) configList.get(0);
					}	
					if(appUserConfig != null && appUserConfig.getBrokeSwitch() == 0 && appUser.getBaiduId() != null && !"".equals(appUser.getBaiduId()) && appUser.getChannelId() != null && !"".equals(appUser.getChannelId())) {
						String title = "OK家";
						String description = "【社区报】您发布的爆料，上新闻头条了！" + businessBreak.getBreakContent();
						
						Map paramMap = new HashMap();
						paramMap.put("messageType", 8);
						paramMap.put("ID", businessNews.getNewsId());
						paramMap.put("title", businessNews.getTitle());
						
						Integer success = AppPushNotificationUtil.pushNotification(
								title, 
								description, 
								appUser.getDeviceType(),
								Long.valueOf(appUser.getChannelId()).longValue(), 
								appUser.getBaiduId(),
								paramMap
								);
						//记录推送日志
						appPushLog = new AppPushLog();
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
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessNews信息时发生错误：/business/businessNews/update", e);
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
						businessNewsService.delete(new Integer(ids[i]));
					}
				}else{
					Boolean  result = businessNewsService.delete(new Integer(id));
					if(result) {
						businessNewsScopeService.deleteScopeByNews(new Integer(id));
						Map paramMap = new HashMap();
						paramMap.put("id", Integer.parseInt(id));
						paramMap.put("type", 0);
						List<AppHomepage> list = appHomepageService.findByMap(paramMap);
						
						if(list.size() == 1) {
							AppHomepage AppHomepage = (AppHomepage)list.get(0);
							appHomepageService.delete(AppHomepage);
							appHomepageScopeService.delete(AppHomepage.getHomePageId());
						}
					}
				}
			}
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessNews时发生错误：/business/businessNews/delete", e);
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
    @RequestMapping(value="uploadNewsImg")
    public @ResponseBody String uploadNewsImg(HttpServletRequest request, @RequestParam MultipartFile[] myfile) {
        String picPath = null;
        //上传附件
        try {
            Uploader uploader = new Uploader(request);
            //paramMap = uploader.uploadForApp();
            picPath = uploader.upload("news");
        } catch(Exception e) {
        	e.printStackTrace();
        }
        //返回图片全路径
        return (String) picPath;
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
			/*ShiroUser shiroUser = CommonUtils.getUser();
			// if(ModuleConst.OPERATION_CODE.equals(shiroUser.getOrgType())) {//驿站
			List comList = businessCommunityService.findAll();
			JSONObject comObj = null;
			Map paramMap = null;
			for(int i=0;i<comList.size();i++) {
				BusinessCommunity community = (BusinessCommunity) comList.get(i);
				comObj = new JSONObject();
				paramMap = new HashMap();
				paramMap.put("comId", community.getComId());
				List estateList = manageEstateService.findByMap(paramMap); 
				if(estateList.size() > 0){
					comObj.put("id", "com_"+community.getComId());
					comObj.put("text", community.getComName());
					JSONArray estateArr = new JSONArray();
					for(int j=0;j<estateList.size();j++) {
						ManageEstate estate = (ManageEstate) estateList.get(j);
						JSONObject estateObj = new JSONObject();
						estateObj.put("id", "estate_"+estate.getEstateId());
						estateObj.put("text", estate.getEstateName());
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
			jsonObj.put("result", comArr);*/
			
			ShiroUser shiroUser = CommonUtils.getUser();
			//获取该用户负责的多社区范围
			List comList = businessCommunityService.findComsByUser(shiroUser.getUserId());
			JSONObject comObj = null;
			Map paramMap = null;
			for(int i=0;i<comList.size();i++) {
				BusinessCommunity community = (BusinessCommunity) comList.get(i);
				comObj = new JSONObject();
				paramMap = new HashMap();
				paramMap.put("comId", community.getComId());
				List estateList = manageEstateService.findByMap(paramMap); 
				if(estateList.size() > 0){
					comObj.put("id", "com_"+community.getComId());
					comObj.put("text", community.getComName());
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
}