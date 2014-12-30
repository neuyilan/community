package com.community.service.community;





/**
 * 社区相关处理接口
 * 包括：
 * 用户信息
 * 
 * @author whh-2_000
 *
 */

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

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


import com.community.app.module.vo.BusinessImagesQuery;
import com.community.app.module.vo.BusinessNewsCommentQuery;
import com.community.app.module.vo.BusinessNewsQuery;
import com.community.app.module.vo.BusinessNewsSupportQuery;
import com.community.app.module.vo.BusinessNewspaperQuery;
import com.community.app.module.vo.BusinessProductQuery;
import com.community.app.module.vo.BusinessProductSupportQuery;
import com.community.app.module.vo.ManageEstateQuery;
import com.community.app.module.bean.AppLatestNews;
import com.community.app.module.bean.AppStatisticsClick;
import com.community.app.module.bean.AppUser;
import com.community.app.module.bean.AppUserNews;
import com.community.app.module.bean.BusinessAnno;
import com.community.app.module.bean.BusinessCommunity;
import com.community.app.module.bean.BusinessFeedbackComment;
import com.community.app.module.bean.BusinessImages;
import com.community.app.module.bean.BusinessNews;
import com.community.app.module.bean.BusinessNewsComment;
import com.community.app.module.bean.BusinessNewsSupport;
import com.community.app.module.bean.BusinessNewspaper;
import com.community.app.module.bean.BusinessProduct;
import com.community.app.module.bean.BusinessProductComment;
import com.community.app.module.bean.BusinessProductSupport;
import com.community.app.module.bean.ManageEstate;
import com.community.app.module.service.AppLatestNewsService;
import com.community.app.module.service.AppStatisticsClickService;
import com.community.app.module.service.AppUserNewsService;
import com.community.app.module.service.AppUserService;
import com.community.app.module.service.BusinessAnnoService;
import com.community.app.module.service.BusinessCommunityService;
import com.community.app.module.service.BusinessImagesService;
import com.community.app.module.service.BusinessNewsCommentService;
import com.community.app.module.service.BusinessNewsService;
import com.community.app.module.service.BusinessNewsSupportService;
import com.community.app.module.service.BusinessNewspaperService;
import com.community.app.module.service.ManageEstateService;
import com.community.app.module.vo.BusinessAnnoQuery;
import com.community.framework.utils.DateUtil;
import com.community.framework.utils.propertiesUtil;
import com.community.framework.utils.testfilter.src.com.gao.SensitivewordFilter;


@Controller
@RequestMapping("/service/commiunity")
public class CommunityController {
	private static Logger GSLogger = LoggerFactory.getLogger(CommunityController.class);
	@Autowired
	private BusinessCommunityService businessCommunityService;
	@Autowired
	private ManageEstateService manageEstateService;
	@Autowired
	private BusinessNewsService businessNewsService;
	@Autowired
	private BusinessNewsCommentService businessNewsCommentService;
	@Autowired
	private BusinessNewsSupportService businessNewsSupportService;
	@Autowired
	private AppUserService appUserService;
	@Autowired
	private AppUserNewsService appUserNewsService;
	@Autowired
	private AppLatestNewsService appLatestNewsService;
	@Autowired
	private BusinessNewspaperService businessNewspaperService;
	@Autowired
	private AppStatisticsClickService appStatisticsClickService;
	@Autowired
	private BusinessImagesService businessImagesService;
	
	
	
	
	
