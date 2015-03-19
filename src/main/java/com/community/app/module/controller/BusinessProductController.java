package com.community.app.module.controller;

import static com.community.framework.utils.CommonUtils.getUser;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import com.community.app.module.bean.AppLatestNews;
import com.community.app.module.bean.AppPushLog;
import com.community.app.module.bean.AppUser;
import com.community.app.module.bean.AppUserConfig;
import com.community.app.module.bean.BusinessOpertaion;
import com.community.app.module.bean.BusinessProduct;
import com.community.app.module.bean.BusinessProductPic;
import com.community.app.module.bean.BusinessProductType;
import com.community.app.module.bean.ShiroUser;
import com.community.app.module.push.AppPushNotificationUtil;
import com.community.app.module.service.AppLatestNewsService;
import com.community.app.module.service.AppPushLogService;
import com.community.app.module.service.AppUserConfigService;
import com.community.app.module.service.AppUserService;
import com.community.app.module.service.BusinessCommunityService;
import com.community.app.module.service.BusinessOpertaionService;
import com.community.app.module.service.BusinessProductCommentService;
import com.community.app.module.service.BusinessProductPicService;
import com.community.app.module.service.BusinessProductService;
import com.community.app.module.service.BusinessProductTypeService;
import com.community.app.module.vo.AppLatestNewsQuery;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessProductCommentQuery;
import com.community.app.module.vo.BusinessProductQuery;
import com.community.framework.utils.CommonUtils;
import com.community.framework.utils.Uploader;
import com.community.framework.utils.propertiesUtil;

