package com.community.service.property;



/**
 * 物业相关处理接口
 * 包括：
 * 
 * @author zyp-2_000
 *
 */

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
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
import com.community.app.module.bean.BusinessFeedback;
import com.community.app.module.bean.BusinessFeedbackComment;
import com.community.app.module.bean.BusinessProperty;
import com.community.app.module.bean.BusinessPropertyMaterial;
import com.community.app.module.bean.BusinessRepair;
import com.community.app.module.bean.BusinessRepairComment;
import com.community.app.module.bean.BusinessRepairType;
import com.community.app.module.bean.BusinessUser;
import com.community.app.module.service.AppLatestNewsService;
import com.community.app.module.service.AppStatisticsClickService;
import com.community.app.module.service.AppUserNewsService;
import com.community.app.module.service.AppUserService;
import com.community.app.module.service.BusinessAnnoCommentService;
import com.community.app.module.service.BusinessAnnoService;
import com.community.app.module.service.BusinessAnnoSupportService;
import com.community.app.module.service.BusinessFeedbackCommentService;
import com.community.app.module.service.BusinessFeedbackService;
import com.community.app.module.service.BusinessPropertyMaterialService;
import com.community.app.module.service.BusinessPropertyService;
import com.community.app.module.service.BusinessRepairCommentService;
import com.community.app.module.service.BusinessRepairService;
import com.community.app.module.service.BusinessRepairTypeService;
import com.community.app.module.service.BusinessUserService;
import com.community.app.module.vo.AppLatestNewsQuery;
import com.community.app.module.vo.AppUserQuery;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessAnnoCommentQuery;
import com.community.app.module.vo.BusinessAnnoQuery;
import com.community.app.module.vo.BusinessAnnoSupportQuery;
import com.community.app.module.vo.BusinessFeedbackCommentQuery;
import com.community.app.module.vo.BusinessFeedbackQuery;
import com.community.app.module.vo.BusinessPropertyMaterialQuery;
import com.community.app.module.vo.BusinessRepairCommentQuery;
import com.community.app.module.vo.BusinessRepairQuery;
import com.community.framework.utils.DateUtil;
import com.community.framework.utils.JsonUtils;
import com.community.framework.utils.propertiesUtil;
import com.community.framework.utils.testfilter.src.com.gao.SensitivewordFilter;


@Controller
@RequestMapping("/service/property")
public class propertyController {
	private static Logger GSLogger = LoggerFactory.getLogger(propertyController.class);
	@Autowired
	private BusinessAnnoService businessAnnoService;
	@Autowired
	private BusinessFeedbackService businessFeedbackService;
	@Autowired
	private BusinessFeedbackCommentService businessFeedbackCommentService;
	@Autowired
	private BusinessAnnoCommentService businessAnnoCommentService;
	@Autowired
	private BusinessAnnoSupportService businessAnnoSupportService;
	@Autowired
	private BusinessRepairService businessRepairService;
	@Autowired
	private BusinessRepairCommentService businessRepairCommentService;
	@Autowired
	private BusinessPropertyMaterialService businessPropertyMaterialService;
	@Autowired
	private BusinessRepairTypeService businessRepairTypeService;
	@Autowired
	private BusinessUserService businessUserService;
	@Autowired
	private BusinessPropertyService businessPropertyService;
	@Autowired
	private AppLatestNewsService appLatestNewsService;
	@Autowired
	private AppUserNewsService appUserNewsService;
	@Autowired
	private AppUserService appUserService;
	@Autowired
	private AppStatisticsClickService appStatisticsClickService;
	
	
	
	
	
