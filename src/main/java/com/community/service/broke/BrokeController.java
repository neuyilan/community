package com.community.service.broke;






/**
 * 爆料相关处理接口
 * 包括：
 * 用户信息
 * 
 * @author whh-2_000
 *
 */

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
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
import java.util.Map;
import com.community.app.module.vo.BaseBean;


import com.community.app.module.vo.AppLatestNewsQuery;
import com.community.app.module.vo.BusinessBreakCommentQuery;
import com.community.app.module.vo.BusinessBreakQuery;
import com.community.app.module.vo.BusinessMenuQuery;
import com.community.app.module.vo.BusinessNewsQuery;
import com.community.app.module.bean.AppLatestNews;
import com.community.app.module.bean.AppStatisticsClick;
import com.community.app.module.bean.AppUserCellphone;
import com.community.app.module.bean.BusinessActivityParticipate;
import com.community.app.module.bean.BusinessAnno;
import com.community.app.module.bean.BusinessBreak;
import com.community.app.module.bean.BusinessBreakAudio;
import com.community.app.module.bean.BusinessBreakComment;
import com.community.app.module.bean.BusinessMenu;
import com.community.app.module.bean.BusinessNews;
import com.community.app.module.service.AppLatestNewsService;
import com.community.app.module.service.AppStatisticsClickService;
import com.community.app.module.service.AppUserNewsService;
import com.community.app.module.service.BusinessAnnoService;
import com.community.app.module.service.BusinessBreakCommentService;
import com.community.app.module.service.BusinessBreakService;
import com.community.app.module.service.BusinessMenuService;
import com.community.app.module.service.BusinessNewsService;
import com.community.app.module.vo.BusinessAnnoQuery;
import com.community.framework.utils.DateUtil;
import com.community.framework.utils.Uploader;
import com.community.framework.utils.propertiesUtil;


@Controller
@RequestMapping("/service/broke")
public class BrokeController {
	private static Logger GSLogger = LoggerFactory.getLogger(BrokeController.class);
	@Autowired
	private BusinessAnnoService businessAnnoService;
	
	@Autowired
	private BusinessBreakService businessBreakService;
	
	@Autowired
	private BusinessNewsService businessNewsService;
	