@Controller
@RequestMapping("/business/businessProduct")
public class BusinessProductController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessProductController.class);
	@Autowired
	private BusinessProductService businessProductService;
    @Autowired
	private BusinessProductPicService businessProductPicService;
    @Autowired
	private BusinessProductCommentService businessProductCommentService;
    @Autowired
	private AppLatestNewsService appLatestNewsService;
    @Autowired
    private AppUserService appUserService;
    @Autowired
    private AppPushLogService appPushLogService;
    @Autowired
    private AppUserConfigService appUserConfigService;
    @Autowired
	private BusinessProductTypeService businessProductTypeService;
	@Autowired
	private BusinessCommunityService businessCommunityService;
	@Autowired
	private BusinessOpertaionService businessOpertaionService;
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="list")
	public ModelAndView list(BusinessProductQuery query) {	
		BaseBean baseBean = new BaseBean();
		try{
			ShiroUser shiroUser = CommonUtils.getUser();
			//if(!ModuleConst.OPERATION_CODE.equals(shiroUser.getOrgType())) {
				query.setCurUserId(shiroUser.getUserId());//社区和驿站根据小区范围数据范围不同
			//}		
			//query.setOrgType(shiroUser.getOrgType());
			//query.setCurOrgType(shiroUser.getCurOrgType());
			
			if(shiroUser.getCurEstateId() != null && shiroUser.getCurEstateId() != 0) {
				query.setCurEstateId(shiroUser.getCurEstateId());
			}
			if(shiroUser.getCurComId() != null && shiroUser.getCurComId() != 0) {
				query.setCurComId(shiroUser.getCurComId());
			}
			Subject currentUser = SecurityUtils.getSubject();  
			if (currentUser.isPermitted("market_publish")) {  //新增二手功能展示会影响分页
				query.setRows(11);
			} else {  
				query.setRows(12);
			}
			query.setSort("editTime");
			query.setOrder("desc");
			baseBean = businessProductService.findAllPage(query);
		}catch(Exception e){
			GSLogger.error("进入businessProduct管理页时发生错误：/business/businessProduct/list", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/market/list");
		mav.addObject("baseBean", baseBean);
		mav.addObject("pager", baseBean.getPager());
		mav.addObject("dealState", query.getDealState());
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="getPageList")
	public void getPageList(BusinessProductQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			ShiroUser shiroUser = CommonUtils.getUser();
			//if(!ModuleConst.OPERATION_CODE.equals(shiroUser.getOrgType())) {
				query.setCurUserId(shiroUser.getUserId());//社区和驿站根据小区范围数据范围不同
			//}	
			//query.setOrgType(shiroUser.getOrgType());
			//query.setCurOrgType(shiroUser.getCurOrgType());
			
			if(shiroUser.getCurEstateId() != null) {
				query.setCurEstateId(shiroUser.getCurEstateId());
			}
			if(shiroUser.getCurComId() != null && shiroUser.getCurComId() != 0) {
				query.setCurComId(shiroUser.getCurComId());
			}
			Subject currentUser = SecurityUtils.getSubject();  
			if (currentUser.isPermitted("market_publish")) {  //新增二手功能展示会影响分页
				query.setRows(11);
			} else {  
				query.setRows(12);
			}
			query.setOrder("desc");
			if(!("").equals(query.getOrderBy()) && query.getOrderBy() != null) {
				query.setSort(query.getOrderBy());
			}else{
				query.setSort("editTime");
			}
			BaseBean baseBean = businessProductService.findAllPage(query);
			
			result.append("{\"total\":").append(baseBean.getCount()).append(",");
			result.append("\"pageId\":").append(baseBean.getPager().getPageId()).append(",");
			result.append("\"pageCount\":").append(baseBean.getPager().getPageCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessProduct businessProduct = (BusinessProduct) baseBean.getList().get(i);
				result.append("{")
			    .append("\"productId\":\"").append(businessProduct.getProductId()).append("\"").append(",")
			    .append("\"productName\":\"").append(businessProduct.getProductName().replace("\"", "\\\"").replaceAll("(\r?\n()+)", "")).append("\"").append(",")
			    .append("\"publisherId\":\"").append(businessProduct.getPublisherId()).append("\"").append(",")
			    .append("\"publisherName\":\"").append(businessProduct.getPublisherName().replace("\"", "\\\"").replaceAll("(\r?\n()+)", "")).append("\"").append(",")
			    .append("\"content\":\"").append(businessProduct.getContent().replace("\"", "\\\"").replaceAll("(\r?\n()+)", "")).append("\"").append(",")
			    .append("\"title\":\"").append(businessProduct.getTitle().replace("\"", "\\\"").replaceAll("(\r?\n()+)", "")).append("\"").append(",")
			    .append("\"contactName\":\"").append(businessProduct.getContactName().replace("\"", "\\\"").replaceAll("(\r?\n()+)", "")).append("\"").append(",")
			    .append("\"contactTel\":\"").append(businessProduct.getContactTel()).append("\"").append(",")
			    .append("\"contactQq\":\"").append(businessProduct.getContactQq()).append("\"").append(",")
			    .append("\"typeId\":\"").append(businessProduct.getTypeId()).append("\"").append(",")
			    .append("\"typeName\":\"").append(businessProduct.getTypeName()).append("\"").append(",")
			    .append("\"estateId\":\"").append(businessProduct.getEstateId()).append("\"").append(",")
			    .append("\"estateScope\":\"").append(businessProduct.getEstateScope()).append("\"").append(",")
			    .append("\"price\":\"").append(businessProduct.getPrice()).append("\"").append(",")
			    .append("\"isEstateAgent\":\"").append(businessProduct.getIsEstateAgent()).append("\"").append(",")
			    .append("\"publishTime\":\"").append(businessProduct.getPublishTime()).append("\"").append(",")
			    .append("\"dealState\":\"").append(businessProduct.getDealState()).append("\"").append(",")
			    .append("\"visits\":\"").append(businessProduct.getVisits()).append("\"").append(",")
			    .append("\"supports\":\"").append(businessProduct.getSupports()).append("\"").append(",")
			    .append("\"comments\":\"").append(businessProduct.getComments()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessProduct.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessProduct.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessProduct.getEditor()).append("\"").append(",")
			    .append("\"newsCount\":\"").append(businessProduct.getNewsCount()).append("\"").append(",")
			    .append("\"auditorId\":\"").append(businessProduct.getAuditorId()).append("\"").append(",")
			    .append("\"auditorName\":\"").append(businessProduct.getAuditorName()).append("\"").append(",")
			    .append("\"auditTime\":\"").append(businessProduct.getAuditTime()).append("\"").append(",")
			    .append("\"nickname\":\"").append(businessProduct.getNickname()).append("\"").append(",")
			     .append("\"realname\":\"").append(businessProduct.getRealname()).append("\"").append(",")
			    .append("\"dealType\":\"").append(businessProduct.getDealType()).append("\"")
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
			GSLogger.error("显示businessProduct列表时发生错误：/business/businessProduct/list", e);
			e.printStackTrace();
		}
	}
	
	 /**
     * 查询跳蚤市场信息
     * @param query
     * @param response
     */
    @RequestMapping(value="getProductDetail")
    public void getProductDetail(HttpServletRequest request, BusinessProductQuery query, HttpServletResponse response) {
        try{
        	String newsCount = request.getParameter("newsCount");//是否有新消息
        	StringBuilder sb = new StringBuilder();
        	BusinessProduct businessProduct = businessProductService.findProductById(query.getProductId());
        	List<BusinessProductPic> businessProductPicList = businessProductPicService.findAllPicbyId(query.getProductId());
        	for(int i=0; i<businessProductPicList.size(); i++) {
        		BusinessProductPic businessProductPic = businessProductPicList.get(i);
        		sb.append(businessProductPic.getPicPath()+"#");
        	}
        	if(sb.toString().length() > 0) {
        		businessProduct.setPicUrl(sb.toString().substring(0,sb.toString().length()-1));
        	}
    		
    		Properties p = propertiesUtil.getProperties("config.properties");
    		String ip = p.getProperty("imageIp");   
    		businessProduct.setIp(ip);
    		
        	JSONObject jsons= JSONObject.fromObject(businessProduct);
        	
        	//如果有新消息则删除消息
            if(newsCount != null && new Integer(newsCount) > 0) {
            	AppLatestNewsQuery newsQuery = new AppLatestNewsQuery();
            	newsQuery.setTypeId(39);//二手
            	newsQuery.setSourceId(query.getProductId());
            	newsQuery.setTo(1);//居民向后台发送
            	appLatestNewsService.deleteByCondition(newsQuery);
            }
        	
            response.setHeader("Cache-Control", "no-cache");
            response.setCharacterEncoding("utf-8");
            try {
                response.getWriter().write(jsons.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }catch(Exception e){
            GSLogger.error("显示businessNews列表时发生错误：/business/businessProduct/list", e);
            e.printStackTrace();
        }
    }
    
    /**
	 * 关闭已售出跳蚤信息对象
	 * @param request
	 * @param businessBreak
	 * @return
	 */
	@RequestMapping(value="saleChangeProductState")
	public void saleChangeProductState(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="id") String id) {
		BusinessProduct businessProduct = new BusinessProduct();
		String json = "";
		try{
			businessProduct.setProductId(Integer.parseInt(id));
			businessProduct.setCloseId(getUser().getUserId());
			businessProduct.setCloseName(getUser().getUserName());
			businessProduct.setCloseTime(new Timestamp(System.currentTimeMillis()));
			businessProduct.setRemarks("驿站已售出");
			businessProduct.setDealState(3);  // 已关闭
			
			businessProductService.update(businessProduct);
			
			AppLatestNews appLatestNews = new AppLatestNews();
			appLatestNews.setUserId(new Integer(request.getParameter("publisherId")));
			appLatestNews.setTypeId(2);
			appLatestNews.setSourceId(new Integer(id));
			appLatestNews.setTo(0);
			appLatestNews.setEstateId(0);
			appLatestNewsService.save_app(appLatestNews);
			appLatestNews.setTypeId(5);
			appLatestNewsService.save_app(appLatestNews);
			appLatestNews.setTypeId(6);
			appLatestNewsService.save_app(appLatestNews);
		
			json = "{\"success\":\"true\",\"message\":\"关闭成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"关闭失败\"}";
			GSLogger.error("显示businessNews列表时发生错误：/business/businessProduct/list", e);
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
	 * 发布/拒绝跳蚤信息对象
	 * @param request
	 * @param businessBreak
	 * @return
	 */
	@RequestMapping(value="updateProductState")
	public void updateProductState(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="id") String id, @RequestParam(value="auditInfo") String auditInfo) {
		BusinessProduct businessProduct = businessProductService.findProductById(Integer.parseInt(id));
		String json = "";
		try{
			if(!auditInfo.equals("")) {
				businessProduct.setDealState(2);  // 未通过
				businessProduct.setRemarks(auditInfo);
			} else {
				businessProduct.setDealState(0);  // 已发布
				businessProduct.setRemarks("");
			}
			businessProduct.setProductId(Integer.parseInt(id));
			businessProduct.setAuditorId(getUser().getUserId());
			businessProduct.setAuditorName(getUser().getUserName());
			businessProduct.setAuditTime(new Timestamp(System.currentTimeMillis()));
			businessProduct.setEditTime(new Timestamp(System.currentTimeMillis()));
			
			businessProductService.update(businessProduct);
			
			String state = "未通过";
			BusinessOpertaion entity = new BusinessOpertaion(
					getUser().getUserId(), 
					getUser().getUserName(), 
					"market", 
					"market_auditor", 
					businessProduct.getProductId(), 
					businessProduct.getProductName(), 
					state,
					request.getRemoteAddr());
			businessOpertaionService.save(entity);
			
			//保存成功
			if(businessProduct.getDealState() == 0) { 
				json = "{\"success\":\"true\",\"message\":\"发布成功\"}"; 
				AppLatestNews appLatestNews = new AppLatestNews();
				appLatestNews.setUserId(new Integer(request.getParameter("publisherId")));
				appLatestNews.setTypeId(2);
				appLatestNews.setSourceId(new Integer(id));
				appLatestNews.setTo(0);
				appLatestNews.setEstateId(0);
				appLatestNewsService.save_app(appLatestNews);
				appLatestNews.setTypeId(3);
				appLatestNewsService.save_app(appLatestNews);
				appLatestNews.setTypeId(6);
				appLatestNewsService.save_app(appLatestNews);
				
				//发布成功后发布推送通知
				businessProduct = businessProductService.findById(Integer.parseInt(id));
				AppUser appUser = appUserService.findById(businessProduct.getPublisherId());
				Map paramMapTemp = new HashMap();
				paramMapTemp.put("userId", appUser.getUserId());
				List configList = appUserConfigService.findByMap(paramMapTemp);
				AppUserConfig appUserConfig = null;
				if(configList != null) {
					appUserConfig = (AppUserConfig) configList.get(0);
				}	
				if(appUserConfig != null 
						&& appUserConfig.getMarketSwitch() == 0 
						&& appUser.getBaiduId() != null 
						&& !"".equals(appUser.getBaiduId()) 
						&& appUser.getChannelId() != null 
						&& !"".equals(appUser.getChannelId())) {
					String title = "OK家";
					String description = "【跳蚤市场】您在跳蚤市场发布的信息，已经通过审核，有时间就来看看有谁对它感兴趣了吧。";			
					
					Map paramMap = new HashMap();
					paramMap.put("messageType", 10);
					paramMap.put("ID", businessProduct.getProductId());
					
					Integer success = AppPushNotificationUtil.pushNotification(
							title, 
							description, 
							appUser.getDeviceType(), 
							new Long(appUser.getChannelId()), 
							appUser.getBaiduId(),
							paramMap
							);
					//记录推送日志
					AppPushLog appPushLog = new AppPushLog();
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
			} else { 
				json = "{\"success\":\"true\",\"message\":\"拒绝成功\"}";
				AppLatestNews appLatestNews = new AppLatestNews();
				appLatestNews.setUserId(new Integer(request.getParameter("publisherId")));
				appLatestNews.setTypeId(2);
				appLatestNews.setSourceId(new Integer(id));
				appLatestNews.setTo(0);
				appLatestNews.setEstateId(0);
				appLatestNewsService.save_app(appLatestNews);
				appLatestNews.setTypeId(5);
				appLatestNewsService.save_app(appLatestNews);
				appLatestNews.setTypeId(6);
				appLatestNewsService.save_app(appLatestNews);
			}
		} catch(Exception e) {
			if(businessProduct.getDealState() == 0) { json = "{\"success\":\"false\",\"message\":\"发布失败\"}"; } 
			else { json = "{\"success\":\"true\",\"message\":\"拒绝失败\"}"; }
			GSLogger.error("显示businessProduct列表时发生错误：/business/businessProduct/list", e);
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
	 * 发布/拒绝跳蚤信息对象
	 * @param request
	 * @param businessBreak
	 * @return
	 */
	@RequestMapping(value="delProductState")
	public void delProductState(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="id") String id, @RequestParam(value="auditInfo") String auditInfo) {
		BusinessProduct businessProduct = businessProductService.findProductById(Integer.parseInt(id));
		String json = "";
		try{
			businessProduct.setDealState(4);  // 已删除
			businessProduct.setRemarks(auditInfo);
			businessProduct.setProductId(Integer.parseInt(id));
			businessProduct.setAuditorId(getUser().getUserId());
			businessProduct.setAuditorName(getUser().getUserName());
			businessProduct.setAuditTime(new Timestamp(System.currentTimeMillis()));
			businessProduct.setEditTime(new Timestamp(System.currentTimeMillis()));
			businessProductService.update(businessProduct);
			
			String state = "审核删除";
			BusinessOpertaion entity = new BusinessOpertaion(
					getUser().getUserId(), 
					getUser().getUserName(), 
					"market", 
					"market_delete", 
					businessProduct.getProductId(), 
					businessProduct.getProductName(), 
					state,
					request.getRemoteAddr());
			businessOpertaionService.save(entity);
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
			if(businessProduct.getDealState() == 4) {
				AppLatestNews appLatestNews = new AppLatestNews();
				appLatestNews.setUserId(new Integer(request.getParameter("publisherId")));
				appLatestNews.setTypeId(2);
				appLatestNews.setSourceId(new Integer(id));
				appLatestNews.setTo(0);
				appLatestNews.setEstateId(0);
				appLatestNewsService.save_app(appLatestNews);
				appLatestNews.setTypeId(5);
				appLatestNewsService.save_app(appLatestNews);
				appLatestNews.setTypeId(6);
				appLatestNewsService.save_app(appLatestNews);
			}
		} catch(Exception e) {
			json = "{\"success\":\"true\",\"message\":\"删除失败\"}"; 
			GSLogger.error("显示businessProduct列表时发生错误：/business/businessProduct/list", e);
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
     * 查询跳蚤市场评论信息
     * @param query
     * @param response
     */    
    @RequestMapping(value="getProductCommentList")
	public ModelAndView getProductCommentList(@RequestParam(value="productId") String productId) {
        BaseBean baseBean = new BaseBean();
        BusinessProduct businessProduct = new BusinessProduct();
        BusinessProductCommentQuery query = new BusinessProductCommentQuery();
		try{
            int id = Integer.parseInt(productId);
            query.setProductId(id);
            query.setRows(12);
            query.setOrder("desc");
            query.setSort("commentId");
			
            baseBean = businessProductCommentService.findAllPage(query);
            businessProduct = businessProductService.findById(id);
            
		}catch(Exception e){
			GSLogger.error("进入businessProduct管理页时发生错误：/business/businessProduct/comment", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/market/comment");
        mav.addObject("baseBean", baseBean);
        mav.addObject("businessProduct", businessProduct);
        mav.addObject("pager", baseBean.getPager());
        
		return mav;
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessProductQuery query) {		
		List<BusinessProductType> bpTypeList = null;
		try{
			bpTypeList = businessProductTypeService.findAll();
		}catch(Exception e){
			GSLogger.error("进入businessProduct新增页时发生错误：/business/businessProduct/add", e);
			e.printStackTrace();
		}
		List comList = businessCommunityService.findAll();
		ModelAndView mav = new ModelAndView("/module/market/add");
		
		mav.addObject("bpTypeList", bpTypeList);
		mav.addObject("comList", comList);
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessProduct
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessProductQuery query) {
		BusinessProduct businessProduct = new BusinessProduct();
		BusinessProductPic businessProductPic = new BusinessProductPic();
		String json = "";
		try{
		    businessProduct.setProductName(query.getProductName());
		    businessProduct.setPublisherId(query.getPublisherId());
		    businessProduct.setPublisherName(query.getPublisherName());
		    businessProduct.setContent(query.getContent().replaceAll("(\r?\n()+)", "").replace("\"", ""));
		    businessProduct.setTitle(query.getTitle());
		    businessProduct.setContactName(query.getContactName());
		    businessProduct.setContactTel(query.getContactTel());
		    businessProduct.setContactQq(query.getContactQq());
		    businessProduct.setTypeId(query.getTypeId() == null?0:query.getTypeId());
		    businessProduct.setTypeName(query.getTypeName() == null?"":query.getTypeName());
		    businessProduct.setEstateId(query.getEstateId());
		    businessProduct.setEstateScope(query.getEstateScope());
		    businessProduct.setIsEstateAgent(query.getIsEstateAgent());
		    businessProduct.setPublishTime(new Timestamp(System.currentTimeMillis()));
			businessProduct.setDealType(query.getDealType());
		    businessProduct.setDealState(0);//已发布，
		    businessProduct.setVisits(0);
		    businessProduct.setSupports(0);
		    businessProduct.setComments(0);
		    businessProduct.setCreateTime(new Timestamp(System.currentTimeMillis()));
		    businessProduct.setEditTime(new Timestamp(System.currentTimeMillis()));
		    businessProduct.setEditor(CommonUtils.getUser().getUserName());
		    		    
			if(query.getDealType() ==0){
				businessProduct.setPrice(query.getPrice());
				businessProduct.setIsEstateAgent(query.getIsEstateAgent());
			} else if(query.getDealType() ==1){
				businessProduct.setPrice(query.getPrice());
				businessProduct.setIsEstateAgent(1);
			} else if(query.getDealType() ==2){
				businessProduct.setPrice(new Long("0"));
				businessProduct.setIsEstateAgent(1);
			}
			businessProductService.save(businessProduct);
			
			String state = "发布中";
			BusinessOpertaion entity = new BusinessOpertaion(
					getUser().getUserId(), 
					getUser().getUserName(), 
					"market", 
					"market_save", 
					businessProduct.getProductId(), 
					businessProduct.getProductName(), 
					state,
					request.getRemoteAddr());
			businessOpertaionService.save(entity);
			
			if(query.getDealType() ==0 || query.getDealType() ==2){
				if(query.getAppPic() != null) {
					String[] appPic = query.getAppPic().substring(1).split("#");
					for(int i=0; i<appPic.length; i++) {
						businessProductPic.setProductId(businessProduct.getProductId());
						businessProductPic.setPicPath(appPic[i]);
						businessProductPic.setCreateTime(new Timestamp(System.currentTimeMillis()));
						businessProductPic.setEditor(CommonUtils.getUser().getUserName());
						businessProductPicService.save(businessProductPic);
					}
				}
			}
			
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessProduct信息时发生错误：/business/businessProduct/save", e);
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
	public ModelAndView modify(BusinessProductQuery query) {	
		BusinessProduct businessProduct=new BusinessProduct();
		
		try{
			businessProduct = businessProductService.findById(query.getProductId());
		}catch(Exception e){
			GSLogger.error("进入businessProduct修改页时发生错误：/business/businessProduct/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/market/modify");
		mav.addObject("businessProduct", businessProduct);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessProductQuery query) {
		BusinessProduct businessProduct = null;
		String json = "";
		try{
		    businessProduct = businessProductService.findById(query.getProductId());
		    businessProduct.setProductName(query.getProductName());
		    businessProduct.setPublisherId(query.getPublisherId());
		    businessProduct.setPublisherName(query.getPublisherName());
		    businessProduct.setContent(query.getContent().replaceAll("(\r?\n()+)", "").replace("\"", ""));
		    businessProduct.setTitle(query.getTitle());
		    businessProduct.setContactName(query.getContactName());
		    businessProduct.setContactTel(query.getContactTel());
		    businessProduct.setContactQq(query.getContactQq());
		    businessProduct.setEstateId(query.getEstateId());
		    businessProduct.setEstateScope(query.getEstateScope());
		    businessProduct.setPrice(query.getPrice());
		    businessProduct.setIsEstateAgent(query.getIsEstateAgent());
		    businessProduct.setPublishTime(new Timestamp(System.currentTimeMillis()));
		    businessProduct.setEditTime(new Timestamp(System.currentTimeMillis()));
		    businessProduct.setEditor(CommonUtils.getUser().getUserName());
		    
		    businessProduct.setDealType(query.getDealType());
			businessProductService.update(businessProduct);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessProduct信息时发生错误：/business/businessProduct/update", e);
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
						businessProductService.delete(new Integer(ids[i]));
					}
				}else{
					businessProductService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessProduct时发生错误：/business/businessProduct/delete", e);
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
    @RequestMapping(value="uploadProductImg")
    public @ResponseBody String uploadProductImg(HttpServletRequest request, @RequestParam MultipartFile[] myfile) {
        String picPath = null;
        //上传附件
        try {
            Uploader uploader = new Uploader(request);
            //paramMap = uploader.uploadForApp();
            picPath = uploader.upload("product");
        } catch(Exception e) {
        	e.printStackTrace();
        }
        //返回图片全路径
        return (String) picPath;
    }
}