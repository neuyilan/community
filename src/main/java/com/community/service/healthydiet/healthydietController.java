package com.community.service.healthydiet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.community.app.module.bean.AppLatestNews;
import com.community.app.module.bean.AppStatisticsClick;
import com.community.app.module.bean.AppUser;
import com.community.app.module.bean.AppUserNews;
import com.community.app.module.bean.BusinessChinmedichenacare;
import com.community.app.module.bean.BusinessChinmedichenacareComment;
import com.community.app.module.bean.BusinessChinmedichenacareSupport;
import com.community.app.module.bean.BusinessHealthydiet;
import com.community.app.module.bean.BusinessHealthydietComment;
import com.community.app.module.bean.BusinessHealthydietSupport;
import com.community.app.module.service.AppLatestNewsService;
import com.community.app.module.service.AppStatisticsClickService;
import com.community.app.module.service.AppUserNewsService;
import com.community.app.module.service.AppUserService;
import com.community.app.module.service.BusinessChinmedichenacareService;
import com.community.app.module.service.BusinessChinmedichenacareSupportService;
import com.community.app.module.service.BusinessHealthydietCommentService;
import com.community.app.module.service.BusinessHealthydietService;
import com.community.app.module.service.BusinessHealthydietSupportService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessChinmedichenacareCommentQuery;
import com.community.app.module.vo.BusinessChinmedichenacareQuery;
import com.community.app.module.vo.BusinessChinmedichenacareSupportQuery;
import com.community.app.module.vo.BusinessHealthydietCommentQuery;
import com.community.app.module.vo.BusinessHealthydietQuery;
import com.community.app.module.vo.BusinessHealthydietSupportQuery;
import com.community.framework.utils.DateUtil;
import com.community.framework.utils.propertiesUtil;
import com.community.framework.utils.testfilter.src.com.gao.SensitivewordFilter;


@Controller
@RequestMapping("/service/healthydiet")
public class healthydietController {
	private static Logger GSLogger = LoggerFactory.getLogger(healthydietController.class);
	@Autowired
	private BusinessHealthydietService businessHealthydietService;
	@Autowired
	private BusinessHealthydietCommentService businessHealthydietCommentService;
	@Autowired
	private BusinessHealthydietSupportService businessHealthydietSupportService;
	@Autowired
	private AppUserService appUserService;
	@Autowired
	private AppLatestNewsService appLatestNewsService;
	@Autowired
	private AppUserNewsService appUserNewsService;
	@Autowired
	private BusinessChinmedichenacareService businessChinmedichenacareService;
	@Autowired
	private AppStatisticsClickService appStatisticsClickService;
	
