package com.community.service.express;



/**
 * 快递相关处理接口
 * 包括：
 * 
 * @author zyp-2_000
 *
 */

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
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



































import com.community.app.module.bean.AppLatestNews;
import com.community.app.module.bean.AppStatisticsClick;
import com.community.app.module.bean.AppUser;
import com.community.app.module.bean.BusinessExp;
import com.community.app.module.bean.BusinessExpFav;
import com.community.app.module.bean.BusinessExpResolve;
import com.community.app.module.bean.BusinessFeedback;
import com.community.app.module.bean.BusinessHelp;
import com.community.app.module.bean.ManageExpress;
import com.community.app.module.bean.ManageExpressFee;
import com.community.app.module.service.AppLatestNewsService;
import com.community.app.module.service.AppStatisticsClickService;
import com.community.app.module.service.BusinessAnnoService;
import com.community.app.module.service.BusinessExpFavService;
import com.community.app.module.service.BusinessExpResolveService;
import com.community.app.module.service.BusinessExpService;
import com.community.app.module.service.BusinessFeedbackService;
import com.community.app.module.service.ManageExpressFeeService;
import com.community.app.module.service.ManageExpressService;
import com.community.app.module.vo.AppLatestNewsQuery;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessBusQuery;
import com.community.app.module.vo.BusinessExpFavQuery;
import com.community.app.module.vo.BusinessExpQuery;
import com.community.app.module.vo.BusinessExpResolveQuery;
import com.community.app.module.vo.BusinessFeedbackQuery;
import com.community.app.module.vo.ManageExpressFeeQuery;
import com.community.app.module.vo.ManageExpressQuery;
import com.community.framework.utils.DateUtil;
import com.community.framework.utils.propertiesUtil;