	@Autowired
	private BusinessBreakCommentService businessBreakCommentService;
	
	
	@Autowired
	private AppUserNewsService appUserNewsService;
	@Autowired
	private AppLatestNewsService appLatestNewsService;
	@Autowired
	private AppStatisticsClickService appStatisticsClickService;
	
	
	/**
	 * 用户发布我的爆料
	 * @param userId,content,speechSounds,pics
	 * @return
	 * json
	 */
	@RequestMapping(value="publishBroke")
	public void publishBroke(HttpServletRequest request, HttpServletResponse response,BusinessBreakQuery query) {
		String json = "";
		Map map = (Map) request.getAttribute("resultMap");
		Map<String,String> paramMap=(Map) map.get("param");
		Map<String,String> imageMap=(Map) map.get("image");
		Map<String,String> audioMap=(Map) map.get("audio");
		try{
			BusinessBreak businessBreak = new BusinessBreak();
			Timestamp  ts=new Timestamp(new Date().getTime());
			businessBreak.setBreakerId(new Integer(paramMap.get("userId")));
			businessBreak.setEditTime(ts);
			businessBreak.setCreateTime(ts);
			businessBreak.setBreakContent(paramMap.get("content"));
			businessBreak.setBreakTime(ts);
			businessBreak.setComId(paramMap.get("comId"));
			businessBreak.setLastCommentTime(ts);
			businessBreak.setEstateId(query.getEstateId());
			businessBreak.setIsNickname(new Integer(paramMap.get("isNickname")));
			businessBreakService.publishBroke(businessBreak,imageMap,audioMap);
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
			appStatisticsClick.setUserId(new Integer(paramMap.get("userId")));
			appStatisticsClick.setType(59);
			appStatisticsClick.setTypeName("发布爆料");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户查看我的爆料
	 * @param userId,sessionid,type,page,rows
	 * @return
	 * json
	 */
	@RequestMapping(value="findByUser")
	public void findByUser(HttpServletRequest request, HttpServletResponse response,BusinessBreakQuery query) {
		String json = "";
		Properties p = propertiesUtil.getProperties("config.properties");
		String ip = p.getProperty("imageIp");   
		if("1".equals(request.getParameter("type"))){
			try{
				query.setRows(15);
				query.setOrder("desc");
				query.setSort("editTime");
				BaseBean baseBean = businessBreakService.getByUserId(query);
				AppLatestNewsQuery appLatestNewsQuery = new AppLatestNewsQuery();
				appLatestNewsQuery.setUserId(query.getUserId());
				appLatestNewsQuery.setTo(0);
				appLatestNewsQuery.setTypeId(1);
				List<AppLatestNews> list = appLatestNewsService.findByExample(appLatestNewsQuery);
				AppLatestNews appLatestNews = new AppLatestNews();
				appLatestNews.setUserId(query.getUserId());
				appLatestNews.setTypeId(0);
				appLatestNews.setTo(0);
				appLatestNewsService.delete_app(appLatestNews);
				appLatestNews.setTypeId(33);
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
					BusinessBreakQuery businessBreak = (BusinessBreakQuery) baseBean.getList().get(i);
					json += "{\"brokeId\":\""+businessBreak.getBreakId()+"\",\"time\":\""+DateUtil.getInterval(businessBreak.getCreateTime())+"\",\"brief\":\""
					+businessBreak.getBreakContent()+"\",\"pic\":\"";
					if(businessBreak.getPicUrl()!=null){
						String[] pic = businessBreak.getPicUrl().split(",");
						json += ip+pic[0];
					}
					if("".equals(businessBreak.getBreakContent())){
						json += "\",\"type\":\"1";
					}else {
						json += "\",\"type\":\"0";
					}
					boolean  flag = false ; //爆料列表状态
					for (AppLatestNews appLatestNews2 : list) {
						if(appLatestNews2.getSourceId().equals(businessBreak.getBreakId())){
							flag = true;
						}
					}
					if (flag) {
						json += "\",\"status\":true";
					}else {
						json += "\",\"status\":false";
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
		}else if("2".equals(request.getParameter("type"))){
			try{
				BusinessNewsQuery businessNewsQuery = new BusinessNewsQuery();
				businessNewsQuery.setRows(15);
				businessNewsQuery.setPublisherId(query.getUserId());
				businessNewsQuery.setState(0);
				businessNewsQuery.setNewsType(1);
				businessNewsQuery.setPage(query.getPage());
				businessNewsQuery.setOrder("desc");
				businessNewsQuery.setSort("publishTime");
				BaseBean baseBean = businessNewsService.findAllPage_app(businessNewsQuery);
				AppLatestNewsQuery appLatestNewsQuery = new AppLatestNewsQuery();
				appLatestNewsQuery.setUserId(query.getUserId());
				appLatestNewsQuery.setTo(0);
				appLatestNewsQuery.setTypeId(35);
				List<AppLatestNews> list = appLatestNewsService.findByExample(appLatestNewsQuery);
				AppLatestNews appLatestNews = new AppLatestNews();
				appLatestNews.setUserId(query.getUserId());
				appLatestNews.setTypeId(0);
				appLatestNews.setTo(0);
				appLatestNewsService.delete_app(appLatestNews);
				appLatestNews.setTypeId(34);
				appLatestNewsService.delete_app(appLatestNews);
				json += "{";
				json += "\"errorCode\":\"200\",";
				json += "\"message\":\"获取成功\",";
				json += "\"content\":{";
				
				json += "\"PageState\":";
				if(baseBean.getCount()>baseBean.getPage()*query.getRows()){
					json += "true,";
				}else{
					json += "false,";
				}
				json += "\"list\":[";
				for(int i=0;i<baseBean.getList().size();i++) {
					BusinessNews businessNews = (BusinessNews) baseBean.getList().get(i);
					json += "{\"ID\":\""+businessNews.getNewsId()+"\",\"title\":\""+businessNews.getTitle()+"\",\"time\":\""
					+DateUtil.getInterval(businessNews.getPublishTime())+"\",\"brief\":\""+businessNews.getBrief()+"\",";
					if("".equals(businessNews.getSubjectPic()) || businessNews.getSubjectPic()==null || businessNews.getSubjectPic().indexOf("/images/icon/")>=0){
						json +="\"pic\":\"\",";
					}else{
						json +="\"pic\":\""+ip+businessNews.getSubjectPic()+"\",";
					}
					json += "\"publisherId\":\""+businessNews.getPublisherId()+"\",\"publisherName\":\""+businessNews.getNickname()+"\",\"avatar\":\""+ip+businessNews.getPortrait()+"\","
									+ "\"url\":\""+ip+"/community/service/commiunity/getJournalismDetailsById.json?ID="+businessNews.getNewsId()+"\"";
					boolean  flag = false ; //爆料列表状态
					for (AppLatestNews appLatestNews2 : list) {
						if(appLatestNews2.getSourceId().equals(businessNews.getNewsId())){
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
			
		}
//		json += "{";
//		json += "\"errorCode\":\"200\",";
//		json += "\"message\":\"获取成功\",";
//		json += "\"content\":{";
//		json += "\"PageState\":true,";
//		if("1".equals(request.getParameter("type"))){
//			json += "\"unselected\":[";
//			json += "{\"brokeId\":\"1\",\"title\":\"标题啊\",\"time\":\"2001-1-1 16:11:11\",\"brief\":\"简介\",\"pic\":\"图片\"},";
//			json += "{\"brokeId\":\"2\",\"title\":\"标题啊\",\"time\":\"\"200\"1-1-1 16:11:11\",\"brief\":\"简介\",\"pic\":\"图片\"}";
//			json += "]";
//		}else if("2".equals(request.getParameter("type"))){
//			json += "\"selected\":[";
//			json += "{\"brokeId\":\"1\",\"title\":\"标题啊\",\"time\":\"2001-1-1 16:11:11\",\"brief\":\"简介\",\"pic\":\"图片\"},";
//			json += "{\"brokeId\":\"2\",\"title\":\"标题啊\",\"time\":\"2001-1-1 16:11:11\",\"brief\":\"简介\",\"pic\":\"图片\"}";
//			json += "]";
//		}
//		json += "}";
//		json += "}";
		
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
			appStatisticsClick.setType(57);
			appStatisticsClick.setTypeName("我的爆料列表");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户查看爆料详情
	 * @param userId,brokeId,sessionid
	 * @return
	 * json
	 */
	@RequestMapping(value="getBrokeById")
	public void getBrokeById(HttpServletRequest request, HttpServletResponse response,BusinessBreakCommentQuery query) {
		String json = "";
		try{
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp");   
			query.setRows(15);
			query.setBreakId(query.getBrokeId());
			query.setOrder("desc");
			query.setSort("commentTime");
			BusinessBreak businessBreak = businessBreakService.findById_app(query.getBrokeId());
			BaseBean baseBean = businessBreakCommentService.findAllPage_app(query);
			AppLatestNews appLatestNews = new AppLatestNews();
			appLatestNews.setUserId(query.getUserId());
			appLatestNews.setTypeId(1);
			appLatestNews.setTo(0);
			appLatestNews.setSourceId(query.getBrokeId());
			appLatestNewsService.delete_app_id(appLatestNews);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"获取成功\",";
			json += "\"content\":{";
			if(query.getPage()==1){
				json += "\"ID\":\""+businessBreak.getBreakId()+"\",";
				json += "\"time\":\""+DateUtil.getInterval(businessBreak.getCreateTime())+"\",";
				json += "\"content\":\""+businessBreak.getBreakContent()+"\",";
				json += "\"pics\":[";
				if(businessBreak.getPics()!=null){
					String[] pic = businessBreak.getPics().split(",");
					for (int i = 0; i < pic.length; i++) {
						json += "{\"pic\":\""+ip+pic[i]+"\"},";
					}
					if(pic.length > 0) {
						json = json.substring(0, json.length()-1);
					}
				}
				json += "],";
				json += "\"speechSounds\":[";
				if(businessBreak.getAudios()!=null && businessBreak.getTime()!=null){
					String[] audios = businessBreak.getAudios().split(",");
					String[] time = businessBreak.getTime().split(",");
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
				BusinessBreakComment businessBreakComment = (BusinessBreakComment) baseBean.getList().get(i);
				if(businessBreakComment.getTo()==1){
					json += "{\"type\":\"1\",\"userId\":\""+businessBreakComment.getCommentorId()+"\",\"avatar\":\""+ip+businessBreakComment.getB_portrait()+"\",\"name\":\""
							+businessBreakComment.getB_nickname()+"\",\"commentTime\":\""+DateUtil.getInterval(businessBreakComment.getCommentTime())+"\",\"content\":\""+businessBreakComment.getContent()+"\",";
					json += "\"role\":\"1\"},";
				}else if(businessBreakComment.getContentType()==1){
					json += "{\"type\":\"1\",\"userId\":\""+businessBreakComment.getCommentorId()+"\",\"avatar\":\""+ip+businessBreakComment.getPortrait()+"\",\"name\":\""
							+businessBreakComment.getNickname()+"\",\"commentTime\":\""+DateUtil.getInterval(businessBreakComment.getCommentTime())+"\",\"content\":\""+businessBreakComment.getContent()+"\",";
					json += "\"role\":\"0\"},";
				}else{
					json += "{\"type\":\"2\",\"userId\":\""+businessBreakComment.getCommentorId()+"\",\"name\":\""
							+businessBreakComment.getNickname()+"\",\"commentTime\":\""+DateUtil.getInterval(businessBreakComment.getCommentTime())+"\",\"speechSound\":\""+ip+
							businessBreakComment.getContent()+"\",\"time\":\""+businessBreakComment.getVideoTime()+"\",";
						json += "\"role\":\"0\"},";
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
			appStatisticsClick.setType(58);
			appStatisticsClick.setTypeName("我的爆料详情");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户回复我的爆料
	 * @param userId,content,speechSounds,pics
	 * @return
	 * json
	 */
	@RequestMapping(value="replyBroke")
	public void replyBroke(HttpServletRequest request, HttpServletResponse response,BusinessBreakQuery query) {
		String json = "";
		Map map = (Map) request.getAttribute("resultMap");
		Map<String,String> paramMap=(Map) map.get("param");
		Map<String,String> audioMap=(Map) map.get("audio");
		try{
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp");   
			BusinessBreakComment businessBreakComment = new BusinessBreakComment();
			Timestamp  ts=new Timestamp(new Date().getTime());
			businessBreakComment.setBreakId(new Integer(paramMap.get("ID")));
			businessBreakComment.setCommentTime(ts);
			businessBreakComment.setTo(0);
			businessBreakComment.setCommentorId(new Integer(paramMap.get("userId")));
			businessBreakComment.setContent(paramMap.get("content"));
			int type = 1;
			if("".equals(paramMap.get("content")) || null == paramMap.get("content")  ){
				type = 2;
				businessBreakComment.setContentType(2);
				Collection<String> coll = audioMap.keySet();
				Iterator iter = coll.iterator();
				int audiocount = 0;
		        for (; iter.hasNext();) {
		        	audiocount++;
		        	iter.next();
		        	String value = (String)audioMap.get(audiocount+"");
					String str = value.substring(value.lastIndexOf("_")+1, value.lastIndexOf("."));
					businessBreakComment.setContent(value);
					businessBreakComment.setVideoTime(new Integer(str));
		        }
			}else{
				businessBreakComment.setContentType(1);
			}
			businessBreakCommentService.save(businessBreakComment);
			AppLatestNews appLatestNews = new AppLatestNews();
			appLatestNews.setUserId(query.getUserId());
			appLatestNews.setTypeId(40);//爆料
			appLatestNews.setSourceId(query.getID());
			appLatestNews.setTo(1);
			appLatestNews.setEstateId(0);
			appLatestNewsService.save_app(appLatestNews);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"回复成功\",";
			json += "\"content\":{";
			if(type==1){
				json += "\"type\":\"1\",";
				json += "\"commentTime\":\""+DateUtil.getInterval(ts)+"\",";
				json += "\"content\":\""+businessBreakComment.getContent()+"\",";
				json += "\"role\":\"0\"";
			}else{
				json += "\"type\":\"2\",";
				json += "\"commentTime\":\""+DateUtil.getInterval(ts)+"\",";
				json += "\"speechSound\":\""+ip+businessBreakComment.getContent()+"\",";
				json += "\"role\":\"0\",";
				json += "\"time\":\""+businessBreakComment.getVideoTime()+"\"";
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
			appStatisticsClick.setUserId(new Integer(paramMap.get("userId")));
			appStatisticsClick.setType(60);
			appStatisticsClick.setTypeName("回复爆料");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