	/**
	 * 用户查看健康饮食接口列表
	 * @param userId,sessionid,type,page,rows
	 * @return
	 * json
	 */
	@RequestMapping(value="getList")
	public void getList (HttpServletRequest request, HttpServletResponse response,BusinessHealthydietQuery query) {
		String json = "";
		try{
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp");   
			query.setRows(15);
			query.setOrder("desc");
			query.setSort("publishTime");
			query.setPublishState(0);
			BaseBean baseBean = businessHealthydietService.findAllPage_app(query);
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
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessHealthydiet businessHealthydiet = (BusinessHealthydiet) baseBean.getList().get(i);
				json += "{\"ID\":\""+businessHealthydiet.getHealId()+"\",\"title\":\""+businessHealthydiet.getHealTitle()+"\",\"time\":\""
				+DateUtil.getInterval(businessHealthydiet.getPublishTime())+"\",\"brief\":\""+businessHealthydiet.getBrief()+"\",";
				if("".equals(businessHealthydiet.getAppPic()) || businessHealthydiet.getAppPic()==null  || businessHealthydiet.getAppPic().indexOf("/images/icon/")>=0){
					json +="\"pic\":\"\",";
				}else{
					json +="\"pic\":\""+ip+businessHealthydiet.getAppPic()+"\",";
				}
				json += "\"publisherId\":\""+businessHealthydiet.getPublisherId()+"\",\"publisherName\":\""+businessHealthydiet.getDoctorName()+"\",\"avatar\":\""+ip+businessHealthydiet.getAvatar()+"\",\"label\":\""+businessHealthydiet.getLabel()+"\"},";
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
			appStatisticsClick.setType(87);
			appStatisticsClick.setTypeName("健康饮食列表");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户查看健康饮食的评论
	 * @param userId,sessionid,ID,page,rows
	 * @return
	 * json
	 */
	@RequestMapping(value="getReviewById")
	public void getReviewById(HttpServletRequest request, HttpServletResponse response,BusinessHealthydietCommentQuery query) {
		String json = "";
		try{
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp");   
			query.setRows(15);
			query.setOrder("desc");
			query.setSort("commentTime");
			query.setHealId(query.getID());
			BaseBean baseBean = businessHealthydietCommentService.findAllPage_app(query);
			BusinessHealthydiet businessHealthydiet = businessHealthydietService.findById_app(query.getID());
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"获取成功\",";
			json += "\"content\":{";
			json += "\"supports\":\""+businessHealthydiet.getSupports()+"\",";
			json += "\"comments\":\""+businessHealthydiet.getComments()+"\",";
			json += "\"PageState\":";
			if(baseBean.getCount()>query.getPage()*query.getRows()){
				json += "true,";
			}else{
				json += "false,";
			}
			json += "\"reviewList\":[";
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessHealthydietComment  businessHealthydietComment= (BusinessHealthydietComment) baseBean.getList().get(i);
					json += "{\"userId\":\""+businessHealthydietComment.getCommentorId()+"\",";
					if(businessHealthydietComment.getCommentorState()==1){
						json +="\"avatar\":\""+ip+businessHealthydietComment.getAvatar()+"\",\"name\":\""
								+businessHealthydietComment.getBuNickname()+"\",";
					}else{
						json +="\"avatar\":\""+ip+businessHealthydietComment.getPortrait()+"\",\"name\":\""
								+businessHealthydietComment.getNickname()+"\",";
					}
					json +="\"commentTime\":\""+DateUtil.getInterval(businessHealthydietComment.getCommentTime())+"\",";
						json += "\"replyName\":\""+businessHealthydietComment.getRepliedName()+"\",";
						json += "\"replyId\":\""+businessHealthydietComment.getRepliedId()+"\",";
						json += "\"content\":\""+businessHealthydietComment.getComment()+"\",";
						if(businessHealthydietComment.getCommentorState()==1){
							json +="\"userType\":\"1\",";
						}else{
							json +="\"userType\":\"0\",";
						}
						if(businessHealthydietComment.getRepliedState()==1){
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
	 * 用户查看健康饮食回复我的评论
	 * @param userId,sessionid,ID,page,rows
	 * @return
	 * json
	 */
	@RequestMapping(value="getReviewByUserId")
	public void getReviewByUserId(HttpServletRequest request, HttpServletResponse response,BusinessHealthydietCommentQuery query) {
		String json = "";
		try{
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp");   
			query.setRows(15);
			query.setOrder("desc");
			query.setSort("commentTime");
			query.setHealId(query.getID());
			query.setCommentorState(0);
			query.setRepliedState(0);
			BaseBean baseBean = businessHealthydietCommentService.findAllPage_app(query);
			BusinessHealthydiet businessHealthydiet = businessHealthydietService.findById_app(query.getID());
			
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
			json += "\"supports\":\""+businessHealthydiet.getSupports()+"\",";
			json += "\"comments\":\""+businessHealthydiet.getComments()+"\",";
			json += "\"PageState\":";
			if(baseBean.getCount()>query.getPage()*query.getRows()){
				json += "true,";
			}else{
				json += "false,";
			}
			json += "\"count\":\""+baseBean.getCount()+"\",";
			json += "\"reviewList\":[";
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessHealthydietComment  businessHealthydietComment= (BusinessHealthydietComment) baseBean.getList().get(i);
					json += "{\"userId\":\""+businessHealthydietComment.getCommentorId()+"\",";
					if(businessHealthydietComment.getCommentorState()==1){
						json +="\"avatar\":\""+ip+businessHealthydietComment.getAvatar()+"\",\"name\":\""
								+businessHealthydietComment.getBuNickname()+"\",";
					}else{
						json +="\"avatar\":\""+ip+businessHealthydietComment.getPortrait()+"\",\"name\":\""
								+businessHealthydietComment.getNickname()+"\",";
					}
					json +="\"commentTime\":\""+DateUtil.getInterval(businessHealthydietComment.getCommentTime())+"\",";
						json += "\"replyName\":\""+businessHealthydietComment.getRepliedName()+"\",";
						json += "\"replyId\":\""+businessHealthydietComment.getRepliedId()+"\",";
						json += "\"content\":\""+businessHealthydietComment.getComment()+"\",";
						if(businessHealthydietComment.getCommentorState()==1){
							json +="\"userType\":\"1\",";
						}else{
							json +="\"userType\":\"0\",";
						}
						if(businessHealthydietComment.getRepliedState()==1){
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
	 * 用户评论健康饮食
	 * @param userId,sessionid,ID,content
	 * @return
	 * json
	 */
	@RequestMapping(value="saveReview")
	public void saveReview(HttpServletRequest request, HttpServletResponse response,BusinessHealthydietCommentQuery query) {
		String json = "";
		try{
			BusinessHealthydietComment businessHealthydietComment = new BusinessHealthydietComment();
			Timestamp  ts=new Timestamp(new Date().getTime());
			businessHealthydietComment.setCommentTime(ts);
			businessHealthydietComment.setHealId(query.getID());
			businessHealthydietComment.setCommentorId(query.getUserId());
			businessHealthydietComment.setComment(SensitivewordFilter.replaceSensitiveWord(query.getContent(),1,"*"));
			businessHealthydietComment.setRepliedId(query.getReplyId());
			businessHealthydietComment.setRepliedName(query.getReplyName());
			if(null==query.getReplyId()){
				businessHealthydietComment.setRepliedId(0);
			}
			if(null==query.getReplyName()){
				businessHealthydietComment.setRepliedName("");
			}
			businessHealthydietComment.setCommentorState(0);//居民
			businessHealthydietComment.setRepliedState(0);
			businessHealthydietCommentService.save(businessHealthydietComment);
			BusinessHealthydiet businessHealthydiet = businessHealthydietService.findById_app(query.getID());
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"评论成功\",";
			json += "\"content\":{";
			//json += "\"comments\":\""+businessNews.getComments()+"\"";
			json += "\"commentId\":\""+businessHealthydietComment.getCommentId()+"\",";
			json += "\"commentor\":\""+businessHealthydietComment.getCommentorName()+"\",";
			json += "\"content\":\""+businessHealthydietComment.getComment()+"\",";
			json += "\"commentTime\":\""+businessHealthydietComment.getCommentTime()+"\",";
			json += "\"replyId\":\""+businessHealthydietComment.getRepliedId()+"\",";
			json += "\"replyName\":\""+businessHealthydietComment.getRepliedName()+"\",";
			json += "\"comments\":\""+businessHealthydiet.getComments()+"\",";
			json += "\"commentorId\":\""+businessHealthydietComment.getCommentorState()+"\"";
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
			appStatisticsClick.setType(90);
			appStatisticsClick.setTypeName("评论健康饮食");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户回复健康饮食
	 * @param userId,sessionid,ID,content
	 * @return
	 * json
	 */          
	@RequestMapping(value="saveReply")
	public void saveReply(HttpServletRequest request, HttpServletResponse response,BusinessHealthydietCommentQuery query) {
		String json = "";
		try{
			BusinessHealthydietComment businessHealthydietComment = new BusinessHealthydietComment();
			Timestamp  ts=new Timestamp(new Date().getTime());
			businessHealthydietComment.setCommentTime(ts);
			businessHealthydietComment.setHealId(query.getID());
			businessHealthydietComment.setCommentorId(query.getUserId());
			businessHealthydietComment.setComment(SensitivewordFilter.replaceSensitiveWord(query.getContent(),1,"*"));
			businessHealthydietComment.setRepliedId(query.getReplyId());
			businessHealthydietComment.setRepliedName(query.getReplyName());
			if(null==query.getReplyId()){
				businessHealthydietComment.setRepliedId(0);
			}
			if(null==query.getReplyName()){
				businessHealthydietComment.setRepliedName("");
			}
			businessHealthydietComment.setCommentorState(0);//居民
			businessHealthydietComment.setRepliedState(0);
			businessHealthydietCommentService.save(businessHealthydietComment);
			BusinessHealthydiet businessHealthydiet = businessHealthydietService.findById_app(query.getID());
			if(!(businessHealthydietComment.getRepliedState()==1)){
				AppUserNews appUserNews = new AppUserNews();
				appUserNews.setUserId(query.getReplyId());
				appUserNews.setCreateTime(ts);
				appUserNews.setNewTitle(businessHealthydiet.getHealTitle());
				appUserNews.setType(10);
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
			json += "\"commentId\":\""+businessHealthydietComment.getCommentId()+"\",";
			json += "\"commentor\":\""+businessHealthydietComment.getCommentorName()+"\",";
			json += "\"content\":\""+businessHealthydietComment.getComment()+"\",";
			json += "\"commentTime\":\""+businessHealthydietComment.getCommentTime()+"\",";
			json += "\"replyId\":\""+businessHealthydietComment.getRepliedId()+"\",";
			json += "\"replyName\":\""+businessHealthydietComment.getRepliedName()+"\",";
			json += "\"comments\":\""+businessHealthydiet.getComments()+"\",";
			json += "\"commentorId\":\""+businessHealthydietComment.getCommentorState()+"\"";
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
			appStatisticsClick.setType(91);
			appStatisticsClick.setTypeName("回复健康饮食");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户点赞中医养生
	 * @param userId,sessionid,ID
	 * @return
	 * json
	 */
	@RequestMapping(value="support")
	public void support(HttpServletRequest request, HttpServletResponse response,BusinessHealthydietCommentQuery query) {
		String json = "";
		try{
			BusinessHealthydietSupportQuery businessHealthydietSupportQuery = new BusinessHealthydietSupportQuery();
			businessHealthydietSupportQuery.setUserId(query.getUserId());
			businessHealthydietSupportQuery.setHealId(query.getID());
			int count = businessHealthydietSupportService.selectCount(businessHealthydietSupportQuery);
			if(count==0){
				BusinessHealthydietSupport businessHealthydietSupport = new BusinessHealthydietSupport();
				businessHealthydietSupport.setUserId(query.getUserId());
				businessHealthydietSupport.setHealId(query.getID());
				Timestamp  ts=new Timestamp(new Date().getTime());
				businessHealthydietSupport.setCreateTime(ts);
				businessHealthydietSupportService.save(businessHealthydietSupport);
				BusinessHealthydiet businessHealthydiet = businessHealthydietService.findById_app(query.getID());
				json += "{";
				json += "\"errorCode\":\"200\",";
				json += "\"message\":\"点赞成功\",";
				json += "\"content\":{";
				json += "\"supports\":\""+businessHealthydiet.getSupports()+"\"";
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
			json = "";
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
			appStatisticsClick.setType(89);
			appStatisticsClick.setTypeName("健康饮食点赞");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 用户查看健康饮食的详情
	 * @param userId,sessionid,ID
	 * @return
	 * json
	 */
	@RequestMapping(value="getDetailsById")
	public ModelAndView getDetailsById(HttpServletRequest request, HttpServletResponse response) {
		Properties p = propertiesUtil.getProperties("config.properties");
		String ip = p.getProperty("imageIp");   
		Integer newsId = new Integer(request.getParameter("ID"));
		//Integer newsId = 48;
		String sessionid = request.getParameter("sessionid");
		//String sessionid = "sessionid";
		Integer userId = new Integer(request.getParameter("userId"));
		//Integer userId = 1;
		AppUser appUser = appUserService.findById(userId);
		
		ModelAndView mav = new ModelAndView("/service/healthydiet");
		
		List commentList = new ArrayList();
		String path = request.getContextPath();
		String ctx = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path; 
		String protrait = ip+appUser.getPortrait();
		BusinessHealthydiet businessHealthydiet = businessHealthydietService.findById_app(newsId);
		mav.addObject("ctx", ctx);
		mav.addObject("newsId", businessHealthydiet.getHealId());
		mav.addObject("doctorBrief", businessHealthydiet.getDoctorBrief());
		mav.addObject("publisherName", businessHealthydiet.getDoctorName());
		mav.addObject("publishTime", businessHealthydiet.getPublishTime());
		mav.addObject("publisherProtrait", ip+businessHealthydiet.getAvatar());
		mav.addObject("title",businessHealthydiet.getHealTitle());
		mav.addObject("newsContent", businessHealthydiet.getHealContent());
		mav.addObject("protrait", protrait);
		mav.addObject("supports", businessHealthydiet.getSupports());
		mav.addObject("comments", businessHealthydiet.getComments());
		mav.addObject("realName", appUser.getRealname());
		mav.addObject("newsId", newsId);
		mav.addObject("sessionid", sessionid);
		mav.addObject("userId", userId);
		mav.addObject("nickname", appUser.getNickname());
		mav.addObject("download", request.getParameter("download"));

		Map propMap = new HashMap();
		propMap.put("newsId",businessHealthydiet.getHealId());
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			AppStatisticsClick appStatisticsClick = new AppStatisticsClick();
			appStatisticsClick.setCreateTime(ts);
			appStatisticsClick.setEditTime(ts);
			appStatisticsClick.setUserId(userId);
			appStatisticsClick.setType(88);
			appStatisticsClick.setTypeName("健康饮食详情");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
		return mav;	
	}
	
	/**
	 * 用户查看健康饮食回复我的详情
	 * @param userId,sessionid,ID
	 * @return
	 * json
	 */
	@RequestMapping(value="getDetailsByUserId")
	public ModelAndView getDetailsByUserId(HttpServletRequest request, HttpServletResponse response) {
		Properties p = propertiesUtil.getProperties("config.properties");
		String ip = p.getProperty("imageIp");   
		Integer newsId = new Integer(request.getParameter("ID"));
		//Integer newsId = 48;
		String sessionid = request.getParameter("sessionid");
		//String sessionid = "sessionid";
		Integer userId = new Integer(request.getParameter("userId"));
		//Integer userId = 1;
		AppUser appUser = appUserService.findById(userId);
		
		
		ModelAndView mav = new ModelAndView("/service/userHealthydiet");
		
		List commentList = new ArrayList();
		String path = request.getContextPath();
		String ctx = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path; 
		String protrait = ip+appUser.getPortrait();
		BusinessHealthydiet businessHealthydiet = businessHealthydietService.findById_app(newsId);
		mav.addObject("ctx", ctx);
		mav.addObject("newsId", businessHealthydiet.getHealId());
		mav.addObject("doctorBrief", businessHealthydiet.getDoctorBrief());
		mav.addObject("publisherName", businessHealthydiet.getDoctorName());
		mav.addObject("publishTime", businessHealthydiet.getPublishTime());
		mav.addObject("publisherProtrait", ip+businessHealthydiet.getAvatar());
		mav.addObject("title",businessHealthydiet.getHealTitle());
		mav.addObject("newsContent", businessHealthydiet.getHealContent());
		mav.addObject("protrait", protrait);
		mav.addObject("supports", businessHealthydiet.getSupports());
		mav.addObject("comments", businessHealthydiet.getComments());
		mav.addObject("realName", appUser.getRealname());
		mav.addObject("newsId", newsId);
		mav.addObject("sessionid", sessionid);
		mav.addObject("userId", userId);
		mav.addObject("nickname", appUser.getNickname());
		
		Map propMap = new HashMap();
		propMap.put("newsId",businessHealthydiet.getHealId());
		
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			AppStatisticsClick appStatisticsClick = new AppStatisticsClick();
			appStatisticsClick.setCreateTime(ts);
			appStatisticsClick.setEditTime(ts);
			appStatisticsClick.setUserId(userId);
			appStatisticsClick.setType(88);
			appStatisticsClick.setTypeName("健康饮食详情");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
		return mav;	
	}
}
