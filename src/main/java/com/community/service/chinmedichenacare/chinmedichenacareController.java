package com.community.service.chinmedichenacare;

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
import com.community.app.module.bean.BusinessAnno;
import com.community.app.module.bean.BusinessAnnoComment;
import com.community.app.module.bean.BusinessAnnoSupport;
import com.community.app.module.bean.BusinessChinmedichenacare;
import com.community.app.module.bean.BusinessChinmedichenacareComment;
import com.community.app.module.bean.BusinessChinmedichenacareSupport;
import com.community.app.module.service.AppLatestNewsService;
import com.community.app.module.service.AppStatisticsClickService;
import com.community.app.module.service.AppUserNewsService;
import com.community.app.module.service.AppUserService;
import com.community.app.module.service.BusinessAnnoService;
import com.community.app.module.service.BusinessChinmedichenacareCommentService;
import com.community.app.module.service.BusinessChinmedichenacareService;
import com.community.app.module.service.BusinessChinmedichenacareSupportService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessAnnoCommentQuery;
import com.community.app.module.vo.BusinessAnnoQuery;
import com.community.app.module.vo.BusinessAnnoSupportQuery;
import com.community.app.module.vo.BusinessChinmedichenacareCommentQuery;
import com.community.app.module.vo.BusinessChinmedichenacareQuery;
import com.community.app.module.vo.BusinessChinmedichenacareSupportQuery;
import com.community.framework.utils.DateUtil;
import com.community.framework.utils.propertiesUtil;
import com.community.framework.utils.testfilter.src.com.gao.SensitivewordFilter;


