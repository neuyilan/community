package com.community.service.station;



/**
 * 驿站相关处理接口
 * 包括：
 * 用户信息
 * 
 * @author zyp-2_000
 *
 */

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
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
import com.community.app.module.bean.BusinessFeedback;
import com.community.app.module.bean.BusinessProduct;
import com.community.app.module.bean.BusinessProductComment;
import com.community.app.module.bean.BusinessPropertyMaterial;
import com.community.app.module.bean.BusinessStation;
import com.community.app.module.bean.BusinessStationMessage;
import com.community.app.module.bean.BusinessTel;
import com.community.app.module.bean.BusinessTelGroup;
import com.community.app.module.bean.BusinessUser;
import com.community.app.module.service.AppLatestNewsService;
import com.community.app.module.service.AppStatisticsClickService;
import com.community.app.module.service.AppUserNewsService;
import com.community.app.module.service.AppUserService;
import com.community.app.module.service.BusinessAnnoCommentService;
import com.community.app.module.service.BusinessAnnoService;
import com.community.app.module.service.BusinessAnnoSupportService;
import com.community.app.module.service.BusinessFeedbackService;
import com.community.app.module.service.BusinessStationMessageService;
import com.community.app.module.service.BusinessStationService;
import com.community.app.module.service.BusinessStationServiceService;
import com.community.app.module.service.BusinessUserService;
import com.community.app.module.vo.AppLatestNewsQuery;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessAnnoCommentQuery;
import com.community.app.module.vo.BusinessAnnoQuery;
import com.community.app.module.vo.BusinessAnnoSupportQuery;
import com.community.app.module.vo.BusinessFeedbackQuery;
import com.community.app.module.vo.BusinessStationMessageQuery;
import com.community.app.module.vo.BusinessStationServiceQuery;
import com.community.app.module.vo.BusinessTelQuery;
import com.community.framework.utils.DateUtil;
import com.community.framework.utils.propertiesUtil;
import com.community.framework.utils.testfilter.src.com.gao.SensitivewordFilter;


