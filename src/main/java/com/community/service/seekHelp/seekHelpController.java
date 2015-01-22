package com.community.service.seekHelp;



/**
 * 邻里求助相关处理接口
 * 包括：
 * @author whh-2_000
 *
 */

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
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


import com.community.app.module.vo.AppLatestNewsQuery;
import com.community.app.module.vo.BusinessHelpCommentQuery;
import com.community.app.module.vo.BusinessHelpQuery;
import com.community.app.module.vo.BusinessHelpSupportQuery;
import com.community.app.module.vo.BusinessNewsCommentQuery;
import com.community.app.module.vo.BusinessNewsSupportQuery;
import com.community.app.module.vo.BusinessRepairQuery;
import com.community.app.module.bean.AppLatestNews;
import com.community.app.module.bean.AppPushLog;
import com.community.app.module.bean.AppStatisticsClick;
import com.community.app.module.bean.AppUser;
import com.community.app.module.bean.AppUserConfig;
import com.community.app.module.bean.AppUserNews;
import com.community.app.module.bean.BusinessAnno;
import com.community.app.module.bean.BusinessFeedback;
import com.community.app.module.bean.BusinessFeedbackComment;
import com.community.app.module.bean.BusinessHelp;
import com.community.app.module.bean.BusinessHelpComment;
import com.community.app.module.bean.BusinessHelpSupport;
import com.community.app.module.bean.BusinessNews;
import com.community.app.module.bean.BusinessNewsComment;
import com.community.app.module.bean.BusinessNewsSupport;
import com.community.app.module.push.AppPushNotificationUtil;
import com.community.app.module.service.AppLatestNewsService;
import com.community.app.module.service.AppPushLogService;
import com.community.app.module.service.AppStatisticsClickService;
import com.community.app.module.service.AppUserConfigService;
import com.community.app.module.service.AppUserNewsService;
import com.community.app.module.service.AppUserService;
import com.community.app.module.service.BusinessAnnoService;
import com.community.app.module.service.BusinessHelpCommentService;
import com.community.app.module.service.BusinessHelpService;
import com.community.app.module.service.BusinessHelpSupportService;
import com.community.app.module.vo.BusinessAnnoQuery;
import com.community.framework.utils.DateUtil;
import com.community.framework.utils.propertiesUtil;
import com.community.framework.utils.testfilter.src.com.gao.SensitivewordFilter;


@Controller
@RequestMapping("/service/seekHelp")
public class seekHelpController {
	private static Logger GSLogger = LoggerFactory.getLogger(seekHelpController.class);
	@Autowired
	private BusinessHelpService businessHelpService;
	@Autowired
	private BusinessHelpCommentService businessHelpCommentService;
	@Autowired
	private BusinessHelpSupportService businessHelpSupportService;
	@Autowired
	private AppLatestNewsService appLatestNewsService;
	@Autowired
	private AppUserNewsService appUserNewsService;
	@Autowired
	private AppPushLogService appPushLogService;
	@Autowired
	private AppUserService appUserService;
	@Autowired
	private AppUserConfigService appUserConfigService;
	@Autowired
	private AppStatisticsClickService appStatisticsClickService;
	
	
	
	
	