@Controller
@RequestMapping("/service/chinmedichenacare")
public class chinmedichenacareController {
	private static Logger GSLogger = LoggerFactory.getLogger(chinmedichenacareController.class);
	@Autowired
	private BusinessChinmedichenacareService businessChinmedichenacareService;
	@Autowired
	private BusinessChinmedichenacareCommentService businessChinmedichenacareCommentService;
	@Autowired
	private BusinessChinmedichenacareSupportService businessChinmedichenacareSupportService;
	@Autowired
	private AppUserService appUserService;
	@Autowired
	private AppUserNewsService appUserNewsService;
	@Autowired
	private AppLatestNewsService appLatestNewsService;
	@Autowired
	private AppStatisticsClickService appStatisticsClickService;
	
	
	/**
	 * 用户查看中医养生接口列表
	 * @param userId,sessionid,type,page,rows
	 * @return
	 * json
	 */
	@RequestMapping(value="getList")
	public void getList (HttpServletRequest request, HttpServletResponse response,BusinessChinmedichenacareQuery query) {
		String json = "";
		try{
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp");   
			query.setRows(15);
			query.setOrder("desc");
			query.setSort("publishTime");
			query.setPublishState(0);
			BaseBean baseBean = businessChinmedichenacareService.findAllPage_app(query);
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
				BusinessChinmedichenacare businessChinmedichenacare = (BusinessChinmedichenacare) baseBean.getList().get(i);
				json += "{\"ID\":\""+businessChinmedichenacare.getCmhcId()+"\",\"title\":\""+businessChinmedichenacare.getCmhcTitle()+"\",\"time\":\""
				+DateUtil.getInterval(businessChinmedichenacare.getPublishTime())+"\",\"brief\":\""+businessChinmedichenacare.getBrief()+"\",";
				if("".equals(businessChinmedichenacare.getAppPic()) || businessChinmedichenacare.getAppPic()==null  || businessChinmedichenacare.getAppPic().indexOf("/images/icon/")>=0){
					json +="\"pic\":\"\",";
				}else{
					json +="\"pic\":\""+ip+businessChinmedichenacare.getAppPic()+"\",";
				}
				json += "\"publisherId\":\""+businessChinmedichenacare.getPublisherId()+"\",\"publisherName\":\""+businessChinmedichenacare.getDoctorName()+"\",\"avatar\":\""+ip+businessChinmedichenacare.getAvatar()+"\",\"label\":\""+businessChinmedichenacare.getLabel()+"\"},";
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
			response.getWriter().write(json.replace("\n", "\\n\\r").replace("\n\r", "\\n\\r"));
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
			appStatisticsClick.setType(82);
			appStatisticsClick.setTypeName("中医养生列表");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户查看中医养生的评论
	 * @param userId,sessionid,ID,page,rows
	 * @return
	 * json
	 */
	@RequestMapping(value="getReviewById")
	public void getReviewById(HttpServletRequest request, HttpServletResponse response,BusinessChinmedichenacareCommentQuery query) {
		String json = "";
		try{
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp");   
			query.setRows(15);
			query.setOrder("desc");
			query.setSort("commentTime");
			query.setCmhcId(query.getID());
			BaseBean baseBean = businessChinmedichenacareCommentService.findAllPage_app(query);
			BusinessChinmedichenacare businessChinmedichenacare = businessChinmedichenacareService.findById_app(query.getID());
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"获取成功\",";
			json += "\"content\":{";
			json += "\"supports\":\""+businessChinmedichenacare.getSupports()+"\",";
			json += "\"comments\":\""+businessChinmedichenacare.getComments()+"\",";
			json += "\"PageState\":";
			if(baseBean.getCount()>query.getPage()*query.getRows()){
				json += "true,";
			}else{
				json += "false,";
			}
			json += "\"reviewList\":[";
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessChinmedichenacareComment  businessChinmedichenacareComment= (BusinessChinmedichenacareComment) baseBean.getList().get(i);
					json += "{\"userId\":\""+businessChinmedichenacareComment.getCommentorId()+"\",";
					if(businessChinmedichenacareComment.getCommentorState()==1){
						json +="\"avatar\":\""+ip+businessChinmedichenacareComment.getAvatar()+"\",\"name\":\""
								+businessChinmedichenacareComment.getBuNickname()+"\",";
					}else{
						json +="\"avatar\":\""+ip+businessChinmedichenacareComment.getPortrait()+"\",\"name\":\""
								+businessChinmedichenacareComment.getNickname()+"\",";
					}
					json +="\"commentTime\":\""+DateUtil.getInterval(businessChinmedichenacareComment.getCommentTime())+"\",";
						json += "\"replyName\":\""+businessChinmedichenacareComment.getRepliedName()+"\",";
						json += "\"replyId\":\""+businessChinmedichenacareComment.getRepliedId()+"\",";
						json += "\"content\":\""+businessChinmedichenacareComment.getComment()+"\",";
						if(businessChinmedichenacareComment.getCommentorState()==1){
							json +="\"userType\":\"1\",";
						}else{
							json +="\"userType\":\"0\",";
						}
						if(businessChinmedichenacareComment.getRepliedState()==1){
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
			response.getWriter().write(json.replace("\n", "\\n\\r").replace("\n\r", "\\n\\r"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户查看中医养生回复我的的评论
	 * @param userId,sessionid,ID,page,rows
	 * @return
	 * json
	 */
	@RequestMapping(value="getReviewByUserId")
	public void getReviewByUserId(HttpServletRequest request, HttpServletResponse response,BusinessChinmedichenacareCommentQuery query) {
		String json = "";
		try{
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp");   
			query.setRows(15);
			query.setOrder("desc");
			query.setSort("commentTime");
			query.setCmhcId(query.getID());
			query.setCommentorState(0);
			query.setRepliedState(0);
			BaseBean baseBean = businessChinmedichenacareCommentService.findAllPage_app(query);
			BusinessChinmedichenacare businessChinmedichenacare = businessChinmedichenacareService.findById_app(query.getID());
			
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
			json += "\"supports\":\""+businessChinmedichenacare.getSupports()+"\",";
			json += "\"comments\":\""+businessChinmedichenacare.getComments()+"\",";
			json += "\"PageState\":";
			if(baseBean.getCount()>query.getPage()*query.getRows()){
				json += "true,";
			}else{
				json += "false,";
			}
			json += "\"count\":\""+baseBean.getCount()+"\",";
			json += "\"reviewList\":[";
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessChinmedichenacareComment  businessChinmedichenacareComment= (BusinessChinmedichenacareComment) baseBean.getList().get(i);
					json += "{\"userId\":\""+businessChinmedichenacareComment.getCommentorId()+"\",";
					if(businessChinmedichenacareComment.getCommentorState()==1){
						json +="\"avatar\":\""+ip+businessChinmedichenacareComment.getAvatar()+"\",\"name\":\""
								+businessChinmedichenacareComment.getBuNickname()+"\",";
					}else{
						json +="\"avatar\":\""+ip+businessChinmedichenacareComment.getPortrait()+"\",\"name\":\""
								+businessChinmedichenacareComment.getNickname()+"\",";
					}
					json +="\"commentTime\":\""+DateUtil.getInterval(businessChinmedichenacareComment.getCommentTime())+"\",";
						json += "\"replyName\":\""+businessChinmedichenacareComment.getRepliedName()+"\",";
						json += "\"replyId\":\""+businessChinmedichenacareComment.getRepliedId()+"\",";
						json += "\"content\":\""+businessChinmedichenacareComment.getComment()+"\",";
						if(businessChinmedichenacareComment.getCommentorState()==1){
							json +="\"userType\":\"1\",";
						}else{
							json +="\"userType\":\"0\",";
						}
						if(businessChinmedichenacareComment.getRepliedState()==1){
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
			response.getWriter().write(json.replace("\n", "\\n\\r").replace("\n\r", "\\n\\r"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户评论中医养生
	 * @param userId,sessionid,ID,content
	 * @return
	 * json
	 */
	@RequestMapping(value="saveReview")
	public void saveReview(HttpServletRequest request, HttpServletResponse response,BusinessChinmedichenacareCommentQuery query) {
		String json = "";
		try{
			BusinessChinmedichenacareComment businessChinmedichenacareComment = new BusinessChinmedichenacareComment();
			Timestamp  ts=new Timestamp(new Date().getTime());
			businessChinmedichenacareComment.setCommentTime(ts);
			businessChinmedichenacareComment.setCmhcId(query.getID());
			businessChinmedichenacareComment.setCommentorId(query.getUserId());
			businessChinmedichenacareComment.setComment(SensitivewordFilter.replaceSensitiveWord(query.getContent(),1,"*"));
			businessChinmedichenacareComment.setRepliedId(query.getReplyId());
			businessChinmedichenacareComment.setRepliedName(query.getReplyName());
			if(null==query.getReplyId()){
				businessChinmedichenacareComment.setRepliedId(0);
			}
			if(null==query.getReplyName()){
				businessChinmedichenacareComment.setRepliedName("");
			}
			businessChinmedichenacareComment.setCommentorState(0);//居民
			businessChinmedichenacareComment.setRepliedState(0);
			businessChinmedichenacareCommentService.save(businessChinmedichenacareComment);
			BusinessChinmedichenacare businessChinmedichenacare = businessChinmedichenacareService.findById_app(query.getID());
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"评论成功\",";
			json += "\"content\":{";
			//json += "\"comments\":\""+businessNews.getComments()+"\"";
			json += "\"commentId\":\""+businessChinmedichenacareComment.getCommentId()+"\",";
			json += "\"commentor\":\""+businessChinmedichenacareComment.getCommentorName()+"\",";
			json += "\"content\":\""+businessChinmedichenacareComment.getComment()+"\",";
			json += "\"commentTime\":\""+businessChinmedichenacareComment.getCommentTime()+"\",";
			json += "\"replyId\":\""+businessChinmedichenacareComment.getRepliedId()+"\",";
			json += "\"replyName\":\""+businessChinmedichenacareComment.getRepliedName()+"\",";
			json += "\"comments\":\""+businessChinmedichenacare.getComments()+"\",";
			json += "\"commentorId\":\""+businessChinmedichenacareComment.getCommentorState()+"\"";
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
			response.getWriter().write(json.replace("\n", "\\n\\r").replace("\n\r", "\\n\\r"));
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
			appStatisticsClick.setType(85);
			appStatisticsClick.setTypeName("中医养生评论");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户回复中医养生
	 * @param userId,sessionid,ID,content
	 * @return
	 * json
	 */
	@RequestMapping(value="saveReply")
	public void saveReply(HttpServletRequest request, HttpServletResponse response,BusinessChinmedichenacareCommentQuery query) {
		String json = "";
		try{
			BusinessChinmedichenacareComment businessChinmedichenacareComment = new BusinessChinmedichenacareComment();
			Timestamp  ts=new Timestamp(new Date().getTime());
			businessChinmedichenacareComment.setCommentTime(ts);
			businessChinmedichenacareComment.setCmhcId(query.getID());
			businessChinmedichenacareComment.setCommentorId(query.getUserId());
			businessChinmedichenacareComment.setComment(SensitivewordFilter.replaceSensitiveWord(query.getContent(),1,"*"));
			businessChinmedichenacareComment.setRepliedId(query.getReplyId());
			businessChinmedichenacareComment.setRepliedName(query.getReplyName());
			if(null==query.getReplyId()){
				businessChinmedichenacareComment.setRepliedId(0);
			}
			if(null==query.getReplyName()){
				businessChinmedichenacareComment.setRepliedName("");
			}
			businessChinmedichenacareComment.setCommentorState(0);//居民
			businessChinmedichenacareComment.setRepliedState(0);
			businessChinmedichenacareCommentService.save(businessChinmedichenacareComment);
			BusinessChinmedichenacare businessChinmedichenacare = businessChinmedichenacareService.findById_app(query.getID());
			if(!(businessChinmedichenacareComment.getRepliedState()==1)){
				AppUserNews appUserNews = new AppUserNews();
				appUserNews.setUserId(query.getReplyId());
				appUserNews.setCreateTime(ts);
				appUserNews.setNewTitle(businessChinmedichenacare.getCmhcTitle());
				appUserNews.setType(9);
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
			json += "\"commentId\":\""+businessChinmedichenacareComment.getCommentId()+"\",";
			json += "\"commentor\":\""+businessChinmedichenacareComment.getCommentorName()+"\",";
			json += "\"content\":\""+businessChinmedichenacareComment.getComment()+"\",";
			json += "\"commentTime\":\""+businessChinmedichenacareComment.getCommentTime()+"\",";
			json += "\"replyId\":\""+businessChinmedichenacareComment.getRepliedId()+"\",";
			json += "\"replyName\":\""+businessChinmedichenacareComment.getRepliedName()+"\",";
			json += "\"comments\":\""+businessChinmedichenacare.getComments()+"\",";
			json += "\"commentorId\":\""+businessChinmedichenacareComment.getCommentorState()+"\"";
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
			response.getWriter().write(json.replace("\n", "\\n\\r").replace("\n\r", "\\n\\r"));
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
			appStatisticsClick.setType(86);
			appStatisticsClick.setTypeName("回复养生评论");
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
	public void support(HttpServletRequest request, HttpServletResponse response,BusinessChinmedichenacareCommentQuery query) {
		String json = "";
		try{
			BusinessChinmedichenacareSupportQuery businessChinmedichenacareSupportQuery = new BusinessChinmedichenacareSupportQuery();
			businessChinmedichenacareSupportQuery.setUserId(query.getUserId());
			businessChinmedichenacareSupportQuery.setCmchId(query.getID());
			int count = businessChinmedichenacareSupportService.selectCount(businessChinmedichenacareSupportQuery);
			if(count==0){
				BusinessChinmedichenacareSupport businessChinmedichenacareSupport = new BusinessChinmedichenacareSupport();
				businessChinmedichenacareSupport.setUserId(query.getUserId());
				businessChinmedichenacareSupport.setCmchId(query.getID());
				Timestamp  ts=new Timestamp(new Date().getTime());
				businessChinmedichenacareSupport.setCreateTime(ts);
				businessChinmedichenacareSupportService.save(businessChinmedichenacareSupport);
				BusinessChinmedichenacare businessChinmedichenacare = businessChinmedichenacareService.findById_app(query.getID());
				json += "{";
				json += "\"errorCode\":\"200\",";
				json += "\"message\":\"点赞成功\",";
				json += "\"content\":{";
				json += "\"supports\":\""+businessChinmedichenacare.getSupports()+"\"";
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
			response.getWriter().write(json.replace("\n", "\\n\\r").replace("\n\r", "\\n\\r"));
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
			appStatisticsClick.setType(84);
			appStatisticsClick.setTypeName("点赞中医养生");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户查看中医养生的详情
	 * @param userId,sessionid,ID
	 * @return
	 * json
	 */
	@RequestMapping(value="getDetailsById")
	public ModelAndView getDetailsById(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/service/chinmedichenacare");
		String userId = request.getParameter("userId");
		String newsId = request.getParameter("ID");
		try{
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp");   
			String phpIp = p.getProperty("phpIp");   

			//Integer userId = 1;
			if(userId!=null && !userId.equals("0") && !userId.equals("")){
				AppUser appUser = appUserService.findById(new Integer(userId));
				mav.addObject("protrait", ip+appUser.getPortrait());
				mav.addObject("nickname", appUser.getNickname());
			}else {
				userId = "0";
			}
			
			List commentList = new ArrayList();
			String path = request.getContextPath();
			String ctx = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path; 
			BusinessChinmedichenacare businessChinmedichenacare = businessChinmedichenacareService.findById_app(new Integer(newsId));
			mav.addObject("ctx", ctx);
			mav.addObject("newsId", businessChinmedichenacare.getCmhcId());
			mav.addObject("doctorBrief", businessChinmedichenacare.getDoctorBrief());
			mav.addObject("publisherName", businessChinmedichenacare.getDoctorName());
			mav.addObject("publishTime", businessChinmedichenacare.getPublishTime());
			mav.addObject("publisherProtrait", ip+businessChinmedichenacare.getAvatar());
			mav.addObject("title",businessChinmedichenacare.getCmhcTitle());
			mav.addObject("newsContent", businessChinmedichenacare.getCmhcContent());
			mav.addObject("supports", businessChinmedichenacare.getSupports());
			mav.addObject("comments", businessChinmedichenacare.getComments());
			mav.addObject("newsId", newsId);
			mav.addObject("userId", userId);
			mav.addObject("download", request.getParameter("download"));
			mav.addObject("phpIp", phpIp);
			mav.addObject("appPic", businessChinmedichenacare.getAppPic());
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			AppStatisticsClick appStatisticsClick = new AppStatisticsClick();
			appStatisticsClick.setCreateTime(ts);
			appStatisticsClick.setEditTime(ts);
			appStatisticsClick.setUserId(new Integer(userId));
			appStatisticsClick.setType(83);
			appStatisticsClick.setTypeName("中医养生详情");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
		return mav;	
	}
	
	/**
	 * 用户查看中医养生的详情
	 * @param userId,sessionid,ID
	 * @return
	 * json
	 */
	@RequestMapping(value="getDetailsByIdComment")
	public ModelAndView getDetailsByIdComment(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/service/chinmedichenacareComment");
		String userId = request.getParameter("userId");
		String newsId = request.getParameter("ID");
		try{
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp");   
			String phpIp = p.getProperty("phpIp");   

			//Integer userId = 1;
			if(userId!=null && !userId.equals("0") && !userId.equals("")){
				AppUser appUser = appUserService.findById(new Integer(userId));
				mav.addObject("protrait", ip+appUser.getPortrait());
				mav.addObject("nickname", appUser.getNickname());
			}else {
				userId = "0";
			}
			
			List commentList = new ArrayList();
			String path = request.getContextPath();
			String ctx = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path; 
			BusinessChinmedichenacare businessChinmedichenacare = businessChinmedichenacareService.findById_app(new Integer(newsId));
			mav.addObject("ctx", ctx);
			mav.addObject("newsId", businessChinmedichenacare.getCmhcId());
			mav.addObject("doctorBrief", businessChinmedichenacare.getDoctorBrief());
			mav.addObject("publisherName", businessChinmedichenacare.getDoctorName());
			mav.addObject("publishTime", businessChinmedichenacare.getPublishTime());
			mav.addObject("publisherProtrait", ip+businessChinmedichenacare.getAvatar());
			mav.addObject("title",businessChinmedichenacare.getCmhcTitle());
			mav.addObject("newsContent", businessChinmedichenacare.getCmhcContent());
			mav.addObject("supports", businessChinmedichenacare.getSupports());
			mav.addObject("comments", businessChinmedichenacare.getComments());
			mav.addObject("newsId", newsId);
			mav.addObject("userId", userId);
			mav.addObject("download", request.getParameter("download"));
			mav.addObject("phpIp", phpIp);
			mav.addObject("appPic", businessChinmedichenacare.getAppPic());
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			AppStatisticsClick appStatisticsClick = new AppStatisticsClick();
			appStatisticsClick.setCreateTime(ts);
			appStatisticsClick.setEditTime(ts);
			appStatisticsClick.setUserId(new Integer(userId));
			appStatisticsClick.setType(83);
			appStatisticsClick.setTypeName("中医养生详情");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
		return mav;	
	}
	
	/**
	 * 用户查看中医养生回复我的的详情
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
		
		ModelAndView mav = new ModelAndView("/service/userChinmedichenacare");
		
		List commentList = new ArrayList();
		String path = request.getContextPath();
		String ctx = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path; 
		String protrait = ip+appUser.getPortrait();
		BusinessChinmedichenacare businessChinmedichenacare = businessChinmedichenacareService.findById_app(newsId);
		mav.addObject("ctx", ctx);
		mav.addObject("newsId", businessChinmedichenacare.getCmhcId());
		mav.addObject("doctorBrief", businessChinmedichenacare.getDoctorBrief());
		mav.addObject("publisherName", businessChinmedichenacare.getDoctorName());
		mav.addObject("publishTime", businessChinmedichenacare.getPublishTime());
		mav.addObject("publisherProtrait", ip+businessChinmedichenacare.getAvatar());
		mav.addObject("title",businessChinmedichenacare.getCmhcTitle());
		mav.addObject("newsContent", businessChinmedichenacare.getCmhcContent());
		mav.addObject("protrait", protrait);
		mav.addObject("supports", businessChinmedichenacare.getSupports());
		mav.addObject("comments", businessChinmedichenacare.getComments());
		mav.addObject("realName", appUser.getRealname());
		mav.addObject("newsId", newsId);
		mav.addObject("sessionid", sessionid);
		mav.addObject("userId", userId);
		mav.addObject("nickname", appUser.getNickname());
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			AppStatisticsClick appStatisticsClick = new AppStatisticsClick();
			appStatisticsClick.setCreateTime(ts);
			appStatisticsClick.setEditTime(ts);
			appStatisticsClick.setUserId(userId);
			appStatisticsClick.setType(83);
			appStatisticsClick.setTypeName("中医养生详情");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		Map propMap = new HashMap();
		propMap.put("newsId",businessChinmedichenacare.getCmhcId());
		return mav;	
	}
}