@Controller
@RequestMapping("/service/station")
public class StationController {
	private static Logger GSLogger = LoggerFactory.getLogger(StationController.class);
	@Autowired
	private BusinessAnnoService businessAnnoService;
	@Autowired
	private BusinessFeedbackService businessFeedbackService;
	@Autowired
	private BusinessAnnoCommentService businessAnnoCommentService;
	@Autowired
	private BusinessAnnoSupportService businessAnnoSupportService;
	@Autowired
	private BusinessUserService businessUserService;
	@Autowired
	private BusinessStationServiceService businessStationServiceService;
	@Autowired
	private BusinessStationService businessStationService;
	@Autowired
	private AppUserNewsService appUserNewsService;
	@Autowired
	private AppLatestNewsService appLatestNewsService;
	@Autowired
	private AppUserService appUserService;
	@Autowired
	private AppStatisticsClickService appStatisticsClickService;
	@Autowired
	private BusinessStationMessageService businessStationMessageService;
	
	
	/**
	 * 用户查看所属服务驿站信息
	 * @param stationId,sessionid
	 * @return
	 * json
	 */
	@RequestMapping(value="getStationById")
	public void getStationById(HttpServletRequest request, HttpServletResponse response,BusinessStationServiceQuery query) {
		String json = "";
		try{
			query.setStationId(query.getID());
			BusinessStation businessStation = businessStationService.findById(query.getID());
			List<com.community.app.module.bean.BusinessStationService>  list = businessStationServiceService.findByExample(query);
			List<BusinessUser> userList = businessUserService.findByStationGril(query.getID());
			Properties p = propertiesUtil.getProperties("config.properties");
			 String ip = p.getProperty("imageIp");   
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"获取成功\",";
			json += "\"content\":{";
			json += "\"ID\":\""+businessStation.getStationId()+"\",";
			json += "\"name\":\""+businessStation.getStaName()+"\",";
			json += "\"tel\":\""+businessStation.getStaTel()+"\",";
			json += "\"addr\":\""+ip+businessStation.getAddrUrl()+"\",";
			json += "\"staLongitude\":\""+businessStation.getStaLongitude()+"\",";
			json += "\"staLatitude\":\""+businessStation.getStaLatitude()+"\",";
			json += "\"staBrief\":\""+businessStation.getStaBrief()+"\",";
			json += "\"serviceList\":[";
			for (com.community.app.module.bean.BusinessStationService businessStationService : list) {
				if("驿站位置".equals(businessStationService.getServiceName())){
					json += "{\"title\":\"驿站位置\",\"image\":\""+ip+businessStationService.getServicePic()+"\",\"map\":\""+ip+businessStation.getAddrUrl()+"\",\"mapTitle\":\""+businessStation.getAddrName()+"\",\"type\":\"1\"},";
				}
			}
			for (com.community.app.module.bean.BusinessStationService businessStationService : list) {
				if(!"驿站位置".equals(businessStationService.getServiceName())){
					json += "{\"title\":\""+businessStationService.getServiceName()+"\",\"image\":\""+ip+businessStationService.getServicePic()+"\",\"utl\":\""+ip+businessStationService.getContent()+"\",\"type\":\"2\"},";
				}
			}
			if(list.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "],";
			
			List<BusinessUser> businessUserList = businessUserService.findByStationGril(query.getID());
			json += "\"grilList\":[";
			for (BusinessUser businessUser : businessUserList) {
				json += "{\"ID\":\""+businessUser.getUserId()+"\",\"age\":\""+businessUser.getAge()+"\",\"name\":\""+businessUser.getNickname()+"\",\"avatar\":\""+ip+businessUser.getAvatar()+"\",\"tel\":\""+businessUser.getStationtel()+"\",\"userBrief\":\""+businessUser.getComWord()+"\"},";
			}
			if(list.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "],";
			
			BusinessAnnoQuery businessAnnoQuery = new BusinessAnnoQuery();
			businessAnnoQuery.setRows(15);
			businessAnnoQuery.setOrder("desc");
			businessAnnoQuery.setSort("publishTime");
			businessAnnoQuery.setAnnoScope(query.getEstateId()+"");
			businessAnnoQuery.setAnnoType(0);
			businessAnnoQuery.setPublishState(0);
			BaseBean baseBean = businessAnnoService.findAllPage_app(businessAnnoQuery);
			json += "\"notice\":";
			for(int i=0;i<baseBean.getList().size();i++) {
				if (i==1) {
					break;
				}
				BusinessAnno businessAnno = (BusinessAnno) baseBean.getList().get(i);
				json += "{\"ID\":\""+businessAnno.getAnnoId()+"\",\"title\":\""+businessAnno.getAnnoTitle()+"\",\"time\":\""
				+DateUtil.getInterval(businessAnno.getPublishTime())+"\",\"brief\":\""+businessAnno.getBrief()+"\",";
				if("".equals(businessAnno.getAnnoPic()) || businessAnno.getAnnoPic()==null  || businessAnno.getAnnoPic().indexOf("/images/icon/")>=0){
					json +="\"pic\":\"\",";
				}else{
					json +="\"pic\":\""+ip+businessAnno.getAnnoPic()+"\",";
				}
				json += "\"publisherId\":\""+businessAnno.getPublisherId()+"\",\"publisherName\":\""+businessAnno.getNickname()+"\",\"avatar\":\""+ip+businessAnno.getPortrait()+"\"},";
			}
			if(baseBean.getList().size() > 0) {
				json = json.substring(0, json.length()-1);
			}
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
			appStatisticsClick.setType(29);
			appStatisticsClick.setTypeName("驿站服务");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 用户获取驿站服务建议列表
	 * @param userId,sessionid,type,page,rows
	 * @return
	 * json
	 */
	@RequestMapping(value="findStationAdviceListByUser")
	public void findStationAdviceListByUser (HttpServletRequest request, HttpServletResponse response,BusinessFeedbackQuery query) {
		String json = "";
		try{
			query.setRows(15);
			query.setFberId(query.getUserId());
			Timestamp  ts=new Timestamp(new Date().getTime()+30*24*60*60*1000);
			query.setEditTime(ts);
			query.setOrder("desc");
			query.setSort("editTime");
			BaseBean baseBean = businessFeedbackService.findAllPage_app(query);
			AppLatestNewsQuery appLatestNewsQuery = new AppLatestNewsQuery();
			appLatestNewsQuery.setUserId(query.getUserId());
			appLatestNewsQuery.setTo(0);
			appLatestNewsQuery.setTypeId(20);
			List<AppLatestNews> list = appLatestNewsService.findByExample(appLatestNewsQuery);
			AppLatestNews appLatestNews = new AppLatestNews();
			appLatestNews.setUserId(query.getUserId());
			appLatestNews.setTo(0);
			if(query.getFbType()==1){
				appLatestNews.setTypeId(14);
			}else if (query.getFbType()==2){
				appLatestNews.setTypeId(11);
			}else{
				appLatestNews.setTypeId(12);
			}
			appLatestNewsService.delete_app(appLatestNews);

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
				BusinessFeedback businessFeedback = (BusinessFeedback) baseBean.getList().get(i);
				json += "{";
				json += "\"ID\":\""+businessFeedback.getFeedbackId()+"\",";
				json += "\"time\":\""+DateUtil.getInterval(businessFeedback.getFbTime())+"\",";
				json += "\"content\":\""+businessFeedback.getFbContent()+"\",";
				json += "\"brief\":\""+businessFeedback.getFbContent()+"\"";
				if("".equals(businessFeedback.getFbContent())){
					json += ",\"type\":\"1\"";
				}else {
					json += ",\"type\":\"0\"";
				}
				boolean  flag = false ; //管家列表状态
				for (AppLatestNews appLatestNews2 : list) {
					if(appLatestNews2.getSourceId().equals(businessFeedback.getFeedbackId())){
						flag = true;
					}
				}
				if (flag) {
					json += ",\"status\":true";
				}else {
					json += ",\"status\":false";
				}
				json +="},";
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
			if(query.getFbType()==1) {
				appStatisticsClick.setType(72);
				appStatisticsClick.setTypeName("物业建议列表");
			}else if(query.getFbType()==2){
				appStatisticsClick.setType(68);
				appStatisticsClick.setTypeName("使用反馈列表");
			}else{
				appStatisticsClick.setType(70);
				appStatisticsClick.setTypeName("驿站建议列表");
			}
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户查看驿站服务建议详情
	 * @param userId,sessionid,advinceId
	 * @return
	 * json
	 */
	@RequestMapping(value="findStationAdvice")
	public void findStationAdvice (HttpServletRequest request, HttpServletResponse response) {
		System.out.println("userId:"+request.getParameter("userId"));
		System.out.println("sessionid:"+request.getParameter("sessionid"));
		System.out.println("advinceId:"+request.getParameter("advinceId"));
		String json = "";
		json += "{";
		json += "\"errorCode\":\"200\",";
		json += "\"message\":\"执行成功\",";
		json += "\"content\":{";
		json += "\"ID\":\"1\",";
		json += "\"time\":\"2001-1-1 11:11:11\",";
		json += "\"content\":\"详细内容\",";
		json += "\"pics\":[";
		json += "{\"pic\":\"图片1\"},";
		json += "{\"pic\":\"图片2\"}";
		json += "],";
		json += "\"speechSounds\":[";
		json += "{\"speechSound\":\"语音1\"},";
		json += "{\"speechSound\":\"语音2\"}";
		json += "],";
		json += "\"PageState\":true,";
		json += "\"detail\":[";
		json += "{\"type\":\"1\",\"userId\":\"1\",\"avatar\":\"头像\",\"name\":\"张三\",\"commentTime\":\"2011-11-11 19:11:11\",\"content\":\"你好\",\"role\":\"1\"},";
		json += "{\"type\":\"2\",\"userId\":\"2\",\"avatar\":\"头像\",\"name\":\"张三\",\"commentTime\":\"2011-11-11 19:11:11\",\"speechSound\":\"语音\",\"role\":\"1\"}";
		json += "]";
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
	 * 用户发布驿站服务建议
	 * @param userId,sessionid,content
	 * @return
	 * json
	 */
	@RequestMapping(value="publishStationAdvice")
	public void publishStationAdvice (HttpServletRequest request, HttpServletResponse response) {
		System.out.println("userId:"+request.getParameter("userId"));
		System.out.println("sessionid:"+request.getParameter("sessionid"));
		System.out.println("content:"+request.getParameter("content"));
		String json = "";
		json += "{";
		json += "\"errorCode\":\"200\",";
		json += "\"message\":\"发布成功\"";
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
	 * 用户回复驿站服务建议
	 * @param userId,sessionid,content,type
	 * @return
	 * json
	 */
	@RequestMapping(value="replyStationAdvice")
	public void replyStationAdvice (HttpServletRequest request, HttpServletResponse response) {
		System.out.println("userId:"+request.getParameter("userId"));
		System.out.println("sessionid:"+request.getParameter("sessionid"));
		System.out.println("content:"+request.getParameter("content"));
		String json = "";
		json += "{";
		json += "\"errorCode\":\"200\",";
		json += "\"message\":\"回复成功\"";
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
	 * 用户查看驿站公告
	 * @param userId,sessionid,page,rows
	 * @return
	 * json
	 */
	@RequestMapping(value="findByStation")
	public void findByStation (HttpServletRequest request, HttpServletResponse response,BusinessAnnoQuery query) {
		String json = "";
		try{
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp");   
			query.setRows(15);
			query.setOrder("desc");
			query.setSort("publishTime");
			query.setAnnoScope(query.getEstateId()+"");
			query.setAnnoType(0);
			query.setPublishState(0);
			BaseBean baseBean = businessAnnoService.findAllPage_app(query);
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
				BusinessAnno businessAnno = (BusinessAnno) baseBean.getList().get(i);
				json += "{\"ID\":\""+businessAnno.getAnnoId()+"\",\"title\":\""+businessAnno.getAnnoTitle()+"\",\"time\":\""
				+DateUtil.getInterval(businessAnno.getPublishTime())+"\",\"brief\":\""+businessAnno.getBrief()+"\",";
				if("".equals(businessAnno.getAnnoPic()) || businessAnno.getAnnoPic()==null  || businessAnno.getAnnoPic().indexOf("/images/icon/")>=0){
					json +="\"pic\":\"\",";
				}else{
					json +="\"pic\":\""+ip+businessAnno.getAnnoPic()+"\",";
				}
				json += "\"publisherId\":\""+businessAnno.getPublisherId()+"\",\"publisherName\":\""+businessAnno.getNickname()+"\",\"avatar\":\""+ip+businessAnno.getPortrait()+"\"},";
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
			appStatisticsClick.setType(32);
			appStatisticsClick.setTypeName("驿站公告列表");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户查看驿站公告详情
	 * @param userId,sessionid,ID
	 * @return
	 * json
	 */
	@RequestMapping(value="getPopertyDetailsById")
	public void getPopertyDetailsById (HttpServletRequest request, HttpServletResponse response) {
		System.out.println("userId:"+request.getParameter("userId"));
		System.out.println("sessionid:"+request.getParameter("sessionid"));
		System.out.println("advinceId:"+request.getParameter("advinceId"));
		String json = "";
		json += "{";
		json += "\"errorCode\":\"200\",";
		json += "\"message\":\"获取成功\",";
		json += "\"content\":{";
		json += "\"ID\":\"1\",";
		json += "\"title\":\"标题啊\",";
		json += "\"time\":\"\"200\"1-1-1 11:11:11\",";
		json += "\"supports\":\"12\",";
		json += "\"comments\":\"12\",";
		json += "\"publisherId\":\"12\",";
		json += "\"publisherName\":\"张三\",";
		json += "\"avatar\":\"头像\",";
		json += "\"content\":\"详细内容\",";
		json += "\"pics\":[";
		json += "{\"pic\":\"图片1\"},";
		json += "{\"pic\":\"图片2\"}";
		json += "]";
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
	 * 用户查看驿站公告评论
	 * @param userId,sessionid,ID,page,rows
	 * @return
	 * json
	 */
	@RequestMapping(value="getStationReviewById")
	public void getStationReviewById(HttpServletRequest request, HttpServletResponse response,BusinessAnnoCommentQuery query) {
		String json = "";
		try{
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp");   
			query.setRows(15);
			query.setOrder("desc");
			query.setSort("commentTime");
			query.setAnnoId(query.getID());
			BaseBean baseBean = businessAnnoCommentService.findAllPage_app(query);
			BusinessAnno BusinessAnno = businessAnnoService.findById_app(query.getID());
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"获取成功\",";
			json += "\"content\":{";
			json += "\"supports\":\""+BusinessAnno.getSupports()+"\",";
			json += "\"comments\":\""+BusinessAnno.getComments()+"\",";
			json += "\"PageState\":";
			if(baseBean.getCount()>query.getPage()*query.getRows()){
				json += "true,";
			}else{
				json += "false,";
			}
			json += "\"reviewList\":[";
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessAnnoComment  businessAnnoComment= (BusinessAnnoComment) baseBean.getList().get(i);
					json += "{\"userId\":\""+businessAnnoComment.getCommentorId()+"\",";
					if(businessAnnoComment.getCommentorState()==1){
						json +="\"avatar\":\""+ip+businessAnnoComment.getAvatar()+"\",\"name\":\""
								+businessAnnoComment.getBuNickname()+"\",";
					}else{
						json +="\"avatar\":\""+ip+businessAnnoComment.getPortrait()+"\",\"name\":\""
								+businessAnnoComment.getNickname()+"\",";
					}
					json +="\"commentTime\":\""+DateUtil.getInterval(businessAnnoComment.getCommentTime())+"\",";
						json += "\"replyName\":\""+businessAnnoComment.getRepliedName()+"\",";
						json += "\"replyId\":\""+businessAnnoComment.getRepliedId()+"\",";
						json += "\"content\":\""+businessAnnoComment.getComment()+"\",";
						if(businessAnnoComment.getCommentorState()==1){
							json +="\"userType\":\"1\",";
						}else{
							json +="\"userType\":\"0\",";
						}
						if(businessAnnoComment.getRepliedState()==1){
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
	 * 用户查看驿站公告回复我的评论
	 * @param userId,sessionid,ID,page,rows
	 * @return
	 * json
	 */
	@RequestMapping(value="getStationReviewByUserId")
	public void getStationReviewByUserId(HttpServletRequest request, HttpServletResponse response,BusinessAnnoCommentQuery query) {
		String json = "";
		try{
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp");   
			query.setRows(15);
			query.setOrder("desc");
			query.setSort("commentTime");
			query.setAnnoId(query.getID());
			query.setCommentorState(0);
			query.setReplyState(0);
			BaseBean baseBean = businessAnnoCommentService.findAllPage_app(query);
			BusinessAnno BusinessAnno = businessAnnoService.findById_app(query.getID());
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
			json += "\"supports\":\""+BusinessAnno.getSupports()+"\",";
			json += "\"comments\":\""+BusinessAnno.getComments()+"\",";
			json += "\"PageState\":";
			if(baseBean.getCount()>query.getPage()*query.getRows()){
				json += "true,";
			}else{
				json += "false,";
			}
			json += "\"count\":\""+baseBean.getCount()+"\",";
			json += "\"reviewList\":[";
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessAnnoComment  businessAnnoComment= (BusinessAnnoComment) baseBean.getList().get(i);
					json += "{\"userId\":\""+businessAnnoComment.getCommentorId()+"\",";
					if(businessAnnoComment.getCommentorState()==1){
						json +="\"avatar\":\""+ip+businessAnnoComment.getAvatar()+"\",\"name\":\""
								+businessAnnoComment.getBuNickname()+"\",";
					}else{
						json +="\"avatar\":\""+ip+businessAnnoComment.getPortrait()+"\",\"name\":\""
								+businessAnnoComment.getNickname()+"\",";
					}
					json +="\"commentTime\":\""+DateUtil.getInterval(businessAnnoComment.getCommentTime())+"\",";
						json += "\"replyName\":\""+businessAnnoComment.getRepliedName()+"\",";
						json += "\"replyId\":\""+businessAnnoComment.getRepliedId()+"\",";
						json += "\"content\":\""+businessAnnoComment.getComment()+"\",";
						if(businessAnnoComment.getCommentorState()==1){
							json +="\"userType\":\"1\",";
						}else{
							json +="\"userType\":\"0\",";
						}
						if(businessAnnoComment.getRepliedState()==1){
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
	 * 用户评论驿站公告
	 * @param userId,sessionid,ID,content
	 * @return
	 * json
	 */
	@RequestMapping(value="saveStationReview")
	public void saveStationReview(HttpServletRequest request, HttpServletResponse response,BusinessAnnoCommentQuery query) {
		String json = "";
		try{
			BusinessAnnoComment businessAnnoComment = new BusinessAnnoComment();
			Timestamp  ts=new Timestamp(new Date().getTime());
			businessAnnoComment.setCommentTime(ts);
			businessAnnoComment.setAnnoId(query.getID());
			businessAnnoComment.setCommentorId(query.getUserId());
			businessAnnoComment.setComment(SensitivewordFilter.replaceSensitiveWord(query.getContent(),1,"*"));
			businessAnnoComment.setRepliedId(query.getReplyId());
			businessAnnoComment.setRepliedName(query.getReplyName());
			if(null==query.getReplyId()){
				businessAnnoComment.setRepliedId(0);
			}
			if(null==query.getReplyName()){
				businessAnnoComment.setRepliedName("");
			}
			businessAnnoComment.setCommentorState(0);//居民
			businessAnnoComment.setRepliedState(0);
			businessAnnoCommentService.save(businessAnnoComment);
			BusinessAnno BusinessAnno = businessAnnoService.findById_app(query.getID());
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"评论成功\",";
			json += "\"content\":{";
			//json += "\"comments\":\""+businessNews.getComments()+"\"";
			json += "\"commentId\":\""+businessAnnoComment.getCommentId()+"\",";
			json += "\"commentor\":\""+businessAnnoComment.getCommentorName()+"\",";
			json += "\"content\":\""+businessAnnoComment.getComment()+"\",";
			json += "\"commentTime\":\""+businessAnnoComment.getCommentTime()+"\",";
			json += "\"replyId\":\""+businessAnnoComment.getRepliedId()+"\",";
			json += "\"replyName\":\""+businessAnnoComment.getRepliedName()+"\",";
			json += "\"comments\":\""+BusinessAnno.getComments()+"\",";
			json += "\"commentorId\":\""+businessAnnoComment.getCommentorState()+"\"";
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
			appStatisticsClick.setType(35);
			appStatisticsClick.setTypeName("评论驿站公告");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户回复驿站公告
	 * @param userId,sessionid,ID,replyId,replyName,content
	 * @return
	 * json
	 */
	@RequestMapping(value="saveStationReply")
	public void saveStationReply(HttpServletRequest request, HttpServletResponse response,BusinessAnnoCommentQuery query) {
		String json = "";
		try{
			BusinessAnnoComment businessAnnoComment = new BusinessAnnoComment();
			Timestamp  ts=new Timestamp(new Date().getTime());
			businessAnnoComment.setCommentTime(ts);
			businessAnnoComment.setAnnoId(query.getID());
			businessAnnoComment.setCommentorId(query.getUserId());
			businessAnnoComment.setComment(SensitivewordFilter.replaceSensitiveWord(query.getContent(),1,"*"));
			businessAnnoComment.setRepliedId(query.getReplyId());
			businessAnnoComment.setRepliedName(query.getReplyName());
			if(null==query.getReplyId()){
				businessAnnoComment.setRepliedId(0);
			}
			if(null==query.getReplyName()){
				businessAnnoComment.setRepliedName("");
			}
			businessAnnoComment.setCommentorState(0);//居民
			businessAnnoComment.setRepliedState(query.getReplyType());
			businessAnnoCommentService.save(businessAnnoComment);
			BusinessAnno BusinessAnno = businessAnnoService.findById_app(query.getID());
			if(!(businessAnnoComment.getRepliedState()==1)){
				AppUserNews appUserNews = new AppUserNews();
				appUserNews.setUserId(query.getReplyId());
				appUserNews.setCreateTime(ts);
				appUserNews.setNewTitle(BusinessAnno.getAnnoTitle());
				appUserNews.setType(4);
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
			json += "\"commentId\":\""+businessAnnoComment.getCommentId()+"\",";
			json += "\"commentor\":\""+businessAnnoComment.getCommentorName()+"\",";
			json += "\"content\":\""+businessAnnoComment.getComment()+"\",";
			json += "\"commentTime\":\""+businessAnnoComment.getCommentTime()+"\",";
			json += "\"replyId\":\""+businessAnnoComment.getRepliedId()+"\",";
			json += "\"replyName\":\""+businessAnnoComment.getRepliedName()+"\",";
			json += "\"comments\":\""+BusinessAnno.getComments()+"\",";
			json += "\"commentorId\":\""+businessAnnoComment.getCommentorState()+"\"";
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
			appStatisticsClick.setType(36);
			appStatisticsClick.setTypeName("回复驿站公告");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户点赞驿站公告
	 * @param userId,sessionid,ID
	 * @return
	 * json
	 */
	@RequestMapping(value="supportStation")
	public void supportStation(HttpServletRequest request, HttpServletResponse response,BusinessAnnoCommentQuery query) {
		String json = "";
		try{
			BusinessAnnoSupportQuery businessAnnoSupportQuery = new BusinessAnnoSupportQuery();
			businessAnnoSupportQuery.setUserId(query.getUserId());
			businessAnnoSupportQuery.setAnnoId(query.getID());
			int count = businessAnnoSupportService.selectCount(businessAnnoSupportQuery);
			if(count==0){
				BusinessAnnoSupport businessAnnoSupport = new BusinessAnnoSupport();
				businessAnnoSupport.setUserId(query.getUserId());
				businessAnnoSupport.setAnnoId(query.getID());
				Timestamp  ts=new Timestamp(new Date().getTime());
				businessAnnoSupport.setCreateTime(ts);
				businessAnnoSupportService.save(businessAnnoSupport);
				BusinessAnno businessAnno = businessAnnoService.findById_app(query.getID());
				json += "{";
				json += "\"errorCode\":\"200\",";
				json += "\"message\":\"点赞成功\",";
				json += "\"content\":{";
				json += "\"supports\":\""+businessAnno.getSupports()+"\"";
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
			appStatisticsClick.setType(34);
			appStatisticsClick.setTypeName("点赞驿站公告");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户使用驿站女孩
	 * @param userId,sessionid,stationId
	 * @return
	 * json
	 */
	@RequestMapping(value="findByStationGril")
	public void findByStationGril(HttpServletRequest request, HttpServletResponse response,BusinessAnnoCommentQuery query) {
		String json = "";
		try{
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp");   
			Integer id = new Integer(request.getParameter("stationId"));
			List<BusinessUser> list = businessUserService.findByStationGril(id);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"获取成功\",";
			json += "\"content\":{";
			json += "\"list\":[";
			for (BusinessUser businessUser : list) {
				json += "{\"ID\":\""+businessUser.getUserId()+"\",\"age\":\""+businessUser.getAge()+"\",\"name\":\""+businessUser.getNickname()+"\",\"avatar\":\""+ip+businessUser.getAvatar()+"\",\"tel\":\""+businessUser.getStationtel()+"\",\"userBrief\":\""+businessUser.getComWord()+"\"},";
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
			appStatisticsClick.setType(30);
			appStatisticsClick.setTypeName("驿站女孩");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * 用户使用驿站服务建议
	 * @param userId,sessionid,stationId
	 * @return
	 * json
	 */
	@RequestMapping(value="findByStationIntroduction")
	public void findByStationIntroduction(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		try{
			
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp");   
			Integer id = new Integer(request.getParameter("stationId"));
			Integer type = new Integer(request.getParameter("type"));
			if(type==3){
				json = "";
				json += "{";
				json += "\"errorCode\":\"200\",";
				json += "\"message\":\"获取成功\",";
				json += "\"content\":{";
				json += "\"ID\":\"10\",";
				json += "\"name\":\"金亮\",";
				json += "\"avatar\":\""+ip+"/images/kefu.jpg"+"\",";
				json += "\"brief\":\"您好：我是OK家的客服“小欧”您的声音是我们成长的动力，我们一直在努力...\",";
				json += "\"tel\":\"18600510615\",";
				json += "\"serviceTel\":\"31213454\"";
			}else{
				List<BusinessUser> list = businessUserService.findByStationGril(id);
				int number = new Random().nextInt(10) + 1;
				int max = list.size();
				int count = 0;
				for (int i = 0; i < number; i++) {
					if(!(count == (max-1))){
						count++;
					}else{
						count=0;
					}
				}
				BusinessUser businessUser = list.get(count);
				json += "{";
				json += "\"errorCode\":\"200\",";
				json += "\"message\":\"获取成功\",";
				json += "\"content\":{";
				json += "\"ID\":\""+businessUser.getUserId()+"\",\"name\":\""+businessUser.getNickname()+"\",\"avatar\":\""+ip+businessUser.getAvatar()+"\",\"serviceTel\":\""+businessUser.getStationtel()+"\",\"tel\":\""+businessUser.getUserTel()+"\",";
				if (type==1) {
					json += "\"brief\":\"我们是驿站女孩，如果您对于我们驿站的服务有任何建议，请您随时通过文字、语音和图片的方式告知我们，让我们能够更好的为您服务，驿站就是咱们大家的家！您也可以拨打我的电话\"";
				}else if (type==2){
					json += "\"brief\":\"我们是驿站女孩，如果您对于我们驿站的服务有任何建议，请您随时通过文字、语音和图片的方式告知我们，让我们能够更好的为您服务，驿站就是咱们大家的家！您也可以拨打我的电话\"";
				}
			}
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
	 * 用户查看驿站公告详情
	 * @param userId,sessionid,ID
	 * @return
	 * json
	 */
	@RequestMapping(value="getStationDetailsById")
	public ModelAndView getStationDetailsById(HttpServletRequest request, HttpServletResponse response) {
		Properties p = propertiesUtil.getProperties("config.properties");
		String ip = p.getProperty("imageIp");   
		Integer newsId = new Integer(request.getParameter("ID"));
		//Integer newsId = 48;
		String sessionid = request.getParameter("sessionid");
		//String sessionid = "sessionid";
		Integer userId = new Integer(request.getParameter("userId"));
		//Integer userId = 1;
		AppUser appUser = appUserService.findById(userId);
		
		ModelAndView mav = new ModelAndView("/service/property");
		
		List commentList = new ArrayList();
		String path = request.getContextPath();
		String ctx = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path; 
		String protrait = ip+appUser.getPortrait();
		BusinessAnno businessAnno = businessAnnoService.findById_app(newsId);
		mav.addObject("ctx", ctx);
		mav.addObject("newsId", businessAnno.getAnnoId());
		mav.addObject("publisherName", businessAnno.getNickname());
		mav.addObject("publishTime", businessAnno.getPublishTime());
		mav.addObject("publisherProtrait", ip+businessAnno.getPortrait());
		mav.addObject("title",businessAnno.getAnnoTitle());
		mav.addObject("newsContent", businessAnno.getAnnoContent());
		mav.addObject("protrait", protrait);
		mav.addObject("supports", businessAnno.getSupports());
		mav.addObject("comments", businessAnno.getComments());
		mav.addObject("realName", appUser.getRealname());
		mav.addObject("newsId", newsId);
		mav.addObject("sessionid", sessionid);
		mav.addObject("userId", userId);
		mav.addObject("nickname", appUser.getNickname());
		mav.addObject("download", request.getParameter("download"));
		mav.addObject("appPic", businessAnno.getAppPic());
		Map propMap = new HashMap();
		propMap.put("newsId", businessAnno.getAnnoId());

		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			AppStatisticsClick appStatisticsClick = new AppStatisticsClick();
			appStatisticsClick.setCreateTime(ts);
			appStatisticsClick.setEditTime(ts);
			appStatisticsClick.setUserId(userId);
			appStatisticsClick.setType(33);
			appStatisticsClick.setTypeName("驿站公告详情");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
		return mav;	
	}
	
	/**
	 * 用户查看驿站公告带评论详情
	 * @param userId,sessionid,ID
	 * @return
	 * json
	 */
	@RequestMapping(value="getStationDetailsByIdComment")
	public ModelAndView getStationDetailsByIdComment(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/service/propertyComment");
		String newsId = request.getParameter("ID");
		//Integer newsId = 48;
		String userId = request.getParameter("userId");

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
			BusinessAnno businessAnno = businessAnnoService.findById_app(new Integer(newsId));
			mav.addObject("ctx", ctx);
			mav.addObject("newsId", businessAnno.getAnnoId());
			mav.addObject("publisherName", businessAnno.getNickname());
			mav.addObject("publisherProtrait", ip+businessAnno.getPortrait());
			mav.addObject("publishTime", businessAnno.getPublishTime());
			mav.addObject("title",businessAnno.getAnnoTitle());
			mav.addObject("newsContent", businessAnno.getAnnoContent());
			mav.addObject("supports", businessAnno.getSupports());
			mav.addObject("comments", businessAnno.getComments());
			mav.addObject("newsId", newsId);
			mav.addObject("userId", userId);
			mav.addObject("phpIp", phpIp);
			mav.addObject("download", request.getParameter("download"));
			mav.addObject("appPic", businessAnno.getAppPic());

		}catch(Exception e){
			e.printStackTrace();
		}

		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			AppStatisticsClick appStatisticsClick = new AppStatisticsClick();
			appStatisticsClick.setCreateTime(ts);
			appStatisticsClick.setEditTime(ts);
			appStatisticsClick.setUserId(new Integer(userId));
			appStatisticsClick.setType(33);
			appStatisticsClick.setTypeName("驿站公告详情");
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
	@RequestMapping(value="getStationDetailsById_title")
	public void getStationDetailsById_title(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		try{
			Integer newsId = new Integer(request.getParameter("ID"));
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp");  
			BusinessAnno businessAnno = businessAnnoService.findById_app(newsId);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"获取成功\",";
			json += "\"content\":{";
			json += "\"title\":\""+businessAnno.getAnnoTitle()+"\",";
			json += "\"pic\":\""+ip+businessAnno.getAppPic()+"\"";
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
	 * 用户查看驿站类回复我的详情
	 * @param userId,sessionid,ID
	 * @return
	 * json
	 */
	@RequestMapping(value="getInformationById")
	public ModelAndView getInformationById(HttpServletRequest request, HttpServletResponse response) {
		Properties p = propertiesUtil.getProperties("config.properties");
		String ip = p.getProperty("imageIp");   
		Integer newsId = new Integer(request.getParameter("ID"));
		//Integer newsId = 48;
		String sessionid = request.getParameter("sessionid");
		//String sessionid = "sessionid";
		Integer userId = new Integer(request.getParameter("userId"));
		//Integer userId = 1;
		AppUser appUser = appUserService.findById(userId);
		ModelAndView mav = new ModelAndView("/service/userProperty");
		
		List commentList = new ArrayList();
		String path = request.getContextPath();
		String ctx = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path; 
		String protrait = ip+appUser.getPortrait();
		BusinessAnno businessAnno = businessAnnoService.findById_app(newsId);
		mav.addObject("ctx", ctx);
		mav.addObject("newsId", businessAnno.getAnnoId());
		mav.addObject("publisherName", businessAnno.getNickname());
		mav.addObject("publishTime", businessAnno.getPublishTime());
		mav.addObject("publisherProtrait", ip+businessAnno.getPortrait());
		mav.addObject("title",businessAnno.getAnnoTitle());
		mav.addObject("newsContent", businessAnno.getAnnoContent());
		mav.addObject("protrait", protrait);
		mav.addObject("supports", businessAnno.getSupports());
		mav.addObject("comments", businessAnno.getComments());
		mav.addObject("realName", appUser.getRealname());
		mav.addObject("newsId", newsId);
		mav.addObject("sessionid", sessionid);
		mav.addObject("userId", userId);
		mav.addObject("nickname", appUser.getNickname());
		Map propMap = new HashMap();
		propMap.put("newsId", businessAnno.getAnnoId());
		
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			AppStatisticsClick appStatisticsClick = new AppStatisticsClick();
			appStatisticsClick.setCreateTime(ts);
			appStatisticsClick.setEditTime(ts);
			appStatisticsClick.setUserId(userId);
			appStatisticsClick.setType(33);
			appStatisticsClick.setTypeName("驿站公告详情");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
		return mav;	
	}
	
	/**
	 * 用户查看驿站留言墙
	 * @param userId,sessionid,advinceId
	 * @return
	 * json
	 */
	@RequestMapping(value="getStationMessage")
	public void getStationMessage (HttpServletRequest request, HttpServletResponse response,BusinessStationMessageQuery query) {
		String json = "";
		try {
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp");   
			query.setRows(15);
			query.setOrder("desc");
			query.setSort("commentTime");
			BaseBean baseBean = businessStationMessageService.findAllPage_app(query);
			
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"执行成功\",";
			json += "\"content\":{";
			json += "\"PageState\":";
			if(baseBean.getCount()>query.getPage()*query.getRows()){
				json += "true,";
			}else{
				json += "false,";
			}
			json += "\"reviewList\":[";
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessStationMessage businessStationMessage = (BusinessStationMessage) baseBean.getList().get(i);
				json += "{\"userId\":\""+businessStationMessage.getCommentorId()+"\",";
				if(businessStationMessage.getCommentorState()==1){
					json +="\"avatar\":\""+ip+businessStationMessage.getAvatar()+"\",\"name\":\""
							+businessStationMessage.getBuNickname()+"\",";
				}else{
					json +="\"avatar\":\""+ip+businessStationMessage.getPortrait()+"\",\"name\":\""
							+businessStationMessage.getNickname()+"\",";
				}
				json +="\"commentTime\":\""+DateUtil.getInterval(businessStationMessage.getCommentTime())+"\",";
					json += "\"replyName\":\""+businessStationMessage.getReplyName()+"\",";
					json += "\"replyId\":\""+businessStationMessage.getReplyId()+"\",";
					json += "\"content\":\""+businessStationMessage.getContent()+"\",";
					if(businessStationMessage.getCommentorState()==1){
						json +="\"userType\":\"1\",";
					}else{
						json +="\"userType\":\"0\",";
					}
					if(businessStationMessage.getReplyState()==1){
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
			json += "\"message\":\"修改失败\"";
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
	 * 用户评论驿站留言墙
	 * @param userId,sessionid,advinceId
	 * @return
	 * json
	 */
	@RequestMapping(value="saveStationMessage")
	public void saveStationMessage (HttpServletRequest request, HttpServletResponse response,BusinessStationMessageQuery query) {
		String json = "";
		try{
			BusinessStationMessage businessStationMessage = new BusinessStationMessage();
			Timestamp  ts=new Timestamp(new Date().getTime());
			businessStationMessage.setCommentTime(ts);
			businessStationMessage.setStationId(query.getStationId());
			businessStationMessage.setCommentorId(query.getUserId());
			businessStationMessage.setContent(SensitivewordFilter.replaceSensitiveWord(query.getContent(),1,"*"));
			businessStationMessage.setCommentorState(0);//居民
			businessStationMessage.setReplyState(0);
			if(null==query.getReplyId()){
				businessStationMessage.setReplyId(0);
			}else{
				businessStationMessage.setReplyId(query.getReplyId());
			}
			if(null==query.getReplyName()){
				businessStationMessage.setReplyName("");
			}else{
				businessStationMessage.setReplyName(query.getReplyName());
			}
			businessStationMessageService.save(businessStationMessage);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"评论成功\"";
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
	}
}