	/**
	 * 用户查看我的求助列表
	 * @param userId,sessionid,page,rows
	 * @return
	 * json
	 */
	@RequestMapping(value="findSeekHelpListByUser")
	public void findSeekHelpListByUser(HttpServletRequest request, HttpServletResponse response,BusinessHelpQuery query) {
		String json = "";
		try{
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp"); 
			query.setRows(15);
			query.setHelperId(query.getUserId());
			query.setOrder("desc");
			query.setSort("editTime");
			BaseBean baseBean = businessHelpService.findAllPage1(query);
			
			AppLatestNewsQuery appLatestNewsQuery = new AppLatestNewsQuery();
			appLatestNewsQuery.setUserId(query.getUserId());
			appLatestNewsQuery.setTo(0);
			appLatestNewsQuery.setTypeId(28);
			List<AppLatestNews> list = appLatestNewsService.findByExample(appLatestNewsQuery);
			
			AppLatestNews appLatestNews = new AppLatestNews();
			appLatestNews.setUserId(query.getUserId());
			appLatestNews.setTypeId(27);
			appLatestNews.setTo(0);
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
				BusinessHelp businessHelp = (BusinessHelp) baseBean.getList().get(i);
				json += "{";
				json += "\"ID\":\""+businessHelp.getHelpId()+"\",";
				json += "\"time\":\""+DateUtil.getInterval(businessHelp.getHelpTime())+"\",";
				json += "\"brief\":\""+businessHelp.getHelpContent()+"\",";
				json += "\"publisherId\":\""+businessHelp.getHelperId()+"\",";
				if(businessHelp.getIsNickname()==1){
					json += "\"publisherName\":\"小区居民\",";
				}else {
					json += "\"publisherName\":\""+businessHelp.getHelperName()+"\",";
				}
				json += "\"avatar\":\""+ip+businessHelp.getPortrait()+"\",";
				json += "\"supports\":\""+businessHelp.getSupports()+"\",";
				json += "\"comments\":\""+businessHelp.getComments()+"\"";
				boolean  flag = false ; //求助列表状态
				for (AppLatestNews appLatestNews2 : list) {
					if(appLatestNews2.getSourceId().equals(businessHelp.getHelpId())){
						flag = true;
					}
				}
				if (flag) {
					json += ",\"status\":true";
				}else {
					json += ",\"status\":false";
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
			appStatisticsClick.setType(61);
			appStatisticsClick.setTypeName("我的邻里求助列表");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}	
	
	/**
	 * 用户查看邻里求助
	 * @param userId,sessionid,page,rows
	 * @return
	 * json
	 */
	@RequestMapping(value="findBySeekHelp")
	public void findBySeekHelp(HttpServletRequest request, HttpServletResponse response,BusinessHelpQuery query) {
		String json = "";
		try{
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp");   
			query.setRows(15);
			query.setOrder("desc");
			query.setSort("editTime");
			BaseBean baseBean = businessHelpService.findAllPage_app(query);
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
				BusinessHelp businessHelp = (BusinessHelp) baseBean.getList().get(i);
				json += "{";
				json += "\"ID\":\""+businessHelp.getHelpId()+"\",";
				json += "\"time\":\""+DateUtil.getInterval(businessHelp.getHelpTime())+"\",";
				json += "\"brief\":\""+businessHelp.getHelpContent()+"\",";
				json += "\"publisherId\":\""+businessHelp.getNickname()+"\",";
				if(businessHelp.getIsNickname()==1){
					json += "\"publisherName\":\"小区居民\",";
				}else {
					json += "\"publisherName\":\""+businessHelp.getHelperName()+"\",";
				}
				json += "\"avatar\":\""+ip+businessHelp.getPortrait()+"\",";
				json += "\"supports\":\""+businessHelp.getSupports()+"\",";
				json += "\"comments\":\""+businessHelp.getComments()+"\"";
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
			appStatisticsClick.setType(16);
			appStatisticsClick.setTypeName("邻里求助列表");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户查看邻里求助详情
	 * @param userId,sessionid,ID
	 * @return
	 * json
	 */
	@RequestMapping(value="getSeekHelpDetailsById")
	public void getSeekHelpDetailsById(HttpServletRequest request, HttpServletResponse response,BusinessHelpQuery query) {
		String json = "";
		try{
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp");   
			BusinessHelp businessHelp = businessHelpService.findById_app(query.getID());
			AppLatestNews appLatestNews = new AppLatestNews();
			appLatestNews.setUserId(query.getUserId());
			appLatestNews.setTypeId(28);
			appLatestNews.setTo(0);
			appLatestNews.setSourceId(query.getID());
			appLatestNewsService.delete_app_id(appLatestNews);
			appLatestNews.setTypeId(8);
			appLatestNewsService.delete_app_id(appLatestNews);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"获取成功\",";
			json += "\"content\":{";
			if(query.getPage()==1){
				json += "\"ID\":\""+businessHelp.getHelpId()+"\",";
				json += "\"time\":\""+DateUtil.getInterval(businessHelp.getHelpTime())+"\",";
				json += "\"supports\":\""+businessHelp.getSupports()+"\",";
				json += "\"comments\":\""+businessHelp.getComments()+"\",";
				json += "\"publisherId\":\""+businessHelp.getHelperId()+"\",";
				if(businessHelp.getIsNickname()==1){
					json += "\"publisherName\":\"小区居民\",";
				}else {
					json += "\"publisherName\":\""+businessHelp.getHelperName()+"\",";
				}
				json += "\"avatar\":\""+ip+businessHelp.getPortrait()+"\",";
				json += "\"content\":\""+businessHelp.getHelpContent()+"\",";
				json += "\"pics\":[";
				if(businessHelp.getPics()!=null){
					String[] pic = businessHelp.getPics().split(",");
					for (int i = 0; i < pic.length; i++) {
						json += "{\"pic\":\""+ip+pic[i]+"\"},";
					}
					if(pic.length > 0) {
						json = json.substring(0, json.length()-1);
					}
				}
				json += "],";
				json += "\"speechSounds\":[";
				if(businessHelp.getAudios()!=null && businessHelp.getTime()!=null){
					String[] audios = businessHelp.getAudios().split(",");
					String[] time = businessHelp.getTime().split(",");
					for (int i = 0; i < audios.length; i++) {
						json += "{\"speechSound\":\""+audios[i]+"\",\"time\":\""+time[i]+"\"},";
					}
					if(audios.length> 0) {
						json = json.substring(0, json.length()-1);
					}
				}
				json += "]";
			}
			json += "}";
			json += "}";
		}catch(Exception e){
			json ="";
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
			appStatisticsClick.setType(17);
			appStatisticsClick.setTypeName("查看邻里求助详情");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 用户查看邻里求助详情 for APP H5
	 * @param userId,sessionid,ID
	 * @return
	 * json
	 */
	@RequestMapping(value="getSeekHelpDetailsByIdHTML")
	public ModelAndView getSeekHelpDetailsByIdHTML(HttpServletRequest request, HttpServletResponse response,BusinessHelpQuery query) {
		ModelAndView mav = new ModelAndView("/service/seekHelp/detailAPP");
		try{
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp");   
			BusinessHelp businessHelp = businessHelpService.findById_app(query.getID());
			AppLatestNews appLatestNews = new AppLatestNews();
			appLatestNews.setUserId(query.getUserId());
			appLatestNews.setTypeId(28);
			appLatestNews.setTo(0);
			appLatestNews.setSourceId(query.getID());
			appLatestNewsService.delete_app_id(appLatestNews);
			appLatestNews.setTypeId(8);
			appLatestNewsService.delete_app_id(appLatestNews);
			
			if(businessHelp.getIsNickname()==1)
				businessHelp.setHelperName("小区居民");
			
			Timestamp  ts=new Timestamp(new Date().getTime());
			AppStatisticsClick appStatisticsClick = new AppStatisticsClick();
			appStatisticsClick.setCreateTime(ts);
			appStatisticsClick.setEditTime(ts);
			if(null==query.getUserId()){
				appStatisticsClick.setUserId(0);
			}else{
				appStatisticsClick.setUserId(query.getUserId());
			}
			appStatisticsClick.setType(17);
			appStatisticsClick.setTypeName("查看邻里求助详情");
			appStatisticsClickService.save(appStatisticsClick);
			String path = request.getContextPath();
			String ctx = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
			
			mav.addObject("userId", query.getUserId()); 
			mav.addObject("ID", query.getID()); 
//			mav.addObject("ctx", ctx);
			mav.addObject("ctx", ctx);
			mav.addObject("businessHelp", businessHelp);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return mav;
	}
	
	
	/**
	 * 用户查看邻里求助详情  回复页面 for PHP H5  
	 * @param userId,sessionid,ID
	 * @return
	 * json
	 */
	@RequestMapping(value="getSeekHelpReplyPHP")
	public ModelAndView getSeekHelpReplyPHP(HttpServletRequest request, HttpServletResponse response,BusinessHelpQuery query) {
		ModelAndView mav = new ModelAndView("/service/seekHelp/replyPHP");
		try{
			String path = request.getContextPath();
			String ctx = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
			
			mav.addObject("userId", request.getParameter("userId"));
			mav.addObject("publisherId", request.getParameter("publisherId"));
			mav.addObject("replyId", request.getParameter("replyId"));
			mav.addObject("replyName", request.getParameter("replyName"));
			mav.addObject("replyType", request.getParameter("replyType"));
			mav.addObject("ID", query.getID()); 
			mav.addObject("ctx", ctx);
//			mav.addObject("businessHelp", query);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return mav;
	}
	
	
	
	/**
	 * 用户查看邻里求助详情 for PHP H5
	 * @param userId,sessionid,ID
	 * @return
	 * json
	 */
	@RequestMapping(value="getSeekHelpDetailsByIdHTMLPHP")
	public ModelAndView getSeekHelpDetailsByIdHTMLPHP(HttpServletRequest request, HttpServletResponse response,BusinessHelpQuery query) {
		ModelAndView mav = new ModelAndView("/service/seekHelp/detailPHP");
		try{
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp");   
			BusinessHelp businessHelp = businessHelpService.findById_app(query.getID());
			AppLatestNews appLatestNews = new AppLatestNews();
			appLatestNews.setUserId(query.getUserId());
			appLatestNews.setTypeId(28);
			appLatestNews.setTo(0);
			appLatestNews.setSourceId(query.getID());
			appLatestNewsService.delete_app_id(appLatestNews);
			appLatestNews.setTypeId(8);
			appLatestNewsService.delete_app_id(appLatestNews);
			
			if(businessHelp.getIsNickname()==1)
				businessHelp.setHelperName("小区居民");
			
			Timestamp  ts=new Timestamp(new Date().getTime());
			AppStatisticsClick appStatisticsClick = new AppStatisticsClick();
			appStatisticsClick.setCreateTime(ts);
			appStatisticsClick.setEditTime(ts);
			if(null==query.getUserId()){
				appStatisticsClick.setUserId(0);
			}else{
				appStatisticsClick.setUserId(query.getUserId());
			}
			appStatisticsClick.setType(17);
			appStatisticsClick.setTypeName("查看邻里求助详情");
			appStatisticsClickService.save(appStatisticsClick);
			String path = request.getContextPath();
			String ctx = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
			
			mav.addObject("userId", query.getUserId()); 
			mav.addObject("ID", query.getID()); 
//			mav.addObject("ctx", ctx);
			mav.addObject("ctx", ctx);
			mav.addObject("businessHelp", businessHelp);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return mav;
	}
	
	/**
	 * 用户查看邻里求助的评论
	 * @param userId,sessionid,ID,page,rows
	 * @return
	 * json
	 */
	@RequestMapping(value="getSeekHelpReviewById")
	public void getSeekHelpReviewById(HttpServletRequest request, HttpServletResponse response,BusinessHelpCommentQuery query) {
		String json = "";
		try{
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp");   
			query.setRows(15);
			query.setOrder("desc");
			query.setSort("commentTime");
			query.setHelp(query.getID());
			BaseBean baseBean = businessHelpCommentService.findAllPage_app(query);
			BusinessHelp businessHelp = businessHelpService.findById_app(query.getID());
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"获取成功\",";
			json += "\"content\":{";
			json += "\"rowCount\":"+baseBean.getCount()+",";
			json += "\"supports\":\""+businessHelp.getSupports()+"\",";
			json += "\"comments\":\""+businessHelp.getComments()+"\",";
			
			json += "\"PageState\":";
			if(baseBean.getCount()>query.getPage()*query.getRows()){
				json += "true,";
			}else{
				json += "false,";
			}
			json += "\"reviewList\":[";
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessHelpComment BusinessHelpComment = (BusinessHelpComment) baseBean.getList().get(i);
				json += "{\"userId\":\""+BusinessHelpComment.getCommentorId()+"\",";
				if(BusinessHelpComment.getCommentorState()==1){
					json +="\"avatar\":\""+ip+BusinessHelpComment.getAvatar()+"\",\"name\":\""
							+BusinessHelpComment.getBuNickname()+"\",";
				}else{
					json +="\"avatar\":\""+ip+BusinessHelpComment.getPortrait()+"\",\"name\":\""
							+BusinessHelpComment.getNickname()+"\",";
				}
				json +="\"commentTime\":\""+DateUtil.getInterval(BusinessHelpComment.getCommentTime())+"\",";
					json += "\"replyName\":\""+BusinessHelpComment.getReplyName()+"\",";
					json += "\"replyId\":\""+BusinessHelpComment.getReplyId()+"\",";
					json += "\"content\":\""+BusinessHelpComment.getContent()+"\",";
					if(BusinessHelpComment.getCommentorState()==1){
						json +="\"userType\":\"1\",";
					}else{
						json +="\"userType\":\"0\",";
					}
					if(BusinessHelpComment.getReplyState()==1){
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
	 * 用户查看邻里求助回复我的评论
	 * @param userId,sessionid,ID,page,rows
	 * @return
	 * json
	 */
	@RequestMapping(value="getSeekHelpReviewByUserId")
	public void getSeekHelpReviewByUserId(HttpServletRequest request, HttpServletResponse response,BusinessHelpCommentQuery query) {
		String json = "";
		try{
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp");   
			query.setRows(15);
			query.setOrder("desc");
			query.setSort("commentTime");
			query.setHelp(query.getID());
			query.setCommentorState(0);
			query.setReplyState(0);
			BaseBean baseBean = businessHelpCommentService.findAllPage_app(query);
			BusinessHelp businessHelp = businessHelpService.findById_app(query.getID());

			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"获取成功\",";
			json += "\"content\":{";
			json += "\"rowCount\":"+baseBean.getCount()+",";
			json += "\"supports\":\""+businessHelp.getSupports()+"\",";
			json += "\"comments\":\""+businessHelp.getComments()+"\",";
			
			json += "\"PageState\":";
			if(baseBean.getCount()>query.getPage()*query.getRows()){
				json += "true,";
			}else{
				json += "false,";
			}
			json += "\"count\":\""+baseBean.getCount()+"\",";
			json += "\"reviewList\":[";
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessHelpComment BusinessHelpComment = (BusinessHelpComment) baseBean.getList().get(i);
				json += "{\"userId\":\""+BusinessHelpComment.getCommentorId()+"\",";
				if(BusinessHelpComment.getCommentorState()==1){
					json +="\"avatar\":\""+ip+BusinessHelpComment.getAvatar()+"\",\"name\":\""
							+BusinessHelpComment.getBuNickname()+"\",";
				}else{
					json +="\"avatar\":\""+ip+BusinessHelpComment.getPortrait()+"\",\"name\":\""
							+BusinessHelpComment.getNickname()+"\",";
				}
				json +="\"commentTime\":\""+DateUtil.getInterval(BusinessHelpComment.getCommentTime())+"\",";
					json += "\"replyName\":\""+BusinessHelpComment.getReplyName()+"\",";
					json += "\"replyId\":\""+BusinessHelpComment.getReplyId()+"\",";
					json += "\"content\":\""+BusinessHelpComment.getContent()+"\",";
					if(BusinessHelpComment.getCommentorState()==1){
						json +="\"userType\":\"1\",";
					}else{
						json +="\"userType\":\"0\",";
					}
					if(BusinessHelpComment.getReplyState()==1){
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
	 * 用户评论邻里求助
	 * @param userId,sessionid,ID,content
	 * @return
	 * json
	 */
	@RequestMapping(value="saveSeekHelpReview")
	public void saveSeekHelpReview(HttpServletRequest request, HttpServletResponse response,BusinessHelpCommentQuery query) {
		String json = "";
		try{
			if(query.getUserId()==null){
				json = "";
				json += "{";
				json += "\"errorCode\":\"400\",";
				json += "\"message\":\"评论失败\"";
				json += "}";
			}else {
				BusinessHelpComment businessHelpComment = new BusinessHelpComment();
				Timestamp  ts=new Timestamp(new Date().getTime());
				businessHelpComment.setCommentTime(ts);
				businessHelpComment.setHelp(query.getID());
				businessHelpComment.setCommentorId(query.getUserId());
				businessHelpComment.setContent(SensitivewordFilter.replaceSensitiveWord(query.getContent(),1,"*"));
				businessHelpComment.setReplyId(query.getReplyId());
				businessHelpComment.setReplyName(query.getReplyName());
				businessHelpComment.setCommentorState(0);//居民
				businessHelpComment.setReplyState(0);
				if(null==query.getReplyId()){
					businessHelpComment.setReplyId(0);
				}
				if(null==query.getReplyName()){
					businessHelpComment.setReplyName("");
				}
				businessHelpCommentService.save(businessHelpComment);
				BusinessHelp businessHelp = businessHelpService.findById_app(query.getID());
				AppUser appUser = appUserService.findById(businessHelp.getHelperId());
				if(businessHelp.getState()==0){
					BusinessHelp businessHelp1 = new BusinessHelp();
					businessHelp1.setHelpId(query.getID());
					businessHelp1.setState(1);
					businessHelp1.setEditTime(ts);
					businessHelpService.update(businessHelp1);
				}
				AppLatestNews appLatestNews = new AppLatestNews();
				appLatestNews.setSourceId(query.getID());
				appLatestNews.setTo(0);
				appLatestNews.setEstateId(0);
				appLatestNews.setUserId(businessHelp.getHelperId());
				appLatestNews.setTypeId(27);//我的求助
				appLatestNewsService.save_app(appLatestNews);
				appLatestNews.setTypeId(28);//我的求助列表
				appLatestNewsService.save_app(appLatestNews);
				json += "{";
				json += "\"errorCode\":\"200\",";
				json += "\"message\":\"评论成功\",";
				json += "\"content\":{";
				json += "\"comments\":\""+businessHelp.getComments()+"\"";
				json += "}";
				json += "}";
			}
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
			appStatisticsClick.setType(19);
			appStatisticsClick.setTypeName("评论邻里求助");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户回复邻里求助
	 * @param userId,sessionid,ID,replyId,replyName,content
	 * @return
	 * json
	 */
	@RequestMapping(value="saveSeekHelpReply")
	public void saveSeekHelpReply(HttpServletRequest request, HttpServletResponse response,BusinessHelpCommentQuery query) {
		String json = "";
		try{
			if(query.getUserId()==null){
				json = "";
				json += "{";
				json += "\"errorCode\":\"400\",";
				json += "\"message\":\"评论失败!用户不存在！！\"";
				json += "}";
			}else {
				BusinessHelpComment businessHelpComment = new BusinessHelpComment();
				Timestamp  ts=new Timestamp(new Date().getTime());
				businessHelpComment.setCommentTime(ts);
				businessHelpComment.setHelp(query.getID());
				businessHelpComment.setCommentorId(query.getUserId());
				businessHelpComment.setContent(SensitivewordFilter.replaceSensitiveWord(query.getContent(),1,"*"));
				businessHelpComment.setReplyId(query.getReplyId());
				businessHelpComment.setReplyName(query.getReplyName());
				businessHelpComment.setCommentorState(0);//居民
				if(query.getReplyType()==null){
					businessHelpComment.setReplyState(0);
				}else{
					businessHelpComment.setReplyState(query.getReplyType());
				}
				if(null==query.getReplyId()){
					businessHelpComment.setReplyId(0);
				}
				if(null==query.getReplyName()){
					businessHelpComment.setReplyName("");
				}
				businessHelpCommentService.save(businessHelpComment);
				BusinessHelp businessHelp = businessHelpService.findById(query.getID());
				AppUser appUser = appUserService.findById(businessHelp.getHelperId());
				AppUserNews appUserNews = new AppUserNews();
				appUserNews.setUserId(query.getReplyId());
				appUserNews.setCreateTime(ts);
				appUserNews.setNewTitle(businessHelp.getHelpContent());
				appUserNews.setType(7);
				appUserNews.setId(query.getID());
				appUserNews.setContent("");
				appUserNews.setLastMessage(SensitivewordFilter.replaceSensitiveWord(query.getContent(),1,"*"));
				appUserNews.setLastMessageName(query.getUserId()+"");
				appUserNewsService.saveReply(appUserNews);
				AppLatestNews appLatestNews = new AppLatestNews();
				appLatestNews.setUserId(query.getReplyId());
				appLatestNews.setTypeId(7);//我的消息
				appLatestNews.setSourceId(query.getID());
				appLatestNews.setTo(0);
				appLatestNews.setEstateId(0);
				appLatestNewsService.save_app(appLatestNews);
				appLatestNews.setTypeId(8);//我的消息列表
				appLatestNewsService.save_app(appLatestNews);
				appLatestNews.setTypeId(9);//我的消息回复我的
				appLatestNewsService.save_app(appLatestNews);
				appLatestNews.setUserId(businessHelp.getHelperId());
				appLatestNews.setTypeId(27);//我的求助
				appLatestNewsService.save_app(appLatestNews);
				appLatestNews.setTypeId(28);//我的求助列表
				appLatestNewsService.save_app(appLatestNews);
				json += "{";
				json += "\"errorCode\":\"200\",";
				json += "\"message\":\"评论成功\",";
				json += "\"content\":{";
				json += "\"comments\":\""+businessHelp.getComments()+"\"";
				json += "}";
				json += "}";
			}
			
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
			appStatisticsClick.setType(20);
			appStatisticsClick.setTypeName("回复邻里求助");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户点赞邻里求助
	 * @param userId,sessionid,ID
	 * @return
	 * json
	 */
	@RequestMapping(value="supportSeekHelp")
	public void supportSeekHelp(HttpServletRequest request, HttpServletResponse response,BusinessHelpCommentQuery query) {
		String json = "";
		try{
			BusinessHelpSupportQuery businessHelpSupportQuery = new BusinessHelpSupportQuery();
			businessHelpSupportQuery.setUserId(query.getUserId());
			businessHelpSupportQuery.setHelpId(query.getID());
			int count =businessHelpSupportService.selectCount(businessHelpSupportQuery);
			if(count==0){
				BusinessHelpSupport businessHelpSupport = new BusinessHelpSupport();
				businessHelpSupport.setUserId(query.getUserId());
				businessHelpSupport.setHelpId(query.getID());
				Timestamp  ts=new Timestamp(new Date().getTime());
				businessHelpSupport.setCreateTime(ts);
				businessHelpSupportService.save(businessHelpSupport);
				BusinessHelp businessHelp = businessHelpService.findById_app(query.getID());
				json += "{";
				json += "\"errorCode\":\"200\",";
				json += "\"message\":\"点赞成功\",";
				json += "\"content\":{";
				json += "\"supports\":\""+businessHelp.getSupports()+"\"";
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
			appStatisticsClick.setType(18);
			appStatisticsClick.setTypeName("点赞邻里求助");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户查看求助类回复我的详情
	 * @param userId,brokeId,sessionid
	 * @return
	 * json
	 */
	@RequestMapping(value="getInformationSeekHelpById")
	public void getInformationSeekHelpById(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("userId:"+request.getParameter("userId"));
		System.out.println("brokeId:"+request.getParameter("brokeId"));
		System.out.println("sessionid:"+request.getParameter("sessionid"));
		String json = "";
		json += "{";
		json += "\"errorCode\":\"200\",";
		json += "\"message\":\"获取成功\",";
		json += "\"content\":{";
		json += "\"ID\":\"1\",";
		json += "\"time\":\"2001-1-1 11:11:11\",";
		json += "\"supports\":\"1222\",";
		json += "\"comments\":\"122\",";
		json += "\"publisherName\":\"发布人\",";
		json += "\"publisherId\":\"12\",";
		json += "\"avatar\":\"头像\",";
		json += "\"content\":\"详细内容\",";
		json += "\"pics\":[";
		json += "{\"pic\":\"图片1\"},";
		json += "{\"pic\":\"图片2\"}";
		json += "]";
		json += "\"speechSounds\":[";
		json += "{\"speechSound\":\"语音1\"},";
		json += "{\"speechSound\":\"语音2\"}";
		json += "]";
		json += "\"detail\":[";
		json += "{\"userId\":\"1\",\"avatar\":\"头像\",\"name\":\"张三\",\"commentTime\":\"2011-11-11 19:11:11\",\"replyName \":\"招六\",\"replyId \":\"12\",\"content \":\"你好\"},";
		json += "{\"userId\":\"1\",\"avatar\":\"头像\",\"name\":\"张三\",\"commentTime\":\"2011-11-11 19:11:11\",\"replyName \":\"招六\",\"replyId \":\"12\",\"content \":\"你好\"}";
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
	 * 用户发布邻里求助
	 * @param userId,sessionid,content,type
	 * @return
	 * json
	 */
	@RequestMapping(value="publishSeekHelpRepair")
	public void publishSeekHelpRepair (HttpServletRequest request, HttpServletResponse response,BusinessHelpQuery query) {
		String json = "";
		try{
			Map map = (Map) request.getAttribute("resultMap");
			Map<String,String> param=(Map) map.get("param");
			Map<String,String> image=(Map) map.get("image");
			Map<String,String> audio=(Map) map.get("audio");
			query.setParam(param);
			query.setImage(image);
			query.setAudio(audio);
			businessHelpService.publishSeekHelpRepair(query);
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
			if(null==query.getUserId()){
				appStatisticsClick.setUserId(0);
			}else{
				appStatisticsClick.setUserId(query.getUserId());
			}
			appStatisticsClick.setType(21);
			appStatisticsClick.setTypeName("发布邻里求助");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