@Controller
@RequestMapping("/service/express")
public class expressController {
	private static Logger GSLogger = LoggerFactory.getLogger(expressController.class);
	@Autowired
	private BusinessAnnoService businessAnnoService;
	@Autowired
	private BusinessFeedbackService businessFeedbackService;
	@Autowired
	private BusinessExpService businessExpService;
	@Autowired
	private ManageExpressService manageExpressService;
	@Autowired
	private ManageExpressFeeService manageExpressFeeService;
	@Autowired
	private BusinessExpFavService businessExpFavService;
	@Autowired
	private BusinessExpResolveService businessExpResolveService;
	@Autowired
	private AppLatestNewsService appLatestNewsService;
	@Autowired
	private AppStatisticsClickService appStatisticsClickService;
	
	
	
	
	/**
	 * 用户获取使用过的已发和已收的快递接口
	 * @param userId,sessionid
	 * @return
	 * json
	 */
	@RequestMapping(value="findExpressListByUser")
	public void findExpressListByUser (HttpServletRequest request, HttpServletResponse response,BusinessExpQuery query) {
		String json = "";
		try {
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp");   
			query.setRows(15);
			query.setType(10);
			query.setOrder("desc");
			query.setSort("modifyTime");
			BaseBean baseBean = businessExpService.findAllPage_app(query);
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
				BusinessExp businessExp = (BusinessExp) baseBean.getList().get(i);
				json += "{";
				json += "\"expressId\":\""+businessExp.getExpId()+"\",";
				json += "\"logo\":\""+ip+businessExp.getLogo()+"\",";
				json += "\"company\":\""+businessExp.getExpCompany()+"\",";
				json += "\"type\":\""+businessExp.getExpType()+"\",";
				json += "\"orderCode\":\""+businessExp.getExpCode()+"\",";
				if(businessExp.getExpType()==0){
					if(businessExp.getReceiveTime()==null){
						json += "\"time\":\"\"";
					}else {
						json += "\"time\":\""+DateUtil.getInterval(businessExp.getReceiveTime())+"\"";
					}
				}else{
					if(businessExp.getSendTime()==null){
						json += "\"time\":\"\"";
					}else {
						json += "\"time\":\""+DateUtil.getInterval(businessExp.getSendTime())+"\"";
					}
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
	 * 用户查看快递投诉详情
	 * @param userId,sessionid,ID
	 * @return
	 * json
	 */
	@RequestMapping(value="findExpressComplaint")
	public void findExpressComplaint (HttpServletRequest request, HttpServletResponse response) {
		//System.out.println("userId:"+request.getParameter("userId"));
		//System.out.println("sessionid:"+request.getParameter("sessionid"));
		//System.out.println("advinceId:"+request.getParameter("advinceId"));
		String json = "";
		json += "{";
		json += "\"errorCode\":\"200\",";
		json += "\"message\":\"执行成功\",";
		json += "\"content\":{";
		json += "\"ID\":\"1\",";
		json += "\"time\":\"\"200\"1-1-1 11:11:11\",";
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
			response.getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户查看快递投诉列表接口
	 * @param userId,sessionid,type,page,rows
	 * @return
	 * json
	 */
	@RequestMapping(value="findExpressSpeedListByUser")
	public void findByUser(HttpServletRequest request, HttpServletResponse response,BusinessFeedbackQuery query) {
		String json = "";
		try{
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp");   
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
			appLatestNews.setTypeId(13);
			appLatestNews.setTo(0);
			appLatestNewsService.delete_app(appLatestNews);
			if(query.getType()==3){
				appLatestNews.setTypeId(16);
			}else {
				appLatestNews.setTypeId(17);
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
					json += "\"logo\":\""+ip+businessFeedback.getLogo()+"\",";
					json += "\"company\":\""+businessFeedback.getExpCompany()+"\",";
					json += "\"type\":\""+businessFeedback.getExpType()+"\",";
					json += "\"orderCode\":\""+businessFeedback.getExpCode()+"\",";
					json += "\"state\":\""+businessFeedback.getFbState()+"\",";
					json += "\"level\":\""+businessFeedback.getFbScore()+"\"";
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
					json += "\"logo\":\""+businessFeedback.getLogo()+"\",";
					json += "\"company\":\""+businessFeedback.getExpCompany()+"\",";
					json += "\"type\":\""+businessFeedback.getExpType()+"\",";
					json += "\"orderCode\":\""+businessFeedback.getExpCode()+"\"";
					boolean  flag = false ; //管家列表状态
					for (AppLatestNews appLatestNews2 : list) {
						if(appLatestNews2.getSourceId()==businessFeedback.getFeedbackId()){
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
			appStatisticsClick.setType(71);
			appStatisticsClick.setTypeName("快递投诉列表");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户回复快递投诉
	 * @param userId,sessionid,content,type
	 * @return
	 * json
	 */
	@RequestMapping(value="replyExpressComplaint")
	public void replyExpressComplaint (HttpServletRequest request, HttpServletResponse response) {
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
			response.getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户评价快递投诉接口
	 * @param userId,sessionid,content,ID,evaluationGrade,ifTheSolution
	 * @return
	 * json
	 */
	@RequestMapping(value="publishExpressEvaluation")
	public void publishExpressEvaluation (HttpServletRequest request, HttpServletResponse response,BusinessFeedbackQuery query) {
		String json = "";
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			BusinessFeedback businessFeedback = new BusinessFeedback();
			businessFeedback.setFeedbackId(query.getID());
			businessFeedback.setFbState(query.getIfTheSolution());
			businessFeedback.setFbScore(query.getEvaluationGrade());
			businessFeedback.setEditTime(ts);
			businessFeedbackService.evaluation(businessFeedback,query);
			AppLatestNews appLatestNews = new AppLatestNews();
			appLatestNews.setUserId(query.getUserId());
			appLatestNews.setTypeId(36);
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
			appStatisticsClick.setType(67);
			appStatisticsClick.setTypeName("评价投诉建议");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * APP自动获取快递公司列表数据
	 * @param userId,sessionid
	 * @return
	 * json
	 */
	@RequestMapping(value="findListByEstate")
	public void findListByEstate (HttpServletRequest request, HttpServletResponse response,ManageExpressQuery query) {
		String json = "";
		try{
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp");   
			query.setRows(15);
			List<ManageExpress> list = manageExpressService.findByExample_app(query);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"获取成功\",";
			json += "\"content\":{";
			json += "\"recipient\":\"1\",";
			json += "\"tel\":\""+list.get(0).getStaTel()+"\",";
			json += "\"list\":[";
			for (ManageExpress manageExpress : list) {
				json += "{\"ID\":\""+manageExpress.getExpressId()+"\",\"name\":\""+manageExpress.getExpressComppay()+"\",\"pic\":\""+ip+manageExpress.getExpressIcon()+"\",\"state\":\""+manageExpress.getState()+"\"},";
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
			appStatisticsClick.setType(1);
			appStatisticsClick.setTypeName("快递服务");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户查看快递公司详情数据
	 * @param userId,sessionid,expressId
	 * @return
	 * json
	 */
	@RequestMapping(value="findExpressDetail")
	public void findExpressDetail (HttpServletRequest request, HttpServletResponse response,ManageExpressFeeQuery query) {
		String json = "";
		try{
			List<ManageExpressFee> list = manageExpressFeeService.findByExample(query);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"获取成功\",";
			json += "\"content\":{";
			json += "\"priceList\":[";
			for (ManageExpressFee ManageExpressFee : list) {
				json += "{\"areaDesc\":\""+ManageExpressFee.getTitle()+"\",\"priceDesc\":\""+ManageExpressFee.getContent()+"\"},";
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
			appStatisticsClick.setType(4);
			appStatisticsClick.setTypeName("查看运费详情");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取快递公司优惠信息数据
	 * @param userId,sessionid,stationId
	 * @return
	 * json
	 */
	@RequestMapping(value="findExpressAdByStation")
	public void findExpressAdByStation (HttpServletRequest request, HttpServletResponse response,BusinessExpFavQuery query) {
		String json = "";
		try{
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp");   
			List<BusinessExpFav> list = businessExpFavService.findByExample(query);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"获取成功\",";
			json += "\"content\":{";
			json += "\"expressAd\":\""+list.get(0).getInfo()+"\",";
			json += "\"attr\":\""+ip+list.get(0).getAddrUrl()+"\",";
			json += "\"tel\":\""+list.get(0).getStaTel()+"\"";
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
			appStatisticsClick.setType(92);
			appStatisticsClick.setTypeName("点击我要发件");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户使用发件功能
	 * @param userId,sessionid,address,isGet,getDate,isAnytime,timeGap,expressId
	 * @return
	 * json
	 */
	@RequestMapping(value="sendExpress")
	public void sendExpress (HttpServletRequest request, HttpServletResponse response,BusinessExpQuery query) {
		String json = "";
		try{
			BusinessExp businessExp = new BusinessExp();
			Timestamp  ts=new Timestamp(new Date().getTime());
			businessExp.setCreateTime(ts);
			businessExp.setModifyTime(ts);
			businessExp.setSenderId(query.getUserId());
			businessExp.setSenderName(query.getSenderName());
			businessExp.setSenderTel(query.getTel());
			businessExp.setSenderAddr(query.getAddress());
			businessExp.setExpState(0);
			businessExp.setExpType(1);
			businessExp.setStation(query.getStation());
			businessExp.setExpCompanyID(query.getExpressId());
			businessExp.setIsAnytime(query.getIsAnytime());
			businessExp.setGetTime(query.getTimeGap());
			businessExp.setIsVideo(0);
			if(query.getIsAnytime()==0){
				businessExp.setLastMessage("您预约"+query.getGetDate()+"任何时间段 服务驿站上门取件");
				businessExp.setBriefMessage(DateUtil.nowTime1()+"\\r\\n您预约"+query.getGetDate()+"任何时间段 服务驿站上门取件");
			}else{
				businessExp.setLastMessage("您预约"+query.getGetDate()+" "+query.getTimeGap()+" 服务驿站上门取件");
				businessExp.setBriefMessage(DateUtil.nowTime1()+"\\r\\n您预约"+query.getGetDate()+" "+query.getTimeGap()+" 服务驿站上门取件");
			}
			businessExpService.sendExpress(businessExp);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"保存成功\"";
			json += "}";
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"保存失败\"";
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
			appStatisticsClick.setType(93);
			appStatisticsClick.setTypeName("发件");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户发送语音快递接口
	 * @param userId,sessionid,exadId,speechSound
	 * @return
	 * json
	 */
	@RequestMapping(value="sendExpressSound")
	public void sendExpressSound (HttpServletRequest request, HttpServletResponse response,BusinessExpQuery query) {
		String json = "";
		try{
			Map map = (Map) request.getAttribute("resultMap");
			Map<String,String> param=(Map) map.get("param");
			Map<String,String> image=(Map) map.get("image");
			Map<String,String> audio=(Map) map.get("audio");
			query.setParam(param);
			query.setImage(image);
			query.setAudio(audio);
			businessExpService.sendExpressSound(query);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"保存成功\"";
			json += "}";
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"保存失败\"";
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
	 * 用户查看我的快件
	 * @param userId,sessionid,type,page
	 * @return
	 * json
	 */
	@RequestMapping(value="IExpress")
	public void IExpress (HttpServletRequest request, HttpServletResponse response,BusinessExpQuery query) {
		String json = "";
		try {
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp");   
			query.setRows(15);
			query.setSort("modifyTime");
			query.setOrder("desc");
			BaseBean baseBean = businessExpService.findAllPage_app(query);
			AppLatestNewsQuery appLatestNewsQuery = new AppLatestNewsQuery();
			appLatestNewsQuery.setUserId(query.getUserId());
			appLatestNewsQuery.setTo(0);
			appLatestNewsQuery.setTypeId(26);
			List<AppLatestNews> list = appLatestNewsService.findByExample(appLatestNewsQuery);
			BusinessExpFavQuery businessExpFavQuery = new BusinessExpFavQuery();
			businessExpFavQuery.setStationId(query.getStationId());
			List<BusinessExpFav> expFavList = businessExpFavService.findByExample(businessExpFavQuery);
			AppLatestNews appLatestNews = new AppLatestNews();
			appLatestNews.setUserId(query.getUserId());
			appLatestNews.setTo(0);
			appLatestNews.setTypeId(0);
			if(query.getType()==1){
				appLatestNews.setTypeId(21);
				appLatestNewsService.delete_app(appLatestNews);
				appLatestNews.setTypeId(22);
			}else if (query.getType()==2) {
				appLatestNews.setTypeId(23);
			}else if (query.getType()==3) {
				appLatestNews.setTypeId(24);
			}else if (query.getType()==6) {
				appLatestNews.setTypeId(21);
				appLatestNewsService.delete_app(appLatestNews);
				appLatestNews.setTypeId(24);
				appLatestNewsService.delete_app(appLatestNews);
				appLatestNews.setTypeId(22);
			}else {
				appLatestNews.setTypeId(25);
			}
			appLatestNewsService.delete_app(appLatestNews);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"获取成功\",";
			json += "\"content\":{";
			json += "\"tel\":\""+expFavList.get(0).getStaTel()+"\",";
			json += "\"PageState\":";
			if(baseBean.getCount()>query.getPage()*query.getRows()){
				json += "true,";
			}else{
				json += "false,";
			}
			json += "\"list\":[";
			if(query.getType()==1){
				for(int i=0;i<baseBean.getList().size();i++) {
					BusinessExp businessExp = (BusinessExp) baseBean.getList().get(i);
					json += "{";
					json += "\"expressId\":\""+businessExp.getExpId()+"\",";
					json += "\"logo\":\""+ip+businessExp.getLogo()+"\",";
					json += "\"company\":\""+businessExp.getExpCompany()+"\",";
					json += "\"time\":\""+ DateUtil.getInterval(businessExp.getModifyTime())+"\",";
					if(businessExp.getExpState()==1){
						json += "\"type\":\"1\",";
					}else{
						json += "\"type\":\"2\",";
					}
					json += "\"lastReply\":\""+businessExp.getLastMessage()+"\",";
					json += "\"isVideo\":\""+businessExp.getIsVideo()+"\"";
					boolean  flag = false ; //我的快递列表状态
					for (AppLatestNews appLatestNews2 : list) {
						if(appLatestNews2.getSourceId().equals(businessExp.getExpId())){
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
				
			}else if(query.getType()==2 || query.getType()==4){
				for(int i=0;i<baseBean.getList().size();i++) {
					BusinessExp businessExp = (BusinessExp) baseBean.getList().get(i);
					json += "{";
					json += "\"expressId\":\""+businessExp.getExpId()+"\",";
					json += "\"logo\":\""+ip+businessExp.getLogo()+"\",";
					json += "\"company\":\""+businessExp.getExpCompany()+"\",";
					json += "\"orderCode\":\""+businessExp.getExpCode()+"\",";
					json += "\"time\":\""+ DateUtil.getInterval(businessExp.getModifyTime())+"\"";
					boolean  flag = false ; //我的快递列表状态
					for (AppLatestNews appLatestNews2 : list) {
						if(appLatestNews2.getSourceId().equals(businessExp.getExpId())){
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
				
			}else if(query.getType()==3){
				for(int i=0;i<baseBean.getList().size();i++) {
					BusinessExp businessExp = (BusinessExp) baseBean.getList().get(i);
					json += "{";
					json += "\"expressId\":\""+businessExp.getExpId()+"\",";
					json += "\"logo\":\""+ip+businessExp.getLogo()+"\",";
					json += "\"company\":\""+businessExp.getExpCompany()+"\",";
					json += "\"orderCode\":\""+businessExp.getExpCode()+"\",";
					json += "\"time\":\""+ DateUtil.getInterval(businessExp.getModifyTime())+"\",";
					json += "\"lastReply\":\""+businessExp.getLastMessage()+"\",";
					if(businessExp.getExpState()==3){
						json += "\"type\":\"3\"";
					}else if(businessExp.getExpState()==4 || businessExp.getExpState()==5){
						json += "\"type\":\"2\"";
					}else{
						json += "\"type\":\"1\"";
					}
					boolean  flag = false ; //我的快递列表状态
					for (AppLatestNews appLatestNews2 : list) {
						if(appLatestNews2.getSourceId().equals(businessExp.getExpId())){
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
				
			}else if (query.getType()==6) {
				for(int i=0;i<baseBean.getList().size();i++) {
					BusinessExp businessExp = (BusinessExp) baseBean.getList().get(i);
					json += "{";
					json += "\"expressId\":\""+businessExp.getExpId()+"\",";
					json += "\"logo\":\""+ip+businessExp.getLogo()+"\",";
					json += "\"company\":\""+businessExp.getExpCompany()+"\",";
					json += "\"orderCode\":\""+businessExp.getExpCode()+"\",";
					json += "\"time\":\""+ DateUtil.getInterval(businessExp.getModifyTime())+"\",";
					json += "\"lastReply\":\""+businessExp.getLastMessage()+"\",";
					json += "\"expType\":\""+businessExp.getExpType()+"\",";
					json += "\"isVideo\":\""+businessExp.getIsVideo()+"\",";
					if(businessExp.getExpState()==3){
						json += "\"type\":\"3\"";
					}else if(businessExp.getExpState()==4 || businessExp.getExpState()==5){
						json += "\"type\":\"2\"";
					}else{
						json += "\"type\":\"1\"";
					}
					boolean  flag = false ; //我的快递列表状态
					for (AppLatestNews appLatestNews2 : list) {
						if(appLatestNews2.getSourceId().equals(businessExp.getExpId())){
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
			appStatisticsClick.setType(2);
			appStatisticsClick.setTypeName("快件列表");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户查看快递详情
	 * @param userId,sessionid,type,page
	 * @return
	 * json
	 */
	@RequestMapping(value="IExpressDetails")
	public void IExpressDetails (HttpServletRequest request, HttpServletResponse response,BusinessExpQuery query) {
		String json = "";
		try {
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp");   
			BusinessExp BusinessExp = businessExpService.findById_app(query.getID());
			BusinessExpResolveQuery BusinessExpResolveQuery = new BusinessExpResolveQuery();
			BusinessExpResolveQuery.setExpId(query.getID());
			BusinessExpResolveQuery.setOrder("desc");
			BusinessExpResolveQuery.setSort("resolveTime");
			BaseBean baseBean = businessExpResolveService.findAllPage_app(BusinessExpResolveQuery);
			AppLatestNews appLatestNews = new AppLatestNews();
			appLatestNews.setUserId(query.getUserId());
			appLatestNews.setTypeId(26);
			appLatestNews.setTo(0);
			appLatestNews.setSourceId(query.getID());
			appLatestNewsService.delete_app_id(appLatestNews);
			
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"获取成功\",";
			json += "\"content\":{";
			json += "\"ID\":\""+BusinessExp.getExpId()+"\",";
			json += "\"logo\":\""+ip+BusinessExp.getLogo()+"\",";
			json += "\"company\":\""+BusinessExp.getExpCompany()+"\",";
			json += "\"orderCode\":\""+BusinessExp.getExpCode()+"\",";
			if(query.getType()!=5){
				if(query.getType()==3 || query.getType()==4){
					json += "\"time\":\""+DateUtil.getTime1(new Date(BusinessExp.getCheckInTime().getTime()))+"\",";
					json += "\"payMount\":\""+BusinessExp.getPayMount()+"\",";
					json += "\"money\":\""+BusinessExp.getAgentMount()+"\",";
					json += "\"isPay\":\""+BusinessExp.getIsPay()+"\",";
					json += "\"isAgent\":\""+BusinessExp.getIsAgent()+"\",";
				}
				if(query.getType()==2){
					json += "\"receiverName\":\""+BusinessExp.getReceiverName()+"\",";
					json += "\"receiverTel\":\""+BusinessExp.getReceiverTel()+"\",";
					json += "\"receiverAddr\":\""+BusinessExp.getReceiverAddr()+"\",";
				}
				json += "\"PageState\":";
				if(baseBean.getCount()>baseBean.getPage()*baseBean.getRows()){
					json += "true,";
				}else{
					json += "false,";
				}
				json += "\"list\":[";
				for(int i=0;i<baseBean.getList().size();i++) {
					BusinessExpResolve businessExpResolve = (BusinessExpResolve) baseBean.getList().get(i);
					json += "{";
					json += "\"userId\":\""+businessExpResolve.getResolverId()+"\",";
					if ("".equals(businessExpResolve.getAvatar()) || businessExpResolve.getAvatar()==null) {
						json += "\"avatar\":\"\",";
					}else{
						json += "\"avatar\":\""+ip+businessExpResolve.getAvatar()+"\",";
					}
					
					json += "\"name\":\""+businessExpResolve.getResolverName()+"\",";
					String date = DateUtil.getTime1(new Date(businessExpResolve.getResolveTime().getTime())).replace(" ", "\\r\\n");
					json += "\"commentTime\":\""+date+"\",";
					json += "\"content\":\""+businessExpResolve.getResolveMemo()+"\",";
					json += "\"videoUrl\":\""+ip+businessExpResolve.getResolveMemo()+"\",";
					json += "\"type\":\""+businessExpResolve.getType()+"\",";
					json += "\"videoTime\":\""+businessExpResolve.getVideoTime()+"\"";
					json += "},";
					
				}
				if(baseBean.getList().size() > 0) {
					json = json.substring(0, json.length()-1);
				}
				json += "]";
			}else{
				json += "\"time\":\""+DateUtil.getTime1(new Date(BusinessExp.getCheckInTime().getTime()))+"\",";
				json += "\"content\":\""+BusinessExp.getLastMessage()+"\",";
				json += "\"payMount\":\""+BusinessExp.getPayMount()+"\",";
				json += "\"money\":\""+BusinessExp.getAgentMount()+"\",";
				json += "\"isPay\":\""+BusinessExp.getIsPay()+"\",";
				json += "\"isAgent\":\""+BusinessExp.getIsAgent()+"\"";
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
			appStatisticsClick.setType(3);
			appStatisticsClick.setTypeName("快件详情");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户获取快递单号验证码
	 * @param userId,sessionid,ID
	 * @return
	 * json
	 */
	@RequestMapping(value="getCode")
	public void getCode (HttpServletRequest request, HttpServletResponse response,BusinessExpQuery query) {
		String json = "";
		try {
			BusinessExp BusinessExp = businessExpService.findById_app(query.getID());
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"获取成功\",";
			json += "\"content\":{";
			json += "\"code\":\""+BusinessExp.getCode()+"\"";
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
			appStatisticsClick.setType(95);
			appStatisticsClick.setTypeName("查看验证码");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 取消预定快递接口
	 * @param userId,sessionid,address,isGet,getDate,isAnytime,timeGap,expressId,ID
	 * @return
	 * json
	 */
	@RequestMapping(value="updateExpress")
	public void updateExpress (HttpServletRequest request, HttpServletResponse response,BusinessExpQuery query) {
		String json = "";
		try {
			BusinessExp BusinessExp = new BusinessExp();
			Timestamp  ts=new Timestamp(new Date().getTime());
			BusinessExp.setModifyTime(ts);
			BusinessExp.setExpId(query.getID());
			if(query.getType()==1){
				BusinessExp.setExpState(8);
				businessExpService.update_app(BusinessExp);
				AppLatestNews appLatestNews = new AppLatestNews();
				appLatestNews.setUserId(query.getUserId());
				appLatestNews.setEstateId(0);
				appLatestNews.setTypeId(38);//快递
				appLatestNews.setTo(1);
				appLatestNewsService.save_app(appLatestNews);
			}else{
				BusinessExp.setExpState(3);
				businessExpService.update_Schedule(BusinessExp);
				AppLatestNews appLatestNews = new AppLatestNews();
				appLatestNews.setUserId(query.getUserId());
				appLatestNews.setTypeId(21);
				appLatestNews.setSourceId(query.getID());
				appLatestNews.setTo(0);
				appLatestNews.setEstateId(0);
				appLatestNewsService.save_app(appLatestNews);
				appLatestNews.setTypeId(24);
				appLatestNewsService.save_app(appLatestNews);
				appLatestNews.setTypeId(26);
				appLatestNewsService.save_app(appLatestNews);
				appLatestNews.setTypeId(38);//快递
				appLatestNews.setTo(1);
				appLatestNewsService.save_app(appLatestNews);
			}
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"修改成功\"";
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
			appStatisticsClick.setType(94);
			appStatisticsClick.setTypeName("取消预约");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 用户修改发送语音快递数据
	 * @param userId,sessionid,speechSounds,ID
	 * @return
	 * json
	 */
	@RequestMapping(value="updateExpressSound")
	public void updateExpressSound (HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		json += "{";
		json += "\"errorCode\":\"200\",";
		json += "\"message\":\"修改成功\"";
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
	 * 修改收件快件方式
	 * @param userId,sessionid,addressId,type
	 * @return
	 * json
	 */
	@RequestMapping(value="updateRecipient")
	public void updateRecipient (HttpServletRequest request, HttpServletResponse response,BusinessExpQuery query) {
		String json = "";
		try {
			BusinessExp exp = businessExpService.findById_app(query.getID());
			if (exp.getExpState()==3) {
				BusinessExp BusinessExp = new BusinessExp();
				BusinessExp.setExpId(query.getID());
				Timestamp  ts=new Timestamp(new Date().getTime());
				BusinessExp.setModifyTime(ts);
				BusinessExp.setIsVideo(0);
				if(query.getType()==2){
					BusinessExp.setReceiverAddr(query.getAddress());
					BusinessExp.setReceiverName(query.getSenderName());
					BusinessExp.setReceiverTel(query.getTel());
					BusinessExp.setExpState(5);
					BusinessExp.setLastMessage("您预约 服务驿站送货上门");
					BusinessExp.setBriefMessage(DateUtil.nowTime1()+"\\r\\n运单号："+query.getOrderCode()+"\\r\\n您预约 服务驿站送货上门");
				}else{
					BusinessExp.setExpState(4);
					BusinessExp.setLastMessage("您预约 去服务驿站上门自提");
					BusinessExp.setBriefMessage(DateUtil.nowTime1()+"\\r\\n运单号："+query.getOrderCode()+"\\r\\n您预约 去服务驿站上门自提");
				}
				businessExpService.update_state(BusinessExp);
				AppLatestNews appLatestNews = new AppLatestNews();
				appLatestNews.setUserId(query.getUserId());
				appLatestNews.setTypeId(21);
				appLatestNews.setSourceId(query.getID());
				appLatestNews.setTo(0);
				appLatestNews.setEstateId(0);
				appLatestNewsService.save_app(appLatestNews);
				appLatestNews.setTypeId(24);
				appLatestNewsService.save_app(appLatestNews);
				appLatestNews.setTypeId(26);
				appLatestNewsService.save_app(appLatestNews);
				appLatestNews.setTypeId(38);//快递
				appLatestNews.setTo(1);
				appLatestNewsService.save_app(appLatestNews);
				json += "{";
				json += "\"errorCode\":\"200\",";
				json += "\"message\":\"修改成功\"";
				json += "}";
			}else {
				json = "";
				json += "{";
				json += "\"errorCode\":\"400\",";
				json += "\"message\":\"快递状态已改变\"";
				json += "}";
			}
			
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
			appStatisticsClick.setType(96);
			appStatisticsClick.setTypeName("取件选择");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 修改语言收件快件方式
	 * @param userId,sessionid,speechSounds
	 * @return
	 * json
	 */
	@RequestMapping(value="updateRecipientSound")
	public void updateRecipientSound (HttpServletRequest request, HttpServletResponse response,BusinessExpQuery query) {
		String json = "";
		try {
			Map map = (Map) request.getAttribute("resultMap");
			Map<String,String> param=(Map) map.get("param");
			Map<String,String> image=(Map) map.get("image");
			Map<String,String> audio=(Map) map.get("audio");
			query.setParam(param);
			query.setImage(image);
			query.setAudio(audio);
			businessExpService.update_SpeechSound(query);
			AppLatestNews appLatestNews = new AppLatestNews();
			appLatestNews.setUserId(query.getUserId());
			appLatestNews.setTypeId(21);
			appLatestNews.setSourceId(query.getID());
			appLatestNews.setTo(0);
			appLatestNews.setEstateId(0);
			appLatestNewsService.save_app(appLatestNews);
			appLatestNews.setTypeId(24);
			appLatestNewsService.save_app(appLatestNews);
			appLatestNews.setTypeId(26);
			appLatestNewsService.save_app(appLatestNews);
			appLatestNews.setTypeId(38);//快递
			appLatestNews.setTo(1);
			appLatestNewsService.save_app(appLatestNews);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"修改成功\"";
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
}