	/**
	 * 用户获取物业服务建议列表
	 * @param userId,sessionid,type,page,rows
	 * @return
	 * json
	 */
	@RequestMapping(value="findPropertyAdviceListByUser")
	public void findPropertyAdviceListByUser (HttpServletRequest request, HttpServletResponse response) {
		//System.out.println("userId:"+request.getParameter("userId"));
		//System.out.println("sessionid:"+request.getParameter("sessionid"));
		String json = "";
		json += "{";
		json += "\"errorCode\":\"200\",";
		json += "\"message\":\"执行成功\",";
		json += "\"content\":{";
		json += "\"PageState\":true,";
		json += "\"adiceList\":[";
		json += "{\"userId\":\"1\",\"userName\":\"张三\",\"content\":\"建议内容\",\"time\":\"2014-03-23 12:32\",\"replierName\":\"名称\":1,\"lastReply\":\"最新回复\"},";
		json += "{\"userId\":\"2\",\"userName\":\"张三\",\"content\":\"建议内容\",\"time\":\"2014-03-23 12:32\",\"replierName\":\"名称\":1,\"lastReply\":\"最新回复\"}";
		json += "]";
		json += "}";
		json += "}";
		
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(JsonUtils.stringToJson(json));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户查看物业服务建议详情
	 * @param userId,sessionid,ID
	 * @return
	 * json
	 */
	@RequestMapping(value="findPropertyAdvice")
	public void findPropertyAdvice (HttpServletRequest request, HttpServletResponse response,BusinessFeedbackCommentQuery query) {
		String json = "";
		try{
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp");   
			query.setRows(15);
			query.setFeedbackId(query.getID());
			query.setOrder("desc");
			query.setSort("commentTime");
			BusinessFeedback businessFeedback = businessFeedbackService.findById_app(query.getID());
			BaseBean baseBean = businessFeedbackCommentService.findAllPage_app(query);
			AppLatestNews appLatestNews = new AppLatestNews();
			appLatestNews.setUserId(query.getUserId());
			appLatestNews.setTypeId(20);
			appLatestNews.setTo(0);
			appLatestNews.setSourceId(query.getID());
			appLatestNewsService.delete_app_id(appLatestNews);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"获取成功\",";
			json += "\"content\":{";
			if(query.getPage()==1){
				json += "\"ID\":\""+businessFeedback.getFeedbackId()+"\",";
				json += "\"time\":\""+DateUtil.getInterval(businessFeedback.getCreateTime())+"\",";
				json += "\"content\":\""+businessFeedback.getFbContent()+"\",";
				json += "\"pics\":[";
				if(businessFeedback.getPics()!=null){
					String[] pic = businessFeedback.getPics().split(",");
					for (int i = 0; i < pic.length; i++) {
						json += "{\"pic\":\""+ip+pic[i]+"\"},";
					}
					if(pic.length > 0) {
						json = json.substring(0, json.length()-1);
					}
				}
				json += "],";
				json += "\"speechSounds\":[";
				if(businessFeedback.getAudios()!=null && businessFeedback.getTime()!=null){
					String[] audios = businessFeedback.getAudios().split(",");
					String[] time = businessFeedback.getTime().split(",");
					for (int i = 0; i < audios.length; i++) {
						json += "{\"speechSound\":\""+ip+audios[i]+"\",\"time\":\""+time[i]+"\"},";
					}
					if(audios.length> 0) {
						json = json.substring(0, json.length()-1);
					}
				}
				json += "],";
			}
			json += "\"PageState\":";
			if(baseBean.getCount()>query.getPage()*query.getRows()){
				json += "true,";
			}else{
				json += "false,";
			}
			json += "\"detail\":[";
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessFeedbackComment businessFeedbackComment = (BusinessFeedbackComment) baseBean.getList().get(i);
				if(businessFeedbackComment.getTo()==1){
					if(businessFeedbackComment.getContentType()==1){
						json += "{\"type\":\"1\",\"userId\":\""+businessFeedbackComment.getCommentorId()+"\",\"avatar\":\""+ip+businessFeedbackComment.getB_portrait()+"\",\"name\":\""
								+businessFeedbackComment.getB_nickname()+"\",\"commentTime\":\""+DateUtil.getInterval(businessFeedbackComment.getCommentTime())+"\",\"content\":\""+businessFeedbackComment.getComment()+"\",";
						json += "\"role\":\"1\"},";
					}else if(businessFeedbackComment.getContentType()==2){
						json += "{\"type\":\"2\",\"userId\":\""+businessFeedbackComment.getCommentorId()+"\",\"name\":\""
								+businessFeedbackComment.getB_nickname()+"\",\"commentTime\":\""+DateUtil.getInterval(businessFeedbackComment.getCommentTime())+"\",\"speechSound\":\""+ip+
								businessFeedbackComment.getComment()+"\",\"time\":\""+businessFeedbackComment.getVideoTime()+"\",";
						json += "\"role\":\"1\"},";
					}else{
						json += "{\"type\":\"3\",\"userId\":\""+businessFeedbackComment.getCommentorId()+"\",\"avatar\":\""+ip+businessFeedbackComment.getB_portrait()+"\",\"name\":\""
								+businessFeedbackComment.getB_nickname()+"\",\"commentTime\":\""+DateUtil.getInterval(businessFeedbackComment.getCommentTime())+"\",\"content\":\""+businessFeedbackComment.getComment()+"\",";
						json += "\"role\":\"1\"},";
					}
				}else{ 
					if(businessFeedbackComment.getContentType()==1){
						json += "{\"type\":\"1\",\"userId\":\""+businessFeedbackComment.getCommentorId()+"\",\"avatar\":\""+ip+businessFeedbackComment.getPortrait()+"\",\"name\":\""
								+businessFeedbackComment.getCommentorName()+"\",\"commentTime\":\""+DateUtil.getInterval(businessFeedbackComment.getCommentTime())+"\",\"content\":\""+businessFeedbackComment.getComment()+"\",";
						json += "\"role\":\"0\"},";
					}else if (businessFeedbackComment.getContentType()==2){
						json += "{\"type\":\"2\",\"userId\":\""+businessFeedbackComment.getCommentorId()+"\",\"name\":\""
								+businessFeedbackComment.getCommentorName()+"\",\"commentTime\":\""+DateUtil.getInterval(businessFeedbackComment.getCommentTime())+"\",\"speechSound\":\""+ip+
								businessFeedbackComment.getComment()+"\",\"time\":\""+businessFeedbackComment.getVideoTime()+"\",";
						json += "\"role\":\"0\"},";
					}else{
						json += "{\"type\":\"4\",\"userId\":\""+businessFeedbackComment.getCommentorId()+"\",\"avatar\":\""+ip+businessFeedbackComment.getPortrait()+"\",\"name\":\""
								+businessFeedbackComment.getCommentorName()+"\",\"commentTime\":\""+DateUtil.getInterval(businessFeedbackComment.getCommentTime())+"\",\"content\":\""+businessFeedbackComment.getComment()+"\",";
						json += "\"role\":\"0\",\"evaluationGrade\":\""+businessFeedbackComment.getComment()+"\",\"ifTheSolution\":\""+(businessFeedbackComment.getContentType()-1)+"\"},";
					}
				}
				
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
			response.getWriter().write(JsonUtils.stringToJson(json));
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
			appStatisticsClick.setType(65);
			appStatisticsClick.setTypeName("我的投诉建议详情");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户发布快递服务投诉
	 * @param userId,sessionid,content
	 * @return
	 * json
	 */
	@RequestMapping(value="publishExpressComplaint")
	public void publishExpressComplaint (HttpServletRequest request, HttpServletResponse response) {
		//System.out.println("userId:"+request.getParameter("userId"));
		//System.out.println("sessionid:"+request.getParameter("sessionid"));
		//System.out.println("content:"+request.getParameter("content"));
		String json = "";
		json += "{";
		json += "\"errorCode\":\"200\",";
		json += "\"message\":\"发布成功\"";
		json += "}";
		
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(JsonUtils.stringToJson(json));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 用户回复物业服务建议
	 * @param userId,sessionid,content,type
	 * @return
	 * json
	 */
	@RequestMapping(value="replyPropertyAdvice")
	public void replyPropertyAdvice (HttpServletRequest request, HttpServletResponse response,BusinessFeedbackQuery query) {
		String json = "";
		Map map = (Map) request.getAttribute("resultMap");
		Map<String,String> paramMap=(Map) map.get("param");
		Map<String,String> audioMap=(Map) map.get("audio");
		try{
			int audiocount = 0;
			BusinessFeedbackComment businessFeedbackComment = new BusinessFeedbackComment();
			Timestamp  ts=new Timestamp(new Date().getTime());
			businessFeedbackComment.setFeedbackId(new Integer(paramMap.get("ID")));
			businessFeedbackComment.setCommentTime(ts);
			businessFeedbackComment.setTo(0);
			businessFeedbackComment.setCommentorId(new Integer(paramMap.get("userId")));
			businessFeedbackComment.setComment(paramMap.get("content"));
			if("".equals(paramMap.get("content")) || null == paramMap.get("content")  ){
				businessFeedbackComment.setContentType(2);
				Collection<String> coll = audioMap.keySet();
				Iterator iter = coll.iterator();
		        for (; iter.hasNext();) {
		        	audiocount++;
		        	iter.next();
		        	String value = (String)audioMap.get(audiocount+"");
					String str = value.substring(value.lastIndexOf("_")+1, value.lastIndexOf("."));
					businessFeedbackComment.setComment(value);
					businessFeedbackComment.setVideoTime(new Integer(str));
		        }
			}else{
				businessFeedbackComment.setContentType(1);
			}
			businessFeedbackCommentService.save(businessFeedbackComment);
			AppLatestNews appLatestNews = new AppLatestNews();
			appLatestNews.setUserId(new Integer(paramMap.get("userId")));
			appLatestNews.setTypeId(36);
			appLatestNews.setSourceId(new Integer(paramMap.get("ID")));
			appLatestNews.setTo(1);
			appLatestNews.setEstateId(0);
			appLatestNewsService.save_app(appLatestNews);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"回复成功\",";
			json += "\"content\":{";
			if(businessFeedbackComment.getContentType()==1){
				json += "\"type\":\"1\",";
				json += "\"commentTime\":\""+DateUtil.getInterval(ts)+"\",";
				json += "\"content\":\""+businessFeedbackComment.getComment()+"\",";
				json += "\"role\":\"0\"";
			}else{
				json += "\"type\":\"2\",";
				json += "\"commentTime\":\""+DateUtil.getInterval(ts)+"\",";
				json += "\"speechSound\":\""+businessFeedbackComment.getComment()+"\",";
				json += "\"role\":\"0\",";
				json += "\"time\":\""+businessFeedbackComment.getVideoTime()+"\"";
			}
			json += "}";
			json += "}";
			
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"回复失败\"";
			json += "}";
			e.printStackTrace();
		}
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(JsonUtils.stringToJson(json));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			AppStatisticsClick appStatisticsClick = new AppStatisticsClick();
			appStatisticsClick.setCreateTime(ts);
			appStatisticsClick.setEditTime(ts);
			appStatisticsClick.setUserId(new Integer(paramMap.get("userId")));
			appStatisticsClick.setType(66);
			appStatisticsClick.setTypeName("回复投诉建议");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 用户发布物业服务建议
	 * @param userId,sessionid,content
	 * @return
	 * json
	 */
	@RequestMapping(value="publishPropertySuggestions")
	public void publishPropertySuggestions (HttpServletRequest request, HttpServletResponse response) {
		//System.out.println("userId:"+request.getParameter("userId"));
		//System.out.println("sessionid:"+request.getParameter("sessionid"));
		//System.out.println("content:"+request.getParameter("content"));
		String json = "";
		json += "{";
		json += "\"errorCode\":\"200\",";
		json += "\"message\":\"发布成功\"";
		json += "}";
		
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(JsonUtils.stringToJson(json));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户查看物业服务投诉接口
	 * @param userId,sessionid,type,page,rows
	 * @return
	 * json
	 */
	@RequestMapping(value="findPropertyComplaintListByUser")
	public void findByUser(HttpServletRequest request, HttpServletResponse response,BusinessFeedbackQuery query) {
		String json = "";
		try{
			query.setRows(15);
			query.setFberId(query.getUserId());
			Timestamp  ts=new Timestamp(new Date().getTime());
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
			appLatestNews.setTypeId(15);
			appLatestNews.setTo(0);
			appLatestNewsService.delete_app(appLatestNews);
			if(query.getType()==3){
				appLatestNews.setTypeId(18);
			}else {
				appLatestNews.setTypeId(19);
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
			if("4".equals(request.getParameter("type"))){
				json += "\"list\":[";
				for(int i=0;i<baseBean.getList().size();i++) {
					BusinessFeedback businessFeedback = (BusinessFeedback) baseBean.getList().get(i);
					json += "{";
					json += "\"ID\":\""+businessFeedback.getFeedbackId()+"\",";
					json += "\"time\":\""+DateUtil.getInterval(businessFeedback.getFbTime())+"\",";
					json += "\"content\":\""+businessFeedback.getFbContent()+"\",";
					json += "\"brief\":\""+businessFeedback.getFbContent()+"\",";
					json += "\"state\":\""+businessFeedback.getFbState()+"\",";
					json += "\"level\":\""+businessFeedback.getFbScore()+"\"";
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
			}else{
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
			response.getWriter().write(JsonUtils.stringToJson(json));
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
			appStatisticsClick.setType(73);
			appStatisticsClick.setTypeName("物业投诉列表");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户查看物业服务投诉详情
	 * @param userId,sessionid,ID
	 * @return
	 * json
	 */
	@RequestMapping(value="findPropertyComplaint")
	public void findPropertyComplaint (HttpServletRequest request, HttpServletResponse response) {
		//System.out.println("userId:"+request.getParameter("userId"));
		//System.out.println("sessionid:"+request.getParameter("sessionid"));
		//System.out.println("advinceId:"+request.getParameter("advinceId"));
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
			response.getWriter().write(JsonUtils.stringToJson(json));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户发布物业服务投诉
	 * @param userId,sessionid,content
	 * @return
	 * json
	 */
	@RequestMapping(value="publishPropertyComplaint")
	public void publishPropertyComplaint (HttpServletRequest request, HttpServletResponse response,BusinessFeedbackQuery query) {
		String json = "";
		Map map = (Map) request.getAttribute("resultMap");
		Map<String,String> param=(Map) map.get("param");
		Map<String,String> image=(Map) map.get("image");
		Map<String,String> audio=(Map) map.get("audio");
		try{
			query.setParam(param);
			query.setImage(image);
			query.setAudio(audio);
			businessFeedbackService.publishPropertyComplaint(query);
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
			response.getWriter().write(JsonUtils.stringToJson(json));
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
			if("0".equals(param.get("fbType"))){
				appStatisticsClick.setType(77);
				appStatisticsClick.setTypeName("发布物业投诉");
			}else if ("1".equals(param.get("fbType"))) {
				appStatisticsClick.setType(76);
				appStatisticsClick.setTypeName("发布物业建议");
			}else if("2".equals(param.get("fbType"))){
				appStatisticsClick.setType(69);
				appStatisticsClick.setTypeName("发布使用反馈");
			}else if("3".equals(param.get("fbType"))){
				appStatisticsClick.setType(74);
				appStatisticsClick.setTypeName("发布驿站建议");
			}else{
				appStatisticsClick.setType(75);
				appStatisticsClick.setTypeName("发布快递投诉");
			}
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户回复物业服务投诉
	 * @param userId,sessionid,content,type
	 * @return
	 * json
	 */
	@RequestMapping(value="replyPropertyComplaint")
	public void replyPropertyComplaint (HttpServletRequest request, HttpServletResponse response) {
		//System.out.println("userId:"+request.getParameter("userId"));
		//System.out.println("sessionid:"+request.getParameter("sessionid"));
		//System.out.println("content:"+request.getParameter("content"));
		String json = "";
		json += "{";
		json += "\"errorCode\":\"200\",";
		json += "\"message\":\"回复成功\"";
		json += "}";
		
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(JsonUtils.stringToJson(json));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户评价物业服务投诉接口
	 * @param userId,sessionid,content,ID,evaluationGrade,ifTheSolution
	 * @return
	 * json
	 */
	@RequestMapping(value="publishPropertyEvaluation")
	public void publishPropertyEvaluation (HttpServletRequest request, HttpServletResponse response) {
		//System.out.println("userId:"+request.getParameter("userId"));
		//System.out.println("sessionid:"+request.getParameter("sessionid"));
		//System.out.println("content:"+request.getParameter("content"));
		String json = "";
		json += "{";
		json += "\"errorCode\":\"200\",";
		json += "\"message\":\"评价成功\"";
		json += "}";
		
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(JsonUtils.stringToJson(json));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户查看物业通知
	 * @param userId,sessionid,page,rows
	 * @return
	 * json
	 */
	@RequestMapping(value="findByProperty")
	public void findByProperty (HttpServletRequest request, HttpServletResponse response,BusinessAnnoQuery query) {
		String json = "";
		try{
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp");   
			query.setRows(15);
			query.setOrder("desc");
			query.setSort("publishTime");
			query.setAnnoScope(query.getEstateId()+"");
			query.setAnnoType(1);
			query.setPublishState(0);
			query.setIsImportant(1);
			BaseBean topBaseBean = businessAnnoService.findAllPage_app(query);
			query.setIsImportant(0);
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
			for(int i=0;i<topBaseBean.getList().size();i++) {
				BusinessAnno businessAnno = (BusinessAnno) topBaseBean.getList().get(i);
				json += "{\"ID\":\""+businessAnno.getAnnoId()+"\",\"title\":\""+businessAnno.getAnnoTitle()+"\",\"time\":\""
				+DateUtil.getInterval(businessAnno.getPublishTime())+"\",\"brief\":\""+businessAnno.getBrief()+"\",";
				if("".equals(businessAnno.getAnnoPic()) || businessAnno.getAnnoPic()==null  || businessAnno.getAnnoPic().indexOf("/images/icon/")>=0){
					json +="\"pic\":\"\",";
				}else{
					json +="\"pic\":\""+ip+businessAnno.getAnnoPic()+"\",";
				}
				json += "\"publisherId\":\""+businessAnno.getPublisherId()+"\",\"publisherName\":\""+businessAnno.getNickname()+"\",\"avatar\":\""+ip+businessAnno.getPortrait()+"\"},";
			}
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
			response.getWriter().write(JsonUtils.stringToJson(json));
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
			appStatisticsClick.setType(37);
			appStatisticsClick.setTypeName("物业通知列表");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户查看物业通知详情
	 * @param userId,sessionid,ID
	 * @return
	 * json
	 */
	@RequestMapping(value="getPopertyDetailsById")
	public ModelAndView getPopertyDetailsById (HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/service/property");
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
			appStatisticsClick.setType(38);
			appStatisticsClick.setTypeName("物业通知详情");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
		return mav;	
	}
	
	/**
	 * 用户查看物业通知带评论详情
	 * @param userId,sessionid,ID
	 * @return
	 * json
	 */
	@RequestMapping(value="getPopertyDetailsByIdComment")
	public ModelAndView getPopertyDetailsByIdComment (HttpServletRequest request, HttpServletResponse response) {
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
			appStatisticsClick.setType(38);
			appStatisticsClick.setTypeName("物业通知详情");
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
	@RequestMapping(value="getPopertyDetailsById_title")
	public void getPopertyDetailsById_title(HttpServletRequest request, HttpServletResponse response) {
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
			response.getWriter().write(JsonUtils.stringToJson(json));
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
	@RequestMapping(value="getInformationById")
	public ModelAndView getInformationById (HttpServletRequest request, HttpServletResponse response) {
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
			appStatisticsClick.setType(38);
			appStatisticsClick.setTypeName("物业通知详情");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
		return mav;	
	}
	
	/**
	 * 用户查看物业通知评论
	 * @param userId,sessionid,ID,page,rows
	 * @return
	 * json
	 */
	@RequestMapping(value="getPopertyReviewById")
	public void getPopertyReviewById(HttpServletRequest request, HttpServletResponse response,BusinessAnnoCommentQuery query) {
		String json = "";
		try{
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp"); 
			String phpIp = p.getProperty("phpIp");  
			query.setRows(15);
			query.setOrder("desc");
			query.setSort("commentTime");
			query.setAnnoId(query.getID());
			BaseBean baseBean = businessAnnoCommentService.findAllPage_app(query);
			BusinessAnno BusinessAnno = businessAnnoService.findById(query.getID());
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"获取成功\",";
			json += "\"content\":{";
			json += "\"appPic\":\""+ip+BusinessAnno.getAppPic()+"\",";
			json += "\"title\":\""+BusinessAnno.getAnnoTitle()+"\",";
			json += "\"url\":\""+phpIp+"/wxokjia/wuye_info.php?ID="+query.getID()+"\",";
			
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
			response.getWriter().write(JsonUtils.stringToJson(json));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户查看物业通知回复我的评论
	 * @param userId,sessionid,ID,page,rows
	 * @return
	 * json
	 */
	@RequestMapping(value="getPopertyReviewByUserId")
	public void getPopertyReviewByUserId(HttpServletRequest request, HttpServletResponse response,BusinessAnnoCommentQuery query) {
		String json = "";
		try{
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp");   
			String phpIp = p.getProperty("phpIp");  
			query.setRows(15);
			query.setOrder("desc");
			query.setSort("commentTime");
			query.setAnnoId(query.getID());
			query.setCommentorState(0);
			query.setReplyState(0);
			query.setRepliedState(0);
			BaseBean baseBean = businessAnnoCommentService.findAllPage_app(query);
			BusinessAnno BusinessAnno = businessAnnoService.findById(query.getID());
			
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
			json += "\"appPic\":\""+ip+BusinessAnno.getAppPic()+"\",";
			json += "\"title\":\""+BusinessAnno.getAnnoTitle()+"\",";
			json += "\"url\":\""+phpIp+"/wxokjia/wuye_info.php?ID="+query.getID()+"\",";
			
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
			response.getWriter().write(JsonUtils.stringToJson(json));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户评论物业通知
	 * @param userId,sessionid,ID,content
	 * @return
	 * json
	 */
	@RequestMapping(value="savePopertyReview")
	public void savePopertyReview(HttpServletRequest request, HttpServletResponse response,BusinessAnnoCommentQuery query) {
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
			BusinessAnno BusinessAnno = businessAnnoService.findById(query.getID());
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
			response.getWriter().write(JsonUtils.stringToJson(json));
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
			appStatisticsClick.setType(40);
			appStatisticsClick.setTypeName("评论物业通知");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户回复物业通知
	 * @param userId,sessionid,ID,replyId,replyName,content
	 * @return
	 * json
	 */
	@RequestMapping(value="savePropertyReply")
	public void savePropertyReply(HttpServletRequest request, HttpServletResponse response,BusinessAnnoCommentQuery query) {
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
			BusinessAnno BusinessAnno = businessAnnoService.findById(query.getID());
			if(!(businessAnnoComment.getRepliedState()==1)){
				AppUserNews appUserNews = new AppUserNews();
				appUserNews.setUserId(query.getReplyId());
				appUserNews.setCreateTime(ts);
				appUserNews.setNewTitle(BusinessAnno.getAnnoTitle());
				appUserNews.setType(3);
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
			response.getWriter().write(JsonUtils.stringToJson(json));
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
			appStatisticsClick.setType(41);
			appStatisticsClick.setTypeName("回复物业通知");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户点赞物业通知
	 * @param userId,sessionid,ID
	 * @return
	 * json
	 */
	@RequestMapping(value="supportProperty")
	public void supportProperty(HttpServletRequest request, HttpServletResponse response,BusinessAnnoCommentQuery query) {
		String json = "";
		try{
			BusinessAnnoSupportQuery businessAnnoSupportQuery = new BusinessAnnoSupportQuery();
			businessAnnoSupportQuery.setUserId(query.getUserId());
			businessAnnoSupportQuery.setAnnoId(query.getID());
			int count = businessAnnoSupportService.selectCount(businessAnnoSupportQuery);
			if(count==0 || query.getUserId()==0){
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
			response.getWriter().write(JsonUtils.stringToJson(json));
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
			appStatisticsClick.setType(39);
			appStatisticsClick.setTypeName("点赞物业通知");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户获取楼管理员介绍
	 * @param userId,sessionid,propertyId,buildingId
	 * @return
	 * json
	 */
	@RequestMapping(value="getPropertyRepairIntroduction")
	public void getPropertyRepairIntroduction(HttpServletRequest request, HttpServletResponse response, AppUserQuery query) {
		String json = "";
		try{
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp");   
			List<BusinessUser> list = businessUserService.findByPropertyBuildingAll(query.getBuildingId());
			BusinessProperty businessProperty = businessPropertyService.findById(query.getPropertyId());
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"获取成功\",";
			json += "\"content\":{";
			json += "\"ID\":\""+list.get(0).getUserId()+"\",\"name\":\""+list.get(0).getNickname()+"\",\"avatar\":\""+ip+list.get(0).getAvatar()+"\",\"serviceTel\":\""+businessProperty.getProTel()+"\",\"tel\":\""+list.get(0).getUserTel()+"\",";
//			if(1==query.getType()){
//				json += "\"brief\":\"您好：我是您的物业管家，对于您提出的任何建议，我都会认真的处理，为您提供最优的服务！您也可以拨打我的电话\"";
//			}else if (1==query.getType()){
//				json += "\"brief\":\"您好：我是您的物业管家，对于您提出的任何建议，我都会认真的处理，为您提供最优的服务！您也可以拨打我的电话\"";
//			}else{
				json += "\"brief\":\"您好：我是您的物业管家，对于您提出的任何建议，我都会认真的处理，为您提供最优的服务！您也可以拨打我的电话:\"";
//			}
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
			response.getWriter().write(JsonUtils.stringToJson(json));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户发布物业报修
	 * @param userId,sessionid,content,type
	 * @return
	 * json
	 */
	@RequestMapping(value="publishPropertyRepair")
	public void publishPropertyRepair (HttpServletRequest request, HttpServletResponse response,BusinessRepairQuery query) {
		String json = "";
		Map map = (Map) request.getAttribute("resultMap");
		Map<String,String> param=(Map) map.get("param");
		Map<String,String> image=(Map) map.get("image");
		Map<String,String> audio=(Map) map.get("audio");
		try{
			query.setParam(param);
			query.setImage(image);
			query.setAudio(audio);
			businessRepairService.publishPropertyRepair(query);
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
			response.getWriter().write(JsonUtils.stringToJson(json));
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
			appStatisticsClick.setType(79);
			appStatisticsClick.setTypeName("发布物业报修");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户查看物业保修
	 * @param userId,sessionid,type,page,rows
	 * @return
	 * json
	 */
	@RequestMapping(value="findByUserRepair")
	public void findByUserRepair(HttpServletRequest request, HttpServletResponse response,BusinessRepairQuery query) {
		String json = "";
		try{
			query.setRows(15);
			query.setReporterId(query.getUserId());
			query.setOrder("desc");
			query.setSort("editTime");
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp"); 
			BaseBean baseBean = businessRepairService.findAllPage_app(query);
			BusinessProperty businessProperty = businessPropertyService.findById(query.getPropertyId());
			AppLatestNewsQuery appLatestNewsQuery = new AppLatestNewsQuery();
			appLatestNewsQuery.setUserId(query.getUserId());
			appLatestNewsQuery.setTo(0);
			appLatestNewsQuery.setTypeId(31);
			List<AppLatestNews> list = appLatestNewsService.findByExample(appLatestNewsQuery);
			AppLatestNews appLatestNews = new AppLatestNews();
			appLatestNews.setUserId(query.getUserId());
			appLatestNews.setTo(0);
			appLatestNews.setTypeId(32);
			appLatestNewsService.delete_app(appLatestNews);
			if(query.getType()==3){
				appLatestNews.setTypeId(29);
			}else {
				appLatestNews.setTypeId(30);
			}
			appLatestNewsService.delete_app(appLatestNews);
			
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"获取成功\",";
			json += "\"content\":{";
			json += "\"url\":\""+ip+businessProperty.getProUrl()+"\",";
			json += "\"PageState\":";
			if(baseBean.getCount()>query.getPage()*query.getRows()){
				json += "true,";
			}else{
				json += "false,";
			}
			if("4".equals(request.getParameter("type"))){
				json += "\"list\":[";
				for(int i=0;i<baseBean.getList().size();i++) {
					BusinessRepair businessRepair = (BusinessRepair) baseBean.getList().get(i);
					json += "{";
					json += "\"ID\":\""+businessRepair.getRepairId()+"\",";
					json += "\"time\":\""+DateUtil.getInterval(businessRepair.getRepairTime())+"\",";
					json += "\"type\":\""+businessRepair.getTypeId()+"\",";
					json += "\"typeName\":\""+businessRepair.getTypeName()+"\",";
					json += "\"state\":\""+businessRepair.getRepairState()+"\",";
					json += "\"level\":\""+businessRepair.getRepairScore()+"\"";
					boolean  flag = false ; //报修列表状态
					for (AppLatestNews appLatestNews2 : list) {
						if(appLatestNews2.getSourceId().equals(businessRepair.getRepairId())){
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
			}else{
				json += "\"list\":[";
				for(int i=0;i<baseBean.getList().size();i++) {
					BusinessRepair businessRepair = (BusinessRepair) baseBean.getList().get(i);
					json += "{";
					json += "\"ID\":\""+businessRepair.getRepairId()+"\",";
					json += "\"time\":\""+DateUtil.getInterval(businessRepair.getRepairTime())+"\",";
					json += "\"type\":\""+businessRepair.getTypeId()+"\",";
					json += "\"typeName\":\""+businessRepair.getTypeName()+"\"";
					boolean  flag = false ; //报修列表状态
					for (AppLatestNews appLatestNews2 : list) {
						if(appLatestNews2.getSourceId().equals(businessRepair.getRepairId())){
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
			response.getWriter().write(JsonUtils.stringToJson(json));
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
			appStatisticsClick.setType(78);
			appStatisticsClick.setTypeName("物业报修列表");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户查看物业报修详情
	 * @param userId,sessionid,ID
	 * @return
	 * json
	 */
	@RequestMapping(value="findByUserRepairDetails")
	public void findByUserRepairDetails (HttpServletRequest request, HttpServletResponse response,BusinessRepairCommentQuery query) {
		String json = "";
		try{
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp");   
			query.setRows(15);
			query.setRepairId(query.getID());
			query.setOrder("desc");
			query.setSort("commentTime");
			BusinessRepair businessRepair = businessRepairService.findById_app(query.getID());
			BaseBean baseBean = businessRepairCommentService.findAllPage_app(query);
			AppLatestNews appLatestNews = new AppLatestNews();
			appLatestNews.setUserId(query.getUserId());
			appLatestNews.setTypeId(31);
			appLatestNews.setTo(0);
			appLatestNews.setSourceId(query.getID());
			appLatestNewsService.delete_app_id(appLatestNews);
			
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"获取成功\",";
			json += "\"content\":{";
			if(query.getPage()==1){
				json += "\"ID\":\""+businessRepair.getRepairId()+"\",";
				json += "\"time\":\""+DateUtil.getInterval(businessRepair.getRepairTime())+"\",";
				json += "\"content\":\""+businessRepair.getRepairContent()+"\",";
				json += "\"pics\":[";
				if(businessRepair.getPics()!=null){
					String[] pic = businessRepair.getPics().split(",");
					for (int i = 0; i < pic.length; i++) {
						json += "{\"pic\":\""+ip+pic[i]+"\"},";
					}
					if(pic.length > 0) {
						json = json.substring(0, json.length()-1);
					}
				}
				json += "],";
				json += "\"speechSounds\":[";
				if(businessRepair.getAudios()!=null && businessRepair.getTime()!=null){
					String[] audios = businessRepair.getAudios().split(",");
					String[] time = businessRepair.getTime().split(",");
					for (int i = 0; i < audios.length; i++) {
						json += "{\"speechSound\":\""+ip+audios[i]+"\",\"time\":\""+time[i]+"\"},";
					}
					if(audios.length> 0) {
						json = json.substring(0, json.length()-1);
					}
				}
				json += "],";
			}
			json += "\"PageState\":";
			if(baseBean.getCount()>query.getPage()*query.getRows()){
				json += "true,";
			}else{
				json += "false,";
			}
			json += "\"detail\":[";
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessRepairComment businessRepairComment = (BusinessRepairComment) baseBean.getList().get(i);
				if(businessRepairComment.getTo()==1){
					if(businessRepairComment.getContentType()==1){
						json += "{\"type\":\"1\",\"userId\":\""+businessRepairComment.getCommentorId()+"\",\"avatar\":\""+ip+businessRepairComment.getPortrait()+"\",\"name\":\""
								+businessRepairComment.getCommentorName()+"\",\"commentTime\":\""+DateUtil.getInterval(businessRepairComment.getCommentTime())+"\",\"content\":\""+businessRepairComment.getComment()+"\",";
						json += "\"role\":\"1\"},";
					}else if(businessRepairComment.getContentType()==2){
						json += "{\"type\":\"2\",\"userId\":\""+businessRepairComment.getCommentorId()+"\",\"name\":\""
								+businessRepairComment.getCommentorName()+"\",\"commentTime\":\""+DateUtil.getInterval(businessRepairComment.getCommentTime())+"\",\"speechSound\":\""+ip+
								businessRepairComment.getComment()+"\",\"time\":\""+businessRepairComment.getVideoTime()+"\",";
						json += "\"role\":\"1\"},";
					}else{
						json += "{\"type\":\"3\",\"userId\":\""+businessRepairComment.getCommentorId()+"\",\"avatar\":\""+ip+businessRepairComment.getPortrait()+"\",\"name\":\""
								+businessRepairComment.getCommentorName()+"\",\"commentTime\":\""+DateUtil.getInterval(businessRepairComment.getCommentTime())+"\",\"content\":\""+businessRepairComment.getComment()+"\",";
						json += "\"role\":\"1\"},";
					}
				}else{ 
					if(businessRepairComment.getContentType()==1){
						json += "{\"type\":\"1\",\"userId\":\""+businessRepairComment.getCommentorId()+"\",\"avatar\":\""+ip+businessRepairComment.getPortrait()+"\",\"name\":\""
								+businessRepairComment.getCommentorName()+"\",\"commentTime\":\""+DateUtil.getInterval(businessRepairComment.getCommentTime())+"\",\"content\":\""+businessRepairComment.getComment()+"\",";
						json += "\"role\":\"0\"},";
					}else if (businessRepairComment.getContentType()==2){
						json += "{\"type\":\"2\",\"userId\":\""+businessRepairComment.getCommentorId()+"\",\"name\":\""
								+businessRepairComment.getCommentorName()+"\",\"commentTime\":\""+DateUtil.getInterval(businessRepairComment.getCommentTime())+"\",\"speechSound\":\""+ip+
								businessRepairComment.getComment()+"\",\"time\":\""+businessRepairComment.getVideoTime()+"\",";
						json += "\"role\":\"0\"},";
					}else{
						json += "{\"type\":\"4\",\"userId\":\""+businessRepairComment.getCommentorId()+"\",\"avatar\":\""+ip+businessRepairComment.getPortrait()+"\",\"name\":\""
								+businessRepairComment.getCommentorName()+"\",\"commentTime\":\""+DateUtil.getInterval(businessRepairComment.getCommentTime())+"\",\"content\":\""+businessRepairComment.getComment()+"\",";
						json += "\"role\":\"0\",\"evaluationGrade\":\""+businessRepairComment.getComment()+"\",\"ifTheSolution\":\""+(businessRepairComment.getContentType()-1)+"\"},";
					}
				}
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
			response.getWriter().write(JsonUtils.stringToJson(json));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户回复物业报修反馈
	 * @param userId,sessionid,content,type
	 * @return
	 * json
	 */
	@RequestMapping(value="replyPropertyRepair")
	public void replyPropertyRepair (HttpServletRequest request, HttpServletResponse response,BusinessRepairQuery query) {
		String json = "";
		Map map = (Map) request.getAttribute("resultMap");
		Map<String,String> paramMap=(Map) map.get("param");
		Map<String,String> audioMap=(Map) map.get("audio");
		try{
			int audiocount = 0;
			BusinessRepairComment businessRepairComment = new BusinessRepairComment();
			Timestamp  ts=new Timestamp(new Date().getTime());
			businessRepairComment.setRepairId(new Integer(paramMap.get("ID")));
			businessRepairComment.setCommentTime(ts);
			businessRepairComment.setTo(0);
			businessRepairComment.setCommentorId(new Integer(paramMap.get("userId")));
			businessRepairComment.setComment(paramMap.get("content"));
			if("".equals(paramMap.get("content")) || null == paramMap.get("content")  ){
				businessRepairComment.setContentType(2);
				Collection<String> coll = audioMap.keySet();
				Iterator iter = coll.iterator();
		        for (; iter.hasNext();) {
		        	audiocount++;
		        	iter.next();
		        	String value = (String)audioMap.get(audiocount+"");
					String str = value.substring(value.lastIndexOf("_")+1, value.lastIndexOf("."));
					businessRepairComment.setComment(value);
					businessRepairComment.setVideoTime(new Integer(str));
		        }
			}else{
				businessRepairComment.setContentType(1);
			}
			
			businessRepairComment.setVideoTime(1);
			businessRepairCommentService.save(businessRepairComment);
			AppLatestNews appLatestNews = new AppLatestNews();
			appLatestNews.setUserId(new Integer(paramMap.get("userId")));
			appLatestNews.setTypeId(37);//报修
			appLatestNews.setSourceId(new Integer(paramMap.get("ID")));
			appLatestNews.setTo(1);
			appLatestNews.setEstateId(0);
			appLatestNewsService.save_app(appLatestNews);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"回复成功\",";
			json += "\"content\":{";
			if(businessRepairComment.getContentType()==1){
				json += "\"type\":\"1\",";
				json += "\"commentTime\":\""+ts+"\",";
				json += "\"content\":\""+businessRepairComment.getComment()+"\",";
				json += "\"role\":\"0\"";
			}else{
				json += "\"type\":\"2\",";
				json += "\"commentTime\":\""+ts+"\",";
				json += "\"speechSound\":\""+businessRepairComment.getComment()+"\",";
				json += "\"role\":\"0\",";
				json += "\"size\":\""+businessRepairComment.getVideoTime()+"\"";
			}
			json += "}";
			json += "}";
			
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"回复失败\"";
			json += "}";
			e.printStackTrace();
		}
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(JsonUtils.stringToJson(json));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			AppStatisticsClick appStatisticsClick = new AppStatisticsClick();
			appStatisticsClick.setCreateTime(ts);
			appStatisticsClick.setEditTime(ts);
			appStatisticsClick.setUserId(new Integer(paramMap.get("userId")));
			appStatisticsClick.setType(80);
			appStatisticsClick.setTypeName("回复物业报修");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户评价物业报修接口
	 * @param userId,sessionid,content,ID,evaluationGrade,ifTheSolution
	 * @return
	 * json
	 */
	@RequestMapping(value="PropertyRepairEvaluation")
	public void PropertyRepairEvaluation (HttpServletRequest request, HttpServletResponse response,BusinessRepairQuery query) {
		String json = "";
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			BusinessRepair BusinessRepair = new BusinessRepair();
			BusinessRepair.setEditTime(ts);
			BusinessRepair.setRepairId(query.getID());
			BusinessRepair.setRepairState(query.getIfTheSolution());
			BusinessRepair.setRepairScore(query.getEvaluationGrade());
			businessRepairService.evaluation(BusinessRepair,query);
			AppLatestNews appLatestNews = new AppLatestNews();
			appLatestNews.setUserId(query.getUserId());
			appLatestNews.setTypeId(37);//报修
			appLatestNews.setSourceId(query.getID());
			appLatestNews.setTo(1);
			appLatestNews.setEstateId(0);
			appLatestNewsService.save_app(appLatestNews);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"评价成功\"";
			json += "}";
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"评价失败\"";
			json += "}";
			e.printStackTrace();
		}	
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(JsonUtils.stringToJson(json));
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
			appStatisticsClick.setType(81);
			appStatisticsClick.setTypeName("评价物业报修");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户查看物业手册
	 * @param userId,sessionid,ID
	 * @return
	 * json
	 */
	@RequestMapping(value="getPropertyManual")
	public void getPropertyManual(HttpServletRequest request, HttpServletResponse response,BusinessPropertyMaterialQuery query) {
		String json = "";
		try{
			query.setProId(query.getID());
			List<BusinessPropertyMaterial>  list = businessPropertyMaterialService.findByExample(query);
			List<BusinessUser> userList = businessUserService.findByPropertyBuildingAll(query.getBuildingId());
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp"); 
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"获取成功\",";
			json += "\"content\":{";
			if(userList==null){
				json += "\"ID\":\"\",";
				json += "\"name\":\"\",";
				json += "\"tel\":\"\",";
				json += "\"portrait\":\"\",";
				json += "\"Introduction\":\"您好：我是您的物业管家，对于您提出的任何建议，我都会认真的处理，为您提供最优的服务！您也可拨打我的电话\",";
			}else {
				json += "\"ID\":\""+userList.get(0).getUserId()+"\",";
				json += "\"name\":\""+userList.get(0).getNickname()+"\",";
				json += "\"tel\":\""+userList.get(0).getUserTel()+"\",";
				json += "\"portrait\":\""+ip+userList.get(0).getAvatar()+"\",";
				json += "\"Introduction\":\"您好：我是您的物业管家，对于您提出的任何建议，我都会认真的处理，为您提供最优的服务！您也可拨打我的电话\",";
			}
			json += "\"serviceTel\":\"85468745\",";
			json += "\"bookList\":[";
			for (BusinessPropertyMaterial businessPropertyMaterial : list) {
				json += "{\"title\":\""+businessPropertyMaterial.getMaterialName()+"\",\"image\":\""+ip+businessPropertyMaterial.getIcon()+"\",\"utl\":\""+ip+businessPropertyMaterial.getLink()+"\"},";
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
			response.getWriter().write(JsonUtils.stringToJson(json));
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
			appStatisticsClick.setType(42);
			appStatisticsClick.setTypeName("物业手册");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户获取物业服务建议列表
	 * @param userId,sessionid,type,page,rows
	 * @return
	 * json
	 */
	@RequestMapping(value="getPropertyRepairType")
	public void getPropertyRepairType (HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		try{
			List<BusinessRepairType>  list = businessRepairTypeService.findAll();
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"获取成功\",";
			json += "\"content\":{";
			json += "\"list\":[";
			for (BusinessRepairType businessRepairType : list) {
				json += "{\"typeName\":\""+businessRepairType.getTypeName()+"\",\"desc\":\""+businessRepairType.getTypeDesc()+"\",\"typeId\":\""+businessRepairType.getTypeId()+"\"},";
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
			response.getWriter().write(JsonUtils.stringToJson(json));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