	/**
	 * 根据用户所在地域获取该地域的所有社区，默认地域为北京
	 * @param areacode
	 * @return
	 * json
	 */
	@RequestMapping(value="findAll")
	public void findAll(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		List<BusinessCommunity> list;
		try{
			list=businessCommunityService.findAll();
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"搜索成功\",";
			json += "\"content\":{";
			json += "\"communityList\":[";
			for (BusinessCommunity businessCommunity : list) {
				json += "{\"comId\":\""+businessCommunity.getComId()+"\",\"comName\":\""+businessCommunity.getComName()+"\",";
				if (businessCommunity.getCityName()==null) {
					json += "\"cityName\":\"\"";
				}else {
					json += "\"cityName\":\""+businessCommunity.getCityName()+"\"";
				}
				if (businessCommunity.getCountyName()==null) {
					json += ",\"areaName\":\"\"},";
				}else {
					
					json += ",\"areaName\":\""+businessCommunity.getCountyName()+"\"},";
				}
				
			}
			if(list.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]";
			json += "}";
			json += "}";
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"获取失败\"";
			json += "}";
			GSLogger.error("进入businessCommunity管理页时发生错误：/business/businessCommunity/enter", e);
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
	 * 根据用户所在地域获取该地域的所有社区，默认地域为北京
	 * @param areacode
	 * @return
	 * html
	 */
	@RequestMapping(value="index")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/service/community");
		List<BusinessCommunity> list;
		try{
			String path = request.getContextPath();
			String ctx = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path; 
			list=businessCommunityService.findAll();
			mav.addObject("ctx", ctx);
			mav.addObject("list", list);
			mav.addObject("ID", request.getParameter("ID"));
			mav.addObject("type", request.getParameter("type"));
		}catch(Exception e){
			GSLogger.error("选择社区发生错误", e);
			e.printStackTrace();
		}
		return mav;
	}
	
	
	/**
	 * 根据APP传回的用户点击的社区ID返回小区列表
	 * @param comId
	 * @return
	 * json
	 */
	@RequestMapping(value="findByCom")
	public void findByCom(HttpServletRequest request, HttpServletResponse response,ManageEstateQuery query) {
		List<ManageEstate> list;
		String json = "";
		try{
			list=manageEstateService.findByExample(query);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"获取成功\",";
			json += "\"content\":{";
			json += "\"estateList\":[";
			for (ManageEstate manageEstate : list) {
				json += "{\"estateId\":\""+manageEstate.getEstateId()+"\",\"estateName\":\""+manageEstate.getEstateName()+"\",";
				json += "\"comName\":\""+manageEstate.getComName()+"\",";
				if (manageEstate.getCountyName()==null) {
					json += "\"areaName\":\"\",";
				}else {
					json += "\"areaName\":\""+manageEstate.getCountyName()+"\",";
				}
				if (manageEstate.getCityName()==null) {
					json += "\"cityName\":\"\",";
				}else{
					json += "\"cityName\":\""+manageEstate.getCityName()+"\",";
				}
				if (manageEstate.getStationId()==null) {
					json += "\"stationId\":\"0\",\"staName\":\"\"";
				} else {
					json += "\"stationId\":\""+manageEstate.getStationId()+"\",\"staName\":\""+manageEstate.getStaName()+"\"";
				}
				if (manageEstate.getComId()==null) {
					json += ",\"comId\":\"0\",\"comName\":\"\"},";
				} else {
					json += ",\"comId\":\""+manageEstate.getComId()+"\",\"comName\":\""+manageEstate.getComName()+"\"},";
				}	
				
						
			}
			if(list.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]";
			json += "}";
			json += "}";
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"获取失败\"";
			json += "}";
			GSLogger.error("进入businessCommunity管理页时发生错误：/business/businessCommunity/enter", e);
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
	 * 根据用户点击的社区ID返回小区列表页面
	 * @param comId
	 * @return
	 * json
	 */
	@RequestMapping(value="findByComIndex")
	public ModelAndView findByComIndex(HttpServletRequest request, HttpServletResponse response,ManageEstateQuery query) {
		ModelAndView mav = new ModelAndView("/service/estate");
		List<ManageEstate> list;
		try{
			
			String path = request.getContextPath();
			String ctx = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path; 
			list=manageEstateService.findByExample(query);			
			mav.addObject("ctx", ctx);
			mav.addObject("list", list);
			mav.addObject("ID", request.getParameter("ID"));
			mav.addObject("type", request.getParameter("type"));
		}catch(Exception e){
			GSLogger.error("获取社区下的小区页面出错", e);
			e.printStackTrace();
		}
		return mav;
		
	}
	
	/**
	 * 用户获取社区介绍
	 * @param userId,sessionid,comId
	 * @return
	 * json
	 */
	@RequestMapping(value="getFamilyInfo")
	public void getFamilyInfo(HttpServletRequest request, HttpServletResponse response) {
		//System.out.println("userId:"+request.getParameter("userId"));
		//System.out.println("sessionid:"+request.getParameter("sessionid"));
		//System.out.println("comId:"+request.getParameter("comId"));
		String json = "";
		json += "{";
		json += "\"errorCode\":\"200\",";
		json += "\"message\":\"获取成功\",";
		json += "\"content\":{";
		json += "\"ID\":\"12\",";
		json += "\"name\":\"张三\",";
		json += "\"avatar\":\"头像\",";
		json += "\"brief\":\"介绍\",";
		json += "\"tel\":\"12232232\",";
		json += "\"propertytel\":\"22232232\",";
		json += "}";
		json += "}";
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
	 * 用户查看新闻类回复我的详情
	 * @param userId,sessionid,ID
	 * @return
	 * json
	 */
	@RequestMapping(value="getInformationCommunityById")
	public ModelAndView getInformationCommunityById(HttpServletRequest request, HttpServletResponse response) {
		
		Properties p = propertiesUtil.getProperties("config.properties");
		String ip = p.getProperty("imageIp");   
		Integer newsId = new Integer(request.getParameter("ID"));
		//Integer newsId = 48;
		String sessionid = request.getParameter("sessionid");
		//String sessionid = "sessionid";
		Integer userId = new Integer(request.getParameter("userId"));
		//Integer userId = 1;
		AppUser appUser = appUserService.findById(userId);
		AppLatestNews appLatestNews = new AppLatestNews();
		appLatestNews.setUserId(userId);
		appLatestNews.setTypeId(8);
		appLatestNews.setTo(0);
		appLatestNews.setSourceId(newsId);
		appLatestNewsService.delete_app_id(appLatestNews);
		
		ModelAndView mav = new ModelAndView("/service/userNews");
		
		List commentList = new ArrayList();
		String path = request.getContextPath();
		String ctx = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path; 
		String protrait = ip+appUser.getPortrait();
		BusinessNews businessNews = businessNewsService.findById_app(newsId);
		mav.addObject("ctx", ctx);
		if(businessNews.getNewsType()==1){
			if (businessNews.getIsNickname()!=null && businessNews.getIsNickname()==1) {
				mav.addObject("publisherName","小区居民");
			}else{
				mav.addObject("publisherName",businessNews.getNickname());
			}
			mav.addObject("publisherProtrait",ip+businessNews.getPortrait());
		}else {
			mav.addObject("publisherName",businessNews.getBuNickname());
			mav.addObject("publisherProtrait",ip+businessNews.getAvatar());
		}
		mav.addObject("newsId", businessNews.getNewsId());
		mav.addObject("publishTime", businessNews.getPublishTime());
		mav.addObject("title", businessNews.getTitle());
		mav.addObject("newsContent", businessNews.getContent());
		mav.addObject("protrait", protrait);
		mav.addObject("supports", businessNews.getSupports());
		mav.addObject("comments", businessNews.getComments());
		mav.addObject("realName", appUser.getRealname());
		mav.addObject("newsId", newsId);
		mav.addObject("sessionid", sessionid);
		mav.addObject("userId", userId);
		mav.addObject("nickname", appUser.getNickname());
		
		Map propMap = new HashMap();
		propMap.put("newsId", businessNews.getNewsId());
		
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			AppStatisticsClick appStatisticsClick = new AppStatisticsClick();
			appStatisticsClick.setCreateTime(ts);
			appStatisticsClick.setEditTime(ts);
			appStatisticsClick.setUserId(userId);
			appStatisticsClick.setType(12);
			appStatisticsClick.setTypeName("新闻详情");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
		return mav;	
	}
	
	/**
	 * 用户查看北青社区报新闻接口
	 * @param userId,sessionid,page,rows
	 * @return
	 * json
	 */
	@RequestMapping(value="findByJournalism")
	public void findByJournalism (HttpServletRequest request, HttpServletResponse response ,BusinessNewsQuery query) {
		String json = "";
		try{
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp");   
			query.setRows(15);
			query.setOrder("desc");
			query.setSort("publishTime");
			query.setPublishScope(query.getComId());
			query.setState(0);
			query.setIsHot(1);
			BaseBean topBaseBean = businessNewsService.findAllPage_app(query);
			query.setIsHot(0);
			BaseBean baseBean = businessNewsService.findAllPage_app(query);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"获取成功\",";
			json += "\"content\":{";
			
			json += "\"PageState\":";
			if(baseBean.getCount()>query.getPage()*query.getRows()){
				json += "true,";
			}else{
				json += "false,";
			}
			json += "\"list\":[";
			for (int i = 0; i < topBaseBean.getList().size(); i++) {
				BusinessNews businessNews = (BusinessNews) topBaseBean.getList().get(i);
				json += "{\"ID\":\""+businessNews.getNewsId()+"\",\"title\":\""+businessNews.getTitle()+"\",\"time\":\""
				+DateUtil.getInterval(businessNews.getPublishTime())+"\",\"brief\":\""+businessNews.getBrief()+"\",";
				if("".equals(businessNews.getSubjectPic()) || businessNews.getSubjectPic()==null || businessNews.getSubjectPic().indexOf("/images/icon/")>=0){
					json +="\"pic\":\"\",";
				}else{
					json +="\"pic\":\""+ip+businessNews.getSubjectPic()+"\",";
				}
				
				if(businessNews.getNewsType()==1){
					json +="\"publisherId\":\""+businessNews.getPublisherId()+"\",\"publisherName\":\""+businessNews.getNickname()+"\",\"avatar\":\""+ip+businessNews.getPortrait()+"\",\"type\":\"1\"},";
				}else {
					json +="\"publisherId\":\""+businessNews.getPublisherId()+"\",\"publisherName\":\""+businessNews.getBuNickname()+"\",\"avatar\":\""+ip+businessNews.getAvatar()+"\",\"type\":\"0\"},";
				}
			}
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessNews businessNews = (BusinessNews) baseBean.getList().get(i);
				json += "{\"ID\":\""+businessNews.getNewsId()+"\",\"title\":\""+businessNews.getTitle()+"\",\"time\":\""
				+DateUtil.getInterval(businessNews.getPublishTime())+"\",\"brief\":\""+businessNews.getBrief()+"\",";
				if("".equals(businessNews.getSubjectPic()) || businessNews.getSubjectPic()==null || businessNews.getSubjectPic().indexOf("/images/icon/")>=0){
					json +="\"pic\":\"\",";
				}else{
					json +="\"pic\":\""+ip+businessNews.getSubjectPic()+"\",";
				}
				
				if(businessNews.getNewsType()==1){
					json +="\"publisherId\":\""+businessNews.getPublisherId()+"\",\"publisherName\":\""+businessNews.getNickname()+"\",\"avatar\":\""+ip+businessNews.getPortrait()+"\",\"type\":\"1\"},";
				}else {
					json +="\"publisherId\":\""+businessNews.getPublisherId()+"\",\"publisherName\":\""+businessNews.getBuNickname()+"\",\"avatar\":\""+ip+businessNews.getAvatar()+"\",\"type\":\"0\"},";
				}
				
			}
			if(baseBean.getList().size() > 0 || topBaseBean.getList().size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]";
			json += "}";
			json += "}";
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"获取失败\"";
			json += "}";
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
		
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			AppStatisticsClick appStatisticsClick = new AppStatisticsClick();
			appStatisticsClick.setCreateTime(ts);
			appStatisticsClick.setEditTime(ts);
			if(null==query.getUserId()){
				appStatisticsClick.setUserId(0);
			}else{
				appStatisticsClick.setUserId(query.getUserId());
			}
			appStatisticsClick.setType(12);
			appStatisticsClick.setTypeName("新闻详情");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			AppStatisticsClick appStatisticsClick = new AppStatisticsClick();
			appStatisticsClick.setCreateTime(ts);
			appStatisticsClick.setEditTime(ts);
			if(null==query.getUserId()){
				appStatisticsClick.setUserId(0);
			}else{
				appStatisticsClick.setUserId(query.getUserId());
			}
			appStatisticsClick.setType(22);
			appStatisticsClick.setTypeName("北青社区报列表");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户查看北京社区报中新闻的详情
	 * @param userId,sessionid,ID
	 * @return
	 * json
	 */
	@RequestMapping(value="getJournalismDetailsById")
	public ModelAndView getJournalismDetailsById (HttpServletRequest request, HttpServletResponse response) {
		Properties p = propertiesUtil.getProperties("config.properties");
		String ip = p.getProperty("imageIp");   
		Integer newsId = new Integer(request.getParameter("ID"));
		//Integer newsId = 48;
		String sessionid = request.getParameter("sessionid");
		//String sessionid = "sessionid";
		Integer userId = new Integer(request.getParameter("userId"));
		//Integer userId = 1;
		AppUser appUser = appUserService.findById(userId);
		AppLatestNews appLatestNews = new AppLatestNews();
		appLatestNews.setUserId(userId);
		appLatestNews.setTypeId(35);
		appLatestNews.setTo(0);
		appLatestNews.setSourceId(newsId);
		appLatestNewsService.delete_app_id(appLatestNews);
		
		ModelAndView mav = new ModelAndView("/service/news");
		
		List commentList = new ArrayList();
		String path = request.getContextPath();
		String ctx = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path; 
		String protrait = ip+appUser.getPortrait();
		BusinessNews businessNews = businessNewsService.findById_app(newsId);
		mav.addObject("ctx", ctx);
		if(businessNews.getNewsType()==1){
			if (businessNews.getIsNickname()!=null && businessNews.getIsNickname()==1) {
				mav.addObject("publisherName","小区居民");
			}else{
				mav.addObject("publisherName",businessNews.getNickname());
			}
			mav.addObject("publisherProtrait",ip+businessNews.getPortrait());
		}else if (businessNews.getNewsType()==2){
			mav.addObject("publisherName",businessNews.getNickname());
			mav.addObject("publisherProtrait",ip+businessNews.getPortrait());
		}else {
			mav.addObject("publisherName",businessNews.getBuNickname());
			mav.addObject("publisherProtrait",ip+businessNews.getAvatar());
		}
		mav.addObject("newsId", businessNews.getNewsId());
		mav.addObject("appPic", businessNews.getAppPic());
		mav.addObject("publishTime", businessNews.getPublishTime());
		mav.addObject("title", businessNews.getTitle());
		mav.addObject("newsContent", businessNews.getContent().replace("?tp=webp",""));
		mav.addObject("protrait", protrait);
		mav.addObject("supports", businessNews.getSupports());
		mav.addObject("comments", businessNews.getComments());
		mav.addObject("realName", appUser.getRealname());
		mav.addObject("nickname", appUser.getNickname());
		mav.addObject("newsId", newsId);
		mav.addObject("sessionid", sessionid);
		mav.addObject("userId", userId);
		mav.addObject("download", request.getParameter("download"));
		Map propMap = new HashMap();
		propMap.put("newsId", businessNews.getNewsId());
		
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			AppStatisticsClick appStatisticsClick = new AppStatisticsClick();
			appStatisticsClick.setCreateTime(ts);
			appStatisticsClick.setEditTime(ts);
			appStatisticsClick.setUserId(userId);
			appStatisticsClick.setType(12);
			appStatisticsClick.setTypeName("新闻详情");
			appStatisticsClick.setId(newsId);
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
		return mav;	
	}
	
	/**
	 * 用户查看北京社区报中新闻的评论
	 * @param userId,sessionid,ID,page,rows
	 * @return
	 * json
	 */
	@RequestMapping(value="getJournalismReviewById")
	public void getJournalismReviewById(HttpServletRequest request, HttpServletResponse response,BusinessNewsCommentQuery query) {
		String json = "";
		try{
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp");   
			query.setRows(15);
			query.setOrder("desc");
			query.setSort("commentTime");
			query.setNewsId(query.getID());
			BaseBean baseBean = businessNewsCommentService.findAllPage(query);
			BusinessNews businessNews = businessNewsService.findById(query.getID());
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"获取成功\",";
			json += "\"content\":{";
			json += "\"rowCount\":"+baseBean.getCount()+",";
			json += "\"supports\":\""+businessNews.getSupports()+"\",";
			json += "\"comments\":\""+businessNews.getComments()+"\",";
			json += "\"PageState\":";
			if(baseBean.getCount()>query.getPage()*query.getRows()){
				json += "true,";
			}else{
				json += "false,";
			}
			json += "\"reviewList\":[";
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessNewsComment  businessNewsComment= (BusinessNewsComment) baseBean.getList().get(i);
					json += "{\"userId\":\""+businessNewsComment.getCommentorId()+"\",";
					if(businessNewsComment.getCommentorState()==1){
						json +="\"avatar\":\""+ip+businessNewsComment.getAvatar()+"\",\"name\":\""
								+businessNewsComment.getBuNickname()+"\",";
					}else{
						json +="\"avatar\":\""+ip+businessNewsComment.getPortrait()+"\",\"name\":\""
								+businessNewsComment.getNickname()+"\",";
					}
					json +="\"commentTime\":\""+DateUtil.getInterval(businessNewsComment.getCommentTime())+"\",";
						json += "\"replyName\":\""+businessNewsComment.getReplyName()+"\",";
						json += "\"replyId\":\""+businessNewsComment.getReplyId()+"\",";
						json += "\"content\":\""+businessNewsComment.getContent()+"\",";
						if(businessNewsComment.getCommentorState()==1){
							json +="\"userType\":\"1\",";
						}else{
							json +="\"userType\":\"0\",";
						}
						if(businessNewsComment.getReplyState()==1){
							json +="\"replyType\":\"1\"";
						}else{
							json +="\"replyType\":\"0\"";
						}
						json += "},";
			}
			if(baseBean.getList().size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]";
			json += "}";
			json += "}";
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"获取失败\"";
			json += "}";
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
	 * 用户查看北京社区报中新闻回复的评论
	 * @param userId,sessionid,ID,page,rows
	 * @return
	 * json
	 */
	@RequestMapping(value="getJournalismReviewByUserId")
	public void getJournalismReviewByUserId(HttpServletRequest request, HttpServletResponse response,BusinessNewsCommentQuery query) {
		String json = "";
		try{
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp");   
			query.setRows(15);
			query.setOrder("desc");
			query.setSort("commentTime");
			query.setNewsId(query.getID());
			query.setCommentorState(0);
			query.setReplyState(0);
			BaseBean baseBean = businessNewsCommentService.findAllPage(query);
			BusinessNews businessNews = businessNewsService.findById(query.getID());
			AppLatestNews appLatestNews = new AppLatestNews();
			appLatestNews.setUserId(query.getUserId());
			appLatestNews.setTypeId(8);
			appLatestNews.setTo(0);
			appLatestNews.setSourceId(query.getID());
			appLatestNewsService.delete_app_id(appLatestNews);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"获取成功\",";
			json += "\"content\":{";
			json += "\"rowCount\":"+baseBean.getCount()+",";
			json += "\"supports\":\""+businessNews.getSupports()+"\",";
			json += "\"comments\":\""+businessNews.getComments()+"\",";
			json += "\"PageState\":";
			if(baseBean.getCount()>query.getPage()*query.getRows()){
				json += "true,";
			}else{
				json += "false,";
			}
			json += "\"count\":\""+baseBean.getCount()+"\",";
			json += "\"reviewList\":[";
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessNewsComment  businessNewsComment= (BusinessNewsComment) baseBean.getList().get(i);
					json += "{\"userId\":\""+businessNewsComment.getCommentorId()+"\",";
					if(businessNewsComment.getCommentorState()==1){
						json +="\"avatar\":\""+ip+businessNewsComment.getAvatar()+"\",\"name\":\""
								+businessNewsComment.getBuNickname()+"\",";
					}else{
						json +="\"avatar\":\""+ip+businessNewsComment.getPortrait()+"\",\"name\":\""
								+businessNewsComment.getNickname()+"\",";
					}
					json +="\"commentTime\":\""+DateUtil.getInterval(businessNewsComment.getCommentTime())+"\",";
						json += "\"replyName\":\""+businessNewsComment.getReplyName()+"\",";
						json += "\"replyId\":\""+businessNewsComment.getReplyId()+"\",";
						json += "\"content\":\""+businessNewsComment.getContent()+"\",";
						if(businessNewsComment.getCommentorState()==1){
							json +="\"userType\":\"1\",";
						}else{
							json +="\"userType\":\"0\",";
						}
						if(businessNewsComment.getReplyState()==1){
							json +="\"replyType\":\"1\"";
						}else{
							json +="\"replyType\":\"0\"";
						}
						json += "},";
			}
			if(baseBean.getList().size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]";
			json += "}";
			json += "}";
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"获取失败\"";
			json += "}";
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
	 * 用户评论北青社区报新闻
	 * @param userId,sessionid,ID,content
	 * @return
	 * json
	 */
	@RequestMapping(value="saveJournalismReview")
	public void saveJournalismReview(HttpServletRequest request, HttpServletResponse response,BusinessNewsCommentQuery query) {
		String json = "";
		try{
			BusinessNewsComment businessNewsComment = new BusinessNewsComment();
			Timestamp  ts=new Timestamp(new Date().getTime());
			businessNewsComment.setCommentTime(ts);
			businessNewsComment.setNewsId(query.getID());
			businessNewsComment.setCommentorId(query.getUserId());
			businessNewsComment.setContent(SensitivewordFilter.replaceSensitiveWord(query.getContent(),1,"*"));
			businessNewsComment.setReplyId(query.getReplyId());
			businessNewsComment.setReplyName(query.getReplyName());
			businessNewsComment.setCommentorState(0);//居民
			businessNewsComment.setReplyState(0);
			if(null==query.getReplyId()){
				businessNewsComment.setReplyId(0);
			}
			if(null==query.getReplyName()){
				businessNewsComment.setReplyName("");
			}
			businessNewsCommentService.save(businessNewsComment);
			BusinessNews businessNews = businessNewsService.findById(query.getID());
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"评论成功\",";
			json += "\"content\":{";
			//json += "\"comments\":\""+businessNews.getComments()+"\"";
			json += "\"commentId\":\""+businessNewsComment.getCommentId()+"\",";
			json += "\"commentor\":\""+businessNewsComment.getCommentorName()+"\",";
			json += "\"content\":\""+businessNewsComment.getContent()+"\",";
			json += "\"commentTime\":\""+businessNewsComment.getCommentTime()+"\",";
			json += "\"replyId\":\""+businessNewsComment.getReplyId()+"\",";
			json += "\"replyName\":\""+businessNewsComment.getReplyName()+"\",";
			json += "\"comments\":\""+businessNews.getComments()+"\",";
			json += "\"commentorId\":\""+businessNewsComment.getCommentorState()+"\"";
			json += "}";
			json += "}";
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"评论失败\"";
			json += "}";
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
		
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			AppStatisticsClick appStatisticsClick = new AppStatisticsClick();
			appStatisticsClick.setCreateTime(ts);
			appStatisticsClick.setEditTime(ts);
			if(null==query.getUserId()){
				appStatisticsClick.setUserId(0);
			}else{
				appStatisticsClick.setUserId(query.getUserId());
			}
			appStatisticsClick.setType(14);
			appStatisticsClick.setTypeName("评论新闻");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户回复北青社区报新闻
	 * @param userId,sessionid,ID,replyId,replyName,content
	 * @return
	 * json
	 */
	@RequestMapping(value="saveJournalismReply")
	public void saveJournalismReply(HttpServletRequest request, HttpServletResponse response,BusinessNewsCommentQuery query) {
		String json = "";
		try{
			BusinessNewsComment businessNewsComment = new BusinessNewsComment();
			Timestamp  ts=new Timestamp(new Date().getTime());
			businessNewsComment.setCommentTime(ts);
			businessNewsComment.setNewsId(query.getID());
			businessNewsComment.setCommentorId(query.getUserId());
			businessNewsComment.setContent(SensitivewordFilter.replaceSensitiveWord(query.getContent(),1,"*"));
			businessNewsComment.setReplyId(query.getReplyId());
			businessNewsComment.setReplyName(query.getReplyName());
			businessNewsComment.setCommentorState(0);//居民
			businessNewsComment.setReplyState(query.getReplyType());
			if(null==query.getReplyId()){
				businessNewsComment.setReplyId(0);
			}
			if(null==query.getReplyName()){
				businessNewsComment.setReplyName("");
			}
			businessNewsCommentService.save(businessNewsComment);
			BusinessNews BusinessNews = businessNewsService.findById(query.getID());
			if (!(businessNewsComment.getReplyState()==1)) {
				AppUserNews appUserNews = new AppUserNews();
				appUserNews.setUserId(query.getReplyId());
				appUserNews.setCreateTime(ts);
				appUserNews.setNewTitle(BusinessNews.getTitle());
				appUserNews.setType(0);
				appUserNews.setId(query.getID());
				appUserNews.setContent("");
				appUserNews.setLastMessage(SensitivewordFilter.replaceSensitiveWord(query.getContent(),1,"*"));
				appUserNews.setLastMessageName(query.getUserId()+"");
				appUserNewsService.saveReply(appUserNews);
				AppLatestNews appLatestNews = new AppLatestNews();
				appLatestNews.setUserId(query.getReplyId());
				appLatestNews.setTypeId(7);
				appLatestNews.setSourceId(query.getID());
				appLatestNews.setTo(0);
				appLatestNews.setEstateId(0);
				appLatestNewsService.save_app(appLatestNews);
				appLatestNews.setTypeId(8);
				appLatestNewsService.save_app(appLatestNews);
				appLatestNews.setTypeId(9);
				appLatestNewsService.save_app(appLatestNews);
			}
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"评论成功\",";
			json += "\"content\":{";
			//json += "\"comments\":\""+businessNews.getComments()+"\"";
			json += "\"commentId\":\""+businessNewsComment.getCommentId()+"\",";
			json += "\"commentor\":\""+businessNewsComment.getCommentorName()+"\",";
			json += "\"content\":\""+businessNewsComment.getContent()+"\",";
			json += "\"commentTime\":\""+businessNewsComment.getCommentTime()+"\",";
			json += "\"replyId\":\""+businessNewsComment.getReplyId()+"\",";
			json += "\"replyName\":\""+businessNewsComment.getReplyName()+"\",";
			json += "\"comments\":\""+BusinessNews.getComments()+"\",";
			json += "\"commentorId\":\""+businessNewsComment.getCommentorState()+"\"";
			json += "}";
			json += "}";
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"评论失败\"";
			json += "}";
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
		
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			AppStatisticsClick appStatisticsClick = new AppStatisticsClick();
			appStatisticsClick.setCreateTime(ts);
			appStatisticsClick.setEditTime(ts);
			if(null==query.getUserId()){
				appStatisticsClick.setUserId(0);
			}else{
				appStatisticsClick.setUserId(query.getUserId());
			}
			appStatisticsClick.setType(15);
			appStatisticsClick.setTypeName("回复新闻");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户点赞北青社区报新闻
	 * @param userId,sessionid,ID
	 * @return
	 * json
	 */
	@RequestMapping(value="supportJournalism")
	public void supportJournalism(HttpServletRequest request, HttpServletResponse response,BusinessNewsCommentQuery query) {
		String json = "";
		try{
			BusinessNewsSupportQuery businessNewsSupportQuery = new BusinessNewsSupportQuery();
			businessNewsSupportQuery.setUserId(query.getUserId());
			businessNewsSupportQuery.setNewsId(query.getID());
			int count =businessNewsSupportService.selectCount(businessNewsSupportQuery);
			if(count==0){
				BusinessNewsSupport businessNewsSupport = new BusinessNewsSupport();
				businessNewsSupport.setUserId(query.getUserId());
				businessNewsSupport.setNewsId(query.getID());
				Timestamp  ts=new Timestamp(new Date().getTime());
				businessNewsSupport.setCreateTime(ts);
				businessNewsSupportService.save(businessNewsSupport);
				BusinessNews businessNews = businessNewsService.findById(query.getID());
				json += "{";
				json += "\"errorCode\":\"200\",";
				json += "\"message\":\"点赞成功\",";
				json += "\"content\":{";
				json += "\"supports\":\""+businessNews.getSupports()+"\"";
				json += "}";
				json += "}";
			}else{
				json = "";
				json += "{";
				json += "\"errorCode\":\"400\",";
				json += "\"message\":\"已赞过了，再赞他会骄傲的…\"";
				json += "}";
			}
		}catch(Exception e){
			json ="";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"已赞过了，再赞他会骄傲的…\"";
			json += "}";
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
		
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			AppStatisticsClick appStatisticsClick = new AppStatisticsClick();
			appStatisticsClick.setCreateTime(ts);
			appStatisticsClick.setEditTime(ts);
			if(null==query.getUserId()){
				appStatisticsClick.setUserId(0);
			}else{
				appStatisticsClick.setUserId(query.getUserId());
			}
			appStatisticsClick.setType(13);
			appStatisticsClick.setTypeName("点赞新闻");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户获取社区介绍
	 * @param userId,sessionid,comId
	 * @return
	 * json
	 */
	@RequestMapping(value="getCommunityRepairIntroduction")
	public void getCommunityRepairIntroduction(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		Properties p = propertiesUtil.getProperties("config.properties");
		String ip = p.getProperty("imageIp");   
		String comId = request.getParameter("comId");
		try {
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"获取成功\",";
			json += "\"content\":{";
			if(comId.equals("8")){
				json += "\"ID\":\"12\",";
				json += "\"name\":\"圆圆\",";
				json += "\"avatar\":\""+ip+"/images/yuanyuan.jpg"+"\",";
				json += "\"brief\":\"我是朝青社区报的社长媛媛，谢谢您给我们提供新闻线索！您可以把情况告诉我们，我们会很快跟您联络。您也可以拨打我的电话：\",";
				json += "\"tel\":\"13910830458\",";
				json += "\"serviceTel\":\"53351217\"";
			}else if(comId.equals("11")){
				json += "\"ID\":\"12\",";
				json += "\"name\":\"北苑社长\",";
				json += "\"avatar\":\""+ip+"/images/yuanyuan.jpg"+"\",";
				json += "\"brief\":\"我是北苑社区报的社长媛媛，谢谢您给我们提供新闻线索！您可以把情况告诉我们，我们会很快跟您联络。您也可以拨打我的电话：\",";
				json += "\"tel\":\"13910830458\",";
				json += "\"serviceTel\":\"53351217\"";
			}else if (comId.equals("12")) {
				json += "\"ID\":\"12\",";
				json += "\"name\":\"天通苑社长\",";
				json += "\"avatar\":\""+ip+"/images/yuanyuan.jpg"+"\",";
				json += "\"brief\":\"我是天通苑社区报的社长媛媛，谢谢您给我们提供新闻线索！您可以把情况告诉我们，我们会很快跟您联络。您也可以拨打我的电话：\",";
				json += "\"tel\":\"13910830458\",";
				json += "\"serviceTel\":\"53351217\"";
			}
			json += "}";
			json += "}";
		} catch (Exception e) {
			// TODO: handle exception
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
	 * 用户查看电子报列表
	 * @param areacode
	 * @return
	 * json
	 */
	@RequestMapping(value="findBynewspaperList")
	public void findBynewspaperList(HttpServletRequest request, HttpServletResponse response,BusinessNewspaperQuery query) {
		String json = "";
		Properties p = propertiesUtil.getProperties("config.properties");
		String ip = p.getProperty("imageIp");   
		try{
			query.setRows(15);
			query.setOrder("desc");
			query.setSort("editTime");
			BaseBean baseBean = businessNewspaperService.findAllPage_app(query);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"搜索成功\",";
			json += "\"content\":{";
			json += "\"PageState\":";
			if(baseBean.getCount()>query.getPage()*query.getRows()){
				json += "true,";
			}else{
				json += "false,";
			}
			json += "\"list\":[";
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessNewspaper businessNewspaper = (BusinessNewspaper) baseBean.getList().get(i);
				json += "{\"ID\":\""+businessNewspaper.getNewspaperId()+"\",\"title\":\""+businessNewspaper.getTitle()+"\",";
				json += "\"pic\":\""+ip+businessNewspaper.getPic()+"\",\"url\":\""+businessNewspaper.getUrl()+"\"},";
			}
			if(baseBean.getList().size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]";
			json += "}";
			json += "}";
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"获取失败\"";
			json += "}";
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
	 * 用户查看电子报列表
	 * @param areacode
	 * @return
	 * json
	 */
	@RequestMapping(value="findBynewspaperList2")
	public void findBynewspaperList2(HttpServletRequest request, HttpServletResponse response,BusinessNewspaperQuery query) {
		String json = "";
		List<BusinessNewspaper> list;
		Properties p = propertiesUtil.getProperties("config.properties");
		String ip = p.getProperty("imageIp");   
		try{
			list=businessNewspaperService.findByExample(query);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"搜索成功\",";
			json += "\"content\":{";
			json += "\"list\":[";
			for (BusinessNewspaper businessNewspaper : list) {
				json += "{\"ID\":\""+businessNewspaper.getNewspaperId()+"\",\"title\":\""+businessNewspaper.getTitle()+"\",";
				json += "\"pic\":\""+ip+businessNewspaper.getPic()+"\",\"url\":\""+businessNewspaper.getUrl()+"\"},";
			}
			if(list.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]";
			json += "}";
			json += "}";
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"获取失败\"";
			json += "}";
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
	 * 社区报记者使用发布新闻
	 * @param
	 * @return
	 * json
	 */
	@RequestMapping(value="releaseNews")
	public void releaseNews(HttpServletRequest request, HttpServletResponse response,BusinessNewsQuery query) {
		String json = "";
		Map map = (Map) request.getAttribute("resultMap");
		Map<String,String> param=(Map) map.get("param");
		Map<String,String> image=(Map) map.get("image");
		try{
			query.setParam(param);
			query.setImage(image);
			businessNewsService.releaseNews(query);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"发布成功\"";
			json += "}";
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"发布失败\"";
			json += "}";
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
		
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			AppStatisticsClick appStatisticsClick = new AppStatisticsClick();
			appStatisticsClick.setCreateTime(ts);
			appStatisticsClick.setEditTime(ts);
			appStatisticsClick.setUserId(new Integer(param.get("userId")));
			appStatisticsClick.setType(102);
			appStatisticsClick.setTypeName("记者爆料");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户查看电子报列表
	 * @param areacode
	 * @return
	 * json
	 */
	@RequestMapping(value="getAppPicAll")
	public void getAppPicAll(HttpServletRequest request, HttpServletResponse response,BusinessImagesQuery query) {
		String json = "";
		List<BusinessImages> list;
		Properties p = propertiesUtil.getProperties("config.properties");
		String ip = p.getProperty("imageIp");   
		try{
			query.setImgType(0);
			list=businessImagesService.findByExample(query);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"获取成功\",";
			json += "\"content\":{";
			json += "\"list\":[";
			for (BusinessImages businessImages : list) {
				json += "{\"url\":\""+ip+businessImages.getImgPath()+"\",\"appPic\":\""+businessImages.getImgPath()+"\"},";
			}
			if(list.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]";
			json += "}";
			json += "}";
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"获取失败\"";
			json += "}";
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
